package L12;

// A tiny resource that must be closed after use
public class Session implements AutoCloseable {
    private final String name;
    private boolean open = true;

    public Session(String name) {
        this.name = (name == null || name.isBlank()) ? "Unknown" : name;
    }

    // Simulate work; throw if invalid or if already closed
    public void doWork(String action) {
        if (!open) throw new IllegalStateException("Session is closed");
        if (action == null || action.isBlank()) throw new IllegalArgumentException("Action is blank");
        // pretend to do something
    }

    @Override
    public void close() {
        // mark as closed (this is where real resources would be released)
        open = false;
        // Keeping prints centralized via print() in main to match your style
    }

    public void print(String status) {
        System.out.println("Session: " + name + " Status: " + status);
    }
}

