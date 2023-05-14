package dingdan.com.views.guanliyuan.maijiaxinxi;

import dingdan.com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class update extends JPanel implements ActionListener {

    private JTextField jt1=null;
    private JTextField jt2=null;
    private JTextField jt3=null;
    private JDBCUtils jdbcUtils;

    public update() {
        setLayout(null);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        JLabel name = new JLabel("被修改人的姓名：");
        name.setFont(new Font("宋体", Font.BOLD, 18));
        name.setBounds(80, 42, 200, 69);
        add(name);

        JLabel tel = new JLabel("修改后的电话：");
        tel.setFont(new Font("宋体", Font.BOLD, 18));
        tel.setBounds(100, 162, 200, 69);
        add(tel);

        JLabel address = new JLabel("修改后的邮寄地址：");
        address.setFont(new Font("宋体", Font.BOLD, 18));
        address.setBounds(60, 282, 200, 69);
        add(address);


        jt1 = new JTextField();
        jt1.setBounds(230, 60, 250, 35);
        add(jt1);
        jt1.setColumns(10);
        jt1.setOpaque(false);

        jt2 = new JTextField();
        jt2.setBounds(230, 180, 250, 35);
        add(jt2);
        jt2.setColumns(10);
        jt2.setOpaque(false);

        jt3 = new JTextField();
        jt3.setBounds(230, 300, 250, 35);
        add(jt3);
        jt3.setColumns(10);
        jt3.setOpaque(false);

        JButton button = new JButton("修改");
        button.setFont(new Font("宋体", Font.BOLD, 18));
        button.setBounds(300, 380, 100, 30);
        add(button);
        button.addActionListener(this);
        button.setContentAreaFilled(false) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = jt1.getText();
        String tel = jt2.getText();
        String address = jt3.getText();

        if (name != null && tel != null && address != null){
            String sql1 = "select * from buyerinformation where name='" + name + "'";
            ResultSet rs1 = jdbcUtils.getResultSet(sql1);
            try {
                if (rs1.next()) {
                    System.out.println("查找到买家！");
                    int n = JOptionPane.showConfirmDialog(null, "已查找到买家，是否修改该买家信息？", "1", JOptionPane.YES_NO_OPTION);
                    if (n == 0){
                        String sql2 = "update buyerinformation set tel='" + tel + "',address='" + address + "' where name='" + name + "'";
                        int update = jdbcUtils.update(sql2);
                        if (update > 0) {
                            System.out.println("该买家信息已修改！");
                            JOptionPane.showMessageDialog(null,"买家信息已修改！");
                            jt1.setText("");
                            jt2.setText("");
                            jt3.setText("");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"未查找到买家！");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
