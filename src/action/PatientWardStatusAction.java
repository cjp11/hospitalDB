package action;

import java.util.Scanner;

import svc.PatientWardStatusService;
import util.ConsoleUtil;

public class PatientWardStatusAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		PatientWardStatusService patientWardStatusService = new PatientWardStatusService();
		ConsoleUtil cu = new ConsoleUtil();
		java.sql.Date day = cu.inputDay();
		
		boolean isSuccess = patientWardStatusService.showWardInfo(day);
		if(isSuccess) {
			cu.showWard(PatientWardStatusService.wardA,PatientWardStatusService.wardB);
			System.out.println("현재 병동 현황 보여주기 성공");
		}else {
			System.out.println("현재 병동 현황 보여주기 실패");
		}	
	}

}
