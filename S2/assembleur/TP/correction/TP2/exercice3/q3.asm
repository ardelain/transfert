section .data
char: db 0

section .text
global _start
_start:
    mov eax, 3
    mov ebx, 0
    mov ecx, char
    mov edx, 1
    int 0x80

    mov eax, 4
    mov ebx, 1
    mov ecx, char
    mov edx, 1
    int 0x80

    cmp byte [char], ' '
    jne _start

mov eax, 1
mov ebx, 0
int 0x80
