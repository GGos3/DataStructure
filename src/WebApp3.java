public class WebApp3 {
    int x, y;

    public WebApp3(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.printf("x:%d, y:%d%n", this.x, this.y);
    }

    void setX(int x) {
        this.x = x;
        System.out.printf("x:%d, y:%d%n", this.x, this.y);
    }

    void setY(int y) {
        this.y = y;
        System.out.printf("x:%d, y:%d%n", this.x, this.y);
    }

    void moveXY(int x, int y) {
        this.x += x;
        this.y += y;
        System.out.printf("x:%d, y:%d%n", this.x, this.y);
    }

    public static void main(String[] args) {
        WebApp3 app = new WebApp3(100, 100);

        app.setX(200);
        app.setY(300);

        app.moveXY(50, 50);
    }
}
