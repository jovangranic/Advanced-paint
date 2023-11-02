package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Point startPoint = null;
	private PnlDrawing pnlDrawing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		setTitle("IT 76/2021 Jovan Granic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setSelected(true);
		buttonGroup.add(tglbtnPoint);
		tglbtnPoint.setForeground(Color.WHITE);
		tglbtnPoint.setBackground(new Color(0, 0, 102));
		panel.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		buttonGroup.add(tglbtnLine);
		tglbtnLine.setForeground(Color.WHITE);
		tglbtnLine.setBackground(new Color(0, 0, 102));
		panel.add(tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		buttonGroup.add(tglbtnRectangle);
		tglbtnRectangle.setForeground(Color.WHITE);
		tglbtnRectangle.setBackground(new Color(0, 0, 102));
		panel.add(tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		buttonGroup.add(tglbtnCircle);
		tglbtnCircle.setForeground(Color.WHITE);
		tglbtnCircle.setBackground(new Color(0, 0, 102));
		panel.add(tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		buttonGroup.add(tglbtnDonut);
		tglbtnDonut.setForeground(Color.WHITE);
		tglbtnDonut.setBackground(new Color(0, 0, 102));
		panel.add(tglbtnDonut);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setForeground(Color.WHITE);
		tglbtnSelect.setBackground(new Color(0, 0, 102));
		panel.add(tglbtnSelect);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.getSelected() == -1) {
					JOptionPane.showMessageDialog(null, "First select a shape!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Shape shape = pnlDrawing.getShape(pnlDrawing.getSelected());
				
				if(shape instanceof Point) {
					DlgPoint dlgPoint = new DlgPoint();
					dlgPoint.setPoint((Point) shape);
					dlgPoint.setColor(shape.getColor());
					dlgPoint.setVisible(true);
					Point point = dlgPoint.getPoint();
					if(point != null) {
						shape.moveTo(point.getX(), point.getY());
						shape.setColor(point.getColor());
					}
						
				}
				else if(shape instanceof Line) {
					DlgLine dlgLine = new DlgLine();
					dlgLine.setLine((Line) shape);
					dlgLine.setVisible(true);
					Line line = dlgLine.getLine();
					if(line != null) {
						((Line) shape).setStartPoint(line.getStartPoint());
						((Line) shape).setEndPoint(line.getEndPoint());
						shape.setColor(line.getColor());
					}
						
				}
				else if(shape instanceof Rectangle) {
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setRectangle((Rectangle) shape);
					dlgRectangle.setVisible(true);
					Rectangle rectangle = dlgRectangle.getRectangle();
					if(rectangle != null) {
						shape.moveTo(rectangle.getUpperLeftPoint().getX(), rectangle.getUpperLeftPoint().getY());
						((Rectangle) shape).setWidth(rectangle.getWidth());
						((Rectangle) shape).setHeight(rectangle.getHeight());
						shape.setColor(rectangle.getColor());
						shape.setInnerColor(rectangle.getInnerColor());
					}
						
				}
				else if(shape instanceof Circle) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setCircle((Circle) shape);
					dlgCircle.setVisible(true);
					Circle circle = dlgCircle.getCircle();
					if(circle != null) {
						shape.moveTo(circle.getCenter().getX(), circle.getCenter().getY());
						try {
							((Circle) shape).setRadius(circle.getRadius());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						shape.setColor(circle.getColor());
						shape.setInnerColor(circle.getInnerColor());
					}
						
				}
				else if(shape instanceof Donut) {
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.setDonut((Donut) shape);
					dlgDonut.setVisible(true);
					Donut donut = dlgDonut.getDonut();
					if(donut != null) {
						shape.moveTo(donut.getCenter().getX(), donut.getCenter().getY());
						try {
							((Circle) shape).setRadius(donut.getRadius());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						shape.setColor(donut.getColor());
						shape.setInnerColor(donut.getInnerColor());
						((Donut) shape).setInnerRadius(donut.getInnerRadius());
					}
						
				}
				pnlDrawing.repaint();
			}
		});
		btnModify.setForeground(Color.WHITE);
		btnModify.setBackground(new Color(0, 0, 102));
		panel.add(btnModify);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.getSelected() == -1) {
					JOptionPane.showMessageDialog(null, "First select a shape!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					if(JOptionPane.showConfirmDialog(null, "Do you want to delete this shape?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
						pnlDrawing.delete(pnlDrawing.getSelected());
					}

				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(0, 0, 102));
		panel.add(btnDelete);
		
		pnlDrawing = new PnlDrawing();
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Kordinate klika
				Point clickPos = new Point(e.getX(), e.getY());
				
				pnlDrawing.deselect();
				
				if(tglbtnSelect.isSelected()) {
					pnlDrawing.select(clickPos);
					return;
				}
				
				if (tglbtnPoint.isSelected()) {
					
					DlgPoint dlgPoint = new DlgPoint();
					dlgPoint.setPoint(clickPos);
					dlgPoint.setVisible(true);
					if(dlgPoint.getPoint() != null) 
						pnlDrawing.addShape(dlgPoint.getPoint());
					
				}
				
				else if (tglbtnLine.isSelected()) {
					if(startPoint != null) {
						
						DlgLine dlgLine = new DlgLine();
						dlgLine.setLine(startPoint, clickPos);
						dlgLine.setColor(Color.BLACK);
						dlgLine.setVisible(true);
						if(dlgLine.getLine()!= null) 
							pnlDrawing.addShape(dlgLine.getLine());
						startPoint = null;
						return;
					}
					startPoint = clickPos;
					
		
				}
				else if (tglbtnRectangle.isSelected()) {
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setPoint(clickPos);
					dlgRectangle.setColors(Color.BLACK, Color.WHITE);
					dlgRectangle.setVisible(true);
					
					if(dlgRectangle.getRectangle() != null)
						pnlDrawing.addShape(dlgRectangle.getRectangle());
				}
				else if (tglbtnCircle.isSelected()) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setPoint(clickPos);
					dlgCircle.setColors(Color.BLACK, Color.WHITE);
					dlgCircle.setVisible(true);
					
					if(dlgCircle.getCircle() != null) 
						pnlDrawing.addShape(dlgCircle.getCircle());
				}
				else if (tglbtnDonut.isSelected()) {
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.setPoint(clickPos);
					dlgDonut.setColors(Color.black, Color.WHITE);
					dlgDonut.setVisible(true);
					
					if(dlgDonut.getDonut() != null)
						pnlDrawing.addShape(dlgDonut.getDonut());
				}
			}
		});
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
	}

}
