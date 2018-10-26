
public class ShuffleCipher implements MessageEncoder {

	private int number;

//CONSTRUCTOR
	public ShuffleCipher(int n) {
		number = n;
	}

//IMPLEMENTED ENCODE METHOD
	public String encode(String plaintext) {
		String shuffle = plaintext;
		int i = 0;
		while(i < number){
			shuffle = oneShuffle(shuffle);
			++i;
		}
		return shuffle;
	}

//HELPER METHOD WHICH PERFORMS ONE SHUFFLE
	private String oneShuffle(String s) {
		String encodedmessage = null;
		String os = s;
		char temp = 0;
		int halfnum;
		boolean even;

		char[] charray = os.toCharArray();
		if (charray.length % 2 == 0) {
			halfnum = charray.length / 2;
			even = true;
		} else {
			halfnum = (charray.length + 1) / 2;
			even = false;
			temp = charray[halfnum-1];

		}
		for (int i = 0; i < halfnum-1; ++i) {
			if (i == 0) {
				encodedmessage = charray[i] + "" + charray[i + halfnum];
			} else {
				encodedmessage += charray[i] + "" + charray[i + halfnum];
			}
		}
		if (!even) {
			encodedmessage += temp;
		}
		return encodedmessage;
	}
}
