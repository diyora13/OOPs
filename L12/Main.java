import L12.*;

public class Main {
    void main() {
        // ===== 1) Normal use with try-with-resources (auto close) =====
        try (Session s1 = new Session("S1")) {
            s1.doWork("LoadHome");
            s1.print("Done"); // Session: S1 Status: Done
        } // s1.close() auto-called here

        // ===== 2) Error path inside try-with-resources (still auto close) =====
        try (Session s2 = new Session("S2")) {
            s2.doWork(""); // throws IllegalArgumentException
            s2.print("Done");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Error: Action is blank
        }
        // Even though an exception occurred, s2.close() was called automatically.

        // ===== 3) Manual try/finally (more verbose than TWR) =====
        Session s3 = new Session("S3");
        try {
            s3.doWork("SyncProfile");
            s3.print("Done"); // Session: S3 Status: Done
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            s3.close(); // must remember to close manually
        }

        // ===== 4) Call after close (unchecked exception) =====
        try {
            s3.doWork("AfterClose"); // IllegalStateException (already closed)
            s3.print("Done");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage()); // Error: Session is closed
        }

        // ===== 5) GC mention (just comments; no code) =====
        // Session temp = new Session("Temp");
        // temp = null; // Eligible for GC later, but GC does NOT close resources.
        // finalize() is deprecated/removed; never rely on it for cleanup.
    }
}
