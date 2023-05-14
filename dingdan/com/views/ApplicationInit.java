package dingdan.com.views;

import javax.swing.*;
public class ApplicationInit {
    public static void main(String[] args) {
        RegisterFrame RegisterFrame = new RegisterFrame();
        LoginFrame LoginFrame = new LoginFrame();
        LoginFrame.setVisible(true);
        LoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        RegisterFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}