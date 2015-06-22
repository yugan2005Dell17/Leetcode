package solutions.java;

import java.util.ArrayList;
import java.util.Collections;

public class ValidNumber {
	
	/* Note - Cases that I missed:
	 * 1: single ".", "e", ...
	 * 2: empty input
	 * 3: This is not a mistake. OJ think ". 1" is not allowed. don't need take the middle space off
	 * 4: '+'/'-' should not be the last
	 * 5: need at least one number
	 * 6: "46.e3" is acceptable
	 */

	static Character[] numChar;
	static final ArrayList<Character> NUM_CHAR;
	static {
		numChar = new Character[10];
		for (char i = '0'; i <= '9'; i++)
			numChar[i - 48] = i;
		NUM_CHAR = new ArrayList<Character>(10);
		Collections.addAll(NUM_CHAR, numChar);
	}

	public boolean isNumber(String s) {
		s = s.trim();
		char[] strip = new char[s.length()];
		int stripLength = 0;
		for (int idx = 0; idx < s.length(); idx++) {
			// if (!Character.isWhitespace(s.charAt(idx))) {
			strip[stripLength] = s.charAt(idx);
			stripLength++;
			// }
		}

		if (stripLength == 0) return false;

		boolean hasE = false;
		boolean hasSignBefore = false;
		boolean hasSignAfter = false;
		boolean hasDot = false;
		boolean hasNumChar = false;

		for (int idx = 0; idx < stripLength; idx++) {

			if (NUM_CHAR.contains(strip[idx])) {
				hasNumChar = true;
				continue;
			}

			switch (strip[idx]) {
			case 'e':
			case 'E': {
				// can only have one e/E
				if (hasE)
					return false;
				else
					hasE = true;

				// cannot be the beginning and end
				if (idx == 0 || idx == stripLength - 1)
					return false;

				// need a number in front of it
				// or num + . will be okay
				if (!NUM_CHAR.contains(strip[idx - 1])
						&& !(hasNumChar && strip[idx - 1] == '.'))
					return false;

				// need a number or '+', '-' after it
				if (!NUM_CHAR.contains(strip[idx + 1]) && strip[idx + 1] != '+'
						&& strip[idx + 1] != '-')
					return false;

				// cannot be single
				if (stripLength == 1)
					return false;

				break;
			}
			case '-':
			case '+': {
				// can only have one before e/E and one after e/E respectively
				if (hasE) {
					if (hasSignAfter)
						return false;
					else
						hasSignAfter = true;
				} else {
					if (hasSignBefore)
						return false;
					else
						hasSignBefore = true;
				}

				// must be either the beginning or right after e/E
				if (idx != 0 && strip[idx - 1] != 'e' && strip[idx - 1] != 'E')
					return false;

				// can not be the last
				if (idx == stripLength - 1)
					return false;

				// cannot be single
				if (stripLength == 1)
					return false;

				break;

			}
			case '.': {

				// can only have one dot before e/E
				if (hasDot)
					return false;
				else if (hasE)
					return false;
				else
					hasDot = true;

				// cannot be single
				if (stripLength == 1)
					return false;

				break;

			}
			default:
				return false;

			}

		}

		if (!hasNumChar)
			return false;

		return true;
	}
}
