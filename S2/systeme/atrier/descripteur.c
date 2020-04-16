#include<stdio.h>
#include<stdlib.h>
#include<inttypes.h>
#include "descripteur.h"
#include "tp3.h"


void creerDescripteur(struct Systeme *s, struct Inode *i){
// Initialisation descripteur
	struct Descripteur * d = malloc(sizeof(struct Descripteur));
	d->fs = malloc(sizeof(struct Systeme));
	d->fs = s;
	d->inode = malloc(sizeof(struct Inode));
	d->inode = i;
	d->bloc = 1;
	d->decalage = 0;
	for(z=0 ; z<16 ; z++){
		cache[z] = s->tabblocs[(d->inode.tabBloc[d->bloc]-1)*16 + z);
	}
		
	
}

void creerDescripteurNom(struct Systeme * s, char * nomFi){
	int i = 0;
	for(i = 0; i < s->nbinodes; i++){
      	if(strcmp(s->tabInode[i].nom,nomFi)==0){
			creerDescripteur(s,s->tabInode[i]);
			return;
		}
    }
	printf("Le nom du fichier recherché n'existe pas\n");
  }
}

void lireBlocs(struct Descripteur *d){
	// On lis le caractère au niveau du curseur, puis on décale. 
	// on lis directement dans le cache, mais on pourrait lire dans les blocs du systeme
	// pour écrire il faudra le faire dans le systeme, pas dans le cache
	printf("%c ",d->cache[d->decalage]);
	if(d->decalage +1 >= 16){
		d->bloc += 1;
		d->decalage = 0;
	}else{
		d->decalage += 1;
	}

	printf("\n");
	

}

