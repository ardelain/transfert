#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>
#include <math.h>
#include <time.h>

#include "machine.h"

void cycle(Processus *p,Machine *m,Processus **procs,ProcList *ready_list,ProcList *waiting_list,Interruption **interruption_list){
	srand(time(NULL));
	//p processus courant
	Mot *instruc;
	int i;
	Interruption *interruption,*inter;
	InterruptList *temp;


	if(interruption_list == NULL){
		interruption_list = (Interruption**)malloc(sizeof(Interruption));
	  if(interruption_list ==  NULL){
	    perror("pb malloc");
	    exit(1);
	  }
	}
	// si temps CPU terminé du processus courant on l'exécute puis ordonnanceur
	//if(p->time==0 && nb_processus>=1){
		//existe au moins deux processus ou un autre non éxecuté?
		//Ajouter time aux processus et le décrémenter ?
		//add_proc_list(ready_list,p);
		//Exécution de l'ordonnanceur
	//}

	//On génère une interruption aléatoirement
	i = (int) rand()%2;//0 pile 1 face
	if(i==0){
		/*if(interruption_list == NULL){
			interruption_list = (InterruptList*)malloc(sizeof(InterruptList));
			if(interruption_list ==  NULL){
				perror("pb malloc");
				exit(1);
			}
		}*/
		inter = (Interruption*)malloc(sizeof(Interruption));
		inter->type=1;
		inter->num_proc=p->num_tab;
		add_interrupt_list(interruption_list,inter);
		print_interruption_list(interruption_list);
	}
	//On traite une interruption
	//if(nb_interruption_list(interruption_list) != 0){
	if(interruption_list[0] != NULL){
		gestion_interrupt(p,interruption_list[0],ready_list,waiting_list,procs);
		//supp de interrupt list
		del_tete_list(interruption_list);
    //print_interruption_list(interruption_list);

		printf("Suppression tete liste\n");
		print_interruption_list(interruption_list);
		//cout tps cpu?
	}
	//Execution de l'instruction
	instruc = recup_instruction_courante(p);
	if(instruc == NULL){
		//print_interruption_list(interruption_list);
		return;
	}
	if(instruc->valide){
		printf("Instruction %d n_%d autorisée.\n",p->num_tab,p->pt_pile);
		if(instruc->bloquante){
			printf("Interruption bloquante\n");
			//enregistre l'interruption
			interruption = (Interruption*)malloc(sizeof(Interruption));
			if(interruption == NULL){
				perror("malloc");
				exit(1);
			}
			interruption->type = interrupt_instruction_type(p,instruc);
			interruption->num_proc = p->num_tab;
			add_interrupt_list(interruption_list,interruption);
			//On bloque le processus
			add_proc_list(waiting_list,procs[p->num_tab]);
			p->en_attente = interruption->type;
			//print_interruption_list(interruption_list);
			printf("Instruction bloquante ajoutée\n");
		}
		printf("On avance pt_pile à l'instruction suivante");
		p->pt_pile = instruction_num(p,instruc)+1;
	}else{
		printf("Instruction non autorisée.\n");
		end_processus(procs[p->num_tab],NULL,procs);
		printf("Fin du processus %d\n",p->num_tab);
	}
}
