import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class SnakePanel extends TilePane {
    private StackPane[][] cells;

    public SnakePanel(final int rows, final int columns, final int cellSize) {
        setPrefRows(rows);
        setPrefColumns(columns);
        setPrefTileHeight(cellSize);
        setPrefTileWidth(cellSize);
        this.cells = new StackPane[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new StackPane();
                cells[i][j].setBackground(new Background(new BackgroundFill(Color.rgb(40, 40, 40), CornerRadii.EMPTY, Insets.EMPTY)));
                getChildren().add(cells[i][j]);
            }
        }
    }

    public void setImage(int row, int column, Image image) {
        cells[row][column].getChildren().add(new ImageView(image));
    }

    public void setBlackImage(int i, int j) {

        cells[i][j].getChildren().clear();
    }
}
