masm
model small
.386
.stack 100h
.data
    message1 db '(12 - 96385) * x / (y - 3698)', 13,10,'$'
    message2 db 13,10,'Input x: $'
    message3 db 13,10,'Input y: $'
    message4 db 13,10,'Result: $'

    x        dd ?
    y        dd ?
    result   dd ?
.code
    start:          
                    mov   ax,@data
                    mov   ds,ax
    ;(12 - 96385) * x / (y - 3698)

                    mov   dx,offset message1         ;(12 - 96385) * x / (y - 3698)
                    call  PrintStr

                    mov   dx, offset message2        ;input x
                    call  PrintStr
                    call  Input
                    mov   x,ecx
        
                    mov   dx, offset message3        ;input y
                    call  PrintStr
                    call  Input
                    mov   y,ecx

                    mov   dx, offset message4
                    call  PrintStr


    ; 96385 = 0x17881
                    mov   ebx, 17881h
    ; EBX = 96385

                    sub   ebx, 0Ch
    ; EBX = -12 + 96385

                    mov   eax, x
                    imul  ebx                        ; EAX = -(12 - 96385) * x

                    mov   ebx, y
                    sub   ebx, 0E72h
                    neg   ebx                        ; EBX = -y + 3698
                        
                    idiv  ebx                        ; EAX = (12 - 96385) * x / (y - 3698)

                    mov   dword ptr [result], eax    ; Сохраняем результат в result
             
                    mov   result, eax
                    call  PrintInt
             

                    mov   ax,4c00h
                    int   21h

PrintStr proc
                    mov   ah, 09h
                    int   21h
                    ret
PrintStr endp

Input proc
                    xor   eax,eax
                    xor   ecx, ecx
                    mov   ah, 01h
                    int   21h
                    cmp   al, '-'
                    jne   positive
                    je    negative
             
    negative:       
                    xor   al,al
                    mov   ah, 01h
                    int   21h
                    sub   al, '0'
                    cbw
                    mov   ebx, 10
                    mov   ecx, eax

    convertNegative:
                    xor   eax,eax
                    mov   ah, 01h
                    int   21h
                    cmp   al,0dh
                    je    endingNegative
                    sub   al,'0'
                    cbw
                    xchg  eax,ecx
                    mul   ebx
                    add   ecx, eax
                    jmp   convertNegative

    positive:       
                    sub   al, '0'
                    cbw
                    mov   ebx, 10
                    mov   ecx, eax

    convertPositive:
                    xor   eax,eax
                    mov   ah, 01h
                    int   21h
                    cmp   al,0dh
                    je    endingPositive
                    sub   al,'0'
                    cbw
                    xchg  eax,ecx
                    mul   ebx
                    add   ecx, eax
                    jmp   convertPositive

    endingPositive: 
                    ret

    endingNegative: 
                    mov   y,ecx
                    neg   y
                    mov   ecx,y
                    ret
Input endp

PrintInt proc
                    xor   ecx, ecx                   ; Сбрасываем счетчик символов
                    mov   ebx, 10                    ; Основание системы счисления (десятичная)
                    mov   eax, result                ; Загружаем результат для вывода
    
                    cmp   eax, 0                     ; Проверяем знак числа
                    jge   convertLoop
                    xor   eax, eax                   ; Если число >= 0, пропускаем обработку знака
                    mov   ah, 02h                    ; DOS-функция вывода символа
                    mov   dl, '-'
                    movzx edx, dl                    ; Выводим знак "-"
                    int   21h
                    mov   eax, result
                    neg   eax                        ; Берем модуль числа


    convertLoop:    
                    xor   dx, dx
                    div   ebx                        ; Делим EAX на 10, остаток в DL
                    add   dl, '0'                    ; Преобразуем остаток в ASCII-символ
                    push  dx                         ; Сохраняем символ в стеке
                    inc   cx                         ; Увеличиваем счетчик символов
                    cmp   eax, 10                    ; Проверяем, деление завершено
                    jge   convertLoop
                    add   al, '0'                    ; Преобразуем остаток в ASCII-символ
                    push  ax
                    inc   cx                         ; Если EAX != 0, продолжаем деление

    printLoop:      
                    pop   dx                         ; Извлекаем символ из стека
                    mov   ah, 02h                    ; DOS-функция вывода символа
                    int   21h
                    loop  printLoop                  ; Повторяем, пока CX > 0

                    ret                              ; Возврат из процедуры
PrintInt endp
end start
