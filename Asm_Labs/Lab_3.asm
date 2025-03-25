;(12 - 96385) * x / (y - 3698)
masm    
model small
.386
.stack 100h
.data
    x      db 1
    y      db 0
    z      db 0
    result dd ?
.code
    start:
          mov   ax, @data
          mov   ds, ax

    ; 96385 = 0x17881
          mov   ebx, 17881h
          neg   ebx

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

end start