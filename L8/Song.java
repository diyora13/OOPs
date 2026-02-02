package L8;

// -------- Implementation 1: Song (implements Playable) --------
public class Song implements Playable {
    private final String title;
    private final int lengthSec;   // e.g., 210 = 3:30
    private String state;

    public Song(String title, int lengthSec) {
        this.title = (title == null || title.isBlank()) ? "Untitled" : title;
        this.lengthSec = Math.max(0, lengthSec);
        this.state="Paused";
    }

    @Override public void play()  { this.state = "Playing";  }
    @Override public void pause() { this.state = "Paused"; }

    @Override
    public void print() {
        System.out.println("Title: " + title
                + " Type: Song"
                + " State: " + state
                + " Len: " + Playable.formatSeconds(lengthSec));
    }
}
