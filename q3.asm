;Assembly program to check whether a person is eligible for voting or not
;Written by Jothis



section .data
        age: dd 18 
        age2: dd 0 
        msg1: db "person is eligible for voting",10,0
        msg2:db "person not eligibile for voting",10,0
  	msg3:db "%d"
section .text
        global main

main:
        push ebp;saving base pointer
        mov ebp,esp
        ;sub esp,0x10

        push DWORD age2;pushing first argument
	push msg3  ;pushing second argument
	call scanf;calling scanf

	mov eax,[age2] ;moving age to eax register
        cmp eax,[age] ;comparing the ages
        jge .label
        push msg2  ;display the persin is not eligible
        call printf;
        jmp .done

        .label:
                push msg1;
                call printf; display the person is eligible
                jmp .done

        .done:
                mov esp,ebp;
                pop ebp
                ret
