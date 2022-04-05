package rastgeleString;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.text.ParseException;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class form1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JTextArea textArea;
	Thread t1;
	String u;
	int sayac,i;
	char h;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form1 frame = new form1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public form1() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaskFormatter mf = new MaskFormatter("UUUUUUUUUU");

		JButton btnNewButton = new JButton("ARA");

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(206, 25, 151, 47);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 93, 336, 274);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.DARK_GRAY);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(28, 25, 157, 47);
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hs= textField.getText().length();
				String s=textField.getText();
				Random r = new Random();
				h=' ';
				sayac=0;
				
				t1 = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						while(true) {
							u="";
							for(i=0;i<hs;i++) {
								h = (char)((char) r.nextInt(26)+65);
								u += h;
							}
							textArea.setText(textArea.getText()+"\n"+u+" - "+sayac+". deneme");	
							sayac++;
							if(s.equals(u)) break;
						}
					}
				});
				
				t1.start();
			}
		});

	}
}
