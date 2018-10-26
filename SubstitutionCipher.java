
public class SubstitutionCipher implements MessageEncoder {

	private int shift;
	
//CONSTRUCTOR
	public SubstitutionCipher(int s) {
		shift = s;
	}
	
//IMPLEMENTED ENCODE METHOD
	public String encode(String plaintext) {
		String encodedmessage = null;
		char[] charray = plaintext.toCharArray();
		for (int i = 0; i < charray.length; ++i) {
			charray[i] = shiftchar(charray[i], shift);
			if (i == 0) {
				encodedmessage = charray[i] + "";
			} else {
				encodedmessage += charray[i] + "";
			}
		}
		return encodedmessage;
	}

//HELPER SHIFTCHAR METHOD
	private char shiftchar(char s, int m) {
		char shifted = (char) (s + m);
		return shifted;
	}
}
