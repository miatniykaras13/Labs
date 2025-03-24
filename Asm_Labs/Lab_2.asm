;12 - (96385 + x - y) - z + 3698
masm    
model small
.386
.stack 100h
.data
x db 0
y dw 0
z db 0
result dd ?
.code
start:
    mov ax, @data  ; стандартное начало программы
    mov ds, ax

    ; 96385 = 0x17801
    mov bx, 7801h  ; младшая часть 96385
    mov dx, 1h     ; старшая часть 96385

    mov al, x      ; x
    cbw            ; расширение знака AL в AX
    add bx, ax     ; 96385 + x
    adc dx, 0      ; проверка переноса

    mov ax, y      ; y
    sub bx, ax     ; 96385 + x - y
    sbb dx, 0      ; проверка заема

    mov al, z      ; z
    cbw            ; расширение знака AL в AX
    add bx, ax     ; 96385 + x - y - z
    adc dx, 0      ; проверка заема

    sub bx, 0E72Ah ; вычитание 3698 (0xE72A)
    sbb dx, 0      ; проверка заема

    neg bx         ; смена знака
    neg dx
    sbb dx, 0      ; проверка заема

    add bx, 0Ch    ; добавление 12
    adc dx, 0      ; проверка переноса

    ; результат в bx:d

    mov [ds:1000h], bx ; сохранение результата
    mov [ds:1002h], dx
    mov ax, 4c00h  ; стандартное завершение программы
    int 21h
end start