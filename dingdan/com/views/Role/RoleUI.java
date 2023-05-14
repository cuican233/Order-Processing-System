/*
 * Created by JFormDesigner on Fri Jun 18 10:07:21 CST 2021
 */

package dingdan.com.views.Role;

import java.awt.event.*;

import dingdan.com.utils.JDBCUtils;
import dingdan.com.views.buyer.BuyerUI;
import dingdan.com.views.saler.SalerUI;

import java.awt.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class RoleUI extends JFrame {
    private CardLayout cardLayout = null;
    public RoleUI() {
        super("订单管理系统-角色管理界面");
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        cardLayout = new CardLayout();
        panel1.setLayout(cardLayout);
        Buyer buyer = new Buyer();
        Business business = new Business();
        Guanliyuan guanliyuan = new Guanliyuan();


        buyer.setOpaque(false);
        business.setOpaque(false);
        guanliyuan.setOpaque(false);

        buyer.setBackground(null);
        business.setBackground(null);
        guanliyuan.setBackground(null);

        panel1.add(buyer,"buyer");
        panel1.add(business,"business");
        panel1.add(guanliyuan,"guanliyuan");

        panel1.setOpaque(false);
        panel1.setBackground(null);

        button1.setContentAreaFilled(false) ;
        button2.setContentAreaFilled(false) ;
        button3.setContentAreaFilled(false) ;
        button4.setContentAreaFilled(false) ;
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        cardLayout.show(panel1,"guanliyuan");
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        new BuyerUI();
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        new SalerUI();
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        JOptionPane.showMessageDialog(null, "感谢使用订单管理系统！");
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button3 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u6211\u662f\u4e70\u5bb6");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(40, 80, 165, 50);

        //---- button3 ----
        button3.setText("\u6211\u662f\u7cfb\u7edf\u7ba1\u7406\u5458");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 5f));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(40, 290, 165, 50);

        //---- button2 ----
        button2.setText("\u6211\u662f\u5546\u5bb6");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(40, 185, 165, 50);

        //---- button4 ----
        button4.setText("\u9000\u51fa\u7cfb\u7edf");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 5f));
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });
        contentPane.add(button4);
        button4.setBounds(40, 395, 165, 50);

        //======== panel1 ========
        {
            panel1.setLayout(new CardLayout());
        }
        contentPane.add(panel1);
        panel1.setBounds(210, 0, 555, 535);

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
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JButton button4;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private JDBCUtils jdbcUtils;

    public static void main(String[] args) {
        new RoleUI();
    }
}
