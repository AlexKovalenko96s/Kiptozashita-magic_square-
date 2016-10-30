package ua.kas.kriptozashita;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	@FXML
	Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24,
			l25;

	@FXML
	TextField tf1, tf2;

	public boolean addEncryptClick = false;
	public boolean addDecryptClick = false;

	private int stringLength;

	private String string = "";
	private String encrypt = "";
	private String decrypt = "";
	private String signature = "";
	private String keyClose = "";
	private String key = "";

	private String[] letter = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z" };

	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<Label> labelList = new ArrayList<Label>();
	private LinkedList<String> alphabet = new LinkedList<String>(Arrays.asList(letter));

	public void addEncrypt() {
		string = tf1.getText();
		stringLength = string.length();
		if (stringLength <= 25) {
			for (int i = 0; i < stringLength; i++) {
				int j = i + 1;
				list.add(string.substring(i, j));
			}
			System.out.println(list);

			for (int i = 0; i < list.size(); i++) {
				labelList.get(i).setText(list.get(i));
			}

			for (int i = list.size(); i < 25; i++) {
				labelList.get(i).setText("_");
			}

			addEncryptClick = true;
			list.clear();
		} else {
			JOptionPane.showMessageDialog(null, "Please enter string no more then 25 elements!");
		}
	}

	public void addDecrypt() {
		string = tf1.getText();
		stringLength = string.length();
		l11.setText(string.substring(0, 1));
		l4.setText(string.substring(1, 2));
		l17.setText(string.substring(2, 3));
		l10.setText(string.substring(3, 4));
		l23.setText(string.substring(4, 5));
		l24.setText(string.substring(5, 6));
		l12.setText(string.substring(6, 7));
		l5.setText(string.substring(7, 8));
		l18.setText(string.substring(8, 9));
		l6.setText(string.substring(9, 10));
		l7.setText(string.substring(10, 11));
		l25.setText(string.substring(11, 12));
		l13.setText(string.substring(12, 13));
		l1.setText(string.substring(13, 14));
		l19.setText(string.substring(14, 15));
		l20.setText(string.substring(15, 16));
		l8.setText(string.substring(16, 17));
		l21.setText(string.substring(17, 18));
		l14.setText(string.substring(18, 19));
		l2.setText(string.substring(19, 20));
		l3.setText(string.substring(20, 21));
		l16.setText(string.substring(21, 22));
		l9.setText(string.substring(22, 23));
		l22.setText(string.substring(23, 24));
		l15.setText(string.substring(24, 25));

		String keyClose = string.substring(25);
		signatureClose(keyClose);

		addDecryptClick = true;
		string = "";
	}

	public void signatureOpen() {
		int e = 7;
		int n = 33;

		signature = tf2.getText();
		// signature.toLowerCase();

		for (int i = 0; i < signature.length(); i++) {
			int j = i + 1;
			String s = signature.substring(i, j);
			int number = alphabet.indexOf(s) + 1;
			key += Integer.toString(((int) Math.pow(number, e)) % n) + "|";
		}
	}

	public void signatureClose(String string) {
		keyClose = "";
		String closeKey = tf2.getText();
		int e = Integer.parseInt(closeKey.substring(0, closeKey.indexOf(",")));
		int n = Integer.parseInt(closeKey.substring(closeKey.indexOf(",") + 1));

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

	public void encrypt() throws IOException {
		if (addEncryptClick = true) {
			key = "";
			signatureOpen();

			encrypt = l11.getText();
			encrypt += l4.getText();
			encrypt += l17.getText();
			encrypt += l10.getText();
			encrypt += l23.getText();
			encrypt += l24.getText();
			encrypt += l12.getText();
			encrypt += l5.getText();
			encrypt += l18.getText();
			encrypt += l6.getText();
			encrypt += l7.getText();
			encrypt += l25.getText();
			encrypt += l13.getText();
			encrypt += l1.getText();
			encrypt += l19.getText();
			encrypt += l20.getText();
			encrypt += l8.getText();
			encrypt += l21.getText();
			encrypt += l14.getText();
			encrypt += l2.getText();
			encrypt += l3.getText();
			encrypt += l16.getText();
			encrypt += l9.getText();
			encrypt += l22.getText();
			encrypt += l15.getText();

			System.out.println(encrypt + key);

			FileWriter writer = new FileWriter("file.txt");
			writer.write(encrypt + key);
			writer.flush();
			writer.close();

			addEncryptClick = false;
			tf1.setText(null);
			tf2.setText(null);
			encrypt = "";
		}
	}

	public void decrypt() {
		if (addDecryptClick == true) {

			for (int i = 0; i < labelList.size(); i++) {
				decrypt += labelList.get(i).getText();
			}

			System.out.println(decrypt + " Your signature is " + keyClose);

			addDecryptClick = false;
			tf1.setText(null);
			tf2.setText(null);
			decrypt = "";
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		labelList.add(l6);
		labelList.add(l7);
		labelList.add(l8);
		labelList.add(l9);
		labelList.add(l10);
		labelList.add(l11);
		labelList.add(l12);
		labelList.add(l13);
		labelList.add(l14);
		labelList.add(l15);
		labelList.add(l16);
		labelList.add(l17);
		labelList.add(l18);
		labelList.add(l19);
		labelList.add(l20);
		labelList.add(l21);
		labelList.add(l22);
		labelList.add(l23);
		labelList.add(l24);
		labelList.add(l25);
	}
}