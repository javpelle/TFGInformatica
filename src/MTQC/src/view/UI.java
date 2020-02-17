package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.Controller;
import model.Observable;
import model.Observer;
import model.mutant.Mutant;
import model.mutantoperator.MutantOperator;
import view.MenuBar.LanguageListener;
import view.mutantgeneratorview.Files.NewPathListener;
import view.mutantgeneratorview.MutantsGenerator.NewGenerateListener;

public class UI extends JFrame implements Observer {

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
	private TabbedPane tabbedPane;

	/**
	 * Constructor of view
	 * 
	 * @param c a Controller
	 * @param o an Observable for add this view as observer.
	 */
	public UI(Controller c, Observable<Observer> o) {
		super("Mutation Testing for Quantum Computing");
		// Add this view as observer
		o.addObserver(this);

		setIconImage(new ImageIcon("icon.jpg").getImage());

		// Size and Layout of view
		setSize(new Dimension(960, 540));
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        c.removeMutants();
		    }
		});

		// Add menu bar
		menuBar = new MenuBar(new LanguageListener() {

			@Override
			public void languageChosen(boolean qiskit) {
				c.updateLanguage(qiskit);
			}

		});
		setJMenuBar(menuBar);

		// Add tabbed pane
		tabbedPane = new TabbedPane(new NewPathListener() {

			@Override
			public void updatePath(String path) {
				c.updatePath(path);
			}

		}, new NewGenerateListener(){

			@Override
			public void generate(ArrayList<String> files, ArrayList<MutantOperator> operators) {
				c.generate(files, operators);
				
			}
			
			
			
		});
		add(tabbedPane, BorderLayout.CENTER);

		setVisible(true);
	}

	@Override
	public void onError(String msg) {
		JFrame error = new JFrame();
		JOptionPane.showMessageDialog(error, msg);
	}

	@Override
	public void updateMutantOperators(MutantOperator[] mutantOperatorList) {
		tabbedPane.updateOperators(mutantOperatorList);
	}

	@Override
	public void updatePath(ArrayList<String> files) {
		tabbedPane.updatePath(files);
	}

	@Override
	public void updateMutants(ArrayList<Mutant> mutantList) {
		tabbedPane.updateMutants(mutantList);	
	}

}
