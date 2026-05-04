package composites;

public class Product extends FormulaComponent {

    FormulaComponent[] children;

    public Product(FormulaComponent... children) {
        this.children = children;
    }

    @Override
    public int compute() {
        int product = 1;
        for (FormulaComponent component : getChildren()) {
            product = product * component.compute();
        }
        return product;
    }

    @Override
    public FormulaComponent[] getChildren() {
        return children;
    }

    @Override
    public String print() {
        String print = "*(";
        for (FormulaComponent child : getChildren()) {
            print += (String) child.print() + ",";
        }
        print = print.substring(0, print.length() - 1) + ")";
        return print;
    }
    
}
