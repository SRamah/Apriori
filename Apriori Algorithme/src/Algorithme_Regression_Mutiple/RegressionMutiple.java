/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithme_Regression_Mutiple;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author salaheddine
 */
public class RegressionMutiple {
    
    public LinkedList<LinkedList> TraitementFichier(String path , String separateur){
        
                LinkedList<LinkedList> list = new LinkedList();
		try {
			File f = new File(path);
			if (f.exists()) {
				FileReader fr = new FileReader(f);
				LineNumberReader in = new LineNumberReader(fr);
				String row;
                                
				while ( (row = in.readLine()) != null) {
                                    
                                    //System.out.println(row);
                                   // LinkedList<String> ling = new LinkedList();
                                    LinkedList ling = new LinkedList();
                                    if(separateur.equals("") || separateur.equals(" ") || separateur.equals("  ") || separateur.equals("   ")){
                                        StringTokenizer st = new StringTokenizer(row);
                                        while (st.hasMoreTokens()) {
                                            ling.add(st.nextToken());
                                            //System.out.println("variable :" + st.nextToken());

                                        }
                                    }else { 
                                        StringTokenizer st = new StringTokenizer(row,separateur);
                                        while (st.hasMoreTokens()) {
                                        ling.add(st.nextToken());
                                        //System.out.println("variable :" + st.nextToken());
                                        
                                        }
                                    }
                                    
                                    
                                    list.add(ling);
                                    
				}
                                
                                //System.out.println("affiche(0,4) "+((LinkedList)list.get(0)).get(4));
                                
                                
				
			}
                        else System.out.println("Le fichier choisis est introuvable..... ");
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
        return list;
                
}
    
    
}
