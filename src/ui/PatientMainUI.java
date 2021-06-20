package ui;

import java.util.Scanner;

public class PatientMainUI {

	public void patientMain() {
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		ManagePatientUI managePatientUI = new ManagePatientUI();
		SearchPatientUI searchPatientUI = new SearchPatientUI();
		
		do {
			System.out.println("****환자 메뉴******");
			System.out.println("****1. 환자 관리****");
			System.out.println("****2. 환자 검색****");
			System.out.println("****3. 이전 메뉴******");
			System.out.println("메뉴번호: ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: 
				managePatientUI.managePatientMain();
				break;
			case 2:
				searchPatientUI.searchPatientMain();
				break;
			case 3:
				isStop = true;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}while(!isStop);
		
	}

}
