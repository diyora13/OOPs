package L9;

public class NoteService {
    private final Note note;     // composition: has-a Note
    private Storage storage;     // composition: has-a Storage
    private String status = "Ready";

    // Constructor injection
    public NoteService(Note note, Storage storage) {
        this.note = note;
        this.storage = storage;
    }

    // Setter injection to swap dependency at runtime
    public void setStorage(Storage s) {
        this.storage = s;
        this.status = "StorageSet";
    }

    public void updateContent(String c) {
        note.setContent(c);
        this.status = "Updated";
    }

    // Delegation
    public boolean save() {
        boolean ok = storage.save(note);
        this.status = ok ? "Saved" : "SaveFailed";
        return ok;
    }

    // Simple, uniform verification line
    public void print() {
        System.out.println("Title: " + note.title()
                + " Storage: " + storage.name()
                + " Status: " + status);
    }
}
