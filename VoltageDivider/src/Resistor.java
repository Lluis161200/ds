public class Resistor {
    private double resistance;
    private Serie series = null;
    public double getResistance() { return resistance; }
    public Serie getSeries() { return series; }
    public Resistor(double resistance, Serie series) {
        this.resistance=resistance;
        this.series=series;
    }


    @Override
    public String toString() {
        return "Resistance " + resistance + ", series " + series.getName()
                + ", precision " + series.getPrecision();
    }
// to print a Resistor with System.out.println

}
