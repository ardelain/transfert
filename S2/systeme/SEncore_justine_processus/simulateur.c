#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>
#include <math.h>

#include "machine.h" //includes interrupt+processus

void test_create_proc_instructions(Processus **procs){
  Processus *p;
  Mot *m;
  //Proc 0 sans instructions
  p=create_proc(procs,0);
  //Proc 1 avec 3 instructions, derniere bloquante(terminaison)
  p=create_proc(procs,0);
  m=(Mot*)malloc(sizeof(Mot));
  m->valide = 1;
  m->bloquante = 0;
  add_instruction(p,m);
  m=(Mot*)malloc(sizeof(Mot));
  m->valide = 1;
  m->bloquante = 0;
  add_instruction(p,m);
  m=(Mot*)malloc(sizeof(Mot));
  m->valide = 1;
  m->bloquante = 1;
  add_instruction(p,m);
  //Proc 2 avec 1 instruction terminaison
  p=create_proc(procs,1);
  m=(Mot*)malloc(sizeof(Mot));
  m->valide = 1;
  m->bloquante = 1;
  add_instruction(p,m);
  //proc 3 avec 4 instructions dont 1 bloquante et 1 terminaison
  p=create_proc(procs,1);
  m=(Mot*)malloc(sizeof(Mot));
  m->valide = 1;
  m->bloquante = 0;
  add_instruction(p,m);
  m=(Mot*)malloc(sizeof(Mot));
  m->valide = 1;
  m->bloquante = 1;
  add_instruction(p,m);
  m=(Mot*)malloc(sizeof(Mot));
  m->valide = 1;
  m->bloquante = 0;
  add_instruction(p,m);
  m=(Mot*)malloc(sizeof(Mot));
  m->valide = 1;
  m->bloquante = 1;
  add_instruction(p,m);
}

int main(){
  //TESTS
  int i,j=0;
  Processus **procs,*p,*p_actuel;
  ProcList *waiting_list=NULL,*ready_list=NULL;
  //InterruptList *interruption_list=NULL;
  Interruption **interruption_list;
  Machine *m;
  procs = (Processus**)malloc(MAX_PROC*sizeof(Processus*));
  if(procs==NULL){
    perror("Pb malloc");
    exit(1);
  }
  waiting_list = (ProcList*)malloc(sizeof(ProcList));
  if(waiting_list == NULL){
    perror("Pb malloc");
    exit(1);
  }
  ready_list = (ProcList*)malloc(sizeof(ProcList));
  if(ready_list == NULL){
    perror("Pb malloc");
    exit(1);
  }

  test_create_proc_instructions(procs);
  print_test_procs(procs);

/*  interruption_list = (InterruptList*)malloc(sizeof(InterruptList));
  if(interruption_list ==  NULL){
    perror("pb malloc");
    exit(1);
  }*/
  interruption_list = (Interruption**)malloc(sizeof(Interruption));
  if(interruption_list ==  NULL){
    perror("pb malloc");
    exit(1);
  }

  print_interruption_list(interruption_list);
  cycle(procs[0],m,procs,ready_list,waiting_list,interruption_list);
  printf("simul\n");
  print_interruption_list(interruption_list);
  cycle(procs[1],m,procs,ready_list,waiting_list,interruption_list);
  cycle(procs[1],m,procs,ready_list,waiting_list,interruption_list);
  cycle(procs[1],m,procs,ready_list,waiting_list,interruption_list);
  printf("simul\n");
  //print_interruption_list(interruption_list);
  //cycle(procs[1],m,procs,ready_list,waiting_list,interruption_list);
  //printf("simul\n");
  //print_interruption_list(interruption_list);
  cycle(procs[3],m,procs,ready_list,waiting_list,interruption_list);
  cycle(procs[3],m,procs,ready_list,waiting_list,interruption_list);
  cycle(procs[3],m,procs,ready_list,waiting_list,interruption_list);

  print_interruption_list(interruption_list);
  print_test_procs(procs);
  return 0;
}
