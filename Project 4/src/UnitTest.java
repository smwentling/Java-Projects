import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.SCPModel;
import solver.ChvatalSolver;
import solver.GreedyCostSolver;
import solver.GreedyCoverageSolver;
import solver.GreedySolver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kwanmat4
 */
public class UnitTest {
    
    SCPModel test = new SCPModel();
    public static GreedySolver gs;
    
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
     
    public static void main(String[] args) throws IOException {
        SCPModel model = new SCPModel();
        File f = new File("src/file/SCPInstances/test");
        model = ReadModel(f);
        

        GreedyCoverageSolver CoverageMethod = new GreedyCoverageSolver();
	GreedyCostSolver CostMethod = new GreedyCostSolver();
	ChvatalSolver ChvatalMethod = new ChvatalSolver();
		
	List<GreedySolver> solvers = Arrays.asList(new GreedySolver[] {CoverageMethod, CostMethod, ChvatalMethod});
        
        gs = CoverageMethod;
       
        gs.setMinCoverage(0.9);
        gs.setModel(model);
        gs.solve();
        
        System.out.println(gs._count);
        System.out.println(gs.getObjFn());
        System.out.println(gs.getCoverage());
        
        
        gs.solve();
       
        
        System.out.println(gs._count);
        System.out.println(gs.getObjFn());
        System.out.println(gs.getCoverage());
        
        f = new File("src/file/SCPInstances/SCP_L_1000-1000.txt");
        model = ReadModel(f);
        
        
        gs.solve();
        System.out.println(gs._count);
        System.out.println(gs.getObjFn());
        System.out.println(gs.getCoverage());
                
        
        
    }
}
