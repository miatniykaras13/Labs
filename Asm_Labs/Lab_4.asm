masm
.model small
.386
.stack 100h
;f = (12 - 96385) * x / (y - 3698)
.data
    x db 0
    y db 0       
    result dd ?   

.code
start:
    mov ax, @data
    mov ds, ax

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

    mov [ds:1000h], eax
    
    
    mov ax, 4C00h
    int 21h
end start