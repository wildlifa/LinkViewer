package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Model;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	public Model model;
	private JTextField textField;
	public ArrayList<JToggleButton> cellDebugButtons;
	public CellSelection cellSelection;
	public int currentCellID = -1;

	/**
	 * Create the frame.
	 */

	BufferedCanvas bufferedCanvas;
	
	JToggleButton leftEdgeButton;
	JToggleButton topLeftEdgeButton;
	JToggleButton topRightEdgeButton;
	JToggleButton rightEdgeButton;
	JToggleButton bottomRightEdgeButton;
	JToggleButton bottomLeftEdgeButton;
	
	JToggleButton topLeftOuterEdgeButton;
	JToggleButton topOuterEdgeButton;
	JToggleButton topRightOuterEdgeButton;
	JToggleButton bottomOuterEdgeButton;
	JToggleButton bottomLeftOuterEdgeButton;
	JToggleButton bottomRightOuterEdgeButton;
	
	public MainFrame(Model model) {
		
		this.model = model;
		cellSelection = new CellSelection();
		
		cellDebugButtons = new ArrayList<JToggleButton>();
		
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Slitherlink Viewer");
		this.setSize(1200, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(754, 30, 418, 576);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("cell debug", null, panel, null);
		panel.setLayout(null);
		
		leftEdgeButton = new JToggleButton("|");
		leftEdgeButton.setBounds(106, 192, 42, 41);
		panel.add(leftEdgeButton);
		cellDebugButtons.add(leftEdgeButton);
		leftEdgeButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		topLeftEdgeButton = new JToggleButton("/");
		topLeftEdgeButton.setBounds(134, 86, 42, 41);
		panel.add(topLeftEdgeButton);
		cellDebugButtons.add(topLeftEdgeButton);
		topLeftEdgeButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		topRightEdgeButton = new JToggleButton("\\");
		topRightEdgeButton.setBounds(238, 86, 42, 41);
		panel.add(topRightEdgeButton);
		cellDebugButtons.add(topRightEdgeButton);
		topRightEdgeButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );		
		
		bottomLeftEdgeButton = new JToggleButton("\\");
		bottomLeftEdgeButton.setBounds(134, 293, 42, 41);
		panel.add(bottomLeftEdgeButton);
		cellDebugButtons.add(bottomLeftEdgeButton);
		bottomLeftEdgeButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );	
		
		bottomRightEdgeButton = new JToggleButton("/");
		bottomRightEdgeButton.setBounds(238, 293, 42, 41);
		panel.add(bottomRightEdgeButton);
		cellDebugButtons.add(bottomRightEdgeButton);
		bottomRightEdgeButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );	
		
		rightEdgeButton = new JToggleButton("|");
		rightEdgeButton.setBounds(264, 192, 42, 41);
		panel.add(rightEdgeButton);
		cellDebugButtons.add(rightEdgeButton);
		rightEdgeButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );	
		
		JToggleButton tglbtnO = new JToggleButton("O");
		tglbtnO.setBounds(43, 187, 50, 50);
		panel.add(tglbtnO);
		cellDebugButtons.add(tglbtnO);
		
		topLeftOuterEdgeButton = new JToggleButton("\\");
		topLeftOuterEdgeButton.setBounds(58, 99, 42, 41);
		panel.add(topLeftOuterEdgeButton);
		cellDebugButtons.add(topLeftOuterEdgeButton);
		topLeftOuterEdgeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );	
		
		bottomRightOuterEdgeButton = new JToggleButton("\\");
		bottomRightOuterEdgeButton.setBounds(310, 282, 42, 41);
		panel.add(bottomRightOuterEdgeButton);
		cellDebugButtons.add(bottomRightOuterEdgeButton);
		bottomRightOuterEdgeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );	
		
		topOuterEdgeButton = new JToggleButton("|");
		topOuterEdgeButton.setBounds(186, 34, 42, 41);
		panel.add(topOuterEdgeButton);
		cellDebugButtons.add(topOuterEdgeButton);
		topOuterEdgeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		bottomOuterEdgeButton = new JToggleButton("|");
		bottomOuterEdgeButton.setBounds(186, 345, 42, 41);
		panel.add(bottomOuterEdgeButton);
		cellDebugButtons.add(bottomOuterEdgeButton);
		bottomOuterEdgeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		topRightOuterEdgeButton = new JToggleButton("/");
		topRightOuterEdgeButton.setBounds(310, 99, 42, 41);
		panel.add(topRightOuterEdgeButton);
		cellDebugButtons.add(topRightOuterEdgeButton);
		topRightOuterEdgeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		bottomLeftOuterEdgeButton = new JToggleButton("/");
		bottomLeftOuterEdgeButton.setBounds(58, 282, 42, 41);
		panel.add(bottomLeftOuterEdgeButton);
		cellDebugButtons.add(bottomLeftOuterEdgeButton);
		bottomLeftOuterEdgeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		JToggleButton toggleButton_11 = new JToggleButton(".");
		toggleButton_11.setBounds(186, 86, 42, 41);
		panel.add(toggleButton_11);
		cellDebugButtons.add(toggleButton_11);
		
		JToggleButton toggleButton_12 = new JToggleButton(".");
		toggleButton_12.setBounds(264, 138, 42, 41);
		panel.add(toggleButton_12);
		cellDebugButtons.add(toggleButton_12);
		
		JToggleButton toggleButton_13 = new JToggleButton(".");
		toggleButton_13.setBounds(264, 241, 42, 41);
		panel.add(toggleButton_13);
		cellDebugButtons.add(toggleButton_13);
		
		JToggleButton toggleButton_14 = new JToggleButton(".");
		toggleButton_14.setBounds(186, 293, 42, 41);
		panel.add(toggleButton_14);
		cellDebugButtons.add(toggleButton_14);
		
		JToggleButton toggleButton_15 = new JToggleButton(".");
		toggleButton_15.setBounds(106, 244, 42, 41);
		panel.add(toggleButton_15);
		cellDebugButtons.add(toggleButton_15);
		
		JToggleButton toggleButton_16 = new JToggleButton(".");
		toggleButton_16.setBounds(106, 140, 42, 41);
		panel.add(toggleButton_16);
		cellDebugButtons.add(toggleButton_16);
		
		JToggleButton toggleButton_17 = new JToggleButton("O");
		toggleButton_17.setBounds(285, 29, 50, 50);
		panel.add(toggleButton_17);
		cellDebugButtons.add(toggleButton_17);
		
		JToggleButton toggleButton_18 = new JToggleButton("O");
		toggleButton_18.setBounds(76, 29, 50, 50);
		panel.add(toggleButton_18);
		cellDebugButtons.add(toggleButton_18);
		
		JToggleButton toggleButton_19 = new JToggleButton("O");
		toggleButton_19.setBounds(76, 343, 50, 50);
		panel.add(toggleButton_19);
		cellDebugButtons.add(toggleButton_19);
		
		JToggleButton toggleButton_20 = new JToggleButton("O");
		toggleButton_20.setBounds(285, 345, 50, 50);
		panel.add(toggleButton_20);
		cellDebugButtons.add(toggleButton_20);
		
		JToggleButton toggleButton_21 = new JToggleButton("O");
		toggleButton_21.setBounds(316, 187, 50, 50);
		panel.add(toggleButton_21);
		cellDebugButtons.add(toggleButton_21);
		
		JToggleButton toggleButton_22 = new JToggleButton("O");
		toggleButton_22.setBounds(186, 187, 50, 50);
		panel.add(toggleButton_22);
		cellDebugButtons.add(toggleButton_22);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 410, 413, 2);
		panel.add(separator);
		
		JButton showAllButton = new JButton("show all");
		showAllButton.setBounds(43, 430, 133, 33);
		panel.add(showAllButton);
		showAllButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				for (JToggleButton aButton : cellDebugButtons) {
					aButton.setSelected(false);
					updateCellID();	
				}
			} 
		} );
		
		JButton hideAllButton = new JButton("hide all");
		hideAllButton.setBounds(232, 430, 150, 33);
		panel.add(hideAllButton);
		hideAllButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				for (JToggleButton aButton : cellDebugButtons) {
					aButton.setSelected(true);
					updateCellID();	
				}
			} 
		} );
		
		textField = new JTextField();
		textField.setBounds(168, 488, 112, 33);
		panel.add(textField);
		textField.setColumns(10);
				textField.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void changedUpdate(DocumentEvent arg0) {
					updateCellID();		
				}
				@Override
				public void insertUpdate(DocumentEvent arg0) {
					updateCellID();	
					
				}
				@Override
				public void removeUpdate(DocumentEvent arg0) {
					updateCellID();	
					
				}
				
		});


		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(134, 487, 27, 31);
		panel.add(lblId);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("edge debug", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("node debug", null, panel_2, null);
		
		bufferedCanvas = new BufferedCanvas(model);
		bufferedCanvas.setBackground(Color.WHITE);
		bufferedCanvas.setBounds(30, 30, 600, 600);
		contentPane.add(bufferedCanvas);

		
//		canvas = new InteractiveCanvas(this.model);
//		canvas.setBounds(30, 30, 600, 600);
//		contentPane.add(canvas);
		
        this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.bufferedCanvas.start();
		
	}
	
	private void updateCellSelection() {
		cellSelection.topLeftEdge = !topLeftEdgeButton.isSelected();
		cellSelection.bottomRightEdge = !bottomRightEdgeButton.isSelected();
		cellSelection.leftEdge = !leftEdgeButton.isSelected(); 
		cellSelection.rightEdge = !rightEdgeButton.isSelected();
		cellSelection.bottomLeftEdge = !bottomLeftEdgeButton.isSelected();
		cellSelection.topRightEdge = !topRightEdgeButton.isSelected();
		
		cellSelection.topRightOuterEdge = !topRightOuterEdgeButton.isSelected();
		cellSelection.bottomLeftOuterEdge = !bottomLeftOuterEdgeButton.isSelected();
		cellSelection.topOuterEdge = !topOuterEdgeButton.isSelected(); 
		cellSelection.bottomOuterEdge = !bottomOuterEdgeButton.isSelected();
		cellSelection.bottomRightOuterEdge = !bottomRightOuterEdgeButton.isSelected();
		cellSelection.topLeftOuterEdge = !topLeftOuterEdgeButton.isSelected();
		
		cellSelection.rightCell = false;
		cellSelection.leftCell = false;
		cellSelection.topRightCell = false;
		cellSelection.topLeftCell = false;
		cellSelection.bottomRightCell = false;
		cellSelection.bottomLeftCell = false;
		
		cellSelection.topNode = false;
		cellSelection.bottomLeftNode = false;
		cellSelection.bottomRightNode = false;
		cellSelection.bottomNode = false;
		cellSelection.topLeftNode = false;
		cellSelection.topRightNode = false;
	}
	
	public void updateCellID() {
		try {
			currentCellID = Integer.parseInt(textField.getText());
			updateCellSelection();
			model.debugCell(currentCellID, cellSelection, bufferedCanvas);
		} catch	(NumberFormatException nfe) {
			currentCellID = -1;
			System.out.println("currentCellID : format error");
		}
		
		
	}
}
