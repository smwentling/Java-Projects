/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizer;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kwanmat4
 */
public class SimpleTokenizerTest {
    
    public SimpleTokenizerTest() {
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
     * Test of tokenize method, of class SimpleTokenizer.
     */
    @Test
    public void testTokenize() {
        System.out.println("tokenize");
        String s = "";
        SimpleTokenizer instance = new SimpleTokenizer();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.tokenize(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
