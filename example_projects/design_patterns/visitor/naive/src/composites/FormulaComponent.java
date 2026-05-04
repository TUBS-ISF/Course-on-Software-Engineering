package composites;

public abstract class FormulaComponent {
    public abstract int compute();
    public abstract String print();
    public abstract FormulaComponent[] getChildren();
}
