package dingdan.com.views.saler;

import dingdan.com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fahuodan extends JPanel implements ActionListener {
    private JTextField jt1=null;
    private JDBCUtils jdbcUtils;

    public fahuodan() {
        setLayout(null);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        JLabel lblNewLabel = new JLabel("请输入买家订单的编号：");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel.setBounds(128, 120, 350, 100);
        add(lblNewLabel);

        jt1 = new JTextField();
        jt1.setBounds(130, 220, 300, 40);
        add(jt1);
        jt1.setColumns(10);
        jt1.setOpaque(false);

        JButton btnNewButton = new JButton("生成发货单");
        btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
        btnNewButton.setBounds(222, 290, 130, 40);
        add(btnNewButton);
        btnNewButton.addActionListener(this);
        btnNewButton.setContentAreaFilled(false) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String DingdanID = jt1.getText();
        if (DingdanID != null) {

            String sql1 = "select * from fahuodan where DingdanID='" + DingdanID + "'";
            ResultSet rs1 = jdbcUtils.getResultSet(sql1);
            try {
                if (rs1.next()) {
                    System.out.println("发货单已存在！");
                    JOptionPane.showMessageDialog(null,"发货单已存在，请重新输入！");
                } else {
                    String sql2 = "insert into fahuodan(DingdanID) values('" + DingdanID + "')";
                    int update = jdbcUtils.update(sql2);
                    if (update > 0) {
                        JOptionPane.showMessageDialog(null,"发货单信息添加成功！");
                        jt1.setText("");
                    }

                    String sql3 = "update buyerdingdan,fahuodan set buyerdingdan.goodsstate= fahuodan.goodsstate where buyerdingdan.DingdanID = fahuodan.DingdanID";
                    int update2 = jdbcUtils.update(sql3);
                    if (update2 > 0) {
                        System.out.println("商品状态更新成功！");
                    }

                    String sql4 = "update goods set goodscount = goodscount - (select buycount from buyerdingdan where DingdanID = '" + DingdanID + "') where goodsname =(select goodsname from buyerdingdan where DingdanID = '" + DingdanID + "')";
                    int update3 = jdbcUtils.update(sql4);
                    if (update3 > 0) {
                        System.out.println("商品库存已更新");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
