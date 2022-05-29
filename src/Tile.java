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
        return switch (value) {
            case 0 -> //на старті
                    Color.GREEN;
            case 2 -> //при першій появі
                    new Color(255, 255, 0);
            case 4 -> //якщо не встиг натиснути за вказаний час
                    new Color(255, 0, 0);
            case 6 -> //встиг натиснути
                    new Color(0, 225, 0);
            default -> new Color(0, 0, 0);
        };
    }
}
