
#define max_processus 100
#define max_processus_fils 20
#define nb_instruction_max 10
#define max_tmps 10

int nb_processus_actif;//nombre total processus non supprimé
int date_processus_actif;//nombre total de processus créé

typedef struct mot{
	int valide;//0 non 1 oui
	int bloquante;
}Mot;


typedef struct programme{
	Mot **tab_mot;
}Programme;

typedef struct processus{
	Programme programme;
	int id_table;
	int date_creation;
	int id_pere;

	int *list_id_fils;
	int nb_fils;

	int pt_pile;//revoir

	int etat;// 0 actif 1 en attente //-1 fini?
	int en_attente;//enlever ? inutile
	int non_bloquant;//0 non  1 oui

	int temps;
}Processus;
//processus->programme.tab_mot[p->pt_pile] //== instruction courante (Mot*)

typedef struct list_chaine{//a ENLEVER -> gestion des ordre des processus par ordonnancement
	Processus *processus;
	struct list_chaine *suiv;
}Chaine_Processus;

typedef struct maillon{//a ENLEVER 
	Processus *processus;
	struct maillon *suiv;
}Maillon;

typedef struct {//a ENLEVER 
	Maillon *tete, *queue;
}File_Processus;

Processus* creation_processus(Processus **listes_processus, int id_pere);
int ajouter_fils(Processus *p,int fils);
int supprimer_fils(Processus *p,int fils);
void sauv_contexte_processus(Processus *p,int contexte);
int fin_processus(Processus *p,Processus **listes_processus);
void afficher_processus(Processus *p);
void afficher_List_processus(Processus **ps);
int ajouter_instruction(Processus *p,Mot *mot);
Mot* instruction_courante(Processus* p);