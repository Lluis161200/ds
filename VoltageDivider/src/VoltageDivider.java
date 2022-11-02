import java.util.Comparator;
public class VoltageDivider {
    private Resistor resistor1 = null;
    private Resistor resistor2 = null;
    private double coincidence;
    // TODO: three corresponding getters
    public VoltageDivider(Resistor r1, Resistor r2, double coincidence) {
        resistor1 = r1;
        resistor2 = r2;
        this.coincidence = coincidence;

    }
    @Override
    public String toString() {
        return resistor1 + ", " + resistor2 + "\nvoltage division "
                + resistor2.getResistance() / (resistor1.getResistance()
                + resistor2.getResistance())
                + "\ncoincidence " + coincidence + "\n";
    }

    //coinciance sorted
    public static Comparator<VoltageDivider> VoltageDividerComparator = new Comparator<VoltageDivider>() {
        @Override
        public int compare(VoltageDivider o1, VoltageDivider o2) {
            double coincidence1 = o1.coincidence;
            double coincidence2 = o2.coincidence;
            double difference= coincidence2-coincidence1;
            if(difference > 0) return 1;
            if(difference < 0) return -1;
            return 0;
        }

    };

}
