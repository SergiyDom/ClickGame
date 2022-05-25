public class CheckThread implements Runnable {
    Tile tile;
    int time;
    Controller controller;
    boolean on = true;

    public CheckThread(Controller controller) {
        this.controller = controller;
        this.time = controller.getTime();
    }

    @Override
    public void run() {
        System.out.println("Зайшли в \"Check thread\" ");
        while (on) {
            try {
                System.out.println("Thread name: " + Thread.currentThread().getName() + " is interrupt " + Thread.currentThread().isInterrupted());
                tile = controller.getTile();
                Thread.sleep(time);
                System.out.println("Change color");
                if (tile.value != 6 && on) {
                    tile.value = 4;
                    controller.setCompScore();
                    controller.getPanel().computerScore.setText("compScore: " + controller.getCompScore());
                    controller.getView().repaint();
                }
            } catch (InterruptedException e) {
            }
            System.out.println("дно вайла");
        }
    }
}
