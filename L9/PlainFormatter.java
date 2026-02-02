package L9;

public class PlainFormatter  implements Formatter {
    public String name() { return "Plain"; }
    public String render(String title, String content) {
        // Very simple: Title: ...  Content: ...
        return "Title: " + title + " | " + content;
    }
}