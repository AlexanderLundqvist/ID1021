/*******************************************************************************
*
* Seminar 1 - task 1
* Author: Alexander Lundqvist
* Created: 30-08-2021
*
* Single file program that performs the task of taking in a string input and
* then print out the characters in reverse order. It does this with two
* different methods, an iterative function and a recursive function.
*
* Time comlexity
*
*
* Memory complexity
*
*******************************************************************************/

#include <stdio.h>
#include <string.h>

/*
* Recursive function that prints the characters in a char array in reverse with
* the help of a pointer.
*/
void recursive(char *array){

  // Checks if the array pointer is null
  if (*array) {
    recursive(array++);
    printf("%c\n", *array); // Dereference the value at the pointer then print
  }
}

/*
* Iterative function that
*
*/
void iterative(){

  int entry;
  int i = 0;
  int amount = 0;
  char string2[10];

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

/*
*
*
*/
int main(void){

  char input_1[100]; // For recursive function
  char input_2[10]; // For iterative function

  // Execution of the recursive function
  printf("\nTesting the recursive function.\n\n");
  printf("Input text:\n");
  fgets(input_1, sizeof input_1, stdin);
  recursive(input_1);
  printf("the reverse string is: %s\n",input_1);

  // Execution of the iterative function
  /*
  printf("\nTesting the iterative function.\n\n");
  printf("Input text (max 10 characters):\n");
  fgets(input_2, sizeOf input_2, stdin);
  iterative(input_2);
  printf("the reverse string is: %s\n",input_2);
  */

  return 0;

}
