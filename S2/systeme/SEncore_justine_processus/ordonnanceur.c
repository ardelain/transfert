#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>
#include <math.h>
/*Donne un nb de cycle a un processus (nb d'instructions à executer) pour éviter un monopole
Puis lorsque qu'un processus est terminé (temps ou execution finie) choisi le prochain processus a executer
selon FIFO,nb d'instructions restantes,...
*/
#include "ordonnanceur.h"


void ordonnancement(ProcList *ready_list,Processus *p_actuel,Processus **procs){//Determine le prochain processus à éxécuté
  
  
  //Choisir un processus
  
  //FIFO on choisit le premier
  p_actuel=ready_list->p;
  
  //Choisir celui avec le moins d'insctruction à réaliser
	int ind_min=ready_list->p->num_tab;
  int min_act=100000000;
  int i=0;
  int tempo =0;
 
  ProcList *l,*temp;
  l = ready_list;
  while(l != NULL){
  	tempo=count_instruction_left(ready_list->p);
  	if(tempo<=min_act){
  		min_act=tempo;
  		ind_min=i;
  	}
    l = l->next;
  }  
  
  p_actuel=procs[ind_min];
  
  return;
}

void setCycle_proc(Processus *p,int a, int b){//anciennement ordonnancement(int a, int b)
	p->time=rand()%(b-a)+a;
}
