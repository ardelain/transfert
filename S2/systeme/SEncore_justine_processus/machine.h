#include "interrupt.h" //includes processus.h

typedef struct machine{
	Mot *pt_pile;
	Processus *p;
	int debloque;// (cf processus)
}Machine;

void cycle(Processus *p,Machine *m,Processus **procs,ProcList *ready_list,ProcList *waiting_list,Interruption **interruption_list);
