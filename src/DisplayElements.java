import javafx.scene.image.Image;

public enum DisplayElements {
    NOTHING(0,null),
    APPLE(1,"images/apple.png"),
    SNAKE(2,"images/dot.png"),
    SNAKE_HEAD(3,"images/head.png");

    public String getImage() {
        return image;
    }

    private String image;
    private int key;

    DisplayElements(int key, String image){
        this.key = key;
        this.image = image;
    }
}
