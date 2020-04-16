; Pour cette quesiton, le plus simple
; est encore d'implémenter a) b) c) l'un
; après l'autre.

section .data
charac: db 0
integer: dd 0 ; 32 bits

overflow_msg: db 'Integer is too big, aborting'
size_overflow: equ $ - overflow_msg

section .text
global _start
_start:
    call LireNombre
    call EcrireNombre

    mov eax, 1
    mov ebx, 0
    int 0x80


LireNombre:
boucle_lireNombre:
    mov eax, 3
    mov ebx, 0
    mov ecx, charac
    mov edx, 1
    int 0x80

    sub byte [charac], '0' ; Conversion ASCII -> chiffre

    cmp byte [charac], 0
    jb fin_boucle_lireNombre
    cmp byte [charac], 9
    ja fin_boucle_lireNombre
    

    mov eax, [integer]
    mov ebx, 10
    mul ebx ; on multiplie eax par 10

    ; on vérifie que la multiplication ne fait pas dépasser les 32 bits de eax
    ; (donc on regarde s'il y a une retenue dans edx)
    cmp edx, 0
    jne overflow

    xor ebx, ebx
    mov bl, [charac] ; Conversion de [charac] en entier 32 bits

    add eax, ebx ; on rajoute [charac] à eax

    ; on verifie que l'addition ne provoque pas d'overflow
    ; (on vérifie donc que le carry flag est à 0)
    jo overflow ; jo active le jump si l'opération précédente a produit un overflow

    mov [integer], eax
    
    jmp boucle_lireNombre

fin_boucle_lireNombre:
    mov eax, [integer]

overflow:
    mov eax, 4
    mov ebx, 1
    mov ecx, overflow_msg
    mov edx, size_overflow
    int 0x80

    mov eax, 1
    mov ebx, 0
    int 0x80

; reprise du code des questions précédentes
EcrireNombre:
    push -1 ; On définit un point d'arrêt sur la stack

    cmp eax, 9
    jbe affichage

    division:
        mov edx, 0
        mov ecx, 10
        div ecx ; Divise edx:eax par 10. Stocke le quotient dans eax et le reste dans edx.

        push edx ; On sauvegarde le reste

        cmp eax, 9
        ja division

    affichage:
        mov [charac], eax
        add byte [charac], '0' ; on transforme le nombre en son code ASCII

        mov eax, 4
        mov ebx, 1
        mov ecx, charac
        mov edx, 1
        int 0x80

        pop eax ; On passe au chiffre à afficher suivant
        cmp eax, -1
        jne affichage ; si on arrive sur -1 c'est qu'on a épuisé toute la stack, car on est arrivé au -1 stocké en début de programme

    ret

