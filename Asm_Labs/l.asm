masm
model small
.386
.stack 100h
.data
    msg       db  'Rezult: '
    len_str   equ 8
    len       equ 10
    mas       dd  9,0,1,8,0,7,8,0,3,0
    sum       dd  0
    max       dd  ?
    p         dw  ?
    col       dw  ?
    index_max dw  0
.code
    start:   
             mov  ax,@data
             mov  ds,ax

             mov  cx,len
             xor  eax,eax
             xor  si,si
             jcxz exit

             mov  si,0
             mov  eax,mas[si]
             mov  max, eax
             mov  index_max,si
    cycl:    
             inc  si
             inc  si
             inc  si
             inc  si
             mov  eax,mas[si]
             cmp  eax,max
             jle  next
             mov  eax,mas[si]
             mov  max,eax
             mov  index_max, si
    next:    
             loop cycl
             xor  si,si
             mov  si,index_max
             shr  index_max,2
             inc  index_max
             inc  index_max
             mov  ax,len
             sub  ax,index_max
             mov  cx,ax
             xor  eax,eax
    cycl_sum:
             inc  si
             inc  si
             inc  si
             inc  si
             mov  eax,mas[si]
             add  sum,eax
             loop cycl_sum
             mov  ah, 40h
             mov  bx, 01h
             mov  cx, len_str
             mov  dx, offset msg
             int  21h
             mov  eax,sum
             call PrintInt
    exit:    
             mov  ax,4c00h
             int  21h

PrintInt proc
             xor  cx,cx
             mov  ebx,10
    convert: 
             xor  dx,dx
             div  ebx
             add  dl, '0'
             push dx
             inc  cx
             cmp  eax,0
             jnz  convert
             mov  col,cx
             xor  cx,cx
    print:   
             mov  ah,40h
             mov  bx,01h
             pop  dx
             mov  p,dx
             mov  dx, offset p
             mov  cx,1
             int  21h
             dec  col
             cmp  col,0
             jnz  print
             ret
                
PrintInt endp

end start