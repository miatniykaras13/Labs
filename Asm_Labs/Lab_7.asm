masm
model small 
.386
.stack 128
.data
    len      equ 10                                                                                                 ;количество элементов в mas
    mas      dd  53434532,-500000000,62346345,-500000000,62363246,-600000000,6456435,-34000000,-2100000000,53232
    filename db  'output.txt', 0
    buffer   db  20 dup(0)
    rez      dq  ?
.code
    start:   
             mov  ax,@data
             mov  ds,ax

             lea  dx, filename
             mov  ah, 3Ch                     ; Функция DOS: создать файл
             mov  cx, 0                       ; Атрибуты файла (обычный файл)
             int  21h

             mov  cx,len                      ; количество элементов в массиве в cx
             xor  ax,ax
             xor  si,si
             mov  ah, 3Eh                     ; Функция DOS: закрыть файл
             int  21h                         ; регистр si - индекс i, нумерация с 0
             jcxz exit                        ;проверка cx на 0, если 0 (все элементы просмотрели), то на выход
    cycl:    
             cmp  mas[si], 0                  ;сравнить очередной элемент mas с 0
             jge  m1                          ;если не равно, то на m1
             add  eax, mas[si]
             jo   overflow
             jmp  m1
    overflow:
             add  edx, 1
    m1:      
             add  si, 4                       ;перейти к следующему элементу i:=i+1
             loop cycl
             neg  edx
             mov  dword ptr [rez], eax
             mov  dword ptr [rez + 4], edx
    exit:    
             mov  ax,4c00h
             int  21h                         ;возврат управления операционной системе
end	start
