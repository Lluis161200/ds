import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Universe {
    private int numBodies;
    private double radius;
    private Body[] bodies;


    public Universe(String fname){
        try{
            Scanner in = new Scanner(new FileReader(fname));
            numBodies=Integer.parseInt(in.next());
            radius= Double.parseDouble(in.next());

            bodies = new Body[numBodies];
            for(int i=0;i<numBodies;i++)
            {
                double rx= Double.parseDouble(in.next());
                double ry= Double.parseDouble(in.next());
                double vx= Double.parseDouble(in.next());
                double vy= Double.parseDouble(in.next());
                double mass= Double.parseDouble(in.next());
                double[] position ={rx,ry};
                double[] velocity ={vx,vy};
                Vector r = new Vector(position);
                Vector v = new Vector(velocity);
                bodies[i]=new Body(r, v, mass);
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void update(double dt){
        Vector[] f =new Vector[numBodies];
        for(int i=0;i<numBodies; i++)
        {
            f[i]=new Vector(new double[2]);
        }
        for(int i=0; i<numBodies; i++){
            for(int j=0; j<numBodies; j++){
                if(i!=j){
                    f[i]=f[i].plus(bodies[i].forceFrom(bodies[j]));
                }
            }
        }
        for(int i=0;i<numBodies;i++)
        {
            bodies[i].move(f[i],dt);
        }

    }
    public Body[] getBodies()
    {
        return bodies;
    }
    public int getNumBodies(){
        return numBodies;
    }
    public double getRadius(){
        return radius;
    }
}
