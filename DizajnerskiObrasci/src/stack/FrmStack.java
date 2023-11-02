package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import geometry.Circle;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStack() {
		setTitle("IT 60/2021 Natasa Martic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setForeground(Color.BLACK);
		list.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(list);
		list.setModel(dlm);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgStack dlgStack = new DlgStack();
				dlgStack.setVisible(true);
				if(dlgStack.getCircle() != null) {
					dlm.add(0,dlgStack.getCircle());
				}
			}
		});
		panel.add(btnAdd);
		btnAdd.setForeground(new Color(255, 255, 204));
		btnAdd.setBackground(new Color(0, 0, 102));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Stack is empty", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				DlgStack dlgStack = new DlgStack();			
				dlgStack.setCircle(dlm.get(0));				
				dlgStack.setVisible(true);
				if(dlgStack.getCircle() != null) {
					
					dlm.remove(0);
				}
			}
		});
		panel.add(btnDelete);
		btnDelete.setForeground(new Color(255, 255, 153));
		btnDelete.setBackground(new Color(0, 0, 102));
		
		JLabel lblStack = new JLabel("Stack");
		lblStack.setVerticalAlignment(SwingConstants.TOP);
		lblStack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblStack.setBackground(new Color(255, 255, 255));
		contentPane.add(lblStack, BorderLayout.NORTH);
	}
}
