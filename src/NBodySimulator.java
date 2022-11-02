import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class NBodySimulator {

    private double timeStep;

    private int pauseTime;

    private boolean trace;

    private Universe universe;

    private static final double MINRADIUSRANDNUM = 1.0e+09;
    private static final double MAXRADIUSRANDNUM = 2.50e+11;
    private static final double MINPOSRANDNUM = -4.5e10;

    private static final double MAXPOSRANDNUM = 4.5e10;

    private static final double MINVELRANDNUM = 0.000e+00;

    private static final double MAXVELRANDNUM = 5.000e+03;

    private static final double MINMASSRANDNUM = 2.500e+20;

    private static final double MAXMASSRANDNUM = 2.500e+28;
    public NBodySimulator(String fname, double timeStep, int pauseTime, boolean trace){
        try{
            Scanner in = new Scanner(new FileReader(fname));
            this.timeStep=timeStep;
            this.pauseTime=pauseTime;
            this.trace=trace;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        universe=new Universe(fname);
    }
    public static void main(String[] args){

        NBodySimulator nbody;
        int numargs= args.length;
        if((numargs==3)||(numargs==4))
        {
            double dt =Double.parseDouble(args[0]);
            String fname =args[1];
            int pauseTime=Integer.parseInt(args[2]);
            boolean do_trace = false;
            if(args.length==4){
                do_trace=args[3].toLowerCase().equals("trace");

            }
            nbody=new NBodySimulator(fname, dt, pauseTime, do_trace);
            createRandom();
            nbody.simulate();

        }else{
            assert false : "invalid number of arguments";
        }
    }
    public static void createRandom()
    {

        try{
            String ruta = "C:\\Users\\lluis\\Desktop\\nbody2\\data/filname.txt";
            //String contenido = String.valueOf(Math.floor(Math.random()*(MINPOSRANDNUM-MAXPOSRANDNUM+1)+MAXPOSRANDNUM)) + " " + String.valueOf(0.0e00) + " " + String.valueOf(Math.floor(Math.random()*(MINVELRANDNUM-MAXVELRANDNUM+1)+MAXVELRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINVELRANDNUM-MAXVELRANDNUM+1)+MAXVELRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINMASSRANDNUM-MAXMASSRANDNUM+1)+MAXMASSRANDNUM));
            //String contenido1 = String.valueOf(Math.floor(Math.random()*(MINPOSRANDNUM-MAXPOSRANDNUM+1)+MAXPOSRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINPOSRANDNUM-MAXPOSRANDNUM+1)+MAXPOSRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINVELRANDNUM-MAXVELRANDNUM+1)+MAXVELRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINVELRANDNUM-MAXVELRANDNUM+1)+MAXVELRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINMASSRANDNUM-MAXMASSRANDNUM+1)+MAXMASSRANDNUM));

            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            int numb= (int) (Math.random()*10+2);
            bw.write(" " + String.valueOf(numb) + '\n');
            bw.write(" " + String.valueOf(Math.floor(Math.random()*(MINRADIUSRANDNUM-MAXRADIUSRANDNUM+1)+MAXRADIUSRANDNUM)) + '\n');
            for(int i=0;i<numb;i++)
            {
                String contenido = String.valueOf(Math.floor(Math.random()*(MINPOSRANDNUM-MAXPOSRANDNUM+1)+MAXPOSRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINPOSRANDNUM-MAXPOSRANDNUM+1)+MAXPOSRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINVELRANDNUM-MAXVELRANDNUM+1)+MAXVELRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINVELRANDNUM-MAXVELRANDNUM+1)+MAXVELRANDNUM)) + " " + String.valueOf(Math.floor(Math.random()*(MINMASSRANDNUM-MAXMASSRANDNUM+1)+MAXMASSRANDNUM));
                bw.write(" " + contenido + '\n' );
            }

            //bw.write(" " + contenido1 + '\n' );


            bw.close();

        }catch(Exception e){
            e.printStackTrace();
        }



    }
    public void simulate(){
        createCanvas();
        while(true)
        {
            StdDraw.clear();
            universe.update(timeStep);
            universe.update(timeStep);
            drawUniverse();
            StdDraw.pause(pauseTime);
            StdDraw.show();
        }

    }
    private void createCanvas() {
        StdDraw.setCanvasSize(1000, 700);
        // this makes a larger window than the default
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenRadius(0.025);
        double radius = universe.getRadius();
        // read from txt file, second line
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
    }
    private void drawUniverse(){

        Body[] body = universe.getBodies();

        for(int i=0; i<universe.getNumBodies();i++)
        {
            Vector v= body[i].getPosition();
            StdDraw.point(v.cartesian(0), v.cartesian(1));
        }
    }
}
