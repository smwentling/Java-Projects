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
public class GreedyCostSolver extends GreedySolver {
    
     TreeSet<ElementSet> input;
    
    public GreedyCostSolver() {
        _name = "Cost";
        this.reset();
        
    }
    @Override
    public ElementSet nextBestSet() {
        
        input = getUncoveredScp();
        ElementSet bestset = null;
        double lowestCost = Double.MAX_VALUE ;
        for (ElementSet e: input) {       
         
            for (int i:e._ele_id){
                if (!_coveredElements.contains(i)) {
                    if (e._cost < lowestCost) {
                        lowestCost = e._cost;
                        bestset=e;
                        break;
                    }
                }  
            }
        }
        
        return bestset;
    }
    
}