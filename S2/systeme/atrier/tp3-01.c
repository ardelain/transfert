#include<stdio.h>
#include<stdlib.h>
#include<inttypes.h>


// Faudra mettre des commentaires
struct Systeme {
	uint8_t nbblocs;
	uint8_t nbinodes;
	uint8_t * bitmapBlocs;
	uint8_t * bitmapInodes;
	struct Inode * tabInode;
	uint8_t * tabblocs; 
};

struct Inode {
	uint8_t tailleNomFichier;
	char nom[8];
	uint8_t tailleFichier;
	uint8_t tabBloc[6];
};

void chargerSystemeFichier(char * nomFi,struct Systeme * s){
/*
	struct Systeme * s = malloc(sizeof(struct Systeme));
	struct Inode * i = malloc(sizeof(struct Inode));
	s-> tabInode = i;
*/

	FILE * fid = fopen(nomFi,"r");
	fread(&s->nbblocs,sizeof(uint8_t),1,fid);
	fread(&s->nbinodes,sizeof(uint8_t),1,fid);
	s->bitmapBlocs = malloc(sizeof(uint8_t)*(s->nbblocs/8));
	s->bitmapInodes = malloc(sizeof(uint8_t)*(s->nbinodes/8));
	s->tabInode = malloc(sizeof(struct Inode) * s->nbinodes);
	s->tabblocs = malloc(sizeof(uint8_t)*16*s->nbblocs);
	fread(s->bitmapBlocs,sizeof(uint8_t),(s->nbblocs)/8,fid);
	fread(s->bitmapInodes,sizeof(uint8_t),(s->nbinodes)/8,fid);
	fread(s->tabInode,sizeof(struct Inode),s->nbinodes,fid);
	fread(s->tabblocs,sizeof(uint8_t),16*(s->nbblocs),fid);
}


void affichage(struct Systeme * s){
	printf("Le nombre de blocs est : %d\n",s->nbblocs);
	printf("Le nombre d'inodes est : %d\n",s->nbinodes);
	int i;
	int nbinodesuse = 0 ;
	for(i= 0 ; i<s->nbinodes;i++){
		if(s->bitmapInodes[i/8] && (1 << 7-(i%8))){
			printf("L'inode numero %d est utilisée\n",i);
			nbinodesuse ++;
		}
	}
	printf("Le nombre d'inode utilisée est %d\n",nbinodesuse);
}



/*
Ex deux bitmap :
0010.1100.0001.0000
1 2 ... ..... 15
bitmapInode[i/8] && (1<<7-(i%8)


*/


int main(int argc, char ** argv){
	struct Systeme * s = (struct Systeme *) malloc(sizeof(struct Systeme));
	struct Inode * i = (struct Inode *) malloc(sizeof(struct Inode));
	s->tabInode = i;
	chargerSystemeFichier("./file-fs/correct-1.fs",s);
	affichage(s);

}
