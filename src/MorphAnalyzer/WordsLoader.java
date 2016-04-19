/*
 * WordsLoader.java
 *
 * Created on January 1, 2006, 3:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package MorphAnalyzer;

import java.sql.*;
import java.util.*;
/**
 *
 * @author Solomon See
 */
public class WordsLoader {
    Connection con;
    ResultSet rs;
    public static final int TRAINING=0;
    public static final int TEST=1;
    /** Creates a new instance of WordsLoader */
    public WordsLoader(int type) throws Exception {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con = DriverManager.getConnection("jdbc:odbc:Words","sa","masterkey");
        if (type == TRAINING)
            rs = con.createStatement().executeQuery("select * from trainingData order by words");
        else
            rs = con.createStatement().executeQuery("select * from testData order by words");
    }    
    public WordPair nextPair() throws Exception {
        if (rs.next())
            return new WordPair(rs.getString("Words"),rs.getString("Root word"), WordSemantic.parse(rs.getString("POS Original Text") + ":" + rs.getString("Tense of Original Text")));
        else {
            con.close();
            return null;            
        }
    }
    public WordPair nextPairNoSemantic() throws Exception {
        if (rs.next())
            return new WordPair(rs.getString("Words"),rs.getString("Root word"));
        else {
            con.close();
            return null;            
        }
    }    
}

class WordPair {
    public String morphed;
    public Vector<WordSemantic> semanticInformations;
    public String root;
    public WordPair(String morphed, String root) {
        this.morphed = morphed;
        this.root = root;
        this.semanticInformations = null;
    }
    public WordPair(String morphed, String root, Vector<WordSemantic> semanticInformations) {
        this.morphed = morphed;
        this.root = root;
        this.semanticInformations = semanticInformations;
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (semanticInformations != null) {
            for(int i=0;i<semanticInformations.size()-1;i++)
                sb.append(semanticInformations.elementAt(i).toString() + ",");
            sb.append(semanticInformations.elementAt(semanticInformations.size()-1).toString());
        }
        return morphed + "-->" + root + ":" + sb.toString();
    }
}