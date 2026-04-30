package visitor;

import composites.Literal;
import composites.Product;
import composites.Sum;

public abstract class FormulaVisitor {
    public abstract Object visitLiteral(Literal literal);

    public abstract Object visitSum(Sum sum);

    public abstract Object visitProduct(Product product);
}
