/*
 * SuffixTrie.java
 *
 * Created on May 15, 2005, 8:45 PM
 */

package DataStructures;

/**
 *
 * @author Solomon See
 */
import java.util.*;
import java.io.Serializable;
public class SuffixTrie<E> extends Trie<E> implements Serializable{
    
    /** Creates a new instance of SuffixTrie */
    public SuffixTrie(AbstractTrieImpl<E> impl) {
        super(impl);
    }
    public void store(String s){        
        super.store(new StringBuffer(s).reverse().toString());
    }
    public void store(String s, E obj){        
        super.store(new StringBuffer(s).reverse().toString(), obj);
    }    
    public void remove(String s) {
        super.remove(new StringBuffer(s).reverse().toString());
    }
    public void remove(String s, E obj) {
        super.remove(new StringBuffer(s).reverse().toString(), obj);
    }    
    public boolean lookup(String s){
        return impl.lookup(new StringBuffer(s).reverse().toString());
    }
    
    /**
     * @param String s
     * s is the input string.
     * @return
     * A vector which contains the suffixes to be removed.
     * It gets the string then reverses it then somehow you get the suffix through some form of magic.
     */
    public Vector<String> getAllPossibleMatch(String s) 
    {
    	Vector<String> v = new Vector();
        // if s = pinaglaban
        s = new StringBuffer(s).reverse().toString(); //s = nabalganip 
        println("\n s = new StringBuffer: " + s + "\n");
        Vector<String> v2= super.getAllPossibleMatch(s); // v2[0] = "na"
        println("v2.capacity: " + v2.capacity());
        println("\n v2 = super.getAll: " + v2.get(0) + "\n");
        for(int i=0;i<v2.size();i++)
        {
        	println("v2.elementAt(i)).toString(): " + v2.elementAt(i).toString());
            v.add(new StringBuffer(v2.elementAt(i)).reverse().toString());
        }
        
        // Returns a vector which contains the suffixes to be removed
        return v;
    }
    public String getGreatestCommon(String s) {
        s = new StringBuffer(s).reverse().toString();
        return new StringBuffer(super.getGreatestCommon(s)).reverse().toString();
    }
    public CountingTable getObjectList(String s) {
        return impl.getObjectList(new StringBuffer(s).reverse().toString());
    }    
    public Vector<String> getContents() {
        Vector<StringBuffer> vSB = impl.getContents();
        Vector v = new Vector(vSB.size());
        int i;
        
        for(i=0;i<vSB.size();i++)
            v.addElement(vSB.elementAt(i).reverse().toString());
        return v;        
    }    
    public Hashtable possibleMatchList(String word, Hashtable masterRuleList) {
        word = new StringBuffer(word).reverse().toString();
        return super.possibleMatchList(word, masterRuleList);
    }
    protected String appendPartialMatch(String s, char c) {
        return c + s;
    }
    
    public static void println(String s)
    {
    	System.out.println("" + s);
    }
}
