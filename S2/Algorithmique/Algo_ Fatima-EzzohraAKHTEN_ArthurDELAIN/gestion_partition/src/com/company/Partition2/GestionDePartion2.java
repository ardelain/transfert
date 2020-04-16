package com.company.Partition2;

import com.company.Arc;
import com.company.Graphe;
import com.company.IGestionPartition;
import com.company.Node;

import java.util.ArrayList;
import java.util.List;

public class GestionDePartion2 implements IGestionPartition {
    List<ListePartition> list_listPartition = new ArrayList<>();

    public ListePartition rechercheL(List<ListePartition> l,int n){
        for(ListePartition listePartition: l){
            if(n == listePartition.getValeur()){
                return listePartition;
            }
        }
        return null;
    }

    public void affichage(){
        System.out.println("\n\nAffichage partition : ");
        for(ListePartition listePartition: list_listPartition){
            System.out.println(listePartition+", ");
        }
        System.out.println("\n");
    }

    public void compo_connexe(Graphe g){
        List<ListePartition> l = new ArrayList<>();
        for(Arc a: g.getArcs_pondere()){
            //System.out.println("arc :  a"+a.getA().getNom()+" b"+a.getB().getNom());
            boolean aPresent = false; // pour verifier durant le parcours si a / le premier sommet est present
            boolean bPresent = false;// pour verifier durant le parcours si b / le deuxieme sommet est present
            ListePartition testb = null;
            for(ListePartition listePartition: l){
                ListePartition nv = null;
                if( listePartition.recherche(a.getA().getNom())){
                    if(!listePartition.recherche(a.getB().getNom())){
                        for(ListePartition listePartition2: l){
                            if( listePartition2.recherche(a.getB().getNom()) && listePartition2!= listePartition){
                                testb = listePartition2;
                                //System.out.println("l "+testb +" | "+listePartition);
                                listePartition.getList().addAll(listePartition2.getList());
                                bPresent = true;
                            }
                        }
                    }else{
                        bPresent = true;
                    }
                    if(!bPresent){
                        listePartition.ajouter(new Element(a.getB().getNom(),0));
                        //System.out.println("!bPresent  b"+a.getB().getNom());
                    }
                    aPresent = true;
                }
            }
            if(bPresent){
                l.remove(testb);
                //System.out.println("!remove   "+testb);
            }
            if(!aPresent){
                //boolean bPresent = false;
                for(ListePartition listePartition: l){
                    if( listePartition.recherche(a.getB().getNom())){
                        listePartition.ajouter(new Element(a.getA().getNom(),0));
                        //System.out.println("!aPresent  a"+a.getA().getNom());
                        bPresent = true;
                    }
                }
                if(!bPresent){
                    ListePartition lp = new ListePartition();
                    lp.ajouter(new Element(a.getA().getNom(),0));
                    lp.ajouter(new Element(a.getB().getNom(),0));
                    l.add(lp);
                    //System.out.println("! ! :  a"+a.getA().getNom()+" b"+a.getB().getNom());
                }
            }
        }

        //on ajoute les orphelins / sans arc
        boolean present = false;
        List<ListePartition> l2 = new ArrayList<>();
        for (Node n : g.getList_node()) {
            for(ListePartition listePartition: l) {
                if (listePartition.recherche(n.getNom())) {
                    present = true;
                }
            }
            if (!present) {
                ListePartition lp = new ListePartition();
                lp.ajouter(new Element(n.getNom(),0));
                l2.add(lp);
            }
            present = false;
        }
        l.addAll(l2);
        list_listPartition = l;

        //affichage(l);
        //return l;
    }
}
