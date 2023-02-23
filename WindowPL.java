import javax.swing.JFrame;
import java.awt.Color;


public class WindowPL extends JFrame{
    public WindowPL(){


        this.setTitle("Particle Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(MainPL.XBOUND+25,MainPL.YBOUND+50);
        this.setVisible(true);
        this.setLayout(null);

        this.getContentPane().setBackground(new Color(0,0,0));

    }
}
