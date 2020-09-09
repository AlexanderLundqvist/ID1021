/*******************************************************************************
*
* Seminar 1 - task 1
* Author: Alexander Lundqvist
* Created: 03-09-2020
* Last updated: 09-09-2020
*
* Koden implementerar två sätt att läsa in en textsträng från användaren tills
* en newline symbol upptäcks och sedan skriva ut strängen i omvänd ordning.
*
* Referenser
* (https://stackoverflow.com/questions/1407461/putting-user-input-into-
* char-array-c-programming)
* Användes för att få fram hur man läser input från användaren och matar in i
* en array.
*
* (https://stackoverflow.com/questions/31678511/reverse-a-string-recursively-in-
* c-using-a-pointer-to-string-only)
* Användes då författaren ej förstod sig på pointers i C.
*******************************************************************************/

#include <stdio.h>
#include <string.h>


void recursive(char *array, int first, int last){
  // Rekursiv funktion som inverterar en char array i minnet (pointer)
  // genom att byta plats på entries.


  char temp; // Temporär variabel för byte

  if(first >= last){ // Kollar ifall vi nått mitten av array.
    return;
  }


  temp = *(array+first); // Lagrar värdet vid index [0] i temp
  *(array+first) = *(array+last); // Byter plats på entries via pointers
  *(array+last) = temp; //

  // Kallar funktionen igen. Stegar fram från första entry och bakåt från sista.
  recursive(array, ++first, --last);
}


void iterative(){
  // Funktionen läser in från stdin och lägger in chars i en tom array
  // av förbestämd storlek 10. Sedan skriver den ut så många chars som skrevs
  // i omvänd orning, max 10.

  int entry;
  int i = 0;
  int amount = 0;
  char string2[10];

  printf("\n\nTest av iterativ funktion. (10 bokstäver max)\n\n");
  printf("Mata in en teckensträng:\n");

  entry = getchar(); // Hämtar en char från input streamen
  while((i < 10 ) && (entry != EOF)){
    if (entry == '\n'){ // Se om newline finns, isåfall avbryt loopen.
      break;
    }

    else{
    string2[i] = entry;
    entry = getchar(); // Hämtar nästa char från inputstreamen
    }
    ++i;
    ++amount;
  }

  // För att skriva ut strängen i omvänd orning i stdout.
  // amount-1 för att bli av med NULL terminatorn i strängen.
  printf("Den omvända teckensträngen är:\n");
  for(int j = (amount-1); j >= 0 ; --j){
    putchar(string2[j]);
  }
}

// Testfunktion för programmet. Testar varje funktion Genom anropning.
int main(void){
  char string1[1000];
  printf("\nTest av rekursiv funktion.\n\n");
  printf("Mata in en teckensträng:\n");
  fgets(string1, 1000, stdin);
  recursive(string1, 0, strlen(string1)-1);
  printf("Den omvända teckensträngen är: %s\n",string1);

  iterative();

  return 0;

}
