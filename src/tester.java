import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class tester extends Application {

    private WebView webView= new WebView();
    public  static SnakeGame snakeGame;

    public static void main(String[] args) throws InterruptedException {
        launch(args);
        //snakeGame.startGame();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
      snakeGame = new SnakeGame();
      SnakeFrame frame = new SnakeFrame(snakeGame);
      Scene scene = new Scene(frame);
      primaryStage.setResizable(false);
      primaryStage.setScene(scene);
      primaryStage.show();
      //snakeGame.startGame();
    }
}
