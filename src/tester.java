import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class tester extends Application {

    private WebView webView= new WebView();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
      SnakeGame  snakeGame = new SnakeGame();
      SnakeFrame frame = snakeGame.getSnakeFrame();
      Scene scene = new Scene(frame);
      primaryStage.setResizable(false);
      primaryStage.setScene(scene);
      primaryStage.show();
    }
}
