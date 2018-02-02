                                       /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.*;
import java.io.*;
import util.ElementSet;
import solver.GreedySolver;
/**
 *
 * @author Matthew Kwan, matthewky.kwan@gmail.com
 */
public class SCPModel {
    
   public static TreeSet<ElementSet> _scp = new TreeSet<ElementSet>();
  
  
   

            
    public SCPModel() {
        _scp = new TreeSet<ElementSet>();
        
    }
    //model.addSetToCover(6, 2.0, Arrays.asList(new Integer[] {4,8}));
    
    
    
    
    public static void addSetToCover (int i, double d, List<Integer> l ) {
        ElementSet es = new ElementSet(i,d,l);
        _scp.add(es);
    }
    
    public static TreeSet getScp() {
       
        return new TreeSet(_scp);
    }
    
    public String toString() {
        
    
        StringBuilder sb = new StringBuilder();
        
        sb.append ("Weighted SCP Model \n");
        
         sb.append ( "" + _scp.size());
       
        
        sb.append ("Set details: \n\n");
        sb.append ("----------------------------\n\n");
        
       
        for (ElementSet e : _scp )
            sb.append(e + "\n");
        return sb.toString();
    
        }
    
        public static SCPModel ReadModel(File file) throws IOException {
            
            
            try {      
            
                BufferedReader fin = new BufferedReader(new FileReader(file));
                fin.readLine();
                int setId = 1;
                int number_sets = Integer.parseInt(fin.readLine());
                SCPModel read_model = new SCPModel();
                
                while (setId<number_sets) {
                    double cost = Double.parseDouble(fin.readLine());
                    List<Integer> eleIDs = new ArrayList<Integer>();
                    int check = Integer.MAX_VALUE;
                    
                    while (check!=0) {
                        check=Integer.parseInt(fin.readLine());
                        if (check !=0)
                            eleIDs.add(check);
                    } 
                    
                    read_model.addSetToCover(setId, cost, eleIDs);
                    setId++;
                }
              return read_model;             
            }
            
            catch (IOException e) {
                throw new IOException("An IOException occured");
                }
            
        }
        
        public static void main(String[] args) {
            addSetToCover(1,5.2,Arrays.asList(new Integer[] {9,6,10}));
            addSetToCover(2,3.2,Arrays.asList(new Integer[] {4,5,7,8}));
            addSetToCover(3,4,Arrays.asList(new Integer[] {3,2,1}));
            
            System.out.println(_scp.size());
            _scp.clear();
            System.out.println(_scp.size());
            
            // now checking if count persists
            addSetToCover(1,5.2,Arrays.asList(new Integer[] {9,6,10}));
            addSetToCover(2,3.2,Arrays.asList(new Integer[] {4,5,7,8}));
            addSetToCover(3,4,Arrays.asList(new Integer[] {3,2,1}));
            
            System.out.println(_scp.size());
            
            addSetToCover(4,5.2,Arrays.asList(new Integer[] {9,6,10}));
            addSetToCover(5,3.2,Arrays.asList(new Integer[] {4,5,7,8}));
            addSetToCover(6,4,Arrays.asList(new Integer[] {3,2,1}));
            
            System.out.println(_scp.size());
            
            //Make sure getter is working
            
            _scp = getScp();
            
            System.out.println(_scp.size());
            
            // test to make sure correct element sets entered
            
           for (ElementSet e: _scp) {
               System.out.println(e);
           }
            
            
        }
    }
