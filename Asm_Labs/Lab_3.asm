masm
.model small
.386
.stack 100h
;f = (12 - 96385) * x / (y - 3698)
.data
    x db ?
    y db ?       
    result dd ?  
    strokaX db 'Input x: ',  '$'
    strokaY db 0Dh, 0Ah, 'Input y: ',  '$'
    strokaRes db 0Dh, 0Ah, 'Result: $'
.code
start:
    mov ax, @data
    mov ds, ax

    lea dx, strokaX
    mov ah, 09h
    int 21h

    mov ah, 01h
    int 21h
    sub al, '0'
    mov x, al

    lea dx, strokaY
    mov ah, 09h
    int 21h

    mov ah, 01h
    int 21h
    sub al, '0'
    mov y, al

    mov ax, 12
    cbw
    sub eax, 96385

    mov ebx, eax

    mov al, x
    cbw

    imul ebx, eax


    mov al, y
    cbw 

    sub eax, 3698
    xchg eax, ebx
    idiv ebx

    mov result, eax

    lea dx, strokaRes
    mov ah, 09h
    int 21h

    

    mov ax, 4C00h
    int 21h

end start