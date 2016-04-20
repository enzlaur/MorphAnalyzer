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
        
        analyze = new JButton ("Pindutin mo ako");
        
        inWord = new JLabel ("Lagay-Loob");
        root = new JLabel ("Lagay-labas");
        input = new JTextField (15);
        output = new JTextField (15);
        c.add (inWord);
        c.add (input);
        c.add (analyze);
        c.add (root);
        c.add (output);
        

        /*
         * Included GUI
         */
        /*analyze.addActionListener ( 
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
        setSize(650, 100);
        show();*/
        
        
        
        
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
	
	public void noGUI(String input)
	{
		
		WordPair wp;
		println("Finding root of: " + input);	
        String root = ""; 
        root = mpl.analyzeMultipleMod(input).result;
        //root = mpl.analyzeMultipleModWithSemantic2(input).result;
        println("Result is:  " + root);
	}
	
	public static void main(String[] args) throws Exception 
	{
		/*Main m = new Main();
		m.addWindowListener( new WindowAdapter() {
			public void windowClosing (WindowEvent e)
			{
				System.exit (0);
			}
		});*/
		
		
//		System.out.println(m.analyze("kinakain"));
		
		Main m = new Main();
		m.noGUI("pinagpaliban");
	}
	
	public static void println(String in)
	{
		System.out.println("" + in);	
	}
}
