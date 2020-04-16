section .data
i: dd 0 ; 32 bits car on ne sait pas jusqu'où on va
n: dd 17
charac: dd 0
eol: db 0


section .text
global _start
_start:

; cas particulier où n = 0 : ne pas décrémenter i qui vaut déjà 0.
mov eax, 0
cmp dword [n], 0
je fin_boucle

boucle:
    mov eax, [i]
    mul eax ; multiplie eax par l'argument (ici eax). Stocke les 32 bits faibles dans eax, les 32 bits forts dans edx.
    cmp [n], eax
    jb fin_boucle
    
    inc dword [i]
    jmp boucle

fin_boucle:
    mov eax, [i]
    dec eax
    call EcrireNombre

    mov eax, 4
    mov ebx, 1
    mov ecx, eol
    mov edx, 1
    int 0x80

    mov eax, 1
    mov ebx, 0
    int 0x80

; reprise du code précédemment écrit
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
