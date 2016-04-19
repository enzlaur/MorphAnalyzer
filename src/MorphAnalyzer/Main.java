package MorphAnalyzer;

import DataStructures.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
	MorphLearnerRedup mpl = new MorphLearnerRedup();
    WordsLoader training = new WordsLoader(WordsLoader.TRAINING);
	
	private JButton analyze;
	private JTextField input, output;
	private JLabel  inWord, root; 
	
	public Main () throws Exception {
		super("Analysis");
		WordPair wp;
        
        Container c = getContentPane();
        c.setLayout (new FlowLayout());
        
        analyze = new JButton ("Pindutin mo");
        
        inWord = new JLabel ("Ipasok mo dito");
        root = new JLabel ("Lalabas dito");
        input = new JTextField (15);
        output = new JTextField (15);
        c.add (inWord);
        c.add (input);
        c.add (root);
        c.add (output);
        c.add (analyze);

        analyze.addActionListener ( 
           new ActionListener () {
   		      public void actionPerformed (ActionEvent e)
   		      {
   		         String root;
		
		         root = mpl.analyzeMultipleMod(input.getText()).result;
		        // root = analyze(input.getText());
		         output.setText (root);
   		      }
           }
        );
        setSize(500, 200);
        show();
/*        while( (wp=training.nextPair()) != null) {
            mpl.extractRule(wp.morphed, wp.root);
        }
        mpl.smoothTrie(); 
        mpl.saveFile("C:\\morphRules.dat");*/
        //mpl = MorphLearnerRedup.loadFile("C:\\morphRules.dat");
	}
	
/*	public void actionPerformed (ActionEvent e)
	{
	}
	
	public String analyze(String morphed) throws Exception  {
		return mpl.analyzeMultipleMod(morphed).result;
	}
*/	
	
	public static void main(String[] args) throws Exception 
	{
		Main m = new Main();
		m.addWindowListener( new WindowAdapter() {
			public void windowClosing (WindowEvent e)
			{
				System.exit (0);
			}
		});
		
		
//		System.out.println(m.analyze("kinakain"));
	}
}
