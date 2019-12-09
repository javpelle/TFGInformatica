package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import control.Controller;
import model.Observable;
import model.Observer;

public class UI extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private MenuBar menuBar;
	
	/**
	 * 
	 */
	private ToolBar toolBar;
	
	/**
	 * Constructor of view
	 * @param c
	 * 		a Controller
	 * @param o
	 * 		an Observable for add this view as observer.
	 */
	public UI(Controller c, Observable<Observer> o) {
		super("Mutation Testing for Quantum Computing");
		// Add this view as observer
		o.addObserver(this);
		
		setIconImage(new ImageIcon("icon.jpg").getImage());
		
		// Size and Layout of view
		setSize(new Dimension(1150, 700));
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add menu bar
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		// Add tool bar
		toolBar = new ToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		// Add Text Area
		add(new JTextArea(), BorderLayout.CENTER);
		
		setVisible(true);
	}



	@Override
	public void onError(String msg) {
		JFrame error = new JFrame();
		JOptionPane.showMessageDialog(error, msg);		
	}

}
