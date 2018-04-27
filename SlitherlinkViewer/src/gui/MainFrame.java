package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultFormatter;

import model.Model;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public Model model;
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
	
	private JToggleButton selfCellButton;
	
	private NodeDebugPanel nodeDebugPanel;
	
	private JToggleButton selfNodeButton;
	
	private JToggleButton topCellForNodeButton;
	private JToggleButton bottomCellForNodeButton;
	private JToggleButton topLeftCellForNodeButton;
	private JToggleButton topRightCellForNodeButton;
	private JToggleButton bottomLeftCellForNodeButton;
	private JToggleButton bottomRightCellForNodeButton;
	
	private JToggleButton bottomLeftEdgeForNodeButton;
	private JToggleButton topRightEdgeForNodeButton;
	private JToggleButton topLeftEdgeForNodeButton;
	private JToggleButton bottomRightEdgeForNodeButton;
	private JToggleButton topEdgeForNodeButton;
	private JToggleButton bottomEdgeForNodeButton;
	
	JSpinner nodeSpinner;
	private JSpinner cellSpinner;
	
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


		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(134, 487, 27, 31);
		panel.add(lblId);
		
		cellSpinner = new JSpinner();
		cellSpinner.setBounds(164, 485, 116, 33);
		panel.add(cellSpinner);
		JComponent cellComp = cellSpinner.getEditor();
	    JFormattedTextField cellField = (JFormattedTextField) cellComp.getComponent(0);
	    DefaultFormatter cellFormatter = (DefaultFormatter) cellField.getFormatter();
	    cellFormatter.setCommitsOnValidEdit(true);
	    cellSpinner.addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            updateCellID();
	        }
	    });
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("edge debug", null, panel_1, null);
		
		nodeDebugPanel = new NodeDebugPanel();
		tabbedPane.addTab("node debug", null, nodeDebugPanel, null);
		nodeDebugPanel.setLayout(null);
		
		
		selfNodeButton = new JToggleButton(".");
		selfNodeButton.setBounds(188, 172, 42, 41);
		nodeDebugPanel.add(selfNodeButton);
		nodeDebugButtons.add(selfNodeButton);
		selfNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		
		topCellForNodeButton = new JToggleButton("O");
		topCellForNodeButton.setBounds(183, 45, 50, 50);
		nodeDebugPanel.add(topCellForNodeButton);
		nodeDebugButtons.add(topCellForNodeButton);
		topCellForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		bottomCellForNodeButton = new JToggleButton("O");
		bottomCellForNodeButton.setBounds(184, 293, 50, 50);
		nodeDebugPanel.add(bottomCellForNodeButton);
		nodeDebugButtons.add(bottomCellForNodeButton);
		bottomCellForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		topLeftCellForNodeButton = new JToggleButton("O");
		topLeftCellForNodeButton.setBounds(49, 64, 50, 50);
		nodeDebugPanel.add(topLeftCellForNodeButton);
		nodeDebugButtons.add(topLeftCellForNodeButton);
		topLeftCellForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		topRightCellForNodeButton = new JToggleButton("O");
		topRightCellForNodeButton.setBounds(315, 64, 50, 50);
		nodeDebugPanel.add(topRightCellForNodeButton);
		nodeDebugButtons.add(topRightCellForNodeButton);
		topRightCellForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		bottomLeftCellForNodeButton = new JToggleButton("O");
		bottomLeftCellForNodeButton.setBounds(49, 272, 50, 50);
		nodeDebugPanel.add(bottomLeftCellForNodeButton);
		nodeDebugButtons.add(bottomLeftCellForNodeButton);
		bottomLeftCellForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		bottomRightCellForNodeButton = new JToggleButton("O");
		bottomRightCellForNodeButton.setBounds(315, 272, 50, 50);
		nodeDebugPanel.add(bottomRightCellForNodeButton);
		nodeDebugButtons.add(bottomRightCellForNodeButton);
		bottomRightCellForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		bottomLeftEdgeForNodeButton = new JToggleButton("/");
		bottomLeftEdgeForNodeButton.setBounds(106, 226, 42, 41);
		nodeDebugPanel.add(bottomLeftEdgeForNodeButton);
		nodeDebugButtons.add(bottomLeftEdgeForNodeButton);
		bottomLeftEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		topRightEdgeForNodeButton = new JToggleButton("/");
		topRightEdgeForNodeButton.setBounds(273, 122, 42, 41);
		nodeDebugPanel.add(topRightEdgeForNodeButton);
		nodeDebugButtons.add(topRightEdgeForNodeButton);
		topRightEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		topLeftEdgeForNodeButton = new JToggleButton("\\");
		topLeftEdgeForNodeButton.setBounds(104, 121, 42, 41);
		nodeDebugPanel.add(topLeftEdgeForNodeButton);
		nodeDebugButtons.add(topLeftEdgeForNodeButton);
		topLeftEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		bottomRightEdgeForNodeButton = new JToggleButton("\\");
		bottomRightEdgeForNodeButton.setBounds(273, 226, 42, 41);
		nodeDebugPanel.add(bottomRightEdgeForNodeButton);
		nodeDebugButtons.add(bottomRightEdgeForNodeButton);
		bottomRightEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		topEdgeForNodeButton = new JToggleButton("|");
		topEdgeForNodeButton.setBounds(188, 120, 42, 41);
		nodeDebugPanel.add(topEdgeForNodeButton);
		nodeDebugButtons.add(topEdgeForNodeButton);
		topEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		bottomEdgeForNodeButton = new JToggleButton("|");
		bottomEdgeForNodeButton.setBounds(188, 226, 42, 41);
		nodeDebugPanel.add(bottomEdgeForNodeButton);
		nodeDebugButtons.add(bottomEdgeForNodeButton);
		bottomEdgeForNodeButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				updateNodeID();
			} 
		} );
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 384, 413, 2);
		nodeDebugPanel.add(separator_1);
		
		JButton showAllNodeDebugButton = new JButton("show all");
		showAllNodeDebugButton.setBounds(49, 403, 133, 33);
		nodeDebugPanel.add(showAllNodeDebugButton);
		showAllNodeDebugButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				for (JToggleButton aButton : nodeDebugButtons) {
					aButton.setSelected(false);
					updateNodeID();	
				}
			} 
		} );
		
		JButton hideAllNodeDebugButton = new JButton("hide all");
		hideAllNodeDebugButton.setBounds(234, 403, 150, 33);
		nodeDebugPanel.add(hideAllNodeDebugButton);
		hideAllNodeDebugButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				for (JToggleButton aButton : nodeDebugButtons) {
					aButton.setSelected(true);
					updateNodeID();	
				}
			} 
		} );
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(133, 473, 27, 31);
		nodeDebugPanel.add(label);
		
		nodeSpinner = new JSpinner();
		nodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		nodeSpinner.setBounds(170, 474, 116, 33);
		nodeDebugPanel.add(nodeSpinner);
		JComponent nodeComp = nodeSpinner.getEditor();
	    JFormattedTextField nodeField = (JFormattedTextField) nodeComp.getComponent(0);
	    DefaultFormatter nodeFormatter = (DefaultFormatter) nodeField.getFormatter();
	    nodeFormatter.setCommitsOnValidEdit(true);
	    nodeSpinner.addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
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
		
		nodeSelection.topRightCell = !topRightCellForNodeButton.isSelected();
		nodeSelection.topLeftCell = !topLeftCellForNodeButton.isSelected();
		nodeSelection.bottomCell = !bottomCellForNodeButton.isSelected();
		nodeSelection.topCell = !topCellForNodeButton.isSelected();
		nodeSelection.bottomRightCell = !bottomRightCellForNodeButton.isSelected();
		nodeSelection.bottomLeftCell = !bottomLeftCellForNodeButton.isSelected();
		
		nodeSelection.selfNode = !selfNodeButton.isSelected();

	}
	
	public void updateCellID() {
		try {
			currentCellID = (int) cellSpinner.getValue();
		} catch	(NumberFormatException nfe) {
			currentCellID = -1;
		}
		updateCellSelection();
		model.debugCell(currentCellID, cellSelection);
	}
	
	public void updateNodeID() {
		try {
			currentNodeID = (int) nodeSpinner.getValue();
		} catch	(NumberFormatException nfe) {
			currentNodeID = -1;
		}
		updateNodeSelection();
		model.debugNodes(currentNodeID, nodeSelection);
	}
}
