package Myself;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
 
public class Testtt{
    JButton b1;
    JLabel l1;
    Testtt(){
        JFrame mainFrame = new JFrame("Display click button time");
        mainFrame.setLayout(new GridLayout(2,1));
        b1 = new JButton("Get Time");
        l1 = new JLabel();
         
        b1.addActionListener(new Monitor(this));
         
        mainFrame.add(b1);
        mainFrame.add(l1);
         
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
         
         
         
    }
     
    class Monitor implements ActionListener{
        Testtt a;
        Monitor(Testtt a){
            this.a = a;
        }
         
        public void actionPerformed(ActionEvent e){
            this.a.l1.setText(new Date().toString());
        }
    }
     
    public static void main(String[] args){
        new Testtt();
    }
}

