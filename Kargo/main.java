import java.util.Collection;
import java.util.HashMap;
/**
 * Determines if a one to one character mapping exist from one string. If one does exist then
 * it will print out true to stdout and if one does not exist it will print out false.
 * @author Madison Garity
 *
 */
public class main {
	/**
	 * Determines if the given strings have an existing one to one character mapping
	 * @param args Command line arguments
	 */
	public static void main(String [] args) {
		// Determines if the correct number of strings is entered by the user
		if(args.length != 2) {
			System.out.println("false");
			return;
		}
		String s1 = args[0];
		String s2 = args[1];
		// Sees if the two different strings are the same length since a one by one mapping
		// cant exist if they arent the same length
		
		if(s1.length() != s2.length()) {
			System.out.println("false");
			return;
		}
		int charNum = 0;
		int fal = 0;
		HashMap<Character, Character> map = new HashMap<>();
		// Goes through each character and puts them in a mapp
		for(int i = 0; i < s1.length(); i++) {
			if(!map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i), s2.charAt(i));
			} else {
				// if the character from s1 is already in the map, checks to make sure that value is still the same
				// as it was the first time
				Collection<Character> keys = map.keySet();
				Collection<Character> values = map.values();
				Object[] valueArray = values.toArray();
				Object[] keyArray = keys.toArray();
				for(int j = 0; j < keyArray.length; j++) {
					if(keyArray[j].equals(s1.charAt(i))) {
						charNum = j;
					}
				}
				if(!valueArray[charNum].equals(s2.charAt(i))) { 
					fal = 1;
				}
				// if it is not the same then it will print false
				if(fal == 1) {
					System.out.println("false");
					return;
				}
			}
		}
		//Prints true if everything passes
		System.out.println("true");
	}
}
