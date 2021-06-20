package ui;

import java.util.Scanner;

public class MainUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		
		PatientMainUI patientMainUI = new PatientMainUI();
		DoctorMainUI doctorMainUI = new DoctorMainUI();
		
		do {
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("********병원 관리 프로그램******");
		System.out.println("**********1.환자 데이터******");
		System.out.println("**********2.의사 데이터******");
		System.out.println("**********3.프로그램 종료******");

		int menu= sc.nextInt();
		sc.nextLine();
		
		switch(menu) {
		case 1:
			patientMainUI.patientMain();
			break;
		case 2:
			doctorMainUI.doctorMain();
			break;
		case 3:
			isStop = true;
			break;
		}
		
		}while(!isStop) ;
		sc.close();
	}

}
