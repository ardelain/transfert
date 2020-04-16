#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <errno.h>

#include <netdb.h>      /* pour gethostbyname*/
#include <string.h>     /* pour memset */
#include <unistd.h>     /* pour getlogin() */


#define DGRAM_MAX 1024  /* taille MAX en réception */

void usage() {
	fprintf(stderr,"usage : client hostname port\n"); 
	exit(1);
}

int main(int argc, char **argv) {
	struct sockaddr_in dst_addr, src_addr;	
	struct hostent * hostent;
	int s, ret;
	socklen_t len_src_addr;

	char response[DGRAM_MAX];

	char msg[100];

	/* Vérification des arguments */
	if(argc!=3) {
		fprintf(stderr,"Erreur : Nb args !\n");
		usage();
	}

	/* Création de la socket IPv4 */
	if((s=socket(AF_INET, SOCK_DGRAM, 0))==-1) {
		perror("socket"); exit(1);
	}
	{
		int on=1;
		setsockopt (s, SOL_SOCKET, SO_BROADCAST, &on, sizeof(on));
	}

	/* Récupération de l'adresse IPv4 du destinataire */
	if((hostent=gethostbyname(argv[1]))==NULL) {
		herror("gethostbyname"); exit(1);
	}

	/* Remplissage de l'adresse du destinataire */
	dst_addr.sin_family = AF_INET;
	dst_addr.sin_port = htons(atoi(argv[2]));  
	dst_addr.sin_addr = *((struct in_addr *)hostent->h_addr);
	memset(dst_addr.sin_zero, '\0', sizeof(dst_addr.sin_zero));

	/* Émission du datagramme */
	
	{
		
		

		while (strcmp(msg,"exit") !=0 ){
				fgets(msg, 50,  stdin);
				if(msg == NULL){
					printf("Message null !");exit(1);
				}
				msg[strlen(msg)-1] = '\0';

				if(sendto(s, msg, strlen(msg)+1, 0, \
					(struct sockaddr*) &dst_addr, sizeof(dst_addr))==-1) {
					perror("sendto"); exit(1);
				}
				
			/* Attente et lecture de la réponse */
				len_src_addr=sizeof(src_addr);
				if((ret=recvfrom(s, response, DGRAM_MAX-1, 0, 
					(struct sockaddr*) &src_addr, &len_src_addr))==-1) {
					perror("recvfrom"); exit(1);
				}
				response[ret]=0;	

				/* Traitement de la réponse */
				puts(response);

		}	

	}
	
	

	return 0;
}

