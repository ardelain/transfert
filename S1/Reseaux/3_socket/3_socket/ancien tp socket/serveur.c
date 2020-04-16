#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <errno.h>
#include <unistd.h>

#include <netinet/in.h>
#include <arpa/inet.h>


#include <netdb.h>      
#include <string.h>     /* pour memset */

#include <ctype.h>     /* pour toupper */

#define DGRAM_MAX 1024  /* taille MAX en réception */

void usage() {
	fprintf(stderr,"usage : serveur port\n"); 
	exit(1);
}

int getexec(char *command, char *response, unsigned size) {
        FILE *fp;
        int r;

	memset (response, 0, sizeof (response));

 	
        if((fp = popen(command, "r"))==NULL) return -1;

        r=read(fileno(fp), response,DGRAM_MAX-1); // FIXME

        if(r>=0) response[r]=0;
 
        if(pclose(fp)==-1) return -1;
 
        return r;
}


int main(int argc, char **argv) {
	struct sockaddr_in addr, src_addr;	
	int s, ret;
	socklen_t len_src_addr;

	char request[DGRAM_MAX];

	/* Vérification des arguments */
	if(argc!=2) {
		fprintf(stderr,"Erreur : Nb args !\n");
		usage();
	}

	/* Création de la socket IPv4 */
	if((s=socket(AF_INET, SOCK_DGRAM, 0))==-1) {
		perror("socket"); exit(1);
	}

	/* Attachement de la socket */
	addr.sin_family = AF_INET;
	addr.sin_addr.s_addr = htonl (INADDR_ANY);
	addr.sin_port = htons(atoi(argv[1]));  
	memset(addr.sin_zero, '\0', sizeof(addr.sin_zero));

	if(bind(s, (struct sockaddr *)&addr, sizeof addr)) {
		perror("bind"); exit(1);
	}

	{
		int codeRet;
		char * resultCom;
		resultCom = (char *)malloc(sizeof(char)*DGRAM_MAX);
		while(1) {

			/* Attente et lecture d'une requête */
			len_src_addr=sizeof src_addr;
			if((ret=recvfrom(s, request, DGRAM_MAX-1, 0,
					(struct sockaddr*) &src_addr, &len_src_addr))==-1) {
				perror("recvfrom"); exit(1);
			}
			request[ret]=0;

			/* traitement de la requête */
			printf("(%s) Commande : %s\n", inet_ntoa(src_addr.sin_addr), request);
			codeRet = getexec(request, resultCom, strlen(request));
			

			/* Émission du datagramme réponse */

			if(sendto(s, resultCom, strlen(resultCom)+1, 0, \
						(struct sockaddr*) &src_addr, sizeof(src_addr))==-1) {
				perror("sendto"); exit(1);
			}
		}

	}
	return 0;
}









