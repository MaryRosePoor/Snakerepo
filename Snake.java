import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<List<Integer>> snakeLocation;
    //List<List<Character>> board = new ArrayList<>();

    public Snake() {
        snakeLocation = new ArrayList<>();
        snakeLocation.add((List.of(20, 20)));
        snakeLocation.add((List.of(21, 20)));
        snakeLocation.add((List.of(22, 20)));

        //List.of(List.of(20, 20),List.of(21, 20), List.of(22, 20));
       // ArrayList<List<Integer>> snakeLocation1=)
       // snake.setSnakeLocation()
        //this.snakeLocation = snakeLocation;
    }



    public void draw(Graphics g) {
        //int[][] snake = {{20, 20}, {21, 20}, {22, 20}};
        /*
        char[] templist[50];

        for (int i = 0; i < 50; i++) {
            templist[i] = "_";
        }
        for (int i = 0; i < 50; i++) {
            board[i] = templist[];
        }
        */

        g.setColor(Color.green);
        for (int i = 0; i < snakeLocation.size()-1; i++) {
            g.fillRect(snakeLocation.get(i).get(0) * 10, snakeLocation.get(i).get(1) * 10, 10, 10);
        }
    }

    public void move() {

        int first = snakeLocation.get(0).get(0) - 1;
        int second = snakeLocation.get(0).get(1);

        snakeLocation.add(0, List.of(first, second));
        snakeLocation.remove(snakeLocation.size()-1);
    }
}