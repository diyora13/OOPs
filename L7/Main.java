import L7.*;

public class Main {
    void main() {
        // ----- Blog via abstract reference ---- //
        PublisherItem b = new BlogPost("Java OOP Notes", 500);
        b.print();   // Title: Java OOP Notes Type: Blog Status: Draft Length: 500

        b.publish();	// Blog Rendering...
        b.print();   // Title: Java OOP Notes Type: Blog Status: Published Length: 500

        b.rename("Java OOP Summary");
        b.print();   // Title: Java OOP Summary Type: Blog Status: Published Length: 500

        b.setLength(0);
        b.print();   // Title: Java OOP Summary Type: Blog Status: Published Length: 0

        b.setLength(-10);
        b.print();   // Title: Java OOP Summary Type: Blog Status: Published Length: 0

        b.rename(" "); // invalid (ignored silently)
        b.print();   // Title: Java OOP Summary Type: Blog Status: Published Length: 0

// ----- Video via abstract reference -----
        PublisherItem v = new VideoPost("OOP Intro", 12);
        v.print();   // Title: OOP Intro Type: Video Status: Draft Length: 12

        v.publish();	// Video Rendering...
        v.print();   // Title: OOP Intro Type: Video Status: Published Length: 12

        v.setLength(0);
        v.print();   // Title: OOP Intro Type: Video Status: Published Length: 0

        v.setLength(-5);
        v.print();   // Title: OOP Intro Type: Video Status: Published Length: 0

        v.rename("OOP Quickstart");
        v.print();   // Title: OOP Quickstart Type: Video Status: Published Length: 0
    }
}
