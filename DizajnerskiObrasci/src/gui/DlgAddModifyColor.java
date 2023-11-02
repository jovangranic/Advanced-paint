package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAddModifyColor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCrvena;
	private JTextField textFieldZelena;
	private JTextField textFieldPlava;
	private boolean ok = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAddModifyColor dialog = new DlgAddModifyColor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAddModifyColor() {
		setModal(true);
		setTitle("Dodaj boju");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCrvenaBoja = new JLabel("Crvena boja");
			GridBagConstraints gbc_lblCrvenaBoja = new GridBagConstraints();
			gbc_lblCrvenaBoja.anchor = GridBagConstraints.EAST;
			gbc_lblCrvenaBoja.insets = new Insets(0, 0, 5, 5);
			gbc_lblCrvenaBoja.gridx = 0;
			gbc_lblCrvenaBoja.gridy = 0;
			contentPanel.add(lblCrvenaBoja, gbc_lblCrvenaBoja);
		}
		{
			textFieldCrvena = new JTextField();
			GridBagConstraints gbc_textFieldCrvena = new GridBagConstraints();
			gbc_textFieldCrvena.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCrvena.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCrvena.gridx = 1;
			gbc_textFieldCrvena.gridy = 0;
			contentPanel.add(textFieldCrvena, gbc_textFieldCrvena);
			textFieldCrvena.setColumns(10);
		}
		{
			JLabel lblZelenaBoja = new JLabel("Zelena boja");
			GridBagConstraints gbc_lblZelenaBoja = new GridBagConstraints();
			gbc_lblZelenaBoja.anchor = GridBagConstraints.EAST;
			gbc_lblZelenaBoja.insets = new Insets(0, 0, 5, 5);
			gbc_lblZelenaBoja.gridx = 0;
			gbc_lblZelenaBoja.gridy = 1;
			contentPanel.add(lblZelenaBoja, gbc_lblZelenaBoja);
		}
		{
			textFieldZelena = new JTextField();
			GridBagConstraints gbc_textFieldZelena = new GridBagConstraints();
			gbc_textFieldZelena.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldZelena.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldZelena.gridx = 1;
			gbc_textFieldZelena.gridy = 1;
			contentPanel.add(textFieldZelena, gbc_textFieldZelena);
			textFieldZelena.setColumns(10);
		}
		{
			JLabel lblPlavaBoja = new JLabel("Plava boja");
			GridBagConstraints gbc_lblPlavaBoja = new GridBagConstraints();
			gbc_lblPlavaBoja.anchor = GridBagConstraints.EAST;
			gbc_lblPlavaBoja.insets = new Insets(0, 0, 0, 5);
			gbc_lblPlavaBoja.gridx = 0;
			gbc_lblPlavaBoja.gridy = 2;
			contentPanel.add(lblPlavaBoja, gbc_lblPlavaBoja);
		}
		{
			textFieldPlava = new JTextField();
			GridBagConstraints gbc_textFieldPlava = new GridBagConstraints();
			gbc_textFieldPlava.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPlava.gridx = 1;
			gbc_textFieldPlava.gridy = 2;
			contentPanel.add(textFieldPlava, gbc_textFieldPlava);
			textFieldPlava.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(Integer.parseInt(textFieldCrvena.getText())>=0
								&& Integer.parseInt(textFieldCrvena.getText())<=255) {
							ok=true;
							setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "Vrednosti su pogresne",
									"Upozorenje", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}

	public JTextField getTextFieldCrvena() {
		return textFieldCrvena;
	}

	public void setTextFieldCrvena(JTextField textFieldCrvena) {
		this.textFieldCrvena = textFieldCrvena;
	}

	public JTextField getTextFieldZelena() {
		return textFieldZelena;
	}

	public void setTextFieldZelena(JTextField textFieldZelena) {
		this.textFieldZelena = textFieldZelena;
	}

	public JTextField getTextFieldPlava() {
		return textFieldPlava;
	}

	public void setTextFieldPlava(JTextField textFieldPlava) {
		this.textFieldPlava = textFieldPlava;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}	

}