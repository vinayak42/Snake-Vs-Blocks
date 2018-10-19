import java.util.Random;

public class Vector {

    // X component of the Vector
    public double x;

    // Y component of the Vector
    public double y;

    // Returns a random unit Vector
    public static Vector random() {
        Random rnd = new Random();

        double x = rnd.nextDouble();
        double y = rnd.nextDouble();

        double mag = Math.sqrt(x * x + y * y);

        return new Vector(x, y);
    }

    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector v) {
        x += v.x;
        y += v.y;
    }

    public void sub(Vector v) {
        x -= v.x;
        y -= v.y;
    }

    public void mult(double m) {
        x *= m;
        y *= m;
    }

    public double mag() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        double mag = this.mag();

        if (mag != 0) {
            x /= mag;
            y /= mag;
        }
    }
}