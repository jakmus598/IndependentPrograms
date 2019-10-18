import java.util.Scanner; //Used to read user input
import java.util.ArrayList; //Used to store the letters of the word and their frequencies

/**
 * October 18, 2019
 * Fetch Rewards - Engineering Intern Challenge
 * @author Jake Musleh
 * Description: This program takes as input a single word and determines whether or not said word is a pyramid word. A word
 * is a pyramid word if the frequency of its letters can be put into ascending order, with no gaps or duplicates. For
 * instance, "banana" is a pyramid word because 'b' occurs once, 'n' occurs twice, and 'a' occurs three times.
 *
 */

public class PyramidWordFinder {
	
	/**
	 * Description: Obtains user input and outputs whether or not it said input is a pyramid word
	 * Note: This method assumes valid input.
	 * @param args - Unused
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a word: ");
		String word = scanner.nextLine();
		boolean isAPyramid = isWordAPyramid(word);
		if(isAPyramid)
		{
			System.out.println(word + " is a pyramid word.");
		}
		else
		{
			System.out.println(word + " is not a pyramid word.");
		}
	}
	
	/**
	 * Description: Determines if a given word is a pyramid word
	 * @param word - The word to check
	 * @return - true if said word is a pyramid word, false otherwise
	 */
	private static boolean isWordAPyramid(String word)
	{
		ArrayList<Character> letters = new ArrayList<Character>(); //The list of letters
		ArrayList<Integer> frequencies = new ArrayList<Integer>(); //The list of the frequencies of the letters
		
		for(int i = 0; i < word.length(); i++)
		{
			if(letters.contains(word.charAt(i)))
			{
				//The index of the letter in letters will be equal to the index of its frequency in frequencies
				int indexOfLetter = letters.indexOf(word.charAt(i));
				frequencies.set(indexOfLetter, frequencies.get(indexOfLetter) + 1);
			}
			
			else
			{
				letters.add(word.charAt(i));
				frequencies.add(1);
			}
			
		}
		
		//Makes currentMin an Integer rather than an int so that remove detects an Object parameter rather than an int parameter
		Integer currentMin; 
		currentMin = getMin(frequencies);
		frequencies.remove(currentMin);
		
		boolean isAPyramid = true;
		
		
		while(isAPyramid)
		{
			if(frequencies.size() == 0)
			{
				//There are no more letters left to check
				break;
			}
			else 
			{
				int newMin = getMin(frequencies);
				if(newMin != currentMin + 1)
				{
					isAPyramid = false;
				}
				
				else
				{
					currentMin = newMin;
					frequencies.remove(currentMin);
				}
			}
		}
		return isAPyramid;	
	}
				
			
	/**
	 * Finds the minimum value in a given ArrayList of Integers 
	 * @param frequencyList - Said ArrayList
	 * @return - The lowest value
	 */
	private static Integer getMin(ArrayList<Integer> frequencyList)
	{
		Integer currentMin = 0;
		currentMin = frequencyList.get(0); //Initial value
		for(int i = 0; i < frequencyList.size() - 1; i++)
		{
			currentMin = Math.min(currentMin, frequencyList.get(i + 1));
		}
		
		return currentMin;
	}
}


	
