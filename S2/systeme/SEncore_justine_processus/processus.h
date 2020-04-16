
#define MAX_PROC 50
#define MAX_INSTRUCTION 20
int nb_processus;

typedef enum {false,true} Bool;

typedef struct mot{
  Bool valide;
  Bool bloquante;
}Mot;

typedef struct programme{
  Mot **mots; //Tab de mots de lg non définit
}Programme;

typedef struct processus{
  Programme p;
  int num_tab;
  int num_pere_tab;
  int *nums_fils_tab;
  int pt_pile; //A enlever -> machine
  //0 pas attente;1 attente bloquante;2attente terminaison
  int en_attente;
  Bool debloque; //Informe si le processus vient d'etre débloqué -> à mettre dans machine
  int *waiting_for; //liste des processus fils qu'il attend
  int time; //tps cpu accordé
}Processus;

typedef struct proc_list{
  Processus *p;
  struct proc_list *next;
}ProcList;



void print_test_procs(Processus **procs);
int* init_nums_fils_tab(int *tab_fils);
void add_fils_pere(Processus *p,int num_fils);
void del_fils_pere(int *tab_fils,int num_fils);
Processus* create_proc(Processus **procs,int num_pere);
void save_context_proc(Processus *p,int context);
void add_proc_list(ProcList *list,Processus *p);
void del_proc_list(ProcList *list,Processus *p);
int end_processus(Processus *p,ProcList *list,Processus **procs);
int is_in_tab_fils(int *tab_fils,int num_p);
int len_tab_int(int *tab);
Mot* recup_instruction_courante(Processus *p);
int instruction_num(Processus *p,Mot *m_courant);
void add_instruction(Processus *p,Mot *mot);
int count_instruction_left(Processus *p);



