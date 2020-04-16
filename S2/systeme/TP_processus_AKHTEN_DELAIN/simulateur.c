#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include <time.h>
#include <errno.h>
#include <math.h>

#include "simulateur.h"


// AKHTEN Fatima-Ezzohra & DELAIN Arthur
int main(){
	//Processus :
	Processus **les_processus;
	Processus *p_actuel;

	date_processus_actif =0;
	nb_processus_actif=0;

	les_processus = (Processus**)malloc(max_processus*sizeof(Processus*));
	p_actuel = (Processus*)malloc(sizeof(Processus));

	test_processus(les_processus);
	afficher_List_processus(les_processus);
	//interruption
  	File_interruption *list_interruption = (File_interruption*)malloc(sizeof(File_interruption));
	//afficher_interruption(list_interruption);

  	//pas utilisé
	Machine *machine; // a genérer directement avec des processus et interruptions quelconques pour lancer que des machines dans le main -> avec tant que prcessus.interruption -> faire cycle_horloge
	machine = (Machine*)malloc(sizeof(Machine*));
	if(machine==NULL){perror("Pb malloc");exit(1);}

	//test cycle + ordonnancement
	
	//exemple
	cycle_horloge(les_processus[0],machine,les_processus,list_interruption);
	cycle_horloge(les_processus[1],machine,les_processus,list_interruption);
	cycle_horloge(les_processus[2],machine,les_processus,list_interruption);
	cycle_horloge(les_processus[2],machine,les_processus,list_interruption);

	cycle_horloge(les_processus[1],machine,les_processus,list_interruption);
	cycle_horloge(les_processus[3],machine,les_processus,list_interruption);
	cycle_horloge(les_processus[3],machine,les_processus,list_interruption);
	cycle_horloge(les_processus[3],machine,les_processus,list_interruption);//le 3 est supprimer // si pile ou face coerant
	cycle_horloge(les_processus[4],machine,les_processus,list_interruption);
	cycle_horloge(les_processus[4],machine,les_processus,list_interruption);
	cycle_horloge(les_processus[1],machine,les_processus,list_interruption);

	cycle_horloge(les_processus[0],machine,les_processus,list_interruption);

	printf("\n======================resultat========================\n");
	afficher_interruption(list_interruption);
	
	ordonnanceur1(p_actuel,les_processus);
	cycle_horloge(p_actuel,machine,les_processus,list_interruption);

	printf("\n======================resultat========================\n");
	afficher_interruption(list_interruption);
	afficher_List_processus(les_processus);

	ordonnanceur2(p_actuel,les_processus);
	cycle_horloge(p_actuel,machine,les_processus,list_interruption);
	printf("\n======================resultat========================\n");
	afficher_interruption(list_interruption);

}


	
	//automatiser pour machine
	/*int testmax = 10;
	while(les_processus[0] != NULL || testmax >= 0){
		ordonnanceur1(p_actuel,les_processus)
		cycle_horloge(p_actuel,machine,les_processus,list_interruption);
		
		testmax--;
	}*/


//genere divers processus avec des programmes(&liste mot)
void test_processus(Processus **ps){
	printf("test_processus");
	Processus *nv;
	Mot * nv_mot =(Mot*)malloc(sizeof(Mot));
	nv = creation_processus(ps,0); // l'element ancetre commun / racine (=>il est sont propre pere)
  	
	// testes creation processus quelconque:
	nv = creation_processus(ps,0);// 2eme processus : id = 1
  	nv_mot =(Mot*)malloc(sizeof(Mot));
  	nv_mot->valide = 1;nv_mot->bloquante = 0;
  	ajouter_instruction(nv,nv_mot);
	nv_mot =(Mot*)malloc(sizeof(Mot));
  	nv_mot->valide = 1;nv_mot->bloquante = 1;
  	ajouter_instruction(nv,nv_mot);

	nv = creation_processus(ps,0);
  	nv_mot =(Mot*)malloc(sizeof(Mot));
  	nv_mot->valide = 1;nv_mot->bloquante = 0;
  	ajouter_instruction(nv,nv_mot);

  	nv = creation_processus(ps,1);
  	nv_mot =(Mot*)malloc(sizeof(Mot));
  	nv_mot->valide = 1;nv_mot->bloquante = 0;
  	ajouter_instruction(nv,nv_mot);
  	nv_mot =(Mot*)malloc(sizeof(Mot));
  	nv_mot->valide = 1;nv_mot->bloquante = 1;
  	ajouter_instruction(nv,nv_mot);

  	nv = creation_processus(ps,0);
  	nv_mot =(Mot*)malloc(sizeof(Mot));
  	nv_mot->valide = 1;nv_mot->bloquante = 0;
  	ajouter_instruction(nv,nv_mot);
  	nv_mot =(Mot*)malloc(sizeof(Mot));
  	nv_mot->valide = 1;nv_mot->bloquante = 1;
  	ajouter_instruction(nv,nv_mot);
  	nv_mot =(Mot*)malloc(sizeof(Mot));
  	nv_mot->valide = 1;nv_mot->bloquante = 0;
  	ajouter_instruction(nv,nv_mot);
}

void cycle_horloge(Processus *p,Machine *m,Processus **les_processus,File_interruption *file_interruption){
	printf("\n**************************************************************\n");
	printf("\n\tcycle_horloge\n");
	srand(time(NULL));//
	int piece = (int) rand()%2;//pile ou face

	Mot *mot_c;//mot courant /instruction
	Interruption *interruption;
	Interruption *i ;
	if(nb_processus_actif == 0){
		printf("Plus aucun processus actif\n");
		return;
	}
	if(p->temps == 0 ){
		p->etat = 0;
		//ordonnanceur1(p,les_processus);//
	}else{
		p->temps--; // temps cpu decrementé // chaque cycle
	}
	//ajout interruption pie ou face 
	if(piece == 0){//pile
		//printf("PILE\n");
		interruption = (Interruption*)malloc(sizeof(Interruption));
		interruption->id_processus = p->id_table;
		interruption->type=0;//blocante

		ajouter_interruption(file_interruption,interruption);
	}

	//on traite l' interruption de sortie de la file
	if(file_interruption->tete != NULL){
		gerer_interruption(file_interruption->tete->interrupt,p,les_processus);
		supprimer_premiere_interruption(file_interruption);
	}

	//on execute la suite du programme (instruction)
	if(p->programme.tab_mot !=NULL){ // -revoir ?
   		mot_c = p->programme.tab_mot[p->pt_pile]; //== instruction courante (Mot*)
		if(mot_c == NULL){
			printf("mot courant est nul\n");return;
		}
  	}else{
  		printf("Il n'y a plus de mots/instructions\n");
  		return;
  	}


	if(mot_c->valide == 1){// si le mot/instruction est valide
		printf("instruction autorisé\n");
		if(mot_c->bloquante == 1){
			printf("instruction autorisé bloquante\n");
			i = (Interruption*)malloc(sizeof(Interruption));// ancien PROBELME MALLOC ?????????????????? pq ?  i == NULL A LA PLACE DE i = NULL/detection laborieuse
			if(i == NULL){
				perror("cycle_horloge Interruption en cours malloc");
			}
			i->type = type_interruption(p,mot_c);
			i->id_processus = p->id_table;
			p->etat = 1;//processus en attente/ on le freez
			ajouter_interruption(file_interruption, i);
			printf("Mot bloquant, nouvelle interruption ajouter \n");
		}

	  	int j = 0;
	  	int ind = -1;
	  	for(j=0;j<nb_instruction_max;j++){
	    	if(mot_c == p->programme.tab_mot[j]){
	    	  ind =  j;
	    	}
  		}
  		if(ind != -1 ){
  			printf("mot/instruction suivant \n");
  			p->pt_pile = ind + 1; //pt_pile -> mot/instruction suivant
  		}else{
  			printf("probleme mot id \n");
  			return;
  		}
		
	}else{
			fin_processus(p,les_processus);//sinon on fini le processus
			printf("FIN PROCESSUS %d de pere %d\n",p->id_table,p->id_pere);
	}

	//afficher_interruption(file_interruption);
}

//moin cpu
void ordonnanceur1(Processus *p,Processus **les_processus){
	printf("\n------------------------------------------------\n");
	printf("ordonnanceur1\n");
	//on cherche le permier processus pret
	int i;
	p = les_processus[0];//racine
	int nb_instruction_min = 10000;

	//on choisi le plus petit (nombre de mot dans prgramme)
	for(i=0;i<max_processus;i++){//on regarde tous les processus pret sauf la racine
		if(les_processus[i] != NULL){
			//les_processus[i]->etat = 0;
			if( les_processus[i]->etat == 0){// si le processus fait partie de ceux actif/pret
				int j = les_processus[i]->pt_pile;
			    int t = 0;// temps/ nombre mot
			    if( les_processus[i]->programme.tab_mot != NULL){
					while(les_processus[i]->programme.tab_mot[j]!=NULL){//on compte le nombre de mot restant
						t++;
						j++;
					}
				}
				if(t<=nb_instruction_min){
				  	nb_instruction_min=t;
				  	p = les_processus[i];
				}
			}
		}
	}
	/*if(p == les_processus[0]){
		printf("ordonnanceur1 p == les_processus[0] fin");
		return;
	}*/
	p->temps = rand()%(10-1)+1; //donner à p un temps CPU// ENTRE 10 ET 1 PAR 
	printf("ordonnanceur1 choix :\n");
	afficher_processus(p);
	printf("\n------------------------------------------------\n");
}

//fifo
void ordonnanceur2(Processus *p,Processus **les_processus){
	printf("\n------------------------------------------------\n");
	printf("ordonnanceur2");
	//on simule une fifo avec l'ordre de la date des processus dans la liste des processus (plus petite date = element mis avant dans la liste)
	int i;
	p = les_processus[0];//racine
	int date_min = 100000;
	int index =0;
	for(i=0;i<max_processus;i++){//on regarde tous les processus pret sauf la racine
		if(les_processus[i] != NULL){
			if(les_processus[i]->etat == 0){
				if(les_processus[i]->date_creation < date_min){
					p = les_processus[i];
					date_min = les_processus[i]->date_creation;
				}
			}
		}
	}
	/*if(p == les_processus[0]){
		printf("ordonnanceur2 p == les_processus[0] fin");
		return;
	}*/
	p->temps = rand()%(10-1)+1; 
	printf("ordonnanceur2 choix :\n");
	afficher_processus(p);
	printf("\n------------------------------------------------\n");
}


