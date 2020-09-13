package client.gui.frame;

import AppPackage.AnimationClass;
import client.controller.PictureController;
import client.gui.label.LoginPage;
import client.gui.label.RegisterPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainFrame extends JFrame {

    private final int width = 1200;
    private final int height = 800;
    private int posX = 0, posY =0;
    private JPanel mainPanel;
    private JLabel backgroundLabel;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    private ScheduledExecutorService randomPicture = Executors.newSingleThreadScheduledExecutor();
    private static AnimationClass slideEfect = new AnimationClass();



    public MainFrame(){

        initFrame();
        initBackgroundLabel();
        mouseListener();
        initLoginPage();
        initRegisterPage();



        setVisible(true);



    }


    private void initFrame(){
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        mainPanel = new JPanel();
        mainPanel.setSize(width,height);
        mainPanel.setLayout(null);
        this.add(mainPanel);
    }

    private void initBackgroundLabel(){
        backgroundLabel = new JLabel();
        backgroundLabel.setSize(width, height);
        scheduleWithFixedDelay();



        mainPanel.add(backgroundLabel);

    }

    private void initLoginPage(){
        loginPage = new LoginPage(-300,0,1200,800);
        backgroundLabel.add(loginPage);
    }

    private void initRegisterPage(){
        registerPage = new RegisterPage(300,0,1200,800);
        backgroundLabel.add(registerPage);
    }

    //method 1
    private void scheduleWithFixedDelay(){
        Runnable task = () -> backgroundLabel.setIcon(getImageIcon());
        randomPicture.scheduleWithFixedDelay(task,0,10, TimeUnit.SECONDS);
    }

    // method 2
    private ImageIcon getImageIcon(){
        byte [] image = PictureController.getInstance().getPicture().getPicture();

        Image rescaleImage = new ImageIcon(image).getImage()
                .getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(rescaleImage);
    }














    private void mouseListener() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {

                setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);
            }
        });
    }

}