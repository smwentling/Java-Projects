/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer;

import io.FileDocSource;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tokenizer.*;
import soln.tokenizer.*;

/**
 * Tests my tokenizer to ensure that it matches the solution (works for hyphenated words and lowercases everything
 * @author kwanmat4
 */
public class IndexingTokenizerTest {
    
    soln.tokenizer.IndexingTokenizer SolnToken = new soln.tokenizer.IndexingTokenizer();
    IndexingTokenizer Token = new IndexingTokenizer();
    soln.io.FileDocSource solFile = new soln.io.FileDocSource("../Part1/awards_1994/awd_1994_00");
    FileDocSource File = new FileDocSource("../Part1/awards_1994/awd_1994_00");
    
    public IndexingTokenizerTest() {
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

    /**
     * Test of tokenize method, of class IndexingTokenizer.
     */
    @Test
    public void testTokenize() {
        System.out.println("tokenize");
        String s = "Why Hello There I Hope That You Are Having A Fantastic Code Review Sir, "
                + "why, is that a surprise hyphenated-word I see?";
        
        ArrayList<String> expResult = SolnToken.tokenize(s);
        ArrayList<String> result = Token.tokenize(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Expected: " + expResult + "\n   Actual: " + result);
    }
    
    @Test
    public void testTokenize2() {
        System.out.println("tokenize");
        String s = "Hellllooooooooooo-EHGEHEGEFEf-fsefesbe-wowthisisamazinghowthebraincandifferentiatethesewordsevenwithoutspaces";
        
        ArrayList<String> expResult = SolnToken.tokenize(s);
        ArrayList<String> result = Token.tokenize(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Expected: " + expResult + "\n   Actual: " + result);
    }
    
}
