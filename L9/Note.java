package L9;

public class Note {
    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = (title == null || title.isBlank()) ? "Untitled" : title;
        this.content = (content == null) ? "" : content;
    }
    public String title()   { return title; }
    public String content() { return content; }
    public void setContent(String c) { content = (c == null) ? content : c; }
}
