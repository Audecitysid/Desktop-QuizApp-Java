
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
    
    Overlay(String s)  
    {  
        super(s); 
        String que=s;
        JLabel l1=new JLabel(que);
        

            l1.setFont(new Font("System",Font.BOLD,22)); 
           
            JPanel centerPanel = new JPanel();
            centerPanel.add(l1);
            centerPanel.setLayout(new GridLayout(4, 1));
            centerPanel.setBounds(userscreenwidth/150,userscreenheight/120,1200,300);
            centerPanel.setBackground(Color.WHITE);
            add(centerPanel,BorderLayout.PAGE_START);
         
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(userscreenwidth-150,userscreenheight/45, 100, 40);
        cancelButton.addActionListener(this);
        cancelButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cancelButton.setOpaque(true);
        add(cancelButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(userscreenwidth-300,userscreenheight/45, 100, 40);
        submitButton.addActionListener(this);
        submitButton.setBorder(BorderFactory.createRaisedBevelBorder());
        submitButton.setOpaque(true);
        add(submitButton);
        
        setLayout(null);
        
        // Set up the frame
        
        setSize(userscreenwidth, 70);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window to fill the entire screen
        setUndecorated(true);
        getContentPane().setBackground(new Color(176, 224, 230));

        setAlwaysOnTop(true);
        setLocation(0, 0);
        setVisible(true); 
    }  
    
  public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==cancelButton)
       {
           dispose();
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
