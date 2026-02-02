package L8;

// -------- Implementation 2: Podcast (implements Playable + Skippable) --------
public class Podcast implements Playable, Skippable {
    private final String title;
    private final int lengthSec;   // total duration
    private int positionSec = 0;   // current position
    private String state;

    public Podcast(String title, int lengthSec) {
        this.title = (title == null || title.isBlank()) ? "Untitled" : title;
        this.lengthSec = Math.max(0, lengthSec);
    }

    @Override public void play()  { this.state = "Playing";  }
    @Override public void pause() { this.state = "Paused"; }

    @Override
    public void skip(int seconds) {
        // Minimal clamping; no prints or error messages (stay focused on interfaces)
        int next = positionSec + seconds;
        if (next < 0) next = 0;
        if (next > lengthSec) next = lengthSec;
        positionSec = next;
    }

    @Override
    public void print() {
        System.out.println("Title: " + title
                + " Type: Podcast"
                + " State: " + state
                + " Pos: " + Playable.formatSeconds(positionSec)
                + "/" + Playable.formatSeconds(lengthSec));
    }
}

