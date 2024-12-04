
package quizapp;

import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

public class Theory extends JFrame implements ActionListener{

    String[][] strArr = {{"Que1: Which one among these is not a primitive datatype?", "A)int", "B)Float","C)Boolean","D)Char","1"},{"Que2: Which class is available to all the class automatically?","A)Swing","B)Applet","C)Object","D)ActionEvent","3"}};
    String Pra_arr[]={"Que1: Question no 1 is to be display?","Que2: Question no 2 is to be display?"};
    JButton END,Pratical,Objective,Pratical1,Objective1,Pratical2,Objective2,Next,Previous;
    JLabel l,l1,l2,l3,l4;
    JButton b1;
    JRadioButton jb[]=new JRadioButton[4];    
    ButtonGroup bg;
    public int userscreenwidth,userscreenheight;
    int current=0;
    int current2=0;
    JFrame frame;
    public Timer timer;
    public int timeLeft = 1800;
    JLabel timerLabel;
    String [] ans=new String[2];
    
    Theory()
    {
        frame = new JFrame("My Frame");
        frame.setLayout(null);
        frame.setTitle("ExamPage");
        
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window to fill the entire screen
        frame.setAlwaysOnTop(true);
        
         userscreenwidth = screenSize.width;
         userscreenheight = screenSize.height;
         
         ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/User.jpeg"));
        Image i11=i10.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i12=new ImageIcon(i11);
        JLabel label5=new JLabel(i12);
        label5.setBounds(userscreenwidth*1/200,userscreenheight*7/200,200,200);
        frame.add(label5); 
        
        String name="Prathamesh Sanjay Mandave";
        JLabel l5=new JLabel("Candidate's Name:");
        l5.setFont(new Font("System",Font.BOLD,22));
        l5.setBounds(20,20,50,25);
        JLabel Name=new JLabel(name);
       // l1.setBounds(10,10,20,20);
        Name.setFont(new Font("System",Font.BOLD,18));
   
        String name2="1956";
        JLabel l6=new JLabel("Application Number:");
        l6.setFont(new Font("System",Font.BOLD,22));
        JLabel Name2=new JLabel(name2);
        Name2.setFont(new Font("System",Font.BOLD,18));
        
        JPanel centerPanel = new JPanel();
            
            centerPanel.add(l5);
            centerPanel.add(Name);
            
            centerPanel.add(l6);
            centerPanel.add(Name2);
           
            
            centerPanel.setBackground(new Color(200, 220, 240));
            centerPanel.setLayout(new GridLayout(2, 2));
            centerPanel.setBounds(userscreenwidth*2/20,userscreenheight/18,600,150);
            frame.add(centerPanel,BorderLayout.PAGE_START);
        
        Next=new JButton("Next");
        Next.setBounds(userscreenwidth*19/100,(userscreenheight*3)/4, 100, 30);
        Next.setFont(new Font("Arial", Font.PLAIN, 24));
        Next.addActionListener(this);
        Next.setBorder(BorderFactory.createRaisedBevelBorder());
        Next.setOpaque(true);
        
        frame.add(Next);
        
        Next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Next.setBackground(new Color(220, 240, 220));
                Next.setForeground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Next.setBackground(UIManager.getColor("Button.background"));
                Next.setForeground(UIManager.getColor("Button.foreground"));
            }
        });
        
        Previous=new JButton("Previous");
        Previous.setBounds(userscreenwidth/10,(userscreenheight*3)/4, 100, 30);
        Previous.setFont(new Font("Arial", Font.PLAIN, 24));
        Previous.addActionListener(this);
        Previous.setBorder(BorderFactory.createRaisedBevelBorder());
        Previous.setOpaque(true);
        frame.add(Previous);
        
        Previous.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Previous.setBackground(new Color(220, 240, 220));
                Previous.setForeground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Previous.setBackground(UIManager.getColor("Button.background"));
                Previous.setForeground(UIManager.getColor("Button.foreground"));
            }
            
            public void mouseClicked(MouseEvent e)
            {
                
            }
        });
        
        END=new JButton("END EXAMINATION");
        END.setBounds(userscreenwidth*80/100,(userscreenheight*85)/100, 250, 30);
        END.setFont(new Font("Arial", Font.PLAIN, 24));
        END.setBackground(new Color(255, 200, 200));
        END.setForeground(Color.BLACK);
        END.addActionListener(this);
        END.setBorder(BorderFactory.createRaisedBevelBorder());
        END.setOpaque(true);
        //END.setContentAreaFilled(false);
        //END.setPaint(gradient);
        frame.add(END);
        
        timerLabel = new JLabel("Time left: " + getTimeString(timeLeft)+"!!!");
        timerLabel.setBounds(userscreenwidth*30/36,(userscreenheight)*73/200,200,100);
        timerLabel.setForeground(Color.red);
        timerLabel.setFont(new Font("System",Font.BOLD,20));
        frame.add(timerLabel);
        
        ImageIcon i25=new ImageIcon(ClassLoader.getSystemResource("icons/clock.png"));
        Image i26=i25.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i27=new ImageIcon(i26);
        JLabel label28=new JLabel(i27);
        label28.setBounds(userscreenwidth*61/72,userscreenheight*31/100,100,100);
        frame.add(label28); 
        
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time left: " + getTimeString(timeLeft)+"!!!");
                if (timeLeft == 0) {
                    dispose();
                }
            }
        });
        timer.start();
       
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
        
        l1=new JLabel();
            l1.setFont(new Font("System",Font.BOLD,20));
            l1.setBounds(userscreenwidth*1/10,userscreenheight*39/100,1600,50);
            l1.setText(Pra_arr[0]);
            frame.add(l1);
            l1.setVisible(false);
        
        Objective=new JButton("Objective");
        Objective.setBounds(userscreenwidth*55/800,(userscreenheight)*53/200, 225, 50);
        Objective.setFont(new Font("Arial", Font.PLAIN, 20));
        Objective.setBackground(new Color(255, 200, 200));
        Objective.setForeground(Color.red);
        Objective.addActionListener(this);
        Objective.setBackground(new Color(255, 200, 200));
        Objective.setForeground(Color.red);
        Objective.setBorder(BorderFactory.createRaisedBevelBorder());
        Objective.setOpaque(true);
        frame.add(Objective);
    
        Pratical=new JButton("Pratical");
        Pratical.setBounds(userscreenwidth*159/800,(userscreenheight)*53/200, 225, 50);
        Pratical.setFont(new Font("Arial", Font.PLAIN, 20));
        Pratical.setBackground(new Color(176, 224, 230));
        Pratical.setForeground(Color.BLACK);;
        Pratical.addActionListener(this);
        Pratical.setBorder(BorderFactory.createRaisedBevelBorder());
        Pratical.setOpaque(true);
        frame.add(Pratical);
        
        l2=new JLabel("Level 1:Easy");
            l2.setFont(new Font("System",Font.BOLD,20));
            l2.setBounds(userscreenwidth*125/800,userscreenheight*44/200,1600,50);
            frame.add(l2);
        /*
        Pratical.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Pratical.setBackground(new Color(255, 200, 200));
                Pratical.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Pratical.setBackground(UIManager.getColor("Button.background"));
                Pratical.setForeground(UIManager.getColor("Button.foreground"));
            }
        });
        */
        
        Objective1=new JButton("Objective");
        Objective1.setBounds(userscreenwidth*309/800,(userscreenheight)*53/200, 225, 50);
        Objective1.setFont(new Font("Arial", Font.PLAIN, 20));
        Objective1.setBackground(new Color(176, 224, 230));
        Objective1.setForeground(Color.BLACK);
        Objective1.addActionListener(this);
        Objective1.setBorder(BorderFactory.createRaisedBevelBorder());
        Objective1.setOpaque(true);
        frame.add(Objective1);
        
        Pratical1=new JButton("Pratical");
        Pratical1.setBounds(userscreenwidth*415/800,(userscreenheight)*53/200, 225, 50);
        Pratical1.setFont(new Font("Arial", Font.PLAIN, 20));
        Pratical1.setBackground(new Color(176, 224, 230));
        Pratical1.setForeground(Color.BLACK);
        Pratical1.addActionListener(this);
        Pratical1.setBorder(BorderFactory.createRaisedBevelBorder());
        Pratical1.setOpaque(true);
        frame.add(Pratical1);
        
        l3=new JLabel("Level 2:MEDIUM");
            l3.setFont(new Font("System",Font.BOLD,20));
            l3.setBounds(userscreenwidth*380/800,userscreenheight*44/200,1600,50);
            frame.add(l3);
        
        Objective2=new JButton("Objective");
        Objective2.setBounds(userscreenwidth*565/800,(userscreenheight)*53/200, 225, 50);
        Objective2.setFont(new Font("Arial", Font.PLAIN, 20));
        Objective2.setBackground(new Color(176, 224, 230));
        Objective2.setForeground(Color.BLACK);
        Objective2.addActionListener(this);
        Objective2.setBorder(BorderFactory.createRaisedBevelBorder());
        Objective2.setOpaque(true);
        frame.add(Objective2);
        
        Pratical2=new JButton("Pratical");
        Pratical2.setBounds(userscreenwidth*675/800,(userscreenheight)*53/200, 225, 50);
        Pratical2.setFont(new Font("Arial", Font.PLAIN, 20));
        Pratical2.setBackground(new Color(176, 224, 230));
        Pratical2.setForeground(Color.BLACK);
        Pratical2.addActionListener(this);
        Pratical2.setBorder(BorderFactory.createRaisedBevelBorder());
        Pratical2.setOpaque(true);
        frame.add(Pratical2);
        
        l4=new JLabel("Level 3:HARD");
            l4.setFont(new Font("System",Font.BOLD,20));
            l4.setBounds(userscreenwidth*640/800,userscreenheight*44/200,1600,50);
            frame.add(l4);
        
        l=new JLabel();
            l.setFont(new Font("System",Font.BOLD,20));
            l.setBounds(userscreenwidth*1/10,userscreenheight*39/100,1600,50);
            frame.add(l); 
            bg=new ButtonGroup();  
        
        for(int i=0;i<4;i++)  
        {  
            jb[i]=new JRadioButton(); 
            jb[i].setFont(new Font("System",Font.BOLD,18));
            bg.add(jb[i]);  
        }
         
        
        l.setText(strArr[current][0]);
        jb[0].setText(strArr[current][1]);
        jb[1].setText(strArr[current][2]);
        jb[2].setText(strArr[current][3]);
        jb[3].setText(strArr[current][4]);
        
        
        jb[0].setBounds(userscreenwidth*1/10,userscreenheight*45/100,500,50);
           // add(jb[0]);
        jb[1].setBounds(userscreenwidth*1/10,userscreenheight*50/100,500,50);
           // add(jb[1]);
        jb[2].setBounds(userscreenwidth*1/10,userscreenheight*55/100,500,50);
          //  add(jb[2]);
        jb[3].setBounds(userscreenwidth*1/10,userscreenheight*60/100,500,50);
           // add(jb[3]);
           frame.add(jb[0]); 
           frame.add(jb[1]); 
           frame.add(jb[2]); 
           frame.add(jb[3]);
        
        frame.setVisible(true);
        frame.setLocation(0,0);
    }
    
     public void set(int current)
   {
       l.setText(strArr[current][0]);
        jb[0].setText(strArr[current][1]);
        jb[1].setText(strArr[current][2]);
        jb[2].setText(strArr[current][3]);
        jb[3].setText(strArr[current][4]);
   }
    public void set2(int current2)
    {
        l.setText(Pra_arr[current2]);
    }
     public void check(int current)
   {
       if(ans[this.current].equals(strArr[this.current][5]))
       {
           JOptionPane.showMessageDialog(frame, "Correct answer!", "Message", JOptionPane.INFORMATION_MESSAGE);
       }
       else
       {
           JOptionPane.showMessageDialog(frame, "Incorrect answer!", "Message", JOptionPane.INFORMATION_MESSAGE);
       }
   }
    
     public String getTimeString(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
        }
     
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Next)
        {
            if (jb[0].isSelected()) {
                ans[current]="1";
                
            } else if (jb[1].isSelected()) {
                ans[current]="2";
                
            } else if (jb[2].isSelected()) {
                ans[current]="3";
                
            } else if(jb[3].isSelected()) {
                ans[current]="4";
  
            }
            check(current);
            current++;
            set(current);
            bg.clearSelection();
            
        }
        //Need to write for previous button also
        else if(ae.getSource()==b1)
        {
            l1.setText(Pra_arr[current]);
            new Overlay(Pra_arr[current]);
        }
        else if(ae.getSource()==Objective)
        {
            //fetch level 1 objective question from csv to array and set that questions
           Objective.setBackground(new Color(255, 200, 200));
           Objective.setForeground(Color.red);
           
           l1.setVisible(false);
           b1.setVisible(false);
           
           l.setVisible(true);
           jb[0].setVisible(true);
           jb[1].setVisible(true);
           jb[2].setVisible(true);
           jb[3].setVisible(true);
           
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
        }
        else if(ae.getSource()==Pratical)
        {
           //set2(current2);
           current2++;
           Pratical.setBackground(new Color(255, 200, 200));
           Pratical.setForeground(Color.red);
           
           l1.setVisible(true);
           b1.setVisible(true);
           
           l.setVisible(false);
           jb[0].setVisible(false);
           jb[1].setVisible(false);
           jb[2].setVisible(false);
           jb[3].setVisible(false);
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        
        else if(ae.getSource()==Objective1)
        {
           //set2(current2);
           current2++;
           Objective1.setBackground(new Color(255, 200, 200));
           Objective1.setForeground(Color.red);
           
           l1.setVisible(false);
           b1.setVisible(false);
           
           l.setVisible(true);
           jb[0].setVisible(true);
           jb[1].setVisible(true);
           jb[2].setVisible(true);
           jb[3].setVisible(true);
           
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        
        else if(ae.getSource()==Pratical1)
        {
           //set2(current2);
           current2++;
           Pratical1.setBackground(new Color(255, 200, 200));
           Pratical1.setForeground(Color.red);
           
           l1.setVisible(true);
           b1.setVisible(true);
           
           l.setVisible(false);
           jb[0].setVisible(false);
           jb[1].setVisible(false);
           jb[2].setVisible(false);
           jb[3].setVisible(false);
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        
        else if(ae.getSource()==Objective2)
        {
          // set2(current2);
           current2++;
           Objective2.setBackground(new Color(255, 200, 200));
           Objective2.setForeground(Color.red);
           
           l1.setVisible(false);
           b1.setVisible(false);
           
           l.setVisible(true);
           jb[0].setVisible(true);
           jb[1].setVisible(true);
           jb[2].setVisible(true);
           jb[3].setVisible(true);
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        
        else if(ae.getSource()==Pratical2)
        {
          // set2(current2);
           current2++;
           Pratical2.setBackground(new Color(255, 200, 200));
           Pratical2.setForeground(Color.red);
           
           l1.setVisible(true);
           b1.setVisible(true);
           
           l.setVisible(false);
           jb[0].setVisible(false);
           jb[1].setVisible(false);
           jb[2].setVisible(false);
           jb[3].setVisible(false);
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        else if(ae.getSource()==END)
        {
            frame.dispose();
        }
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Theory();
    }
    
}
