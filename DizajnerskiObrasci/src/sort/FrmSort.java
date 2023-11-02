package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();
	private ArrayList<Circle> circles = new ArrayList<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setTitle("IT 60/2021 Natasa Martic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgSort dlgCircle = new DlgSort();
				dlgCircle.setVisible(true);
				if(dlgCircle.getCircle() != null) {
					circles.add(dlgCircle.getCircle());
					circles.sort(null);
					dlm.clear();
					for(int i = 0; i < circles.size(); i++) {
						dlm.add(i, circles.get(i));
					}
				}
			}
		});
		btnAdd.setForeground(new Color(255, 255, 204));
		btnAdd.setBackground(new Color(0, 0, 102));
		panel.add(btnAdd);
		
		JLabel lblSort = new JLabel("Sort");
		lblSort.setVerticalAlignment(SwingConstants.TOP);
		lblSort.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSort.setBackground(Color.WHITE);
		contentPane.add(lblSort, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setForeground(Color.BLACK);
		scrollPane.setViewportView(list);
		list.setModel(dlm);
	}

}
