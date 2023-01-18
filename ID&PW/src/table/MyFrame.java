package table;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	Container frame = this.getContentPane();
	JPanel panel;
	
	JButton btn;
	DefaultTableModel model;
	JTable table;
	String [] title = {"아이디","비밀번호","이름"};
	
	MyDialog dlg = null;
	
	MyFrame(String title) {
		
		super(title);
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		init();
		this.setVisible(true);
		}

	private void init() {
		// TODO Auto-generated method stub
		this.panel = new JPanel();
		
		this.btn = new JButton("정보입력");
		this.btn.addActionListener(e->{
			if(dlg==null) {
			dlg = new MyDialog(MyFrame.this,"정보입력",false);
			}else 
				dlg.requestFocus();
			
		});
			
			/*String uid = dlg.uid.getText();
			if(uid.length()>0) {
				String [] data = {dlg.uid.getText(),
						new String(dlg.upassword.getPassword()),
						dlg.uname.getText()};
				model.addRow(data);
				}
			else {
				JOptionPane.showMessageDialog(null,"입력필드가 비었습니다.");
			}*/
			
			
		
		this.model = new DefaultTableModel(title,0);
		this.table = new JTable(model);
		//this.model.addColumn(title);
		this.panel.add(btn);
		this.panel.add(btn);
		//frame.add(panel,BorderLayout.NORTH);
		frame.add(new JScrollPane(table),BorderLayout.CENTER);
		frame.add(panel,BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame("202211946 이재원");
	}

}
