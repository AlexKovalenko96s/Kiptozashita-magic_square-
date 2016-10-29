package ua.kas.kriptozashita;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	@FXML
	Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25;

	@FXML
	TextField tf1;

	private int stringLength;

	private String string = "";
	private String encrypt = "";

	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<Label> labelList = new ArrayList<Label>();

	public void add() {
		string = tf1.getText();
		stringLength = string.length();
		System.out.println(stringLength);
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

			list.clear();
		} else {
			JOptionPane.showMessageDialog(null, "Please enter string no more then 25 elements!");
		}
	}

	public void encrypt() {
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

		System.out.println(encrypt);

		encrypt = "";
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