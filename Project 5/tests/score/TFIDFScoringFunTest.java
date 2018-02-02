/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score;

import index.Index;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import score.*;
import io.*;
import index.*;
import soln.score.*;
import soln.io.*;
import soln.index.*;

/**
 * Testing my TFIDF Scorer
 * @author kwanmat4
 */
public class TFIDFScoringFunTest {
    
    
   
		
		// Build the search index
    
    soln.index.InvertedIndex _index =new soln.index.InvertedIndex(new soln.io.FileDocSource("../Part1/awards_1994/awd_1994_00"), new soln.tokenizer.IndexingTokenizer(),new soln.score.TFIDFScoringFun());

	 
    

    
    public TFIDFScoringFunTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testinit() {
        _index = new soln.index.InvertedIndex(new soln.io.FileDocSource("../Part1/awards_1994/awd_1994_00"), new soln.tokenizer.IndexingTokenizer(),new soln.score.TFIDFScoringFun());
    }
 
    /**
     * Test of scoreToken method, of class TFIDFScoringFun.
     */
    @Test
    public void testScoreToken() {
        System.out.println("scoreToken");
        _index = new soln.index.InvertedIndex(new soln.io.FileDocSource("../Part1/awards_1994/awd_1994_00"), new soln.tokenizer.IndexingTokenizer(),new soln.score.TFIDFScoringFun());

        String term = "computer";
        int freq = 12;
        soln.score.TFIDFScoringFun soln_scorer = new soln.score.TFIDFScoringFun();
        TFIDFScoringFun scorer = new TFIDFScoringFun();
        double expResult = soln_scorer.scoreToken(term, freq);
        double result = scorer.scoreToken(term, freq);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}
