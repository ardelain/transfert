#include<stdio.h>

#define TAILLE_PAGE 4
#define TAILLE_MEM 64

struct PageVirt {
	int num;
	int num_phy;
	int isRead;
	int isModified;
	int lastTime;
	int duree;
};

struct Liste {
	struct PageVirt *pageVirt;
	struct Liste *suiv;
};

struct Pile {
	struct Liste *tetePile;
	int taille;
};

//Question 1
struct *PageVirt creer_page(){
	struct PageVirt * page = malloc(sizeof struct PageVirt);
	page->num_phy = -1;
	// Initialiser le reste a -1
}


// Peut etre retour du tableau de page ici, ou alors le passer en param
//Question 2
void creation_mem_virtuelle(int n){
	struct PageVirt * page[n];
	int i = 0;
	for(i=0;i<n;i++){
		page[i] = creer_page();
	}
}
// Question 3
void affectation(int numPagePhy, struct PageVirt * p){
	p->num_phy = numPagePhy;

}
//Question 4
// Le remplacement d'une page, je suppose changer une page virtuelle dans la mémoire physique?
void remplacement(struct Pile * pile, struct PageVirt memoirePhy[]){
	
	// Et mtn on cherche une page de la memoire physique qui n'est pas utilisé.
	int nbPagePhy = TAILLE_MEM/TAILLE_PAGE;
	int i;
	for(i=0;i<nbPagePhy;i++){
		if(memoirePhy[i]->isModified == -1){
			// Algo FIFO, on recup la 1ere page de la pile
			struct PageVirt *pageVirt = depiler(pile);
			// On vire la page en memoire virtuelle
			memoirePhy[i] -> num_phy = -1;
			empiler(pile,memoirePhy[i]);
			pageVirt -> num_phy = i;
			memoirePhy[i] = pageVirt;
			break;
		}else if(memoirePhy[i]->isRead == -1){
			struct PageVirt *pageVirt = depiler(pile);
			memoirePhy[i] -> num_phy = -1;
			empiler(pile,memoirePhy[i]);
			pageVirt -> num_phy = i;
			memoirePhy[i] = pageVirt;
			break;
		}else{
			printf("Toute les pages de la mémoire physiques sont actuellement utilisé");
			break;
		}
	}
	
}

struct * PageVirt depiler (struct Pile *pile) {
	struct PageVirt * page = malloc(sizeof(struct PageVirt));
	page = pile->tetePile->pageVirt;
	pile->tetePile = pile->pageVirt->suiv;
	pile->taille = pile->taille-1;
	// Il faudrait faire un free pour l'element depiler
	return page;
}

void empiler(struct Pile *pile, struct PageVirt * page){
	struct Liste * pageListe = malloc(sizeof(struct Liste));
	pageListe -> pageVirt = page;
	pageListe -> suiv = pile ->tetePile;
	pile->tetePile = pageListe;
	pile->taille = pile -> taille +1;
}


int main(){
	int nbPagePhy = TAILLE_MEM/TAILLE_PAGE;
	int i;
	struct PageVirt memoirePhy[nbPagePhy];
	for(i = 0; i<nbPagePhy;i++){
		memoirePhy[i] = NULL;
	}
	// On crée la pile des pages virtuelles
	struct Liste * pile;
	// On a un tableau de int qui correspond aux page physiques, et dedans on mettra les numeros
	// des pages virtuelles
	
	return 0;
}

