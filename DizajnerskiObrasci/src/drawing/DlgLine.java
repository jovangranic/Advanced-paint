package drawing;

import java.awt.BorderLayout;
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
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX1;
	private JTextField textFieldY1;
	private JTextField textFieldX2;
	private JTextField textFieldY2;
	private Line line = null;
	private Color color = null;

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
		setResizable(false);
		setModal(true);
		setTitle("Line");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 204, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{70, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartX = new JLabel("X start coordinate:");
			GridBagConstraints gbc_lblStartX = new GridBagConstraints();
			gbc_lblStartX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartX.anchor = GridBagConstraints.EAST;
			gbc_lblStartX.gridx = 0;
			gbc_lblStartX.gridy = 0;
			contentPanel.add(lblStartX, gbc_lblStartX);
		}
		{
			textFieldX1 = new JTextField();
			GridBagConstraints gbc_textFieldX1 = new GridBagConstraints();
			gbc_textFieldX1.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX1.gridx = 1;
			gbc_textFieldX1.gridy = 0;
			contentPanel.add(textFieldX1, gbc_textFieldX1);
			textFieldX1.setColumns(10);
		}
		{
			JLabel lblStartY = new JLabel("Y start coordinate");
			GridBagConstraints gbc_lblStartY = new GridBagConstraints();
			gbc_lblStartY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartY.anchor = GridBagConstraints.EAST;
			gbc_lblStartY.gridx = 0;
			gbc_lblStartY.gridy = 1;
			contentPanel.add(lblStartY, gbc_lblStartY);
		}
		{
			textFieldY1 = new JTextField();
			GridBagConstraints gbc_textFieldY1 = new GridBagConstraints();
			gbc_textFieldY1.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY1.gridx = 1;
			gbc_textFieldY1.gridy = 1;
			contentPanel.add(textFieldY1, gbc_textFieldY1);
			textFieldY1.setColumns(10);
		}
		{
			JLabel lblEndX = new JLabel("X end coordinate");
			GridBagConstraints gbc_lblEndX = new GridBagConstraints();
			gbc_lblEndX.anchor = GridBagConstraints.EAST;
			gbc_lblEndX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndX.gridx = 0;
			gbc_lblEndX.gridy = 2;
			contentPanel.add(lblEndX, gbc_lblEndX);
		}
		{
			textFieldX2 = new JTextField();
			GridBagConstraints gbc_textFieldX2 = new GridBagConstraints();
			gbc_textFieldX2.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX2.gridx = 1;
			gbc_textFieldX2.gridy = 2;
			contentPanel.add(textFieldX2, gbc_textFieldX2);
			textFieldX2.setColumns(10);
		}
		{
			JLabel lblEndY = new JLabel("Y end coordinate");
			GridBagConstraints gbc_lblEndY = new GridBagConstraints();
			gbc_lblEndY.anchor = GridBagConstraints.EAST;
			gbc_lblEndY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndY.gridx = 0;
			gbc_lblEndY.gridy = 3;
			contentPanel.add(lblEndY, gbc_lblEndY);
		}
		{
			textFieldY2 = new JTextField();
			GridBagConstraints gbc_textFieldY2 = new GridBagConstraints();
			gbc_textFieldY2.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY2.gridx = 1;
			gbc_textFieldY2.gridy = 3;
			contentPanel.add(textFieldY2, gbc_textFieldY2);
			textFieldY2.setColumns(10);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose color", color);
					if (color == null) {
						color = Color.BLACK;
					}
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnColor.gridx = 0;
			gbc_btnColor.gridy = 4;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int x1 = Integer.parseInt(textFieldX1.getText());
							int y1 = Integer.parseInt(textFieldY1.getText());
							int x2 = Integer.parseInt(textFieldX2.getText());
							int y2 = Integer.parseInt(textFieldY2.getText());
							
							if(x1 < 0 || x2 <0 || y1 < 0 || y2 < 0) {
								JOptionPane.showMessageDialog(null, "Numbers must be bigger than 0", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							line = new Line(new Point(x1, y1), new Point(x2, y2), color);
							dispose();
						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Exception found", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Line getLine() {
		return this.line;
	}
	
	public void setLine(Point startPoint, Point endPoint) {
		textFieldX1.setText("" + startPoint.getX());
		textFieldY1.setText("" + startPoint.getY());
	
		textFieldX2.setText("" + endPoint.getX());
		textFieldY2.setText("" + endPoint.getY());
	}
	
	public void setLine(Line line) {
		setLine(line.getStartPoint(), line.getEndPoint());
		setColor(line.getColor());
	}

}
