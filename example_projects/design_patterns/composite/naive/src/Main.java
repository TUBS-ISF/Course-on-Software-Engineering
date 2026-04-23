import composites.Literal;
import composites.Product;
import composites.Sum;

public class Main {
    public static void main(String[] args) {
        Sum formulaRoot = new Sum(new Product(new Literal(3), new Literal(5)), new Literal(10));
        System.out.println(formulaRoot.compute());
    }
}
