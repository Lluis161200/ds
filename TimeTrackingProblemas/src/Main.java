import java.util.ArrayList;
import java.util.Timer;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Project root = new Project("root");
        Project p1 = new Project("P1", root);
        Project p2 = new Project("P2", root);
        Task t1 = new Task("T1", root);
        Task t2 = new Task("T2", p1);
        Task t3 = new Task("T3", p2);

        root.addComponent(p1);
        root.addComponent(p2);
        root.addComponent(t1);
        p1.addComponent(t2);
        p2.addComponent(t3);



        Time clock = new Time(2);
        Printer printer = new Printer(root);
        clock.addObserver(printer);

        Thread.sleep(4000);
        t1.startTask(clock);
        Thread.sleep(4000);
        t2.startTask(clock);
        Thread.sleep(2000);

    }
}