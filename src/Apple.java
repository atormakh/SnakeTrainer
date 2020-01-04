import javafx.scene.control.Alert;

public class Apple {
    private  Coordinate actual;

    public Apple(Coordinate actual) {
        this.actual = actual;
    }

    public Coordinate getActual() {
        return actual;
    }

    public void setActual(Coordinate actual) {
        this.actual = actual;
    }

}
