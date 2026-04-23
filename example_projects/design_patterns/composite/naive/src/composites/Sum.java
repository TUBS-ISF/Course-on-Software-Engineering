package composites;

public class Sum {

    Object[] children;

    public Sum(Object... children) {
        this.children = children;
    }

    public int compute() {
        int sum = 1;
        for (Object element : getChildren()) {
            if (element instanceof Product) {
                sum = sum + ((Product) element).compute();
            } else if (element instanceof Sum) {
                sum = sum + ((Sum) element).compute();
            } else if (element instanceof Literal) {
                sum = sum + ((Literal) element).value;
            }
        }
        return sum;
    }

    public Object[] getChildren() {
        return children;
    }
    
}
