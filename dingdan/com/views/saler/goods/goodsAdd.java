package dingdan.com.views.saler.goods;

import dingdan.com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class goodsAdd extends JPanel implements ActionListener {

    private JTextField jt1=null;
    private JTextField jt2=null;
    private JTextField jt3=null;
    private JTextField jt4=null;
    private JDBCUtils jdbcUtils;

    public goodsAdd() {
        setLayout(null);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        JLabel name = new JLabel("商品名称：");
        name.setFont(new Font("宋体", Font.BOLD, 22));
        name.setBounds(100, 82, 200, 69);
        add(name);

        JLabel jiage = new JLabel("商品价格：");
        jiage.setFont(new Font("宋体", Font.BOLD, 22));
        jiage.setBounds(100, 160, 200, 69);
        add(jiage);

        JLabel tel = new JLabel("商品类型：");
        tel.setFont(new Font("宋体", Font.BOLD, 22));
        tel.setBounds(100, 242, 200, 69);
        add(tel);

        JLabel address = new JLabel("库存数量：");
        address.setFont(new Font("宋体", Font.BOLD, 22));
        address.setBounds(100, 322, 200, 69);
        add(address);



        jt1 = new JTextField();
        jt1.setBounds(210, 100, 300, 40);
        add(jt1);
        jt1.setColumns(10);
        jt1.setOpaque(false);


        jt2 = new JTextField();
        jt2.setBounds(210, 178, 300, 40);
        add(jt2);
        jt2.setColumns(10);
        jt2.setOpaque(false);

        jt3 = new JTextField();
        jt3.setBounds(210, 260, 300, 40);
        add(jt3);
        jt3.setColumns(10);
        jt3.setOpaque(false);

        jt4 = new JTextField();
        jt4.setBounds(210, 340, 300, 40);
        add(jt4);
        jt4.setColumns(10);
        jt4.setOpaque(false);

        JButton button = new JButton("添加");
        button.setFont(new Font("宋体", Font.BOLD, 22));
        button.setBounds(300, 410, 120, 35);
        add(button);
        button.addActionListener(this);
        button.setContentAreaFilled(false) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String goodsname = jt1.getText();
        String jiage = jt2.getText();
        String goodstype = jt3.getText();
        String goodscount = jt4.getText();
        if (goodsname != null && jiage != null && goodstype != null && goodscount != null) {

            String sql1 = "select * from goods where goodsname='" + goodsname + "'";
            ResultSet rs1 = jdbcUtils.getResultSet(sql1);
            try {
                if (rs1.next()) {
                    System.out.println("商品已存在！");
                    JOptionPane.showMessageDialog(null,"商品已登记，请重新输入！");
                } else {
                    String sql2 = "insert into goods values('" + goodsname + "','" + jiage + "','" + goodstype + "','" + goodscount + "')";
                    int update = jdbcUtils.update(sql2);
                    if (update > 0) {
                        JOptionPane.showMessageDialog(null,"商品信息添加成功！");
                        jt1.setText("");
                        jt2.setText("");
                        jt3.setText("");
                        jt4.setText("");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
