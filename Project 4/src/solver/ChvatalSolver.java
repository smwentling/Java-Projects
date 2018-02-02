/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver;

import java.util.TreeSet;
import util.ElementSet;
import model.SCPModel;
import java.util.*;
import java.io.*;

/**
 *
 * @author Matthew Kwan, matthewky.kwan@gmail.com
 */
public class ChvatalSolver extends GreedySolver {
    
    TreeSet<ElementSet> input;
    
    public ChvatalSolver() {
        _name = "Chvatal";
        this.reset();
    }
    
    @Override
    public ElementSet nextBestSet() {
        input = getUncoveredScp();
        ElementSet bestSet = null;
        double lowest= Double.MAX_VALUE;
        
        for (ElementSet e: input) {
                      
            int num_diff=0;
            double ratio = 0;
            
            for (int i:e._ele_id){
                if (!_coveredElements.contains(i)) {
                    num_diff++;
                }
                
                if (num_diff>0) {
                    ratio = (e._cost)/(num_diff);
                    if (ratio<lowest) {
                        lowest = ratio;
                        bestSet = e;
                    }
                }
               
            }
        }
        
        return bestSet;
    }
    
}
