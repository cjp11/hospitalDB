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
		if(patients != null) {		// ����Ʈ �����ִ� ���� �� ������ �ڵ� �ʿ������, ���߿� �����ϱ� 
			commit(con);
			isListSuccess = true;
		}else {
			rollback(con);
		}
		
		return isListSuccess;
	}
}
