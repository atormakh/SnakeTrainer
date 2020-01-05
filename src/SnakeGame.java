import javafx.application.Application;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SnakeGame {

    private SnakeFrame snakeFrame;
    private Snake snake;
    private Coordinate currentApple;
    private int rows;
    private int cols;
    private DisplayElements[][] cells;


    public SnakeGame() throws InterruptedException {
        rows = 26;
        cols = 26;
        cells = new DisplayElements[rows][cols];
        fillWithNothing(cells);
        snake = new Snake(rows,cols);
        snakeFrame = new SnakeFrame();
        Random random = new Random();
        currentApple = new Coordinate(random.nextInt(rows),random.nextInt(cols));
        //startGame();

    }

    public void startGame() throws InterruptedException {
        while(snakeLost() == false) {
            TimeUnit.MILLISECONDS.sleep(100);
            updateCells();
            updateUI(cells);
            snake.move(Directions.RIGHT);
        }
    }

    public void updateCells(){
        List<Coordinate> positions = snake.getPositions();
        for (int i=0; i<snake.getLength()-1; i++){
            Coordinate actual = positions.get(i);
            cells[actual.getVertical()][actual.getHorizontal()] = DisplayElements.SNAKE;
        }
        cells[snake.getSnakeHead().getVertical()][snake.getSnakeHead().getHorizontal()] = DisplayElements.SNAKE_HEAD;
        cells[currentApple.getVertical()][currentApple.getHorizontal()] = DisplayElements.APPLE;
        cells[snake.getLastPlace().getVertical()][snake.getLastPlace().getHorizontal()] = DisplayElements.NOTHING;
        System.out.println("snake: " + snake.getLastPlace());
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
                if ( i!=j && positions.get(i).equals(positions.get(j))){
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
