;Assembly program to convert celsius to fahrenhiet and vice versa



section .data

  	msg1: db "Enter the choice",10,0
	 msg2: db "1 celsius to fahrenhiet",10,0
	 msg3: db "2 fahernhiet to celsius",10,0
	 msg6: db "Enter the celsius",10,0
	 msg5: db "Enter the fahrenhiet",10,0
	 msg7: db "The result =%f",10,0
	 msg4: db "%d",10,0
	fahren: dd 0
	celsius:dd 0
	choice: dd 0
	con1:dq 1.8
	

section .text

	extern printf
	extern scanf
	global main
	main:
		push ebp;saving base pointer
		mov ebp,esp
		
		push msg1
		call printf ;calling printf

		push msg2
                call printf;calling printf
		
		push msg3
                call printf;calling printf

		push DWORD choice ;reading choice
		push msg4
		call scanf;calling scanf

		mov eax,[choice];moving choice to eax register
		cmp eax,1   ;check if choice 1
		je .choice1
		
		push msg5  ;enter fahren
		call printf
		
		push DWORD fahren
		push msg4
		call scanf

		mov eax,[fahren] ;fahernhiet cal
		sub eax,32
		;mov ecx,2;[con1]
		mov edx,0
		
		fdiv DWORD[con1]	;div eax,10
		
		push eax;DWORD [con1]
		push msg7
		call printf;display fahrenhiet
		jmp .done
	.choice1:
		jmp .done

		
	.done:	
		mov esp,ebp
		pop ebp
		ret	
