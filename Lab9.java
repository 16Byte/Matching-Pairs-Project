import java.util.*;

public class Lab9 {
	
	static Scanner userScan = new Scanner(System.in);
	
	static int[][] gameBoard = {	{1, 1, 2, 2},
									{3, 3, 4, 4},
									{5, 5, 6, 6},
									{7, 7, 8, 8}	};
									
	/*   Sample Output -- Starting Board Gets Scrambled Randomly Each Game
						  Essentially is the reference board
	static int[][] gameBoard = {	{1, 2, 8, 3},
									{4, 8, 7, 7},
									{5, 4, 2, 6},
									{3, 6, 5, 1}	};
	
	*/
	static int[][] hiddenBoard = {	{0, 0, 0, 0},
									{0, 0, 0, 0},
									{0, 0, 0, 0},
									{0, 0, 0, 0}	};
	/*   Sample Output -- Updates When X and Y are selected and is stored as a succession pair
	static int[][] hiddenBoard = {	{0, 2, 0, 0},
									{0, 0, 0, 0},
									{0, 0, 2, 0},
									{0, 0, 0, 0}	};
	
	*/
	static int[][] tempBoard = {	{0, 0, 0, 0},
									{0, 0, 0, 0},
									{0, 0, 0, 0},
									{0, 0, 0, 0}	};
	/*   Sample Output -- Holds Temp value of hiddenBoard and prints it to reveal what's behind their selection
						  This array is also used to store the Temp value in case the pair is found and it needs
						  to be assigned to the hiddenBoard
	static int[][] hiddenBoard = {	{0, 2, 0, 0},
									{0, 0, 0, 0},
									{0, 0, 2, 0},
									{7, 0, 0, 0}	};
	
	*/
	
	static int tempSelection;
	
	
	public static void main(String[] args) {
		
		//we can do a for loop inside of a while loop repeating 3 times for each index. 
		//we can make a second set of this except going through 0,1,2.
		//then we duplicate this for both X and Y to create a gameboard
		
		//print the blank board -- Debug Tool
		//printGameBoard();
		
		//create the scrambled board
		setBoard();
		
		System.out.println();
		System.out.println();
		
		//print the scrambled board -- Debug Tool
		printGameBoard();
		
		//begin game
		gameHandler();
		
		
	}
	
	//Method Function: Prints Current Gameboard
	public static void printGameBoard() {	
	
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				System.out.print(gameBoard[x][y]);
			}//end y loop
			System.out.println();
		}//end x loop
		System.out.println("");
	}
	
	//Method Function: Prints the currently updated hidden game board
	public static void printHiddenGameBoard() {
		
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				System.out.print(hiddenBoard[x][y]);
			}//end y loop
			System.out.println();
		}//end x loop
	}
	
	//Method Function: Prints the currently updated hidden game board
	public static void printTempGameBoard() {
		
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				System.out.print(tempBoard[x][y]);
			}//end y loop
			System.out.println();
		}//end x loop
	}
	
	//Method Function: Prints an obvlivion of emtpy lines to clear the code
	//				   in order to reduce chances of cheating
	public static void cls() {
		for(int i = 0; i < 100; i++) {
				System.out.println(" ");
			}//end cls loop
	}
	
	//Method Function: Shuffles Array
	public static void setBoard() {
		
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				
				int x1 = (int)(Math.random()* gameBoard.length);
				int y1 = (int)(Math.random()* gameBoard[x].length);
				
				int temp = gameBoard[x][y];
				gameBoard[x][y] = gameBoard[x1][y1];
				gameBoard[x1][y1] = temp;
				
				
			}//end y loop
		}//end x loop
		
	}
	
	//Method Function: numbers are revealed either when X and Y are selected (starts tempReveal(); 
	//				   and if a pair is found in succession they will be solidified. If not then
	// 				   the gameboard will take the value of revealBoard(temp board). 
	public static void hiddenBoardUpdateHandler() {
		//TODO: create check and bounce if statement that checks if the two numbers are indeed a pair.
		//		If the two numbers are not a pair, print second hidden number and then throw try again.
	}
	
	//Method Function: Handles temporary storage of selections to be revealed
	public static void tempBoardUpdateHandler(int x, int y, int value) {
		//TODO: create function that stores temp selection in all the right places then moves data to hiddenBoardUpdateHandler();
		
		//write function that will take the x and y and value of the matrix location then set the value to the same x and y value of the temp matrix
		
		//then write a catch function to ask for a second input and write it to the temp matrix then check if they are pairs if(value(xy)==value(xy)) {add to hiddenBoard and reveal new hiddenBoard} 
		//else {throw error and say "That's not a pair! Try again." loop back to gameHandler();}
		//rest temp matrix back to {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0};
		
		//set Temp Value
		tempBoard[x][y] = value;
		//print temp board
		printTempGameBoard();
		
		//Successor Selection
		//X and Y selection value holders
		int userXSelection;
		int userYSelection;
		
		//Just a print statement to show initiation
		System.out.println("");
		System.out.println("Awesome! You found, " + value + ". Can you find the pair?");
		System.out.println("");
		
		//Ask for X and Y values
		System.out.println("Please Choose an X Position: ___");
		userXSelection = userScan.nextInt()-1;
		
		System.out.println("Please Choose a Y Position: ___");
		userYSelection = userScan.nextInt()-1;
		//end ask
		
		//Show user what they entered for X and Y
		System.out.println("X: " + (userXSelection+1) + "\tY: " + (userYSelection+1));

		//Reveal the temp selection value to the user
		tempSelection = gameBoard[userXSelection][userYSelection];
		System.out.println("Second Selection: " + tempSelection);
		
		//Check if the two values equal each other (is a pair)
		if(value == tempSelection) {
			hiddenBoard[x][y] = value;
			hiddenBoard[userXSelection][userYSelection] = tempSelection;
			tempBoard[userXSelection][userYSelection] = tempSelection;
		} else {
			System.out.println("");
			System.out.println(value + " and " + tempSelection + " are not matching pairs!");
			System.out.println("Please Try Again");
			System.out.println("");
			
			//reset gameboard
			tempBoard[x][y] = 0;
			tempBoard[userXSelection][userYSelection] = 0;
		}
		
		gameHandler();
		
	}
	
	//Method Function: Main Game Function Block
	public static void gameHandler() {
		boolean isStillSolving = true;
		//X and Y selection value holders
		int userXSelection;
		int userYSelection;
		
		//quick check if the gameboard is fully solved
		if(Arrays.deepEquals(gameBoard, hiddenBoard)) {
			isStillSolving = false;
		}
		
		if(isStillSolving) {
			printHiddenGameBoard();
			
			//Just a print statement to show initiation
			System.out.println("");
			System.out.println("Let's Roll");
			System.out.println("");
			
			//Ask for X and Y values
			System.out.println("Please Choose an X Position: ___");
			userXSelection = userScan.nextInt()-1;
			
			System.out.println("Please Choose a Y Position: ___");
			userYSelection = userScan.nextInt()-1;
			//end ask
			
			//Show user what they entered for X and Y
			System.out.println("X: " + (userXSelection+1) + "\tY: " + (userYSelection+1));

			//Reveal the temp selection value to the user
			tempSelection = gameBoard[userXSelection][userYSelection];
			System.out.println("First Selection: " + tempSelection);
			
			//Move values over to tempBoardUpdateHandler(x,y,value); for successor selection and reveal
			tempBoardUpdateHandler(userXSelection, userYSelection, tempSelection);
		}
		if(!isStillSolving) {
			cls();
			System.out.println(" ------------------------------ ");
			System.out.println("|       Congratulations!       |");
			System.out.println("| You solved the entire board! |");
			System.out.println(" ------------------------------ ");
			printHiddenGameBoard();
		}
	}
	
}