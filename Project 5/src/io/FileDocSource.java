/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;
import java.util.*;
import java.io.*;

/**
 *
 * @author Matthew Kwan, matthewky.kwan@gmail.com
 */
public class FileDocSource extends DocSource {
    
    public ArrayList<File> docs;
    
    public FileDocSource(String dir) {
        docs = new ArrayList<File>();
        docs = FileFinder.GetAllFiles(dir);
    }
    
  
    @Override
    public int getNumDocs() {   
        return docs.size();
    }

    @Override
    public String getDoc(int id)  {
        
        StringBuilder sb = new StringBuilder();
        
        try {
            File file = docs.get(id);
            BufferedReader fin = new BufferedReader(new FileReader(file));
            
            
            String currentline = fin.readLine();
            do {
                sb.append(currentline);
                currentline = fin.readLine();
            } while (currentline != null);
        }
        
        catch (IOException e) {
            System.out.print("file not found");
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        
       // FileDocSource test = new FileDocSource();
       //System.out.println(test.getDoc(0));
       // System.out.print(test.getNumDocs());    
    }
}
