import javax.swing.*;

public class Notepad extends  JFrame {
    Notepad() {
        setTitle("Notepad Clone");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }
}
