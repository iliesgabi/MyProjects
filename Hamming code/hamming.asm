.386
.model flat, stdcall
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;includem biblioteci, si declaram ce functii vrem sa importam
includelib msvcrt.lib
extern exit: proc
extern fscanf: proc
extern scanf: proc
extern fopen: proc 
extern printf: proc 
extern strlen: proc
extern fgets: proc 
extern fprintf: proc
extern fclose: proc
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
include librarie.asm
;declaram simbolul start ca public - de acolo incepe executia
public start
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;sectiunile programului, date, respectiv cod
.data

;aici declaram date
nr dd 31 dup(0)
string db "1111111111111111111111111111111",0
mode db "%s", 0
pointer dd 0
filename db "fisier.txt",0
format db "r",0
contor dd 0
modec db "%c", 0
mesaj1 db "1 generare",10,0
mesaj2 db "2 verificare",10,0
ce_proc db "0000000000000000000000", 0
lgstring dd 0
moded db "%d", 0
eaxqq dd 0
eroare dd 0
corect db "corect", 0
corect2 db "corect: ", 0
incorect db "incorect", 10, 0
aux dd 0
rand_nou db " ", 10, 0
msj_eroare db "eroare la bitul %d", 10, 0
pointerw dd 0
filenamew db "fisierout.txt",0
formatw db "w", 0
mesaj db "numarul citit este %s", 0
mesaj_eroare db "ati introdus o comanda gresita. mai incercati o data", 0

.code

aranjare_vector proc
mov eax, esi 
mov ecx, 30
bucla1:
mov edx, [esi-4]
mov [esi], edx
sub esi, 4
loop bucla1
mov edx, 0
mov [esi], edx

mov esi, eax
mov ecx, 29 
bucla2:
mov edx, [esi-4]
mov [esi], edx
sub esi, 4
loop bucla2
mov edx, 0
mov [esi], edx

mov esi, eax
mov ecx, 27
bucla4:
mov edx, [esi-4]
mov [esi], edx
sub esi, 4
loop bucla4
mov edx, 0
mov [esi], edx

mov esi, eax
mov ecx, 23
bucla8:
mov edx, [esi-4]
mov [esi], edx
sub esi, 4
loop bucla8
mov edx, 0
mov [esi], edx

mov esi, eax
mov ecx, 15
bucla16:
mov edx, [esi-4]
mov [esi], edx
sub esi, 4
loop bucla16
mov edx, 0
mov [esi], edx

ret 8
aranjare_vector endp


transformare proc
mov ecx, eax
	bucla:
		mov edx, 0
		mov edx, [esi]
		sub edx, 48
		mov [edi], dl
		add edi, 4
		add esi, 1 
	loop bucla 
ret 24
transformare endp 


initializare proc
mov ecx, 31
mov ebx, 0
bucla:
mov [edi], ebx
add edi, 4
loop bucla
ret 8
initializare endp


lungime_sir proc
cmp ebx, 4
jb trans1
	cmp ebx, 11
	jb trans2
		cmp ebx, 26
		jb trans3
			add ebx, 5
		jmp cont1
trans1:
add ebx, 2
jmp cont2
trans2:
add ebx, 3
jmp cont3
trans3:
add ebx, 4
cont1:
cont2:
cont3:
ret 8
lungime_sir endp

start:

;aici se scrie codul
;f=fopen("fisier.txt", r);
push offset format
push offset filename
call fopen 
add esp, 8
mov pointer, eax 


push offset formatw
push offset filenamew
call fopen 
add esp, 8
mov pointerw, eax 

citire:
	;fscanf(f, %s, &string);
	push offset string
	push offset mode
	push pointer
	call fscanf 
	add esp, 12
	mov eaxqq, eax 
	

	cmp eax, 1
	jne iesi
	
	push offset string
	push offset mesaj
	call printf
	push pointerw
	call fprintf
	add esp, 12
	
	push offset rand_nou
	push offset mode
	push pointerw
	call fprintf
	add esp, 12
	
	mov eax, 0
	push offset string
	call strlen 
	mov aux, eax

	mov esi, offset string
	lea edi, nr
	push eax 
	push esi
	push edi 
	call transformare
	jmp sari_eroare
	
	inca_o_data:
	push offset mesaj_eroare
	call printf
	add esp, 4
	
	intra_in_altfel:
	
	sari_eroare:
	push offset rand_nou
	call printf
	add esp, 4
	
	push offset mesaj1
	call printf
	add esp, 4


	push offset mesaj2
	call printf
	add esp, 4

	push offset ce_proc
	push offset mode
	call scanf
	add esp, 8
	
	push offset ce_proc
	call strlen
	add esp, 4
	
	cmp eax, 1
	jne inca_o_data
	
	
	lea esi, ce_proc
	mov edx, 0
	mov dl, [esi]
	sub edx, 48
	
	
	cmp edx, 2
	je procedura2
		cmp edx, 1
		je procedura1
			push offset mesaj_eroare
			call printf
			add esp, 4
		
		jmp intra_in_altfel
		
		procedura1:
		lea esi, nr
		add esi, 120
		push esi
		call aranjare_vector
	
		lea esi, nr
		add esi, 120
		push esi
		call generare 
		
		mov ebx, aux 
		push ebx
		call lungime_sir
		
		inc ebx 
		lea edi, nr
		mov ecx, ebx 
		mov contor, ecx
	afisare1:

		push [edi]
		push offset moded
		call printf
		push pointerw
		call fprintf
		add esp, 12
		
		add edi, 4
	
		dec contor
		mov ecx, contor
	
	loop afisare1
	
	push offset rand_nou
	push pointerw
	call fprintf
	add esp, 8
		
	jmp gata
	procedura2:
	lea esi, nr 
	add esi, 120 

	mov eax, 0
	push esi
	push eax
	call verificare 
	
	mov eroare, eax
	
	cmp eax, 0
	je acorect 

	push offset incorect 
	call printf
	add esp, 4
	
	push offset incorect 
	push pointerw
	call fprintf
	add esp, 8
	
	push eroare
	push offset msj_eroare
	call printf
	add esp, 8
	
	push eroare 
	push offset msj_eroare
	push pointerw
	call fprintf
	add esp, 12
	
	push offset corect2
	call printf
	add esp, 4
	
	push offset corect2
	push pointerw
	call fprintf
	add esp, 8
	
	mov ebx, aux
	cmp eroare, 1
	je schimba1
		cmp eroare, ebx
		je schimba2
		
		lea edi, nr
		
		mov ebx, eroare
		inc ebx
		mov ecx, ebx
		mov contor, ecx
		afisare2:

			push [edi]
			push offset moded
			call printf
			push pointer 
			call fprintf
			add esp, 12
			
			add edi, 4
	
			dec contor
			mov ecx, contor
	
		loop afisare2
		
		push offset rand_nou
		push pointerw
		call fprintf
		add esp, 8
		
		mov ecx, [edi] 
		cmp ecx, 0
		je afis2
			
			mov ecx, 0
			push ecx 
			push offset moded
			call printf
			push pointerw
			call fprintf
			add esp, 12
		jmp sari_afis2
		afis2:
			mov ecx, 1
			push ecx 
			push offset moded
			call printf
			push pointerw
			call fprintf
			add esp, 12
		sari_afis2:
		add edi, 4
		
		mov ecx, aux 
		sub ecx, eroare
		mov contor, ecx
		afisare22:

			push [edi]
			push offset moded
			call printf
			push pointerw
			call fprintf
			add esp, 12
			
			add edi, 4
	
			dec contor
			mov ecx, contor
	
		loop afisare22
		
		push offset rand_nou
		push pointerw
		call fprintf
		add esp, 8
		
	jmp continuare1
	schimba1:
		lea edi, nr
		mov ecx, [edi]
		cmp ecx,0
		je afis1
			mov ecx, 0
			push ecx 
			push offset moded
			call printf
			push pointerw
			call fprintf
			add esp, 12
		jmp sari_afis1
		afis1:
			mov ecx, 1
			push ecx 
			push offset moded
			call printf
			push pointerw
			call fprintf
			add esp, 12
		sari_afis1:
	
	
	add edi, 4
	mov ecx, aux
		mov contor, ecx
		afisare3:

			push [edi]
			push offset moded
			call printf
			push pointerw
			call fprintf
			add esp, 12
			add edi, 4
	
			dec contor
			mov ecx, contor
	
		loop afisare3
		
	jmp continuare2	
	
	schimba2:
		lea edi, nr
		mov ecx, eroare 
		mov contor, ecx
		afisare4:

			push [edi]
			push offset moded
			call printf
			push pointerw
			call fprintf
			add esp, 12
			add edi, 4
	
			dec contor
			mov ecx, contor
	
		loop afisare4
		
		mov ecx, [edi] 
		cmp ecx, 0
		je afis3
			
			mov ecx, 0
			push ecx 
			push offset moded
			call printf
			push pointerw
			call fprintf
			add esp, 12
		jmp sari_afis3
		afis3:
			mov ecx, 1
			push ecx 
			push offset moded
			call printf
			push pointerw
			call fprintf
			add esp, 12
		sari_afis3:
		
	continuare1:
	continuare2:
	
	push offset rand_nou
	push pointerw
	call fprintf
	add esp, 8
	
	jmp continue
	acorect:
	push offset corect
	call printf 
	add esp, 4
	
	push offset corect
	push pointerw 
	call fprintf 
	add esp, 8
	
	push offset rand_nou
	push pointerw
	call fprintf
	add esp, 8
	
	continue:
	
	gata:
	
	mov eax, eaxqq
	
	lea edi, nr
	push edi 
	call initializare
	
	push offset rand_nou
	call printf
	add esp, 4
	
jmp citire 
iesi:

;fclose(f);
push pointer
call fclose
add esp, 4

push pointerw
call fclose
add esp, 4
	;terminarea programului
	push 0
	call exit
end start
