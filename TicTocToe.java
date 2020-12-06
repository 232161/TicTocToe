import java.util.Scanner;

//TicTocToe program

public class TicTocToe {
 
	//Instantiating boardof tictoc
	char board[][]=new char[3][3];
	
	//display function 
	public static void display(char board[][]) {
		// displaying board
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(board[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	public static void replace(char board[][],int choice,char find) {
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]==choice) {
					board[i][j]=find;
					return;
				}
		}}}		
	
	public boolean checkForWin() {
		if(checkForRows() || checkForColumn() || checkForDiagonal())
			return true;
		else 
			return false; 
	}
	
	public boolean checkForRows() {
		for(int i=0;i<3;i++) {
			if(check(board[i][0],board[i][1],board[i][2])==true)
				return true;
		}
	    return false;
	}
    
	public boolean checkForColumn() {
		for(int i=0;i<3;i++) {
			if(check(board[0][i],board[1][i],board[2][i])==true)
				return true;
		}
	    return false;
	}
	
	public boolean checkForDiagonal() {
			return ((check(board[0][0],board[1][1],board[2][2])==true) || (check(board[0][2],board[1][1],board[2][0])==true));
	}
	
	public boolean check(char c1,char c2,char c3) {
		if((c1==c2) && (c2==c3))
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {
     		
		//create object of class
		TicTocToe game=new TicTocToe();
		int  counter=0;
		Scanner in=new Scanner(System.in);
		
		//Initialize pattern or board
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				 game.board[i][j]=Character.forDigit(counter++, 10);
			}
		}
		display(game.board);
				
		//Declaring player1 and player2
		String player1,player2;
		System.out.println("enter player1 name ");
		player1=in.next();
		System.out.println("enter player2 name ");
		player2=in.next();
		
		//select player1 marker
		char player1Marker,player2Marker;
		System.out.println(player1+" enter marker between X/O ");
		player1Marker=in.next().charAt(0);
		
		while(player1Marker!='X' && player1Marker!='x' && player1Marker!='O' && player1Marker!='o') {
			System.out.println("Invalid Input ..."+player1+" please enter X/O ");
			player1Marker=in.next().charAt(0);
		}
		if(player1Marker=='X' || player1Marker=='x')  		// Assigning another marker to player2
              player2Marker='O';
		  else 
			player2Marker='X';
		System.out.println("");
			
	    
		
		//Taking user choice
		int choice;
		for(int i=0;i<4;i++) {
			System.out.println(player1+" turn : ");
			choice=in.next().charAt(0);
			replace(game.board,choice,player1Marker);
			display(game.board);
			
			if(game.checkForWin()) {
				System.out.println("we have one  "+player1);
				System.exit(0);;
			}   
			System.out.println(player2+" turn : ");
			choice=in.next().charAt(0);
			replace(game.board,choice,player2Marker);
		    display(game.board);
		    if(game.checkForWin()) {
				System.out.println("we have one  "+player2);
				break;
		    }
		}
		
		if(game.checkForWin()==false) {
			System.out.println(player1+" turn : ");
		    choice=in.next().charAt(0);
		    replace(game.board,choice,player1Marker);
		    if(game.checkForWin()) {
				System.out.println("we have  winner "+player1);
		    }
			else
			    System.out.println("match draw !! ....");			
		}
		 display(game.board);   
	}
		
		
		
}