package util;


import java.util.ArrayList;
import java.util.Scanner;


import vo.Patient;

public class ConsoleUtil {
	static Scanner sc = new Scanner(System.in);
	public void showPatients(ArrayList<Patient> patients) {
		for(int i=0; i<patients.size(); i++) {
			System.out.println(patients.get(i).toString());
		}
	}
	
	public java.sql.Date inputDay() {
		System.out.println("�Կ��� ��¥ �Է�: ");
		String day = sc.nextLine();
		java.sql.Date d = java.sql.Date.valueOf(day);	
		
		return d;
	}
	
	public void showWard(int[][] wardA,int[][] wardB) {
		for(int i=0; i<wardA.length; i++) {
			if(i == 0) System.out.printf("<< %d�� ���� �� �ִ� �ο�:6 >>\n",i+1);
			else if(i==1 ||i==2) System.out.printf("<< %d�� ���� �� �ִ� �ο�:2 >>\n",i+1);
			else System.out.printf("<< %d�� ���� �� �ִ� �ο�:1 >>\n",i+1);
			for(int j=0; j<wardA[i].length; j++) {
				System.out.printf("A�� %d0%dȣ �ο�: %d\n",i+1,j+1,wardA[i][j]);
			}
		}
		for(int i=0; i<wardB.length; i++) {
			if(i == 0) System.out.printf("<< %d�� ���� �� �ִ� �ο�:6 >>\n",i+1);
			else if(i==1 ||i==2) System.out.printf("<< %d�� ���� �� �ִ� �ο�:2 >>\n",i+1);
			else System.out.printf("<< %d�� ���� �� �ִ� �ο�:1 >>\n",i+1);
			for(int j=0; j<wardB[i].length; j++) {
				System.out.printf("B�� %d0%dȣ �ο�: %d\n",i+1,j+1,wardB[i][j]);
			}
		}
	}
}
