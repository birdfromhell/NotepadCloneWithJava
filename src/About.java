import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
  About() {
      setTitle("About Tulisan Ku");
      setBounds(100,100,500,400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      ImageIcon icon = new ImageIcon(getClass().getResource("Notepad.png"));
      setIconImage(icon.getImage());

      JLabel tulisan = new JLabel("<html>Ini Adalah Tulisan Ku<br>Clone Dari Notepad</html>");
      tulisan.setFont(new Font("SAN_SERIF" ,Font.PLAIN, 10));
      tulisan.setBounds(150,130,500,300);
      add(tulisan);
  }

    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
