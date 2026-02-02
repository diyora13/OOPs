import L9.*;

public class Main {
    void main() {
        // Start with Local storage (constructor DI)
        Note note = new Note("Shopping", "Milk, Eggs");
        NoteService svc = new NoteService(note, new LocalStorage());

        // Baseline
        svc.print(); // Title: Shopping Storage: Local Status: Ready

        // Save via Local (delegation)
        svc.save();
        svc.print(); // Title: Shopping Storage: Local Status: Saved

        // Swap to Cloud (setter DI)
        svc.setStorage(new CloudStorage());
        svc.print(); // Title: Shopping Storage: Cloud Status: StorageSet

        // Empty content -> Cloud should fail
        svc.updateContent("");
        svc.print(); // Title: Shopping Storage: Cloud Status: Updated

        svc.save();
        svc.print(); // Title: Shopping Storage: Cloud Status: SaveFailed

        // Add some content -> Cloud should succeed
        svc.updateContent("Bread, Butter");
        svc.print(); // Title: Shopping Storage: Cloud Status: Updated

        svc.save();
        svc.print(); // Title: Shopping Storage: Cloud Status: Saved

        // (Optional) Swap back to Local and save (shows easy replacement)
        svc.setStorage(new LocalStorage());
        svc.print(); // Title: Shopping Storage: Local Status: StorageSet

        svc.save();
        svc.print(); // Title: Shopping Storage: Local Status: Saved
    }
}
