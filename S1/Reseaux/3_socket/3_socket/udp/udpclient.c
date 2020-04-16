#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <errno.h>
#include <netdb.h>      
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/ip.h>
#include <unistd.h> /* close */
#include <netdb.h> /* gethostbyname */
#define INVALID_SOCKET -1
#define SOCKET_ERROR -1

typedef int SOCKET;
typedef struct sockaddr_in SOCKADDR_IN;
typedef struct sockaddr SOCKADDR;
typedef struct in_addr IN_ADDR;

#define REQUEST_MAX 1024  /* taille MAX en réception */

int main(int argc, char **argv) {//port, ip
	struct hostent * hostent;
	struct sockaddr_in  sin;
	//struct sockaddr  adresse = inet_aton("127.0.0.1");;
	int i, ret,sock;
	char buffer[1024];
	char msg[100];

	//init socket:
	if((sock=socket(AF_INET, SOCK_DGRAM, 0)) == -1)
	{
	    perror("socket()");exit(errno);
	}else{
		int on=1;
		setsockopt (sock, SOL_SOCKET, SO_REUSEADDR, &on, sizeof(on));//SO_BROADCAST
	}

	/* Récupération de l'adresse IPv4 du destinataire */
	/*if((hostent=gethostbyname(argv[2]))==NULL) {
    	perror("gethostbyname"); exit(1);
	}*/
	//memcpy("127.0.0.1",hostent->h_addr_list[0],hostent->h_length);

	sin.sin_family  = AF_INET;
	sin.sin_port = htons(atoi(argv[1]));
	//bcopy((char *)hostent->h_addr, (char *)&sin.sin_addr.s_addr,hostent->h_length);
	//sin.sin_addr= *((struct in_addr *)hostent->h_addr);
	//sin.sin_addr.s_addr=inet_aton("127.0.0.1");
	 if (!inet_aton((const char*)argv[2],&sin.sin_addr)){
		//sin.sin_addr.s_addr=0;perror("inet_aton"); exit(1);		
		}
	//memset(sin.sin_zero, '\0', sizeof(sin.sin_zero));


	while (strcmp(msg,"quit") !=0 ){//while(1){
		//fgets(msg, 50,  stdin);
		scanf("%s",&msg);
		if(msg == NULL){
			printf("\nMessage null !");exit(1);
		}
		//msg[strlen(msg)-1] = '\0';

		if(sendto(sock,msg, strlen(msg) + 1,0,(struct sockaddr*)&sin,sizeof sin)==-1) {
			perror("sendto pb"); exit(1);
		}
		if(ret<0){
			printf("error");
		}
	}
	close(sock);
}
