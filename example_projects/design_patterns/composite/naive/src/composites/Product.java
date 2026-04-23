package composites;

public class Product {

    Object[] children;

    public Product(Object... children) {
        this.children = children;
    }

    public int compute() {
        int product = 1;
        for (Object element : getChildren()) {
            if (element instanceof Product) {
                product = product * ((Product) element).compute();
            } else if (element instanceof Sum) {
                product = product * ((Sum) element).compute();
            } else if (element instanceof Literal) {
                product = product * ((Literal) element).value;
            }
        }
        return product;
    }

    public Object[] getChildren() {
        return children;
    }
    
}
