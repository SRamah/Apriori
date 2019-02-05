package Algorithme_Apriori;


import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salaheddine
 */
public class TraitementFile {
    
   public LinkedList basicItems = new LinkedList();
   public LinkedList allItems = new LinkedList();
   public LinkedList<LinkedList> deletedItems = new LinkedList();
   public LinkedList<LinkedList<LinkedList<LinkedList>>> reglesAssociationGenerale = new LinkedList();
   public LinkedList<LinkedList> ensembleFinaleGenerale = new LinkedList();
   public LinkedList<LinkedList> matriceDesEnsembles = new LinkedList();
   
   public LinkedList<LinkedList> combliste = new LinkedList();
   public int  nbcomb=0;
    
    
    
   public LinkedList<LinkedList> TraitementFile(String path , String separateur){
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
                System.out.println("Fichier : \n"+list);
        return list;
   }
   
   
   public LinkedList<LinkedList> TraitementMatrice(LinkedList<LinkedList> matrice , String separateur){
       LinkedList<LinkedList> list = new LinkedList();
        try {
                for (int i = 1; i < matrice.size(); i++) {
                
                            LinkedList ling = new LinkedList();
                            String row = new String((String)matrice.get(i).get(1));
                            
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


        }
                        
        catch(Exception e) {
                System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println("Matrice de travaille : \n"+list);
        return list;
   }
   
   
   public void ItemsOccurence(LinkedList<LinkedList> travmatrice, int frequence){
       
       LinkedList<LinkedList> ensembleFinale = new LinkedList();
       LinkedList<LinkedList<LinkedList<LinkedList>>> reglesAssociation = new LinkedList();// attension!!!!!!+<LinkedList>
      
       PremierIteration(travmatrice, frequence);
       
       ensembleFinale = EnsembleFinale(travmatrice, frequence);
       ensembleFinaleGenerale=ensembleFinale;
       
       if(ensembleFinale.isEmpty()){
           System.out.println("List des Items est vide !!! \n");
       }
       
       System.out.println("La list d'Items finale est : "+ensembleFinale);
       reglesAssociation = ReglesAssociation(ensembleFinale);
       reglesAssociationGenerale=reglesAssociation;
       
       /*for (int i = 0; i < reglesAssociation.size(); i++) {
           System.out.println("Les regles de l'ensemble "+i+" :\n*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
           for (int l = 0; l < reglesAssociation.get(i).size(); l++) {
               if( EffetLevier(travmatrice, ensembleFinale.get(i), reglesAssociation.get(i).get(l)) > 1 )
                    System.out.println("Règle importante ==> "+reglesAssociation.get(i).get(l)+"\n");
               else System.out.println("Règle n'est pas importante ==> "+reglesAssociation.get(i).get(l)+"\n");
           }
           
       }*/
       
   }
   
   
   public int CalculOccurence(LinkedList<LinkedList> travmatrice,LinkedList temp ){
       //LinkedList tempOccurence = new LinkedList();
       int count=0,nboccurence=0;
       
        
        for (int k = 0; k < travmatrice.size(); k++) {
               int valeur=0;
            for (int i = 0; i < temp.size(); i++) {
                if(travmatrice.get(k).contains(temp.get(i))){
                 count=1;
                }
                if(count==1){
                    valeur++;
                    count=0;
                }
                else{
                    valeur=0;
                }
            }
            if(valeur==temp.size()) nboccurence++;
           
       }
           

            //tempOccurence.add(temp);
            //tempOccurence.add(count);
       
        
        //System.out.println("tempOccurence : "+tempOccurence+"\n");
        return nboccurence;
   }
   
   
   public LinkedList<LinkedList> PremierIteration(LinkedList<LinkedList> travmatrice, int frequence){
       basicItems.removeAll(basicItems);
       LinkedList<LinkedList> occurence = new LinkedList();
       
       LinkedList test = new LinkedList();
       for (int i = 0; i < travmatrice.size(); i++) {
           
           for (int j = 0; j < travmatrice.get(i).size(); j++) {
               
               
               LinkedList tempOccurence = new LinkedList();
               int count=0;
               LinkedList temp = new LinkedList();
               temp.add(travmatrice.get(i).get(j));
               
               if(!test.contains(temp.get(0))){
                    for (int k = 0; k < travmatrice.size(); k++) {
                         if(travmatrice.get(k).containsAll(temp)){
                             count++;
                         }
                    }
                    test.add(temp.get(0));
                    allItems.add(temp.get(0));
                    //basicItems.add(temp.get(0));
                    if(count>=frequence){
                     basicItems.add(temp.get(0));
                     tempOccurence.add(temp);
                     tempOccurence.add(count);
                     occurence.add(tempOccurence);
                    }
               }
           }
           
       }
       System.out.println("Aprés traitement : \n"+occurence);
       System.out.println("test : \n"+test);
       System.out.println("basicItems : \n"+basicItems);
       return occurence;
   }
   
   
   /*
    fonction arrangements(Liste L, Liste F, k) {
    si k est égal à 0, {
        afficher  L
    } sinon {
        pour tous les éléments x de l'ensemble F  {
             Liste G = F moins x 
                         (F auquel on a ôté l'élément x)
             Liste L2  = L plus x  
                         (on a concaténé x à la droite de la liste L)
             arrangements(L2, G , k-1)
        }
    }
   */
   public void Arrangements(LinkedList sousEnsemble, LinkedList listBasicItems , int degre){
       if (degre==0) {
           LinkedList lili = new LinkedList();
           lili=(LinkedList) sousEnsemble.clone();
           int pout=0;
           for(int i=0;i<matriceDesEnsembles.size();i++){
                if(matriceDesEnsembles.get(i).containsAll(lili) && pout==0) {
                    pout=1;
                }
           }
           if(pout==0){
               matriceDesEnsembles.add(lili);
               System.out.println(lili);
           }
           
       } else {
           for (int i = 0; i < listBasicItems.size(); i++) {
               int count=0;
               LinkedList restItems = new LinkedList();
               restItems= (LinkedList) listBasicItems.clone();
               restItems.remove(i);
               LinkedList list = new LinkedList();
               list= (LinkedList) sousEnsemble.clone();
               list.add(listBasicItems.get(i));
               
               for (int k = 0; k < deletedItems.size(); k++) {
                    if(list.containsAll(deletedItems.get(k)) && count==0) count=1;
                        
               }
               if(count==0)
                    Arrangements(list, restItems, degre-1);
           }
       }
       
   }
   
   
   public LinkedList<LinkedList> CreerEnsembles1(LinkedList listBasicItems , int degre){
       matriceDesEnsembles.removeAll(matriceDesEnsembles);
       
       LinkedList list = new LinkedList();
       Arrangements(list, listBasicItems, degre);
       
       return matriceDesEnsembles;
   }
   
   public LinkedList<LinkedList> CreerEnsembles(LinkedList listBasicItems , int degre){
       LinkedList<LinkedList> matriceEnsemble = new LinkedList();
       /*
        [A, D, G, I, L, E, B, K, C, M, H] ==> size = 11

        [A, D : G, I, L, E, B, K, C, M, H]
        [D, G : I, L, E, B, K, C, M, H]
        [G, I : L, E, B, K, C, M, H]
        [I, L : E, B, K, C, M, H]
        [L, E : B, K, C, M, H]              }==> size = 9
        [E, B : K, C, M, H]
        [B, K : C, M, H]
        [K, C : M, H]
        [C, M : H]
       */
       if(degre>1){
            for (int i = 0; i < (listBasicItems.size()-degre+1); i++) {
                 int count=0;
                LinkedList tempSousEnsemble = new LinkedList();
                 for(int d = 0; d < degre-1; d++){ //fixer les items
                     tempSousEnsemble.add(listBasicItems.get(i+d));  
                 }
                for (int j = (i+degre-1); j < listBasicItems.size(); j++) {
                    LinkedList sousEnsemble = new LinkedList();
                    sousEnsemble=(LinkedList) tempSousEnsemble.clone();
                    sousEnsemble.add(listBasicItems.get(j));
                    for (int k = 0; k < deletedItems.size(); k++) {
                        if(sousEnsemble.containsAll(deletedItems.get(k)) && count==0) count=1;
                        
                    }
                    //if(count==0)
                    matriceEnsemble.add(sousEnsemble);
                    /*
                    if((j+degre-2)<(listBasicItems.size())  &&  degre>2){
                        LinkedList sousEnsemble2 = new LinkedList();
                        sousEnsemble2.add(listBasicItems.get(i));
                        for(int d = 0; d < degre-1; d++){ 
                            sousEnsemble2.add(listBasicItems.get(j+d));  
                        }
                        if(!deletedItems.containsAll(sousEnsemble2))
                        matriceEnsemble.add(sousEnsemble2);
                    }*/
                    
                }
            }
       }
       else if(degre==1) {
           for (int i = 0; i < listBasicItems.size(); i++) {
               LinkedList tempItems = new LinkedList();
               tempItems.add(listBasicItems.get(i));
               matriceEnsemble.add(tempItems);
           }
           
           return matriceEnsemble;
       }
       System.out.println(" La matrice des ensembles : "+matriceEnsemble);
       return matriceEnsemble;
       
   }
    
   ////////////////////////////////////////////////////////////////////////////
   
   

public void comb(LinkedList L, LinkedList t, int n ,int k) {
   if(n<k) {
    
       System.out.println("null"); return;
   }
   if(k==0) {
     System.out.println(L);
        /*//test de delete
            int pout=0;
            LinkedList lili = new LinkedList();
           lili=(LinkedList) L.clone();
           for(int i=0;i<deletedItems.size();i++){
               LinkedList temp = new LinkedList();
               temp=(LinkedList) deletedItems.get(i).clone();
                if(lili.containsAll(temp) && pout==0) {
                    pout=1;
                }
           }
           if(pout==0){
               combliste.add(L);
               System.out.println(L);
           } else System.out.println("delete : "+L);
        //test de delete */
     combliste.add(L);
     nbcomb++;
     
   } else {
      for(int i=0;i < n-k+1; i++) {
        LinkedList L2 = (LinkedList) L.clone();
        L2.add(t.get(i));
        LinkedList t2 = new LinkedList();
        int j = 0;
        for(int r = i+1 ; r < n ; r++) {
            t2.add(t.get(r));
             //t2.set(j, t.get(r));
             j++;
        }
        //test de delet
        int count=0;
        for (int h = 0; h < deletedItems.size(); h++) {
            if(L2.containsAll(deletedItems.get(h)) && count==0) count=1;
                        
        }
               if(count==0)           
        //test de delet
        comb(L2, t2, j, k-1);
     }
   }
}

public LinkedList<LinkedList> effectue(LinkedList listBasicItems , int degre) {
    
    LinkedList<LinkedList> Ensembles = new LinkedList();
    
  LinkedList L = new LinkedList();
  int n = listBasicItems.size();
  
  

  combliste.removeAll(combliste);
  nbcomb = 0;
  comb(L, listBasicItems, n, degre);
  System.out.println("comb end");
  Ensembles=(LinkedList<LinkedList>) combliste.clone();
    System.out.println("Le nombre des des ensembles est : "+nbcomb);
       return Ensembles;
}
   
   ///////////////////////////////////////////////////////////////////////////
   
   public void EnsembleItemsOccurence(LinkedList<LinkedList> travmatrice, LinkedList<LinkedList> ensembles, int frequence){
       LinkedList<LinkedList> occurence = new LinkedList();
       deletedItems.removeAll(deletedItems);
       
        for (int i = 0; i < ensembles.size(); i++) {
            int count=0;
            LinkedList tempOccurence = new LinkedList();
            for (int j = 0; j < travmatrice.size(); j++) {
              
                
                if(travmatrice.get(j).containsAll(ensembles.get(i))){
                    count++;
                }
               
            }
            
            if(count>=frequence){
                    
                     tempOccurence = (LinkedList) ensembles.get(i).clone();
                     tempOccurence.add(":"+count);
                     occurence.add(tempOccurence);
            }
            
            if(count<frequence)  {
                /*tempOccurence = (LinkedList) ensembles.get(i).clone();
                tempOccurence.add(":"+count);*/
                deletedItems.add(ensembles.get(i));
            }
           
       }
        System.out.println("Aprés traitement : \n"+occurence);
       
       
       System.out.println("deletedItems : \n"+deletedItems);
       
   }
   
   
   public LinkedList<LinkedList> EnsembleFinale(LinkedList<LinkedList> travmatrice, int frequence){
       int dim =2,repete=2;
       LinkedList<LinkedList> ensembleFinale = new LinkedList();
       LinkedList<LinkedList> ensembleFinaleTemp = new LinkedList();
       
       while( repete>1 ){
           LinkedList<LinkedList> ensembles = new LinkedList();
           //ensembles=CreerEnsembles1(basicItems, dim);
           ensembles=effectue(basicItems, dim);
           EnsembleItemsOccurence(travmatrice, ensembles, frequence);
           repete=(ensembles.size()-deletedItems.size());
           
           
           if(repete>1){
               System.out.println("------------------\n Résultat partiel :\n------------------");
               LinkedList<LinkedList> sousEnsembleFinale = new LinkedList();
               
               for (int p = 0; p < ensembles.size(); p++) {
                   
                   LinkedList temp = new LinkedList();
                   temp.add(ensembles.get(p));
                   //sousEnsembleFinale.add(temp);
                   if(!deletedItems.containsAll(temp)) {
                       temp=(LinkedList) (ensembles.get(p)).clone();
                       sousEnsembleFinale.add(temp);
                   }
               }
               
               ensembleFinaleTemp=(LinkedList<LinkedList>) (sousEnsembleFinale).clone();
               //System.out.println("ensembleFinaleTemp : "+ensembleFinaleTemp);
            }
           
           
            if(repete==1){ 
                System.out.println("******************\n Résultat exact :\n******************");
               for (int p = 0; p < ensembles.size(); p++) {
                   LinkedList sousEnsemble = new LinkedList();
                   sousEnsemble.add(ensembles.get(p));
                   if(!deletedItems.containsAll(sousEnsemble)) { 
                       LinkedList<LinkedList> temp = new LinkedList();
                       temp.add(ensembles.get(p));
                       ensembleFinale=(LinkedList<LinkedList>) (temp).clone();/* ensembleFinale.add(ensembles.get(p)); */ 
                   }
               }
            }
            
            
           dim++;
       }
       
       //System.out.println("La list d'Items finale est : "+ensembleFinale);
        if(repete==0){
            System.out.println("Retour vers l'ensemble finale précédentes : "+ensembleFinaleTemp);
            return ensembleFinaleTemp;
        }
        else {
           System.out.println("L'ensemble finale exacte : "+ensembleFinale);
           return ensembleFinale;
        }
        
       
           
   }
   
   
   public LinkedList<LinkedList<LinkedList<LinkedList>>> ReglesAssociation(LinkedList<LinkedList> ensembleFinale){
       
       LinkedList<LinkedList<LinkedList<LinkedList>>> reglesFinal = new LinkedList();
       deletedItems.removeAll(deletedItems);
       
       for (int l = 0; l < ensembleFinale.size(); l++) {
           LinkedList<LinkedList<LinkedList>> regles = new LinkedList();
       
            for (int i = 1; i < ensembleFinale.get(l).size(); i++) {


                    LinkedList<LinkedList> matriceEnsemble = new LinkedList();
                    //matriceEnsemble = CreerEnsembles1( ensembleFinale.get(l),(ensembleFinale.get(l).size()-i) );
                    matriceEnsemble = effectue(ensembleFinale.get(l),(ensembleFinale.get(l).size()-i) );

                    for (int k = 0; k < matriceEnsemble.size(); k++) {
                        LinkedList tempRegleMatrice = new LinkedList();
                        LinkedList tempRegleList = new LinkedList();

                        tempRegleList = (LinkedList) matriceEnsemble.get(k).clone();


                        tempRegleMatrice.add(tempRegleList);
                        tempRegleMatrice.add( ResteItems(ensembleFinale.get(l), tempRegleList) );
                        regles.add(tempRegleMatrice);

                    }


            }
            reglesFinal.add(regles);
            
        }
       
       System.out.println("Les Régles : "+reglesFinal+"\n");
       return reglesFinal;
   }
  /* 
   public void purmitation(LinkedList<LinkedList> ensembleFinale){
       
       for (int i = 0; i < ensembleFinale.size(); i++) {
           int n = ensembleFinale.get(i).size()-1;
           int c = 0;
           Recursive(ensembleFinale.get(i),c,n);
           
       }
       
   }
   
   
   public static void Recursive(LinkedList Final ,int i , int n) {
    if(i==n) {
        System.out.println(Final);
    }
    else {
        for(int j=i ; j<=n ; j++) {
            String st1 = (String) Final.get(i);
            String st2 = (String) Final.get(j);
            Final.set(i, st2) ;
            Final.set(j, st1) ;
            Recursive(Final, i+1, n);
            String st3 = (String) Final.get(i);
            String st4 = (String) Final.get(j);
            Final.set(i, st4) ;
            Final.set(j, st3) ;
        }
    }
}*/
   
   
   public LinkedList ResteItems( LinkedList ensembleFinale, LinkedList itemsChoisi ) {
       LinkedList autreItemsList = new LinkedList();
       for (int i = 0; i < ensembleFinale.size(); i++) {
           
           if ( !itemsChoisi.contains( ensembleFinale.get(i) ) ) {
               autreItemsList.add(ensembleFinale.get(i));
           }
           
       }
       
        return autreItemsList;
    }
   
   
   public double EffetLevier( LinkedList<LinkedList> travmatrice, LinkedList ensembleFinale, LinkedList<LinkedList> regle ){
      // antecedent ==> consequent
       LinkedList antecedent = new LinkedList(regle.get(0));
       LinkedList consequent = new LinkedList(regle.get(1));
       
       int totaleTransaction = travmatrice.size();
       int frequenceAntecedent = CalculOccurence(travmatrice, antecedent);
       int frequenceConsequent = CalculOccurence(travmatrice, consequent);
       int frequenceRegle = CalculOccurence(travmatrice, ensembleFinale);;
       double supportConsequent = 0.0 + ((double)frequenceConsequent)/totaleTransaction;//   frequenceConsequent/totaleTransaction
       double supportRegle = 0.0 + ((double)frequenceRegle)/totaleTransaction;//  frequenceRegle/totaleTransaction
       double confianceRegle = 0.0 + ((double)frequenceRegle)/frequenceAntecedent;//  frequenceRegle/frequenceAntecedent
       
       double levierRegle = 0.0 + confianceRegle/supportConsequent;//   confianceRegle/supportConsequent
       
       
       if(confianceRegle>0.7){
       //////////////////////   Affichage   ////////////////////////
       System.out.println("Règle : "+regle.get(0)+" ==> "+regle.get(1)+"\n =======================================\n");
       System.out.println("antecedent : "+regle.get(0));
       System.out.println("consequent : "+regle.get(1));
       System.out.println("totaleTransaction = "+totaleTransaction);
       System.out.println("frequenceAntecedent = "+frequenceAntecedent);
       System.out.println("frequenceConsequent = "+frequenceConsequent);
       System.out.println("frequenceRegle = "+frequenceRegle);
       System.out.println("supportConsequent = "+supportConsequent);
       System.out.println("supportRegle = "+supportRegle);
       System.out.println("confianceRegle = "+confianceRegle);
       System.out.println("levierRegle = "+levierRegle+"\n\n");
       //////////////////////   Affichage   ////////////////////////
       }
       
       return levierRegle;
       
   }
   
   
   public static void main(String arg[]){
       TraitementFile tf = new TraitementFile();
       tf.ItemsOccurence(tf.TraitementMatrice(tf.TraitementFile("/Users/salaheddine/Desktop/Items_achat3.txt", ""),","),2);
   }

   
   
    
}
