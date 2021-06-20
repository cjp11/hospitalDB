package controller;

import java.util.Scanner;

import action.Action;

public class PatientController {

	public void processRequest(Action action, Scanner sc) {
		try {
			action.execute(sc);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
