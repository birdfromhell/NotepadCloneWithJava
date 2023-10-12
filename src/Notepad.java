import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {
    JMenuBar Barmenu = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");

    JMenuItem newfile = new JMenuItem("New File");
    JMenuItem openfile = new JMenuItem("Open File");
    JMenuItem savefile = new JMenuItem("Save File");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");

    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem all = new JMenuItem("Select All");

    JMenuItem about = new JMenuItem("About");

    JTextArea areatext = new JTextArea();

    Notepad() {
        setTitle("Notepad Ku");
        setBounds(50, 50, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        help.add(about);

        JScrollPane scroll = new JScrollPane(areatext);
        add(scroll);
        areatext.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        areatext.setLineWrap(true);
        areatext.setWrapStyleWord(true);

        newfile.addActionListener(this);
        openfile.addActionListener(this);
        savefile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        all.addActionListener(this);

        about.addActionListener(this);
    }

    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(newfile.getActionCommand())) {
            areatext.setText("");
        } else if (command.equals(openfile.getActionCommand())) {
            JFileChooser chooser = new JFileChooser();
            int chooserOption = chooser.showOpenDialog(null);
            if (chooserOption == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    areatext.read(br, null);
                    br.close();
                    areatext.requestFocus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } else if (command.equals(savefile.getActionCommand())) {
            JFileChooser fc = new JFileChooser();
            int chooserOption = fc.showSaveDialog(null);
            if (chooserOption == JFileChooser.APPROVE_OPTION) {
                try {
                    FileWriter fw = new FileWriter(fc.getSelectedFile().getAbsolutePath());
                    BufferedWriter bw = new BufferedWriter(fw);
                    areatext.write(bw);
                    bw.close();
                    areatext.requestFocus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } else if (command.equals(print.getActionCommand())) {
            try {
                areatext.print();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (command.equals(exit.getActionCommand())) {
            System.exit(0);
        } else if (command.equals(cut.getActionCommand())) {
            areatext.cut();
        } else if (command.equals(copy.getActionCommand())) {
            areatext.copy();
        } else if (command.equals(paste.getActionCommand())) {
            areatext.paste();
        } else if (command.equals(all.getActionCommand())) {
            areatext.selectAll();
        } else if(command.equals(about.getActionCommand())) {
            JOptionPane.showMessageDialog(this, "This is a simple Notepad App\nCreated with Java and Swing", "About", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}