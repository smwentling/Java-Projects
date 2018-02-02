package solver;
import java.util.TreeSet;
import util.ElementSet;
import model.SCPModel;
import java.io.*;
import java.util.*;


/** This is the main method that all solvers inherit from.  It is important
 *  to note how this solver calls nextBestSet() polymorphically!  Subclasses
 *  should *not* override solver(), they need only override nextBestSet().
 * 
 *  We'll assume models are well-defined here and do not specify Exceptions
 *  to throw.
 * 
 * @author Matthew Kwan, matthewky.kwan@gmail.com
 *
 */
public abstract class GreedySolver {
	
	protected String _name;			  // name of algorithm type
	protected double _alpha;          // minimum required coverage level in range [0,1]
	protected SCPModel _model;        // the SCP model we're currently operating on
	protected double _objFn;          // objective function value (*total cost sum* of all sets used)
	protected double _coverage;       // actual coverage fraction achieved
	protected long _compTime;         // computation time (ms)
        public TreeSet<ElementSet> _solnSets = new TreeSet<ElementSet>();
        public TreeSet<ElementSet> _uncoveredScp;
        public TreeSet<Integer> _uncoveredElements;
        public TreeSet<Integer> _coveredElements = new TreeSet();
        public TreeSet<Integer> _numEle = new TreeSet();
        public int _count;
        public int _uncovered;
        public int _covered;
	
	// Basic setter (only one needed)
	public void setMinCoverage(double alpha) { _alpha = alpha; }
	public void setModel(SCPModel model) { _model = model; }
       
	// Basic getters
        
	public double getMinCoverage() { return _alpha; }
	public double getObjFn() { return _objFn; }
	public double getCoverage() { return _coverage; }
	public long getCompTime() { return _compTime; }
	public String getName() { return _name; }
        public TreeSet getUncoveredScp() { return new TreeSet(_uncoveredScp); }
        public TreeSet getUncoveredEle() { return _uncoveredElements;}
        public TreeSet getCoveredEle() { return _coveredElements;}
        public int getCount() { return _count;}
        public TreeSet getNumEle() { return new TreeSet(_numEle);}


        public void reset() {
            _objFn = 0d;
            _coverage=0d;
            _compTime=0;
            _uncovered=_count;
            _covered=0;
            _solnSets = new TreeSet<ElementSet>();
            _uncoveredElements = new TreeSet<Integer>();
            _coveredElements = new TreeSet<Integer>();
        }
        
        public void countSet() {
            for (ElementSet e: _model._scp){
                    for (int i: e._ele_id) {
                        if (!_numEle.contains(i)) {
                            _numEle.add(i);
                            _count++;
                        }
                    }

                }
        }
	// TODO: Add any helper methods you need
	
	/** Run the simple greedy heuristic -- add the next best set until either
	 *  (1) The coverage level is reached, or 
	 *  (2) There is no set that can increase the coverage.
	 */
	public void solve() {
		
              
		// Reset the solver
                countSet();
		reset();    
		
		// TODO: Preliminary initializations
                //Model Initialization
          
                
                // Integers
                int num_to_cover = (int)Math.ceil(_alpha*(_count));
                int num_can_leave_uncovered = (_count) - num_to_cover;
                //TreeSets
                
                _uncoveredScp = _model.getScp();
                //System.out.print(_uncoveredScp.size());
                _uncoveredElements = getNumEle();
                
  
               
                
		// Begin the greedy selection loop
		long start = System.currentTimeMillis();
		System.out.println("Running '" + getName() + "'...");
               // System.out.print(_count);

		// TODO: Fill in the main loop, pseudocode given below
		//
		// while (set elements remaining not covered > max num that can be left uncovered
		//        AND all sets have not been selected)
                while (((_uncovered) > num_can_leave_uncovered ) && !_uncoveredScp.isEmpty() ) {
		//  
		//      Call nextBestSet() to get the next best ElementSet to add (if there is one)
                    ElementSet best = nextBestSet();
                    if (best==null)
                        break;
                   // System.out.println("Selected: " + best);
             
                // *Update of TreeSets with Element Set*
                    
                    _solnSets.add(best);
                    _uncoveredScp.remove(best);
                    
                // *Update of TreeSets with Integers*
                    for (int i: best._ele_id) {
                        if (!_coveredElements.contains(i)) {
                            _uncoveredElements.remove(i);
                            _coveredElements.add(i);
                            _uncovered--;
                            _covered++;
                        }
                    }
                    
                _objFn += best.getCost();
               
                }
              
		// Record final set coverage, compTime and print warning if applicable
		_coverage = ((double)_covered)/(_count); // TODO: Correct this, should be coverage of solution found
		_compTime = System.currentTimeMillis() - start;
		if (_coverage < _alpha)
			System.out.format("\nWARNING: Impossible to reach %.2f%% coverage level.\n", 100*_alpha);
		//System.out.println("Done.");
	}
	
	/** Returns the next best set to add to the solution according to the heuristic being used.
	 * 
	 *  NOTE 1: This is the **only** method to be implemented in child classes.
	 *  
	 *  NOTE 2: If no set can improve the solution, returns null to allow the greedy algorithm to terminate.
	 *  
	 *  NOTE 3: This references an ElementSet class which is a tuple of (Set ID, Cost, Integer elements to cover)
	 *          which you must define.
	 * 
	 * @return
	 */
	public abstract ElementSet nextBestSet(); // Abstract b/c it must be implemented by subclasses
	
	/** Print the solution
	 * 
	 */
	public void print() {
		//System.out.println("\n'" + getName() + "' results:");
		//System.out.format("'" + getName() + "'   Time to solve: %dms\n", _compTime);
		//System.out.format("'" + getName() + "'   Objective function value: %.2f\n", _objFn); //solve this
		//System.out.format("'" + getName() + "'   Coverage level: %.2f%% (%.2f%% minimum)\n", 100*_coverage, 100*_alpha);
		//System.out.format("'" + getName() + "'   Number of sets selected: %d\n", _solnSets.size());
		//System.out.format("'" + getName() + "'   Sets selected: ");
		for (ElementSet s : _solnSets) {
			//System.out.print(s.getId() + " ");
		}
		//System.out.println("\n");
	}
	
	/** Print the solution performance metrics as a row
	 * 
	 */
	public void printRowMetrics() {
		System.out.format("%-25s%12d%15.4f%17.2f\n", getName(), _compTime, _objFn, 100*_coverage);
	}	
}
