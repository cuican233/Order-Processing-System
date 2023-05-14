package dingdan.com.views.saler.goods;

import dingdan.com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class goodsupdate extends JPanel implements ActionListener {
    private JTextField jt1=null;
    private JTextField jt2=null;
    private JTextField jt3=null;
    private JTextField jt4=null;
    private JDBCUtils jdbcUtils;

    public goodsupdate() {

        setLayout(null);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        JLabel name = new JLabel("修改的商品的名称：");
        name.setFont(new Font("宋体", Font.BOLD, 18));
        name.setBounds(60, 82, 200, 69);
        add(name);

        JLabel jiage = new JLabel("修改后的商品价格：");
        jiage.setFont(new Font("宋体", Font.BOLD, 18));
        jiage.setBounds(60, 160, 200, 69);
        add(jiage);

        JLabel tel = new JLabel("修改后的商品类型：");
        tel.setFont(new Font("宋体", Font.BOLD, 18));
        tel.setBounds(60, 242, 200, 69);
        add(tel);

        JLabel address = new JLabel("修改后的库存数量：");
        address.setFont(new Font("宋体", Font.BOLD, 18));
        address.setBounds(60, 322, 200, 69);
        add(address);



        jt1 = new JTextField();
        jt1.setBounds(230, 100, 280, 35);
        add(jt1);
        jt1.setColumns(10);
        jt1.setOpaque(false);


        jt2 = new JTextField();
        jt2.setBounds(230, 178, 280, 35);
        add(jt2);
        jt2.setColumns(10);
        jt2.setOpaque(false);

        jt3 = new JTextField();
        jt3.setBounds(230, 260, 280, 35);
        add(jt3);
        jt3.setColumns(10);
        jt3.setOpaque(false);

        jt4 = new JTextField();
        jt4.setBounds(230, 340, 280, 35);
        add(jt4);
        jt4.setColumns(10);
        jt4.setOpaque(false);

        JButton button = new JButton("修改");
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

        if (goodsname != null && jiage != null && goodstype != null && goodscount != null){
            String sql1 = "select * from goods where goodsname='" + goodsname + "'";
            ResultSet rs1 = jdbcUtils.getResultSet(sql1);
            try {
                if (rs1.next()) {
                    System.out.println("查找到商品信息！");
                    int n = JOptionPane.showConfirmDialog(null, "已查找到商品，是否修改该商品信息？", "1", JOptionPane.YES_NO_OPTION);
                    if (n == 0){
                        String sql2 = "update goods set jiage='" + jiage + "',goodstype='" + goodstype + "',goodscount='" + goodscount + "' where goodsname='" + goodsname + "'";
                        int update = jdbcUtils.update(sql2);
                        if (update > 0) {
                            System.out.println("该商品信息已修改！");
                            JOptionPane.showMessageDialog(null,"商品信息已修改！");
                            jt1.setText("");
                            jt2.setText("");
                            jt3.setText("");
                            jt4.setText("");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"未查找到商品！");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
