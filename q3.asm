section .data
        age: dd 18
        age2: dd 0
        msg1: db "person is eligible for voting",10,0
        msg2:db "person not eligibile for voting",10,0
  msg3:db "%d"
section .text
        global main

main:
        push ebp
        mov ebp,esp
        ;sub esp,0x10

        ;mov DWORD [ebp-4],10
        push DWORD age2
	push msg3
	call scanf
;	add esp,8
	mov eax,[age2];DWORD PTR[ebp-4]
        cmp eax,[age]
        jge .label
        push msg2
        call printf;
        jmp .done

        .label:
                push msg1;
                call printf;
                jmp .done

        .done:
                mov esp,ebp;
                pop ebp
                ret
