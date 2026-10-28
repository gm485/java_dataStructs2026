package dsa_ch4_arrays;

public class CaesarCipher {
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    public CaesarCipher(int rotation) {
        for (int k = 0; k<26; k++){
            encoder[k] = (char)('A' + (k + rotation) % 26);
            decoder[k] = (char)('a' + (k - rotation + 26) % 26);
        }
    }

    public String encrypt(String message) {
        return transform(message, encoder);
    }

    public String decrypt(String secret) {
        return transform(secret, decoder);
    }

    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int k = 0; k < msg.length; k++) {
            if (Character.isUpperCase(msg[k])) {
                int j = msg[k] - 'A';
                msg[k] = code[j];
            }
        }
        return new String(msg);

    }

    static void main() {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("ENCRYPTION CODE = " + new String(cipher.encoder));
        System.out.println("DECRYPTION CODE = " + new String(cipher.decoder));
        String msg = "THE EAGLE HAS LANDED";
        String coded = cipher.encrypt(msg);
        System.out.println("Secret" + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Answer: " + answer);

    }
}
