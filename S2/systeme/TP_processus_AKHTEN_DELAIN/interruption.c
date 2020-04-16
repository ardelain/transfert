#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include <time.h>
#include <errno.h>
#include <math.h>

#include "interruption.h"

 //il faut faire une recherche dans les processus pour obtenir la lisye des processus pret et ceux en attente
int gerer_interruption(Interruption *i,Processus*p,Processus ** list_processus){//File_interruption file_inter,
	printf("gerer_interruption\n");
	//verifier si arguement NULL

	//si l'interruption et le processus correspondent
	if(p->id_table ==  i->id_processus){
		if(i->type == 0){
			p->etat = 0;// actif : lajout se fait implicitement
			p->non_bloquant = 1; //
			return;
		}else{
			if(i->type == 1){
				//...
			}
		}
		fin_processus(p,list_processus);
		return;
	}
	else{
		int j;int ind=-1;
		for(j=0;j<max_processus;j++){
	    	if(list_processus[j]->id_table != i->id_processus){
	      		ind = j;
	      		break;
	    	}
	  	}
	  	if(ind != -1 && i->type == 1 && p->nb_fils == 0){
			p->etat = 0;//actif
			list_processus[ind]->etat = 0;//fils plus en attente
			return;
	  	}else{
	  		if(i->type == 0){
	  			list_processus[i->id_processus]->etat = 0;
				p->non_bloquant = 1;
				return;
	  		}
	  	}
	}

}


Interruption* rechercher_interruption(File_interruption file_inter,Interruption *i){
	printf("rechercher_interruption\n");
	Maillon_interruption* tmp = file_inter.tete;
	while(tmp != NULL){
		if(tmp->interrupt == i){
			printf("=====\n");
	      		return tmp->interrupt;
	    	}
		tmp = tmp->suiv;
	}
	return NULL;
}

//push
int ajouter_interruption(File_interruption * file_inter,Interruption *i){
	printf("ajouter_interruption\n");
	if(rechercher_interruption(*file_inter,i) == NULL ){//si l'interruption n'est pas deja presente
	  	Maillon_interruption* tmp = (Maillon_interruption *)malloc(sizeof(Maillon_interruption));
		if(tmp==NULL) return 0;
		if(file_inter->tete != NULL){
			file_inter->queue->suiv=tmp;
			file_inter->queue=tmp;
		}else{
			file_inter->tete=tmp;
			file_inter->queue=tmp;
		}
		tmp->interrupt=i;
		tmp->suiv=NULL;
		return 1;
	}else{
		printf("ajouter_interruption deja existante\n");
		return 0;
	}
}

//pop
int supprimer_premiere_interruption(File_interruption *file_inter){
	printf("supprimer_premiere_interruption\n");
 	Maillon_interruption *tmp;
	if(file_inter->tete == NULL) return 0;
		tmp = file_inter->tete;
		//*interrup=tmp->interrupt;
		file_inter->tete=tmp->suiv;
		free(tmp);
	if(file_inter->tete == NULL) {
		file_inter->queue = NULL;
	}
	return 1;
}

//retourne le type d'interruption correspondante
int type_interruption(Processus *p,Mot *mot){
	printf("type_interruption\n");
  	int i;
  	for(i=0;i<nb_instruction_max-1;i++){
    	if(p->programme.tab_mot[i+1]==NULL){//ssi c'est le dernier
      		if(mot == p->programme.tab_mot[i]){ 
        		printf("Interruption 1 terminaison\n");
        		return 1;
      		}
    	}
  	}
 	printf("Interruption 0\n");
  	return 0;
}

void afficher_interruption(File_interruption *file_inter){
	printf("afficher_interruption\n");
	Maillon_interruption* tmp = file_inter->tete;
	int i = 0;
	while(tmp != NULL){
		printf("%d : \tType %d proc %d\n",i,tmp->interrupt->type,tmp->interrupt->id_processus);
		tmp = tmp->suiv;
		i++;
	}
	printf("fin afficher_interruption\n");
	return;
}