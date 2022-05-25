import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tile {
    int value; //вес плитки

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
        this.value = 0;
    }

    public boolean isEmpty() {
        return this.value == 0;
    }

    public Color getFontColor() { //колір значень
        return new Color(225,225,0);
//        return new Color(65,105,225);
    }

    public Color getTileColor() { //колір плитка
        switch (value) {
            case 0:
                return new Color(65,105,225);
            case 2:
                return new Color(255, 255, 0);
            case 4:
                return new Color(255, 0, 0);
            default:
                return new Color(0, 0, 0);
        }
    }
}
