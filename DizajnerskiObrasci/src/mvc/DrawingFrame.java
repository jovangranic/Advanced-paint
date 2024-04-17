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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;

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
	private JToggleButton toggleHexagon;
	private JButton btnToFront;
	private JButton btnToBack;
	private JButton btnBringToFront;
	private JButton btnBringToBack;
	private JButton btnEdgeColor;
	private JButton btnFillColor;
	private JButton buttonModify;
	private JButton buttonDelete;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JButton btnSaveDrawing;
	private JButton btnLoadDrawing;
	private JButton btnSaveLog;
	private JButton btnLoadLog;

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
		ShapeButtonPanel.setLayout(new GridLayout(0, 6, 0, 0));

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
		
		toggleHexagon = new JToggleButton("Hexagon");
		toggleHexagon.setBackground(SystemColor.control);
		Shapesbtngroup.add(toggleHexagon);
		ShapeButtonPanel.add(toggleHexagon);

		JPanel ModifyButtonspanel = new JPanel();
		ModifyButtonspanel.setBackground(SystemColor.control);
		contentPane.add(ModifyButtonspanel, BorderLayout.EAST);
		GridBagLayout gbl_ModifyButtonspanel = new GridBagLayout();
		gbl_ModifyButtonspanel.columnWidths = new int[]{89, 0};
		gbl_ModifyButtonspanel.rowHeights = new int[]{17, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_ModifyButtonspanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_ModifyButtonspanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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

		buttonModify = new JButton("Modify");
		buttonModify.setEnabled(false);
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

		buttonDelete = new JButton("Delete");
		buttonDelete.setEnabled(false);
		buttonDelete.setBackground(SystemColor.control);
		GridBagConstraints gbc_buttonDelete = new GridBagConstraints();
		gbc_buttonDelete.fill = GridBagConstraints.BOTH;
		gbc_buttonDelete.insets = new Insets(0, 0, 5, 0);
		gbc_buttonDelete.gridx = 0;
		gbc_buttonDelete.gridy = 2;
		ModifyButtonspanel.add(buttonDelete, gbc_buttonDelete);

		btnUndo = new JButton("Undo");
		btnUndo.setEnabled(false);
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
		btnRedo.setEnabled(false);
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
			}
		});
		btnRedo.setBackground(SystemColor.control);
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.insets = new Insets(0, 0, 5, 0);
		gbc_btnRedo.fill = GridBagConstraints.BOTH;
		gbc_btnRedo.gridx = 0;
		gbc_btnRedo.gridy = 4;
		ModifyButtonspanel.add(btnRedo, gbc_btnRedo);
		
		btnToFront = new JButton("To Front");
		btnToFront.setEnabled(false);
		btnToFront.setBackground(SystemColor.control);
		btnToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.shapeToFront();
			}
		});
		GridBagConstraints gbc_btnToFront = new GridBagConstraints();
		gbc_btnToFront.insets = new Insets(0, 0, 5, 0);
		gbc_btnToFront.fill = GridBagConstraints.BOTH;
		gbc_btnToFront.gridx = 0;
		gbc_btnToFront.gridy = 5;
		ModifyButtonspanel.add(btnToFront, gbc_btnToFront);
		
		btnToBack = new JButton("To Back");
		btnToBack.setEnabled(false);
		btnToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.shapeToBack();
			}
		});
		btnToBack.setBackground(SystemColor.control);
		GridBagConstraints gbc_btnToBack = new GridBagConstraints();
		gbc_btnToBack.fill = GridBagConstraints.BOTH;
		gbc_btnToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnToBack.gridx = 0;
		gbc_btnToBack.gridy = 6;
		ModifyButtonspanel.add(btnToBack, gbc_btnToBack);
		
		btnBringToFront = new JButton("Bring To Front");
		btnBringToFront.setEnabled(false);
		btnBringToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bringShapeToFront();
			}
		});
		btnBringToFront.setBackground(SystemColor.control);
		GridBagConstraints gbc_btnBringToFront = new GridBagConstraints();
		gbc_btnBringToFront.fill = GridBagConstraints.BOTH;
		gbc_btnBringToFront.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringToFront.gridx = 0;
		gbc_btnBringToFront.gridy = 7;
		ModifyButtonspanel.add(btnBringToFront, gbc_btnBringToFront);
		
		btnBringToBack = new JButton("Bring To Back");
		btnBringToBack.setEnabled(false);
		btnBringToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bringShapeToBack();
			}
		});
		btnBringToBack.setBackground(SystemColor.control);
		GridBagConstraints gbc_btnBringToBack = new GridBagConstraints();
		gbc_btnBringToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringToBack.fill = GridBagConstraints.BOTH;
		gbc_btnBringToBack.gridx = 0;
		gbc_btnBringToBack.gridy = 8;
		ModifyButtonspanel.add(btnBringToBack, gbc_btnBringToBack);
		
		btnEdgeColor = new JButton("Edge Color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setEdgeColor();
			}
		});
		btnEdgeColor.setBackground(SystemColor.control);
		GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
		gbc_btnEdgeColor.fill = GridBagConstraints.BOTH;
		gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdgeColor.gridx = 0;
		gbc_btnEdgeColor.gridy = 9;
		ModifyButtonspanel.add(btnEdgeColor, gbc_btnEdgeColor);
		
		btnFillColor = new JButton("Fill Color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setFillColor();
			}
		});
		btnFillColor.setBackground(SystemColor.control);
		GridBagConstraints gbc_btnFillColor = new GridBagConstraints();
		gbc_btnFillColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnFillColor.fill = GridBagConstraints.BOTH;
		gbc_btnFillColor.gridx = 0;
		gbc_btnFillColor.gridy = 10;
		ModifyButtonspanel.add(btnFillColor, gbc_btnFillColor);
		
		btnSaveDrawing = new JButton("Save Drawing");
		btnSaveDrawing.setBackground(SystemColor.control);
		btnSaveDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.saveDrawing();
			}
		});
		GridBagConstraints gbc_btnSaveDrawing = new GridBagConstraints();
		gbc_btnSaveDrawing.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveDrawing.fill = GridBagConstraints.BOTH;
		gbc_btnSaveDrawing.gridx = 0;
		gbc_btnSaveDrawing.gridy = 11;
		ModifyButtonspanel.add(btnSaveDrawing, gbc_btnSaveDrawing);
		
		btnLoadDrawing = new JButton("Load Drawing");
		btnLoadDrawing.setBackground(SystemColor.control);
		btnLoadDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loadDrawing();
			}
		});
		GridBagConstraints gbc_btnLoadDrawing = new GridBagConstraints();
		gbc_btnLoadDrawing.fill = GridBagConstraints.BOTH;
		gbc_btnLoadDrawing.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoadDrawing.gridx = 0;
		gbc_btnLoadDrawing.gridy = 12;
		ModifyButtonspanel.add(btnLoadDrawing, gbc_btnLoadDrawing);
		
		btnSaveLog = new JButton("Save Log");
		btnSaveLog.setBackground(SystemColor.control);
		btnSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSaveLog = new GridBagConstraints();
		gbc_btnSaveLog.fill = GridBagConstraints.BOTH;
		gbc_btnSaveLog.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveLog.gridx = 0;
		gbc_btnSaveLog.gridy = 13;
		ModifyButtonspanel.add(btnSaveLog, gbc_btnSaveLog);
		
		btnLoadLog = new JButton("Load Log");
		btnLoadLog.setBackground(SystemColor.control);
		btnLoadLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnLoadLog = new GridBagConstraints();
		gbc_btnLoadLog.fill = GridBagConstraints.BOTH;
		gbc_btnLoadLog.gridx = 0;
		gbc_btnLoadLog.gridy = 14;
		ModifyButtonspanel.add(btnLoadLog, gbc_btnLoadLog);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(150, 2));
		contentPane.add(scrollPane, BorderLayout.WEST);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		panel.add(textArea, BorderLayout.CENTER);
		
		
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
	public JToggleButton getToggleHexagon() {
		return toggleHexagon;
	}
	public JButton getButtonModify() {
		return buttonModify;
	}
	public JButton getButtonDelete() {
		return buttonDelete;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public JButton getBtnToFront() {
		return btnToFront;
	}

	public JButton getBtnToBack() {
		return btnToBack;
	}

	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

}
