;Assembly program to display helloworld using system calls
;Writen by Jothis



section .data

  mesg: db "Helloworld",10,0
	strlen : equ $ -mesg
section .text

	global main
main:

	mov eax,4;stdin 
	mov ebx,1

	mov ecx,mesg
	mov edx,strlen	
	int 80h;interrupt to display the message

	mov eax,1
	mov ebx,0
	int 80h
