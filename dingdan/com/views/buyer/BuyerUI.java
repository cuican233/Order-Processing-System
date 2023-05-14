/*
 * Created by JFormDesigner on Tue Jun 22 09:31:10 CST 2021
 */

package dingdan.com.views.buyer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class BuyerUI extends JFrame {
    private CardLayout cardLayout = null;
    public BuyerUI() {
        super("订单管理系统-买家操作界面");
        initComponents();
        setVisible(true);
        cardLayout = new CardLayout();
        panel1.setLayout(cardLayout);
        Buyerdingdan buyerdingdan = new Buyerdingdan();
        panel1.add(buyerdingdan,"buyerdingdan");
        buyerdingdan.setOpaque(false);
        buyerdingdan.setBackground(null);
        panel1.setOpaque(false);
        panel1.setBackground(null);
        button3.setContentAreaFilled(false) ;
        button4.setContentAreaFilled(false) ;
        button1.setContentAreaFilled(false) ;
    }


    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here

        cardLayout.show(panel1,"buyerdingdan");

    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        new DingdanselectUI();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        new GoodsselectUI();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button3 = new JButton();
        panel1 = new JPanel();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u5546\u54c1\u4fe1\u606f\u67e5\u8be2");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(40, 90, 165, 50);

        //---- button3 ----
        button3.setText("\u67e5\u8be2\u8ba2\u5355");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 5f));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(40, 360, 165, 50);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(205, 0, 560, 535);

        //---- button4 ----
        button4.setText("\u4e0b\u8ba2\u5355");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 5f));
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });
        contentPane.add(button4);
        button4.setBounds(40, 225, 165, 50);

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
    private JPanel panel1;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new BuyerUI();
    }
}
