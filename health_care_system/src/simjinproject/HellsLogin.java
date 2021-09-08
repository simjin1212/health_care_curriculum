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
		
	
		
		public HellsLogin(String title, int width, int height) /*jframe의 상위 호환, 뒤에 괄호안에 변수들을 지정해 프레임 이름과 사이즈를 통합적으로 사용 */{
			setTitle(title); 	//프레임 이름정하기 (this.은 없어도 됨), 괄호안에 타이틀을 넣어 통합적으로 쓰기 위해 이런식으로 지정
			setSize(width, height);		//프레임 사이즈, 괄호안에 변수를 맞게 넣어 통합적으로 사용
			//setLocation(300, 300);	//프레임 시작위치를 좌표에 맞게 이동 하는 정도
			setLocationRelativeTo(this); //프레임 시작위치를 화면 가운데로 만듬
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//실행 창을 닫을때 프로그램도 종료하게끔 만드는 명령어
			
			//레이아웃
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
			
			lbtype = new JLabel("몸키우기 프로젝트");
			lbtype.setFont(new Font("Serif", Font.BOLD,25));
			lbtype.setForeground(Color.BLACK);
			lbtype.setBounds(150, 35, 500,30);
			lbtype.setFocusable(true);
			
			add(panBase);
			add(lbtype);
			add(lgimage);
			
			
			setVisible(true);		// 무조건 있어야하는 눈에 보이게 하는 내용
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

			btnLogin = new JButton("로그인");
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
			new HellsLogin("몸키우기 프로젝트",600,650);
		}//위에 프레임 이름과 사이즈를 지정해 사용(통합적으로)
			
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj ==btnLogin) {
				String id = tfID.getText();
				String pw = tdPW.getText();
				
				
				//데이터베이스에서 가져오기
				boolean check = checkIDPW(id,pw);
				if(check) { 
					System.out.println("로그인 성공");
					
					new Myhells("오늘 운동할 부위는?",800,800);
					this.dispose();	//실행이 되면 삭제시키기
				}else {
					System.out.println("아직 회원이아닙니다");
					JOptionPane.showMessageDialog(null, "아직 회원이 아닙니다.");
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
					System.out.println("해당 사용자가 없습니다.");
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
		
	

