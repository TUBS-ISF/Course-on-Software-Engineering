package composites;

import visitor.FormulaVisitor;

public class Literal extends FormulaComponent {

    public int value;

    public Literal(int value) {
        this.value = value;
    }

    @Override
    public FormulaComponent[] getChildren() {
        return new FormulaComponent[0];
    }

    @Override
    public Object accept(FormulaVisitor visitor) {
        return visitor.visitLiteral(this);
    }
    
}
