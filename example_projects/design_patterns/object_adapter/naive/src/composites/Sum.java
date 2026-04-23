package composites;

public class Sum extends FormulaComponent {

    FormulaComponent[] children;

    public Sum(FormulaComponent... children) {
        this.children = children;
    }

    @Override
    public int compute() {
        int sum = 0;
        for (FormulaComponent element : getChildren()) {
            sum += element.compute();
        }
        return sum;
    }

    @Override
    public FormulaComponent[] getChildren() {
        return children;
    }
    
}
