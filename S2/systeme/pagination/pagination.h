struct Page_V {
	int num;
	int num_phy;
	int isRead;
	int isModified;
};

typedef struct maillon{
	int val;
	struct Page_V *page_v;
	struct maillon *suiv;
}Maillon;

typedef struct {
	Maillon *tete, *queue;
}File;


struct *Page_V creer_();
void creation_memoire_virtuelle(int);
void affecter(int pagev, struct Page_V *);
void remplacement_fifo(struct File *, struct Page_V *);
int estVide(struct File f);
void enfiler(struct File*, int elt);
struct * PageVirt defiler(struct File* , int* );