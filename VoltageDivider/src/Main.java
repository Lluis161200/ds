import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {

        //input
        double k=0.5;
        String name="E192";
        double coincidence=80.;

        //computer resistor pairs
        SeriesCatalog seriesCatalog = new SeriesCatalog();
        Serie series=seriesCatalog.findSeriesByname(name);
        List<VoltageDivider> vd=VoltageDividerCalculation.calculate(k,coincidence,series);
        Collections.sort(vd, VoltageDivider.VoltageDividerComparator);

        for(VoltageDivider i: vd){
            System.out.println(i);
        }





    }
}
