/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kwanmat4
 */
import linalg.LinAlgException;
import linalg.Matrix;
import linalg.Vector;

public class Test02 {


    public static void main(String[] args) {
        try {
            Matrix m1 = new Matrix[2][3];
            Vector v2 = new Vector ("[ 1 2 3 4 5 ]");   
            System.out.println(v1.InnerProd(v1,v2));

        } catch (LinAlgException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        
        
        
    }
    

}
