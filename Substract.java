public class Substract extends BinaryOperator{
    public Substract(Expression ex1, Expression ex2) {
        super(ex1, ex2);
    }
    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = left.evaluate(dn);
        DualNumber dn2 = right.evaluate(dn);
        return new DualNumber(dn1.u+dn2.u, dn1.uprime+dn2.uprime);
    }
}
