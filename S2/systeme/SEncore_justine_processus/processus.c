//3.1,3.2,3.3
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>
#include <math.h>

#include "processus.h"

void print_test_progs(Programme p){
  int i;
  printf("Programme : \n");
  if(p.mots == NULL){
    printf("Vide\n");
    return;
  }
  for(i=0;i<MAX_INSTRUCTION;i++){
    if(p.mots[i] == NULL){
      return;
    }
    printf("\tInstruc val;%d bloq%d;\n",p.mots[i]->valide,p.mots[i]->bloquante);
  }
  return;
}

void print_test_procs(Processus **procs){
  int i,j;
  printf("PRINT TEST PROCS:\n");
  if(procs == NULL){
    printf("tabNULL\n\n");
    return;
  }
  for(i=0;i<MAX_PROC;i++){
    if(procs[i] != NULL){
      printf("num_tab %d\n",procs[i]->num_tab);
      printf("num_pere %d\n",procs[i]->num_pere_tab);
      print_test_progs(procs[i]->p);
      printf("Liste fils:\n");
      for(j=0;j<MAX_PROC;j++){
        if(procs[i]->nums_fils_tab[j] != -1)
          printf("%d ",procs[i]->nums_fils_tab[j]);
      }
      printf("\n\n");
    }
  }
}

int* init_nums_fils_tab(int *tab_fils){
  int i;
  tab_fils = (int*)malloc(MAX_PROC*sizeof(int));
  for(i=0;i<MAX_PROC;i++){
    tab_fils[i] = -1;
  }
  return tab_fils;
}

void add_fils_pere(Processus *p,int num_fils){
  int i;
  if(p == NULL){
    perror("Pb p est null");
    return;
  }
  for(i=0;i<MAX_PROC;i++){
    if(p->nums_fils_tab[i] == -1){
      p->nums_fils_tab[i]=num_fils;
      return;
    }
  }
}

void del_fils_pere(int *tab_fils,int num_fils){
  int i;
  for(i=0;i<MAX_PROC;i++){
    if(tab_fils[i] == num_fils){
      tab_fils[i]= -1;
      return;
    }
  }
}

Processus* create_proc(Processus **procs,int num_pere){
  int i=0;
  Processus *p;
  if(procs == NULL){
    printf("tabNULL\n");
    procs = (Processus**)malloc(MAX_PROC*sizeof(Processus*));
    if(procs==NULL){
      perror("Pb malloc");
      exit(1);
    }
  }

  for(i=0;i<MAX_PROC;i++){
    if(procs[i] == NULL){
      p = (Processus*)malloc(sizeof(Processus));
      if(p==NULL){
        perror("Pb malloc");
        exit(1);
      }
      p->num_tab = i;
      p->num_pere_tab = num_pere; //Verifeir si pere existe
      p->nums_fils_tab=init_nums_fils_tab(p->nums_fils_tab);
      p->waiting_for=init_nums_fils_tab(p->waiting_for);
      procs[i] = p;
      if(i != 0)
        add_fils_pere(procs[num_pere],p->num_tab);
      nb_processus++;
      return procs[i];
    }
  }
  //perror("Pb procs, plus de place"); //Possible realloc
}

void add_instruction(Processus *p,Mot *mot){
  int i;
  if(p->p.mots == NULL){
    p->p.mots = (Mot**)malloc(MAX_INSTRUCTION*sizeof(Mot));
    if(p->p.mots == NULL){
      perror("pb malloc");
      exit(1);
    }
  }

  for(i=0;i<MAX_INSTRUCTION;i++){
    if(p->p.mots[i] == NULL){
      p->p.mots[i] = mot;
      return;
    }
  }

}

void save_context_proc(Processus *p,int context){
  p->debloque = 0;
  p->pt_pile = context;
}

void add_proc_list(ProcList *list,Processus *p){
  ProcList *l;
  if(list == NULL){
    perror("Pb add proc list");
    return;
  }
  l = list;
  while(l != NULL){
    if(l->next == NULL){
      l->next = (ProcList*)malloc(sizeof(ProcList));
      l->next->p = p;
      return;
    }
    l = l->next;
  }
}

void del_proc_list(ProcList *list,Processus *p){
  ProcList *l,*temp;
  l = list;
  while(l != NULL){
    if(l->next->p->num_tab == p->num_tab){
      temp = l->next;
      l->next = l->next->next;
      free(temp);
      break;
    }
    l = l->next;
  }
}

int end_processus(Processus *p,ProcList *list,Processus **procs){
  int i;
  if(list != NULL)
    del_proc_list(list,p);

  for(i=0;i<MAX_PROC;i++){
    if(p->nums_fils_tab[i] != -1){
      procs[p->nums_fils_tab[i]]->num_pere_tab = 0;
      add_fils_pere(procs[0],p->nums_fils_tab[i]);
    }
  }
  //ajout waiting_for ??
  del_fils_pere(procs[p->num_pere_tab]->nums_fils_tab,p->num_tab);
  procs[p->num_tab] = NULL;
  free(p);
  nb_processus--;
  return 0;
}

//returns the index
int is_in_tab_fils(int *tab_fils,int num_p){
  int i;
  for(i=0;i<MAX_PROC;i++){
    if(tab_fils[i] == num_p){
      return i;
    }
  }
  return -1;
}

int len_tab_int(int *tab){
  int i,nb=0;
  for(i=0;i<MAX_PROC;i++){
    if(tab[i] != -1){
      nb++;
    }
  }
  return nb;
}

Mot* recup_instruction_courante(Processus *p){
  int i;
  if(p->p.mots ==NULL){
    printf("Il n'y a pas d'instruction\n");
    return NULL;
  }
  return p->p.mots[p->pt_pile]; //pt_pile = ligne = nb instruction;
}

int instruction_num(Processus *p,Mot *m_courant){
  Mot *m;
  int i;
  for(i=0;i<MAX_INSTRUCTION;i++){
    if(m_courant == p->p.mots[i]){
      printf("NUM INSTRUCTION %d\n",i);//On prend i+1
      return i;
    }
  }
  return -1;
}

int count_instruction_left(Processus *p){
	int cpt=0;
	int i=p->pt_pile;
	while(p->p.mots[i]!=NULL){
		cpt++;
		i++;
	}

	return cpt;
}

/*int main(){
  //TESTS
  Processus **procs,*p;
  ProcList *waiting_list;
  procs = (Processus**)malloc(MAX_PROC*sizeof(Processus*));
  if(procs==NULL){
    perror("Pb malloc");
    exit(1);
  }
  p=create_proc(procs,0);
  p=create_proc(procs,0);
  p=create_proc(procs,1);
  p=create_proc(procs,1);
  print_test_procs(procs);
  add_proc_list(waiting_list,procs[2]);
  end_processus(procs[1],NULL,procs);
  print_test_procs(procs);
  return 0;
}*/
