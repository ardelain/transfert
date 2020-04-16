#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <errno.h>
#include <unistd.h>     /* pour read(2)/write(2) */

#include <netdb.h>      
#include <string.h>     /* pour memset */

#include <ctype.h>      /* pour toupper */

#include <arpa/inet.h>  /* pour inet_ntop */

#define REQUEST_MAX 1024  /* taille MAX en réception */
#define MAX_CLIENTS 20
#define true 1
#define false 0
typedef int SOCKET;
typedef struct sockaddr_in SOCKADDR_IN;
typedef struct sockaddr SOCKADDR;
typedef struct in_addr IN_ADDR;

typedef struct
{
   SOCKET sock;
   char name[BUF_SIZE];
}Client;

void usage() {
  fprintf(stderr,"usage : serveur port\n"); 
  exit(1);
}



void readForAll(Client clients[],int nb){
   char buffer[1024];
  for(int i = 0; i<nb ; i ++){
    if((ret=read(clients[i].sock, buffer, REQUEST_MAX))>0){
       scanf("%s",buffer);
       sendStringLen = strlen(buffer);  /* Find length of sendString */
       emmisionForAll(buffer,Client clients[],int nb);
       //sleep(3);
    }
  }
}

void emmisionForAll(char *msg,Client clients[],int nb){
  for(int i = 0; i<nb ; i ++){
    if(sendto(clients[i].sock,msg, strlen(msg) + 1,0,(struct sockaddr*)&clients[i].sock,sizeof clients[i].sock)==-1) {
        perror("sendto pb"); exit(1);
      } 
  }
}
int isclientIsConnect(char *name,int nb,Client clients[]){
  for(int i = 0; i<nb ; i ++){
    if(strcmp(name,clients[i].name)==0){
      return true;
    }
  }
  return false;
}



int main(int argc, char **argv) {

  int s, sock, ret;
  socklen_t n;
  int broadcastPermission;
  unsigned int sendStringLen;   
  char *broadcastIP,b1[100]; 
  unsigned short broadcastPort; 
  char *sendString; 

  char buffer[1024];
  int nbclients=0;
  Client clients[100]; 
  struct sockaddr_in broadcastAddr,client,server; 
  char request[REQUEST_MAX];
  
  //struct addrinfo hints, *result;
  struct sockaddr_storage src_addr;
  //socklen_t len_src_addr;

  

  /* Vérification des arguments */
  /*if(argc!=2) {
    fprintf(stderr,"Erreur : Nb args !\n");
    usage();
  }*/

 
  if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0){//IPPROTO_TCP
   perror("sock"); exit(1);
  }
   //s=socket(AF_INET,SOCK_DGRAM,0);
   server.sin_family=AF_INET;
   server.sin_port=hton(2000);
   //server.sin_addr.s_addr=inet_addr("127.0.0.1");
   if (!inet_aton((const char*)"127.0.0.1",&server.sin_addr)){
     perror("inet_aton"); exit(1);    
   }
  
  /* Attachement de la socket */
  if (bind(s,(SOCKADDR *)&server,sizeof(server)) == -1) {
    perror("bind"); exit(1);
  }

  if(listen(sock, MAX_CLIENTS) == SOCKET_ERROR)
   {
      perror("listen()");
      exit(errno);
   }
  int conn;
  while(1) { /* boucle du serveur */

    /* Attente d'une connexion */
    unsigned int size = sizeof (client);
    n=sizeof(client);
    puts("En attente de connexion...");

    //len_src_addr=sizeof src_addr;
    if((conn=accept(s, (struct sockaddr *)&client, 
      &size))==-1) {
      perror("accept"); exit(1);
    }else{
      if(conn>0){
        recvfrom(s,buffer,sizeof(buffer),0,(struct sockaddr *) &client,&n);
        puts("Connexion acceptée !");
        Client c;
        c.sock = conn;
        strncpy(c.name, buffer);
        clients[nbclients] = c;
        nbclients++;
      }
    }
    /* traitement du client */
   readForAll(clients,nb);
  } /* fin boucle principale du serveur */

  return 0;
}

  /*sendto(sock, sendString, sendStringLen, 0, (struct sockaddr *)&broadcastAddr, sizeof(broadcastAddr));*/


  /* Set socket to allow broadcast 
  broadcastPermission = 1;
  if (setsockopt(s, SOL_SOCKET, SO_BROADCAST, (void *) &broadcastPermission, sizeof(broadcastPermission)) < 0)
        system("echo erreur");//perror("setsockopt() failed");  exit(1);

  memset(&broadcastAddr, 0, sizeof(broadcastAddr));// Zero out structure 
  broadcastAddr.sin_family = AF_INET;// Internet address family 
  broadcastAddr.sin_addr.s_addr = inet_addr(broadcastIP);// Broadcast IP address 
  broadcastAddr.sin_port = htons(broadcastPort);// Broadcast port 

  /* définition de la taille de la file d'attente */
