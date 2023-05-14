/*
 * Created by JFormDesigner on Wed Apr 21 22:04:55 CST 2021
 */

package dingdan.com.views;


import dingdan.com.utils.JDBCUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        super("订单管理系统-用户注册页面");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        button1.setContentAreaFilled(false) ;
        textField1.setOpaque(false);
        passwordField1.setOpaque(false);
        passwordField2.setOpaque(false);

    }

        private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("注册按钮点击...");
        String id = textField1.getText();
        String pwd = new String(passwordField1.getPassword());
        String confirm = new String(passwordField2.getPassword());
        LoginFrame lg = new LoginFrame();
        if (id != null && pwd != null && confirm != null) {
            if (!pwd.equals(confirm)) {
                JOptionPane.showMessageDialog(null,"两次输入不一致！");
            } else {
                String sql1 = "select * from administrator where username='" + id + "'";
                ResultSet rs1 = jdbcUtils.getResultSet(sql1);
                try {
                    if (rs1.next()) {
                        System.out.println("用户已存在！");
                        JOptionPane.showMessageDialog(null,"您注册的用户账号已存在，请重新输入！");
                    } else {
                        String sql2 = "insert into administrator values('" + id + "','" + pwd + "')";
                        int update = jdbcUtils.update(sql2);
                        if (update > 0) {
                            System.out.println("注册成功！");
                            JOptionPane.showMessageDialog(null,"注册成功！");
                            this.setVisible(false);
                            lg.setVisible(true);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        label3 = new JLabel();
        passwordField2 = new JPasswordField();
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        contentPane.add(label2);
        label2.setBounds(205, 190, 125, 75);
        contentPane.add(textField1);
        textField1.setBounds(295, 110, 315, 35);
        contentPane.add(passwordField1);
        passwordField1.setBounds(295, 300, 315, 35);

        //---- button1 ----
        button1.setText("\u6ce8\u518c");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(405, 370, 110, 35);

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        contentPane.add(label3);
        label3.setBounds(175, 280, 125, 75);
        contentPane.add(passwordField2);
        passwordField2.setBounds(295, 205, 315, 35);

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        contentPane.add(label1);
        label1.setBounds(200, 90, 125, 75);

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
        setSize(770, 565);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label2;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JLabel label3;
    private JPasswordField passwordField2;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables




    private JDBCUtils jdbcUtils;

    
}