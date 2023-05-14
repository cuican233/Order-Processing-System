/*
 * Created by JFormDesigner on Tue Jun 22 15:07:46 CST 2021
 */

package dingdan.com.views.saler.goods;

import java.awt.event.*;
import com.oo.utils.jdbcUtils;
import dingdan.com.utils.JDBCUtils;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class goodsselect extends JFrame {
    public goodsselect() {
        super("订单管理系统-商家库存管理界面");
        initComponents();
        setVisible(true);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        panel1.setOpaque(false);
        panel1.setBackground(null);
        scrollPane1.setOpaque(false);
        scrollPane1.setBackground(null);
        scrollPane1.getViewport().setOpaque(false);
        button2.setContentAreaFilled(false) ;
        button1.setContentAreaFilled(false) ;
        textField1.setOpaque(false);
        table1.setOpaque(false);
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        Vector rowDate, columnNames;
        columnNames = new Vector();
        columnNames.add("商品名称");
        columnNames.add("价格");
        columnNames.add("商品类型");
        columnNames.add("库存数量");
        rowDate = new Vector();
        try {
            jdbcUtils = new JDBCUtils();
            jdbcUtils.connect();
            String sql = "SELECT *FROM goods";
            ResultSet rs = jdbcUtils.getResultSet(sql);
            while (rs.next()) {
                Vector hang = new Vector();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                hang.add(rs.getString(4));
                rowDate.add(hang);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DefaultTableModel model = new DefaultTableModel(rowDate,columnNames);
        table1.setModel(model);
        table1.setRowHeight(30);
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here

        Vector rowDate, columnNames;
        String goodsname = textField1.getText();
        columnNames = new Vector();
        columnNames.add("商品名称");
        columnNames.add("价格");
        columnNames.add("商品类型");
        columnNames.add("库存数量");
        rowDate = new Vector();

        try {
            jdbcUtils = new JDBCUtils();
            jdbcUtils.connect();
            String sql = "SELECT *FROM goods where goodsname ='" + goodsname + "'";
            ResultSet rs = jdbcUtils.getResultSet(sql);
            if (rs.next()) {
                Vector hang = new Vector();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                hang.add(rs.getString(4));
                rowDate.add(hang);
            }
        } catch (SQLException d) {
            d.printStackTrace();
        }
        DefaultTableModel model = new DefaultTableModel(rowDate,columnNames);
        table1.setModel(model);
        table1.setRowHeight(30);
    }
    private JDBCUtils jdbcUtils;

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u67e5\u8be2\u7684\u5546\u54c1\u540d\u79f0\uff1a");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
            panel1.add(label1);
            label1.setBounds(100, 40, 255, 40);
            panel1.add(textField1);
            textField1.setBounds(245, 40, 270, 40);

            //---- button1 ----
            button1.setText("\u663e\u793a\u5e93\u5b58");
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(50, 105, 195, 35);

            //---- button2 ----
            button2.setText("\u67e5\u8be2\u5546\u54c1\u5e93\u5b58");
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            panel1.add(button2);
            button2.setBounds(335, 105, 195, 35);

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
        panel1.setBounds(90, 0, 580, 155);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(100, 170, 575, 305);

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
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
