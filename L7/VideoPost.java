package L7;

public class VideoPost extends PublisherItem {
    private int minutes;

    public VideoPost(String title, int minutes) {
        super(title);
        this.minutes = Math.max(0, minutes);
    }

    @Override protected void render() { System.out.println("Video Rendering..."); }
    @Override protected String type() { return "Video"; }
    @Override protected int length() { return minutes; }
    @Override public void setLength(int v) { minutes = Math.max(0, v); }
}
