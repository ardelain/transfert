#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <errno.h>

#include <unistd.h>     /* pour read(2)/write(2) */

#include <netdb.h>      /* pour getaddrinfo*/
#include <string.h>     /* pour memset */

#include <arpa/inet.h>  /* pour inet_ntop */
#define true 1
#define false 0
#define LINE_MAX 1024  /* taille MAX en réception */
typedef int SOCKET;
typedef struct sockaddr_in SOCKADDR_IN;
typedef struct sockaddr SOCKADDR;
typedef struct in_addr IN_ADDR;

void usage() {
  fprintf(stderr,"usage : client hostname port\n"); 
  exit(1);
}



int emission(char *msg){
    if(strcmp(fgets(msg, LINE_MAX, stdin),"")==0){
      return false;
    }else{
      return true;
    }
    
}

int reponse(SOCKET s,SOCKADDR_IN from, char *response){
    /* Attente et lecture de la réponse */
    int ret;
    socklen_t fromsize;
    fromsize = sizeof(from);
    if((ret = recvfrom(s, response, 1023, 0,(struct sockaddr*) &from, &fromsize)) < 0) /*ret=read(s, response, LINE_MAX);*/
    {
        perror("recvfrom()");exit(errno);
    }

    if(ret==0 || strcmp(response,"quit") == 0 ) {
      fprintf(stderr, "Déconnexion du serveur !\n");
      exit(1);
    }

    if(response == NULL){
      return false;
    }else{
      return true;
    }
}

int main(int argc, char **argv) {
  int s, ret;
  SOCKADDR_IN sin;
  struct addrinfo hints, *result;

  char msg[LINE_MAX];
  char response[LINE_MAX];


  /* Vérification des arguments */
  /*if(argc!=3) {
    fprintf(stderr,"Erreur : Nb args !\n");
    usage();
  }*/

   //sin.sin_addr = *(IN_ADDR *) hostinfo->h_addr;
   sin.sin_port = hton("2000");//argv[1]
   sin.sin_family = AF_INET;
  if (!inet_aton((const char*)"localhost",&sin.sin_addr)){//argv[2]
    perror("inet_aton"); exit(1);   
  }

  /* Création de la socket IPv4/IPv6 */
  if((s=socket(result->ai_family, result->ai_socktype, 
          result->ai_protocol))==-1) {
    perror("socket"); exit(1);
  }

  /* Connexion au serveur */
  if(connect(s, result->ai_addr, result->ai_addrlen)) {
    perror("connect"); exit(1);
  }

  puts("Connecté !");

  //freeaddrinfo(result); // si result ne sert plus

  while(1) {//fgets(msg, LINE_MAX, stdin) != NULL

    if(emission(msg)){
      /* Émission */
      //msg[strlen(msg)-1]=0; /* retire '\n' final */
      if(sendto(s,msg, strlen(msg) + 1,0,(struct sockaddr*)&sin,sizeof sin)==-1) {
        perror("sendto pb"); exit(1);
      }
      /*if(write(s, msg, strlen(msg)+1) != strlen(msg)+1) {
        perror("write"); exit(1);
      }*/
    }
   
    if(reponse(s,sin, response)){
      /* Traitement de la réponse */
      if(strcmp(response,msg) != 0){
       puts("Probleme accusé de reception");
       puts(response);
      }else{
       puts(response);
       system("echo recu !");
      }
    }

    
    
  }

  if(close(s)==-1) {
    perror("close"); exit(1);
  } 

  return 0;
}