/*********************************** README ************************************
*
* Seminar 3 - Task 1
* Author: Alexander Lundqvist
* Created: 02-10-2021
*
* This program acts like a filter that removes all non-alphabetical characters
* but also preserves whitespaces and newlines and also converts uppercase to
* lowercase. It operates on a given textfile specified in the commandline
* execution and then saves the result in a new file.
*
* C in terminal with text file
*
* Usage:
* Use command in teminal ./a.out < thetext.txt > filteredtext.txt
* Or in commandline ./a.exe < thetext.txt > filteredtext.txt
*
*******************************************************************************/

#include <stdio.h>
#include <ctype.h>

/*
* Filter function that replaces non-alphabetical characters
* with whitespaces.
*/
void filterText() {
  char c = getchar();
  while (c != EOF) {
    // If alphabetical, newline or whitespace, then preserve it
    if (isalpha(c) || c == '\n' || c == ' ') {
      putchar(c);
    }
    // If non-alphabetical, replace with blank
    else {
      putchar(' ');
    }
    // Continue with next char
    c = getchar();
  }
}

/* Main driver code */
int main(void) {
  filterText();
  return 0;
}
