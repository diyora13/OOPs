package L7;

public class BlogPost extends PublisherItem {
    private int words;

    public BlogPost(String title, int words) {
        super(title);
        this.words = Math.max(0, words);
    }

    @Override protected void render() { System.out.println("Blog Rendering..."); }
    @Override protected String type() { return "Blog"; }
    @Override protected int length() { return words; }
    @Override public void setLength(int v) { words = Math.max(0, v); }
}
