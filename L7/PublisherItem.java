package L7;

public abstract class PublisherItem {
    private String title;
    private String status = "Draft"; // Draft -> Published

    protected PublisherItem(String title) {
        this.title = (title == null || title.isBlank()) ? "Untitled" : title;
    }

    // ----- Template Method (kept minimal on purpose) -----
    public final void publish() {
        render();            // abstract hook: child decides rendering work
        status = "Published";
    }

    // ----- Shared concrete behavior -----
    public final void rename(String newTitle) {
        if (newTitle != null && !newTitle.isBlank()) {
            this.title = newTitle; // ignore invalid silently to keep output clean
        }
    }

    public final void print() {
        System.out.println("Title: " + title + " Type: " + type() + " Status: " + status + " Length: " + length());
    }

    // ----- Abstract hooks -----
    protected abstract void render();
    protected abstract String type();     // "Blog" / "Video"
    protected abstract int length();      // words / minutes
    public abstract void setLength(int v);
}
