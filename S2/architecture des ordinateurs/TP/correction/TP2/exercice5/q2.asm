section .data
charac: db 0

section .text
global _start
_start:
    mov eax, 0b10101010101010101010101010101010

    shr eax, 23
    mov ebx, 0b011111111 ; masque qui permet de mettre le bit de poids 9 de eax à 0
    and eax, ebx
    
    ; On obtient l'exposant non-renormalisé
    ; cf. https://fr.wikipedia.org/wiki/IEEE_754#Format_simple_pr%C3%A9cision_(32_bits)
    ; Puis on l'affiche

    call EcrireNombre

    mov eax, 1
    mov ebx, 0
    int 0x80

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

