
package quizapp;

import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

public class Mainpage extends JFrame implements ActionListener {
    
    JLabel l,l1;
    int sec=4;
    JButton b1; 
    boolean flag,flag1;
    public int userscreenwidth,userscreenheight;
    JFrame frame;
    JButton Pratical,Exam,Theory,TV,Submit,SS,SU,IO,Sst,IT,Oth,wd,Ex,PP,OL,WND,INT;
    String[][][] strArr = ControllerClass.Theoryquestions(10);
    JRadioButton jb[]=new JRadioButton[4];    
    ButtonGroup bg;
    int current=0;
    String [] ans=new String[2];
    String[][][] Pra_arr= ControllerClass.PracticalQuestions(10);
    int current1=0;
    Mainpage()
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
        //frame.setAlwaysOnTop(true);
        
         userscreenwidth = screenSize.width;
         userscreenheight = screenSize.height;
        
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/Theory.png"));
        Image i11=i10.getImage().getScaledInstance(200, 200, WIDTH);
        ImageIcon i12=new ImageIcon(i11);
        Theory = new JButton(i12);
        Theory.setBounds(userscreenwidth/22,userscreenheight/10,200,200);
        Theory.addActionListener(this);
        frame.add(Theory);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Pratical.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200, WIDTH);
        ImageIcon i3=new ImageIcon(i2);
        Pratical = new JButton(i3);
        Pratical.setBounds(userscreenwidth/22,userscreenheight*3/10,200,200);
        Pratical.addActionListener(this);
        frame.add(Pratical);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/Exam.png"));
        Image i5=i4.getImage().getScaledInstance(200, 200, WIDTH);
        ImageIcon i6=new ImageIcon(i5);
        Exam = new JButton(i6);
        Exam.setBounds(userscreenwidth/22,userscreenheight*5/10,200,200);
        Exam.addActionListener(this);
        frame.add(Exam);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/TV.png"));
        Image i8=i7.getImage().getScaledInstance(200, 200, WIDTH);
        ImageIcon i9=new ImageIcon(i8);
        TV = new JButton(i9);
        TV.setBounds(userscreenwidth/22,userscreenheight*7/10,200,200);
        TV.addActionListener(this);
        frame.add(TV);
        
        
       
        b1=new JButton("Perform Actions");
        b1.setBounds(userscreenwidth*329/800,(userscreenheight)*100/200, 225, 50);
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.DARK_GRAY);
        b1.addActionListener(this);
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        b1.setOpaque(true);
        frame.add(b1);
        
        b1.setVisible(false);
        
        frame.setVisible(true);
        frame.setLocation(0,0);
        
         l=new JLabel();
            l.setFont(new Font("System",Font.BOLD,20));
            l.setBounds(userscreenwidth*2/10,userscreenheight*39/100,1600,50);
            frame.add(l);
            l.setVisible(false);
            bg=new ButtonGroup();  
        
        for(int i=0;i<4;i++)  
        {  
            jb[i]=new JRadioButton(); 
            jb[i].setFont(new Font("System",Font.BOLD,18));
            bg.add(jb[i]);  
        }
         
        
        l.setText(strArr[sec][current][1]);
        jb[0].setText(strArr[sec][current][2]);
        jb[1].setText(strArr[sec][current][3]);
        jb[2].setText(strArr[sec][current][4]);
        jb[3].setText(strArr[sec][current][5]);
        
        
        jb[0].setBounds(userscreenwidth*2/10,userscreenheight*45/100,500,50);
        jb[1].setBounds(userscreenwidth*2/10,userscreenheight*50/100,500,50);
        jb[2].setBounds(userscreenwidth*2/10,userscreenheight*55/100,500,50);
        jb[3].setBounds(userscreenwidth*2/10,userscreenheight*60/100,500,50);
           // add(jb[3]);
           frame.add(jb[0]); 
           frame.add(jb[1]); 
           frame.add(jb[2]); 
           frame.add(jb[3]);
           
           jb[0].setVisible(false);
           jb[1].setVisible(false);
           jb[2].setVisible(false);
           jb[3].setVisible(false);
           
           jb[0].repaint();
           jb[1].repaint();
           jb[2].repaint();
           jb[3].repaint();
           
        ImageIcon i18=new ImageIcon(ClassLoader.getSystemResource("icons/SS.jpg"));
        Image i28=i18.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i38=new ImageIcon(i28);
        SS = new JButton(i38);
        SS.setBounds(userscreenwidth*4/22,userscreenheight*2/10,150,150);
        SS.addActionListener(this);
        frame.add(SS);
        SS.setVisible(false);
        SS.repaint();
        
        ImageIcon i48=new ImageIcon(ClassLoader.getSystemResource("icons/SU.jpg"));
        Image i58=i48.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i68=new ImageIcon(i58);
        SU = new JButton(i68);
        SU.setBounds(userscreenwidth*7/22,userscreenheight*2/10,150,150);
        SU.addActionListener(this);
        frame.add(SU);
        SU.setVisible(false);
        SU.repaint();
        
        ImageIcon i71=new ImageIcon(ClassLoader.getSystemResource("icons/IO.jpg"));
        Image i81=i71.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i91=new ImageIcon(i81);
        IO = new JButton(i91);
        IO.setBounds(userscreenwidth*10/22,userscreenheight*2/10,150,150);
        IO.addActionListener(this);
        frame.add(IO);
        IO.setVisible(false);
        IO.repaint();
        
        ImageIcon i101=new ImageIcon(ClassLoader.getSystemResource("icons/Sst.jpg"));
        Image i111=i101.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i121=new ImageIcon(i111);
        Sst = new JButton(i121);
        Sst.setBounds(userscreenwidth*13/22,userscreenheight*2/10,150,150);
        Sst.addActionListener(this);
        frame.add(Sst);
        Sst.setVisible(false);
        Sst.repaint();
        
        ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("icons/IT.jpg"));
        Image i14=i13.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i15=new ImageIcon(i14);
        IT = new JButton(i15);
        IT.setBounds(userscreenwidth*16/22,userscreenheight*2/10,150,150);
        IT.addActionListener(this);
        frame.add(IT);
        IT.setVisible(false);
        IT.repaint();
        
        ImageIcon i16=new ImageIcon(ClassLoader.getSystemResource("icons/Oth.jpg"));
        Image i17=i16.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i19=new ImageIcon(i17);
        Oth = new JButton(i19);
        Oth.setBounds(userscreenwidth*19/22,userscreenheight*2/10,150,150);
        Oth.addActionListener(this);
        frame.add(Oth);
        Oth.setVisible(false);
        Oth.repaint();
           
        Submit=new JButton("SUBMIT");
        Submit.setBounds(userscreenwidth*20/100,(userscreenheight*3)/4, 150, 30);
        Submit.setFont(new Font("Arial", Font.PLAIN, 24));
        Submit.setBorder(BorderFactory.createRaisedBevelBorder());
        Submit.setOpaque(true);
        Submit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Code to be executed when the button is clicked
        if (jb[0].isSelected()) {
            strArr[sec][current][7]="opt";
                
            } else if (jb[1].isSelected()) {
                strArr[sec][current][7]="opt";
                
            } else if (jb[2].isSelected()) {
                strArr[sec][current][7]="opt";
                
            } else if(jb[3].isSelected()) {
                strArr[sec][current][7]="opt";
  
            }
        check(current);
        current++;
        set(current);
        bg.clearSelection();
        
    }
});
        frame.add(Submit);
        
        Submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Submit.setBackground(new Color(255, 200, 200));
                Submit.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Submit.setBackground(UIManager.getColor("Button.background"));
                Submit.setForeground(UIManager.getColor("Button.foreground"));
            }
        });
        Submit.setVisible(false);
        Submit.repaint();
        
        l1=new JLabel();
            l1.setFont(new Font("System",Font.BOLD,20));
            l1.setBounds(userscreenwidth*2/10,userscreenheight*39/100,1600,50);
            l1.setText(Pra_arr[sec][current1][1]);
            frame.add(l1);
            l1.setVisible(false);
            l1.setText(Pra_arr[sec][current1][1]);

        b1.repaint();
        
        ImageIcon i61=new ImageIcon(ClassLoader.getSystemResource("icons/wd.jpg"));
        Image i62=i61.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i63=new ImageIcon(i62);
        wd = new JButton(i63);
        wd.setBounds(userscreenwidth*4/22,userscreenheight*2/10,150,150);
        wd.addActionListener(this);
        frame.add(wd);
        wd.setVisible(false);
        wd.repaint();
        
        ImageIcon i54=new ImageIcon(ClassLoader.getSystemResource("icons/Ex.jpg"));
        Image i55=i54.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i56=new ImageIcon(i55);
        Ex = new JButton(i56);
        Ex.setBounds(userscreenwidth*7/22,userscreenheight*2/10,150,150);
        Ex.addActionListener(this);
        frame.add(Ex);
        Ex.setVisible(false);
        Ex.repaint();
        
        ImageIcon i77=new ImageIcon(ClassLoader.getSystemResource("icons/PP.jpg"));
        Image i78=i77.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i79=new ImageIcon(i78);
        PP = new JButton(i79);
        PP.setBounds(userscreenwidth*10/22,userscreenheight*2/10,150,150);
        PP.addActionListener(this);
        frame.add(PP);
        PP.setVisible(false);
        PP.repaint();
        
        ImageIcon i130=new ImageIcon(ClassLoader.getSystemResource("icons/OL.jpg"));
        Image i131=i130.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i132=new ImageIcon(i131);
        OL = new JButton(i132);
        OL.setBounds(userscreenwidth*13/22,userscreenheight*2/10,150,150);
        OL.addActionListener(this);
        frame.add(OL);
        OL.setVisible(false);
        OL.repaint();
        
        ImageIcon i137=new ImageIcon(ClassLoader.getSystemResource("icons/WND.jpg"));
        Image i147=i137.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i157=new ImageIcon(i147);
        WND = new JButton(i157);
        WND.setBounds(userscreenwidth*16/22,userscreenheight*2/10,150,150);
        WND.addActionListener(this);
        frame.add(WND);
        WND.setVisible(false);
        WND.repaint();
        
        ImageIcon i167=new ImageIcon(ClassLoader.getSystemResource("icons/INT.jpg"));
        Image i177=i167.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i187=new ImageIcon(i177);
        INT = new JButton(i18);
        INT.setBounds(userscreenwidth*19/22,userscreenheight*2/10,150,150);
        INT.addActionListener(this);
        frame.add(INT);
        INT.setVisible(false);
        INT.repaint();
        
    }
    
    
     public void set(int current)
   {
       l.setText(strArr[sec][current][1]);
        jb[0].setText(strArr[sec][current][2]);
        jb[1].setText(strArr[sec][current][3]);
        jb[2].setText(strArr[sec][current][4]);
        jb[3].setText(strArr[sec][current][5]);
   }

   public void set1(int current)
   {
       l1.setText(Pra_arr[sec][current1][1]);
   }
    
     public void check(int current)
   {
       if(strArr[sec][this.current][6].equals(strArr[sec][this.current][7]))
       {
           JOptionPane.showMessageDialog(frame, "Correct answer!", "Message", JOptionPane.INFORMATION_MESSAGE);
       }
       else
       {
           JOptionPane.showMessageDialog(frame, "Incorrect answer!", "Message", JOptionPane.INFORMATION_MESSAGE);
       }
   }
    
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==Theory)
       {
        strArr = ControllerClass.Theoryquestions(10);
           l.setVisible(true);
           jb[0].setVisible(true);
           jb[1].setVisible(true);
           jb[2].setVisible(true);
           jb[3].setVisible(true);
           Submit.setVisible(true);
           SS.setVisible(true);
           SU.setVisible(true);
           IO.setVisible(true);
           Sst.setVisible(true);
           IT.setVisible(true);
           Oth.setVisible(true);
           
           l1.setVisible(false);
           b1.setVisible(false);
           wd.setVisible(false);
           Ex.setVisible(false);
           PP.setVisible(false);
           OL.setVisible(false);
           WND.setVisible(false);
           INT.setVisible(false);
       }
       else if(ae.getSource()==Pratical)
       {
           l1.setVisible(true);
           b1.setVisible(true);
           wd.setVisible(true);
           Ex.setVisible(true);
           PP.setVisible(true);
           OL.setVisible(true);
           WND.setVisible(true);
           INT.setVisible(true);
           
           l.setVisible(false);
           jb[0].setVisible(false);
           jb[1].setVisible(false);
           jb[2].setVisible(false);
           jb[3].setVisible(false);
           Submit.setVisible(false);
           SS.setVisible(false);
           SU.setVisible(false);
           IO.setVisible(false);
           Sst.setVisible(false);
           IT.setVisible(false);
           Oth.setVisible(false);
           
           //write set1 to set praticals and add help buttons for both section
       }
       else if(ae.getSource()==b1)
       {
           //run overlay class and perfrom actions according to the questions
           new Overlay(Pra_arr[sec][current1][1]);
       }
       else if(ae.getSource()==Exam)
       {
           //run overlay class and perfrom actions according to the questions
           this.dispose();
           new Theory();
           new Mainpage();
       }

       else if(ae.getSource()==SS)
       {
           sec=4;
           current=0;
           set(current);
       }

       else if(ae.getSource()==SU)
       {
           sec=5;
           current=0;
           set(current);
       }

       else if(ae.getSource()==IO)
       {
           sec=0;
           current=0;
           set(current);
       }

       else if(ae.getSource()==Sst)
       {
           sec=3;
           current=0;
           set(current);
       }

       else if(ae.getSource()==IT)
       {
           sec=1;
           current=0;
           set(current);
       }

       else if(ae.getSource()==Oth)
       {
           sec=2;
           current=0;
           set(current);
       }

       else if(ae.getSource()==wd)
       {
           sec=4;
           current1=0;
           set1(current1);
       }

       else if(ae.getSource()==Ex)
       {
           sec=5;
           current1=0;
           set1(current1);
       }

       else if(ae.getSource()==PP)
       {
           sec=0;
           current1=0;
           set1(current1);
       }

       else if(ae.getSource()==OL)
       {
           sec=3;
           current1=0;
           set1(current1);
       }

       else if(ae.getSource()==WND)
       {
           sec=1;
           current1=0;
           set1(current1);
       }

       else if(ae.getSource()==INT)
       {
           sec=2;
           current1=0;
           set1(current1);
       }
       
    }
    
    public static void main(String[] args) {
        new Mainpage();
    }
    
}
