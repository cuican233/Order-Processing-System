package dingdan.com.views.Role;

import dingdan.com.utils.JDBCUtils;
import dingdan.com.views.guanliyuan.maijiaxinxi.BuyerInformationUI;
import dingdan.com.views.guanliyuan.shangjiaxinxi.shangjiaxinxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guanliyuan extends JPanel implements ActionListener {

    private JButton jb1=null;
    private JButton jb2=null;
    private JDBCUtils jdbcUtils;

    public Guanliyuan(){
        setLayout(null);
        jdbcUtils = new JDBCUtils();
        jdbcUtils.connect();
        jb1 = new JButton("买家信息管理");
        jb1.setFont(new Font("宋体", Font.BOLD, 20));
        jb1.setBounds(170, 95, 180, 90);
        add(jb1);
        jb1.addActionListener(this);
        jb1.setContentAreaFilled(false) ;

        jb2 = new JButton("商家信息管理");
        jb2.setFont(new Font("宋体", Font.BOLD, 20));
        jb2.setBounds(170, 265, 180, 90);
        add(jb2);
        jb2.addActionListener(this);
        jb2.setContentAreaFilled(false) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            new BuyerInformationUI();
        }
        else if(e.getSource() == jb2){
            new shangjiaxinxi();
        }
    }
}
