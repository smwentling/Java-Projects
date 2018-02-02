/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.util.*;
import java.io.*;

/**
 *
 * @author Matthew Kwan, matthewky.kwan@gmail.com
 */
public class ElementSet implements Comparable {
    
    public int _id;
    public double _cost;
    public List<Integer> _ele_id_;
    public TreeSet<Integer> _ele_id = new TreeSet();
    
    public ElementSet() {
        _id = 0;
        _cost = 0;
        _ele_id = null;
        
    }
    
    public ElementSet(int id, double cost, List<Integer> ids ) {
      _id=id;
      _cost=cost;
      _ele_id_=ids;
      
      for (int i: _ele_id_)
          _ele_id.add(i);
    }
    
    //Basic Getters
    
    public int getId() {
        return _id;
    }
    
    public double getCost() {
        return _cost;
    }
    
    public TreeSet getElements() {
        return _ele_id;
    }
    
    // End of Coverage
    
    @Override
    public int compareTo (Object o) {
        if (o instanceof ElementSet) 
            return 1;
            
        ElementSet e = (ElementSet)o;
            
        if (this._id == e._id) {
            return 0;
        }
            
        else if (this._id < e._id) {
            return -1;
        }
            
        else {
            return 1;
        }
    }
        
 
        
    
    
    public String toString() {
        
        int count=1;
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("Set ID:  " + this._id);
        sb.append("   Cost :   " + this._cost);
        sb.append("   Element IDs: [");
        
        for (int i:this._ele_id) {
            if (count<this._ele_id.size()) {
                count++;
                sb.append(i+", ");
            }
            
            else {
                sb.append(i);
            }
        }
        
        sb.append("]");
        
        return sb.toString();
        
    }
    
    
}
