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
			System.out.println("환자 목록 보여주기 성공");
		}else {
			System.out.println("환자 목록 보여주기 실패");
		}	
	}

}
