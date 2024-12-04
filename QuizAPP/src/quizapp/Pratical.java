
package quizapp;

import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

public class Pratical extends JFrame implements ActionListener{
    String Pra_arr[]={"Que1: Question no 1 is to be display?","Que2: Question no 2 is to be display?"};
    int current=0;
    JLabel l;
    JButton b1; 
    public int userscreenwidth,userscreenheight;
    JFrame frame;
    String [] ans=new String[2];
    
    Pratical()
    {
        frame = new JFrame("My Frame");
        frame.setLayout(null);
        frame.setTitle("MainPage");
        
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window to fill the entire screen
        frame.setAlwaysOnTop(true);
        
         userscreenwidth = screenSize.width;
         userscreenheight = screenSize.height;
        
        
        l=new JLabel();
            l.setFont(new Font("System",Font.BOLD,20));
            l.setBounds(userscreenwidth*1/10,userscreenheight*39/100,1600,50);
            frame.add(l); 
            
        l.setText(Pra_arr[0]);
        b1=new JButton("Perform Actions");
        b1.setBounds(userscreenwidth*329/800,(userscreenheight)*100/200, 225, 50);
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.DARK_GRAY);
        b1.addActionListener(this);
        frame.add(b1);
        
        frame.setVisible(true);
        frame.setLocation(0,0);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==b1)
       {
           //run overlay class and perfrom actions according to the questions
           new Overlay(Pra_arr[current]);
       }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Pratical();
    }
    
}
