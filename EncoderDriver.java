
public class EncoderDriver {

	public static void main(String[] args) {
		
		SubstitutionCipher s = new SubstitutionCipher(3);
		System.out.println(s.encode("hello"));
		ShuffleCipher n = new ShuffleCipher(2);
		System.out.println(n.encode("abcdefghi"));
	}

}
