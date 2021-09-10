/*******************************************************************************
*
* Seminar 1 - task 1
* Author: Alexander Lundqvist
* Created: 30-08-2021
*
* Single file program that performs the task of taking in a string input and
* then print out the characters in reverse order by using a recursive function.
*
*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>

void recursive() {
  char c;
  c = getchar(); // Reads a char from standard input, each time it is called it moves to the next char
  if (c != '\n') { // Checks if we reached "end of string" by checking for newline
    recursive();
    putchar(c); // Outputs a character to the standard output
  }
}

int main(void){
  printf("Input text: \n");
  recursive();
  return 0;
}
