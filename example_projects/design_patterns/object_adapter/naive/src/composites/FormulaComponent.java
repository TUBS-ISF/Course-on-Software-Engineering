package composites;

public abstract class FormulaComponent {
    public abstract int compute();
    public abstract FormulaComponent[] getChildren();
}
