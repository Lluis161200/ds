import java.util.ArrayList;
import java.util.List;

public class Serie {
    private List<Resistor> resistors = new ArrayList<>();
    private String name;
    private double precision;
    private double[] values = null;
    private static final double[] PowerFactors = {1., 10., 100., 1000., 1.0e+04, 1.0e+05, 1.0e+06};
    // why static ? why final
    public List getResistors() { return resistors; }
    public String getName() { return name; }
    public double getPrecision() { return precision; }
    public Serie(String name, double[] values, double precision) {
        this.name = name;
        this.values = values;
        this.precision = precision;
        makeResistors();
        //System.out.println(getResistors());
        //printResistor();

        //for (int i=0;i<resistors.size();i++) {
        //    System.out.println(resistors.get(i));
       // }

    }


    @Override
    public String toString() {
        String res = "Series " + name + "\nNormalized values ";
        for (int i=0; i<values.length; i++) { res += values[i] + ", "; }
        res += "\nPrecision " + precision;
        return res;
    }
    private void makeResistors() { /* TODO */
        for (int j=0; j<values.length;j++){
            for(int i=0; i<PowerFactors.length;i++){
                resistors.add(new Resistor(values[j]*PowerFactors[i],this));
            }
        }
    }
      


}
