import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.List;

public class SnakeFrame extends VBox {

    private static final int CELL_SIZE = 12;
    private SnakePanel snakePanel;

    public SnakeFrame(){
        getChildren().add(new TextField("Hola loco"));
        snakePanel = new SnakePanel(50,50,CELL_SIZE);
        getChildren().add(snakePanel);

    }

    public void updatePanel(DisplayElements[][] grid){
        for (int i=0; i<50; i++){
            for (int j=0; j<50; j++){
                String url = grid[i][j].getImage();
                if (url != null){
                    snakePanel.setImage(i,j, new Image(url));
                }else{
                    snakePanel.setBlackImage(i,j);
                }
            }
        }
    }
}
