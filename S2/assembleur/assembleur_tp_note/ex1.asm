section .data

char: db 0
i: dd 0

section .text
global _start
_start:
    mov eax, 2 ;a
    mov ebx, 5 ;n
    mov ecx, eax

    loop:
        cmp ebx, 0
        je end_loop
        imul eax,ecx
        sub ebx,1
        jmp loop


end_loop:
    mov [char], eax
    add byte [char], '0' ;
    mov eax, 4
    mov ebx, 1
    mov ecx, char
    mov edx, 1
    int 0x80 ;

    mov eax, 1
    mov ebx, eax
    int 0x80

