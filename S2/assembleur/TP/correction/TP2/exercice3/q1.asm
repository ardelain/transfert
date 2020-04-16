section .data
n: db 5
star: db '*'
eol: db 10

section .text
global _start
_start:
boucle:
    mov cl, [n] ; cl parce que n fait 1 octet (8 bits)
    cmp cl, 0
    je fin_boucle ; on sort de la boucle si n vaut 0

    dec byte [n] ; on décrémente n

    mov eax, 4
    mov ebx, 1
    mov ecx, star
    mov edx, 1
    int 0x80 ; on affiche une étoile

    jmp boucle

fin_boucle:
    mov eax, 4
    mov ebx, 1
    mov ecx, eol
    mov edx, 1
    int 0x80 ; retour à la ligne

    mov eax, 1
    mov ebx, 0
    int 0x80 ; return 0
