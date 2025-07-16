import java.util.*;

public class LogManager {
    private List<String> logs = new ArrayList<>();

    public void addLog(String msg) {
        logs.add(msg);
        System.out.println("[LOG] " + msg);
    }

    public void print() {
        System.out.println("Mission Log:");
        for (String l : logs) {
            System.out.println("- " + l);
        }
    }
}
