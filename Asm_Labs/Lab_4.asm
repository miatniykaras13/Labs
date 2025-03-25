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
    f        dd ?
.code
    start:          
                    mov  ax,@data
                    mov  ds,ax
    ;(12 - 96385) * x / (y - 3698)

                    mov  dx,offset message1     ;(12 - 96385) * x / (y - 3698)
                    call PrintStr

                    mov  dx, offset message2    ;input x
                    call PrintStr
                    call Input
                    mov  x,ecx
        
                    mov  dx, offset message3    ;input y
                    call PrintStr
                    call Input
                    mov  y,ecx

                    mov  dx, offset message4
                    call PrintStr


                    mov  ebx, 17881h
                    neg  ebx

                    add  ebx, 0Ch               ; 12 - 96385

                    mov  eax, x
                    neg  ebx
                    imul ebx                    ; (12 - 96385) * x

                    mov  ebx, y
                    sub  ebx, 0E72h             ; y - 3698
                    neg  ebx

                    idiv ebx
             
                    mov  f, eax
                    call PrintInt
             

                    mov  ax,4c00h
                    int  21h

PrintStr proc
                    mov  ah, 09h
                    int  21h
                    ret
PrintStr endp

Input proc
                    xor  eax,eax
                    xor  ecx, ecx
                    mov  ah, 01h
                    int  21h
                    cmp  al, '-'
                    jne  positive
                    je   negative
             
    negative:       
                    xor  al,al
                    mov  ah, 01h
                    int  21h
                    sub  al, '0'
                    cbw
                    mov  ebx, 10
                    mov  ecx, eax

    convertNegative:
                    xor  eax,eax
                    mov  ah, 01h
                    int  21h
                    cmp  al,0dh
                    je   endingNegative
                    sub  al,'0'
                    cbw
                    xchg eax,ecx
                    mul  ebx
                    add  ecx, eax
                    jmp  convertNegative

    positive:       
                    sub  al, '0'
                    cbw
                    mov  ebx, 10
                    mov  ecx, eax

    convertPositive:
                    xor  eax,eax
                    mov  ah, 01h
                    int  21h
                    cmp  al,0dh
                    je   endingPositive
                    sub  al,'0'
                    cbw
                    xchg eax,ecx
                    mul  ebx
                    add  ecx, eax
                    jmp  convertPositive

    endingPositive: 
                    ret

    endingNegative: 
                    mov  y,ecx
                    neg  y
                    mov  ecx,y
                    ret
Input endp

PrintInt proc
                    xor  cx, cx
                    mov  ebx, 10
                    mov  eax, f
    
                    cmp  eax, 0
                    jge  convert
                    mov  ah, 02h
                    mov  dl, '-'
                    int  21h
                    mov  eax, f
                    neg  eax

    convert:        
                    xor  dx, dx
                    div  ebx
                    add  dl, '0'
                    push dx
                    inc  cx
                    cmp  eax, 0
                    jnz  convert

    print:          
                    pop  dx
                    mov  ah, 02h
                    int  21h
                    loop print

                    ret
        
        
PrintInt endp
end start

