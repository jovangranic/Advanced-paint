package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField xField;
	private JTextField x2Field;
	private JTextField y2Field;
	private JTextField yField;

	private Color color = null;
	private Line line = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		getContentPane().setBackground(Color.GRAY);
		setTitle("Add or modify existing line");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblDialogName = new JLabel("LINE");
			lblDialogName.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
			GridBagConstraints gbc_lblDialogName = new GridBagConstraints();
			gbc_lblDialogName.gridwidth = 2;
			gbc_lblDialogName.insets = new Insets(0, 0, 5, 5);
			gbc_lblDialogName.gridx = 0;
			gbc_lblDialogName.gridy = 0;
			contentPanel.add(lblDialogName, gbc_lblDialogName);
		}
		{
			JLabel lblStartPointCoordinates = new JLabel("Start point information:");
			lblStartPointCoordinates.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblStartPointCoordinates = new GridBagConstraints();
			gbc_lblStartPointCoordinates.gridwidth = 2;
			gbc_lblStartPointCoordinates.insets = new Insets(0, 0, 5, 0);
			gbc_lblStartPointCoordinates.gridx = 0;
			gbc_lblStartPointCoordinates.gridy = 1;
			contentPanel.add(lblStartPointCoordinates, gbc_lblStartPointCoordinates);
		}
		{
			JLabel lblXCoordinate = new JLabel("X coordinate:");
			lblXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
			gbc_lblXCoordinate.anchor = GridBagConstraints.WEST;
			gbc_lblXCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinate.gridx = 0;
			gbc_lblXCoordinate.gridy = 2;
			contentPanel.add(lblXCoordinate, gbc_lblXCoordinate);
		}
		{
			xField = new JTextField();
			GridBagConstraints gbc_xField = new GridBagConstraints();
			gbc_xField.insets = new Insets(0, 0, 5, 0);
			gbc_xField.fill = GridBagConstraints.HORIZONTAL;
			gbc_xField.gridx = 1;
			gbc_xField.gridy = 2;
			contentPanel.add(xField, gbc_xField);
			xField.setColumns(10);
		}
		{
			JLabel lblYCoordinate = new JLabel("Y coordinate:");
			lblYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
			gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinate.anchor = GridBagConstraints.WEST;
			gbc_lblYCoordinate.gridx = 0;
			gbc_lblYCoordinate.gridy = 3;
			contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
		}
		{
			yField = new JTextField();
			GridBagConstraints gbc_yField = new GridBagConstraints();
			gbc_yField.insets = new Insets(0, 0, 5, 0);
			gbc_yField.fill = GridBagConstraints.HORIZONTAL;
			gbc_yField.gridx = 1;
			gbc_yField.gridy = 3;
			contentPanel.add(yField, gbc_yField);
			yField.setColumns(10);
		}
		{
			JLabel lblEndPointCoordinates = new JLabel("End point coordinates:");
			lblEndPointCoordinates.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblEndPointCoordinates = new GridBagConstraints();
			gbc_lblEndPointCoordinates.gridwidth = 2;
			gbc_lblEndPointCoordinates.insets = new Insets(0, 0, 5, 0);
			gbc_lblEndPointCoordinates.gridx = 0;
			gbc_lblEndPointCoordinates.gridy = 4;
			contentPanel.add(lblEndPointCoordinates, gbc_lblEndPointCoordinates);
		}
		{
			JLabel lblXCoordinate = new JLabel("X coordinate:");
			lblXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
			gbc_lblXCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinate.anchor = GridBagConstraints.WEST;
			gbc_lblXCoordinate.gridx = 0;
			gbc_lblXCoordinate.gridy = 5;
			contentPanel.add(lblXCoordinate, gbc_lblXCoordinate);
		}
		{
			x2Field = new JTextField();
			GridBagConstraints gbc_x2Field = new GridBagConstraints();
			gbc_x2Field.insets = new Insets(0, 0, 5, 0);
			gbc_x2Field.fill = GridBagConstraints.HORIZONTAL;
			gbc_x2Field.gridx = 1;
			gbc_x2Field.gridy = 5;
			contentPanel.add(x2Field, gbc_x2Field);
			x2Field.setColumns(10);
		}
		{
			JLabel lblYKoordinata_1 = new JLabel("Y coordinate:");
			lblYKoordinata_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblYKoordinata_1 = new GridBagConstraints();
			gbc_lblYKoordinata_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblYKoordinata_1.anchor = GridBagConstraints.WEST;
			gbc_lblYKoordinata_1.gridx = 0;
			gbc_lblYKoordinata_1.gridy = 6;
			contentPanel.add(lblYKoordinata_1, gbc_lblYKoordinata_1);
		}
		{
			y2Field = new JTextField();
			GridBagConstraints gbc_y2Field = new GridBagConstraints();
			gbc_y2Field.insets = new Insets(0, 0, 5, 0);
			gbc_y2Field.fill = GridBagConstraints.HORIZONTAL;
			gbc_y2Field.gridx = 1;
			gbc_y2Field.gridy = 6;
			contentPanel.add(y2Field, gbc_y2Field);
			y2Field.setColumns(10);
		}
		{
			JButton colorBtn = new JButton("Color");
			colorBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					color = JColorChooser.showDialog(null, "Choose color", color);
					if (color == null) {
						color = Color.BLACK;
					}
				}
			});
			colorBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_colorBtn = new GridBagConstraints();
			gbc_colorBtn.gridwidth = 2;
			gbc_colorBtn.gridx = 0;
			gbc_colorBtn.gridy = 7;
			contentPanel.add(colorBtn, gbc_colorBtn);
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
							int x1 = Integer.parseInt(xField.getText());
							int y1 = Integer.parseInt(yField.getText());

							int x2 = Integer.parseInt(x2Field.getText());
							int y2 = Integer.parseInt(y2Field.getText());

							if (x1 < 0 || y1 < 0) {
								JOptionPane.showMessageDialog(null, "Start point coordinates must be greater than 0!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
							if (x2 < 0 || y2 < 0) {
								JOptionPane.showMessageDialog(null, "End point coordinates must be greater than 0!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							line = new Line(new Point(x1, y1), new Point(x2, y2), color);
							dispose();

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "An error has occured.", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	//geting coordinates for those tho points and setting them in text field
	
	public void setLine(Point startPoint, Point endPoint) {
		xField.setText("" + startPoint.getX());
		yField.setText("" + startPoint.getY());

		x2Field.setText("" + endPoint.getX());
		y2Field.setText("" + endPoint.getY());
	}

	public Line getLine() {
		return line;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
