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
import geometry.Rectangle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangle extends JDialog {
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;

	private Rectangle rectangle = null;
	private Color edgeColor;
	private Color fillColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		getContentPane().setForeground(Color.LIGHT_GRAY);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setModal(true);
		setTitle("Add or modify existing rectangle");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 434, 0 };
		gridBagLayout.rowHeights = new int[] { 228, 33, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		{
			JPanel contentPanel = new JPanel();
			contentPanel.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints gbc_contentPanel = new GridBagConstraints();
			gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
			gbc_contentPanel.fill = GridBagConstraints.BOTH;
			gbc_contentPanel.gridx = 0;
			gbc_contentPanel.gridy = 0;
			getContentPane().add(contentPanel, gbc_contentPanel);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[] { 170, 0, 0, 93, 0 };
			gbl_contentPanel.rowHeights = new int[] { 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
			gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lblDialogName = new JLabel("RECTANGLE");
				lblDialogName.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GridBagConstraints gbc_lblDialogName = new GridBagConstraints();
				gbc_lblDialogName.gridwidth = 4;
				gbc_lblDialogName.insets = new Insets(0, 0, 5, 0);
				gbc_lblDialogName.gridx = 0;
				gbc_lblDialogName.gridy = 1;
				contentPanel.add(lblDialogName, gbc_lblDialogName);
			}
			{
				JLabel lblXCoordinate = new JLabel("Choose X coordinate:");
				lblXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
				gbc_lblXCoordinate.anchor = GridBagConstraints.EAST;
				gbc_lblXCoordinate.insets = new Insets(0, 0, 5, 5);
				gbc_lblXCoordinate.gridx = 0;
				gbc_lblXCoordinate.gridy = 3;
				contentPanel.add(lblXCoordinate, gbc_lblXCoordinate);
			}
			{
				textFieldX = new JTextField();
				GridBagConstraints gbc_textFieldX = new GridBagConstraints();
				gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldX.gridx = 1;
				gbc_textFieldX.gridy = 3;
				contentPanel.add(textFieldX, gbc_textFieldX);
				textFieldX.setColumns(10);
			}
			{
				JLabel lblYCoordinate = new JLabel("Choose Y coordinate:");
				lblYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
				gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
				gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
				gbc_lblYCoordinate.gridx = 0;
				gbc_lblYCoordinate.gridy = 4;
				contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
			}
			{
				textFieldY = new JTextField();
				GridBagConstraints gbc_textFieldY = new GridBagConstraints();
				gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldY.gridx = 1;
				gbc_textFieldY.gridy = 4;
				contentPanel.add(textFieldY, gbc_textFieldY);
				textFieldY.setColumns(10);
			}
			{
				JLabel lblBreak = new JLabel("");
				GridBagConstraints gbc_lblBreak = new GridBagConstraints();
				gbc_lblBreak.insets = new Insets(0, 0, 5, 5);
				gbc_lblBreak.gridx = 0;
				gbc_lblBreak.gridy = 5;
				contentPanel.add(lblBreak, gbc_lblBreak);
			}
			{
				JLabel lblWidth = new JLabel("Width:");
				lblWidth.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblWidth = new GridBagConstraints();
				gbc_lblWidth.anchor = GridBagConstraints.EAST;
				gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
				gbc_lblWidth.gridx = 0;
				gbc_lblWidth.gridy = 6;
				contentPanel.add(lblWidth, gbc_lblWidth);
			}
			{
				textFieldWidth = new JTextField();
				GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
				gbc_textFieldWidth.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldWidth.gridx = 1;
				gbc_textFieldWidth.gridy = 6;
				contentPanel.add(textFieldWidth, gbc_textFieldWidth);
				textFieldWidth.setColumns(10);
			}
			{
				JLabel lblHeight = new JLabel("Height:");
				lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblHeight = new GridBagConstraints();
				gbc_lblHeight.anchor = GridBagConstraints.EAST;
				gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
				gbc_lblHeight.gridx = 0;
				gbc_lblHeight.gridy = 7;
				contentPanel.add(lblHeight, gbc_lblHeight);
			}
			{
				textFieldHeight = new JTextField();
				GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
				gbc_textFieldHeight.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldHeight.gridx = 1;
				gbc_textFieldHeight.gridy = 7;
				contentPanel.add(textFieldHeight, gbc_textFieldHeight);
				textFieldHeight.setColumns(10);
			}
			{
				{
					{
						JLabel lblBreak = new JLabel("");
						GridBagConstraints gbc_lblBreak = new GridBagConstraints();
						gbc_lblBreak.insets = new Insets(0, 0, 5, 5);
						gbc_lblBreak.gridx = 0;
						gbc_lblBreak.gridy = 8;
						contentPanel.add(lblBreak, gbc_lblBreak);
					}
				}
			}
			JButton btnFillColor = new JButton("Fill color");
			btnFillColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillColor = JColorChooser.showDialog(null, "Choose fill color", fillColor);
					if (fillColor == null) {
						fillColor = Color.WHITE;
					}
				}
			});
			btnFillColor.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
			GridBagConstraints gbc_btnFillColor = new GridBagConstraints();
			gbc_btnFillColor.anchor = GridBagConstraints.EAST;
			gbc_btnFillColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnFillColor.gridx = 0;
			gbc_btnFillColor.gridy = 9;
			contentPanel.add(btnFillColor, gbc_btnFillColor);
			JButton btnEdgeColor = new JButton("Edge color");
			btnEdgeColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					edgeColor = JColorChooser.showDialog(null, "Choose edge color", edgeColor);
					if (edgeColor == null) {
						edgeColor = Color.BLACK;
					}
				}
			});
			btnEdgeColor.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
			GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
			gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnEdgeColor.anchor = GridBagConstraints.WEST;
			gbc_btnEdgeColor.gridx = 1;
			gbc_btnEdgeColor.gridy = 9;
			contentPanel.add(btnEdgeColor, gbc_btnEdgeColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 1;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							int x = Integer.parseInt(textFieldX.getText());
							int y = Integer.parseInt(textFieldY.getText());

							int width = Integer.parseInt(textFieldWidth.getText());
							int height = Integer.parseInt(textFieldHeight.getText());

							if (x < 0 || y < 0) {
								JOptionPane.showMessageDialog(null, "Enter positive values!", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							if (width < 0 || height < 0) {
								JOptionPane.showMessageDialog(null, "Enter positive values for width and height!",
										"Error", JOptionPane.ERROR_MESSAGE);
								return;
							}

							rectangle = new Rectangle(new Point(x, y), width, height, edgeColor, fillColor);
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

	public void setPoint(Point p) {
		textFieldX.setText("" + p.getX());
		textFieldY.setText("" + p.getY());
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle r) {
		setPoint(r.getUpperLeftPoint());
		setColors(r.getColor(), r.getFillColor());
		textFieldWidth.setText("" + r.getWidth());
		textFieldHeight.setText("" + r.getHeight());
	}

	public void setColors(Color edgeColor, Color fillColor) {
		this.edgeColor = edgeColor;
		this.fillColor = fillColor;
	}

}
