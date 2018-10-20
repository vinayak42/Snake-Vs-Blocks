import java.util.Random;

public class Vector {

    // X component of the Vector
    public double x;

    // Y component of the Vector
    public double y;

    // Returns a random unit Vector
    public static Vector random() {
        Random rnd = new Random();

        // Random x and y in range (-1, 1)
        double x = rnd.nextDouble() * 2 - 1;
        double y = rnd.nextDouble() * 2 - 1;

        Vector v = new Vector(x, y);
        v.normalize();

        return v;
    }

    // Add two vectors and return the resultant Vector
    public static Vector add(Vector first, Vector second) {
        return new Vector(first.x + second.x, first.y + second.y);
    }

    // Subtract second Vector from first Vector and return the resultant Vector
    public static Vector sub(Vector first, Vector second) {
        return new Vector(first.x - second.x, first.y - second.y);
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

    public void setMag(double m) {
        this.normalize();
        this.mult(m);
    }

    public Vector copy() {
        return new Vector(x, y);
    }
}
