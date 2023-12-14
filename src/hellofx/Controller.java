package hellofx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.image.Image;

public class Controller {

    @FXML
    private Label lable_life;

    @FXML
    private Label label_gold;

    @FXML
    private Label label_monster;

    @FXML
    private Label label_time;

    @FXML
    private Label label_status;

    @FXML
    private Canvas grid;

    private String[][] map;
    private final int width = 10;
    private final int height = 10;
    private double unit_width;
    private double unit_height;

    private Image treasure;
    private Image hero;

    private int hero_x = 5;
    private int hero_y = 5;

    public void move_up() {
        label_status.setText("");
        if ( hero_x > 0 )
        {
            map[hero_x][hero_y] = null;
            hero_x--;
            map[hero_x][hero_y] = "O";
        }
        else {
            label_status.setText("You are already at the top. You can't move up anymore!");
        }

        updateAll();
    }

    public void move_down() {
        label_status.setText("");
        if ( hero_x < height-1 )
        {
            map[hero_x][hero_y] = null;
            hero_x++;
            map[hero_x][hero_y] = "O";
        }
        else {
            label_status.setText("You are already at the bottom. You can't move up anymore!");
        }

        updateAll();
    }

    public void move_left() {
        label_status.setText("");
        if ( hero_y > 0 )
        {
            map[hero_x][hero_y] = null;
            hero_y--;
            map[hero_x][hero_y] = "O";
        }
        else {
            label_status.setText("You are already at the left. You can't move left anymore!");
        }

        updateAll();
    }

    public void move_right() {
        label_status.setText("");
        if ( hero_y < width-1 )
        {
            map[hero_x][hero_y] = null;
            hero_y++;
            map[hero_x][hero_y] = "O";
        }
        else {
            label_status.setText("You are already at the right. You can't move right anymore!");
        }

        updateAll();
    }
    public void initialize()  throws FileNotFoundException {
        map = new String[height][width];
        map[hero_x][hero_y] = "O";
        map[1][3] = "*";
        map[8][9] = "*";
        map[3][4] = "*";

        unit_width = (double) grid.getWidth() / width;
        unit_height = (double) grid.getHeight() / height;

        treasure = new Image(new FileInputStream("C:\\Users\\s-wangdy\\OneDrive - Bellevue School District\\Senior Year\\Spec Topics\\Game\\src\\hellofx\\treasure.jpg"), unit_width, unit_height, false, false);
        hero = new Image(new FileInputStream("C:\\Users\\s-wangdy\\OneDrive - Bellevue School District\\Senior Year\\Spec Topics\\Game\\src\\hellofx\\hero.jpg"), unit_width, unit_height, false, false);

        updateAll();
     }

     private void updateAll() {
        updateLabels();
        drawMap();
     }

     private void updateLabels() {
        // update labels
        lable_life.setText("Life: 92");
        label_gold.setText("Gold: 5,287");
        label_monster.setText("Monster: 34");
        label_time.setText("Time: 13");
     }

     private void drawMap() {
        // first, fill whole canvas with green 
        GraphicsContext gc = grid.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,grid.getWidth(), grid.getHeight());

        for(int i = 0; i < height; i++) {
            for (int j=0; j<width; j++) {
                if ( map[i][j] != null ) {
                    if ( map[i][j].equals("*")) {
                        // draw treasure box
                        gc.drawImage(treasure, j * unit_width, i * unit_height);
                    }
                    else if ( map[i][j].equals("O")) {
                        // draw treasure box
                        gc.drawImage(hero, j * unit_width, i * unit_height);
                    }
                    
                }
            }
        }

     }
}