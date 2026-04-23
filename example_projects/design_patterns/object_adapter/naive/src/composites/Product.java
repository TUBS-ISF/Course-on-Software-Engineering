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
    
}
