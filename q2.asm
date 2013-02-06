section .data

  mesg: db "Helloworld",10,0
	strlen : equ $ -mesg
section .text

	global main
main:

	mov eax,4
	mov ebx,1

	mov ecx,mesg
	mov edx,strlen	
	int 80h

	mov eax,1
	mov ebx,0
	int 80h
