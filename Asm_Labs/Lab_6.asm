masm
model small
.386
.stack 100h
.data
    msg1 db 'Y * 24 + X / 64 $'
    msg2 db 13,10,'Vvedite X: $'
    msg3 db 13,10,'Vvedite Y: $'
    msg4 db 13,10,'Recultat: $'
    msg5 db 13,10,'Resultat raven null$'
    msg6 db 13,10,'Resultat bolshe null$'
    msg7 db 13,10,'Resultat menshe null$'
    msg8 db 13,10,'Chet$'
    msg9 db 13,10,'Nechet$'
    x    dw ?                                ;un int
    y    db ?                                ;un char
    f    dw ?
.code
    start:    
              mov  ax,@data
              mov  ds, ax
    ;Y * 24 + X / 64

              mov  dx,offset msg1     ;vivod primera
              call PrintStr

              mov  dx,offset msg3
              call PrintStr
              call InputChar

              mov  al,y
              shl  al,1
              add  al,al
              shl  al,3
              mov  y,al

              mov  dx,offset msg2
              call PrintStr
              call InputInt
              mov  x,cx
              mov  cx,x
              shr  cx,6

              mov  al,y
              cbw
              add  cx,ax
              mov  ax, cx
              mov  dx, offset msg4
              call PrintStr
              call PrintInt
              mov  f,ax
              and  f,1
              jz   chet
              jmp  nechet
    chet:     
              mov  dx, offset msg8
              call PrintStr
    nechet:   
              mov  dx, offset msg9
              call PrintStr

              cmp  f,0
              jg   positive
              jl   negative
              mov  dx, offset msg5
              call PrintStr
    positive: 
              mov  dx,offset msg6
              call PrintStr
              jmp  konec
    negative: 
              mov  dx,offset msg7
              call PrintStr
    konec:    
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
    conv:     
              xor  ax,ax
              mov  ah, 01h
              int  21h
              cmp  al,0dh
              je   Endi
              sub  al,'0'
              cbw
              xchg ax,cx
              mul  bx
              add  cx, ax
              jmp  conv
    Endi:     
              ret
InputInt endp

PrintInt proc
              xor  cx,cx
              mov  bx,10
    convert:  
              xor  dx,dx
              div  bx
              add  dl, '0'
              push dx
              inc  cx
              cmp  ax,0
              jnz  convert
    print:    
              mov  ah,02h
              pop  dx
              int  21h
              loop print
              ret
        
        
PrintInt endp

end start  


