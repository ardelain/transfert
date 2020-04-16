section .data

table: db 'Hello', 3
size: equ $ - table

char: db 0

section .text
global _start
_start:
    mov al, [table]; on instancie le minimum avec le premier élément de la table
    mov ebx, 0 ;offset
    
find_minimum:
.loop:
    cmp ebx, size
    jae subtract

    cmp al, [table+ebx]
    jb .no_update ; Si le caractère n'est pas < minimum on ne fait rien

    mov al, [table+ebx]
    .no_update:

    inc ebx
    jmp .loop


subtract:
    mov ebx, 0
    
.loop:
    cmp ebx, size
    jae end_loop

    sub [table+ebx], al ; on soustrait la valeur
    
    ; et on affiche pour vérifier que tout fonctionne
    push eax
    mov dl, [table+ebx]
    push ebx
    mov eax, 4
    mov ebx, 1
    mov [char], dl
    mov ecx, char
    mov edx, 1
    int 0x80 

    pop ebx
    pop eax 
    inc ebx
    jmp .loop


end_loop:
    mov eax, 1
    mov ebx, 0
    int 0x80
