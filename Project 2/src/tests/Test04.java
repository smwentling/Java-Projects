import linalg.LinAlgException;
import linalg.Matrix; // This is Matrix from the linear algebra package you are writing 
import linalg.Vector; // This is Vector from the linear algebra package you are writing 

/** This is a small example of test cases.  Write your own test cases to understand all
 *  of the methods in Matrix and Vector.  To test correctness of your implementation,  
 *  see if the output on your tests matches the results of the same tests on the solution
 *
 *  NOTE: see TestLinAlgSoln which provides results for the solution by importing 
 *        soln.Matrix and soln.Vector from the solution jar as opposed to linalg.Matrix 
 *        and linalg.Vector that you are writing.  All that changes are the import
 *        statements at the top. 
 * 
 * @author ssanner@mie.utoronto.ca
 *
 */
public class Test04 {

	public static void main(String[] args) {
		try {
			// Note: you need to write your own tests, this is only a small sample and it does not
			//       test cases that throw an Exception.
			Vector v = new Vector("[ 1 2 3 4 5 ]");
			System.out.println("1. test constructor and toString(): " + v); // This automatically invokes v.toString()!
			System.out.println("2. test scalar addition: " + v.scalarAdd(1));
			System.out.println("3. ensure v was not modified: " + v);
			v.scalarAddInPlace(2);
			System.out.println("4. now v should be modified: " + v);
			
                        
                        //v.changeDim(6);
                        //System.out.println("changeDim test 6 " + v);
			
                        Matrix m = Matrix.GetIdentity(5);
			System.out.println("5. identity matrix m:\n" + m);
			System.out.println("6. still identity after self-multiply:\n" + Matrix.Multiply(m, m)); 
			
			m.set(2, 0, 2);
			m.set(0, 2, 3);
			m.set(4, 0, 5);
                        
                        /*
                        //1
                        Vector jingkai_testcase = new Vector (-2);
                        // should print Vector dimension -2 cannot be less than 1
                        */
                       
                        
                        
                        /*
                        //2
                        Vector jingkai_testcase = new Vector (3);
                        jingkai_testcase.set(2, 10);
                        System.out.println("should print [  0.000   0.000  10.000  ]"+jingkai_testcase);
                        jingkai_testcase.set(-4, 10);
                        // should print ERROR: Index -4 is out of bounds [0, 3]
                        */
                        
                        
                        
                        /*  
                        //3
                        Vector jingkai_testcase = new Vector (3);
                        jingkai_testcase.set(2, 8);
                        
                        System.out.println("should print 8.0   "+jingkai_testcase.get(2));
                        jingkai_testcase.get(-2);
                        //should print ERROR: Index -2 is out of bounds [0, 3]
                        */
                        
                        
                        /*
                        //4
                        Vector jingkai_testcase = new Vector (3);
                        jingkai_testcase.set(2,3);
                        jingkai_testcase.set(0,10);
                        jingkai_testcase.changeDim(5);
                        System.out.println("should print [ 10.000   0.000   3.000   0.000   0.000  ]:  "+jingkai_testcase);
                        
                        jingkai_testcase.changeDim(3);
                        System.out.println("should print [ 10.000   0.000   3.000  ]:   "+jingkai_testcase);
                        
                        jingkai_testcase.changeDim(-1);
                        //should print ERROR: Vector dimension -1 cannot be less than 1
                        
                        */
                        
                        /*
                        //5
                        Vector jingkai_testcase = new Vector (5);
                        jingkai_testcase.set(2,10);
                        jingkai_testcase.set(0,8);
                        
                        System.out.println("should print [  8.800   0.800  10.800   0.800   0.800  ]:   " + jingkai_testcase.scalarAdd(0.8));
                        System.out.println("should print [  8.000   0.000  10.000   0.000   0.000  ]:   " + jingkai_testcase);
                        
                        System.out.println("should print [ 14.000   6.000  16.000   6.000   6.000  ]:    " + jingkai_testcase.scalarAdd(6));
                        System.out.println("should print [  8.000   0.000  10.000   0.000   0.000  ]:   " + jingkai_testcase);
                        
                        jingkai_testcase.scalarAddInPlace(7);
                        System.out.println("should print [ 15.000   7.000  17.000   7.000   7.000  ]:   " + jingkai_testcase);
                        
                        
                        jingkai_testcase.scalarAddInPlace(99);
                        System.out.println("should print [ 114.000  106.000  116.000  106.000  106.000  ]:   " + jingkai_testcase);
                        
                        */
                        
                        
                        /*
                        //6
                        Vector jingkai_testcase = new Vector (6);
                        jingkai_testcase.set(3,2);
                        jingkai_testcase.set(4,3);
                        
                        System.out.println("should print [  0.000   0.000   0.000   3.000   4.500   0.000  ]:   " + jingkai_testcase.scalarMult(1.5));
                        System.out.println("should print [  0.000   0.000   0.000   2.000   3.000   0.000  ]:   " + jingkai_testcase);
                        
                        System.out.println("should print [  0.000   0.000   0.000  14.000  21.000   0.000  ]:   " + jingkai_testcase.scalarMult(7));
                        System.out.println("should print [  0.000   0.000   0.000   2.000   3.000   0.000  ]:   " + jingkai_testcase);
                        
                        jingkai_testcase.scalarMultInPlace(10);
                        System.out.println("should print [  0.000   0.000   0.000  20.000  30.000   0.000  ]:   " + jingkai_testcase);
                        
                        
                        jingkai_testcase.set(5,44);
                        jingkai_testcase.scalarMultInPlace(0.8);
                        System.out.println("should print [  0.000   0.000   0.000  16.000  24.000  35.200  ]:   " + jingkai_testcase);
                        */
                        
                        /*
                        
                        //7
                        
                        Vector jingkai_testcase = new Vector (4);
                        jingkai_testcase.set(0,2);
                        jingkai_testcase.set(2,3.2);
                        jingkai_testcase.set(1,8.8);
                        
                        Vector jingkai_testcase_2 = new Vector (4);
                        jingkai_testcase_2.set(0,1.2);
                        jingkai_testcase_2.set(2,2.9);
                        jingkai_testcase_2.set(3,6.6);
                        
                        System.out.println("should print [  3.200   8.800   6.100   6.600  ]:   " + jingkai_testcase.elementwiseAdd(jingkai_testcase_2));
                        System.out.println("should print [  2.000   8.800   3.200   0.000  ]:   " + jingkai_testcase);
                        
                        
                        jingkai_testcase_2.set(1,5.9);
                        jingkai_testcase_2.set(2,9.6);
                        System.out.println("should print [  3.200  14.700  12.800   6.600  ]:   " + jingkai_testcase.elementwiseAdd(jingkai_testcase_2));
                        System.out.println("should print [  2.000   8.800   3.200   0.000  ]:   " + jingkai_testcase);
                        
                        jingkai_testcase.elementwiseAddInPlace(jingkai_testcase_2);
                        System.out.println("should print [  3.200  14.700  12.800   6.600  ]:   " + jingkai_testcase);
                        
                        jingkai_testcase_2.set(0,88);
                        jingkai_testcase_2.set(2,44);
                        jingkai_testcase.elementwiseAddInPlace(jingkai_testcase_2);
                        System.out.println("should print [ 91.200  20.600  56.800  13.200  ]:   " + jingkai_testcase);
                        
                        Vector jingkai_testcase_3 = new Vector (5);
                        jingkai_testcase.elementwiseAddInPlace(jingkai_testcase_3);
                        // should print ERROR: Cannot elementWiseAdd vectors of different dimensions 4 and 5
                        
                        */
                        
                        
                        /*
                        //8
                       Vector jingkai_testcase = new Vector (4);
                        jingkai_testcase.set(0,2);
                        jingkai_testcase.set(2,3.2);
                        jingkai_testcase.set(1,8.8);
                        
                        Vector jingkai_testcase_2 = new Vector (4);
                        jingkai_testcase_2.set(0,1.2);
                        jingkai_testcase_2.set(2,2.9);
                        jingkai_testcase_2.set(3,6.6);
                        
                        System.out.println("should print [  2.400   0.000   9.280   0.000  ]:   " + jingkai_testcase.elementwiseMult(jingkai_testcase_2));
                        System.out.println("should print [  2.000   8.800   3.200   0.000  ]:   " + jingkai_testcase);
                        
                        
                        jingkai_testcase_2.set(1,5.9);
                        jingkai_testcase_2.set(2,9.6);
                        System.out.println("should print  [  2.400  51.920  30.720   0.000  ]:   " + jingkai_testcase.elementwiseMult(jingkai_testcase_2));
                        System.out.println("should print [  2.000   8.800   3.200   0.000  ]:   " + jingkai_testcase);
                        
                        
                        jingkai_testcase_2.set(1,1.9);
                        jingkai_testcase_2.set(2,2.6);
                        jingkai_testcase_2.set(3,7.7);
                        jingkai_testcase.elementwiseMultInPlace(jingkai_testcase_2);
                        System.out.println("should print [  2.400  16.720   8.320   0.000  ]:   " + jingkai_testcase);
                        
                        jingkai_testcase_2.set(0,88);
                        jingkai_testcase_2.set(2,44);
                        jingkai_testcase.elementwiseMultInPlace(jingkai_testcase_2);
                        System.out.println("should print [ 211.200  31.768  366.080   0.000  ]:   " + jingkai_testcase);
                        
                        Vector jingkai_testcase_3 = new Vector (5);
                        jingkai_testcase.elementwiseMultInPlace(jingkai_testcase_3);
                        // should print ERROR: Cannot elementWiseMult vectors of different dimensions 4 and 5
                        */
           
                        
                        /*
                        
                        //9
                         
                        Vector jingkai_testcase = new Vector (4);
                        jingkai_testcase.set(0,2);
                        jingkai_testcase.set(3,9.2);
                        jingkai_testcase.set(2,2.8);
                        
                        Vector jingkai_testcase_2 = new Vector (4);
                        jingkai_testcase_2.set(0,4.2);
                        jingkai_testcase_2.set(2,6.2);
                        jingkai_testcase_2.set(3,1.6);
                       
                        System.out.println("should print 40.48:  " + Vector.InnerProd(jingkai_testcase, jingkai_testcase_2));
                        
                        
                        */
                        
                        
                        
                        /*
                        //10
                        Matrix jingkai_testcase = new Matrix (5,-2);
                        // should print Both dimensions (5,-2) must be greater than 0
                      */
                        
          
                        /*
                        //11
                        Matrix jingkai_testcase = new Matrix (3,5);
                        jingkai_testcase.set(1,2,2);
                        jingkai_testcase.set(0,1,2.4);
                        jingkai_testcase.set(2,0,22);
                        jingkai_testcase.set(0,4,8.2);
                        jingkai_testcase.set(1,3,2.6);
                        jingkai_testcase.set(0,2,5.2);
                        jingkai_testcase.set(2,4,9.21);
                        System.out.println("should print \n[ 51.400   2.400   5.200   0.000   8.200  ] \n" +
                                                            "[  4.000   0.000   2.000   2.600   0.000  ] \n" +
                                                            "[ 68.050   0.000  66.000   0.000   9.210  ] \n"
                                + "-----------------------\n" 
                                + Matrix.Multiply( jingkai_testcase, m));
                        
                        
                        jingkai_testcase= Matrix.GetIdentity(2);
                        Matrix.Multiply(m, jingkai_testcase);
                        //Should print Cannot multiply matrix m1 having 5 columns with matrix m2 having 2 rows
                        */ 
                        
                        
                        
                        /*
                        //12
                        m.set(-1,5,2);
                        //should print ERROR: One or both indices (-1, 5) are out of bounds ([0, 5],[0, 5])
                        */
                        
                        
                        
                        /*
                        //13
                        Matrix jingkai_testcase = Matrix.GetIdentity(-6);
                        // should print Size -6 must be greater than 0
                        */
                        
                        
                        /*
                        //14
                        Matrix jingkai_testcase = Matrix.GetIdentity(6);
                        jingkai_testcase.set(2,5,88);
                        System.out.println("matrix get row should print [  0.000   0.000   1.000   0.000   0.000  88.000  ] : "
                        +jingkai_testcase.getRow(2));
                        jingkai_testcase.getRow(-1);  
                        // should print ERROR: Row index (-1) out of bounds [0, 6])
                        */
                        
                        
                        /*
                        //15
                        Matrix jingkai_testcase = Matrix.GetIdentity(6);
                        jingkai_testcase.set(2,5,88);
                        System.out.println("matrix get should print 88.0 : " +jingkai_testcase.get(2, 5));
                        jingkai_testcase.get(-1,11);  
                        // should print ERROR: One or both indices (-1, 11) are out of bounds ([0, 6],[0, 6])
                        */
                        
                        
                        /*
                        //16
                        
                        Matrix jingkai_testcase = new Matrix (4,6);
                        System.out.println("should print 4  6  :   "+jingkai_testcase.getNumRows() +"  " + jingkai_testcase.getNumCols());
                        */
                        
                        
                        
                   /*
                        //17
                        
                        Matrix jingkai_testcase = new Matrix (4,9);
                        jingkai_testcase.set(1,2,2);
                        jingkai_testcase.set(0,1,2.4);
                        jingkai_testcase.set(2,0,22);
                        jingkai_testcase.set(0,4,8.2);
                        jingkai_testcase.set(1,3,2.6);
                        jingkai_testcase.set(0,2,5.2);
                        jingkai_testcase.set(2,4,9.21);
                        Vector jingkai_testcase_2 = new Vector ("[ 2.4 9.2 8.8 65 66 6.6 1 1 1 ]");
                        System.out.println("should print \n [ 609.040  186.600  660.660   0.000  ] \n ---------\n "
                                + Matrix.Multiply(jingkai_testcase, jingkai_testcase_2));
                        
                        */
                   
                   
                   
                   
                        /*
                        //18
                        Matrix jingkai_testcase_100 = new Matrix (3,3);
                        Matrix jingkai_testcase_200 = new Matrix (3,3);
                        System.out.println("should be equal: " + jingkai_testcase_100.equals(jingkai_testcase_200));
                       
                        Matrix jingkai_testcase = new Matrix (3,3);
                        jingkai_testcase.set(1,2,2);
                  
                        Matrix jingkai_testcase_2 = new Matrix (3,3);
                        jingkai_testcase_2.set(1,2,2);
                        
                        System.out.println("should be equal: " + jingkai_testcase.equals(jingkai_testcase_2));
                        
                        jingkai_testcase_2.set(1,2,2.5);
                       
                        System.out.println("should not be equal: " + jingkai_testcase.equals(jingkai_testcase_2));
                        
                        
                        Matrix jingkai_testcase_3 = new Matrix (4,9);
                        
                        System.out.println("should not be equal: " + jingkai_testcase.equals(jingkai_testcase_3));
                        
                        */
                        
                        
                        
                        
                        
                        
			System.out.println("7. m should be modified:\n" + m); // Remember: this automatically invokes m.toString()!
			System.out.println("8. result should not be the identity:\n" + Matrix.Multiply(m, m));
			System.out.println("9. example matrix/vector multiply: " + Matrix.Multiply(m, v));
			
			Matrix m2 = new Matrix(m);
			System.out.println("10. should be equal: " + m2.equals(m));
			m2.set(0, 1, 2d);
			System.out.println("11. should not be equal: " + m2.equals(m));
		
		} catch (LinAlgException e) {
			System.out.println("ERROR: " + e.getMessage());
			System.exit(1); // Exits the program
		}
	}

}
