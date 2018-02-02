/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import soln.index.*;
import index.*;
import io.*;
import soln.io.*;
import tokenizer.IndexingTokenizer;
import score.TFIDFScoringFun;
import score.TermScoringFun;
import soln.score.*;

/**
 *
 * @author kwanmat4
 */
public class InvertedIndexTest {
    
    soln.io.FileDocSource solFile = new soln.io.FileDocSource("../Part1/awards_1994/awd_1994_00");
    io.FileDocSource File = new io.FileDocSource("../Part1/awards_1994/awd_1994_00");
    soln.tokenizer.IndexingTokenizer SolnToken = new soln.tokenizer.IndexingTokenizer();
    IndexingTokenizer Token = new IndexingTokenizer();
    
    public InvertedIndexTest() {
    }
    
    @Test
    
 
    /**
     * Test of buildIndex method, of class InvertedIndex.
     */
    
    public void testBuildIndexDoc() {
        System.out.println("buildIndex");
        soln.index.InvertedIndex soln_index = new soln.index.InvertedIndex(new soln.io.FileDocSource("../Part1/awards_1994/awd_1994_00"), new soln.tokenizer.IndexingTokenizer(),new soln.score.TFIDFScoringFun());
        InvertedIndex index = new index.InvertedIndex(new io.FileDocSource("../Part1/awards_1994/awd_1994_00"),new tokenizer.IndexingTokenizer(), new score.TFIDFScoringFun());
        
        index.buildIndex();
        soln_index.buildIndex();
        
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(index._docSource.getDoc(0), soln_index._docSource.getDoc(0));
        
    }
    @Test
     public void testBuildScoreDoc() {
        System.out.println("buildIndex");
        soln.index.InvertedIndex soln_index = new soln.index.InvertedIndex(new soln.io.FileDocSource("../Part1/awards_1994/awd_1994_00"), new soln.tokenizer.IndexingTokenizer(),new soln.score.TFIDFScoringFun());
        InvertedIndex index = new index.InvertedIndex(new io.FileDocSource("../Part1/awards_1994/awd_1994_00"),new tokenizer.IndexingTokenizer(), new score.TFIDFScoringFun());
        
        index.buildIndex();
        soln_index.buildIndex();
        
        // TODO review the generated test code and remove the default call to fail.
        
        assertEquals(index._scoring.scoreToken("and", 3), soln_index._scoring.scoreToken("and",3),0);
    }

    /**
     * Test of getDocumentFreq method, of class InvertedIndex.
     */
    @Test
    public void testGetDocumentFreq() {
        System.out.println("getDocumentFreq");
        String term = "";
        InvertedIndex instance = null;
        int expResult = 0;
        int result = instance.getDocumentFreq(term);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSortedSearchResults method, of class InvertedIndex.
     */
    @Test
    public void testGetSortedSearchResults() {
       System.out.println("buildIndex");
        soln.index.InvertedIndex soln_index = new soln.index.InvertedIndex(new soln.io.FileDocSource("../Part1/awards_1994/awd_1994_00"), new soln.tokenizer.IndexingTokenizer(),new soln.score.TFIDFScoringFun());
        InvertedIndex index = new index.InvertedIndex(new io.FileDocSource("../Part1/awards_1994/awd_1994_00"),new tokenizer.IndexingTokenizer(), new score.TFIDFScoringFun());
        TermScoringFun scoring = new TFIDFScoringFun();
        soln.score.TFIDFScoringFun soln_scoring = new soln.score.TFIDFScoringFun();
        
        index.buildIndex();
        soln_index.buildIndex();
        
        scoring.init(index);
        soln_scoring.init(soln_index);
        
        ArrayList<DocScore> our = index.getSortedSearchResults("and");
        ArrayList<DocScore> their = soln_index.getSortedSearchResults("and");
        
        assertEquals(our,their);
        
        
    }
    
}
