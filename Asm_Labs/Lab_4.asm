masm
model small
.386
.stack 100h
.data
    sign   db ?
    s      dd 0
    x      dd ?
    y      dd ?
    f      dd ?
    height dd 0
    vivod  db '(8735 * 588) - X + (Y / 12)', 10, 13, '$'
    str1   db '          $'
    k      dw 0
    ress   dd ?
.code
    start:      
                mov  ax, @data
                mov  ds, ax
                mov  ah, 09h
                mov  dx, offset vivod    ; вывод
                int  21h
                xor  eax, eax            ; обнуление регистров
                xor  ebx, ebx
                xor  ecx, ecx
                xor  edx, edx

    ; Ввод X
                mov  ah, 01h
                int  21h
                cmp  al, '-'             ; проверка на отрицательное число
                jne  coninput1
                mov  sign, 1

                mov  ah, 01h
                int  21h

    coninput1:  
                sub  al, 30h             ; преобразование символа в число
                mov  ah, 0
                mov  ebx, 10
                mov  ecx, eax

    ; Начало цикла ввода X
    FirstInput: 
                xor  eax, eax
                mov  ah, 01h             ; считывание числа
                int  21h
                cmp  al, 0dh             ; проверка на Enter
                je   EndFirst            ; переход к завершению ввода
                sub  al, 30h
                cbw                      ; расширение до 16 бит
                cwde                     ; расширение до 32 бит
                xchg eax, ecx
                mul  ebx                 ; умножение числа на 10
                add  ecx, eax
                jmp  FirstInput
 
    EndFirst:   
                cmp  sign, 1
                jne  final1
                neg  ecx                 ; изменение знака

    final1:     
                mov  X, ecx

    ; Сбросим знак для Y
                mov  sign, 0

    ; Ввод Y
                mov  ah, 01h
                int  21h
                cmp  al, 2Dh
                jne  coninput2
                mov  sign, 1

                mov  ah, 01h
                int  21h

    coninput2:  
                sub  al, 30h
                mov  ah, 0
                mov  ebx, 10
                mov  ecx, eax

    ; Начало цикла ввода Y
    SecondInput:
                mov  ah, 01h
                int  21h
                cmp  al, 0dh
                je   EndSecond
                sub  al, 30h
                cbw
                cwde
                xchg eax, ecx
                mul  ebx
                add  ecx, eax
                jmp  SecondInput

    EndSecond:  
                cmp  sign, 1
                jne  final2
                neg  ecx


    final2:     
    ; Умножаем 8735 на 588
                mov  eax, 8735
                mov  ebx, 588
                imul ebx                 ; Умножение eax (8735) на ebx (588)
    
    ; Извлекаем x
                sub  eax, x              ; height = height - x

    ; Делим y на 12
                mov  height, eax
                xor  eax, eax
                mov  eax, y              ; Загружаем y в eax (обратите внимание на квадратные скобки)
                mov  ecx, 12             ; Делитель
                xor  edx, edx            ; Обнуляем edx перед делением
                idiv ecx                 ; Делим eax на ecx, результат в eax, остаток в edx

    ; Добавляем результат деления к height
                add  height, eax         ; height = height + (y / 12)

                mov  eax, [height]       ; Загружаем результат в eax
    ; Сохраняем результат в переменную result
                mov  f, eax              ; Сохраняем результат в f
    ; Вывод результата
                xor  edx, edx
                push -1

                mov  eax, f
                cmp  eax, 0
                jnl  cont
                mov  ecx, eax
                mov  ah, 02h
                mov  dl, '-'
                int  21h
                mov  eax, ecx
                neg  eax

    cont:       
                mov  ebx, 10

    cont2:      
                mov  edx, 0
                div  ebx
                push edx
                cmp  eax, 0
                jne  cont2

    NumOut:     
                pop  edx
                cmp  dx, -1
                je   exit
                add  dl, 30h
                mov  ah, 02h
                int  21h
                jmp  NumOut

    ; Завершение программы
    exit:       
                mov  ax, 4c00h
                int  21h
end start

