package simjinproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;

public class hellsweeklist extends JFrame {
	Container ctpane = getContentPane();
	public JPanel w1,w2,w3,w4,w5,w6,w7;
	private JLabel a1,a2,a3,a4,a5,a6,a7;
	private JLabel aaa;


	
	public hellsweeklist(String title, int width, int height) /*jframe�� ���� ȣȯ, �ڿ� ��ȣ�ȿ� �������� ������ ������ �̸��� ����� ���������� ��� */{
		setTitle(title); 	//������ �̸����ϱ� (this.�� ��� ��), ��ȣ�ȿ� Ÿ��Ʋ�� �־� ���������� ���� ���� �̷������� ����
		setSize(width, height);		//������ ������, ��ȣ�ȿ� ������ �°� �־� ���������� ���
		//setLocation(300, 300);	//������ ������ġ�� ��ǥ�� �°� �̵� �ϴ� ����
		setLocationRelativeTo(this); //������ ������ġ�� ȭ�� ����� ����
		setLayout(null);
		aaa = new JLabel("                                                                   "
				+ "                                           "
				+ "               ��¯�� ���� �ְ� ����ǥ");
		aaa.setFont(new Font("Serif", Font.BOLD,20));
		aaa.setVerticalAlignment(SwingConstants.TOP);
		aaa.setSize(1000,1000);
		add(aaa);
		ctpane.setBackground(Color.WHITE);
		ctpane.setLayout(null);
		
		w1=new JPanel();
		w2=new JPanel();
		w3=new JPanel();
		w4=new JPanel();
		w5=new JPanel();
		w6=new JPanel();
		w7=new JPanel();
		
		
		
		a1= new JLabel("       ��            ");
		a1.setFont(new Font("Serif", Font.BOLD,15));
		a1.setVerticalAlignment(SwingConstants.TOP);
		w1.add(a1);
		a2= new JLabel("       ȭ            ");
		a2.setFont(new Font("Serif", Font.BOLD,15));
		w2.add(a2);
		a3= new JLabel("       ��            ");
		a3.setFont(new Font("Serif", Font.BOLD,15));
		w3.add(a3);
		a4= new JLabel("       ��            ");
		a4.setFont(new Font("Serif", Font.BOLD,15));
		w4.add(a4);
		a5= new JLabel("       ��            ");
		a5.setFont(new Font("Serif", Font.BOLD,15));
		w5.add(a5);
		a6= new JLabel("       ��            ");
		a6.setFont(new Font("Serif", Font.BOLD,15));
		a6.setForeground(Color.BLUE);
		w6.add(a6);
		a7= new JLabel("       ��            ");
		a7.setFont(new Font("Serif", Font.BOLD,15));
		a7.setForeground(Color.RED);
		w7.add(a7);
		
		
		w1.setBounds(0, 30, 200, 270);
		w1.setBackground(Color.WHITE);
		add(w1);
		
		
		w2.setBounds(200, 30, 200, 270);
		w2.setBackground(Color.WHITE);
		add(w2);
		
		w3.setBounds(400, 30, 200, 270);
		w3.setBackground(Color.WHITE);
		add(w3);
		
		w4.setBounds(600, 30, 200, 270);
		w4.setBackground(Color.WHITE);
		add(w4);
		
		w5.setBounds(800, 30, 200, 270);
		w5.setBackground(Color.WHITE);
		add(w5);
		
		w6.setBounds(1000, 30, 200, 270);
		w6.setBackground(Color.WHITE);
		add(w6);
		
		w7.setBounds(1200, 30, 200, 270);
		w7.setBackground(Color.WHITE);
		add(w7);
		
		w1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		w2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		w3.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		w4.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		w5.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		w6.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		w7.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		
		setVisible(true);		// ������ �־���ϴ� ���� ���̰� �ϴ� ����
	}

	public static void main(String[] args) {
		new hellsweeklist("�ְ� ����Ʈ",1400,300); //���� ������ �̸��� ����� ������ ���(����������)
	
	}

}
