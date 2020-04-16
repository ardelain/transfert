#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <errno.h>

#include <unistd.h>     /* pour read(2)/write(2) */

#include <netdb.h>      /* pour getaddrinfo*/
#include <string.h>     /* pour memset */

#include <arpa/inet.h>  /* pour inet_ntop */

#define LINE_MAX 1024  /* taille MAX en réception */

void usage() {
  fprintf(stderr,"usage : client hostname port\n"); 
  exit(1);
}

int main(int argc, char **argv) {
  int s, ret;

  struct addrinfo hints, *result;

  char msg[LINE_MAX];
  char response[LINE_MAX];


  /* Vérification des arguments */
  if(argc!=3) {
    fprintf(stderr,"Erreur : Nb args !\n");
    usage();
  }

  memset(&hints, 0, sizeof(struct addrinfo));
  hints.ai_flags = 0;//AI_PASSIVE/* For wildcard IP address */
  hints.ai_family = AF_UNSPEC;    /* Allow IPv4 or IPv6 */
  hints.ai_socktype = SOCK_STREAM; /* Datagram socket */
  hints.ai_protocol = 0;          /* Any protocol */
  hints.ai_canonname = NULL;
  hints.ai_addr = NULL;
  hints.ai_next = NULL;


  ret = getaddrinfo(argv[1], argv[2], &hints, &result);
  if (ret != 0) {
    fprintf(stderr, "getaddrinfo: %s\n", gai_strerror(ret));
    exit(EXIT_FAILURE);
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

  freeaddrinfo(result); // si result ne sert plus

  while(fgets(msg, LINE_MAX, stdin) != NULL) {

    msg[strlen(msg)-1]=0; /* retire '\n' final */

    /* Émission */
    if(write(s, msg, strlen(msg)+1) != strlen(msg)+1) {
      perror("write"); exit(1);
    }

    /* Attente et lecture de la réponse */
    ret=read(s, response, LINE_MAX);

    if(ret==0) {
      fprintf(stderr, "Déconnexion du serveur !\n");
      exit(1);
    }

    else if(ret == -1) {
      perror("read"); exit(1);
    }

    /* Traitement de la réponse */
    puts(response);
  }

  if(close(s)==-1) {
    perror("close"); exit(1);
  } 

  return 0;
}

