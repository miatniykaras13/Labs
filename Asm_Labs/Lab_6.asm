masm
model small
.386
.stack 100h
.data
    msg1 db 'Y * 64 + X / 36 $'
    msg2 db 13,10,'Input X: $'
    msg3 db 13,10,'Input Y: $'
    msg4 db 13,10,'Result: $'
    msg5 db 13,10,'Result equals zero$'
    msg6 db 13,10,'Result is positive$'
    msg7 db 13,10,'Result is negative$'
    msg8 db 13,10,'Even$'
    msg9 db 13,10,'Odd$'
    x    dw ?                                ;int
    y    db ?                                ;char
    f    dw ?
.code
    start:    
              mov  ax,@data
              mov  ds, ax

              mov  dx,offset msg1     ;Y * 64 + X / 36
              call PrintStr

              mov  dx,offset msg3
              call PrintStr
              call InputChar

              mov  al,y
              sal al, 6
              mov  y,al

              mov  dx,offset msg2
              call PrintStr
              call InputInt
              mov  x,cx
              mov  cx,x
              mov ax, cx        
            shr cx, 5         
            mov bx, cx        
            mov cx, ax        
            and cx, 1Fh       
            shr cx, 2 
            dec bx       
            add bx, cx        
            mov cx, bx 
            mov x, cx

                          

              mov  al,y
              cbw
              mov bx, x
              add  bx,ax
              mov  ax, bx
              mov  f,ax
              mov  dx, offset msg4
              call PrintStr
              call PrintInt
              
              and  f,1
              jz   chet
              jmp  nechet
    chet:     
              mov  dx, offset msg8
              call PrintStr
              jmp continue
    nechet:   
              mov  dx, offset msg9
              call PrintStr
              
              mov  dx, offset msg5
              call PrintStr
    continue:
            cmp  f,0
            jg   positive
            jl   negative
    positive: 
              mov  dx,offset msg6
              call PrintStr
              jmp  ending
    negative: 
              mov  dx,offset msg7
              call PrintStr
    ending:    
              mov  ax, 4c00h          ;standart end prog
              int  21h

PrintStr proc
              mov  ah, 09h
              int  21h
              ret
PrintStr endp

InputChar proc
              mov  ah,01h
              int  21h
              mov  y,al
              ret
InputChar endp


InputInt proc
              xor  ax,ax
              xor  cx, cx
              mov  ah, 01h
              int  21h
              sub  al, '0'
              cbw
              mov  bx, 10
              mov  cx, ax
    convert:     
              xor  ax,ax
              mov  ah, 01h
              int  21h
              cmp  al,0dh
              je   Endin
              sub  al,'0'
              cbw
              xchg ax,cx
              mul  bx
              add  cx, ax
              jmp  convert
    Endin:     
              ret
InputInt endp

PrintInt proc
              xor  cx,cx
              mov  bx,10
    conv:  
              xor  dx,dx
              div  bx
              add  dl, '0'
              push dx
              inc  cx
              cmp  ax,0
              jnz  conv
    print:    
              mov  ah,02h
              pop  dx
              int  21h
              loop print
              ret
        
        
PrintInt endp

end start  


