section .data
n: db 0
star: db '*'
eol: db 10

section .text
global _start
_start:

    mov eax, 3 ; syscall read
    mov ebx, 0 ; STDIN
    mov ecx, n
    mov edx, 1 ; on lit 1 octet seulement
    int 0x80

    sub byte [n], '0' ; [n] a reçu une string qui contient un chiffre. On convertit la string en chiffre en soustrayant le code ASCII de 0.

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
