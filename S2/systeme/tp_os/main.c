
#include "processus.h"
#include "processus.c"

// selectionne prec
//machine 
// gestionnaire instruction  (p,  )
// gestion  interruption
// le temps de chaque prc est aleatoire
//
/*******************************************************************************/



int main(){


	liste_processus = malloc( sizeof( struct liste_processus));
	
	file_interruption		 = malloc( sizeof( struct file_interruption));	
	
	initialisation( );

	
	creation_processus( 0 );
	creation_processus( 0 );
	creation_processus( 1 );
	creation_processus( 2 );
	creation_processus( 3 );
	creation_processus( 1 );
	
	
	
	affiche_liste_processus( liste_processus , 1);
	
	
	affiche_programme(1);
	affiche_programme(2);
	affiche_programme(3);
	affiche_programme(4);
	affiche_programme(5);
	affiche_programme(6);
	

	genere_interruption();
	genere_interruption();
	genere_interruption();
	genere_interruption();

	
	
	affiche_file_interruption();
	ordonnancement();
	affiche_file_interruption();
	affiche_liste_processus( liste_processus , 1);

		
	
	return 0;
}
