#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include <time.h>
#include <errno.h>
#include <math.h>

#include "processus.h"

Processus* creation_processus(Processus **listes_processus, int id_pere){
	printf("creation_processus\n");
	int i;

	Processus *nv_proc;
 	for(i=0;i<max_processus;i++){

    if(listes_processus[i] == NULL){
  		nv_proc = (Processus*)malloc(sizeof(Processus));
  		if(nv_proc == NULL){perror("creation_processus malloc processus");exit(1);}
  		nv_proc->id_table = i;
  		nv_proc->etat = 0;

  		nv_proc->date_creation = date_processus_actif;

  		nv_proc->nb_fils = 0;
  		nv_proc->temps = 5; //temps CPU par default
  		int j;
  		int bool_pere = 1;//si le pere est present dans la liste des processus

    		for(j=0;j<max_processus;j++){
    			if(listes_processus[j] !=  NULL){
  	  			if(listes_processus[j]->id_table == id_pere){
  	  				bool_pere = 0;
  	  			}
    			}
    		}
    		if(bool_pere == 0 || nb_processus_actif == 0){//si le pere existe ou c'est le processus racine
    			nv_proc->id_pere = id_pere;
    		}else{
    			printf("pere non existant\n");
    			return NULL;
    		}
    		//initialisation fils
      	nv_proc->list_id_fils = (int*)malloc(max_processus_fils*sizeof(int));
    		for(j=0;j<max_processus_fils;j++){
      		nv_proc->list_id_fils[j] = -1;
    		}
        	//nv_proc->waiting_for=init_nums_fils_tab(nv_proc->waiting_for);
        	listes_processus[i] = nv_proc;
        	if(i != 0)//sauf pour le premier
          	ajouter_fils(listes_processus[id_pere],nv_proc->id_table);
        	nb_processus_actif++;
        	date_processus_actif++;
        	return listes_processus[i];
      }
  }
}



int ajouter_fils(Processus *p,int fils){
	printf("ajouter_fils\n");
	int i=0;
  	for(i=0;i<max_processus_fils;i++){
    	if(p->list_id_fils[i] == -1){
      	p->list_id_fils[i]= fils;
      	p->nb_fils++;
      	return 1;
    	}
  	}
  	return 0;

}

int supprimer_fils(Processus *p,int fils){
	printf("supprimer_fils\n");
    int i=0;
  	for(i=0;i<max_processus_fils;i++){
    	if(p->list_id_fils[i] == fils){
      		p->list_id_fils[i]= -1;
      		p->nb_fils--;
      		return 1;
    	}
  	}
  	return 0;
}

int recherche_index_fils(Processus *p,int fils){
	int i=0;
  	for(i=0;i<max_processus_fils;i++){
    	if(p->list_id_fils[i] == fils){
      		return i;
    	}
  	}
  	return -1;
}


void sauv_contexte_processus(Processus *p,int contexte){
	p->pt_pile = contexte;
	p->non_bloquant = 0;
}

void afficher_processus(Processus *p){
        int j;
        printf("id %d\n",p->id_table);
        printf("id pere %d\n",p->id_pere);
        printf("etat %d\n",p->etat);

        printf("le programme :\n");
        if(p->programme.tab_mot != NULL){
        for(j=0;j<nb_instruction_max;j++){
            if(p->programme.tab_mot[j] != NULL){
              printf("\tMot: v->%d b->%d;\n",p->programme.tab_mot[j]->valide,p->programme.tab_mot[j]->bloquante);
            }
          }
        }
        printf("La liste des fils:");
        for(j=0;j<max_processus_fils;j++){
          if(p->list_id_fils[j] != -1)
            printf("\t%d ",p->list_id_fils[j]);
        }
        printf("\n\n");
}

void afficher_List_processus(Processus **ps){
  	int i,j;
  	printf("Les processus :\n");
  	for(i=0;i<max_processus;i++){
    	if(ps[i] != NULL){
      	afficher_processus(ps[i]);
    	}
  	}
}

int ajouter_instruction(Processus *p,Mot *mot){
	printf("ajouter_instruction\n");
	int i;
	if(p->programme.tab_mot == NULL)
		p->programme.tab_mot = (Mot**)malloc(nb_instruction_max*sizeof(Mot));
	if(p->programme.tab_mot == NULL){
		perror("ajouter_instruction pb malloc");
		exit(-1);
	}
  	for(i=0;i<nb_instruction_max;i++){
    	if(p->programme.tab_mot[i] == NULL){
      		p->programme.tab_mot[i] = mot;
      		return 1;
    	}
  	}
  	printf("2\n");
  	return 0;
}

Mot* instruction_courante(Processus* p){
  printf("instruction_courante\n");
  if(p->programme.tab_mot!=NULL){
  	return p->programme.tab_mot[p->pt_pile];
  }else{
  	return NULL;
  }
   
}



int fin_processus(Processus *p,Processus **listes_processus){
	printf("fin_processus\n");
	int i;
	for(i=0;i<max_processus_fils;i++){
    	if(p->list_id_fils[i] != -1){
      		listes_processus[p->list_id_fils[i]]->id_pere = 0;
    	  	ajouter_fils(listes_processus[0],p->list_id_fils[i]);//ajout orphelin
    	}
  	}
  	supprimer_fils(listes_processus[p->id_pere],p->id_table);
  	listes_processus[p->id_table] = NULL;
  	free(p);
  	nb_processus_actif--;
}

/*******************************************************/
/************************FILE PROCESSUS*******************************///enlever