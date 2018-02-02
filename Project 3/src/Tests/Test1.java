import java.io.File;

import opt.Minimizer;
import poly.Polynomial;
import util.Vector;

/** 
 *Test Minimize with More Polynomial Files
 * @author matthewky.kwan@mail.utoronto.ca
 *
 */
public class Test1 {

	public static void main(String[] args) throws Exception {
		
		RunMinimizer("files/poly3.txt", 0.001, 100, 0.30, "{ y=1.0 x=1.0}");
		
	}	

	public static void RunMinimizer(String polyfile, double eps, int max_iter, double alpha, String sx0) 
			throws Exception {
		
		Minimizer m = new Minimizer();

	
		Polynomial p = Polynomial.ReadPolynomial(new File(polyfile));
		
		m.setEps(eps);
		m.setMaxIter(max_iter);
		m.setStepSize(alpha);
		m.setX0(new Vector(sx0));
		
		System.out.println("========================================");
		System.out.println("OPTIMIZING: " + p);
		System.out.println("========================================");
		m.printParams(System.out);
		m.minimize(p);
		m.printResults(System.out);
	}
}