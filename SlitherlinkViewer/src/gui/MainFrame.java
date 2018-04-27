package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public Model model;
	private JTextField cellIdTextField;
	public ArrayList<JToggleButton> cellDebugButtons;
	public ArrayList<JToggleButton> nodeDebugButtons;
	public CellSelection cellSelection;
	public NodeSelection nodeSelection;
	public int currentCellID = -1;
	public int currentNodeID = -1;

	/**
	 * Create the frame.
	 */

	BufferedCanvas bufferedCanvas;
	
	private JToggleButton leftEdgeButton;
	private JToggleButton topLeftEdgeButton;
	private JToggleButton topRightEdgeButton;
	private JToggleButton rightEdgeButton;
	private JToggleButton bottomRightEdgeButton;
	private JToggleButton bottomLeftEdgeButton;
	
	private JToggleButton topLeftOuterEdgeButton;
	private JToggleButton topOuterEdgeButton;
	private JToggleButton topRightOuterEdgeButton;
	private JToggleButton bottomOuterEdgeButton;
	private JToggleButton bottomLeftOuterEdgeButton;
	private JToggleButton bottomRightOuterEdgeButton;
	
	private JToggleButton topNodeButton;
	private JToggleButton bottomNodeButton;
	private JToggleButton topLeftNodeButton;
	private JToggleButton topRightNodeButton;
	private JToggleButton bottomLeftNodeButton;
	private JToggleButton bottomRightNodeButton;
	
	private JToggleButton leftCellButton;
	private JToggleButton rightCellButton;
	private JToggleButton topLeftCellButton;
	private JToggleButton topRightCellButton;
	private JToggleButton bottomLeftCellButton;
	private JToggleButton bottomRightCellButton;
	
	JToggleButton selfCellButton;
	
	private NodeDebugPanel nodeDebugPanel;
	
	private JToggleButton selfNodeButton;
	private JToggleButton toggleButton_1;
	private JToggleButton toggleButton_2;
	private JToggleButton toggleButton_3;
	private JToggleButton toggleButton_4;
	private JToggleButton toggleButton_5;
	private JToggleButton toggleButton_6;
	
	private JToggleButton bottomLeftEdgeForNodeButton;
	private JToggleButton topRightEdgeForNodeButton;
	private JToggleButton topLeftEdgeForNodeButton;
	private JToggleButton bottomRightEdgeForNodeButton;
	private JToggleButton topEdgeForNodeButton;
	private JToggleButton bottomEdgeForNodeButton;
	
	private JTextField nodeIdTextField;
	
	public MainFrame(Model model) {
		
		this.model = model;
		cellSelection = new CellSelection();
		nodeSelection = new NodeSelection();
		
		cellDebugButtons = new ArrayList<JToggleButton>();
		nodeDebugButtons = new ArrayList<JToggleButton>();
		
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
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            System.out.println("Tab: " + tabbedPane.getSelectedIndex());
	        }
	    });
		
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
		
		leftCellButton = new JToggleButton("O");
		leftCellButton.setBounds(43, 187, 50, 50);
		panel.add(leftCellButton);
		cellDebugButtons.add(leftCellButton);
		leftCellButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					updateCellID();
			} 
		} );
		
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
		
		topNodeButton = new JToggleButton(".");
		topNodeButton.setBounds(186, 86, 42, 41);
		panel.add(topNodeButton);
		cellDebugButtons.add(topNodeButton);
		topNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		topRightNodeButton = new JToggleButton(".");
		topRightNodeButton.setBounds(264, 138, 42, 41);
		panel.add(topRightNodeButton);
		cellDebugButtons.add(topRightNodeButton);
		topRightNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		
		bottomRightNodeButton = new JToggleButton(".");
		bottomRightNodeButton.setBounds(264, 241, 42, 41);
		panel.add(bottomRightNodeButton);
		cellDebugButtons.add(bottomRightNodeButton);
		bottomRightNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		bottomNodeButton = new JToggleButton(".");
		bottomNodeButton.setBounds(186, 293, 42, 41);
		panel.add(bottomNodeButton);
		cellDebugButtons.add(bottomNodeButton);
		bottomNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		
		bottomLeftNodeButton = new JToggleButton(".");
		bottomLeftNodeButton.setBounds(106, 244, 42, 41);
		panel.add(bottomLeftNodeButton);
		cellDebugButtons.add(bottomLeftNodeButton);
		bottomLeftNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		topLeftNodeButton = new JToggleButton(".");
		topLeftNodeButton.setBounds(106, 140, 42, 41);
		panel.add(topLeftNodeButton);
		cellDebugButtons.add(topLeftNodeButton);
		topLeftNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		topRightCellButton = new JToggleButton("O");
		topRightCellButton.setBounds(285, 29, 50, 50);
		panel.add(topRightCellButton);
		cellDebugButtons.add(topRightCellButton);
		topRightCellButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		topLeftCellButton = new JToggleButton("O");
		topLeftCellButton.setBounds(76, 29, 50, 50);
		panel.add(topLeftCellButton);
		cellDebugButtons.add(topLeftCellButton);
		topLeftCellButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		bottomLeftCellButton = new JToggleButton("O");
		bottomLeftCellButton.setBounds(76, 343, 50, 50);
		panel.add(bottomLeftCellButton);
		cellDebugButtons.add(bottomLeftCellButton);
		bottomLeftCellButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		bottomRightCellButton = new JToggleButton("O");
		bottomRightCellButton.setBounds(285, 345, 50, 50);
		panel.add(bottomRightCellButton);
		cellDebugButtons.add(bottomRightCellButton);
		bottomRightCellButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		rightCellButton = new JToggleButton("O");
		rightCellButton.setBounds(316, 187, 50, 50);
		panel.add(rightCellButton);
		cellDebugButtons.add(rightCellButton);
		rightCellButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
		selfCellButton = new JToggleButton("O");
		selfCellButton.setBounds(186, 187, 50, 50);
		panel.add(selfCellButton);
		cellDebugButtons.add(selfCellButton);
		selfCellButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateCellID();
			} 
		} );
		
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
		
		cellIdTextField = new JTextField("2");
		cellIdTextField.setBounds(168, 488, 112, 33);
		panel.add(cellIdTextField);
		cellIdTextField.getDocument().addDocumentListener(new DocumentListener() {
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
		
		nodeDebugPanel = new NodeDebugPanel();
		tabbedPane.addTab("node debug", null, nodeDebugPanel, null);
		nodeDebugPanel.setLayout(null);
		
		
		selfNodeButton = new JToggleButton(".");
		selfNodeButton.setBounds(188, 172, 42, 41);
		nodeDebugPanel.add(selfNodeButton);
		cellDebugButtons.add(selfNodeButton);
		selfNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		
		toggleButton_1 = new JToggleButton("O");
		toggleButton_1.setBounds(70, 169, 50, 50);
		nodeDebugPanel.add(toggleButton_1);
		
		toggleButton_2 = new JToggleButton("O");
		toggleButton_2.setBounds(303, 170, 50, 50);
		nodeDebugPanel.add(toggleButton_2);
		
		toggleButton_3 = new JToggleButton("O");
		toggleButton_3.setBounds(114, 60, 50, 50);
		nodeDebugPanel.add(toggleButton_3);
		
		toggleButton_4 = new JToggleButton("O");
		toggleButton_4.setBounds(252, 60, 50, 50);
		nodeDebugPanel.add(toggleButton_4);
		
		toggleButton_5 = new JToggleButton("O");
		toggleButton_5.setBounds(114, 285, 50, 50);
		nodeDebugPanel.add(toggleButton_5);
		
		toggleButton_6 = new JToggleButton("O");
		toggleButton_6.setBounds(252, 286, 50, 50);
		nodeDebugPanel.add(toggleButton_6);
		
		bottomLeftEdgeForNodeButton = new JToggleButton("/");
		bottomLeftEdgeForNodeButton.setBounds(106, 226, 42, 41);
		nodeDebugPanel.add(bottomLeftEdgeForNodeButton);
		bottomLeftEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		topRightEdgeForNodeButton = new JToggleButton("/");
		topRightEdgeForNodeButton.setBounds(273, 122, 42, 41);
		nodeDebugPanel.add(topRightEdgeForNodeButton);
		topRightEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		topLeftEdgeForNodeButton = new JToggleButton("\\");
		topLeftEdgeForNodeButton.setBounds(104, 121, 42, 41);
		nodeDebugPanel.add(topLeftEdgeForNodeButton);
		topLeftEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		bottomRightEdgeForNodeButton = new JToggleButton("\\");
		bottomRightEdgeForNodeButton.setBounds(273, 226, 42, 41);
		nodeDebugPanel.add(bottomRightEdgeForNodeButton);
		bottomRightEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		topEdgeForNodeButton = new JToggleButton("|");
		topEdgeForNodeButton.setBounds(188, 64, 42, 41);
		nodeDebugPanel.add(topEdgeForNodeButton);
		topEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		bottomEdgeForNodeButton = new JToggleButton("|");
		bottomEdgeForNodeButton.setBounds(188, 277, 42, 41);
		nodeDebugPanel.add(bottomEdgeForNodeButton);
		bottomEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 384, 413, 2);
		nodeDebugPanel.add(separator_1);
		
		JButton button = new JButton("show all");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(49, 403, 133, 33);
		nodeDebugPanel.add(button);
		
		JButton button_1 = new JButton("hide all");
		button_1.setBounds(234, 403, 150, 33);
		nodeDebugPanel.add(button_1);
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(133, 473, 27, 31);
		nodeDebugPanel.add(label);
		
		nodeIdTextField = new JTextField("2");
		nodeIdTextField.setColumns(10);
		nodeIdTextField.setBounds(167, 474, 112, 33);
		nodeDebugPanel.add(nodeIdTextField);
		nodeIdTextField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				updateNodeID();		
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				updateNodeID();						
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				updateNodeID();						
			}				
	});
		
		bufferedCanvas = new BufferedCanvas(model);
		bufferedCanvas.setBackground(Color.WHITE);
		bufferedCanvas.setBounds(30, 30, 600, 600);
		contentPane.add(bufferedCanvas);
		
        this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.bufferedCanvas.start();
		this.updateCellID();
		
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
		
		cellSelection.rightCell = !rightCellButton.isSelected();
		cellSelection.leftCell = !leftCellButton.isSelected();
		cellSelection.topRightCell = !topRightCellButton.isSelected();
		cellSelection.topLeftCell = !topLeftCellButton.isSelected();
		cellSelection.bottomRightCell = !bottomRightCellButton.isSelected();
		cellSelection.bottomLeftCell = !bottomLeftCellButton.isSelected();
		
		cellSelection.topNode = !topNodeButton.isSelected();
		cellSelection.bottomLeftNode = !bottomLeftNodeButton.isSelected();
		cellSelection.bottomRightNode = !bottomRightNodeButton.isSelected();
		cellSelection.bottomNode = !bottomNodeButton.isSelected();
		cellSelection.topLeftNode = !topLeftNodeButton.isSelected();
		cellSelection.topRightNode = !topRightNodeButton.isSelected();
		
		cellSelection.selfCell = !selfCellButton.isSelected();
	}
	
	private void updateNodeSelection() {
		
		nodeSelection.topLeftEdge = !topLeftEdgeForNodeButton.isSelected();
		nodeSelection.bottomRightEdge = !bottomRightEdgeForNodeButton.isSelected();
		nodeSelection.topEdge = !topEdgeForNodeButton.isSelected(); 
		nodeSelection.bottomEdge = !bottomEdgeForNodeButton.isSelected();
		nodeSelection.bottomLeftEdge = !bottomLeftEdgeForNodeButton.isSelected();
		nodeSelection.topRightEdge = !topRightEdgeForNodeButton.isSelected();		
		
		nodeSelection.topCell = false;
		nodeSelection.bottomCell = false;
		nodeSelection.topRightCell = false;
		nodeSelection.topLeftCell = false;
		nodeSelection.bottomRightCell = false;
		nodeSelection.bottomLeftCell = false;
		
		nodeSelection.selfNode = !selfNodeButton.isSelected();

	}
	
	public void updateCellID() {
		try {
			currentCellID = Integer.parseInt(cellIdTextField.getText());
		} catch	(NumberFormatException nfe) {
			currentCellID = -1;
		}
		updateCellSelection();
		model.debugCell(currentCellID, cellSelection);
	}
	
	public void updateNodeID() {
		try {
			currentNodeID = Integer.parseInt(nodeIdTextField.getText());
		} catch	(NumberFormatException nfe) {
			currentNodeID = -1;
		}
		updateNodeSelection();
		model.debugNodes(currentNodeID, nodeSelection);
	}
}
