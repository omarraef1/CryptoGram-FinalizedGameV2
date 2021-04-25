import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author omargebril
 * 
 *
 */
class CryptogramTests {
	/**
	 * tests for game, must play the game for maimum code coverage
	 */
	@Test
	void test() {
		String quote = "To iterate is human, to recurse divine. - L. Peter Deutsch To iterate is human, to recurse divine. - L. Peter Deutsch To iterate is human, to recurse divine. - L. Peter Deutsch";
		CryptogramClass cryptoObject = new CryptogramClass();
		ArrayList encrypted = cryptoObject.encryptMessage(quote);
		cryptoObject.printBoard(cryptoObject.PCmap);
		
		cryptoObject.replaceCommand('A', 'B');
		cryptoObject.replaceCommand('B', 'C');
		cryptoObject.replaceCommand('C', 'D');
		cryptoObject.replaceCommand('D', 'E');
		cryptoObject.replaceCommand('E', 'F');
		cryptoObject.replaceCommand('F', 'G');
		cryptoObject.replaceCommand('G', 'H');
		cryptoObject.replaceCommand('H', 'I');
		cryptoObject.replaceCommand('I', 'J');
		cryptoObject.equalsCommand('C', 'O');

		cryptoObject.equalsCommand('O', 'C');
		cryptoObject.equalsCommand('O', 'C');
		cryptoObject.printBoard(cryptoObject.Usermap);
		cryptoObject.hintCommand();
		cryptoObject.freqCommand(quote);
		cryptoObject.printBoard(cryptoObject.Usermap);
		cryptoObject.helpCommand();
		
		
		
		
		
		
		
		String[] args = {quote};
		CryptogramsGame.main(args);
		
		
	}

}
