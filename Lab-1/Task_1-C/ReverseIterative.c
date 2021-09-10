/*******************************************************************************
*
* Seminar 1 - task 1
* Author: Alexander Lundqvist
* Created: 30-08-2021
*
* Single file program that performs the task of taking in a string input and
* then print out the characters in reverse order by using a iterative function.
*
*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>

#define SIZE 11

void iterative(){
  char string[SIZE]; // Array that holds 10 chars, with the 11th accounting for the newline
  int index = 0;
  char c;

  while ((c = getchar()) != '\n') { // Checks until newline is found
    string[index] = c;
    index++;
  }

  for (int i = (index-1); i >= 0; i--) { // Prints out the array elements in reverse
    putchar(string[i]);
  }
}

/*
*
*
*/
int main(void){
  printf("Input text (MAX 10 characters): \n");
  iterative();
  return 0;

}
