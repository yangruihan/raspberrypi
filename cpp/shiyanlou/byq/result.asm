       DISSP  MACRO                 ;????
              PUSH      AX
              PUSH      DX
              MOV       AH,02H
              MOV       DL,20H
              INT       21H
              POP       DX
              POP       AX
              ENDM
     DISHCHH  MACRO                 ;??????
              PUSH      AX
              PUSH      DX
              MOV       AH,02H
              MOV       DL,0DH
              INT       21H
              MOV       AH,02H
              MOV       DL,0AH
              INT       21H
              POP       DX
              POP       AX
              ENDM
   DISSTRING  MACRO     STRING      ;?????
              PUSH      AX
              PUSH      DX
              MOV       AH,09H
              MOV       DX,OFFSET STRING
              INT       21H
              POP       DX
              POP       AX
              ENDM
      STACKS  SEGMENT   STACK
              DW        128 DUP(?)
      STACKS  ENDS
       DATAS  SEGMENT



a   dw  5 dup(?)
b   dw   ?
c   dw   ?
string0   db  'please input five numbers:' ,'$'
string1   db  'the sum of the numbers is:' ,'$'

DATAS  ENDS
       CODES  SEGMENT
              ASSUME    CS:CODES,DS:DATAS
      START:  MOV       AX,DATAS
              MOV       DS,AX



     mov b,0
     mov c,0
     disstring string0
     dishchh
LC2:
     cmp c,5
     jb LC0
     jmp LC1
LC0:
     mov ax,c
     push bx
     mov bx,2
     mul bx
     pop bx
     mov bx,offset a
     mov si,ax
     call getnum
     mov word ptr [bx+si],ax
     mov ax,c
     push bx
     mov bx,2
     mul bx
     pop bx
     mov si,ax
     mov bx, word ptr [a+si]
     push dx
     mov dx,bx
     mov bx,b
     add bx,dx
     pop dx
     mov b,bx
     inc c
     jmp LC2
LC1:
     disstring string1
     dishchh
     mov ax,b
     call putnum
     dishchh

 MOV       AX,4C00H    ;????
              INT       21H
              
      GETNUM  PROC      NEAR
              PUSH      BX
              PUSH      CX
              MOV       BX,0        ;BX???10????12???0
          L:  CALL      GETHEXCHAR  ;??1?10???=>AL
              CMP       AL,0DH
              JE        T1
              CMP       AL,20H
              JE        T2
              MOV       AH,0
              PUSH      AX
              MOV       AX,BX
              MOV       BX,10
              MUL       BX
              MOV       BX,AX
              POP       AX
              ADD       BX,AX
              JMP       L
         T1:  DISHCHH
              JMP       OVER
         T2:  DISSP
       OVER:  MOV       AX,BX       ;????AX
              POP       CX
              POP       BX
              RET
      GETNUM  ENDP
   
   
  GETHEXCHAR  PROC      NEAR
        CHL:  MOV       AH,1
              INT       21H         ;??1???
              CMP       AL,0DH
              JE        OVER2
              CMP       AL,20H
              JE        OVER2
              CMP       AL,'0'      ;<'0'???
              JB        ERROR
              CMP       AL,'9'      ;>'9'
              JA        ERROR
              SUB       AL,30H      ;?'0'-'9'??????0-9
              JMP       OVER2
      ERROR:  MOV       AH,2        ;??0-9?????????????
              MOV       DL,8
              INT       21H
              JMP       CHL         ;????
      OVER2:
              RET
  GETHEXCHAR  ENDP
      
      PUTNUM  PROC      NEAR        ;????1?10???(AL)
              PUSH      BX
              PUSH      CX
              PUSH      DX
              PUSH      AX
              MOV       CX,0
         L1:
              MOV       BX,10
              MOV       DX,0
              DIV       BX
              PUSH      DX
              INC       CX
              CMP       AX,0
              JNZ       L1
         L2:  POP       AX
              MOV       AH,0
              CALL      PUTHEXCHAR  ;??1?10????
              LOOP      L2
              POP       AX
              POP       DX
              POP       CX
              POP       BX
              RET
      PUTNUM  ENDP

  PUTHEXCHAR  PROC      NEAR        ;????1?10?????AL?
              ADD       AL,30H
              MOV       DL,AL
              MOV       AH,2
              INT       21H
              RET
  PUTHEXCHAR  ENDP
              
       CODES  ENDS
              END       START


