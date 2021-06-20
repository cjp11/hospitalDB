package svc;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.PatientDAO;
import vo.Patient;


public class PatientListService {
	public ArrayList<Patient> patients;
	public boolean listPatientInfo() {
		boolean isListSuccess = false;
		Connection con = getConnection();
		PatientDAO patientDAO = new PatientDAO(con);
		
		patients = patientDAO.listPatient();
		//int listCount = memberDAO.listMember();
		if(patients != null) {		// 리스트 보여주는 것은 이 이하의 코드 필요없을듯, 나중에 수정하기 
			commit(con);
			isListSuccess = true;
		}else {
			rollback(con);
		}
		
		return isListSuccess;
	}
}
