/*
 * Created by JFormDesigner on Fri Jun 18 11:49:04 CST 2021
 */

package dingdan.com.views.guanliyuan.maijiaxinxi;

import com.oo.utils.jdbcUtils;
import dingdan.com.utils.JDBCUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class BuyerInformationSelectUI extends JFrame {
    public BuyerInformationSelectUI() {
        super("订单管理系统-买家信息查询界面");
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
    private JDBCUtils jdbcUtils;

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        Vector rowDate, columnNames;
        columnNames = new Vector();
        columnNames.add("姓名");
        columnNames.add("电话");
        columnNames.add("邮寄地址");
        rowDate = new Vector();
        try {
            jdbcUtils = new JDBCUtils();
            jdbcUtils.connect();
            String sql = "SELECT * FROM buyerinformation";
            ResultSet rs = jdbcUtils.getResultSet(sql);
            while (rs.next()) {
                Vector hang = new Vector();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
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
        String name = textField1.getText();
        columnNames = new Vector();
        columnNames.add("姓名");
        columnNames.add("电话");
        columnNames.add("邮寄地址");
        rowDate = new Vector();

        try {
            jdbcUtils = new JDBCUtils();
            jdbcUtils.connect();
            String sql = "SELECT *FROM buyerinformation where name ='" + name + "'";
            ResultSet rs = jdbcUtils.getResultSet(sql);
            if (rs.next()) {
                Vector hang = new Vector();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                rowDate.add(hang);
            }
        } catch (SQLException d) {
            d.printStackTrace();
        }
        DefaultTableModel model = new DefaultTableModel(rowDate,columnNames);
        table1.setModel(model);
        table1.setRowHeight(30);

    }

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
            label1.setText("\u8bf7\u8f93\u5165\u9700\u8981\u67e5\u627e\u7684\u4e70\u5bb6\u59d3\u540d\uff1a");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
            panel1.add(label1);
            label1.setBounds(135, 25, 255, 40);
            panel1.add(textField1);
            textField1.setBounds(380, 25, 240, 35);

            //---- button1 ----
            button1.setText("\u663e\u793a\u6240\u6709\u4e70\u5bb6\u4fe1\u606f");
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(145, 85, 195, 35);

            //---- button2 ----
            button2.setText("\u67e5\u627e");
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            panel1.add(button2);
            button2.setBounds(400, 85, 195, 35);

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
        panel1.setBounds(25, 10, 645, 145);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setAutoCreateRowSorter(true);
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(105, 175, 575, 305);

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
