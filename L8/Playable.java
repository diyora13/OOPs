package L8;

// -------- Interface 1: Playable --------
public interface Playable {
    void play();
    void pause();
    void print();

    // static: utility usable by any class (call as Playable.formatSeconds(x))
    static String formatSeconds(int s) {
        int mm = s / 60, ss = s % 60;
        return mm + ":" + ss; // uses private helper
    }
}