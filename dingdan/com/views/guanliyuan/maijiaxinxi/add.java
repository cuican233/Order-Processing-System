package dingdan.com.views.guanliyuan.maijiaxinxi;

import dingdan.com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class add extends JPanel implements ActionListener {
    private JTextField jt1=null;
    private JTextField jt2=null;
    private JTextField jt3=null;
    private JDBCUtils jdbcUtils;

    public add() {
        setLayout(null);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        JLabel name = new JLabel("姓名：");
        name.setFont(new Font("宋体", Font.BOLD, 22));
        name.setBounds(100, 42, 200, 69);
        add(name);

        JLabel tel = new JLabel("电话：");
        tel.setFont(new Font("宋体", Font.BOLD, 22));
        tel.setBounds(100, 162, 200, 69);
        add(tel);

        JLabel address = new JLabel("邮寄地址：");
        address.setFont(new Font("宋体", Font.BOLD, 22));
        address.setBounds(60, 282, 200, 69);
        add(address);


        jt1 = new JTextField();
        jt1.setBounds(210, 60, 300, 40);
        add(jt1);
        jt1.setColumns(10);
        jt1.setOpaque(false);

        jt2 = new JTextField();
        jt2.setBounds(210, 180, 300, 40);
        add(jt2);
        jt2.setColumns(10);
        jt2.setOpaque(false);

        jt3 = new JTextField();
        jt3.setBounds(210, 300, 300, 40);
        add(jt3);
        jt3.setColumns(10);
        jt3.setOpaque(false);

        JButton button = new JButton("添加");
        button.setFont(new Font("宋体", Font.BOLD, 22));
        button.setBounds(300, 380, 120, 35);
        add(button);
        button.addActionListener(this);
        button.setContentAreaFilled(false) ;
    }
    public void actionPerformed(ActionEvent e) {

        String name = jt1.getText();
        String tel = jt2.getText();
        String address = jt3.getText();
        if (name != null && tel != null && address != null) {

            String sql1 = "select * from buyerinformation where name='" + name + "'";
            ResultSet rs1 = jdbcUtils.getResultSet(sql1);
            try {
                if (rs1.next()) {
                    System.out.println("买家已存在！");
                    JOptionPane.showMessageDialog(null,"买家已登记，请重新输入！");
                } else {
                    String sql2 = "insert into buyerinformation values('" + name + "','" + tel + "','" + address + "')";
                    int update = jdbcUtils.update(sql2);
                    if (update > 0) {
                        JOptionPane.showMessageDialog(null,"买家信息添加成功！");
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
