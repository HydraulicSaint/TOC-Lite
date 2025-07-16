public class Marker {
    private String label;
    private int x, y;

    public Marker(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return label + " at (" + x + "," + y + ")";
    }
}
