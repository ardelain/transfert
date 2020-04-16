section .data
positif: db 'positif', 10
size_positif: equ $ - positif

negatif: db 'negatif', 10
size_negatif: equ $ - negatif

section .text
global _start
_start:
    ; eax contient un nombre au format IEEE 754 simple
    ; 1 bit de signe, 8 bits d'exposant, 21 bits de mantisse
    ; le bit de signe est le bit de poids fort
    mov eax, 0b11010110101010101010101010101010

    shr eax, 31
    cmp eax, 1
    je nb_negatif

    mov eax, 4
    mov ebx, 1
    mov ecx, positif
    mov edx, size_positif
    int 0x80

    jmp end

nb_negatif:
    mov eax, 4
    mov ebx, 1
    mov ecx, negatif
    mov edx, size_negatif
    int 0x80

end:
    mov eax, 1
    mov ebx, 0
    int 0x80
