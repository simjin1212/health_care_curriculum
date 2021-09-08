package simjinproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.StringContent;





public class Myhells extends JFrame implements ActionListener, MouseListener, ListSelectionListener, ItemListener {
	private JPanel bodyimage;
	private JPanel bodytype;
	private JPanel panday;
	private JTabbedPane tabday;
	private JTextField tftf1;
	private JTextField tftf2;
	private JTextField tftf3;
	

	
	private hellsweeklist magache;
	
	private JPanel jpmunday;
	private JPanel jpthesunday;
	private JPanel jpwensday;
	private JPanel jpthrsday;
	private JPanel jpfriday;
	private JPanel jpsaterday;
	private JPanel jpsunday;
	
	
	public static JTextArea sunday;
	private JTextArea munday;
	private JTextArea thesday;
	private JTextArea wensday;
	private JTextArea thrsday;
	private JTextArea friday;
	private JTextArea saterday;
	
	
	private ImageIcon body = new ImageIcon("image11/body.png");
	private String[] part = {"가슴", "등", "다리", "종아리","전완" , "복근","이두", "삼두", "어깨"};
	private String[] day = {"월요일","화요일","수요일","목요일","금요일","토요일","주일"};
	private JComboBox<String> cbpart;
	private JComboBox<String> cblist;
	private JComboBox<String> week;
	private JButton insert, btweeklist,btdelete;
	private JLabel select;

	
	private String[] partchest = {"벤치프레스","던벨플라이","인클라인 벤치프레스"};
	private String[] partback = {"와이드 그립 친업","시티드 케이블 로우","데드리프트"};
	private String[] partleg = {"스쿼트", "레그 프레스", "레그 익스텐션"};
	private String[] partjongali = {"스탠딩 카프레이즈","시티드 카프레이즈","원 레그 카프 레이즈"};
	private String[] partjenwan = {"리스트 컬","리버스 바벨 컬","리스트롤"};
	private String[] partedu = {"바벨 컬", "시티드 덤벨 컬","컨센트레이션 컬"};
	private String[] partsamdu = {"클로즈 그립 벤치 프레스","케이블 푸시 다운","바벨 프렌치 프레스"};
	private String[] partauche = {"시티드 바벨 프레스","래터럴 레이즈","케이블 레터럴 레이즈"};
	private String[] partbokgen = {"윗몸일으키기","레그레이지","플랭크"};
	private String[] bunsu;
	
	
	public Myhells(String title, int width, int height) /*jframe의 상위 호환, 뒤에 괄호안에 변수들을 지정해 프레임 이름과 사이즈를 통합적으로 사용 */{
		setTitle(title); 	//프레임 이름정하기 (this.은 없어도 됨), 괄호안에 타이틀을 넣어 통합적으로 쓰기 위해 이런식으로 지정
		setSize(width, height);		//프레임 사이즈, 괄호안에 변수를 맞게 넣어 통합적으로 사용
		//setLocation(300, 300);	//프레임 시작위치를 좌표에 맞게 이동 하는 정도
		setLocationRelativeTo(this); //프레임 시작위치를 화면 가운데로 만듬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//실행 창을 닫을때 프로그램도 종료하게끔 만드는 명령어
		setLayout(null);
		//몸그림
		bodyimage = new JPanel() {
			public void paint(Graphics g) {
				Dimension d = getSize();
				g.drawImage(body.getImage(), 0, 0,d.width,d.height,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		bodyimage.setBounds(10, 10, 380, 700);
		add(bodyimage);
		
		
		//몸내용들
		bodytype = new JPanel();
		bodytype.setLayout(new FlowLayout());
		bodytype.setBounds(400, 10, 380, 200);
		bodytype.setBackground(Color.WHITE);
		add(bodytype);
		select = new JLabel("운동 부위와 종류를 선택하시오");
		select.setFont(new Font("Serif", Font.BOLD,25));
		
		//리스트 박스 선언
		cbpart = new JComboBox<String>(part);
		//체크박스 선언
		cblist = new JComboBox<String>(partchest);
		cblist.addItemListener(this);
		//리스트 박스 이벤트
		cbpart.addActionListener(this);
		cbpart.addItemListener(this);
		//요일 체크박스
		week = new JComboBox<String>(day);
		//추가버튼
		insert = new JButton("!!!!!!!!!!추가하기!!!!!!!!!");
		insert.addActionListener(this);
		
		
		
		//요일 팬
		panday = new JPanel();
		panday.setBackground(Color.BLUE);
		panday.setBounds(400, 210, 380, 500);
		panday.setLayout(new FlowLayout());
		add(panday);
		
		
		
		//요일 탭팬
		createTabbedPane();
		//요일표 리스트
		btweeklist= new JButton("!!!!!!!!!!!!!주간 일정표 보기!!!!!!!!!!!");
		panday.add(btweeklist);
		btweeklist.addActionListener(this);
		
		//삭제 버튼
		btdelete = new JButton("삭제하기");
		btdelete.addActionListener(this);
		panday.add(btdelete);

		//추가
		bodytype.add(select);
		bodytype.add(cbpart);
		bodytype.add(cblist);
		bodytype.add(week);
		bodytype.add(insert);
		//변수

		
		setVisible(true);		// 무조건 있어야하는 눈에 보이게 하는 내용
	}

	private void createTabbedPane() {
		// TODO Auto-generated method stub
		munday = new JTextArea(15,15);
		thesday = new JTextArea(15,15);
		wensday = new JTextArea(15,15);
		thrsday = new JTextArea(15,15);
		friday = new JTextArea(15,15);
		saterday = new JTextArea(15,15);
		sunday = new JTextArea(15,15);

		tabday = new JTabbedPane(JTabbedPane.LEFT);
		jpmunday = new JPanel();
		jpmunday.add(munday);
		jpsunday = new JPanel();
		jpsunday.add(sunday);
		jpthesunday = new JPanel();
		jpthesunday.add(thesday);
		jpwensday = new JPanel();
		jpwensday.add(wensday);
		jpthrsday = new JPanel();
		jpthrsday.add(thrsday);
		jpsaterday = new JPanel();
		jpsaterday.add(saterday);
		jpfriday = new JPanel();
		jpfriday.add(friday);
		
		
		tabday.addTab("월요일",jpmunday);
		tabday.addTab("화요일",jpthesunday);
		tabday.addTab("수요일",jpwensday);
		tabday.addTab("목요일",jpthrsday);
		tabday.addTab("금요일",jpfriday);
		tabday.addTab("토요일",jpsaterday);
		tabday.addTab("일요일",jpsunday);
		
		panday.setBackground(Color.WHITE);
		panday.add(tabday);
		
	}

	private void add(ImageIcon body2) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Myhells("오늘 운동할 부위는?",800,800); //위에 프레임 이름과 사이즈를 지정해 사용(통합적으로)
	
	}

//콤보박스 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		Object obj = e.getSource();
		if(obj == insert) {
			
			int selectpart = cbpart.getSelectedIndex();
			System.out.println(selectpart);
			int selectlist = cblist.getSelectedIndex();
			System.out.println(selectlist);
			int selectweek = week.getSelectedIndex();
			System.out.println(selectweek);
			
			switch (selectweek) {
			case 0: {
				for(int i=0;i<=2;i++)
				{
					switch(selectpart) {
					case 0:{if(selectlist == i) {munday.append(partchest[selectlist]+"\n");}break;}
					case 1:{if(selectlist == i) {munday.append(partback[selectlist]+"\n");}break;}
					case 2:{if(selectlist == i) {munday.append(partleg[selectlist]+"\n");}break;}
					case 3:{if(selectlist == i) {munday.append(partjongali[selectlist]+"\n");}break;}
					case 4:{if(selectlist == i) {munday.append(partjenwan[selectlist]+"\n");}break;}
					case 5:{if(selectlist == i) {munday.append(partbokgen[selectlist]+"\n");}break;}
					case 6:{if(selectlist == i) {munday.append(partedu[selectlist]+"\n");}break;}
					case 7:{if(selectlist == i) {munday.append(partsamdu[selectlist]+"\n");}break;}
					case 8:{if(selectlist == i) {munday.append(partauche[selectlist]+"\n");}break;}
					}
				}
				break;
			}
			case 1: {
				for(int i=0;i<=2;i++)
				{
					switch(selectpart) {
					case 0:{if(selectlist == i) {thesday.append(partchest[selectlist]+"\n");}break;}
					case 1:{if(selectlist == i) {thesday.append(partback[selectlist]+"\n");}break;}
					case 2:{if(selectlist == i) {thesday.append(partleg[selectlist]+"\n");}break;}
					case 3:{if(selectlist == i) {thesday.append(partjongali[selectlist]+"\n");}break;}
					case 4:{if(selectlist == i) {thesday.append(partjenwan[selectlist]+"\n");}break;}
					case 5:{if(selectlist == i) {thesday.append(partbokgen[selectlist]+"\n");}break;}
					case 6:{if(selectlist == i) {thesday.append(partedu[selectlist]+"\n");}break;}
					case 7:{if(selectlist == i) {thesday.append(partsamdu[selectlist]+"\n");}break;}
					case 8:{if(selectlist == i) {thesday.append(partauche[selectlist]+"\n");}break;}
					}
				}
				
				break;
				}
			case 2: {
				for(int i=0;i<=2;i++)
				{
					switch(selectpart) {
					case 0:{if(selectlist == i) {wensday.append(partchest[selectlist]+"\n");}break;}
					case 1:{if(selectlist == i) {wensday.append(partback[selectlist]+"\n");}break;}
					case 2:{if(selectlist == i) {wensday.append(partleg[selectlist]+"\n");}break;}
					case 3:{if(selectlist == i) {wensday.append(partjongali[selectlist]+"\n");}break;}
					case 4:{if(selectlist == i) {wensday.append(partjenwan[selectlist]+"\n");}break;}
					case 5:{if(selectlist == i) {wensday.append(partbokgen[selectlist]+"\n");}break;}
					case 6:{if(selectlist == i) {wensday.append(partedu[selectlist]+"\n");}break;}
					case 7:{if(selectlist == i) {wensday.append(partsamdu[selectlist]+"\n");}break;}
					case 8:{if(selectlist == i) {wensday.append(partauche[selectlist]+"\n");}break;}
					}
				}
				
				break;
			}
			case 3: {
				for(int i=0;i<=2;i++)
				{
					switch(selectpart) {
					case 0:{if(selectlist == i) {thrsday.append(partchest[selectlist]+"\n");}break;}
					case 1:{if(selectlist == i) {thrsday.append(partback[selectlist]+"\n");}break;}
					case 2:{if(selectlist == i) {thrsday.append(partleg[selectlist]+"\n");}break;}
					case 3:{if(selectlist == i) {thrsday.append(partjongali[selectlist]+"\n");}break;}
					case 4:{if(selectlist == i) {thrsday.append(partjenwan[selectlist]+"\n");}break;}
					case 5:{if(selectlist == i) {thrsday.append(partbokgen[selectlist]+"\n");}break;}
					case 6:{if(selectlist == i) {thrsday.append(partedu[selectlist]+"\n");}break;}
					case 7:{if(selectlist == i) {thrsday.append(partsamdu[selectlist]+"\n");}break;}
					case 8:{if(selectlist == i) {thrsday.append(partauche[selectlist]+"\n");}break;}
					}
				}
				
				break;
			}
			case 4: {
				for(int i=0;i<=2;i++)
				{
					switch(selectpart) {
					case 0:{if(selectlist == i) {friday.append(partchest[selectlist]+"\n");}break;}
					case 1:{if(selectlist == i) {friday.append(partback[selectlist]+"\n");}break;}
					case 2:{if(selectlist == i) {friday.append(partleg[selectlist]+"\n");}break;}
					case 3:{if(selectlist == i) {friday.append(partjongali[selectlist]+"\n");}break;}
					case 4:{if(selectlist == i) {friday.append(partjenwan[selectlist]+"\n");}break;}
					case 5:{if(selectlist == i) {friday.append(partbokgen[selectlist]+"\n");}break;}
					case 6:{if(selectlist == i) {friday.append(partedu[selectlist]+"\n");}break;}
					case 7:{if(selectlist == i) {friday.append(partsamdu[selectlist]+"\n");}break;}
					case 8:{if(selectlist == i) {friday.append(partauche[selectlist]+"\n");}break;}
					}
				}
				
				break;
			}
			case 5: {
				for(int i=0;i<=2;i++)
				{
					switch(selectpart) {
					case 0:{if(selectlist == i) {saterday.append(partchest[selectlist]+"\n");}break;}
					case 1:{if(selectlist == i) {saterday.append(partback[selectlist]+"\n");}break;}
					case 2:{if(selectlist == i) {saterday.append(partleg[selectlist]+"\n");}break;}
					case 3:{if(selectlist == i) {saterday.append(partjongali[selectlist]+"\n");}break;}
					case 4:{if(selectlist == i) {saterday.append(partjenwan[selectlist]+"\n");}break;}
					case 5:{if(selectlist == i) {saterday.append(partbokgen[selectlist]+"\n");}break;}
					case 6:{if(selectlist == i) {saterday.append(partedu[selectlist]+"\n");}break;}
					case 7:{if(selectlist == i) {saterday.append(partsamdu[selectlist]+"\n");}break;}
					case 8:{if(selectlist == i) {saterday.append(partauche[selectlist]+"\n");}break;}
					}
				}
				
				break;
			}
			case 6: {
				for(int i=0;i<=2;i++)
				{
					switch(selectpart) {
					case 0:{if(selectlist == i) {sunday.append(partchest[selectlist]+"\n");}break;}
					case 1:{if(selectlist == i) {sunday.append(partback[selectlist]+"\n");}break;}
					case 2:{if(selectlist == i) {sunday.append(partleg[selectlist]+"\n");}break;}
					case 3:{if(selectlist == i) {sunday.append(partjongali[selectlist]+"\n");}break;}
					case 4:{if(selectlist == i) {sunday.append(partjenwan[selectlist]+"\n");}break;}
					case 5:{if(selectlist == i) {sunday.append(partbokgen[selectlist]+"\n");}break;}
					case 6:{if(selectlist == i) {sunday.append(partedu[selectlist]+"\n");}break;}
					case 7:{if(selectlist == i) {sunday.append(partsamdu[selectlist]+"\n");}break;}
					case 8:{if(selectlist == i) {sunday.append(partauche[selectlist]+"\n");}break;}
					}
				}
				
				break;
			}

			}
		
			


			}
		else if(obj == btweeklist) 
		{
			System.out.println("1111");
			magache = new hellsweeklist("주간 리스트",1400,300);
			magache.w1.add(munday);
			magache.w2.add(thesday);
			magache.w3.add(wensday);
			magache.w4.add(thrsday);
			magache.w5.add(friday);
			
			magache.w6.add(saterday);
			magache.w7.add(sunday);
		
		}
		else if(obj == btdelete)
		{
			munday.setText("");
			thesday.setText("");
			wensday.setText("");
			thrsday.setText("");
			friday.setText("");
			saterday.setText("");
			sunday.setText("");
			
			
		}
		
		}
			
	

	
	//체크박스 이벤트( 리스트 파트 )

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		Object obj = e.getSource();
//		if(obj == cbpart) {
//			int index = cbpart.getSelectedIndex();
//			System.out.println(index);
//			switch (index) {
//			case 0:
//				cblist.removeAllItems();
//				
//				//cblist = new JComboBox<String>(part2[index]);
//				//bodytype.add(cblist);
//				break;
//			case 1:
//				cblist.removeAllItems();
//				cblist.addItem(partback[0]);
//				cblist.addItem(partback[1]);
//				cblist.addItem(partback[2]);
//				
//				break;
//			case 2:
//				
//				break;
//			}
//		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Object obj = e.getSource();
				if(obj == cbpart) {
					int index = cbpart.getSelectedIndex();
					System.out.println(index);
					switch (index) {
					case 0:
						cblist.removeAllItems();
						cblist.addItem(partchest[0]);
						cblist.addItem(partchest[1]);
						cblist.addItem(partchest[2]);
						//cblist = new JComboBox<String>(part2[index]);
						//bodytype.add(cblist);
						break;
					case 1:
						cblist.removeAllItems();
						cblist.addItem(partback[0]);
						cblist.addItem(partback[1]);
						cblist.addItem(partback[2]);
						
						break;
					case 2:
						cblist.removeAllItems();
						cblist.addItem(partleg[0]);
						cblist.addItem(partleg[1]);
						cblist.addItem(partleg[2]);
						
						break;
					case 3:
						cblist.removeAllItems();
						cblist.addItem(partjongali[0]);
						cblist.addItem(partjongali[1]);
						cblist.addItem(partjongali[2]);
						break;
					case 4:
						cblist.removeAllItems();
						cblist.addItem(partjenwan[0]);
						cblist.addItem(partjenwan[1]);
						cblist.addItem(partjenwan[2]);
						break;
					case 5:
						cblist.removeAllItems();
						cblist.addItem(partbokgen[0]);
						cblist.addItem(partbokgen[1]);
						cblist.addItem(partbokgen[2]);
						break;
					case 6:
						cblist.removeAllItems();
						cblist.addItem(partedu[0]);
						cblist.addItem(partedu[1]);
						cblist.addItem(partedu[2]);
						break;
				
					case 7:	
						cblist.removeAllItems();
						cblist.addItem(partsamdu[0]);
						cblist.addItem(partsamdu[1]);
						cblist.addItem(partsamdu[2]);
						break;
					case 8:
						cblist.removeAllItems();
						cblist.addItem(partauche[0]);
						cblist.addItem(partauche[1]);
						cblist.addItem(partauche[2]);
						break;
					}
				}
				
		
		
	}
	


	
}


