;12 - (96385 + x - y) - z + 3698
masm    
model small
.386
.stack 100h
.data
      x      dw 0
      y      dw 0
      z      dw 0
      result dd ?
.code
      start:
            mov ax, @data
            mov ds, ax

      ; 96385 = 0x17801
            mov bx, 7881h                      ; младшая часть 96385
            mov dx, 1h                         ; старшая часть 96385

            mov ax, x
      
            add bx, ax                         ; 96385 + x
            adc dx, 0                          ; проверка

            mov ax, y
            sub bx, ax                         ; 96385 + x - y
            sbb dx, 0                          ; проверка

            neg bx                             ; смена знака
            neg dx
            sbb dx, 0                          ; проверка

            mov ax, z
            
            sub bx, ax                         ; 96385 + x - y - z
            sbb dx, 0                          ; проверка

            add bx, 0E72h                      ; вычитание 3698 (0xE72A)
            adc dx, 0                          ; проверка заема


            add bx, 0Ch                        ; добавление 12
            adc dx, 0                          ; проверка переноса

            mov word ptr [result], bx
            mov word ptr [result + 2], dx

      ; перемещение результата по адресу 1000h
            mov [ds:1000h], bx
            mov [ds:1002h], dx
   

            mov ax, 4c00h
            int 21h

end start