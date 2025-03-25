masm
model small
.386
.stack 100h
.data
    message1 db 'y = 5x2 - 7x + 2', 13,10,'$'
    message2 db 13,10,'Input a: $'
    message3 db 13,10,'Input b: $'
    true     db 13,10,'True $'
    false    db 13,10,'False $'

    a        dd ?
    b        dd ?
    flag     db ?
    temp     dd ?
.code
    start:          
                    mov  ax,@data
                    mov  ds,ax
    ;(12 - 96385) * x / (y - 3698)

                    mov  dx,offset message1     ;(12 - 96385) * x / (y - 3698)
                    call PrintStr

                    mov  dx, offset message2    ;input a
                    call PrintStr
                    call Input
                    mov  a,ecx
        
                    mov  dx, offset message3    ;input b
                    call PrintStr
                    call Input
                    mov  b,ecx


                    mov  eax, a
                    mov  ebx, a
                    imul ebx
                    mov  ebx, 5
                    imul ebx
                    mov  temp, eax
                    mov  eax, a
                    mov  ebx, 7
                    imul ebx
                    neg  eax
                    add  eax, temp
                    add  eax, 2
                    mov  ebx, b
                    cmp  eax, ebx
                    jne  falseLabel
                    mov  flag, 1
                    call printFlag
                    jmp  continue
    falseLabel:     
                    mov  flag, 0
                    call printFlag
                
    continue:       
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
                    mov  b,ecx
                    neg  b
                    mov  ecx,b
                    ret
Input endp

printFlag proc
                    mov  dx, offset true
                    cmp  flag, 0
                    jne  print
                    mov  dx, offset false
    print:          
                    call PrintStr
                    ret
end start

