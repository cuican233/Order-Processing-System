/*
 * Created by JFormDesigner on Tue Jun 22 11:48:51 CST 2021
 */

package dingdan.com.views.saler.goods;

import java.awt.event.*;
import dingdan.com.utils.JDBCUtils;
import dingdan.com.views.saler.Jinhuo;

import java.awt.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class GoodsUI extends JFrame {
    private CardLayout cardLayout = null;
    private JDBCUtils jdbcUtils;
    public GoodsUI() {
        super("订单管理系统-商家商品查询界面");
        initComponents();
        this.setVisible(true);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        cardLayout = new CardLayout();
        panel1.setLayout(cardLayout);
        goodsAdd goodsAdd = new goodsAdd();
        goodsdelete goodsdelete = new goodsdelete();
        goodsupdate goodsupdate = new goodsupdate();

        goodsAdd.setOpaque(false);
        goodsAdd.setBackground(null);
        panel1.add(goodsAdd,"goodsAdd");

        goodsdelete.setOpaque(false);
        goodsdelete.setBackground(null);
        panel1.add(goodsdelete,"goodsdelete");

        goodsupdate.setOpaque(false);
        goodsupdate.setBackground(null);
        panel1.add(goodsupdate,"goodsupdate");

        panel1.setOpaque(false);
        panel1.setBackground(null);
        button2.setContentAreaFilled(false) ;
        button1.setContentAreaFilled(false) ;
        button3.setContentAreaFilled(false) ;
        button4.setContentAreaFilled(false) ;
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        cardLayout.show(panel1,"goodsAdd");
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        cardLayout.show(panel1,"goodsdelete");
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        cardLayout.show(panel1,"goodsupdate");
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        new goodsselect();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        panel1 = new JPanel();

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

        //---- button1 ----
        button1.setText("\u589e\u52a0\u5546\u54c1\u4fe1\u606f");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        layer2.add(button1);
        button1.setBounds(40, 80, 165, 50);

        //---- button2 ----
        button2.setText("\u5220\u9664\u5546\u54c1\u4fe1\u606f");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        layer2.add(button2);
        button2.setBounds(40, 185, 165, 50);

        //---- button3 ----
        button3.setText("\u4fee\u6539\u5546\u54c1\u4fe1\u606f");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 5f));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        layer2.add(button3);
        button3.setBounds(40, 290, 165, 50);

        //---- button4 ----
        button4.setText("\u67e5\u8be2\u5546\u54c1\u4fe1\u606f");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 5f));
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });
        layer2.add(button4);
        button4.setBounds(40, 395, 165, 50);

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
        layer2.add(panel1);
        panel1.setBounds(205, 0, 560, 535);

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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
