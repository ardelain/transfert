section .data
star: db '*'
eol: db 10
n: dd 5 ; on utilise dd parce que qu'on push n sur la stack, or push ne prend que des variables de 32 bits (optionnellement 16). Il est donc plus simple de travailler directement en mettant n sur 32 bits

section .text
global _start
_start:
    mov ecx, [n]

    boucle_ligne: ; une itération de la boucle affiche une ligne complète
        push ecx

        mov ecx, [n] ; [boucle_carac]: on initialise le compteur à n
        boucle_carac:
            push ecx ; [boucle_carac]: on sauvegarde le compteur

            mov eax, 4
            mov ebx, 1
            mov ecx, star
            mov edx, 1
            int 0x80

            pop ecx ; on récupère le compteur
        loop boucle_carac ; on boucle si le compteur ne vaut pas 0

        mov eax, 4
        mov ebx, 1
        mov ecx, eol
        mov edx, 1
        int 0x80

        pop ecx
    loop boucle_ligne

fin:
    mov eax, 1
    mov ebx, 0
    int 0x80
