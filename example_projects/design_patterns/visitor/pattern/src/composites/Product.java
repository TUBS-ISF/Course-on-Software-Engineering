package composites;

import visitor.FormulaVisitor;

public class Product extends FormulaComponent {

    FormulaComponent[] children;

    public Product(FormulaComponent... children) {
        this.children = children;
    }

    @Override
    public FormulaComponent[] getChildren() {
        return children;
    }

    @Override
    public Object accept(FormulaVisitor visitor) {
        return visitor.visitProduct(this);
    }
    
}
