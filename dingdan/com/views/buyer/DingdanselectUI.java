/*
 * Created by JFormDesigner on Tue Jun 22 11:00:36 CST 2021
 */

package dingdan.com.views.buyer;

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
public class DingdanselectUI extends JFrame {
    public DingdanselectUI() {
        super("订单管理系统-买家订单查询界面");
        initComponents();
        setVisible(true);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        panel1.setOpaque(false);
        panel1.setBackground(null);
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setOpaque(false);
        button1.setContentAreaFilled(false) ;
        textField1.setOpaque(false);
        table1.setOpaque(false);
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here

        Vector rowDate, columnNames;
        String DingdanID = textField1.getText();
        columnNames = new Vector();
        columnNames.add("订单编号");
        columnNames.add("商品名称");
        columnNames.add("购买数量");
        columnNames.add("商品状态");
        rowDate = new Vector();

        try {
            jdbcUtils = new JDBCUtils();
            jdbcUtils.connect();
            String sql = "SELECT *FROM buyerdingdan where DingdanID ='" + DingdanID + "'";
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
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u67e5\u8be2\u7684\u8ba2\u5355\u7f16\u53f7\uff1a");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
            panel1.add(label1);
            label1.setBounds(40, 50, 255, 40);
            panel1.add(textField1);
            textField1.setBounds(180, 50, 270, 40);

            //---- button1 ----
            button1.setText("\u67e5\u8be2");
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(160, 130, 195, 35);

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
        panel1.setBounds(125, 85, 490, 165);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(110, 275, 570, 50);

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
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
