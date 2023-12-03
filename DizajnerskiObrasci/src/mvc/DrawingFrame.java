package mvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class DrawingFrame extends JFrame {

	DrawingView view = new DrawingView();
	DrawingController controller;

	private JPanel contentPane;

	private ButtonGroup Shapesbtngroup = new ButtonGroup();
	private JToggleButton togglePoint;
	private JToggleButton toggleLine;
	private JToggleButton toggleRectangle;
	private JToggleButton toggleCircle;
	private JToggleButton toggleDonut;
	private JToggleButton toggleSelect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
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
	public DrawingFrame() {
		setTitle("Jovan Granic IT-76/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		view = new DrawingView();

		view.setBackground(Color.WHITE);
		contentPane.add(view, BorderLayout.CENTER);

		JPanel ShapeButtonPanel = new JPanel();
		ShapeButtonPanel.setBackground(SystemColor.control);
		contentPane.add(ShapeButtonPanel, BorderLayout.NORTH);
		ShapeButtonPanel.setLayout(new GridLayout(0, 5, 0, 0));

		togglePoint = new JToggleButton("Point");
		togglePoint.setBackground(SystemColor.control);
		ShapeButtonPanel.add(togglePoint);
		Shapesbtngroup.add(togglePoint);

		toggleLine = new JToggleButton("Line");
		toggleLine.setBackground(SystemColor.control);
		ShapeButtonPanel.add(toggleLine);
		Shapesbtngroup.add(toggleLine);

		toggleRectangle = new JToggleButton("Rectangle");
		toggleRectangle.setBackground(SystemColor.control);
		ShapeButtonPanel.add(toggleRectangle);
		Shapesbtngroup.add(toggleRectangle);

		toggleCircle = new JToggleButton("Circle");
		toggleCircle.setBackground(SystemColor.control);
		ShapeButtonPanel.add(toggleCircle);
		Shapesbtngroup.add(toggleCircle);

		toggleDonut = new JToggleButton("Donut");
		toggleDonut.setBackground(SystemColor.control);
		ShapeButtonPanel.add(toggleDonut);
		Shapesbtngroup.add(toggleDonut);

		JPanel ModifyButtonspanel = new JPanel();
		ModifyButtonspanel.setBackground(SystemColor.control);
		contentPane.add(ModifyButtonspanel, BorderLayout.EAST);
		ModifyButtonspanel.setLayout(new GridLayout(3, 1, 0, 0));

		toggleSelect = new JToggleButton("Select");
		toggleSelect.setBackground(SystemColor.control);
		ModifyButtonspanel.add(toggleSelect);
		Shapesbtngroup.add(toggleSelect);

		JButton buttonDelete = new JButton("Delete");
		buttonDelete.setBackground(SystemColor.control);
		ModifyButtonspanel.add(buttonDelete);

		// Modifying

		JButton buttonModify = new JButton("Modify");
		buttonModify.setBackground(SystemColor.control);
		ModifyButtonspanel.add(buttonModify);
		buttonModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.modify();
			}
		});
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.delete();
			}
		});

		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.mouseClicked(e);
			}

		});
	}

	public JToggleButton getTogglePoint() {
		return togglePoint;
	}
	public JToggleButton getToggleLine() {
		return toggleLine;
	}
	public JToggleButton getToggleRectangle() {
		return toggleRectangle;
	}
	public JToggleButton getToggleCircle() {
		return toggleCircle;
	}
	public JToggleButton getToggleDonut() {
		return toggleDonut;
	}
	public JToggleButton getToggleSelect() {
		return toggleSelect;
	}
	public DrawingView getView() {
		return view;
	}
	public void setController(DrawingController controller) {
		this.controller = controller;
	}
}
