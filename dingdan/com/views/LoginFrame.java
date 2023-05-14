/*
 * Created by JFormDesigner on Wed Apr 21 23:32:00 CST 2021
 */

package dingdan.com.views;

import dingdan.com.utils.JDBCUtils;
import dingdan.com.views.Role.RoleUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class LoginFrame extends JFrame {
    public LoginFrame() {
        super("订单管理系统-用户登录界面");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();

        button3.setContentAreaFilled(false) ;
        button4.setContentAreaFilled(false) ;
        textField1.setOpaque(false);
        passwordField1.setOpaque(false);
    }


    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        this.setVisible(false);
        RegisterFrame rg = new RegisterFrame();
        rg.setVisible(true);
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String id = textField1.getText();
        String passwd = new String(passwordField1.getPassword());
        String sql1 = "select *from administrator where username='"+id+"' and password='"+passwd+"'";
        ResultSet rs = jdbcUtils.getResultSet(sql1);
        try{
            if(rs.next()){
                System.out.println("登录成功！");
                this.setVisible(false);
                new RoleUI();
            }
            else{
                JOptionPane.showMessageDialog(null,"登录失败，请重新输入账号密码！");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button3 = new JButton();
        button4 = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(250, 160, 315, 35);
        contentPane.add(passwordField1);
        passwordField1.setBounds(250, 255, 315, 35);

        //---- button3 ----
        button3.setText("\u6ce8\u518c");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 7f));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(455, 335, 105, 40);

        //---- button4 ----
        button4.setText("\u767b\u5f55");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 7f));
        button4.setBackground(UIManager.getColor("Button.background"));
        button4.addActionListener(e -> button4ActionPerformed(e));
        contentPane.add(button4);
        button4.setBounds(255, 335, 105, 40);

        //---- label3 ----
        label3.setText("\u8d26\u53f7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        label3.setBackground(Color.white);
        contentPane.add(label3);
        label3.setBounds(170, 145, 90, 60);

        //---- label4 ----
        label4.setText("\u5bc6\u7801\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
        contentPane.add(label4);
        label4.setBounds(175, 245, 90, 60);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(765, 565);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button3;
    private JButton button4;
    private JLabel label3;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private JDBCUtils jdbcUtils;

}
