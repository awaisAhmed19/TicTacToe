//package Tic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
	private static Scanner in  = new Scanner(System.in);
	
	static ArrayList<Integer> Playerpos= new ArrayList<Integer>();
	static ArrayList<Integer> CPUpos=new ArrayList<Integer>();

	public static void main(String[] args) {
		//Scanner in=new Scanner(System.in);
		char[][] gameBoard= {
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
					
		};
		Printboard(gameBoard);
		
		
		while(true) {
			
			System.out.println("Enter the value X or O in place 1-9");
			int playerPosition=in.nextInt();
			
			Player(playerPosition,gameBoard);
			
			PlacePiece(gameBoard,playerPosition,"player");
			checkWinner();
			
			if(checkWinner().length()>0) {
				System.out.println(checkWinner());
				break;
			}
			
			int CPUposition=CPU(gameBoard);
			
			PlacePiece(gameBoard,CPUposition,"CPU");
			checkWinner();
			
			if(checkWinner().length()>0) {
			System.out.println(checkWinner());
			break;
			}
		
			Printboard(gameBoard);
		}
		
		
	}
	
	public static int CPU(char[][] gameBoard) {
		Random rand=new Random();
		int CPUposition=rand.nextInt(9)+1;
		while(Playerpos.contains(CPUposition)||CPUpos.contains(CPUposition)) {
			CPUposition=rand.nextInt(9)+1;
		}
		return CPUposition;
	}
	
	public static void Player(int playerPosition,char[][] gameBoard) {
		
		while(Playerpos.contains(playerPosition)||CPUpos.contains(playerPosition)) {
			System.out.println("Position taken Enter a new position");
			playerPosition=in.nextInt();
		}
		
		
	}
	
	public static void Printboard(char[][] gameBoard) {
		
		
		for(char[] row: gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}System.out.println();
		}

		
	}
	public static void PlacePiece(char [][] gameBoard,int pos, String user) {
	
		
		char symbol=' ';
		
		if(user.equals("player")) {
			symbol='X';
			Playerpos.add(pos);
			
		}else if(user.equals("CPU")) {
			symbol='O';
			CPUpos.add(pos);
			
		}
		
	switch(pos) {
		case 1: gameBoard[0][0]=symbol;
			break;
		case 2: gameBoard[0][2]=symbol;
			break;
		case 3: gameBoard[0][4]=symbol;
			break;
		case 4: gameBoard[2][0]=symbol;
			break;
		case 5: gameBoard[2][2]=symbol;
			break;
		case 6: gameBoard[2][4]=symbol;
			break;
		case 7: gameBoard[4][0]=symbol;
			break;
		case 8: gameBoard[4][2]=symbol;
			break;
		case 9: gameBoard[4][4]=symbol;
			break;
		default:
			break;
		
		
		}
		
	}
	
	public static String checkWinner() {
		List topRow=Arrays.asList(1,2,3);
		List midRow=Arrays.asList(4,5,6);
		List botRow=Arrays.asList(7,8,9);
		List rightCol=Arrays.asList(1,4,7);
		List midCol=Arrays.asList(2,5,8);
		List leftCol=Arrays.asList(3,6,9);
		List Diag1=Arrays.asList(1,5,9);
		List Diag2=Arrays.asList(3,5,7);
		
		
		List <List> winning=new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(rightCol);
		winning.add(midCol);
		winning.add(leftCol);
		winning.add(Diag1);
		winning.add(Diag2);
		
		for (List l: winning) {
			if (Playerpos.containsAll(l)) {
				return "congratulations you won";
				
		}else if(CPUpos.containsAll(l)){
			return "CPU wins LMAOOOOO";
			
		}else if(Playerpos.size() + CPUpos.size()==9) {
			return "Draw.....";
		}
		}
		
		return "";
	}

}
