/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import io.DocSource;
import java.util.ArrayList;
import score.TermScoringFun;
import tokenizer.Tokenizer;
import java.util.*;
import java.io.*;

/** 
 *
 * @author Matthew Kwan, matthewky.kwan@gmail.com
 */
public class InvertedIndex extends Index {
    
    private HashMap<String,HashMap<Integer,Integer>> index;
    private HashMap<Integer,Integer> id_freq;
    private HashMap<String,Integer> _docFreq;
    private HashMap<Integer,Double> _sortedSearch;

    public InvertedIndex(DocSource doc_source, Tokenizer tokenizer, TermScoringFun scoring) {
        super(doc_source, tokenizer, scoring);
    }
    

    @Override
    public void buildIndex() {
        
        _docFreq = new HashMap();
        index = new HashMap();
   
        for (int i = 0 ; i<_docSource.getNumDocs() ; i++ ) {
            String content = _docSource.getDoc(i);
            ArrayList<String> tokens = _tokenizer.tokenize(content);
            
            for (String term: tokens) {
                
                if (!(index.containsKey(term))) {
                    id_freq = new HashMap();
                    id_freq.put(i, Collections.frequency(tokens,term));
                    _docFreq.put(term,1);
                    index.put(term, id_freq);
                }
                
                else {
                    if (!(index.get(term).containsKey(i))){
                        index.get(term).put(i,Collections.frequency(tokens,term));
                        _docFreq.replace(term,(_docFreq.get(term)+1));
                    
                    }
                }
          
            }    
        }
            
          
    }

    @Override
    public int getDocumentFreq(String term) {
        return _docFreq.get(term);
    }

    
    //Data member from Index.java / protected TermScoringFun _scoring;
    @Override
    public ArrayList<DocScore> getSortedSearchResults(String query) {
      //  HashSet<Integer> tot_freq = new HashSet();
      //  tot_freq = ;
      ArrayList<String> _query = _tokenizer.tokenize(query);
      _sortedSearch = new HashMap<Integer,Double>();
      
        for (String word: _query){ 
            for(int j=0 ; j<_docSource.getNumDocs(); j++) {         
                
                
                if (index.containsKey(word)) {
                    if (index.get(word).containsKey(j)){
                        if (!(_sortedSearch.containsKey(j))) {
                            _sortedSearch.put(j,_scoring.scoreToken(word,index.get(word).get(j)));
                        }
                        else {
                            _sortedSearch.replace(j, (_sortedSearch.get(j)+_scoring.scoreToken(word,index.get(word).get(j))));
                        }
                    }
                        
                }
                
                /*if (!(_sortedSearch.containsKey(j))) {
                    if (index.containsKey(word)) {
                        if (index.get(word).containsKey(j))
                            _sortedSearch.put(j,_scoring.scoreToken(word,index.get(word).get(j)));
                    }
                }
                else {
                    if (index.containsKey(word)) {
                        if (index.get(word).containsKey(j)) {
                            _sortedSearch.replace(j, (_sortedSearch.get(j)+_scoring.scoreToken(word,index.get(word).get(j))));
                        }
                    }
                    
                }*/
            }
        }
        
       // System.out.print(_sortedSearch.size() + "SIZE"); // TEST SIZE
        TreeSet<SortedDocScore> _SortedScore = new TreeSet();
        
       
        
        for (HashMap.Entry<Integer,Double> Sorted : _sortedSearch.entrySet() ) {
            Integer key = Sorted.getKey();
            Double value = Sorted.getValue();
            
            SortedDocScore entry = new SortedDocScore(value,key,_docSource.getDoc(key));
            _SortedScore.add(entry);
        }
        
        
        
        return new ArrayList<>(_SortedScore);
    }
    
}
