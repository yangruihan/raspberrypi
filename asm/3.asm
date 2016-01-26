assume cs:code

code segment
	mov ax,007bh
	mov cx,00edh
	
s:
	add ax,123
	loop s

	mov ax,4c00h
	int 21h
code ends

end

