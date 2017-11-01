package academy.learnprogramming;

import java.util.Arrays;

public class _067_QuestionExamplesArraysString {

	public static void main(String[] args) {
		// Vraag 1
		int count = 0;
		ROW_LOOP:for (int row = 1; row <= 3; row++)  
				for (int col = 1; col <= 2; col++) {
					if (row * col % 2 == 0)continue ROW_LOOP;
					count++;
				}
				System.out.println(count);
				
				
			/**
			 * Vraag 2
			 * Which of these array declarations is not legal? (Choose all that apply)
			 * A. int [][] scores = new int[5][];
			 * B. Object[][][] cubbies = new Object[3][0][5];
			 * C. String beans[] = new beans[6]; // De varabele naam kan niet als type gegeven worden.
			 * D. java.util.Date[] dates[] = new java.util.Date[2][];
			 * E. int[][] types = new int[]; //De size wordt niet gespecifeerd
			 * F. int[][] java = new int[][]; //De size wordt niet gespecifeerd
			 * 
			 * eigen antwoord: B,C,E
			 * officieel antwoord: C, E, F Let op er moet minstens een grootte van de Array aangegeven zijn
			 */
				
				
				/**
				 * 3. Which of these compile when replacing line 8
				 * 
				 * 	7: char[]c= new char[2];
				 * 8: // inset code here
				 * 
				 * A. int length = c.capacity
				 * B. int length = c.capacity();
				 * C. int length = c.length;
				 * D. int length = c.length();
				 * E. int length = c.size;
				 * F. int length = c.size();
				 * G. None of the above
				 * 
				 * Antwoord van mij:  
				 * 
				 * Antwoord: Array heeft geen methoden en geen capacity of size dus C.
				 */
				
				// What is the result of the following
				
				int[] random = {6, -4, 12, 0, -10};
				int x = 12;
				int y = Arrays.binarySearch(random, x);
				System.out.println(y);
				
				/**
				 * A. 2
				 * B. 4
				 * C. 6
				 * D. The result is undefined
				 * E. An exception is thrown
				 * F. The code does not compile
				 * 
				 * Antwoord van mij: D
				 * Antwoord: D omdat voor een binarySearch een Array gesorteerd moet zijn.
				 * 
				 */
				
				/*
				 * What is the output of the following code?
				 */
				
//				int [] arr1;
//				int [] arr2 = new int [3];
//				char [] arr3 = {'a', 'b'};
//				arr1 = arr2;
//				arr1 = arr3;
//				System.out.println(arr1[0]+ ":" + arr1[1]);
//				
				// Compilation error char kan je omzetten naar int (primitives) maar niet van een char Array!! 
				
				
				/**
				 * Which of the following are valid lines of code to define a multidimensional int array
				 * 
				 * A. int [][] array1 = {{1, 2, 3}, {}, {1, 2, 3, 4, 5}};
				 * B. int [][] array2 = new array() {{1, 2, 3}, {}, {1, 2, 3, 4, 5}};
				 * C. int [][] array3 = {1, 2, 3}, {0}, {1, 2, 3, 4, 5};
				 * D. int [][] array5 = new int[2][];
				 * 
				 * Antwoord van mij: A, D
				 */
				
				/**
				 * What is the output of the following code?
				 */
				
				int[] list = {8, 10};
				for(int b:list) {
					System.out.print(b + ",");
					break;
				}
				
				/**
				 * A. 8, 10,
				 * B. 8, 10
				 * C. 8,
				 * D. The code does not compile because of line 105
				 * E. The code does not compile because of line 106
				 * F. The code contains an ifinite loop and does not terminate
				 * 
				 * Antwoord van mij: A
				 * Antwoord: moet zijn C, want na de eerst loop wordt er een brak uitgevoerd dwz dat het meteen uit de loop gaat en finidhed
				 */
				
				
				// Wahat is the output of the following code snippet?
				
				int[] list1= {10, 8, 10, 9};
				for (int c : list1) {
					System.out.println(c+",");
					if(c % 2 == 0) {
						continue;
					}
				}
				
				
				/**
				 * A. 10, 8, 10, 9,
				 * B. 11, 9
				 * C. 8, 10
				 * D. The code does not compile because of line 122
				 * E. The code does not compile because of line 125
				 * F. The code does not compile because of line 126
				 * G. The code does not compile because of line 127
				 * 
				 * mijn antwoord: A
				 * 
				 */
				
				
				/**
				 * Which of the following statements is true
				 * 
				 * A. The enhanced for loop can't be used within a regular for loop
				 * B. The enhanced for loop can't be used within a while loop
				 * C. The enhanced for loop can be used within a do-while loop
				 * D. The enhanced for loop can't be used within a switch construct
				 * E. All of the above statements are false
				 * 
				 * Mijn antwoord: C, D
				 * juiste antwoord: C
				 */
				
				//What's the output of the following code?
				
				int num = 120;
				switch(num) {
				default: System.out.println("default");
//				case 0: System.out.println("case1");		//Duplicate Case!!
				case 10*2-20: System.out.println("case2");
				break;
				}
				
				/**
				 * A. default case1 case2
				 * B. case1 case2
				 * C. case2
				 * D. Compilation error
				 * E. Runtime exception
				 * Mijn antwoord: D
				 * Juiste antwoord: D
				 */
				
				
			}

	}


