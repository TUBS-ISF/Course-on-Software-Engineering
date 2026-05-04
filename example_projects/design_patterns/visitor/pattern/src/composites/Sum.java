package composites;

import visitor.FormulaVisitor;

public class Sum extends FormulaComponent {

    FormulaComponent[] children;

    public Sum(FormulaComponent... children) {
        this.children = children;
    }

    @Override
    public FormulaComponent[] getChildren() {
        return children;
    }

    @Override
    public Object accept(FormulaVisitor visitor) {
        return visitor.visitSum(this);
    }
    
}
