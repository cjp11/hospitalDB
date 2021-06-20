package ui;

import java.util.Scanner;

import action.Action;
import action.PatientListAction;
import controller.PatientController;

public class ManagePatientUI {
	
	public void managePatientMain() {
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		PatientController patientController = new PatientController();
		
		do {
			System.out.println("ȯ�� ���� �޴�");
			System.out.println("1. ȯ�ڵ��");
			System.out.println("2. ȯ�ڸ��");
			System.out.println("3. ȯ����������");
			System.out.println("4. ȯ����������");
			System.out.println("5. ���� �޴�����");
			System.out.print("�޴� ��ȣ: ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			Action action = null;
			
			switch(menu) {
			case 1:
				//action = new PatientAddAction();		// �ڽ� ��ü �ּ� �޴´�.
				break;
			case 2:
				System.out.println("ȯ�ڸ��");
				action = new PatientListAction();
				break;
			case 3:
				//action = new MemberUpdateAction();
				//System.out.println("ȸ����������");
				break;
			case 4:
				//System.out.println("ȸ����������");
				//action = new MemberDeleteAction();
				break;
			case 5:
				System.out.println("���� �޴���");
				isStop = true;
				break;
			default:
				System.out.println("�߸� �Է��ϼ̳׿�");
				break;
			}
			if(action != null) {
				patientController.processRequest(action, sc);
			}
		}while(!isStop);
		
	}
}
