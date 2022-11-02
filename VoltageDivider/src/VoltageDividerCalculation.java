import java.util.ArrayList;
import java.util.List;

public class VoltageDividerCalculation {

    public static List<VoltageDivider> calculate(double voltageDivision, double coincidence, Serie series) {
        List<Resistor> allResistors = series.getResistors();
        double r1r2VoltageDivision;
        double r1r2Coincidence = 0;
        List<VoltageDivider> result = new ArrayList<>();

        for (Resistor r1 : allResistors) {

            for (Resistor r2 : allResistors) {
                r1r2VoltageDivision = r2.getResistance() / (r1.getResistance() + r2.getResistance());
                r1r2Coincidence = (r1r2VoltageDivision / voltageDivision) * 100;
                if (r1r2Coincidence > 100) {
                    r1r2Coincidence = r1r2Coincidence - 100;
                    r1r2Coincidence = 100 - r1r2Coincidence;
                }
                if (r1r2Coincidence >= coincidence) {
                    VoltageDivider vd = new VoltageDivider(r1, r2, r1r2Coincidence);
                    result.add(vd);
                }
            }
        }

        return result;

    }
}