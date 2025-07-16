import java.util.*;

public class TOCApp {
    private Grid grid;
    private LogManager logManager;
    private ResourceTracker resourceTracker;
    private Scanner scanner = new Scanner(System.in);

    public TOCApp() {
        this.grid = new Grid(10, 10); // default size
        this.logManager = new LogManager();
        this.resourceTracker = new ResourceTracker();
    }

    public void start() {
        System.out.println("Welcome to TOC-Lite CIVOPS Edition");
        String input;
        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            executeCommand(input);
        }
    }

    public void executeCommand(String input) {
        String[] tokens = input.split(" ");
        switch (tokens[0].toLowerCase()) {
            case "map":
                if (tokens.length >= 3 && tokens[1].equals("create")) {
                    String[] dims = tokens[2].split("x");
                    int rows = Integer.parseInt(dims[0]);
                    int cols = Integer.parseInt(dims[1]);
                    this.grid = new Grid(rows, cols);
                    System.out.println("Map created: " + rows + "x" + cols);
                }
                break;
            case "marker":
                if (tokens.length >= 5 && tokens[1].equals("add")) {
                    String label = tokens[2];
                    int x = Integer.parseInt(tokens[3]);
                    int y = Integer.parseInt(tokens[4]);
                    grid.addMarker(new Marker(label, x, y));
                }
                break;
            case "unit":
                if (tokens.length >= 5 && tokens[1].equals("add")) {
                    String name = tokens[2];
                    String role = tokens[3];
                    int x = Integer.parseInt(tokens[4]);
                    int y = Integer.parseInt(tokens[5]);
                    grid.addUnit(new Unit(name, role, x, y));
                }
                break;
            case "log":
                String message = input.substring(4);
                logManager.addLog(message);
                break;
            case "resource":
                if (tokens.length >= 4 && tokens[1].equals("update")) {
                    String key = tokens[2];
                    int amount = Integer.parseInt(tokens[3]);
                    resourceTracker.updateResource(key, amount);
                }
                break;
            case "status":
                grid.print();
                resourceTracker.print();
                logManager.print();
                break;
            default:
                System.out.println("Unknown command. Try again.");
        }
    }
}
