#! /bin/bash
# Usage
#   ./compile_braunschweig.sh -options <nr>
# where options is a string consisting of the characters l, o
#   l = lecture
#   o = overview
# and <nr> is the number of the lecture you want to compile.
# The output will be written to the value stored in "slide_path" below.
# Example, to compile the lecture 3 and also prepare the overview slides (i.e., a big pdf containing lectures 1-3), you can run
#   ./compile_braunschweig.sh -lo 3
# Important: Run this script from the directory the script is in. Otherwise paths for output pdfs might be wrong.

## Colors for pretty printing in console output
RED='\033[0;31m'
GREEN='\033[0;32m'
NOCOLOR='\033[0m'

university=tubs
semester=2025s
lecture_short_name=se2

template_path="../se1/template/"
archive_path="../../SE2-Slide-Archive/"

build_tex () {
    parameters='pdflatex %O -interaction=batchmode -synctex=1 -halt-on-error "\def\ismake{}\def\university{'
    parameters+="${university}"
    parameters+='}'
    parameters+="$2"
    parameters+='\input{%S}"'
    if latexmk -pdf -pdflatex="${parameters}" "$1.tex" > /dev/null 2>&1 ; then
        echo -e "${GREEN}OK${NOCOLOR}"
    else
        echo -e "${RED}fail${NOCOLOR}" >&2
        cat "$1.log" | grep -E "^[!]"
        exit 1
    fi
    latexmk -c "$1.tex" > /dev/null 2>&1
    rm -rf "$1.fls" "$1.nav" "$1.snm" "$1.listing" "$1.vrb"
}

make_lecture () {
    # Remove all generated files
    latexmk -quiet -silent -C ${TEXFILE} > /dev/null 2>&1

    # Build pdfs with handout and darkmode
    echo -e -n "${GREEN}Building animated pdf...${NOCOLOR}"
    build_tex "${lecture}" ""
    mv -f "${lecture}.pdf" "${outpath}animated/${lecture}.pdf"

    echo -e -n "${GREEN}Building handout pdf...${NOCOLOR}"
    build_tex "${lecture}" "\def\ishandout{}"
    mv -f "${lecture}.pdf" "${outpath}${lecture}.pdf"

    echo -e -n "${GREEN}Building handout darkmode pdf...${NOCOLOR}"
    build_tex "${lecture}" "\def\ishandout{}\def\isdarkmode{}"
    mv -f "${lecture}.pdf" "${outpath}${lecture}-dark.pdf"
}

make_overview () {
    cur_lectures=$(printf ",%s" "${lecture_names[@]:0:$lecture_number}")
    cur_lectures=${cur_lectures:1}

    # Remove old generated tex file
    latexmk -quiet -silent -C ${lecture_short_name}.tex > /dev/null 2>&1
    rm ${lecture_short_name}.tex

    # Generate new tex file for the overview
    content="\input{${template_path}lecture_header.tex}\includeonlylecture{$cur_lectures}\input{${template_path}lecture_body.tex}"
    echo "${content}" > ${lecture_short_name}.tex

    echo -e -n "${GREEN}Building overview...${NOCOLOR}"
    build_tex "${lecture_short_name}" "\def\ishandout{}"

    # Compress pdf
    gs -sDEVICE=pdfwrite -dCompatibilityLevel=1.4 -dPDFSETTINGS=/prepress -dNOPAUSE -dQUIET -dBATCH -sOutputFile="${outpath}${lecture_short_name}.pdf" ${lecture_short_name}.pdf
    # Move uncompressed pdf
    mv -f ${lecture_short_name}.pdf "${outpath}${lecture_short_name}_uncompressed.pdf"

    echo -e -n "${GREEN}Building darkmode overview...${NOCOLOR}"
    build_tex "${lecture_short_name}" "\def\ishandout{}\def\isdarkmode{}"
    #mv -f "${lecture}.pdf" "${outpath}${lecture}-dark.pdf"

    # Compress pdf
    gs -sDEVICE=pdfwrite -dCompatibilityLevel=1.4 -dPDFSETTINGS=/prepress -dNOPAUSE -dQUIET -dBATCH -sOutputFile="${outpath}${lecture_short_name}-dark.pdf" ${lecture_short_name}.pdf
    # Move uncompressed pdf
    mv -f ${lecture_short_name}.pdf "${outpath}${lecture_short_name}-dark_uncompressed.pdf"

    rm ${lecture_short_name}.tex
}

is_make_lecture=0
is_make_overview=0
while getopts "lo" opt
do
    case $opt in
    (l) is_make_lecture=1 ;;
    (o) is_make_overview=1 ;;
    (*) echo "Illegal option $opt" && exit 1 ;;
    esac
done

shift $(($OPTIND - 1))
lecture_number=$1

readarray -d '' file_names < <(find . -type f -print0)
file_names=($(printf "%s\n" "${file_names[@]}" | sort))
lecture_names=()
for file_name in "${file_names[@]}"; do
    if [[ "$file_name" =~ \./[0-1][0-9]-([a-zA-Z_-]+)\.tex ]]; then
        lecture_names+=("${BASH_REMATCH[1]}")
    fi
done

# Return if first argument is not a positive integer
number_re='^[0-9]+$'
if ! [[ ${lecture_number} =~ ${number_re} ]] ; then
    echo "ERROR: ${lecture_number} is not a valid integer";
    exit 1
fi

lecture_index=$((lecture_number-1))
lecture_number_formated=$(printf "%02d" ${lecture_number})
lecture=$lecture_number_formated-${lecture_names[$lecture_index]}

# Return if tex file does not exist
TEXFILE=${lecture}.tex
if test -f "${TEXFILE}"; then
    echo $lecture
else
    echo "ERROR: ${TEXFILE} does not exist!"
    exit 1
fi

if [ "$#" -ge 2 ]; then
    university=$2
    echo "Using university ${university}"
fi

outpath="${archive_path}${semester}-${university}/"
mkdir -p "${outpath}animated/"

if test ${is_make_lecture} -gt 0 ; then make_lecture ; fi
if test ${is_make_overview} -gt 0 ; then make_overview ; fi
