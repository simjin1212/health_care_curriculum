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
	private String[] part = {"����", "��", "�ٸ�", "���Ƹ�","����" , "����","�̵�", "���", "���"};
	private String[] day = {"������","ȭ����","������","�����","�ݿ���","�����","����"};
	private JComboBox<String> cbpart;
	private JComboBox<String> cblist;
	private JComboBox<String> week;
	private JButton insert, btweeklist,btdelete;
	private JLabel select;

	
	private String[] partchest = {"��ġ������","�����ö���","��Ŭ���� ��ġ������"};
	private String[] partback = {"���̵� �׸� ģ��","��Ƽ�� ���̺� �ο�","���帮��Ʈ"};
	private String[] partleg = {"����Ʈ", "���� ������", "���� �ͽ��ټ�"};
	private String[] partjongali = {"���ĵ� ī��������","��Ƽ�� ī��������","�� ���� ī�� ������"};
	private String[] partjenwan = {"����Ʈ ��","������ �ٺ� ��","����Ʈ��"};
	private String[] partedu = {"�ٺ� ��", "��Ƽ�� ���� ��","����Ʈ���̼� ��"};
	private String[] partsamdu = {"Ŭ���� �׸� ��ġ ������","���̺� Ǫ�� �ٿ�","�ٺ� ����ġ ������"};
	private String[] partauche = {"��Ƽ�� �ٺ� ������","���ͷ� ������","���̺� ���ͷ� ������"};
	private String[] partbokgen = {"��������Ű��","���׷�����","�÷�ũ"};
	private String[] bunsu;
	
	
	public Myhells(String title, int width, int height) /*jframe�� ���� ȣȯ, �ڿ� ��ȣ�ȿ� �������� ������ ������ �̸��� ����� ���������� ��� */{
		setTitle(title); 	//������ �̸����ϱ� (this.�� ��� ��), ��ȣ�ȿ� Ÿ��Ʋ�� �־� ���������� ���� ���� �̷������� ����
		setSize(width, height);		//������ ������, ��ȣ�ȿ� ������ �°� �־� ���������� ���
		//setLocation(300, 300);	//������ ������ġ�� ��ǥ�� �°� �̵� �ϴ� ����
		setLocationRelativeTo(this); //������ ������ġ�� ȭ�� ����� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//���� â�� ������ ���α׷��� �����ϰԲ� ����� ��ɾ�
		setLayout(null);
		//���׸�
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
		
		
		//�������
		bodytype = new JPanel();
		bodytype.setLayout(new FlowLayout());
		bodytype.setBounds(400, 10, 380, 200);
		bodytype.setBackground(Color.WHITE);
		add(bodytype);
		select = new JLabel("� ������ ������ �����Ͻÿ�");
		select.setFont(new Font("Serif", Font.BOLD,25));
		
		//����Ʈ �ڽ� ����
		cbpart = new JComboBox<String>(part);
		//üũ�ڽ� ����
		cblist = new JComboBox<String>(partchest);
		cblist.addItemListener(this);
		//����Ʈ �ڽ� �̺�Ʈ
		cbpart.addActionListener(this);
		cbpart.addItemListener(this);
		//���� üũ�ڽ�
		week = new JComboBox<String>(day);
		//�߰���ư
		insert = new JButton("!!!!!!!!!!�߰��ϱ�!!!!!!!!!");
		insert.addActionListener(this);
		
		
		
		//���� ��
		panday = new JPanel();
		panday.setBackground(Color.BLUE);
		panday.setBounds(400, 210, 380, 500);
		panday.setLayout(new FlowLayout());
		add(panday);
		
		
		
		//���� ����
		createTabbedPane();
		//����ǥ ����Ʈ
		btweeklist= new JButton("!!!!!!!!!!!!!�ְ� ����ǥ ����!!!!!!!!!!!");
		panday.add(btweeklist);
		btweeklist.addActionListener(this);
		
		//���� ��ư
		btdelete = new JButton("�����ϱ�");
		btdelete.addActionListener(this);
		panday.add(btdelete);

		//�߰�
		bodytype.add(select);
		bodytype.add(cbpart);
		bodytype.add(cblist);
		bodytype.add(week);
		bodytype.add(insert);
		//����

		
		setVisible(true);		// ������ �־���ϴ� ���� ���̰� �ϴ� ����
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
		
		
		tabday.addTab("������",jpmunday);
		tabday.addTab("ȭ����",jpthesunday);
		tabday.addTab("������",jpwensday);
		tabday.addTab("�����",jpthrsday);
		tabday.addTab("�ݿ���",jpfriday);
		tabday.addTab("�����",jpsaterday);
		tabday.addTab("�Ͽ���",jpsunday);
		
		panday.setBackground(Color.WHITE);
		panday.add(tabday);
		
	}

	private void add(ImageIcon body2) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Myhells("���� ��� ������?",800,800); //���� ������ �̸��� ����� ������ ���(����������)
	
	}

//�޺��ڽ� �̺�Ʈ
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
			magache = new hellsweeklist("�ְ� ����Ʈ",1400,300);
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
			
	

	
	//üũ�ڽ� �̺�Ʈ( ����Ʈ ��Ʈ )

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


