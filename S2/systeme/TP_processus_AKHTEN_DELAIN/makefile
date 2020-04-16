CC = gcc
CFLAGS = -Wall

all: simulateur

%.o: %.c %.h
	$(CC) $(CFLAGS) -c $< -o $@



processus.o: processus.c processus.h
interruption.o: interruption.c interruption.h processus.h
simulateur.o: simulateur.c simulateur.h interruption.h

%: %.o
	$(CC) $^ -o $@

simulateur: simulateur.o interruption.o processus.o

clean: 
	rm -f *.o simulateur
