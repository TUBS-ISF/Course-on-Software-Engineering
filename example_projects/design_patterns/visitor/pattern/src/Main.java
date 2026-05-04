import composites.FormulaComponent;
import composites.Literal;
import composites.Product;
import composites.Sum;
import visitor.ComputeVisitor;
import visitor.PrintVisitor;

public class Main {
    public static void main(String[] args) {
        FormulaComponent formulaRoot = new Sum(new Product(new Literal(3), new Literal(5)), new Literal(10));
        ComputeVisitor computer = new ComputeVisitor();
        PrintVisitor printer = new PrintVisitor();

        System.out.println(formulaRoot.accept(computer));
        System.out.println(formulaRoot.accept(printer));
    }
}
