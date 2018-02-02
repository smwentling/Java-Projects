 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver;

import util.ElementSet;
import model.SCPModel;
import java.util.*;
import java.io.*;

/**
 *
 * @author Matthew Kwan, matthewky.kwan@gmail.com
 */
public class GreedyCoverageSolver extends GreedySolver {
    
    TreeSet<ElementSet> input;
    
 
    
    public GreedyCoverageSolver() {
        _name = "Coverage"; 
        this.reset();
    }
    
    @Override
    public ElementSet nextBestSet() {
        
        input = _model.getScp(); // takes the most updated UncoveredScp treeset
        ElementSet bestSet = null;
        int highest= Integer.MIN_VALUE;
        
        for (ElementSet e: input) {
            
            int num_diff=0;
            for (int i:e._ele_id){
                if (_uncoveredElements.contains(i)) {
                    num_diff++;
                }

            }
            if (num_diff>highest) {
                    highest = num_diff;
                    bestSet = e;
                }
        }
        
        return bestSet;
    }
    
}