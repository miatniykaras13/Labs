masm
.model small
.386
.stack 100h
 ;12 - (96385 + x-y) - z + 3698
.data
    x      db 0
    y      db 0
    z      db 0
    result dd ?

.code
    start:
          mov ax, @data
          mov ds, ax

          mov al, x
          cbw

          add eax, 96385

          mov ebx, eax

          mov al, y
          cbw
          sub ebx, eax

          mov ax, 12
          cbw

          sub eax, ebx
          mov ebx, eax

          mov al, z
          cbw

          sub ebx, eax

          mov ax, 3698

          sub ebx, eax


          mov ds:1000h, ebx
    
    
          mov ax, 4C00h
          int 21h
end start