import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final int INITIAL_LENGTH = 3;
    private List<Coordinate> positions;
    private List<Directions> directions;
    private int length;
    private Coordinate lastPlace;


    public Snake(int rows, int cols){
        length = INITIAL_LENGTH;
        positions = new ArrayList(length);
        directions = new ArrayList<>(length);
        giveInitialLayout(rows,cols);
    }

    public void giveInitialLayout(int rows, int cols){
        int half= rows/2;
        for (int i = 0; i< length; i++){
            positions.add(new Coordinate(half,i));
            directions.add(Directions.RIGHT);
        }
        lastPlace = positions.get(0);
    }

    public void move(Directions dir){
/*        lastPlace = positions.get(0);
        Directions aux = directions.get(0);
        directions.set(0,dir);
        Directions aux2;
        for(int i =1; i<length; i++){
            aux2 = directions.get(i);
            directions.set(i,aux);
            aux = aux2;
        }*/
        // ab
        // { i,a,ab}
        lastPlace = positions.get(0).clone();


        for(int i= 0 ; i<length -1 ; i++){
            directions.set(i,directions.get(i+1));
        }
        directions.set(length-1,dir);
        //se podria agregar la ultima direccion y desp hacer un directions.remove(index=0) lo cual shiftearia el vector
        for(int i = 0; i<length ; i++){
            Coordinate original = positions.get(i);
            Coordinate newPos = original.plus(directions.get(i));
            positions.set(i,newPos);
        }


    }

    public Coordinate getLastPlace() {
        return lastPlace;
    }

    public void grow(){}

    public List<Coordinate> getPositions() {
        return positions;
    }

    public void setPositions(List<Coordinate> positions) {
        this.positions = positions;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Coordinate getSnakeHead(){
        return positions.get(length-1);
    }
}
