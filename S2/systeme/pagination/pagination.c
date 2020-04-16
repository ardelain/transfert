#include<stdio.h>
#include "pagination.h"

#define TAILLE_PAGE 4
#define TAILLE_MEM 64



struct *Page_V creer_(){
	struct Page_V page = malloc(sizeof struct Page_V);
	page->num_phy = -1;
	return page;
}

void creation_memoire_virtuelle(int n){
	struct Page_V * page[n];
	int i = 0;
	int nbpage =  n/TAILLE_PAGE;
	for(i=0;i<n;i++){
		page[i] = creer_();
	}
}

void affecter(int pagev, struct Page_V *p){
	p->num_phy = pagev;
}

void remplacement_fifo(struct File * file, struct Page_V memoirePhy[]){
	// recherche page de la memoire physique pas utilisé.
	int nbPagePhy = TAILLE_MEM/TAILLE_PAGE;
	int i;
	for(i=0;i<nbPagePhy;i++){
		if(memoirePhy[i]->isRead == -1){
			struct PageVirt *pageVirt = defiler(file);
			memoirePhy[i]->num_phy = -1;
			enfiler(pile,memoirePhy[i]);
			pageVirt->num_phy = i;
			memoirePhy[i] = pageVirt;
			break;
		}else if(memoirePhy[i]->isModified == -1){
			struct PageVirt *pageVirt = defiler(file);
			// On vire la page en memoire virtuelle
			memoirePhy[i]->num_phy = -1;
			enfiler(pile,memoirePhy[i]);
			pageVirt->num_phy = i;
			memoirePhy[i] = pageVirt;
			break;
		} else{
			printf("Toute les pages (mémoire physiques) sont utilisé");
			break;
		}
	}

}

int estVide(struct File f){
	if(f.tete == NULL){ return 0;}
	else { return -1;}
}


void enfiler(struct File* pf, int elt){
	Maillon* tmp = (Maillon *)malloc(sizeof(Maillon));
	if(tmp==NULL) return ;
	if(!estVide(*pf)){
		pf->queue->suiv=tmp;
		pf->queue=tmp;
	}else{
		pf->tete=tmp;
		pf->queue=tmp;
	}
	tmp->val=elt;
	tmp->suiv=NULL;
}

struct * PageVirt defiler(File* pf){
	Maillon *tmp;
	Maillon* elt = (Maillon *)malloc(sizeof(Maillon));
	//if(estVide(*pf)) return FAUX;
	tmp = pf->tete;
	*elt=tmp->page_v;
	pf->tete=tmp->suiv;
	//free(tmp);
	if(pf->tete == NULL) {
		pf->queue = NULL;
	}
	return ;
}


int main(){



}