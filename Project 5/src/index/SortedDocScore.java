/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;
import io.DocSource;
import io.FileFinder;
import java.io.*;
import java.util.*;


/**
 *
 * @author Matthew Kwan, matthewky.kwan@gmail.com
 */
public class SortedDocScore extends DocScore implements Comparable {
    

    public SortedDocScore(double score, int doc_id, String content) {
        super(score ,doc_id ,content);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof SortedDocScore)) {
            return 1;
        }
            
        SortedDocScore d = (SortedDocScore)o;
            
            if (this._score == d._score) {  
                return this._content.compareTo(d._content);
            }

            else if (this._score < d._score)
                return 1;
            
            else {
                return -1;
            }  
            
        }
    }
    
    /* @Override
    public int compareTo (Object o) {
        if (o instanceof ElementSet) 
            return 1;
            
        ElementSet e = (ElementSet)o;
            
        if (this._id == e._id) {
            return 0;
        }
            
        else if (this._id < e._id) {
            return -1;
        }
            
        else {
            return 1;
        }
    }
        */



