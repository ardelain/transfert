#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>
#include <math.h>

#include "interrupt.h"
#define INTER_MAX 20


//Interruptions : 1 bloquante;2 terminaison
//*p = processus en cours
void gestion_interrupt(Processus *p,Interruption *i,ProcList *ready_list,ProcList *waiting_list,Processus **procs){
  int index_fils;
  if(i == NULL || p == NULL){
    printf("NULLLL");
    return;
  }
  //Si l'interruption concerne le processus en cours
  if(i->num_proc == p->num_tab){
  //On la traite
  if(i->type == 1){
    procs[i->num_proc]->en_attente = 0;
    add_proc_list(ready_list,procs[i->num_proc]);
    procs[i->num_proc]->debloque = 1;
    return;
  }//Sinon le proc se termine
  end_processus(p,waiting_list,procs);
  return;
  //sinon
  }else{
    index_fils = is_in_tab_fils(p->waiting_for,i->num_proc);
    //Si c'est un proc fils qui se termine et qu'il n'attend pas d'autres fils
    if(index_fils != -1 && i->type == 2 && len_tab_int(p->waiting_for) == 1){
      //On réveille le proc
      p->waiting_for[index_fils] = -1;
      p->en_attente = 0;
      //On le met dans la liste des procs pret à s'executer
      add_proc_list(ready_list,p);
      return;
    }
    if(i->type == 1){
      procs[i->num_proc]->en_attente = 0;
      add_proc_list(ready_list,procs[i->num_proc]);
      procs[i->num_proc]->debloque = 1;
      return;
    }
  }
}

void add_interrupt_list(Interruption **list,Interruption *i){
  int j;
  printf("ADD");
  if(is_in_interruption_list(list,*i)){
    printf("Already in list\n");
    return;
  }
  for(j=0;j<INTER_MAX;j++){
    if(list[j] == NULL){
      list[j]=i;
      printf(" %d %d \n",list[j]->type,list[j]->num_proc);
      return;
    }
  }
}
int is_in_interruption_list(Interruption **list,Interruption i){
  int j;
  printf("ADD");
  for(j=0;j<INTER_MAX;j++){
    if(list[j] == NULL)
      return;
    if(list[j]->num_proc == i.num_proc && list[j]->type == i.type)
      return 1;
  }
  return 0;
}
void decalage_gauche(Interruption **list,int num){
  int i;
  for(i=num;i<INTER_MAX;i++){
    list[i]=list[i+1];
    if(list[i]==NULL){
      return;
    }
  }
}
/*
void add_interrupt_list(InterruptList *list,Interruption *i){
  InterruptList *l;
  printf("ADD");
  l = list;
  while(l != NULL){
    if(l->i == NULL){
      l->next = (InterruptList*)malloc(sizeof(InterruptList));
      l->next->i = NULL;
      l->i = i;
      return;
    }
    l = l->next;
  }
}*/

void del_tete_list(Interruption **list){
  printf("DEL\n");
  free(list[0]);
  decalage_gauche(list,0);
}
/*
InterruptList* del_tete_list(InterruptList *list)
{
    if(list != NULL)
    {
      InterruptList *i = list->next;
      if(list->i != NULL)
        free(list->i);
      free(list);
      return i;
    }
    else
    {
        return NULL;
    }
}*/


int interrupt_instruction_type(Processus *p,Mot *m_courant){
  Mot *m;
  int i,last;
  for(i=0;i<MAX_INSTRUCTION-1;i++){
    if(p->p.mots[i+1]==NULL){//if last
      if(m_courant == p->p.mots[i]){ //if instruction est la derniere
        printf("InterruptionTYPE 2\n");
        return 2; //terminaison
      }
    }
  }
  printf("InterruptionTYPE 1\n");
  return 1;//autre
}

/*
int nb_interruption_list(InterruptList *list){
  InterruptList *l;
  int nb=0;
  l = list;
  while(l != NULL){
    if(l->i != NULL)
      nb++;
    l = l->next;
  }
  return nb;
}*/
void print_interruption_list(Interruption **list){
  int i=0;
  printf("PRINT\n");
  if(list == NULL){
    printf("Liste vide\n");
    return;
  }
  for(i=0;i<INTER_MAX;i++){
    if(list[i] == NULL)
      return;
    printf("I %d \tType %d proc %d\n",i,list[i]->type,list[i]->num_proc);
  }
}
/*void print_interruption_list(InterruptList *list){
  InterruptList *l;
  int i=0;
  printf("PRINT");
  if(list == NULL){
    printf("Liste vide\n");
  }
  l = list;
  while(l != NULL){
    if(l->i != NULL){
      printf("I %d \tType %d proc %d\n",i,l->i->type,l->i->num_proc);
      i++;
    }else{
      printf("Element null\n");
    }
    l = l->next;
  }
}*/
