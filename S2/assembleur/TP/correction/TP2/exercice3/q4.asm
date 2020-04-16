section .data
charac: dd 0 ; dd car on push cette variable sur la stack.
eol: db 10

section .text
global _start

; TODO pour l'étudiant curieux : faire fonctionner ce code pour afficher des nombres négatifs.
; Il faudra notamment se renseigner sur idiv et imul
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


_start:
    mov eax, 123456
    call EcrireNombre

    mov eax, 4
    mov ebx, 1
    mov ecx, eol
    mov edx, 1
    int 0x80
    
    mov eax, 1
    mov ebx, 0
    int 0x80


