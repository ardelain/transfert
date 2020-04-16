#include "processus.h"

typedef struct interrupt{
  int type; //1 bloquante;2 terminaison
  int num_proc; //Processus concerné par l'Interruption
}Interruption;

typedef struct interrupt_list{
  Interruption *i;
  struct interrupt_list *next;
}InterruptList;

void gestion_interrupt(Processus *p,Interruption *i,ProcList *ready_list,ProcList *waiting_list,Processus **procs);
void add_interrupt_list(Interruption **list,Interruption *i);
void del_tete_list(Interruption **list);
int interrupt_instruction_type(Processus *p,Mot *m_courant);
//int nb_interruption_list(InterruptList *list);
void print_interruption_list(Interruption **list);
