public abstract class BinaryOperator implements Expression{
    protected Expression left;
    protected Expression right;

    public BinaryOperator(Expression ex1, Expression ex2){
        left=ex1;
        right=ex2;
    }
    public DualNumber evaluate(DualNumber dn){
        return dn;
    }
}