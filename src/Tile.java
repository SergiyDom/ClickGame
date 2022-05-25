import java.awt.*;

public class Tile {
    int value; //вес плитки
    int xCoord;
    int yCoord;

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
        return new Color(225, 225, 0);
//        return new Color(65,105,225);
    }

    public Color getTileColor() { //колір плитка
        switch (value) {
            case 0: //на старті
                return new Color(65, 105, 225);
            case 2: //при першій появі
                return new Color(255, 255, 0);
            case 4: //якщо не встиг натиснути за вказаний час
                return new Color(255, 0, 0);
            case 6: //встиг натиснути
                return new Color(0, 225, 0);
            default:
                return new Color(0, 0, 0);
        }
    }
}
