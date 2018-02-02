/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kwanmat4
 */
import soln.LinAlgException;
import soln.Matrix; // This is Matrix from the solution (not the Matrix you are writing) 
import soln.Vector; // This is Vector from the solution (not the Vector you are writing)

public class Sol_test1 {
    public static void main(String[] args) throws LinAlgException {
        try {
            Vector v1 = new Vector ("[ 1 2 3 4 ]");   
            Vector v2 = new Vector ("[ 1 2 3 4 5 ]");   
            System.out.println(v1.InnerProd(v1,v2));
            
        } catch (LinAlgException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        
        
        
    }
    
}
