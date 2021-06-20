package ui;

import java.util.Scanner;

public class PatientMainUI {

	public void patientMain() {
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		ManagePatientUI managePatientUI = new ManagePatientUI();
		SearchPatientUI searchPatientUI = new SearchPatientUI();
		
		do {
			System.out.println("****ȯ�� �޴�******");
			System.out.println("****1. ȯ�� ����****");
			System.out.println("****2. ȯ�� �˻�****");
			System.out.println("****3. ���� �޴�******");
			System.out.println("�޴���ȣ: ");
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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}while(!isStop);
		
	}

}
