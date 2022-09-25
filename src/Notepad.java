import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Notepad extends  JFrame  implements ActionListener {
    JMenuBar Barmenu = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("About");

    JMenuItem newfile = new JMenuItem("New File");
    JMenuItem openfile = new JMenuItem("Open File");
    JMenuItem savefile = new JMenuItem("Save File");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");




    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem all = new JMenuItem("Select All");

    JTextArea areatext = new JTextArea();

    Notepad() {
        setTitle("Notepad Ku");
        setResizable(true);
        setBounds(50, 50, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("Notepad.png"));
        setIconImage(icon.getImage());

        setJMenuBar(Barmenu);
        Barmenu.add(file);
        Barmenu.add(edit);
        Barmenu.add(help);

        file.add(newfile);
        file.add(openfile);
        file.add(savefile);
        file.add(print);
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(all);



        JScrollPane scroll = new JScrollPane(areatext);
        add(scroll);
        areatext.setFont(new Font("SAN_SERIF" ,Font.PLAIN, 20));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        areatext.setLineWrap(true);
        areatext.setWrapStyleWord(true);

        newfile.addActionListener(this);
        openfile.addActionListener(this);
        savefile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        copy.addActionListener(this);
        all.addActionListener(this);

    }

    public static void main(String[] args) {

        new Notepad().setVisible(true);
    }
}
