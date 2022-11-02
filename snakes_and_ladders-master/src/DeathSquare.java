import java.util.LinkedList;
import java.util.Vector;

public class DeathSquare extends Square{

    private Player player;
    private final int destine;
    public DeathSquare(int position,Board b){
        super(position,b);
        destine=position;


    }

    @Override
    protected Square landHereOrGoHome(){


        return destinationdefead();

    }

    private Square destinationdefead(){
        return findRelativeSquare(0);
    }
    //private Square

}
