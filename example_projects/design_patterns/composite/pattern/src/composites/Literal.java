package composites;

public class Literal extends FormulaComponent {

    int value;

    public Literal(int value) {
        this.value = value;
    }

    @Override
    public int compute() {
        return value;
    }

    @Override
    public FormulaComponent[] getChildren() {
        return new FormulaComponent[0];
    }
    
}
