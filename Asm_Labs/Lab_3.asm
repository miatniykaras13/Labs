;(12 - 96385) * x / (y - 3698)
masm    
model small
.386
.stack 100h
.data
    x      dd 1
    y      dd 0
    z      dd 0
    result dd ?
.code
    start:
          mov  ax, @data
          mov  ds, ax

    ; 96385 = 0x17881
          mov  ebx, 17881h
    ; EBX = 96385

          sub  ebx, 0Ch
    ; EBX = -12 + 96385

          mov  eax, x
          imul ebx                        ; EAX = -(12 - 96385) * x

          mov  ebx, y
          sub  ebx, 0E72h
          neg  ebx                        ; EBX = -y + 3698
                        
          idiv ebx                        ; EAX = (12 - 96385) * x / (y - 3698)

          mov  dword ptr [result], eax    ; Сохраняем результат в result   ; Сохраняем результат в result

    ; перемещение результата по адресу 1000h
          mov  [ds:1000h], ax             ; Сохраняем младшее слово результата
          mov  [ds:1002h], dx             ; Сохраняем старшее слово результата

          mov  ax, 4c00h
          int  21h

end start