package L9;

public class CloudStorage implements Storage {
    public String name() { return "Cloud"; }
    public boolean save(Note note) {
        // Edge: reject empty content
        String c = note.content();
        return c != null && !c.isBlank();
    }
}