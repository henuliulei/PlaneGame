package Mygame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstWindow extends JFrame {
	
	static int sum=0;
	static int sp =0;
	JTextField tf_length;
	JTextField speed;
	 static JButton btn;
	static  boolean flag=true;
	
	public FirstWindow() {
		super("��ʼ��");
		this.setBounds(800, 300, 450, 220);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT));
		JPanel p1=new JPanel();
		p1.add(new JLabel("�������ӵ���"));
		tf_length=new JTextField(5);
		p1.add(tf_length);
		p1.add(new JLabel("�������ӵ��ٶ�"));
		speed=new JTextField(5);
		p1.add(speed);
		btn=new JButton("ȷ��");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sum=Integer.parseInt(tf_length.getText());
					sp=Integer.parseInt(speed.getText());
					flag=false;
					setVisible(false);
					MyGameWindow my=new MyGameWindow();
					my.launchFrame();
					System.out.println(flag);
				
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					System.out.println("������������������");
				}
				
			}
		});
		p1.add(btn);
		this.getContentPane().add(p1);
			this.setVisible(true);
		
	}
public static void main(String[] args) {
		FirstWindow firstWindow=new FirstWindow();
		
	}

}
