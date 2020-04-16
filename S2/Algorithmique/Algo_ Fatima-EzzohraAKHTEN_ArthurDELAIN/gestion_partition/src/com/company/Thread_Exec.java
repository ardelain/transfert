package com.company;

import com.company.Partition1.GestionDePartition;
import com.company.Partition2.GestionDePartion2;

import java.util.ArrayList;
import java.util.List;

/**
 * Parallelisation / Lancement des threads de calcul (pour compo_connexe)
 */
public class Thread_Exec {
    public  void traitement(int nb ){
        try{
            java.util.List<Integer> listElement = new ArrayList<>();
            int nb_test =nb;
            List<Graphe>lg = new ArrayList<>();
            for (int i =0; i <nb_test;i++) {
                Graphe g = new Graphe();
                g.creationGrapheAleatoire(0.01, i, i);// création de graphe avec forte chance de non connexité (une chance sur cent de creer un lien entre 2 arretes) qui a un nombre de sommet entre i et i ici
                listElement.add(i);//nombre de sommet
                lg.add(g);
            }
            ProcessP p = new ProcessP(new GestionDePartition(),lg);
            ProcessP p2 = new ProcessP(new GestionDePartion2(),lg);
            p.start();
            p2.start();
            p.thisThread.join();
            p2.thisThread.join();
            Affichage_Graphique ag = new Affichage_Graphique(listElement,p.listSerie,p2.listSerie,"Algo Connexe  - Test","Nombre d'axe", "Temps (ms)","avec partition","normal");

        }catch(Exception e){
            System.err.println("\nERREUR ");
        }
    }
}

/**
 * Processus s'ocupant de lancer un nombre de calcul d'un certain type (IGestionPartition) sur une liste de Graphe et de récupérer leur temps d'executions dans listSerie
 */
class ProcessP implements Runnable{
    Thread thisThread;
    //int nb;
    //java.util.List<Integer> listElement = new ArrayList<>();
    List<Long> listSerie = new ArrayList<>();//resultat lpI
    List<ProcessF> lpI = new ArrayList<>();

    IGestionPartition ig;
    List<Graphe> lg;

    public ProcessP(IGestionPartition ig, List<Graphe> lg) {
        this.ig = ig;
        this.lg = lg;
    }

    public void start() {
        if (thisThread != null) {
            return;
        }
        thisThread = new Thread(this);
        thisThread.start();
    }

    public List<Long> stop() {
        thisThread = null;
        return listSerie;
    }

    public void run() {
        //ExecutorService es = Executors.newSingleThreadExecutor();
        ProcessF pI ;
        for(Graphe g:lg){
            pI = new ProcessF(g,ig);
            lpI.add(pI);
            pI.start();
        }
        //es.shutdown();//attente des processus
        try {
            for(ProcessF pi : lpI){
                pi.thisThread.join();
                listSerie.add(pi.temps_exec);
                //System.out.println("Thread PERE "+pi.num+" fini" + " valeur: ");
            }
            //System.out.println("Thread PERE FIN");
        } catch (Exception e) {
            System.out.println("Fin Force attente pere !");
            return;
        }
        //System.out.println("Thread PERE FINI");
    }
}

/**
 * Thread permettant de lancer un compo_connexe() d'un IGestionPartition quelconque et d'enregistrer son temps d'execution (temps_exec)
 */
class ProcessF implements Runnable{

    int num;

    Thread thisThread;
    Graphe g;
    long temps_exec;
    IGestionPartition ig;


    public ProcessF(Graphe g,IGestionPartition ig) {
        this.g = g;
        this.ig = ig;
    }


    public void start() {
        if (thisThread != null) {
            return;
        }
        thisThread = new Thread(this);
        thisThread.start();
    }


    public long stop() {
        thisThread = null;
        System.out.println("Thread "+num+" FINI" + " valeur: "+temps_exec);
        return temps_exec;
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        ig.compo_connexe(g);
        long endTime = System.currentTimeMillis();
        temps_exec = endTime-startTime;
    }
}