package linalg;

/*** A class that represents a two dimensional real-valued (double) matrix
 *   and supports various matrix computations required in linear algebra.
 *   
 *   Class and method comments are in JavaDoc: https://en.wikipedia.org/wiki/Javadoc
 * 
 * @author ssanner@mie.utoronto.ca, matthewky.kwan@mail.utoronto.ca
 *
 */
public class Matrix {

	private int _nRows; // Number of rows in this matrix; nomenclature: _ for data member, n for integer
	private int _nCols; // Number of columns in this matrix; nomenclature: _ for data member, n for integer
	private double[][] _matrix;
	//       you could use a 2D array, or an array of Vectors (e.g., for each row)
	
	/** Allocates a new matrix of the given row and column dimensions
	 * 
	 * @param rows
	 * @param cols
	 * @throws LinAlgException if either rows or cols is <= 0
	 */
	public Matrix(int rows, int cols) throws LinAlgException {
		if (rows <=0 || cols <=0) //This if statement is to throw an exception if the matrix dimensions are invalid
			throw new LinAlgException("Matrix Rows and Columns can not be less than 1");
		_nRows = rows;
                _nCols = cols;
		_matrix = new double[rows][cols]; // Entries will be automatically initialized to 0.0
               
	}
	
	/** Copy constructor: makes a new copy of an existing Matrix m
	 *                    (note: this explicitly allocates new memory and copies over content)
	 * 
	 * @param m
	 */
	public Matrix(Matrix m) {
		_nRows = m._nRows; //assigns Rows from Matrix m to _nRows
                _nCols = m._nCols; //assigns Cols from Matrix m to _nCols
		_matrix = new double[_nRows][_nCols];
		for (int i = 0; i<_nRows; i++) {
                    for (int j=0; j<_nCols; j++) 
                        _matrix[i][j]=m._matrix[i][j];
                }
	}

	/** Constructs a String representation of this Matrix
	 * 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < _nRows; i++) {
                    sb.append("[");
                    for (int j=0; j<_nCols;j++) 
                        sb.append(String.format(" %6.3f ", _matrix[i][j])); // Append each vector value in order
                    sb.append(" ]"); // creates a separate square bracket for each row of matrix
                    sb.append("\n");
                }
		
		return sb.toString();
	}

	/** Tests whether another Object o (most often a matrix) is a equal to *this*
	 *  (i.e., are the dimensions the same and all elements equal each other?)
	 * 
	 * @param o the object to compare to
	 */
	public boolean equals(Object o) {
                    if (o instanceof Matrix) {
			Matrix m = (Matrix)o; 
                        
			if (_nRows!= m._nRows)
				return false; // The 2 Matrices must have the same number of rows and columns to be equal to eachother
                        if (_nCols!=m._nRows)
                                return false;
			for (int i=0; i<_nRows; i++) {
                            for (int j=0; j<_nCols; j++) {
                                if (_matrix[i][j] != m._matrix[i][j])
                                    return false;// if any of these return false, the matrices are not equal
                            }
                        }
			return true; // Everything matched... objects are equal!
		} else 
			return false; // Two objects cannot be equal if they don't have the same class type
	}
	
	/** Return the number of rows in this matrix
	 *   
	 * @return 
	 */
	public int getNumRows() {
            return _nRows; 
	}

	/** Return the number of columns in this matrix
	 *   
	 * @return 
	 */
	public int getNumCols() {
		return _nCols;
        }
	/** Return the scalar value at the given row and column of the matrix
	 * 
	 * @param row
	 * @param col
	 * @return
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public double get(int row, int col) throws LinAlgException {
            
            if (row >= _nRows || row < 0 || col >= _nCols || col < 0 )
                throw new LinAlgException("Number of Rows or Columns are out of bounds");
            
		double val = _matrix[row][col];
		return val;
	}
	
	/** Return the Vector of numbers corresponding to the provided row index
	 * 
	 * @param row
	 * @return
	 * @throws LinAlgException if row is out of bounds
	 */
	public Vector getRow(int row) throws LinAlgException {
            if (row<0 || row>=_nRows)
                throw new LinAlgException("Provided Row exceeds the bounds"); 
            
            Vector gr = new Vector(_nCols);//create new vector for the row index
            double val =0;
            
            for (int j=0; j<_nCols; j++) {
                val = this.get(row,j); // gets value of row in column j
                gr.set(j,val); //sets gr vector at index j to val
                
            }
            return gr;
	}

	/** Set the row and col of this matrix to the provided val
	 * 
	 * @param row
	 * @param col
	 * @param val
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public void set(int row, int col, double val) throws LinAlgException {
                if (row<0||row>_nRows||col<0||col>_nCols)
                    throw new LinAlgException ("Row and Col indices are out of bounds");
                
		_matrix[row][col] = val; // assigns _matrix index function is called on to val
	}
	
	/** Return a new Matrix that is the transpose of *this*, i.e., if "transpose"
	 *  is the transpose of Matrix m then for all row, col: transpose[row,col] = m[col,row]
	 *  (should not modify *this*)
	 * 
	 * @return
	 * @throws LinAlgException
	 */
	public Matrix transpose() throws LinAlgException {
		Matrix transpose = new Matrix(_nCols, _nRows);
		for (int row = 0; row < _nRows; row++) {
			for (int col = 0; col < _nCols; col++) {
				transpose.set(col, row, get(row,col));
			}
		}
		return transpose;
	}

	/** Return a new Matrix that is the square identity matrix (1's on diagonal, 0's elsewhere) 
	 *  with the number of rows, cols given by size.  E.g., if size = 3 then the returned matrix
	 *  would be the following:
	 *  
	 *  [ 1 0 0 ]
	 *  [ 0 1 0 ]
	 *  [ 0 0 1 ]
	 * 
	 * @param size
	 * @return
	 * @throws LinAlgException if the size is <= 0
	 */
	public static Matrix GetIdentity(int size) throws LinAlgException {
            if (size<=0)
                throw new LinAlgException ("Size can not be less than or equal to 0");
            
            Matrix d = new Matrix(size,size); //creates a new matrix of (rows,cols = size)
            
            for (int i=0; i<size; i++) {
                d._matrix[i][i]=1; // assigns the diagonals to 1
            }
		return d;
	}
	
	/** Returns the Matrix result of multiplying Matrix m1 and m2
	 *  (look up the definition of matrix multiply if you don't remember it)
	 * 
	 * @param m1
	 * @param m2
	 * @return
	 * @throws LinAlgException if m1 columns do not match the size of m2 rows
	 */
	public static Matrix Multiply(Matrix m1, Matrix m2) throws LinAlgException {
		if (m1._nCols != m2._nRows)
                    throw new LinAlgException ("Number of columns of first matrix must match number of rows of second");
                
                Matrix m3 = new Matrix(m1._nRows, m2._nCols);
                
                double val=0;
                
		for (int i=0 ; i < m1._nRows ; i++) {
                    for (int j=0; j<m2._nCols; j++) {
                        for (int k=0; k<m1._nCols; k++) {
                            val+=m1._matrix[i][k]*m2._matrix[k][j];// assigns doub.val to sum of val plus product of matrices at indices [i][k] and [k][j]
                                    }//the k is because the value of row changes for mat.1 and col for mat.2
                        m3.set(i,j,val);//outside of for loop, sets completed val to index of m3
                        val = 0; //resets val to 0 for next iteration
                    }
                }
            
            return m3;
	}
		
	/** Returns the Vector result of multiplying Matrix m by Vector v (assuming v is a column vector)
	 * 
	 * @param m
	 * @param v
	 * @return
	 * @throws LinAlgException if m columns do match the size of v
	 */
	public static Vector Multiply(Matrix m, Vector v) throws LinAlgException {
            if (m._nCols != v.getDim()) // makes sure mat.cols equals vector dim
                throw new LinAlgException("matrix columns do not match the size of v");
            
            Vector t = new Vector(m._nRows);
            double val = 0;
            
            for (int i=0; i<m._nRows ; i++) {
                for (int j=0; j<v.getDim(); j++)     
                    val += m._matrix[i][j]*v.get(j); // assigns val to the sum of val and the product of mat(i,j) and v(j)
                t.set(i,val); // sets vector t's value at [i] to value of val after leaving for loop
                val=0; // resets val to 0 for the multiplication of the next row
                
            }
            
            return t;
	}

}
