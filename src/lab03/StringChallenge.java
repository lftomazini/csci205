/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2015
* Instructor: Brian King
* Section: 10am
*
* Name: Luis Felipe Franco Candeo Tomazini & Anmol Singh
* Date: 08/25/2015
*
* Lab / Assignment: Lab03
*
* Description: Methods, and the String class
*
* *****************************************/

package lab03;

/**
 * The StringChallenge class is used to evaluate several different string
 * exercises from lab03.
 *
 * @author brk009
 */
public class StringChallenge {

    /**
     * Count the number of vowels in a string.
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowels(String s) {
	int sizeString = s.length();
	int vowels = 0;
	String str = s.toUpperCase();	

	for (int i = 0; i < sizeString; i++){
		if (str.charAt(i)=='A' || str.charAt(i)=='E' || str.charAt(i)=='I' || str.charAt(i)=='O' || str.charAt(i)=='U')
			vowels++;
	}

        return vowels;
    }

    /**
     * Count the number of vowels in a string. This method uses recursion
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowelsRec(String s) {
        String str = s.toUpperCase();

	if (str.length() == 0){
		return 0;
	} else if (str.charAt(0)=='A' || str.charAt(0)=='E' || str.charAt(0)=='I' || str.charAt(0)=='O' || str.charAt(0)=='U') {
			return 1 + countVowelsRec(str.substring(1, str.length()));
		}
		else
			return 0 + countVowelsRec(str.substring(1, str.length()));
    }


 /**
     * Returns if a word is a palindrome or not using recursion
     *
     * @param s The string to test
     * @return If <code>s</code> is a palindrome or not
     */
    public static boolean isPalindrome(String s) {
	String str = s.toLowerCase();
	
	if (str.length() == 1 || str.length() == 0) {
		return true;
	} else if (str.charAt(0) == str.charAt(str.length()-1)){
		return isPalindrome(str.substring(1, str.length()-1));
		} else
			return false;
	}


	

    /**
     * Swaps the first and last letters of a string, preserving case, only if they are letters
     *
     * @param s The string to swap
     * @return The string0 <code>s</code> with first and last letters swapped
     */
    public static String swapFirstAndLastLetter(String s) {
        int sizeString = s.length();
	
	char first = s.charAt(0);
	String middle = s.substring(1,s.length()-1);
	char last = s.charAt(s.length()-1);
	char first_2;
	char last_2;

	if ( last >= 65 && last <= 90 ){
		first_2 = Character.toUpperCase(first);
	} else if (last >= 97 && last <= 122){
			first_2 = Character.toLowerCase(first);
		} else
			return s;

	if (first >= 65 && first <= 90){
		last_2 = Character.toUpperCase(last);
	} else if (first >= 97 && first <= 122){
			last_2 = Character.toLowerCase(last);
		} else
			return s;		

	return 	Character.toString(last_2) + middle + Character.toString(first_2);
	}


    /**
     * Removes all the occurences of a string from another
     *
     * @param s The string to test
     * @param sRemove The string to be removes
     * @return The string <code>s</code> without all the occurences of <code>sRemove</code>
     */
    public static String withoutString(String s, String sRemove) {
        return s.replaceAll(sRemove, "");
    }

    /**
     *Converts the digits from String to int
     *
     * @param s The string to test
     * @return The sum of all of the numbers that occur in the string
     */
    public static int sumNumbersInString(String s) {
	int sum = 0; 
	int num; 
	for(int i = 0; i < s.length(); i++){
		char letter = s.charAt(i);
		if (Character.isDigit(letter) == true) {
			num = 1;
			
			for(int j = i+1 ;j < s.length();j++){
				letter = s.charAt(j);
				if (Character.isDigit(letter) == true){
					num += 1;
				} else {
					break;
				}
			}
			sum += Integer.parseInt(s.substring(i, i+num));
			i += num - 1;	
		}
	}
	return sum;
}

    /**
     * Main program to test out each String processing method
     */
    public static void main(String[] args) {
        String sTest = "Mississippi River";
        System.out.printf("countVowels(\"%s\") = %d\n", sTest, countVowels(sTest));
        System.out.printf("countVowelsRec(\"%s\") = %d\n", sTest, countVowelsRec(sTest));

        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
        sTest = "amanapanama";
        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));

        sTest = "Testing";
        System.out.printf("swapFirstAndLastLetter(\"%s\") = \"%s\"\n", sTest, swapFirstAndLastLetter(sTest));
        sTest = "Testing123";
        System.out.printf("swapFirstAndLastLetter(\"%s\") = \"%s\"\n", sTest, swapFirstAndLastLetter(sTest));

        sTest = "Testing Running Walking Jumping";
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "ing", withoutString(sTest, "ing"));
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "Sleep", withoutString(sTest, "Sleep"));

        sTest = "a1b2c3";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
        sTest = "aa12bb34cc56dd78";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
    }
}
