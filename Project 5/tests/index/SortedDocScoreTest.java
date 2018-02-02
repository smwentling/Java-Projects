/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import index.*;
import soln.index.*;
import java.util.*;


/**
 *
 * @author kwanmat4
 */
public class SortedDocScoreTest {
    
    soln.index.SortedDocScore SolnSDS;
    SortedDocScore SDS;
    
    public SortedDocScoreTest() {
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
    public void testSort() {
        SortedDocScore a = new SortedDocScore(3.452,1,"Wow such a cool document");
        SortedDocScore b = new SortedDocScore(3.452,2,"Amazing! This document is even cooler!");
        SortedDocScore c = new SortedDocScore(623.745345,3,"That score! It's likes haven't been seen for a century at the very least");
        
        TreeSet<SortedDocScore> sort = new TreeSet();
        sort.add(a);
        sort.add(b);
        sort.add(c);
        
        int count = 0;
        int[] expresult = new int[]{3,2,1};
        for (SortedDocScore x : sort) {
            assertTrue(x.getDocID() == expresult[count]);
            count++;
        }
      
    }

    /**
     * Test of compareTo method, of class SortedDocScore.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object o = null;
        SortedDocScore instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
