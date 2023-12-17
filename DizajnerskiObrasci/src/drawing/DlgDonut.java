package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
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
import javax.swing.SwingConstants;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField xField;
	private JTextField yField;
	private JTextField outerRadiusField;
	private JTextField innerRadiusField;
	private Donut donut = null;
	private Color edgeColor;
	private Color fillColor;


	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgDonut() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setModal(true);
		setTitle("Add or modify an existing donut");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblDialogName = new JLabel("DONUT");
			lblDialogName.setHorizontalAlignment(SwingConstants.CENTER);
			lblDialogName.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblDialogName = new GridBagConstraints();
			gbc_lblDialogName.gridwidth = 4;
			gbc_lblDialogName.insets = new Insets(0, 0, 5, 0);
			gbc_lblDialogName.gridx = 0;
			gbc_lblDialogName.gridy = 1;
			contentPanel.add(lblDialogName, gbc_lblDialogName);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblXcoord = new JLabel("         Input X coordinate:");
			lblXcoord.setHorizontalAlignment(SwingConstants.RIGHT);
			lblXcoord.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblXcoord = new GridBagConstraints();
			gbc_lblXcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcoord.anchor = GridBagConstraints.WEST;
			gbc_lblXcoord.gridx = 0;
			gbc_lblXcoord.gridy = 3;
			contentPanel.add(lblXcoord, gbc_lblXcoord);
		}
		{
			xField = new JTextField();
			xField.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_xField = new GridBagConstraints();
			gbc_xField.insets = new Insets(0, 0, 5, 5);
			gbc_xField.fill = GridBagConstraints.HORIZONTAL;
			gbc_xField.gridx = 2;
			gbc_xField.gridy = 3;
			contentPanel.add(xField, gbc_xField);
			xField.setColumns(10);
		}
		{
			JLabel lblYcoord = new JLabel("         Input Y coordinate:");
			lblYcoord.setHorizontalAlignment(SwingConstants.CENTER);
			lblYcoord.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblYcoord = new GridBagConstraints();
			gbc_lblYcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcoord.anchor = GridBagConstraints.WEST;
			gbc_lblYcoord.gridx = 0;
			gbc_lblYcoord.gridy = 4;
			contentPanel.add(lblYcoord, gbc_lblYcoord);
		}
		{
			yField = new JTextField();
			yField.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_yField = new GridBagConstraints();
			gbc_yField.insets = new Insets(0, 0, 5, 5);
			gbc_yField.fill = GridBagConstraints.HORIZONTAL;
			gbc_yField.gridx = 2;
			gbc_yField.gridy = 4;
			contentPanel.add(yField, gbc_yField);
			yField.setColumns(10);
		}
		{
			JLabel lblOuterRadius = new JLabel("Outer radius :");
			lblOuterRadius.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
			gbc_lblOuterRadius.anchor = GridBagConstraints.EAST;
			gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterRadius.gridx = 0;
			gbc_lblOuterRadius.gridy = 6;
			contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);
		}
		{
			outerRadiusField = new JTextField();
			outerRadiusField.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_outerRadiusField = new GridBagConstraints();
			gbc_outerRadiusField.insets = new Insets(0, 0, 5, 5);
			gbc_outerRadiusField.fill = GridBagConstraints.HORIZONTAL;
			gbc_outerRadiusField.gridx = 2;
			gbc_outerRadiusField.gridy = 6;
			contentPanel.add(outerRadiusField, gbc_outerRadiusField);
			outerRadiusField.setColumns(10);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner radius :");
			lblInnerRadius.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 0;
			gbc_lblInnerRadius.gridy = 7;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			innerRadiusField = new JTextField();
			innerRadiusField.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_innerRadiusField = new GridBagConstraints();
			gbc_innerRadiusField.insets = new Insets(0, 0, 5, 5);
			gbc_innerRadiusField.fill = GridBagConstraints.HORIZONTAL;
			gbc_innerRadiusField.gridx = 2;
			gbc_innerRadiusField.gridy = 7;
			contentPanel.add(innerRadiusField, gbc_innerRadiusField);
			innerRadiusField.setColumns(10);
		}
		{
		}
		{
			JButton innerColorbtn = new JButton("Inner color");
			innerColorbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
			innerColorbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					fillColor = JColorChooser.showDialog(null, "Choose fill color", edgeColor);
					if (fillColor == null) {
						fillColor = Color.BLACK;
					}
				}
			});
			GridBagConstraints gbc_innerColorbtn = new GridBagConstraints();
			gbc_innerColorbtn.anchor = GridBagConstraints.EAST;
			gbc_innerColorbtn.insets = new Insets(0, 0, 5, 5);
			gbc_innerColorbtn.gridx = 0;
			gbc_innerColorbtn.gridy = 8;
			contentPanel.add(innerColorbtn, gbc_innerColorbtn);
		}
		JButton edgeColorbtn = new JButton("Edge color");
		edgeColorbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		edgeColorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				edgeColor = JColorChooser.showDialog(null, "Choose edge color", Color.BLACK);
				if (edgeColor == null) {
					edgeColor = Color.BLACK;
				}
			}
		});
		GridBagConstraints gbc_edgeColorbtn = new GridBagConstraints();
		gbc_edgeColorbtn.anchor = GridBagConstraints.WEST;
		gbc_edgeColorbtn.insets = new Insets(0, 0, 5, 5);
		gbc_edgeColorbtn.gridx = 2;
		gbc_edgeColorbtn.gridy = 8;
		contentPanel.add(edgeColorbtn, gbc_edgeColorbtn);
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
							int x = Integer.parseInt(xField.getText());
							int y = Integer.parseInt(yField.getText());

							int outerRadius = Integer.parseInt(outerRadiusField.getText());
							int innerRadius = Integer.parseInt(innerRadiusField.getText());

							if (x < 0 || y < 0) {
								JOptionPane.showMessageDialog(null, "Enter positive values!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							if (outerRadius < 0 || innerRadius < 0) {
								JOptionPane.showMessageDialog(null, "Enter positive values for radiuses!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							if (innerRadius > outerRadius) {
								JOptionPane.showMessageDialog(null,
										"Enter a inner radius smaller than the outer radius!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							donut = new Donut(new Point(x, y), outerRadius, innerRadius, edgeColor, fillColor);
							dispose();

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "An error has occured.", "Error",
									JOptionPane.ERROR_MESSAGE);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();

					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setPoint(Point p) {
		xField.setText("" + p.getX());
		yField.setText("" + p.getY());
	}

	public Donut getDonut() {
		return donut;
	}

	public void setDonut(Donut d) {
		setPoint(d.getCenter());
		setColors(d.getColor(), d.getFillColor());
		outerRadiusField.setText("" + d.getRadius());
		innerRadiusField.setText("" + d.getInnerRadius());

	}

	public void setColors(Color edgeColor, Color fillColor) {
		this.edgeColor = edgeColor;
		this.fillColor = fillColor;
	}

}
