import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
/**
 * 
 * @author omargebril
 * CryptogramClass with attributes for later use
 */
public class CryptogramClass {
	String toEncrypt;
	String encrypted;
	ArrayList<Character> originalAlphabet = new ArrayList<Character>();
	ArrayList<Character> Alphabet = new ArrayList<Character>();
	ArrayList<Character> gameAlphabet = new ArrayList<Character>();
	String board;
	ArrayMap<Character, Character> PCmap = new ArrayMap<Character, Character>();
	ArrayMap<Character, Character> Usermap = new ArrayMap<Character, Character>();
	ArrayList<Character> gameArray = new ArrayList<>();
	
	public CryptogramClass() {
		gameAlphabet.add('A');
		gameAlphabet.add('B');
		gameAlphabet.add('C');
		gameAlphabet.add('D');
		gameAlphabet.add('E');
		gameAlphabet.add('F');
		gameAlphabet.add('G');
		gameAlphabet.add('H');
		gameAlphabet.add('I');
		gameAlphabet.add('J');
		gameAlphabet.add('K');
		gameAlphabet.add('L');
		gameAlphabet.add('M');
		gameAlphabet.add('N');
		gameAlphabet.add('O');
		gameAlphabet.add('P');
		gameAlphabet.add('Q');
		gameAlphabet.add('R');
		gameAlphabet.add('S');
		gameAlphabet.add('T');
		gameAlphabet.add('U');
		gameAlphabet.add('V');
		gameAlphabet.add('W');
		gameAlphabet.add('X');
		gameAlphabet.add('Y');
		gameAlphabet.add('Z');
		Collections.shuffle(gameAlphabet);
		Alphabet.add('A');
		Alphabet.add('B');
		Alphabet.add('C');
		Alphabet.add('D');
		Alphabet.add('E');
		Alphabet.add('F');
		Alphabet.add('G');
		Alphabet.add('H');
		Alphabet.add('I');
		Alphabet.add('J');
		Alphabet.add('K');
		Alphabet.add('L');
		Alphabet.add('M');
		Alphabet.add('N');
		Alphabet.add('O');
		Alphabet.add('P');
		Alphabet.add('Q');
		Alphabet.add('R');
		Alphabet.add('S');
		Alphabet.add('T');
		Alphabet.add('U');
		Alphabet.add('V');
		Alphabet.add('W');
		Alphabet.add('X');
		Alphabet.add('Y');
		Alphabet.add('Z');

	}

	/**
	 * 
	 * @param usermap2	user's hash map
	 * prints board correctly
	 * @return return board string
	 */
	public String printBoard(ArrayMap<Character, Character> usermap2) {// TODO
		int spaceOne = 0;
		int spaceTwo = 0;
		int spaceDistance = 0;
		int lineCounter = 0;
		int lineCounter2 = 0;
		Character let = null;
		int upperFlag = 0;
		int bottomFlag = -1;
		if (gameArray.size() > 80) {
			for (int h = 0; h < gameArray.size(); h++) {
				upperFlag = h;
				boolean spaceFlag = true;
				for (ArrayMap.Entry entry : Usermap.entrySet()) {
					if (gameArray.get(h).equals(entry.getKey())) {
						String let1 = entry.getValue().toString();
						let = let1.charAt(0);
						spaceFlag = false;
						break;
					}
				}
				if(lineCounter2>70 && lineCounter2<=80 && !Character.isLetter(gameArray.get(h))) {
					lineCounter2 = 0;
					System.out.println();
					for (int x = bottomFlag+1; x <= upperFlag; x++) { //
						System.out.print(gameArray.get(x));
					}
					bottomFlag = upperFlag;
					System.out.println("\n");
				}
				else if (lineCounter2 <= 80) {

					// System.out.print(lineCounter);
					if (spaceFlag == false) {
						System.out.print(let);
					} else {
						if (Character.isLetter(gameArray.get(h))) {
							System.out.print(" ");
						} else {
							System.out.print(gameArray.get(h));
						}
					}

				}
				else{
					lineCounter2 = 0;
					System.out.println();
					for (int x = bottomFlag+1; x <= upperFlag; x++) { //
						System.out.print(gameArray.get(x));
					}
					bottomFlag = upperFlag;
					System.out.println("\n");
					
					
				}

				lineCounter2++;
			}
			System.out.println();
			for (int x = bottomFlag+1; x <= upperFlag; x++) { //
				System.out.print(gameArray.get(x));
			}

		} else {

			for (int h = 0; h < gameArray.size(); h++) {
				upperFlag = h;
				boolean spaceFlag = true;
				for (ArrayMap.Entry entry : Usermap.entrySet()) {
					if (gameArray.get(h).equals(entry.getKey())) {
						String let1 = entry.getValue().toString();
						let = let1.charAt(0);
						spaceFlag = false;
						break;
					}
				}

				if (spaceFlag == false) {
					System.out.print(let);
				} else {
					if (Character.isLetter(gameArray.get(h).toString().charAt(0))) {
						System.out.print(" ");
					} else {
						System.out.print(gameArray.get(h));
					}
				}
			}

			System.out.println();

			for (int u = 0; u < gameArray.size(); u++) {
				System.out.print(gameArray.get(u));
			}
		}

		System.out.println();
		return board;

	}
	/**
	 * 
	 * @param quote to encrypt message
	 * @return	returns array of characters for encrypted message
	 */
	public ArrayList encryptMessage(String quote) {// TODO NO SAME LETTER ASSIGNMENT DONE!!!
		// Create PC HashMap that stores quotation encryption
		toEncrypt = quote;
		ArrayList<Character> encryptedList = new ArrayList<Character>(toEncrypt.length());

		for (int j = 0; j < toEncrypt.length(); j++) {
			if (Character.isLetter(toEncrypt.charAt(j))) {
				for (int k = 0; k < gameAlphabet.size(); k++) {
					if (!PCmap.containsKey(gameAlphabet.get(k)) && !PCmap.containsValue(toEncrypt.charAt(j))
							&& (gameAlphabet.get(k) != toEncrypt.charAt(j))) {
						PCmap.put(gameAlphabet.get(k), toEncrypt.charAt(j));
						break;
					}

				}
			}

		}

		for (int l = 0; l < toEncrypt.length(); l++) {
			Character key = null;
			boolean flag = false;
			for (ArrayMap.Entry entry : PCmap.entrySet()) {
				if (Character.valueOf(toEncrypt.charAt(l)).equals(entry.getValue())) {
					String key2 = entry.getKey().toString();
					key = key2.charAt(0);
					flag = true;
					break;
				}
			}

			if (flag == true) {
				encryptedList.add(key);
				flag = false;
			} else {
				encryptedList.add((toEncrypt.charAt(l)));

			}
		}

		gameArray = encryptedList;

		return gameArray;

	}

	/**
	 * 
	 * @param quote to be encrypted
	 * @return string as flag
	 */
	public String freqCommand(String quote) {
		int lineCounter = 0;
		String toReturn = "";
		char[] arr = quote.toCharArray();
		// Arrays.sort(arr);
		// System.out.println(arr);
		// System.out.println(Alphabet);
		// System.out.println(gameAlphabet);
		// HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < Alphabet.size(); i++) {
			int counter = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == Alphabet.get(i)) {
					counter++;
				}
			}
			if (lineCounter == 7) {
				toReturn += ("\n");
				lineCounter = 0;
			}

			toReturn += Alphabet.get(i) + ": " + counter + " ";
			lineCounter++;
		}
		return toReturn;
	}

	/**
	 * 
	 * @param toReplace char to be replaced
	 * @param replacement letter for later use
	 * @return string as flag
	 */
	public String replaceCommand(char toReplace, char replacement) {
		boolean flag = false;
		if (Character.isUpperCase(toReplace) && Character.isUpperCase(replacement)) {
			Usermap.put(toReplace, replacement);
			flag = true;
		}
		if (flag) {
			return "success!\n";
		}
		return "illegal mapping";
	}

	/**
	 * 
	 * @param toReplace char to be replaced
	 * @param replacement char to replace
	 * @return String as flag
	 */
	public String equalsCommand(char toReplace, char replacement) {
		boolean flag = false;
		if (Character.isUpperCase(toReplace) && Character.isUpperCase(replacement)) {
			Usermap.put(toReplace, replacement);
			flag = true;
		}
		if (flag) {
			return "success!\n";
		}
		return "illegal mapping";
	}

	/**
	 * 
	 * @return null, the method processes the hint and alters the user's map
	 */
	public String hintCommand() {
		for (ArrayMap.Entry entry : PCmap.entrySet()) {
			if (!Usermap.containsKey(entry.getKey())) {
				Usermap.put(entry.getKey().toString().charAt(0), entry.getValue().toString().charAt(0));
				break;
			}
		}
		return null;
	}

	/**
	 * 
	 * @return, returns string of help command 
	 * listing supported commandsx
	 */
	public String helpCommand() {
		String toReturn = "";
		toReturn += "Supported commands:\n";
		toReturn += "a.\treplace X by Y - replace letter X by Y\n";
		toReturn += "\tX = Y - a shortcut for this same command\n";
		toReturn += "b.\tfreq - Display the letter frequencies in the encrypted quotation (i.e., how many of letter X appear)\n";
		toReturn += "c.\thint - Display one correct mapping that has not yet been guessed\n";
		toReturn += "d.\texit – Ends the game early\n";
		toReturn += "e.\thelp - List these commands";
		return toReturn;
	}

}
