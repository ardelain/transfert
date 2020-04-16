import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Parallelisation / Lancement de thread de calcul (pour distance edition)
 */
public class Thread_Exec {
    public  void traitement(int nb){
        try{
            List<Integer> listElement = new ArrayList<>();//nombre d'element pour la comparaison graphique
            int nb_test =nb;
            List<String>lm = new ArrayList<>();//premiere liste de mot
            List<String>lm2 = new ArrayList<>();//deuxieme liste de mot

            for (int i =0; i <nb_test;i++) {
                String m,m2;
                Random r = new Random();
                int ra = r.nextInt(12 - 2 + 1) + 2;//taille des mot de 2 a 12
                m = Mot.generateString(ra);//creation mot aléatoire;
                m2 = Mot.generateString(ra);//creation mot 2 aléatoire;
                listElement.add(ra);//nombre de lettre dans un mot
                lm.add(m);
                lm2.add(m2);
            }
            ProcessP p = new ProcessP(new DistanceEditionRecursif(),lm,lm2);
            ProcessP p2 = new ProcessP(new DistanceEditionIteratif(),lm,lm2);
            p.start();
            p2.start();
            p.thisThread.join();
            p2.thisThread.join();
            Affichage_Graphique ag = new Affichage_Graphique(listElement,p.listSerie,p2.listSerie,"Distance Edition","Nombre de mot", "Temps (ms)","recursif","iteratif");

        }catch(Exception e){
            System.err.println("\nERREUR ");
        }
    }
}

/**
 * Processus s'ocupant de lancer un nombre de calcul d'un certain type (IDistanceEdition) sur deux listes de mot (comparaison des mot de meme indice) et de récupérer leur temps d'executions dans listSerie
 */
class ProcessP implements Runnable{
    Thread thisThread;
    List<Long> listSerie = new ArrayList<>();//resultat lpI
    List<ProcessF> lpI = new ArrayList<>(); //liste processus
    IDistanceEdition id;

    List<String> lm;//liste de mot
    List<String> lm2;//liste de mot a comparer a ceux de la premiere

    public ProcessP(IDistanceEdition id, List<String> lm, List<String> lm2) {
        this.id = id;
        this.lm = lm;
        this.lm2 = lm2;
    }

    public void start() {
        if (thisThread != null) {
            return;
        }
        thisThread = new Thread(this);
        thisThread.start();
    }

    public void run() {
        ProcessF pI ;
        for(int i = 0; i < lm.size();i++){
            pI = new ProcessF(lm.get(i),lm2.get(i),id);
            lpI.add(pI);
            pI.start();
        }
        try {
            for(ProcessF pi : lpI){
                pi.thisThread.join();
                listSerie.add(pi.temps_exec);
                //System.out.println("Thread PERE "+pi.num+" fini" + " valeur: ");
            }
        } catch (Exception e) {
            System.out.println("Fin Force attente pere !");
            return;
        }
    }
}

/**
 * Thread permettant de lancer un exec() d'un IDistanceEdition quelconque et d'enregistrer son temps d'execution (temps_exec)
 */
class ProcessF implements Runnable{

    int num;

    Thread thisThread;
    String m;//mot
    String m2;//mot
    long temps_exec;
    IDistanceEdition ig;


    public ProcessF(String m,String m2,IDistanceEdition ig) {
        this.m = m;
        this.m2 = m2;
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
        int v = ig.exec(m,m2);
        long endTime = System.currentTimeMillis();
        System.out.println(ig.toString()+" ->  mot 1: "+ m +" , mot 2: "+ m2 +" , distance :"+v+ " , temps "+(endTime-startTime));
        temps_exec = endTime-startTime;
    }
}