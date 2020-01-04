import javafx.application.Application;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame {

    private SnakeFrame snakeFrame;
    private Snake snake;
    private Coordinate currentApple;
    private int rows;
    private int cols;
    private DisplayElements[][] cells;
    private EventHandler eventHandler;

    public SnakeGame(){
        rows = 50;
        cols = 50;
        cells = new DisplayElements[rows][cols];
        fillWithNothing(cells);
        snake = new Snake(rows,cols);
        snakeFrame = new SnakeFrame();
        Random random = new Random();
        currentApple = new Coordinate(random.nextInt(rows),random.nextInt(cols));
        updateCells();
        updateUI(cells);
        startGame();
    }

    public void startGame(){
        while(snakeLost() == false){

            snake.move(Directions.UP);
        }
    }

    public void updateCells(){
        List<Coordinate> positions = snake.getPositions();
        for (int i=0; i<snake.getLength(); i++){
            Coordinate actual = positions.get(i);
            cells[actual.getVertical()][actual.getHorizontal()] = DisplayElements.SNAKE;
        }
        cells[currentApple.getVertical()][currentApple.getHorizontal()] = DisplayElements.APPLE;
    }

    public void updateUI(DisplayElements[][] cells){
        snakeFrame.updatePanel(cells);
    }

    public SnakeFrame getSnakeFrame() {
        return snakeFrame;
    }

    public void fillWithNothing(DisplayElements[][] cells){
        for(int i = 0; i<rows; i++){
            for(int j =0; j<cols ; j++){
                cells[i][j] = DisplayElements.NOTHING;
            }
        }
    }

    public boolean snakeLost(){
        if (snakeOverlap() == true || snakeOutOfBounds() == true){
            return true;
        }
        return false;
    }
    public boolean snakeOverlap(){
        List<Coordinate> positions = snake.getPositions();
        for(int i= 0; i<snake.getLength(); i++){
            for(int j=0 ; j<snake.getLength(); j++){
                if (positions.get(i).equals(positions.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean snakeOutOfBounds(){
        Coordinate aux = snake.getSnakeHead();
        if (aux.getHorizontal() >= rows || aux.getHorizontal() < 0 || aux.getVertical() >=cols || aux.getVertical() < 0){
            return true;
        }
        return false;
    }



}
