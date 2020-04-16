package com.company;

import com.company.Partition1.GestionDePartition;

/**
 *  //Fatima-Ezzohra AKHTEN et Arthur DELAIN. (intel ij) L3 UCA Groupe A 04/2019
 */
public class Main {

    public static void main(String[] args) {
        Graphe g2 = new Graphe();
        g2.creationGrapheAleatoire(0.75,10,5);//haut tot de probabilité pour créer un graphe connexe
        g2.afficherGrahe();
        GestionDePartition gp2 = new GestionDePartition();

        long startTime = System.currentTimeMillis();

        gp2.abr_kruskal(g2);

        long endTime = System.currentTimeMillis();
        System.out.println("Temps exec Kruskal:"+ (endTime-startTime));


        Thread_Exec exec = new Thread_Exec();//compo connexe
        exec.traitement(500);
    }


    /*java.util.List<Integer> listElement = new ArrayList<>();//ici liste des nombre d'arretes dans le graphe
        //java.util.List<Long> listSerie1 = new ArrayList<>();//liste du temps d'execution de GestionPartion
        //java.util.List<Long> listSerie2 = new ArrayList<>();//liste du temps d'execution de GestionPartion2
        List<Long> listSerie1 = new ArrayList<>();
        List<Long> listSerie2 = new ArrayList<>();
        int nb_test =250;
        for (int i =0; i <nb_test;i++){
            Graphe g = new Graphe();
            g.creationGrapheAleatoire(0.1,i,i);//bas tot de probabilité pour créer un graphe non connexe
            //g.afficherGrahe();
            GestionDePartition gp = new GestionDePartition();
            long startTime = System.currentTimeMillis();
            gp.compo_connexe(g);
            long endTime = System.currentTimeMillis();
            //gp.afficherPartition();
            //System.out.println("Temps exec :"+ (endTime-startTime) +" "+endTime+" "+startTime);

            //System.out.println("\n===================================\n");
            //g.afficherGrahe();
            GestionDePartion2 gp2 = new GestionDePartion2();
            long startTime2 = System.currentTimeMillis();
            gp2.compo_connexe(g);
            long endTime2 = System.currentTimeMillis();
            //gp2.affichage();
            //System.out.println("Temps exec :"+ (endTime2-startTime2));
            //System.out.println("\n===================================\n");
            //
            // System.out.println("Temps exec:  "+(endTime-startTime)+" | "+(endTime2-startTime2));
            listElement.add(g.getList_node().size());
            listSerie1.add((endTime-startTime));
            listSerie2.add((endTime2-startTime2));
        }
        //System.out.println("\n->"+listSerie1.size()+" "+listSerie2.size()+" "+listElement.size());
        Affichage_Graphique ag = new Affichage_Graphique(listElement,listSerie1,listSerie2,"","Nombre d'axe", "Temps (ms)");
        */


}
