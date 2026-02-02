import L7.*;

public class Main {
    void main() {
        // ===== SONG (Playable) =====
        Playable s = new Song("City Song", 210);
        s.print();   // Title: City Song Type: Song State: Paused Len: 3:30

        s.play();
        s.print();   // Title: City Song Type: Song State: Playing Len: 3:30

        s.pause();
        s.print();   // Title: City Song Type: Song State: Paused Len: 3:30

// Static method demo (does not change state; just a call)
        System.out.println("Changing format of 95 second to minute:second : "+Playable.formatSeconds(95));

// ===== PODCAST (Playable + Skippable) =====
        Playable p = new Podcast("DevTalk", 1200); // 20 minutes
        p.print();   // Title: DevTalk Type: Podcast State: Paused Pos: 0:0/20:0

        p.play();
        p.print();   // Title: DevTalk Type: Podcast State: Playing Pos: 0:0/20:0

        // Use the second interface via a reference cast (multiple interfaces in action)
        Skippable sp = (Skippable) p;
        sp.skip(30);
        p.print();   // Title: DevTalk Type: Podcast State: Playing Pos: 0:30/20:0

        sp.skip(1000);
        p.print();   // Title: DevTalk Type: Podcast State: Playing Pos: 17:1/20:0

        sp.skip(-9999);          // rewind to start (clamped)
        p.print();   // Title: DevTalk Type: Podcast State: Playing Pos: 0:0/20:0

        p.pause();
        p.print();   // Title: DevTalk Type: Podcast State: Paused Pos: 0:0/20:0

        // Array of Playable (polymorphism via interfaces; optional but nice)
        Playable[] playlist = { s, p, new Song("Morning Tune", 95) };
        for (Playable item : playlist) {
            item.print(); // one simple line per item, same default print()
        }
    }
}
