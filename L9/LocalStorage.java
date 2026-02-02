package L9;

public class LocalStorage implements Storage {
    public String name() { return "Local"; }
    public boolean save(Note note) { return true; } // Always succeeds (simple)
}
