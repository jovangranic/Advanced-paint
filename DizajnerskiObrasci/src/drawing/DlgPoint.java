package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private Color color;

	private Point point = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setTitle("Add or modify existing point");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblDialogName = new JLabel("POINT");
			lblDialogName.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblDialogName = new GridBagConstraints();
			gbc_lblDialogName.gridwidth = 8;
			gbc_lblDialogName.insets = new Insets(0, 0, 5, 0);
			gbc_lblDialogName.gridx = 0;
			gbc_lblDialogName.gridy = 0;
			contentPanel.add(lblDialogName, gbc_lblDialogName);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 3;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose color", color);
					if (color == null) {
						color = Color.BLACK;
					}
				}
			});
			{
				JLabel lblXcoordinate = new JLabel("X coordinate:");
				lblXcoordinate.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblXcoordinate = new GridBagConstraints();
				gbc_lblXcoordinate.gridwidth = 3;
				gbc_lblXcoordinate.anchor = GridBagConstraints.EAST;
				gbc_lblXcoordinate.insets = new Insets(0, 0, 5, 5);
				gbc_lblXcoordinate.gridx = 0;
				gbc_lblXcoordinate.gridy = 3;
				contentPanel.add(lblXcoordinate, gbc_lblXcoordinate);
			}
			{
				textFieldX = new JTextField();
				textFieldX.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
				GridBagConstraints gbc_textFieldX = new GridBagConstraints();
				gbc_textFieldX.gridwidth = 2;
				gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldX.gridx = 3;
				gbc_textFieldX.gridy = 3;
				contentPanel.add(textFieldX, gbc_textFieldX);
				textFieldX.setColumns(10);
			}
			{
				JLabel lblYCoordinate = new JLabel("Y coordinate:");
				lblYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
				gbc_lblYCoordinate.gridwidth = 3;
				gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
				gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
				gbc_lblYCoordinate.gridx = 0;
				gbc_lblYCoordinate.gridy = 5;
				contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
			}
			{
				textFieldY = new JTextField();
				textFieldY.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
				GridBagConstraints gbc_textFieldY = new GridBagConstraints();
				gbc_textFieldY.gridwidth = 2;
				gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldY.gridx = 3;
				gbc_textFieldY.gridy = 5;
				contentPanel.add(textFieldY, gbc_textFieldY);
				textFieldY.setColumns(10);
			}
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.gridwidth = 8;
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 7;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int x = Integer.parseInt(textFieldX.getText());
							int y = Integer.parseInt(textFieldY.getText());

							if (x < 0 || y < 0) {
								JOptionPane.showMessageDialog(null, "Enter positive values!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							point = new Point(x, y, color);
							dispose();

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "An error has occured.", "Error",
									JOptionPane.ERROR_MESSAGE);
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point p) {
		textFieldX.setText("" + p.getX());
		textFieldY.setText("" + p.getY());
		this.color = p.getColor();
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
