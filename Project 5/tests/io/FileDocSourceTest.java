/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import soln.io.*;
import io.*;



/**
 * Tests the two functions in FileDocSourceTest
 * @author kwanmat4
 */
public class FileDocSourceTest { 
    
    soln.io.FileDocSource solFile = new soln.io.FileDocSource("../Part1/awards_1994/awd_1994_00");
    FileDocSource File = new FileDocSource("../Part1/awards_1994/awd_1994_00");
    
    public FileDocSourceTest() {
        
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
     * Test of getNumDocs method, of class FileDocSource.
     */
    @Test
    public void testGetNumDocs() {
        System.out.println("getNumDocs");
        int expResult = solFile.getNumDocs();
        int result = File.getNumDocs();
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + "   Actual: " + result);
        
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of getDoc method, of class FileDocSource.
     */
    @Test
    public void testGetDoc() {
        System.out.println("getDoc");
        int id = 0;
        String expResult = solFile.getDoc(id);
        String result = File.getDoc(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Expected: " + expResult + "\n   Actual: " + result);
    }

    
    
}
