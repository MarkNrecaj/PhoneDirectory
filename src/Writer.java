import javax.swing.*;
import java.awt.*;

public class Writer extends JPanel {
    Directory k;
    int i;
    public Writer(int a, Directory obj){
        k=obj;
        i=a;

        int width = 300;
        int height = 200;
        JFrame frame = new JFrame();
        frame.getContentPane().add(this);
        frame.setTitle("Phone");
        frame.setSize(width, height);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLACK);
        g.drawLine(50,101,150,101);
        g.drawLine(50,61,150,61);
        vizato(g);

        Font f1 = new Font("Arial", Font.BOLD, 12);
        g.setFont(f1);
        g.drawString("Emri:", 10, 60);
        g.drawString("Numri:", 10, 100);


        int fontSize = 17;
        Font f = new Font("Arial", Font.BOLD, fontSize);
        g.setFont(f);
        g.drawString("Phone Directory",85, 20);
    }
     private void vizato(Graphics g){
        g.drawString(k.base[i].getKey().getEmri(),60, 60);
        g.drawString(k.base[i].getNumber() +  "",60,100);
    }
    void jepVlerat(int i)
     {     
      this.i = i; 
     }



}
