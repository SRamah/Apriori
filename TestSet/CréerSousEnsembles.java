LinkedList deletedItems = new LinkedList();
LinkedList combliste = new LinkedList();
int nbcomb = 0;

public void comb(LinkedList L, LinkedList t, int n ,int k) {
   if(n<k) {
    
       System.out.println("null"); return;
   }
   if(k==0) {
     System.out.println(L);
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