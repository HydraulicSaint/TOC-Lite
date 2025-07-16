import java.util.*;

public class Grid {
    private int rows, cols;
    private List<Marker> markers = new ArrayList<>();
    private List<Unit> units = new ArrayList<>();

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public void addMarker(Marker m) {
        markers.add(m);
        System.out.println("Marker added: " + m);
    }

    public void addUnit(Unit u) {
        units.add(u);
        System.out.println("Unit added: " + u);
    }

    public void print() {
        System.out.println("Grid: " + rows + "x" + cols);
        for (Marker m : markers) System.out.println("[MARKER] " + m);
        for (Unit u : units) System.out.println("[UNIT] " + u);
    }
}