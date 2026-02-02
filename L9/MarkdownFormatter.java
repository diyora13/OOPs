package L9;

public class MarkdownFormatter implements Formatter {
    public String name() { return "Markdown"; }
    public String render(String title, String content) {
        // Minimal pretend-Markdown
        return "**" + title + "** — " + content;
    }
}
