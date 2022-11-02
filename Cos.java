public class Cos implements Expression{
    Expression expr;

    public Cos(Expression expr){
        this.expr=expr;
    }
    @Override
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = expr.evaluate(dn);
        return new DualNumber(Math.cos(dn1.u), -dn1.uprime * Math.sin(dn1.u));
    }
}
