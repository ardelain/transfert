section .data

text: db 'HLe fils fait la guerre!'
size: equ $ - text

char: db 0
i: dd 0
k: dd 3
charac: dd 0
eol: db 0

nb_mot: db 0
nb_mot_lu: db 0

section .text
global _start
_start:

loop:
    mov edx,0
    cmp dword [i], size
    jae end_loop

    mov ebx, [i]
    mov al, [text+ebx]
    mov [char], al

    cmp byte [char], ' '
    je inc_nb_mot

    cmp [nb_mot],k
    je affichage

    inc dword [i]
    jmp loop

inc_nb_mot:
    inc byte [nb_mot],1
    push -1
    ret

affichage:
        mov [char], eax
        add byte [char], '0' ;

        mov eax, 4
        mov ebx, 1
        mov ecx, charac
        mov edx, 1
        int 0x80

        pop eax ; On passe au chiffre à afficher suivant
        cmp eax, -1
        jne affichage ; si on arrive sur -1 c'est qu'on a épuisé toute la stack, car on est arrivé au -1 stocké en début de programme

print_char_av:
    

end_loop:
    mov eax, 1
    mov ebx, 0
    int 0x80

