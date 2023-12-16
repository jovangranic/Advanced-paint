package mvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JToggleButton;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private JButton btnUndo;
	private JButton btnRedo;

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
		togglePoint.setSelected(true);
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
		GridBagLayout gbl_ModifyButtonspanel = new GridBagLayout();
		gbl_ModifyButtonspanel.columnWidths = new int[]{89, 0};
		gbl_ModifyButtonspanel.rowHeights = new int[]{17, 28, 0, 0, 0, 0};
		gbl_ModifyButtonspanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_ModifyButtonspanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		ModifyButtonspanel.setLayout(gbl_ModifyButtonspanel);

		toggleSelect = new JToggleButton("Select");
		toggleSelect.setBackground(SystemColor.control);
		GridBagConstraints gbc_toggleSelect = new GridBagConstraints();
		gbc_toggleSelect.fill = GridBagConstraints.BOTH;
		gbc_toggleSelect.insets = new Insets(0, 0, 5, 0);
		gbc_toggleSelect.gridx = 0;
		gbc_toggleSelect.gridy = 0;
		ModifyButtonspanel.add(toggleSelect, gbc_toggleSelect);
		Shapesbtngroup.add(toggleSelect);

		// Modifying

		JButton buttonModify = new JButton("Modify");
		buttonModify.setBackground(SystemColor.control);
		GridBagConstraints gbc_buttonModify = new GridBagConstraints();
		gbc_buttonModify.fill = GridBagConstraints.BOTH;
		gbc_buttonModify.insets = new Insets(0, 0, 5, 0);
		gbc_buttonModify.gridx = 0;
		gbc_buttonModify.gridy = 1;
		ModifyButtonspanel.add(buttonModify, gbc_buttonModify);
		buttonModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.modify();
			}
		});

		JButton buttonDelete = new JButton("Delete");
		buttonDelete.setBackground(SystemColor.control);
		GridBagConstraints gbc_buttonDelete = new GridBagConstraints();
		gbc_buttonDelete.fill = GridBagConstraints.BOTH;
		gbc_buttonDelete.insets = new Insets(0, 0, 5, 0);
		gbc_buttonDelete.gridx = 0;
		gbc_buttonDelete.gridy = 2;
		ModifyButtonspanel.add(buttonDelete, gbc_buttonDelete);

		btnUndo = new JButton("Undo");
		btnUndo.setBackground(SystemColor.control);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.undo();
			}
		});
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.insets = new Insets(0, 0, 5, 0);
		gbc_btnUndo.fill = GridBagConstraints.BOTH;
		gbc_btnUndo.gridx = 0;
		gbc_btnUndo.gridy = 3;
		ModifyButtonspanel.add(btnUndo, gbc_btnUndo);

		btnRedo = new JButton("Redo");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
			}
		});
		btnRedo.setBackground(SystemColor.control);
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.fill = GridBagConstraints.BOTH;
		gbc_btnRedo.gridx = 0;
		gbc_btnRedo.gridy = 4;
		ModifyButtonspanel.add(btnRedo, gbc_btnRedo);
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
