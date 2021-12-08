package enduroatari;

import java.awt.Color;

import javax.swing.JFrame;

public class Interface extends JFrame
{

    public MainDraw principal = new MainDraw();

    Interface()
    {
        setResizable(false);
        this.add(principal);

        this.setTitle("Enduro Atari");
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.setSize(962, 698);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
