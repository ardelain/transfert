section .data

table: db 'abcdefghi'
size: equ $ - table

output: times size db 0 ; initialisation du tableau de retour

section .text
global _start

_start:
    mov ecx, 0 ; compteur
    
.loop:
    cmp ecx, size / 2
    jae .end_loop
    
    ; ajout du premier caractère
    mov al, [table+ecx]
    mov [output+2*ecx], al
    
    ; ajout du second caractère
    ; NASM ne comprend pas les adresses concrètes avec les symboles
    ; on calcule donc d'abord l'adresse dans un registre
    ; on calcule ebx = table + size - 1 - ecx
    mov ebx, table
    add ebx, size-1
    sub ebx, ecx

    mov al, [ebx]
    mov [output+2*ecx+1], al

    inc ecx
    jmp .loop

.end_loop:
    ; on regarde si size % 2 == 0
    ;mov bl, size
    ;cmp bl, 1
    ;jnp end
    mov ebx, size
    and ebx, 1
    cmp ebx, 0
    jz end

    mov al, [table+ecx]
    mov [output+2*ecx], al

end:
mov ecx, 0
.loop:
    cmp ecx, size
    jae .end_loop

    mov eax, output
    add eax, ecx ; on sauvegarde l'adresse du caractère à afficher (output+ecx)
    push ecx
    mov ecx, eax
    mov eax, 4
    mov ebx, 1
    mov edx, 1
    int 0x80

    pop ecx
    inc ecx
    jmp .loop

.end_loop:
    mov eax, 1
    mov ebx, 0
    int 0x80
