package com.company.Partition1;

import com.company.Arc;
import com.company.Graphe;
import com.company.IGestionPartition;
import com.company.Node;

import java.util.*;

public class GestionDePartition implements IGestionPartition {

    private List<ArbrePartition> partitions = new ArrayList<>();//liste des arbres

    public List<ArbrePartition> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<ArbrePartition> partitions) {
        this.partitions = partitions;
    }

    /**
     *Arbre recouvrant de poids minimal
     * @param graphe
     */
    public void abr_kruskal(Graphe graphe){
        int min=Integer.MAX_VALUE;//valeur tres haute pour obtenir le poid le plus petit
        Arc a_min = null;
        List<ArbrePartition> lP = new ArrayList<>();
        int poid_abr= 0;
        int size = graphe.getArcs_pondere().size();
        for (Node n : graphe.getList_node()) {
            lP.add(new ArbrePartition(n.getNom()));
        }
        while(graphe.getArcs_pondere().size() > 0) {
            min=Integer.MAX_VALUE;
            //recherche valeur minimal
            for (Arc me : graphe.getArcs_pondere()) {
                int v = me.getValeur();
                if (v < min) {
                    min = v;
                    a_min = me;
                }
            }
            ArbrePartition gp = recherche_list_partition(lP, a_min.getA());
            ArbrePartition gp2 = recherche_list_partition(lP, a_min.getB());
            if (gp.rechercheRacine() != gp2.rechercheRacine()) {
                //gp2.poid = a_min.getValeur();
                //gp.union(gp2,a_min.getValeur());
                gp.union_pondere(gp2,a_min.getValeur());
                poid_abr += a_min.getValeur();
            }
            graphe.getArcs_pondere().remove(a_min);
            a_min = null;
        }

        partitions = lP;
        afficherPartition();
        //System.out.println("\n");
        /*for (ArbrePartition a: lP){
            System.out.println("\n= a "+a+" p "+a.poid+" r "+a.rechercheRacine()+" r poid "+a.rechercheRacine().poid+"");
        }*/
        System.out.println("\n -> "+lP.get(0).rechercheRacine().getPere().poid+"  \n");
    }


    /**
     * Composantes connexe
     * @param graphe
     */
    public void compo_connexe(Graphe graphe){
        //HashMap<Arc,Integer> hmn = map_arrete(nodes);
        List<ArbrePartition> lP = new ArrayList<>();
        //création d'une feuille ArbrePartition pour chaque
        for (Node n : graphe.getList_node()) {
            lP.add(new ArbrePartition(n.getNom()));
        }
        if (graphe.getArcs_pondere().size() == 0){
            partitions =  lP;
            return;
        }
        graphe.getArcs_pondere().forEach((k) -> {
            ArbrePartition gp = recherche_list_partition(lP,k.getA());//lP.get(lP.indexOf(new ArbrePartition(k.getA().getNom())));
            ArbrePartition gp2 = recherche_list_partition(lP,k.getB());
            //if(gp.rechercheRacine() != gp2.rechercheRacine()){
                //gp.union(gp2);//remmetre le if pour l'union sans equilibrage normal
                gp.union_pondere(gp2,0);
            //}
        });
        partitions =  lP;
    }

    /**
     * recherche dans la liste de partition
     * @param l
     * @param n
     * @return
     */
    public static ArbrePartition recherche_list_partition(List<ArbrePartition> l, Node n){
        for (ArbrePartition gp : l) {
            if(gp.nom == n.getNom()){
                return gp;
            }
        }
        return null;
    }

    public void afficherPartition(){
        System.out.print("\n\n { ");
        for (ArbrePartition p: partitions) {
            if(p.rechercheRacine() == p){
                System.out.print(" { ");
                //System.out.print(p.nom);
                for (ArbrePartition pp: partitions) {
                    if( pp.rechercheRacine() == p){//p != pp &&
                        System.out.print(pp.nom+";");
                    }
                }
                System.out.print(" } ");
            }
        }
        System.out.print(" } \n");
    }

}
