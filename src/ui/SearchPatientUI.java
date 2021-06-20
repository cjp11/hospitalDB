package ui;

import java.util.Scanner;

import action.Action;
import action.PatientWardStatusAction;
import controller.PatientController;

public class SearchPatientUI {

	public void searchPatientMain() {
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		PatientController patientController = new PatientController();
		
		do {
			System.out.println("환자 검색 메뉴");
			System.out.println("1. 병실 현황");
			//System.out.println("2. 환자목록");
			//System.out.println("3. 환자정보수정");
			//System.out.println("4. 환자정보삭제");
			//System.out.println("5. 이전 메뉴종료");
			//System.out.print("메뉴 번호: ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			Action action = null;
			
			switch(menu) {
			case 1:
				action = new PatientWardStatusAction();		// 자식 객체 주소 받는다.
				break;
			case 2:
				//action = new PatientListAction();
				break;
			case 3:
				//action = new MemberUpdateAction();
				//System.out.println("회원정보수정");
				break;
			case 4:
				//System.out.println("회원정보삭제");
				//action = new MemberDeleteAction();
				break;
			case 5:
				System.out.println("이전 메뉴로");
				isStop = true;
				break;
			default:
				System.out.println("잘못 입력하셨네요");
				break;
			}
			if(action != null) {
				patientController.processRequest(action, sc);
			}
		}while(!isStop);
		sc.close();
	}

}
