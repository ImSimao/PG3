package i2627.trab1.grupo1;

public class Rect {
    private final double w;
    private final double h;
    private final double x;
    private final double y;
    private static int noOriginCounter = 0;

    public Rect(double x, double y, double w, double h) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
    }

    public Rect(double w, double h) {
        this(0, 0, w, h);  // primeira linha: origem em (0,0)
        noOriginCounter++;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getW() { return w; }
    public double getH() { return h; }

    public static int getNoOriginCounter() {
        return noOriginCounter;
    }


    @Override
    public String toString() {
        return String.format(java.util.Locale.US,"(%.1f,%.1f)->(%.1f,%.1f)", x, y, x + w, y + h);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rect other)) return false;
        return Math.abs(x - other.x) <= 0.01
            && Math.abs(y - other.y) <= 0.01 
            && Math.abs(w - other.w) <= 0.01 
            && Math.abs(h - other.h) <= 0.01;
    }

    public boolean isOverlapped(Rect other) {
        return x <= other.x + other.w   //this não está à direita de other
            && x + w >= other.x          //this não está à esquerda de other
            && y <= other.y + other.h   //this não está abaixo de other
            && y + h >= other.y;        //this não está acima de other
    }


    public static Rect parseRect(String s) {
        if (s == null) return null;
    
        String[] parts = s.split("->");
        if (parts.length != 2) return null;
    
        double[] p1 = parsePoint(parts[0]);
        double[] p2 = parsePoint(parts[1]);
        if (p1 == null || p2 == null) return null;
    
        double x1 = p1[0], y1 = p1[1];
        double x2 = p2[0], y2 = p2[1];
        return new Rect(x1, y1, x2 - x1, y2 - y1);
    }
    
    private static double[] parsePoint(String point) {
        if (point == null || point.length() < 5) return null; // mínimo: (0,0)
        if (point.charAt(0) != '(' || point.charAt(point.length() - 1) != ')') {
            return null;
        }
    
        String inside = point.substring(1, point.length() - 1); // "1.0,2.0"
        String[] nums = inside.split(",");
        if (nums.length != 2) return null;
    
        try {
            double a = Double.parseDouble(nums[0]);
            double b = Double.parseDouble(nums[1]);
            return new double[] { a, b };
        } catch (NumberFormatException e) {
            return null; // "abc" não é número
        }
    }



    public static void main(String[] args) {
        Rect r1 = new Rect(3, 4, 0, 0);
        Rect r2 = new Rect(3, 4, 0, 0);
        Rect r3 = r1;
        System.out.println(r1.toString());
        System.out.println(r1);
        System.out.println(r1 == r2);
        System.out.println(r1 == r3);
        System.out.println(r1.equals(r2));
    }
}
