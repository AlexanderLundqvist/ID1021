/*******************************************************************************
*
* Seminar 1 - task 1
* Author: Alexander Lundqvist
* Created: 30-08-2021
* Last updated:
*
* Koden implementerar två sätt att läsa in en textsträng från användaren tills
* en newline symbol upptäcks och sedan skriva ut strängen i omvänd ordning.
*
* Referenser
*
*******************************************************************************/

#include <stdio.h>
#include <string.h>

/*
* Rekursiv funktion som inverterar en char array i minnet (pointer)
* genom att byta plats på entries.
*/
void recursive(char *array){

  // Kollar ifall pointern är null
  if (*array) {
    recursive(array++);
    printf("%c\n", *array); // Skriv ut dereferenserat värde vid pointern
  }
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

  char input[50];

  printf("\nTest av rekursiv funktion.\n\n");
  printf("Mata in en teckensträng:\n");

  fgets(input, sizeOf input, stdin);
  recursive(input);

  printf("Den omvända teckensträngen är: %s\n",string1);

  //iterative();

  return 0;

}
