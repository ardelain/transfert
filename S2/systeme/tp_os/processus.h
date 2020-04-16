#include<stdio.h>
#include<stdlib.h>
#include <unistd.h>

#define max_nb_proc_fils         10
#define max_nb_instructions      6
#define max_processus            10
#define max_tmp_cpu              5

/*


typedef enum{
    RESSOURCE,RETURN,END_OPERATION
} TypeInteruption;



*/

//  le processus dans la creation il a quel etat ???


enum type_interruption {

	FIN_PROCESSUS,          	//0
	FIN_APPEL_BLOQUNT,      	//1
	ATTENTE_FIN_PROCESSUS_FILS, //2
	ATTENTE_UNE_RESSOURCE,		//3


};

//Si c’est l’attente de la fin d’un processus fils, on réveille le processus

struct interruption{

	//ressource terminée
	int type_interruption ;    	//enum type_interruption type_interruption;    
	int id_origine;
	int id_cible; // faire un traitement avec la cible en le reveillant par exemple
	
	struct interruption *next;

};

struct instruction{

	int id_processus_cible;           // on aura besoin de ça si c'est bloquant_processus	
	int bloquant_processus;        // si c'est instruction bloquante qui attend la fin d'un processus
	int bloquant_ressource;			// attente d'une ressource
	
	int valide;        // 0 n'est pas valide 1 valide
	int bloquante; 		// 0 n'est pas bloquante   1 bloquante
};


struct processus{
	
	struct instruction *programme;
	int num_processus;
	int num_processus_pere;
	int tab_numero_fils[ max_nb_proc_fils ];
	int pt_pile;         // la première instruction à exécuter ????
	int etat;            // 0 en execution....1 en attente.... 2 pret à s'executer ......  3 zombie	
	
	
	// c'est moi qui l'ai ajouté
	int nb_fils;
	int nb_instruction;
	
	struct processus *next;
	// enregistrer le contexe 
	int registre;
};


struct liste_processus{

	struct processus *premier;
};

struct file_interruption{

	struct interruption *premier;
};


struct machine{

	int compteur_ordinale;
	int registre;
	struct instruction *programme;
	
};

int tab_processus[max_processus] ;



struct liste_processus *liste_processus;			 // type liste = 1
struct file_interruption *file_interruption;

/******************************************************************************/

int initialisation();
int creation_processus( int num_pere );
void affiche_liste_processus( struct liste_processus *listeProc_pret_execution, int type_liste );
int affecte_fils( int num_pere, int num_fils);
int ajoute_en_fin( struct liste_processus *listeProc , struct processus *proc_a_ajouter );
int supprimer_proc( struct liste_processus *listeProc , int num_processus );
int supprimer_proc_adopte_fils( struct liste_processus *listeProc , int num_processus );
int genere_interruption();
void affiche_file_interruption( );
int gestion_interruption( int num_processus_courant );
void supprime_premiere_interruption();
int genere_interruption_2( int id_origine, int id_cible, int type_interruption );
int affiche_programme( int num_processus );
int gestion_instruction( struct liste_processus *listeProc, struct processus *processus_en_cours );
int gestion_instruction_2( struct liste_processus *listeProc, int num_processus );





void ordonnancement_2(int nb_tours );
int ordonnancement();
struct processus *premier_proc_pret_executer();
int rendre_pret_a_executer( int num_processus);
int mettre_a_jour_registre( int num_processus , int etat_registre);


