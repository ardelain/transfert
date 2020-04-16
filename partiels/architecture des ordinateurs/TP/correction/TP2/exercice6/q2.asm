section .data
charac: dd 0
eol: db 10

section .text
global _start

_start:
    mov eax, 6
    call fibo
    call EcrireNombre

    mov eax, 4
    mov ebx, 1
    mov ecx, eol
    mov edx, 1
    int 0x80

    mov eax, 1
    mov ebx, 0
    int 0x80

fibo:
    ; on a n dans eax
    cmp eax, 1
    jbe fin_fibo ; F(0) et F(1) sont les cas terminaux de notre récursivité

    dec eax
    push eax ; on conserve n-1 dans la stack

    call fibo ; on calcule F(n-1), la valeur est stockée dans eax

    pop ebx ; on récupère n-1 dans ebx
    
    push eax ; on stocke F(n-1) dans la stack
    dec ebx
    mov eax, ebx ; on place n-2 en argument pour fibo
    call fibo ; on calcule F(n-2)

    pop ebx ; on récupère F(n-1)

    add eax, ebx ; on calcule F(n-1) + F(n-2) qu'on stocke dans eax

    ret


fin_fibo:
    mov eax, 1
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

