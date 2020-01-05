import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.List;

public class SnakeFrame extends VBox {

    private static final int CELL_SIZE = 12;
    private SnakePanel snakePanel;

    public SnakeFrame(){
        getChildren().add(new TextField("Hola loco"));
        snakePanel = new SnakePanel(26,26,CELL_SIZE);
        getChildren().add(snakePanel);

    }

    public void updatePanel(DisplayElements[][] grid){
        Timeline timeLine = new Timeline();
        Duration frameGap = Duration.millis(100);
        Duration frameTime = Duration.ZERO;
        for (int i=0; i<26; i++){
            for (int j=0; j<26; j++){
                String url = grid[i][j].getImage();
                int finalI = i;
                int finalJ = j;
                if (url != null){
                    timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> snakePanel.setImage(finalI, finalJ, new Image(url))));
                    //snakePanel.setImage(i,j, new Image(url));
                }else{
                    timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> snakePanel.setBlackImage(finalI,finalJ)));
                }
            }
            frameTime = frameTime.add(frameGap);
        }

        timeLine.play();
    }
}
