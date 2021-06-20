package action;

import java.util.Scanner;

import svc.PatientListService;
import util.ConsoleUtil;

public class PatientListAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
	
		PatientListService patientListService = new PatientListService();
		ConsoleUtil cu = new ConsoleUtil();
		
		boolean isListSuccess = patientListService.listPatientInfo();
		if(isListSuccess) {
			cu.showPatients(patientListService.patients);
			System.out.println("ȯ�� ��� �����ֱ� ����");
		}else {
			System.out.println("ȯ�� ��� �����ֱ� ����");
		}	
	}

}
