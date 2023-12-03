package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;

	private Point center;
	private int radius;

	private Circle circle = null;

	private Color edgeColor;
	private Color fillColor;

	private Color color;

	
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Add or modify an existing circle");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 421, 266);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[] { 30, 30, 30, 30, 0, 0, 0, 0, 0, 0 };
			gbl_contentPanel.rowHeights = new int[] { 30, 30, 30, 30 };
			gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
			gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
			contentPanel.setLayout(gbl_contentPanel);
		}
		{
			JLabel lblCenterXcoord = new JLabel("Input X:");
			lblCenterXcoord.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblCenterXcoord = new GridBagConstraints();
			gbc_lblCenterXcoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblCenterXcoord.gridwidth = 6;
			gbc_lblCenterXcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterXcoord.gridx = 0;
			gbc_lblCenterXcoord.gridy = 0;
			contentPanel.add(lblCenterXcoord, gbc_lblCenterXcoord);
		}
		{
			textFieldX = new JTextField();
			textFieldX.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.gridwidth = 2;
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 5;
			gbc_textFieldX.gridy = 0;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblCenterYcoord = new JLabel("Input Y:");
			lblCenterYcoord.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblCenterYcoord = new GridBagConstraints();
			gbc_lblCenterYcoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblCenterYcoord.gridwidth = 6;
			gbc_lblCenterYcoord.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterYcoord.gridx = 0;
			gbc_lblCenterYcoord.gridy = 1;
			contentPanel.add(lblCenterYcoord, gbc_lblCenterYcoord);
		}
		{
		}
		{
			textFieldY = new JTextField();
			textFieldY.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.gridwidth = 2;
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 5;
			gbc_textFieldY.gridy = 1;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Circle radius:");
			lblRadius.setHorizontalAlignment(SwingConstants.LEFT);
			lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.WEST;
			gbc_lblRadius.gridwidth = 5;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.gridwidth = 2;
			gbc_textFieldRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 5;
			gbc_textFieldRadius.gridy = 3;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
		}
		JButton InnerColorbtn = new JButton("Inner color");
		InnerColorbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InnerColorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fillColor = JColorChooser.showDialog(null, "Choose fill color", edgeColor);
				if (fillColor == null) {
					fillColor = Color.WHITE;
				}
			}
		});
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 54));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 5;
			gbc_lblNewLabel_1.gridy = 4;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		GridBagConstraints gbc_InnerColorbtn = new GridBagConstraints();
		gbc_InnerColorbtn.gridwidth = 3;
		gbc_InnerColorbtn.insets = new Insets(0, 0, 0, 5);
		gbc_InnerColorbtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_InnerColorbtn.gridx = 1;
		gbc_InnerColorbtn.gridy = 5;
		contentPanel.add(InnerColorbtn, gbc_InnerColorbtn);
		JButton EdgeColorbtn = new JButton("Edge color");
		EdgeColorbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EdgeColorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Choose edge color", Color.BLACK);
				if (edgeColor == null) {
					edgeColor = Color.BLACK;

				}
			}
		});
		GridBagConstraints gbc_EdgeColorbtn = new GridBagConstraints();
		gbc_EdgeColorbtn.insets = new Insets(0, 0, 0, 5);
		gbc_EdgeColorbtn.gridx = 5;
		gbc_EdgeColorbtn.gridy = 5;
		contentPanel.add(EdgeColorbtn, gbc_EdgeColorbtn);
		{
			JLabel lblCircle = new JLabel("CIRCLE");
			lblCircle.setBackground(Color.LIGHT_GRAY);
			lblCircle.setHorizontalAlignment(SwingConstants.CENTER);
			lblCircle.setFont(new Font("Tahoma", Font.PLAIN, 22));
			getContentPane().add(lblCircle, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int x = Integer.parseInt(textFieldX.getText());
							int y = Integer.parseInt(textFieldY.getText());
							int radius = Integer.parseInt(textFieldRadius.getText());

							if (x <= 0 || y <= 0 || radius <= 0) {
								JOptionPane.showMessageDialog(null, "Enter positive values!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							circle = new Circle(new Point(x, y), radius, edgeColor, fillColor);
							dispose();

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "An error has occured.", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
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
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Circle getCircle() {
		return this.circle;
	}
	
	public void setPoint(Point p) {
		textFieldX.setText("" + p.getX());
		textFieldY.setText("" + p.getY());
	}

	public void setCircle(Circle c) {
		setPoint(c.getCenter());
		setColors(c.getColor(), c.getFillColor());
		textFieldRadius.setText("" + c.getRadius());
	}

	public void setColors(Color edgeColor, Color fillColor) {
		this.edgeColor = edgeColor;
		this.fillColor = fillColor;
	}
}