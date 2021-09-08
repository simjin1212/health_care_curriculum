package simjinproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import simjinproject.hellsDB;
import simjinproject.Myhells;


	public class HellsLogin extends JFrame implements ActionListener {
		
		private JPanel panBase, panCenter, panSouth, lgimage;
		private JButton btnLogin;
		private JLabel lbl1, lbl2, lbtype;
		private JTextField tfID; 
		private JPasswordField tdPW;
		private ImageIcon img = new ImageIcon("image11/login.png");
		
	
		
		public HellsLogin(String title, int width, int height) /*jframe�� ���� ȣȯ, �ڿ� ��ȣ�ȿ� �������� ������ ������ �̸��� ����� ���������� ��� */{
			setTitle(title); 	//������ �̸����ϱ� (this.�� ��� ��), ��ȣ�ȿ� Ÿ��Ʋ�� �־� ���������� ���� ���� �̷������� ����
			setSize(width, height);		//������ ������, ��ȣ�ȿ� ������ �°� �־� ���������� ���
			//setLocation(300, 300);	//������ ������ġ�� ��ǥ�� �°� �̵� �ϴ� ����
			setLocationRelativeTo(this); //������ ������ġ�� ȭ�� ����� ����
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//���� â�� ������ ���α׷��� �����ϰԲ� ����� ��ɾ�
			
			//���̾ƿ�
			setLayout(null);
			lgimage = new JPanel(){
				public void paint(Graphics g) {
					Dimension d = getSize();
					g.drawImage(img.getImage(),0,0,d.width,d.height,null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
			lgimage.setBounds(0,0,600,650);
			
			createPanBase();
			
			lbtype = new JLabel("��Ű��� ������Ʈ");
			lbtype.setFont(new Font("Serif", Font.BOLD,25));
			lbtype.setForeground(Color.BLACK);
			lbtype.setBounds(150, 35, 500,30);
			lbtype.setFocusable(true);
			
			add(panBase);
			add(lbtype);
			add(lgimage);
			
			
			setVisible(true);		// ������ �־���ϴ� ���� ���̰� �ϴ� ����
		}

		private void createPanBase() {
			// TODO Auto-generated method stub
			panBase = new JPanel();
			panBase.setBounds(300,0,300,150);
			panBase.setFocusable(true);
			panBase.setBackground(new Color(255, 0, 0, 0));

			panBase.setLayout(new BorderLayout());
			
			createPanCenter();
			panBase.add(panCenter, BorderLayout.CENTER);
			createPanSouth();
			panBase.add(panSouth, BorderLayout.SOUTH);
			
		}
		private void createPanSouth() {
			// TODO Auto-generated method stub
			panSouth= new JPanel();
			//panSouth.setBackground(Color.YELLOW);
			
			
			panSouth.setBackground(new Color(255, 0, 0, 0));

			btnLogin = new JButton("�α���");
			btnLogin.addActionListener(this);
			panSouth.add(btnLogin);
		}

		private void createPanCenter() {
			// TODO Auto-generated method stub
			panCenter= new JPanel();
			panCenter.setLayout(new GridLayout(2,2));
			panCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,20));
			panCenter.setBackground(new Color(255, 0, 0, 0));


		
			lbl1 = new JLabel("ID :",JLabel.CENTER);
			tfID = new JTextField("simjin",15);
			
			lbl2 = new JLabel("PW :",JLabel.CENTER);
			tdPW = new JPasswordField("1234",15);
			
			panCenter.add(lbl1);
			panCenter.add(tfID);
			panCenter.add(lbl2);
			panCenter.add(tdPW);
		}
		public static void main(String[] args) {
			hellsDB.init();
			new HellsLogin("��Ű��� ������Ʈ",600,650);
		}//���� ������ �̸��� ����� ������ ���(����������)
			
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj ==btnLogin) {
				String id = tfID.getText();
				String pw = tdPW.getText();
				
				
				//�����ͺ��̽����� ��������
				boolean check = checkIDPW(id,pw);
				if(check) { 
					System.out.println("�α��� ����");
					
					new Myhells("���� ��� ������?",800,800);
					this.dispose();	//������ �Ǹ� ������Ű��
				}else {
					System.out.println("���� ȸ���̾ƴմϴ�");
					JOptionPane.showMessageDialog(null, "���� ȸ���� �ƴմϴ�.");
					tfID.setText("");
					tdPW.setText("");
					tfID.requestFocus();
				}
			}
		}
	

		private boolean checkIDPW(String id, String pw) {
			boolean check = false;
			String sql = "SELECT * FROM MEMBER WHERE ID = '"+id+"' AND PW = '"+pw+"'";
			ResultSet rs = hellsDB.getResultSet(sql);
			try {
				if(rs.next()){
					System.out.println(rs.getString(1));
					check = true;
					}
				else {
					System.out.println("�ش� ����ڰ� �����ϴ�.");
					check = false;
					}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
		}
	}
	
	
			// TODO Auto-generated method stu
		
	

