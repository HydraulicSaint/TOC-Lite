import java.util.*;

public class ResourceTracker {
    private Map<String, Integer> resources = new HashMap<>();

    public void updateResource(String name, int value) {
        resources.put(name, value);
        System.out.println("[RESOURCE] " + name + " = " + value);
    }

    public void print() {
        System.out.println("Resources:");
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
