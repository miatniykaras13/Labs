masm
.model small
.386
.stack 100h
;f = (12 - 96385) * x / (y - 3698)
.data
    x dw 123  

.code
start:
    
    x = x-2
    
    mov ax, 4C00h
    int 21h
end start