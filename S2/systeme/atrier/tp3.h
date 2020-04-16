

struct Inode {
  uint8_t tailleNomFichier;
  char nom[8];
  uint8_t tailleFichier;
  uint8_t tabBloc[6];
};

struct Systeme {
  uint8_t nbblocs;
  uint8_t nbinodes;
  uint8_t * bitmapBlocs;
  uint8_t * bitmapInodes;
  struct Inode * tabInode;
  uint8_t * tabblocs; 
};



