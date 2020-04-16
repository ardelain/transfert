#include<stdio.h>
#include<stdlib.h>
#include<inttypes.h>
#include "tp3.h"
#include "descripteur.h"


// Faudra mettre des commentaires
void ecrireSystemeFichier(char * nomFi,struct Systeme * s){
	FILE * fid = fopen(nomFi,"w");
	fwrite(&s->nbblocs,sizeof(uint8_t),1,fid);
  	fwrite(&s->nbinodes,sizeof(uint8_t),1,fid);
 	fwrite(s->bitmapBlocs,sizeof(uint8_t),(s->nbblocs)/8,fid);
  	fwrite(s->bitmapInodes,sizeof(uint8_t),(s->nbinodes)/8,fid);
  	fwrite(s->tabInode,sizeof(struct Inode),s->nbinodes,fid);
  	fwrite(s->tabblocs,sizeof(uint8_t),16*(s->nbblocs),fid);
	fclose(fid);
}

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
	fclose(fid);
}


void affichageInodes(struct Systeme * s){

  printf("Le nombre de blocs est : %d\n",s->nbblocs);
  printf("Le nombre d'inodes est : %d\n",s->nbinodes);
  int i;
  int nbinodesuse = 0 ;
  for(i= 0 ; i<s->nbinodes;i++){
    if(s->bitmapInodes[i/8] & (1 << 7-(i%8))){
      printf("L'inode numero %d est utilisée\n",i);
      nbinodesuse ++;
    }
  }
  printf("Le nombre d'inode utilisée est %d\n",nbinodesuse);
}


void affichageNomFichier(struct Systeme * s){

  int i,j;

  printf("Le nombre de blocs est : %d\n",s->nbblocs);
  printf("Le nombre d'inodes est : %d\n",s->nbinodes);

  for(i = 0; i < s->nbinodes; i++){
    
    if(s->bitmapInodes[i/8] & (1 << 7-(i%8))){
      printf("Le nom du fichier est ");
      
      for(j = 0; j < s->tabInode[i].tailleNomFichier; j++)
	printf("%c",s->tabInode[i].nom[j]);
      
      printf("\n");
      
      

    }
  }
}


void affichageContenuFichier(struct Systeme * s){

  //afficher le nom de l'inode et le contenue des blocs
  
  int i,j,z;

	printf("Le nombre de blocs est : %d\n",s->nbblocs);
	printf("Le nombre d'inodes est : %d\n",s->nbinodes);
	for(j = 0; j < s->nbblocs; j++){
	printf("bloc %d:  ",j);
		for(z = 0 ; z<16 ; z++){
			printf("%c ",s->tabblocs[j*16 + z]);
		}
	printf("\n");
	}
  for(i = 0; i < s->nbinodes; i++){
    
    if(s->bitmapInodes[i/8] & (1 << 7-(i%8))){
      printf("Le nom du fichier est ");
      
      for(j = 0; j < s->tabInode[i].tailleNomFichier; j++)
	printf("%c",s->tabInode[i].nom[j]);
      

      printf(" ,Taille fichier = %d, il contient:\n",s->tabInode[i].tailleFichier);
      
      for(j = 0; j < s->tabInode[i].tailleFichier/16; j++){
			for(z = 0 ; z<16 ; z++){
					printf("%c ",s->tabblocs[(s->tabInode[i].tabBloc[j]-1)*16 + z]);
			}
      	
      
		}
      printf("\n");
    }
  }
}







int main(int argc, char ** argv){

  struct Systeme * s = (struct Systeme *) malloc(sizeof(struct Systeme));
  struct Inode * i = (struct Inode *) malloc(sizeof(struct Inode));
  s->tabInode = i;
  chargerSystemeFichier("./file-fs/correct-1.fs",s);
	ecrireSystemeFichier("testFichier.fs",s);
  //affichageInodes(s);
  //affichageNomFichier(s);
  affichageContenuFichier(s);

	creerDescripteurNom(s, "AAAA");


}
