public class Unit {
    private String name, role;
    private int x, y;

    public Unit(String name, String role, int x, int y) {
        this.name = name;
        this.role = role;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return name + " [" + role + "] at (" + x + "," + y + ")";
    }
}
