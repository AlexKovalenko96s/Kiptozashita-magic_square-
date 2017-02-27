package ua.kas.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Controller {

	private String string = "";
	private String encrypt = "";
	private String decrypt = "";
	private String keyClose = "";
	private String rsa = "";
	private String key = "";

	private int d;

	private String[] alphabet = { "б", "а", "н", "д", "е", "р", "о", "л", "ь", "в", "г", "ж", "з", "і", "й", "к", "м",
			"п", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "и", "ь", "є", "ю", "я" };
	private String[] letter = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z" };

	private LinkedList<String> alphabetRSA = new LinkedList<String>(Arrays.asList(letter));

	public void start(String string, String rsa, int d) {
		this.string = string;
		this.d = d;
		this.rsa = rsa;
		encrypt();
		decrypt();
	}

	private void encrypt() {
		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < alphabet.length; j++) {
				if (string.substring(i, i + 1).equals(alphabet[j])) {
					if (j + 8 > alphabet.length - 1) {
						int n = (j + 8) - (alphabet.length);
						encrypt += alphabet[n];
					} else {
						encrypt += alphabet[j + 8];
					}
				}
			}
		}
		signatureOpen();

		try {
			FileWriter writer = new FileWriter("file.txt");
			writer.write(encrypt + key);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Enter string = " + string + " " + rsa);
		System.out.println("Encrypt string = " + encrypt + key);
	}

	private void decrypt() {
		for (int i = 0; i < encrypt.length(); i++) {
			for (int j = 0; j < alphabet.length; j++) {
				if (string.substring(i, i + 1).equals(alphabet[j])) {
					if (j - 8 < 0) {
						int n = alphabet.length + j - 8;
						decrypt += alphabet[n - 24];
					} else {
						decrypt += alphabet[j];
					}
				}
			}
		}
		signatureClose(key);
		System.out.println("Decrypt string = " + decrypt + " " + keyClose);
	}

	public void signatureOpen() {
		int e = 7;
		int n = 33;

		for (int i = 0; i < rsa.length(); i++) {
			int j = i + 1;
			String s = rsa.substring(i, j);
			int number = alphabetRSA.indexOf(s) + 1;
			key += Integer.toString(((int) Math.pow(number, e)) % n) + "|";
		}
	}

	public void signatureClose(String string) {
		keyClose = "";
		String closeKey = d + ",33";
		int d = Integer.parseInt(closeKey.substring(0, closeKey.indexOf(",")));
		int n = Integer.parseInt(closeKey.substring(closeKey.indexOf(",") + 1));

		ArrayList<String> l = new ArrayList<String>();

		while (string.length() >= 2) {
			int j = string.indexOf("|");
			l.add(string.substring(0, j));
			string = string.substring(j + 1);
		}

		for (int i = 0; i < l.size(); i++) {
			int j = (int) Math.pow(Integer.parseInt(l.get(i)), d);
			keyClose = keyClose + alphabetRSA.get((j % n) - 1);
		}
	}
}