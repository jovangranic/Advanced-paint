package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class PrviZadatak extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroupColor = new ButtonGroup();
	private JLabel lblCrvena;
	private JLabel lblZuta;
	private JLabel lblPlava;
	private DefaultListModel<String> dlm = new DefaultListModel<String> ();
	private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrviZadatak frame = new PrviZadatak();
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
	public PrviZadatak() {
		setTitle("Vezbe 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNaslov = new JLabel("Zadatak 1");
		lblNaslov.setBackground(Color.GREEN);
		lblNaslov.setForeground(Color.BLUE);
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaslov.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblNaslov, BorderLayout.NORTH);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{121, 0, 283, 0};
		gbl_pnlCenter.rowHeights = new int[]{34, 0, 0, 113, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JToggleButton tglbtnCrvena = new JToggleButton("Crvena boja");
		tglbtnCrvena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblZuta.setForeground(Color.black);
				lblPlava.setForeground(Color.black);
				lblCrvena.setForeground(Color.green);
				dlm.addElement(lblCrvena.getText());
			}
		});
		buttonGroupColor.add(tglbtnCrvena);
		GridBagConstraints gbc_tglbtnCrvena = new GridBagConstraints();
		gbc_tglbtnCrvena.fill = GridBagConstraints.BOTH;
		gbc_tglbtnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvena.gridx = 0;
		gbc_tglbtnCrvena.gridy = 0;
		pnlCenter.add(tglbtnCrvena, gbc_tglbtnCrvena);
		
		lblCrvena = new JLabel("Crvena");
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 0;
		pnlCenter.add(lblCrvena, gbc_lblCrvena);
		
		JToggleButton tglbtnPlava = new JToggleButton("Plava boja");
		tglbtnPlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblZuta.setForeground(Color.black);
				lblCrvena.setForeground(Color.black);
				lblPlava.setForeground(Color.green);
				dlm.addElement(lblPlava.getText());
			}
		});
		buttonGroupColor.add(tglbtnPlava);
		GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
		gbc_tglbtnPlava.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava.gridx = 0;
		gbc_tglbtnPlava.gridy = 1;
		pnlCenter.add(tglbtnPlava, gbc_tglbtnPlava);
		
		lblPlava = new JLabel("Plava");
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 1;
		pnlCenter.add(lblPlava, gbc_lblPlava);
		
		JToggleButton tglbtnZuta = new JToggleButton("Zuta boja");
		tglbtnZuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCrvena.setForeground(Color.black);
				lblPlava.setForeground(Color.black);
				lblZuta.setForeground(Color.green);
				dlm.addElement(lblZuta.getText());
			}
		});
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (list.getSelectedIndex()>=0) {
					DlgAddModifyColor dlgColor = new DlgAddModifyColor();
					int index = list.getSelectedIndex();
					String elementColor = dlm.get(index);
					String[] colors = elementColor.split(" ");
					dlgColor.getTextFieldCrvena().setText(colors[0]);
					dlgColor.getTextFieldZelena().setText(colors[1]);
					dlgColor.getTextFieldPlava().setText(colors[2]);
					dlgColor.setVisible(true);
					if (dlgColor.isOk()) {
						dlm.remove(index);
						String colorRed = dlgColor.getTextFieldCrvena().getText();
						String colorGreen = dlgColor.getTextFieldZelena().getText();
						String colorBlue = dlgColor.getTextFieldPlava().getText();
						String stringColor = colorRed + " " + colorGreen + " " + colorBlue;
						dlm.add(index, stringColor);
						Color color = new Color(Integer.parseInt(colorRed), Integer.parseInt(colorGreen),
								Integer.parseInt(colorBlue));
						pnlCenter.setBackground(color);
					} 
					
				}else {
					JOptionPane.showMessageDialog(null, "Selektuj boju",
							"Upozorenje", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnIzmeni = new GridBagConstraints();
		gbc_btnIzmeni.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzmeni.gridx = 2;
		gbc_btnIzmeni.gridy = 1;
		pnlCenter.add(btnIzmeni, gbc_btnIzmeni);
		buttonGroupColor.add(tglbtnZuta);
		GridBagConstraints gbc_tglbtnZuta = new GridBagConstraints();
		gbc_tglbtnZuta.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnZuta.fill = GridBagConstraints.BOTH;
		gbc_tglbtnZuta.gridx = 0;
		gbc_tglbtnZuta.gridy = 2;
		pnlCenter.add(tglbtnZuta, gbc_tglbtnZuta);
		
		lblZuta = new JLabel("Zuta");
		GridBagConstraints gbc_lblZuta = new GridBagConstraints();
		gbc_lblZuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuta.gridx = 1;
		gbc_lblZuta.gridy = 2;
		pnlCenter.add(lblZuta, gbc_lblZuta);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgAddModifyColor dlgColor = new DlgAddModifyColor();
				dlgColor.setVisible(true);
				
				if (dlgColor.isOk()) {
					String colorRed = dlgColor.getTextFieldCrvena().getText();
					String colorGreen = dlgColor.getTextFieldZelena().getText();
					String colorBlue = dlgColor.getTextFieldPlava().getText();
					String stringColor = colorRed + " " + colorGreen + " " + colorBlue;
					dlm.addElement(stringColor);
					Color color = new Color(Integer.parseInt(colorRed), Integer.parseInt(colorGreen),
							Integer.parseInt(colorBlue));
					pnlCenter.setBackground(color);
				}
			}
		});
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 0);
		gbc_btnDodaj.gridx = 2;
		gbc_btnDodaj.gridy = 2;
		pnlCenter.add(btnDodaj, gbc_btnDodaj);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		pnlCenter.add(scrollPane, gbc_scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
		
		JButton btnKlik = new JButton("Klikni");
		btnKlik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)",
						"Poruka", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(btnKlik, BorderLayout.SOUTH);
	}

}