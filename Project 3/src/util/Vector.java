package util;

import java.util.HashMap;
import java.io.*;
import java.util.Arrays;

/** Implements a vector with *named* indices.  For example { x=1.0 y=2.0 } is a 2D
 *  vector with the first dimension named "x" and the second dimension named "y"
 *  and having respective values 1.0 and 2.0 in these dimensions.
 *  
 *  TODO: Implement all methods required to support the functionality of the project
 *        and that described in Vector.main(...) below.
 * 
 * @author matthewky.kwan@gmail.com, ssanner@mie.utoronto.ca
 *
 */
public class Vector {
	private HashMap<String,Double> _hmVar2Value; // This maps dimension variable names to values
	
	/** Constructor of an initially empty Vector
	 * 
	 */
	public Vector() {
            _hmVar2Value = new HashMap<String,Double>();
		// TODO: this method should not be empty! 
		// Hint: is there any memory you want to allocate?
	}

	/** Constructor that parses a String s like "{ x=-1 y=-2.0 z=3d }" into 
	 *  the internal HashMap representation of the Vector.  See usage in main().
	 * 
	 * @param s
	 */
	public Vector(String s) throws VectorException {
            
            _hmVar2Value = new HashMap<String,Double>();
            String[] split = s.split(" ");
          //  System.out.print(split[4]);
            for (int i=1 ; i<(split.length-1) ; i++) {
                String[] split2 = split[i].split("=");
                double val = Double.parseDouble(split2[1]);
                _hmVar2Value.put(split2[0],val);
               // System.out.print(_hmVar2Value.get('x'));
            }
            
		// TODO: this method should not be empty! 
		// Hint: you're going to have use String.split covered in the File I/O lecture.
	}

	/** Removes (clears) all (key,value) pairs from the Vector representation
	 * 
	 */
	public void clear() {
            
            _hmVar2Value.clear();
		// TODO: this method should not be empty! 
		// Hint: look very carefully at the available methods of HashMap... this is a one liner!
	}

	/** Sets a specific var to the value val in *this*, i.e., var=val
	 * 
	 * @param var - label of Vector index to change
	 * @param val - value to change it to
	 */
	public void set(String var, double val) {
            
            this._hmVar2Value.put(var,val);
		// TODO: this method should not be empty! 
		// Hint: look very carefully at the available methods of HashMap... this is a one liner!
	}

	/** Sets all entries in *this* Vector to match entries in x
	 *  (if additional variables are in *this*, they remain unchanged) 
	 * 
	 * @param x
	 */
	public void setAll(Vector x) {
            
            this._hmVar2Value.putAll(x._hmVar2Value);
		// TODO: this method should not be empty! 
		// Hint: look very carefully at the available methods of HashMap... this is a one liner!
	}
        
        @Override // optional annotation to tell Java we expect this overrides a parent method -- compiler will warn if not
	public String toString() {
		// We could just repeatedly append to an existing String, but that copies the String each
		// time, whereas a StringBuilder simply appends new characters to the end of the String
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (String key :_hmVar2Value.keySet())
			sb.append(String.format("%s=%6.4f ", key,_hmVar2Value.get(key))); // Append each vector value in order
		sb.append("}");
		return sb.toString();
	}


	///////////////////////////////////////////////////////////////////////////////
	// TODO: Add your methods here!  You'll need more than those above to make
	//       main() work below.
	///////////////////////////////////////////////////////////////////////////////
        
        /**
         * This vector is called and sums the called upon vector with vector param v
         * @param v a vector
         * @return 
         */
        public Vector sum(Vector v) {
            
            Vector a = new Vector();
            
            for (String key:v._hmVar2Value.keySet())
                a.set(key,(this._hmVar2Value.get(key) + v._hmVar2Value.get(key)));
            
            return a;
            
        }
        /**
         * This vector multiplies the called upon vector by double m
         * @param m
         * @return 
         */
        public Vector scalarMult(double m) {
            
            Vector a = new Vector(); 
            
            for (String key:this._hmVar2Value.keySet())
               a.set(key,(this._hmVar2Value.get(key) * m));
            
            return a;
        }
        
        /** 
         * This function computes the normality of the vector it is called upon.
         * @returns val
         */
        public double computeL2Norm() {
            double sum=0;
            double val; 
            
            for(String key:this._hmVar2Value.keySet())
                sum+= Math.pow(this._hmVar2Value.get(key), 2);
            
            val = Math.sqrt(sum);
            return val;
        }
        
        /**
         * checks if object o is a vector and is equal to what equals is called upon
         * @param o
         * @return 
         */
        @Override
        public boolean equals(Object o) {
		if (o instanceof Vector) {
			Vector v = (Vector)o; // This is called a cast (or downcast)... we can do it since we
			                      // know from the if statement that o is actually of subtype Vector
			if (_hmVar2Value.size() != v._hmVar2Value.size())
				return false; // Two Vectors cannot be equal if they don't have the same dimension
			for (String key: v._hmVar2Value.keySet()) {
                           
				if (_hmVar2Value.get(key).equals(v._hmVar2Value.get(key))!=true)
                                    return false; // If two Vectors mismatch at any index, they are not equal
                        }
			return true; // Everything matched... objects are equal!
		} else // if we get here "(o instanceof Vector)" was false
			return false; // Two objects cannot be equal if they don't have the same class type
	}
        
        /**
         * This function takes in a string and returns the hashmap value paired to the key
         * @param key
         * @return 
         */
        public double getval(String key) {
           return this._hmVar2Value.get(key);
        }
        
        public HashMap convHash() {
            return this._hmVar2Value;
        }
	
	/** Your Vector class should implement the core functionality below and produce
	 *  **all** of the expected outputs below.  **These will be tested for grading.**
	 * 
	 *  When initially developing the code, comment out lines below that you have
	 *  not implemented yet.  This will allow your code to compile for incremental
	 *  testing.
	 *  
	 * @param args (unused -- ignore)
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// Make vector: vec1[x y z] = [1 2 3]
		Vector vec1 = new Vector();
		vec1.set("x", 1.0);
		vec1.set("y", 2.0);
		vec1.set("z", 3.0);
		
		// Make vector: vec2[x y z] = [-3 -2 -1]
		Vector vec2 = new Vector();
		vec2.set("x", -3.0);
		vec2.set("y", -2.0);
		vec2.set("z", -1.0);
		
		// Make vector: vec3[x y z] = vec4[x y z] = [-1 -2 -3]
		Vector vec3 = new Vector("{ x=-1 y=-2.0 z=3d }");
		Vector vec4 = new Vector(vec3.toString());
              
                
              		
		// Hint: all numbers below are formatted with String.format("%s=%6.4f ", var, val)
		//       ... you may want to use this in your Vector.toString() implementation!
		
                
		// Test cases: 
		System.out.println(vec1); // Should print: { x=1.0000 y=2.0000 z=3.0000 }
		System.out.println(vec2); // Should print: { x=-3.0000 y=-2.0000 z=-1.0000 }
		System.out.println(vec3); // Should print: { x=-1.0000 y=-2.0000 z=3.0000 }
		System.out.println(vec4); // Should print: { x=-1.0000 y=-2.0000 z=3.0000 }
		System.out.println(vec1.sum(vec1));        // Should print: { x=2.0000 y=4.0000 z=6.0000 }
		System.out.println(vec1.sum(vec2));        // Should print: { x=-2.0000 y=0.0000 z=2.0000 }
		System.out.println(vec1.sum(vec3));        // Should print: { x=0.0000 y=0.0000 z=6.0000 }
		System.out.println(vec1.scalarMult(0.5));  // Should print: { x=0.5000 y=1.0000 z=1.5000 }
		System.out.println(vec2.scalarMult(-1.0)); // Should print: { x=3.0000 y=2.0000 z=1.0000 }
		System.out.println(vec1.sum(vec2.scalarMult(-1.0))); // Should print: { x=4.0000 y=4.0000 z=4.0000 }
		System.out.format("%01.3f\n", vec1.computeL2Norm());           // Should print: 3.742
		System.out.format("%01.3f\n", vec2.sum(vec3).computeL2Norm()); // Should print: 6.000
		
		// If the following don't work, did you override equals()?  See Project 2 Vector and Matrix.
		System.out.println(vec3.equals(vec1)); // Should print: false
		System.out.println(vec3.equals(vec3)); // Should print: true
		System.out.println(vec3.equals(vec4)); // Should print: true
		System.out.println(vec1.sum(vec2).equals(vec2.sum(vec1))); // Should print: true*/
	}	
}
