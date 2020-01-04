import java.lang.reflect.Array;
import java.util.Arrays;

public enum Directions {

    UP(-1,0),
    DOWN(1,0),
    RIGHT(0,1),
    LEFT(0,-1);


    private int vertical, horizontal;
    Directions(int vertical,int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }
}
