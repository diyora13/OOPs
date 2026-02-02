package L9;

public interface Storage {
    String name();                  // e.g., "Local", "Cloud"
    boolean save(Note note);        // returns success/failure
}

