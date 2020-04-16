section .data

carac: db 0
table: times 20 db 0
current_offset: db 0

section .text
global _start

_start:
.loop:
    mov eax, 3
    mov ebx, 1
    mov ecx, carac
    mov edx, 1
    int 0x80

    cmp byte [carac], 10 ; 10: retour à la ligne
    je end_message

    ; si pas un retour à la ligne, on rajoute au tableau
    ; on calcule l'offset
    xor ecx, ecx
    mov cl, [current_offset]
    add ecx, table

    ; et on rajoute l'élément dans le tableau
    mov al, [carac]
    mov [ecx], al

    ; on incrémente le compteur
    inc byte [current_offset]
    cmp byte [current_offset], 20
    jb .no_update
        ; ici on sait que [current_offset] == 20
        ; on le remet à zéro 
        mov byte [current_offset], 0
    
    .no_update:
    jmp .loop

end_message:
    ; on tient à jour un compteur annexe
    mov ecx, 0
    push ecx

    .loop:
    pop ecx
    cmp ecx, 20
    jae end
    
    inc ecx
    push ecx

    mov eax, 4
    mov ebx, 1
    xor ecx, ecx
    mov cl, [current_offset]
    add ecx, table
    mov edx, 1
    int 0x80

    inc byte [current_offset]
    cmp byte [current_offset], 20
    jb .no_update
        mov byte [current_offset], 0
    .no_update:
    jmp .loop

end:
    mov eax, 1
    mov ebx, 0
    int 0x80
