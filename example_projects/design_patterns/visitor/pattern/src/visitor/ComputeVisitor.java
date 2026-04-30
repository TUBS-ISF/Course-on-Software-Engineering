package visitor;

import composites.FormulaComponent;
import composites.Literal;
import composites.Product;
import composites.Sum;

public class ComputeVisitor extends FormulaVisitor {

    @Override
    public Integer visitLiteral(Literal literal) {
        return literal.value;
    }

    @Override
    public Integer visitSum(Sum sum) {
        int result = 0;
        for (FormulaComponent child : sum.getChildren()) {
            result += (Integer) child.accept(this);
        }
        return result;
    }

    @Override
    public Integer visitProduct(Product product) {
        int result = 1;
        for (FormulaComponent child : product.getChildren()) {
            result = result * (Integer) child.accept(this);
        }
        return result;
    }
    
}
