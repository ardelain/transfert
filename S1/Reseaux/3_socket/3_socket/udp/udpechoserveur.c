#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <errno.h>
#include <netdb.h>      
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netinet/ip.h>
#include <unistd.h> /* close */
#define INVALID_SOCKET -1
#define SOCKET_ERROR -1

#define REQUEST_MAX 1024  /* taille MAX en réception */

int main(int argc, char **argv) {//port
	struct sockaddr_in  sin;
	struct sockaddr_in from;
	socklen_t fromsize;
	int ret;
	char buffer[1024];

	int sock = socket(AF_INET, SOCK_DGRAM, 0);
	if(sock == 0){
	    perror("socket()");exit(errno);
	}
	
	sin.sin_family  = AF_INET;
	sin.sin_port = htons(atoi(argv[1]));
	sin.sin_addr.s_addr = htonl(INADDR_ANY);
	//memset(sin.sin_zero, '\0', sizeof(sin.sin_zero));

	if((ret=bind (sock, (struct sockaddr *) &sin, sizeof sin)) == SOCKET_ERROR){
		perror("bind()");exit(errno);
	}
{
	while(1){
		fromsize = sizeof(from);
		if((ret = recvfrom(sock, buffer, 1023, 0,(struct sockaddr*) &from, &fromsize)) < 0)
		{
		    perror("recvfrom()");exit(errno);
		}
			//buffer[ret]=0;
			//printf("");
			printf("\n\nmessage: %s",buffer);// inet_ntoa(sin.sin_addr)
			printf("\n(%s) Commande : %s", inet_ntoa(sin.sin_addr), buffer);
			/*if(strcmp(buffer,"quit") == 0){
				break;		
			}*/
		
	}
}
	close(sock);
}
