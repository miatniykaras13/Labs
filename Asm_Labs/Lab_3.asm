masm
.model small
.386
.stack 100h
;f = (12 - 96385) * x / (y - 3698)
.data
    x         db ?
    y         db ?
    result    dd ?
    strokaX   db 'Input x: ',  '$'
    strokaY   db 0Dh, 0Ah, 'Input y: ',  '$'
    strokaRes db 0Dh, 0Ah, 'Result: $'
.code
    start:
          mov  ax, @data
          mov  ds, ax


          mov  ax, 12
          cbw
          sub  eax, 96385

          mov  ebx, eax

          mov  al, x
          cbw

          imul ebx, eax


          mov  al, y
          cbw

          sub  eax, 3698
          xchg eax, ebx
          idiv ebx


          mov  ax, 4C00h
          int  21h

end start