package dingdan.com.views.buyer;

import dingdan.com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Buyerdingdan extends JPanel implements ActionListener {
    private JTextField jt1=null;
    private JTextField jt2=null;
    private JTextField jt3=null;
    private JDBCUtils jdbcUtils;

    public Buyerdingdan() {
        setLayout(null);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        JLabel name = new JLabel("订单编号：");
        name.setFont(new Font("宋体", Font.BOLD, 22));
        name.setBounds(100, 82, 200, 69);
        add(name);

        JLabel tel = new JLabel("购买商品名称：");
        tel.setFont(new Font("宋体", Font.BOLD, 22));
        tel.setBounds(55, 202, 200, 69);
        add(tel);

        JLabel address = new JLabel("购买数量：");
        address.setFont(new Font("宋体", Font.BOLD, 22));
        address.setBounds(100, 322, 200, 69);
        add(address);


        jt1 = new JTextField();
        jt1.setBounds(210, 100, 300, 40);
        add(jt1);
        jt1.setColumns(10);
        jt1.setOpaque(false);

        jt2 = new JTextField();
        jt2.setBounds(210, 220, 300, 40);
        add(jt2);
        jt2.setColumns(10);
        jt2.setOpaque(false);

        jt3 = new JTextField();
        jt3.setBounds(210, 340, 300, 40);
        add(jt3);
        jt3.setColumns(10);
        jt3.setOpaque(false);

        JButton button = new JButton("下订单");
        button.setFont(new Font("宋体", Font.BOLD, 22));
        button.setBounds(300, 420, 120, 35);
        add(button);
        button.addActionListener(this);
        button.setContentAreaFilled(false) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String DingdanID = jt1.getText();
        String goodsname = jt2.getText();
        String buycount = jt3.getText();
        String goodsstate = null;
        if (DingdanID != null && goodsname != null && buycount != null) {

            String sql1 = "select * from buyerdingdan where DingdanID='" + DingdanID + "'";
            ResultSet rs1 = jdbcUtils.getResultSet(sql1);
            try {
                if (rs1.next()) {
                    System.out.println("订单已存在！");
                    JOptionPane.showMessageDialog(null,"订单已登记，请重新输入！");
                } else {
                    String sql2 = "insert into buyerdingdan(DingdanID,goodsname,buycount) values('" + DingdanID + "','" + goodsname + "','" + buycount + "')";
                    String sql3 = "update goods set goodscount = goodscount - '" + buycount + "' where goodsname = '" + goodsname + "'";
                    int update = jdbcUtils.update(sql2);
                    if (update > 0) {
                        JOptionPane.showMessageDialog(null,"订单信息添加成功！");
                        jt1.setText("");
                        jt2.setText("");
                        jt3.setText("");
                    }


                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
