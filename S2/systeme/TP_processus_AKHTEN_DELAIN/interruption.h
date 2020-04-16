#include "processus.h"


typedef struct interruption{
  int type; //0 bloquante;1 terminaison
  int id_processus; //Processus concerné par l'Interruption
  //int id_cible;
  int is_active;
}Interruption;

typedef struct interruptions{
  Interruption *interrupt;
  struct interruptions *suiv;
}Maillon_interruption;

typedef struct {
	Maillon_interruption *tete, *queue;
}File_interruption;


int gerer_interruption(Interruption *i,Processus*p,Processus ** list_processus);//File_interruption file_inter,
Interruption* rechercher_interruption(File_interruption file_inter,Interruption *i);
int ajouter_interruption(File_interruption * file_inter,Interruption *i);
int supprimer_premiere_interruption(File_interruption *file_inter);
int type_interruption(Processus *p,Mot *mot);
void afficher_interruption(File_interruption *file_inter);