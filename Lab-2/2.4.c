/*******************************************************************************
*
* Seminar 2 - task 4
* Author: Alexander Lundqvist
* Created: 09-09-2020
* Last updated:
*
*
* ---------------------------------README---------------------------------------
*
* The code implements a function that orders an array that all negative elements
* comes before the positive. It also implements some auxillary functions like
* toString function to display arrays and swapping elements. The code is used
* by taking input from the user in the form of array length and desired
* elements. Error handling is only implemented in the form of checking for
* correct array length, i.e positive integers.
*
* The algoritm of the ordering function is in-place, as it only takes a pointer
* and int as arguments. It orders the array in the memory and uses no extra data
* structures.
*
*
*******************************************************************************/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/* A function that implements swapping two elements */
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* The ordering function, takes input as pointer to array and array length */
void arrayOrdered(int* array, int length){
  int j = length-1; // Pointing to end of array

  // The loop runs through the array from the start and checks if it finds a
  // positive value. If it finds it, a secondary loop tries to find a negative
  // value, counting from the end. If it is found, it swaps places with the
  // positive.
  for(int i = 0; i < j; i++){
    if(array[i] >= 0){
      while(j > i){ // Search from the right until negative is found
        if(array[j] < 0){
          swap(&array[i], &array[j]);
          break; // start inner loop from the place where negative was found
        }
        else{
          j--; // Decrease the search area
        }

      }
    }
  }
}

/* Function to print array */
void toString(int array[], int length){
  for(int i = 0; i < length; i++){
    printf("[%d]", array[i]);
    if(i < length - 1){
      printf(",");
    }
  }
}

/* Driver code to test the above functions */
int main(void){

  // Basic test for checking the toString and order function
  int testArray[6] = {1,-2,4,-3,-5,0};
  printf("Testing toString with testArray:\n");
  toString(testArray, 6);
  printf("\n\nTesting arrayOrdered with testArray:\n");
  arrayOrdered(testArray, 6);
  toString(testArray, 6);


  // Unit testing which takes input from the user in the form of
  // length of the array and the desired elements. Catches only error in case
  // of invalid array length.
  int length = 0;
  printf("\n\nInput length of array (int): ");
  scanf("%d", &length);

  // Catches error here
  if(length < 0){
    printf("Array length can't be negative!");
    exit(0);
  }
  printf("\nEnter %d elements (int): ", length);
  int inputArray[length];
  for(int i = 0; i < length; ++i){ // Populating the array with input integers
    scanf("%d", &inputArray[i]);
  }

  // Verify the array with toString
  printf("\nThe input array: \n");
  toString(inputArray, length);

  // Display the result
  printf("\n\nThe array after the ordering: \n");
  arrayOrdered(inputArray, length);
  toString(inputArray, length);

  return 0;

}
