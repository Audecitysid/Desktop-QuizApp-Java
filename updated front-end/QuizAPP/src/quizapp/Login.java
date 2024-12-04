/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quizapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.image.ImageObserver.*;



public class Login extends JFrame implements ActionListener {
    

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    public int userscreenwidth = screenSize.width;
    public int userscreenheight = screenSize.height;
        
    
    JButton Login,Signup;
    JTextField cardnotextfield;
    JTextField pinnotextfield;
    
    
    Login()
    {

        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JLabel Text=new JLabel("Quiz Application");
        Text.setBounds(250, 20, 600, 100);
        Text.setFont(new Font("osward",Font.BOLD,38));
        add(Text);
        
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("/src/quizapp/images/user_image.png");
        imageLabel.setIcon(imageIcon);
        imageLabel.setBounds(userscreenwidth/3, userscreenheight/3, 100, 100);
        getContentPane().add(imageLabel);
        
        JLabel CardNo=new JLabel("UserName:");
        CardNo.setBounds(200, 220, 150, 30);
        CardNo.setFont(new Font("osward",Font.BOLD,25));
        add(CardNo);
        
        JLabel PinNo=new JLabel("Password:");
        PinNo.setBounds(200, 280, 150, 30);
        PinNo.setFont(new Font("osward",Font.BOLD,25));
        add(PinNo);
        
        cardnotextfield=new JTextField();
        cardnotextfield.setBounds(350,220,250,30);
        add(cardnotextfield);
        
        pinnotextfield=new JTextField();
        pinnotextfield.setBounds(350,280,250,30);
        add(pinnotextfield);
        
        Login=new JButton("Login");
        Login.setBounds(350,350,100,30);
        Login.addActionListener(this);
        add(Login);
        
        Login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Login.setBackground(Color.BLUE);
                Login.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Login.setBackground(UIManager.getColor("Button.background"));
                Login.setForeground(UIManager.getColor("Button.foreground"));
            }
        });
        
        Signup=new JButton("Signup");
        Signup.setBounds(500,350,100,30);
        Signup.addActionListener(this);
        add(Signup);
        
        Signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Signup.setBackground(Color.BLUE);
                Signup.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Signup.setBackground(UIManager.getColor("Button.background"));
                Signup.setForeground(UIManager.getColor("Button.foreground"));
            }
        });
        
        setTitle("Quiz Application");
        setSize(800,480);
        setVisible(true);
        setLocation(450,200);
         
        
        
    }
    
    private void openLinkInChrome() {
        try {
            
            URI uri = new URI("https://www.example.com");              // url of the signup website
            
            
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void close()
    {
        WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==Login)
        {
            dispose();
            new Mainpage();
            /*
            //remaaining
            String entered_username = cardnotextfield.getText();
            String entered_password = pinnotextfield.getText();

            int Status_Code = ControllerClass.UserValidity(entered_username, entered_password);
            
                /*
                Status codes :
                
                #status code 3 - internet connectivity required
                #status code 4 - username or password is incorrect
                #status code 5 - incorrect system date and time
                #status code 6 - your subscription has expired connect to the internet
                #status code 10 - successfull login // open the main page

                 */
                
                
                    

            





            
            // conditions for when the text  is fetched to be removed 
            // add api calls here
            /*
            if(username.equals("") && password.equals(""))
            {
                dispose();
                JOptionPane.showMessageDialog(null, "Logged In sucessfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
                Mainpage();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect Login credentials!!!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            */

            
          
            
        }
        else if(ae.getSource()==Signup)
        {
             
            openLinkInChrome();
            //connect to service
            
        }
    }

    
    
    public static void main(String args[]) {
       
        Login l1=new Login();
        //l1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
    }
}

