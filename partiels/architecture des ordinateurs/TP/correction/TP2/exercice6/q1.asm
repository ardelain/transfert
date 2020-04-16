section .data
charac: db 0

section .text
global _start

; Note: par convention les valeurs de retour sont habituellement
; stockées dans eax, tout comme les paramètres d'appel de fonction.
; Par souci de clarté on stocke ici la valeur de retour dans ebx
_start:
    mov eax, 5
    call factorielle
    mov eax, ebx
    call EcrireNombre

    mov eax, 1
    mov ebx, 0
    int 0x80

; fonctionne tant que les nombres sont inférieurs à 32 bits
; (l'overflow n'est pas géré)
factorielle:
    cmp eax, 0
    je fin_factorielle

    dec eax
    push eax ; On stocke eax avant l'appel récursif
    call factorielle ; calcul de (n-1)!
    pop eax ; On récupère eax après l'appel récursif
    inc eax
    mul ebx ; on multiplie eax (n) avec ebx (n-1)!

    mov ebx, eax ; on met le résultat dans ebx
    ret

fin_factorielle:
    mov ebx, 1
    ret

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

