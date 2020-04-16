package com.company;

import java.util.*;

public class Graphe {

    private List<Node> list_node = new ArrayList<>();//liste des sommets
    private List<Arc> arcs_pondere = new ArrayList<>();//liste des Arc (deux sommets et une valeur) (ici pris contre les arcs directement dans les Node/sommets pour faciliter les recherches)

    //pour graphe non orienté (ajout d'arc dans les deux sens)
    public void ajouter_Arc(Node n,Node n2,int valeur){
        arcs_pondere.add(new Arc(n,n2,valeur));
        arcs_pondere.add(new Arc(n2,n,valeur));
    }

    /**
     * creation graphe aleatoire
     * @param probaArc probabilité de créer un Arc
     * @param max_sommet maximum de sommet
     * @param min_sommet minimum de sommet
     * (le nombre de sommet est aussi tiré aléatoirement)
     */
    public void creationGrapheAleatoire(double probaArc,int max_sommet,int min_sommet){
        List<Node> l = new ArrayList<>();
        int max = max_sommet,min = min_sommet;
        Random r = new Random();
        int ra = r.nextInt(max - min + 1) + min;
        for (int i=0;i<ra; i++){
            l.add(new Node(i));

        }
        int i = 0;
        for (Node n: l) {
            for (Node n2: l) {
                if(n != n2){// enlever ?
                    double rr = Math.random() * ( 1 - 0 );
                    if(Math.random() * ( 1 - 0 ) < probaArc){ //
                        int t = r.nextInt(100 - 1 + 1) + 1;
                        //arcs_pondere.add(new Arc(n,n2,t));
                        ajouter_Arc(n,n2,t);
                    }
                }
            }
        }
        list_node = l;
    }

    /**
     * Afficher un graphe
     * @param
     */
    public void afficherGrahe(){
        System.out.println("Graphe Orienté: arretes\\Sommet");
        System.out.print("  ");
        for (Node n: list_node) {
            System.out.print(n.getNom()+" ");
        }
        System.out.print("\n");
        for (Node n: list_node) {
            System.out.print(n.getNom());
            boolean b[] = new boolean[list_node.size()];//= false;
            /*for (Node n2: n.getList_arcs().keySet()) {
                b[n2.getNom()]= true;

            }*/
            for (Arc a: arcs_pondere) {
                if(a.getA().getNom() == n.getNom()){
                    a.getB();
                    b[a.getB().getNom()]= true;
                }
            }
            for (int j=0;j<list_node.size(); j++) {
                if (b[j]) {
                    System.out.print(" " + "1");
                } else {
                    System.out.print(" " + "0");
                }
            }
            System.out.print("\n");
        }
    }

    public List<Node> getList_node() {
        return list_node;
    }

    public void setList_node(List<Node> list_node) {
        this.list_node = list_node;
    }

    public List<Arc> getArcs_pondere() {
        return arcs_pondere;
    }

    public void setArcs_pondere(List<Arc> arcs_pondere) {
        this.arcs_pondere = arcs_pondere;
    }
}
