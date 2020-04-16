
//Fatima-Ezzohra AKHTEN et Arthur DELAIN. (intel ij) L3 UCA Groupe A 04/2019
public class Main {

    //distance d'édition / Distance de Levenshtein :
    public static void main(String[] args) {
        System.out.println("Distance Edition entre Deux Mot");
        //DistanceEditionRecursif de = new DistanceEditionRecursif();
        //DistanceEditionIteratif de = new DistanceEditionIteratif();
        //int u = de.exec("daaaa","baaaae");
        //System.out.println("recursif: "+ u);
        /*for(int i = 2;i< 10;i++){
            String mot1=Mot.generateString(i);
            String mot2=Mot.generateString(i);
            System.out.println("mot 1: "+ mot1 +" , mot 2: "+ mot2);
            System.out.println("recursif: "+ dei.exec(mot1,mot2));
        }*/
        Thread_Exec e = new Thread_Exec();
        e.traitement(500);
    }
}
