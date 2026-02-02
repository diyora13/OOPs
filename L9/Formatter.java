package L9;

public interface Formatter {
    String name();                         // e.g., "Plain", "Markdown"
    String render(String title, String content);
}
