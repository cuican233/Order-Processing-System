/*
 * Created by JFormDesigner on Mon Jun 21 10:36:13 CST 2021
 */

package dingdan.com.views.guanliyuan.shangjiaxinxi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class shangjiaxinxi extends JFrame {
    private CardLayout cardLayout = null;
    public shangjiaxinxi() {
        super("订单管理系统-商家信息管理界面");
        initComponents();
        setVisible(true);
        cardLayout = new CardLayout();
        panel2.setLayout(cardLayout);
        P1 p1 = new P1();
        P2 p2 = new P2();
        P3 p3 = new P3();


        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);

        p1.setBackground(null);
        p2.setBackground(null);
        p3.setBackground(null);

        panel2.add(p1,"p1");
        panel2.add(p2,"p2");
        panel2.add(p3,"p3");

        panel1.setOpaque(false);
        panel1.setBackground(null);
        panel2.setOpaque(false);
        panel2.setBackground(null);

        button1.setContentAreaFilled(false) ;
        button2.setContentAreaFilled(false) ;
        button3.setContentAreaFilled(false) ;
        button4.setContentAreaFilled(false) ;
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        cardLayout.show(panel2,"p1");
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        cardLayout.show(panel2,"p2");
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        cardLayout.show(panel2,"p3");
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        new ShangjiaSelectUI();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        panel2 = new JPanel();

        //======== this ========
        JLayeredPane layer2;
        layer2 = new JLayeredPane() {
            public void paintComponent(Graphics g) {//重写绘制面板的方法
                super.paintComponent(g);
                ImageIcon image = new ImageIcon("D:\\workspace\\src\\dingdan\\CC.jpg");
                image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
                g.drawImage(image.getImage(), 0, 0, this); //重新绘制面板
            }
        };
        this.add(layer2);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- button1 ----
            button1.setText("\u589e\u52a0\u5546\u5bb6\u4fe1\u606f");
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(15, 55, 155, 55);

            //---- button2 ----
            button2.setText("\u5220\u9664\u5546\u5bb6\u4fe1\u606f");
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            panel1.add(button2);
            button2.setBounds(15, 180, 155, 55);

            //---- button3 ----
            button3.setText("\u4fee\u6539\u5546\u5bb6\u4fe1\u606f");
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 5f));
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            panel1.add(button3);
            button3.setBounds(15, 305, 155, 55);

            //---- button4 ----
            button4.setText("\u67e5\u8be2\u5546\u5bb6\u4fe1\u606f");
            button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 5f));
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                }
            });
            panel1.add(button4);
            button4.setBounds(15, 430, 155, 55);

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
        layer2.add(panel1);
        panel1.setBounds(0, 0, 170, 535);

        //======== panel2 ========
        {
            panel2.setLayout(null);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        layer2.add(panel2);
        panel2.setBounds(170, 0, 595, 535);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < layer2.getComponentCount(); i++) {
                Rectangle bounds = layer2.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = layer2.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            layer2.setMinimumSize(preferredSize);
            layer2.setPreferredSize(preferredSize);
        }
        setSize(765, 565);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new shangjiaxinxi();
    }
}
