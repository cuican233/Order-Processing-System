package dingdan.com.views.saler.goods;

import dingdan.com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class goodsdelete extends JPanel implements ActionListener {
    private JTextField jt1=null;
    private JDBCUtils jdbcUtils;

    public goodsdelete() {
        setLayout(null);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        JLabel lblNewLabel = new JLabel("请输入需要删除的商品名：");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel.setBounds(128, 120, 350, 100);
        add(lblNewLabel);

        jt1 = new JTextField();
        jt1.setBounds(130, 220, 300, 40);
        add(jt1);
        jt1.setColumns(10);
        jt1.setOpaque(false);

        JButton btnNewButton = new JButton("删除");
        btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
        btnNewButton.setBounds(222, 290, 110, 40);
        add(btnNewButton);
        btnNewButton.addActionListener(this);
        btnNewButton.setContentAreaFilled(false) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String goodsname = jt1.getText();
        if (goodsname != null) {

            String sql1 = "select * from goods where goodsname='" + goodsname + "'";
            ResultSet rs1 = jdbcUtils.getResultSet(sql1);
            try {
                if (rs1.next()) {
                    System.out.println("查找到商品信息！");
                    int n = JOptionPane.showConfirmDialog(null, "已查找到商品，是否删除该商品信息？", "1", JOptionPane.YES_NO_OPTION);
                    if (n == 0) {
                        String sql2 = "delete from goods where goodsname ='" + goodsname + "'";
                        int update = jdbcUtils.update(sql2);
                        if (update > 0) {
                            System.out.println("该买家商家已删除！");
                            JOptionPane.showMessageDialog(null,"商品信息已全部删除！");
                            jt1.setText("");
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
