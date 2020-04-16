section .data

n: dd 5
star: db '*'
p: db '.'
eol: db 10
i: db 1

section .text
global _start
_start:
boucle:
    mov eax, [n] 
    cmp eax, 0
    je fin_boucle 
    mov ebx ,1
    mov [i], ebx

    call aff
    dec byte [n] ; on décrémente n


aff :
        mov ebx,[i]
        cmp eax, ebx
        je etoile

        mov eax, 4
        mov ebx, 1
        mov ecx, p
        mov edx, 1
        int 0x80 ;

        inc byte [i]
        jmp aff

etoile :
        mov eax, 4
        mov ebx, 1
        mov ecx, star
        mov edx, 1
        int 0x80 ; une étoile

        mov eax, 4
        mov ebx, 1
        mov ecx, eol
        mov edx, 1
        int 0x80 ; retour à la ligne

fin_boucle:
    mov eax, 1
    mov ebx, 0
    int 0x80 ; return 0
