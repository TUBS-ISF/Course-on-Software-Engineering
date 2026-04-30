package composites;

import visitor.FormulaVisitor;

public abstract class FormulaComponent {
    public abstract FormulaComponent[] getChildren();
    public abstract Object accept(FormulaVisitor visitor);
}
