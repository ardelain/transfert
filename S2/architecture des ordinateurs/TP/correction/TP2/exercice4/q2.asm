section .data
i: dd 2 ; on commence à diviser par 2
notPrime: db 'Not prime', 10
np_size: equ $ - notPrime

prime: db 'Prime', 10
p_size: equ $ - prime

charac: db 0
integer: dd 0

overflow_msg: db 'Overflow', 10
size_overflow: equ $ - overflow_msg


section .text
global _start
_start:
call LireNombre
mov ecx, eax ; ecx n'est pas utilisé par le reste du programme donc on stocke le nombre ici

boucle:    
    mov edx, 0
    div dword [i] ; on divise edx:eax par [i], quotient dans eax et reste edx.
    mov eax, ecx ; on réinitialise eax à n

    cmp edx, 0
    je fin_boucle

    inc dword [i]

    cmp [i], ecx
    jae is_prime ; i = n on n n'a pas de diviseur

    jmp boucle

fin_boucle:
    mov eax, 4
    mov ebx, 1
    mov ecx, notPrime
    mov edx, np_size
    int 0x80

    jmp end

is_prime:
    mov eax, 4
    mov ebx, 1
    mov ecx, prime
    mov edx, p_size
    int 0x80

end:
    mov eax, 1
    mov ebx, 0
    int 0x80

; reprise du code des questions precedentes
LireNombre:
boucle_lireNombre:
    mov eax, 3
    mov ebx, 0
    mov ecx, charac
    mov edx, 1
    int 0x80

    sub byte [charac], '0' ; Conversion ASCII -> chiffre

    cmp byte [charac], 0
    jb fin_boucle_lireNombre
    cmp byte [charac], 9
    ja fin_boucle_lireNombre


    mov eax, [integer]
    mov ebx, 10
    mul ebx ; on multiplie eax par 10

    ; on vérifie que la multiplication ne fait pas dépasser les 32 bits de eax
    ; (donc on regarde s'il y a une retenue dans edx)
    cmp edx, 0
    jne overflow

    xor ebx, ebx
    mov bl, [charac] ; Conversion de [charac] en entier 32 bits

    add eax, ebx ; on rajoute [charac] à eax

    ; on verifie que l'addition ne provoque pas d'overflow
    ; (on vérifie donc que le carry flag est à 0)
    jo overflow ; jo active le jump si l'opération précédente a produit un overflow

    mov [integer], eax

    jmp boucle_lireNombre

fin_boucle_lireNombre:
    mov eax, [integer]
    ret

overflow:
    mov eax, 4
    mov ebx, 1
    mov ecx, overflow_msg
    mov edx, size_overflow
    int 0x80

    mov eax, 1
    mov ebx, 0
    int 0x80

