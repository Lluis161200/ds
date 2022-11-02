public class Constant implements Expression{

    double value;

    public Constant(double value){
        this.value=value;
    }
    @Override
    public DualNumber evaluate(DualNumber dn) {
        return dn;
    }
}
