struct Descripteur {
  struct Systeme* fs;
  struct Inode* inode;
  uint8_t bloc; // Le bloc en cours de lecture
  uint8_t decalage;
  uint8_t cache [16]; // Le contenu du blocs en cours
};

void lireBlocs(struct Descripteur d);
void creerDescripteur(struct Systeme *s, struct Inode *i);
void creerDescripteurNom(struct Systeme * s, char * nomFi);
