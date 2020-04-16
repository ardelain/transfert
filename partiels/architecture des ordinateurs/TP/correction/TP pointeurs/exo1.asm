section .data

text: db 'Hello World!'
size: equ $ - text

char: db 0
i: dd 0

section .text
global _start
_start:
loop:
    cmp dword [i], size
    jae end_loop

    ; on récupère le caractère d'offset i
    mov ebx, [i]
    mov al, [text+ebx] ; on ne peut pas directement faire [text+i], donc on adapte
    mov [char], al

    cmp byte [char], 'a'
    jb print_char
    cmp byte [char], 'z'
    ja print_char

    sub byte [char], 32 ; le code ASCII d'une majuscule correspond au code ASCII de la minuscule moins 32

    print_char:    
        mov eax, 4
        mov ebx, 1
        mov ecx, char
        mov edx, 1
        int 0x80

    inc dword [i]
    jmp loop

end_loop:
    mov eax, 1
    mov ebx, 0
    int 0x80

