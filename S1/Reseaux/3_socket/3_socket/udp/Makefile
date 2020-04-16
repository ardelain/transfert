
CC=gcc -pipe -Wall -march=native -O3 -lm -lcrypt
CPP=g++ -pipe -Wall -march=native -Ofast -fomit-frame-pointer
SRC=$(wildcard *.c)
EXEC=$(SRC:.c=)

all: $(EXEC)

%: %.c Makefile
	$(CC) -o $@ $<

mrproper: 
	rm -rf $(EXEC)  *~
