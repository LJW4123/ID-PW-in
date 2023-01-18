package table;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyDialog extends JDialog {
	
	MyFrame parent = null;
	Container dialog = this.getContentPane();
	JTextField uid = new JTextField(10);
	JPasswordField upassword = new JPasswordField(10);
	JTextField uname = new JTextField(10);
	JButton ok = new JButton("확인");
	JButton cancel = new JButton("취소");
	
	

	public MyDialog(MyFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		// TODO Auto-generated constructor stub
		this.parent = parent;
		
		this.setSize(500,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //프로그램 종료가 아닌 창만 닫기
		this.setLocationRelativeTo(parent);
		init();
		this.setVisible(true);
		
		
	}


	private void init() {
		// TODO Auto-generated method stub
		dialog.setLayout(new GridLayout(4,2));
		dialog.add(new JLabel("아이디"));
		dialog.add(uid);
		dialog.add(new JLabel("비밀번호"));
		dialog.add(upassword);
		upassword.setEchoChar('*');
		dialog.add(new JLabel("이름"));
		dialog.add(uname);
		dialog.add(ok);
		dialog.add(cancel);
		
		
		ok.addActionListener(e->{
			String uId = uid.getText();
			if(uId.length()>0) {
				String [] data = {uid.getText(),
						new String(upassword.getPassword()),
						uname.getText()};
				parent.model.addRow(data);
				}
			else {
				JOptionPane.showMessageDialog(null,"입력필드가 비었습니다.");
			}
			parent.dlg = null;
			dispose();
		});
		
		cancel.addActionListener(e->{
			uid.setText("");
			upassword.setText("");
			uname.setText("");
			parent.dlg = null;
			dispose();
		});
	}

}
