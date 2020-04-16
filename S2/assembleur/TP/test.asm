section .data

message: db 'dada',10
longueur: equal $-message

section .text
global _start

_start:
	mov eax, 4
	mov ebx, 1
	mov ecx, message
	mov edx, longueur
	int 80h
	mov eax, 4
	mov ebx, 1
	int 80h