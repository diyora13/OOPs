package L8;

// -------- Interface 2: Skippable (second capability) --------
public interface Skippable {
    void skip(int seconds);        // advance or rewind position (impl decides clamping)
}
