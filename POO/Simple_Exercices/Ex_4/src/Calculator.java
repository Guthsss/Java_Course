public class Calculator {

    public static final double PI = 3.14159;

    public static double circuference(double radious) {
        return 2 * PI * radious;
    }
    public static double volume(double radious) {
        return 4 * PI * Math.pow(radious, 3) / 3;
    }
}
