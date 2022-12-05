import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		char Table[][] = new char [3][3];
		char ans[] = new char[2];
		int count = 0;
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				Table[i][j]=' ';
			}
		}
		
		System.out.println("************");
		System.out.println("Tic-Tac-Toe!");
		System.out.println("************");
		
		System.out.println("Please enter the column (A, B or C) and then the row (1, 2, or 3) of your move.");
		System.out.println();
		
		//loop gia na paizoyn mexri na yparxei nikhths h isopalia
		while(!winner(Table)) {
			printTable(Table);
		
			//Player move
			System.out.println();
			System.out.print("Player move (X) : ");
			String answer = keyboard.nextLine();
			while(isValid(answer)) {
				System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1).");
				System.out.print("Player move (X) : ");
				String answer2 = keyboard.nextLine();
				answer = answer2;
			}
			ans = answer.toCharArray();
			while(Table[Character.getNumericValue(ans[1])-1][(int)ans[0]-65]!=' ') {
				System.out.println("The space entered is already taken.");
				System.out.print("Player move (X) : ");
				String answer2 = keyboard.nextLine();
				answer = answer2;
				ans = answer2.toCharArray();
			}
			
			Table[Character.getNumericValue(ans[1])-1][(int)ans[0]-65]='X';
			
			System.out.println();
			printTable(Table);
			if(winner(Table))
				break;
			count++;
			if(count==5)
				break;
			
			//Computer move
			computer(Table);
			if(winner(Table)) {
				count=69;
				break;
			}
		}
		
		System.out.println();
		if(count<4)
			System.out.println("You win");
		else if(count==69) {
			printTable(Table);
			System.out.println();
			System.out.println("Computer won");
		}else 
			System.out.println("Draw");
	}
	
	//Synarthsh gia na paizei o ypologisths
	public static void computer(char Table[][]) {
		Random rand = new Random();
		char[] alf = new char[] {'A','B','C'};
		int col;
		int row;
		do {
			col = rand.nextInt(3);
			row = rand.nextInt(3);
		}while(Table[row][col]!=' ');
		
		System.out.println();
		System.out.println("Computer Move (O): "+alf[col]+(row+1));
		System.out.println();
		Table[row][col]='O';
	}
	
	//Ektypwsh pinaka
	public static void printTable(char Table[][]) {
		System.out.println("   A   B   C");
		for (int i=0; i<3; i++) {
			System.out.print( i+1 +"| " );
			for (int j=0; j<3; j++) {
				System.out.print( Table[i][j] +" | " );
			}
			System.out.println();
		}
	}
	
	//Elegxos apanthshs
	public static boolean isValid(String answer) {
		char ans[] = new char[2];
		if((answer.length()!=2)) 
			return true;
		
		ans = answer.toCharArray();
		if((Character.getNumericValue(ans[1])>3)||(int)ans[0]-65>3||(int)ans[0]-65<0) 
			return true;
		
		return false;
	}
	
	
	//Elegxos an yparxei nikhths
	public static boolean winner(char Table[][]) {
		//Orizontia periptwsh
		for(int i=0;i<3;i++) {
				if((Table[i][0]!=' ')&&(Table[i][0]==Table[i][1])&&(Table[i][1]==Table[i][2]))
					return true;
		}
		//Katakorhfh periptwsh
		for(int i=0;i<3;i++) {
			if((Table[0][i]!=' ')&&(Table[0][i]==Table[1][i])&&(Table[1][i]==Table[2][i]))
				return true;
		}
		
		//Diagwnia periptwsh no1
		if((Table[0][0]!=' ')&&(Table[0][0]==Table[1][1])&&(Table[1][1]==Table[2][2])){
				return true;
		}
		
		//Diagwnia periptwsh no2
		if((Table[0][2]!=' ')&&(Table[0][2]==Table[1][1])&&(Table[1][1]==Table[2][0])){
			return true;
		}
		return false;
	}
    
}
