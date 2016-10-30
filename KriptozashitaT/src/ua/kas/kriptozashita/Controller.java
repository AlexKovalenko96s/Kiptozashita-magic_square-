package ua.kas.kriptozashita;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

	@FXML
	TextField tf1, tf2;

	private String string = "";
	private String encrypt = "";
	private String decrypt = "";
	private String signature = "";
	private String key = "";
	private String keyClose = "";

	private String[] letter = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z" };

	private LinkedList<String> alphabet = new LinkedList<String>(Arrays.asList(letter));

	public void encrypt() throws IOException {
		string = tf1.getText();
		String s;

		for (int i = 0; i < string.length(); i++) {
			int j = i + 1;
			s = string.substring(i, j);
			switch (s) {
			case "б":
				s = s.replace("б", "ь");
				break;
			case "а":
				s = s.replace("а", "в");
				break;
			case "н":
				s = s.replace("н", "г");
				break;
			case "д":
				s = s.replace("д", "ж");
				break;
			case "е":
				s = s.replace("е", "з");
				break;
			case "р":
				s = s.replace("р", "і");
				break;
			case "о":
				s = s.replace("о", "й");
				break;
			case "л":
				s = s.replace("л", "к");
				break;
			case "ь":
				s = s.replace("ь", "м");
				break;
			case "в":
				s = s.replace("в", "п");
				break;
			case "г":
				s = s.replace("г", "с");
				break;
			case "ж":
				s = s.replace("ж", "т");
				break;
			case "з":
				s = s.replace("з", "у");
				break;
			case "і":
				s = s.replace("і", "ф");
				break;
			case "й":
				s = s.replace("й", "х");
				break;
			case "к":
				s = s.replace("к", " ");
				break;
			case "м":
				s = s.replace("м", "ч");
				break;
			case "п":
				s = s.replace("п", "ш");
				break;
			case "с":
				s = s.replace("с", "щ");
				break;
			case "т":
				s = s.replace("т", "и");
				break;
			case "у":
				s = s.replace("у", "ї");
				break;
			case "ф":
				s = s.replace("ф", "є");
				break;
			case "х":
				s = s.replace("х", "ю");
				break;
			case " ":
				s = s.replace(" ", "я");
				break;
			case "ч":
				s = s.replace("ч", "б");
				break;
			case "ш":
				s = s.replace("ш", "а");
				break;
			case "щ":
				s = s.replace("щ", "н");
				break;
			case "и":
				s = s.replace("и", "д");
				break;
			case "ї":
				s = s.replace("ї", "е");
				break;
			case "є":
				s = s.replace("є", "р");
				break;
			case "ю":
				s = s.replace("ю", "о");
				break;
			case "я":
				s = s.replace("я", "л");
				break;
			}
			encrypt += s;
		}
		signatureOpen();

		tf1.setText(null);
		tf2.setText(null);

		System.out.println(encrypt + key);

		FileWriter writer = new FileWriter("file.txt");
		writer.write(encrypt + key);
		writer.flush();
		writer.close();
	}

	public void decrypt() {
		string = tf1.getText();
		String stringS = string.substring(0, string.indexOf("|"));
		String stringSS = string.substring(string.indexOf("|") + 1);
		String s;

		for (int i = 0; i < stringS.length(); i++) {
			int j = i + 1;
			s = stringS.substring(i, j);
			switch (s) {
			case "ь":
				s = s.replace("ь", "б");
				break;
			case "в":
				s = s.replace("в", "а");
				break;
			case "г":
				s = s.replace("г", "н");
				break;
			case "ж":
				s = s.replace("ж", "д");
				break;
			case "з":
				s = s.replace("з", "е");
				break;
			case "і":
				s = s.replace("і", "р");
				break;
			case "й":
				s = s.replace("й", "о");
				break;
			case "к":
				s = s.replace("к", "л");
				break;
			case "м":
				s = s.replace("м", "ь");
				break;
			case "п":
				s = s.replace("п", "в");
				break;
			case "с":
				s = s.replace("с", "г");
				break;
			case "т":
				s = s.replace("т", "ж");
				break;
			case "у":
				s = s.replace("у", "з");
				break;
			case "ф":
				s = s.replace("ф", "і");
				break;
			case "х":
				s = s.replace("х", "й");
				break;
			case " ":
				s = s.replace(" ", "к");
				break;
			case "ч":
				s = s.replace("ч", "м");
				break;
			case "ш":
				s = s.replace("ш", "п");
				break;
			case "щ":
				s = s.replace("щ", "с");
				break;
			case "и":
				s = s.replace("и", "т");
				break;
			case "ї":
				s = s.replace("ї", "у");
				break;
			case "є":
				s = s.replace("є", "ф");
				break;
			case "ю":
				s = s.replace("ю", "х");
				break;
			case "я":
				s = s.replace("я", " ");
				break;
			case "б":
				s = s.replace("б", "ч");
				break;
			case "а":
				s = s.replace("а", "ш");
				break;
			case "н":
				s = s.replace("н", "щ");
				break;
			case "д":
				s = s.replace("д", "и");
				break;
			case "е":
				s = s.replace("е", "ї");
				break;
			case "р":
				s = s.replace("р", "є");
				break;
			case "о":
				s = s.replace("о", "ю");
				break;
			case "л":
				s = s.replace("л", "я");
				break;
			}
			decrypt += s;
		}

		signatureClose(stringSS);

		System.out.println(decrypt + " Your signature is " + keyClose);

		tf1.setText(null);
		tf2.setText(null);
		decrypt = "";
	}

	public void signatureClose(String string) {
		keyClose = "";
		key = tf2.getText();
		int e = Integer.parseInt(key.substring(0, key.indexOf(",")));
		int n = Integer.parseInt(key.substring(key.indexOf(",") + 1));

		ArrayList<String> l = new ArrayList<String>();

		while (string.length() >= 2) {
			int j = string.indexOf("|");
			l.add(string.substring(0, j));
			string = string.substring(j + 1);
		}

		for (int i = 0; i < l.size(); i++) {
			int j = (int) Math.pow(Integer.parseInt(l.get(i)), e);
			keyClose = keyClose + alphabet.get((j % n) - 1);
		}
	}

	public void signatureOpen() {
		int e = 7;
		int n = 33;

		signature = tf2.getText();

		for (int i = 0; i < signature.length(); i++) {
			int j = i + 1;
			String s = signature.substring(i, j);
			int number = alphabet.indexOf(s) + 1;
			key += Integer.toString(((int) Math.pow(number, e)) % n) + "|";
		}
		key = "|" + key;
	}
}