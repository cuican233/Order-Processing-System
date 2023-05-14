package dingdan.com.views.saler.goods;

import dingdan.com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fahuodanstate extends JPanel implements ActionListener {
    private JTextField jt1=null;
    private JTextField jt2=null;
    private JDBCUtils jdbcUtils;

    public fahuodanstate() {
        setLayout(null);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        JLabel lblNewLabel = new JLabel("请输入买家订单的编号：");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        lblNewLabel.setBounds(128, 50, 350, 100);
        add(lblNewLabel);

        JLabel label2 = new JLabel("请输入商品状态：");
        label2.setFont(new Font("Dialog", Font.BOLD, 20));
        label2.setBounds(128, 150, 350, 100);
        add(label2);


        jt1 = new JTextField();
        jt1.setBounds(130, 125, 300, 40);
        add(jt1);
        jt1.setColumns(10);
        jt1.setOpaque(false);

        jt2 = new JTextField();
        jt2.setBounds(130, 225, 300, 40);
        add(jt2);
        jt2.setColumns(10);
        jt2.setOpaque(false);

        JButton btnNewButton = new JButton("更新商品状态");
        btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
        btnNewButton.setBounds(222, 290, 150, 40);
        add(btnNewButton);
        btnNewButton.addActionListener(this);
        btnNewButton.setContentAreaFilled(false) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String DingdanID = jt1.getText();
        String goodsstate = jt2.getText();
        if (DingdanID != null && goodsstate != null) {

            String sql1 = "select * from fahuodan where DingdanID='" + DingdanID + "'";
            ResultSet rs1 = jdbcUtils.getResultSet(sql1);
            try {
                if (rs1.next()) {
                    String sql3 = "update buyerdingdan set goodsstate = '" + goodsstate + "' where DingdanID='" + DingdanID + "'";
                    int update2 = jdbcUtils.update(sql3);
                    if (update2 > 0) {
                        System.out.println("商品状态更新成功！");
                        JOptionPane.showMessageDialog(null,"商品状态更新成功！");
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"未查找到该订单！");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
