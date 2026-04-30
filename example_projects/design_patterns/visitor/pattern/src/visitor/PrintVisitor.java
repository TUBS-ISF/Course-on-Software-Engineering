package visitor;

import composites.FormulaComponent;
import composites.Literal;
import composites.Product;
import composites.Sum;

public class PrintVisitor extends FormulaVisitor {

    @Override
    public String visitLiteral(Literal literal) {
        return Integer.toString(literal.value);
    }

    @Override
    public String visitSum(Sum sum) {
        String print = "+(";
        for (FormulaComponent child : sum.getChildren()) {
            print += (String) child.accept(this) + ",";
        }
        print = print.substring(0, print.length() - 1) + ")";
        return print;
    }

    @Override
    public String visitProduct(Product product) {
        String print = "*(";
        for (FormulaComponent child : product.getChildren()) {
            print += (String) child.accept(this) + ",";
        }
        print = print.substring(0, print.length() - 1) + ")";
        return print;
    }

}