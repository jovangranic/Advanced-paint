package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgStack extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	private Circle circle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStack dialog = new DlgStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			lblNewLabel = new JLabel("Cordinate X");
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Cordinate Y");
			sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
			contentPanel.add(lblNewLabel_1);
		}
		
		JLabel lblNewLabel_2 = new JLabel("Radius");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPanel.add(lblNewLabel_2);
		
		textFieldX = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textFieldX, 46, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, textFieldX, 185, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, textFieldX);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -25, SpringLayout.WEST, textFieldX);
		contentPanel.add(textFieldX);
		textFieldX.setColumns(10);
		
		textFieldY = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textFieldY, 19, SpringLayout.SOUTH, textFieldX);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, textFieldY);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textFieldY, 0, SpringLayout.EAST, textFieldX);
		contentPanel.add(textFieldY);
		textFieldY.setColumns(10);
		
		textFieldRadius = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textFieldRadius, 19, SpringLayout.SOUTH, textFieldY);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, textFieldRadius);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textFieldRadius, 0, SpringLayout.EAST, textFieldX);
		contentPanel.add(textFieldRadius);
		textFieldRadius.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							
							int x = Integer.parseInt(textFieldX.getText());
							int y = Integer.parseInt(textFieldY.getText());
							int radius = Integer.parseInt(textFieldRadius.getText());
							
							if( x<0 || y<0 || radius<0)	{
								JOptionPane.showMessageDialog(null, "Number must be positive", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}	
							circle = new Circle(new Point(x,y), radius);
							dispose();
						
						}catch(Exception exception){
							JOptionPane.showMessageDialog(null, "Enter only number", "Error", JOptionPane.ERROR_MESSAGE);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public Circle getCircle() {
		return this.circle;
	}
	
	public void setCircle(Circle circle) {
		textFieldX.setText(""+circle.getCenter().getX());
		textFieldY.setText(""+circle.getCenter().getY());
		
		textFieldRadius.setText("" +circle.getRadius());

	}
}
