section .data

table: db 'teststring'
n: equ $ - table

section .text
global _start
_start:
mov al, 0
.loop_i: ; i est implémenté avec al
    cmp al, n
    jae .end_loop_i

    mov ebx, 1 ; j est stocké dans ebx (taille 32 bits pour les offsets)
    .loop_j:
    mov ecx, n
    sub ecx, eax
    cmp ebx, ecx ; j n'a pas besoin d'aller au dela de n-i-1
    jae .end_loop_j

        ;on place [table + ebx] dans cl pour pouvoir utiliser cmp
        mov cl, [table + ebx]
        cmp cl, [table + ebx - 1]
        jae .no_swap ; si t[j] > t[j-1] il n'y a rien à faire

            ; on met t[j-1] dans t[j]
            mov dl, [table + ebx-1]
            mov [table + ebx], dl

            mov [table + ebx - 1], cl ; on met t[j] dans t[j-1]

        .no_swap:
        inc ebx
    jmp .loop_j

    .end_loop_j:
    inc al
jmp .loop_i

.end_loop_i:
 mov eax, 0
.loop_print:
    cmp eax, n
    jae end_print
    
    mov ecx, table
    add ecx, eax
    push eax
    mov eax, 4
    mov ebx, 1
    mov edx, 1
    int 0x80

    pop eax
    inc eax
    jmp .loop_print

end_print:
    mov eax, 1
    mov ebx, 0
    int 0x80
