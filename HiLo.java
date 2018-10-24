/**
 * Game outline:
 * 1. generate random number between 1-100
 * 2. prompt asking user to guess a number between 1-100
 * 3. compare user's guess to generate number (too high, too low, or correct)
 * 4. display results of comparison 
 * 5. prompt asking if user wants to play again
 */
import java.util.Scanner; //lib for working w/ keyboard input
/**
 * @author lauren
 *
 */
public class HiLo 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try(Scanner _scan = new Scanner(System.in);)
		{
			//Generate random number
			//random generates number between 0.0 and .999999
			int _theNumber = (int)(Math.random() * 100 + 1);
			int _guess = 0; //user's guess
			int _maxGuesses = 3; //max number of attempts to guess number
			int _currentGuesses = 1; //guess counter
			String _userPrompt = "Guess a number between 1 and 100. You have MAXGUESSES attempt(s):"; //prompt for user to guess number
			String _playAgain = ""; //response indicating if user wants to play again
	
			//Debug
			//System.out.println(_theNumber);
			
			//do while user wants to play
			do
			{		
				//prompt user to guess again as long at their guess is incorrect and less the max allowed guesses
				while (_guess != _theNumber && _currentGuesses <= _maxGuesses)
				{
					_guess = GetGuess(_userPrompt.replace("MAXGUESSES", Integer.toString(_maxGuesses - _currentGuesses + 1)), _scan);
	
					if(_guess < _theNumber)
						System.out.println(_guess + " is too low. Try again. If you dare....");
					else if (_guess > _theNumber)
						System.out.println(_guess + " is too high. Try again. If you dare....");
					else
						System.out.println(_guess + " is correct!! You win...NOTHING!");
	
					_currentGuesses++; //increment current guess count
				}
	
				//Debug
				//System.out.println("current guess value: " + _currentGuesses);
	
				if (_currentGuesses >=_maxGuesses)
					System.out.println("Max guess attempts reached");
	
				//ask user if they want to play again
				System.out.println("Would you like to play again (y/n)?");
				_playAgain = _scan.next();
			}
			while (_playAgain.equalsIgnoreCase("y"));
	
			System.out.println("Thank you for playing and good day!");
		}
	}

	public static int GetGuess(String UserPrompt, Scanner Scan)
	{
		int _guess = 0; 

		//prompt user to make guess
		System.out.println(UserPrompt);
		//put user's guess in local var
		_guess = Scan.nextInt();
		//display user's guess
		System.out.println("You guessed: " + _guess + ".");
		//return user's guess
		return _guess;
	}

}
