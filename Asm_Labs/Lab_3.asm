;(12 - 96385) * x / (y - 3698)
masm    
model small
.386
.stack 100h
.data
<<<<<<< HEAD
    x      db 1
    y      db 0
    z      db 0
    result dd ?
.code
    start:
          mov   ax, @data
          mov   ds, ax
=======
    x db ?
    y db ?       
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

    imul ebx

;edx
    mov al, y
    cbw 

    sub eax, 3698
    xchg eax, ebx
    idiv ebx
>>>>>>> 7d76b63e777834756c19321a64dd4b95af33189c

    ; 96385 = 0x17881
          mov   ebx, 17881h
          neg   ebx

<<<<<<< HEAD
          add   ebx, 0Ch                 ; 12 - 96385

          mov   al, x
          cbw
          imul  ebx                      ; (12 - 96385) * x

          mov   bl, y
          movsx ebx, bl
          sub   ebx, 0E72h               ; y - 3698

          neg   ebx
          neg   eax
          mov   edx, 0
          idiv  ebx

          mov   word ptr [result], ax

    ; перемещение результата по адресу 1000h
          mov   [ds:1000h], bx
          mov   [ds:1002h], dx


          mov   ax, 4c00h
          int   21h
=======
    

    mov ax, 4C00h
    int 21h
>>>>>>> 7d76b63e777834756c19321a64dd4b95af33189c

end start