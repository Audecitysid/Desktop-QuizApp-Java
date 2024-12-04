package quizapp;


import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 

public class Overlay extends JFrame implements ActionListener
{  
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    public int userscreenwidth = screenSize.width;
    public int userscreenheight = screenSize.height;
    JButton cancelButton,submitButton;
    static JFrame frame;
 
    Overlay(String s)  
    {  
        super(s);
        frame = new JFrame("My Frame");
        String que=s;
        JLabel l1=new JLabel(que);
        

            l1.setFont(new Font("System",Font.BOLD,18)); 
           
            JPanel centerPanel = new JPanel();
            centerPanel.add(l1);
            centerPanel.setLayout(new GridLayout(4, 1));
            centerPanel.setBounds(userscreenwidth/150,userscreenheight/120,userscreenwidth*3/4,userscreenheight/10);
            centerPanel.setBackground(Color.WHITE);
            frame.add(centerPanel,BorderLayout.PAGE_START);
         
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(userscreenwidth-150,10, 100, 30);
        cancelButton.addActionListener(this);
        cancelButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cancelButton.setOpaque(true);
        frame.add(cancelButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(userscreenwidth-300,10, 100, 30);
        submitButton.addActionListener(this);
        submitButton.setBorder(BorderFactory.createRaisedBevelBorder());
        submitButton.setOpaque(true);
        frame.add(submitButton);
        
        frame.setLayout(null);
        
        // Set up the frame
        
        frame.setSize(userscreenwidth, userscreenheight/17);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window to fill the entire screen
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(new Color(176, 224, 230));

        frame.setAlwaysOnTop(true);
        frame.setLocation(0, 0);
        frame.setVisible(true); 
    }  
    public static void Closed()
    {
        frame.dispose();
    }
    
  public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==cancelButton)
       {
           frame.dispose();
       }
       if(ae.getSource()==submitButton)
       {
          //save and check current answer
          //current++ and set next que
       }
     
    }
    public static void main(String s[])  
{  
    
    new Overlay("Online Test Of Java");  
    
    
}

}
