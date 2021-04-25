import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author omargebril
 *
 */
public class CryptogramsGame {
	
	/**
	 * 
	 * @param args
	 * main is where the game control happens basically,
	 * so if one tried to run JUnit test CryptogramTests;
	 * it will not fulfill a greater than or equal 90% coverage unless the game is played a little,
	 * because the CryptogramsGame.main is called in the JUnit test file
	 */
	public static void main(String[] args){
		// prompt user for file
		String filePath = "src/quotes.txt";
		int flag = 0;
	//	System.out.println("We here");
		String toEncrypt = "";
		try {
			
			toEncrypt = readFileAndReturnQuote(filePath);
		//	System.out.println(toEncrypt);
			flag = 1;
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			flag = 0;
			e.printStackTrace();
		}
	//	System.out.println("File read");
		int turnCount = 0;
		if(flag==0) {
			System.out.println("Rerun program with right filepath in main.");
		}
		 
		else if(flag==1) {
			// rest of program and game
			CryptogramClass cryptoObject = new CryptogramClass();
			//System.out.println("we here bruh");
			ArrayList encrypted = cryptoObject.encryptMessage(toEncrypt);

		
				cryptoObject.printBoard(cryptoObject.Usermap);
			
//			
			String encryptedAsString="";
			for (int u = 0; u < encrypted.size(); u++) {
				encryptedAsString+=(encrypted.get(u));
			}
			
			boolean gameFlag = true;
			Scanner usersc = new Scanner(System.in);
			
			while(gameFlag == true) {
				String userInput = usersc.nextLine();
				//print board first // no letter should map to itself 
			//	cryptoObject.printBoard(cryptoObject.Usermap);
				
				
				if(userInput.compareTo("help")==0) {
					// command printing method
					System.out.println(cryptoObject.helpCommand());
					System.out.println();
				}
				else if(userInput.compareTo("freq")==0) {
					// letter frequency method 
					System.out.println(cryptoObject.freqCommand(encryptedAsString));
					System.out.println();
					
					
				}
				else if(userInput.compareTo("hint")==0) {
					// display one correct mapping that has not yet been guessed
					// hinting method
					cryptoObject.hintCommand();
				//	System.out.println("hint works\n");
					System.out.println();
					
				}
				else if(userInput.length()>=13 && userInput.substring(0,7).compareTo("replace") == 0) {
					// replace stuff and check letters
					// letter replacing method
					cryptoObject.replaceCommand(userInput.charAt(8), userInput.charAt(13));
				//	System.out.println("replace works\n");
					System.out.println();
					
				}
				else if(userInput.length()>1 && Character.toString(userInput.charAt(2)).compareTo("=")==0) {
					// replace stuff and check letters
					// letter replacing method
					cryptoObject.equalsCommand(userInput.charAt(0), userInput.charAt(4));
					//System.out.println("= works\n");
					System.out.println();
					
				}
				else if(userInput.compareTo("exit")==0 ) {
					gameFlag = false;
					System.out.println("Game exited early, sad to see you go\n");
					break;
				}
				else {
					System.out.println("Command not found, try again");
					System.out.println();
				}
				
				cryptoObject.printBoard(cryptoObject.Usermap);
				//System.out.println("none");
				
				// check if hashmaps are equal and end game if true 
				if(cryptoObject.PCmap.equals(cryptoObject.Usermap)) {
					System.out.println();
					System.out.println("SUCCESS! YOU GOT IT!\nGame ended.");
					break;
				}
				 
				
			}
			
			
			
		}
		
	}
	
	
	/**
	 * 
	 * @param filename (input
	 * @return returns string encrypted
	 * @throws FileNotFoundException throws if file not found
	 */
	public static String readFileAndReturnQuote(String filename) throws FileNotFoundException {//surround with try catch

		File file = new File(filename);
		Random rand = new Random();
		int lines = 0;
		
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {
			lines++;
			sc.nextLine();
		}
		
		int n = rand.nextInt((lines - 1) + 1) + 1;
		
		Scanner newsc = new Scanner(file);
		int i = 1;
		String line = "";
		String toEncrypt2 = ""; 
		while (newsc.hasNextLine()) {
			line = newsc.nextLine();
			if (i == n) {
				toEncrypt2 = line;
			}
			i++;
		}
		// end reading file and getting specific line
		String toEncrypt = "";
		toEncrypt = toEncrypt2.toUpperCase();
		
		return toEncrypt;
		
	}
}
