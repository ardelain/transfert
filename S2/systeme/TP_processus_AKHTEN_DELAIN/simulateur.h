#include "interruption.h"

typedef struct machine{
	Mot *pt_pile;//compteur ordinal
	Processus *p;// prcessus du programme
	int bloque;//AREVOIR
}Machine;

void ordonnanceur1(Processus *p,Processus **les_processus);
void ordonnanceur2(Processus *p,Processus **les_processus);
void test_processus(Processus **p);
void cycle_horloge(Processus *p,Machine *m,Processus **les_processus,File_interruption *file_interruption);
