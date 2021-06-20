package svc;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.PatientDAO;

public class PatientWardStatusService {
	public static int[][] wardA = new int[4][];	// 4층 건물
	public static int[][] wardB = new int[4][];
	public boolean showWardInfo(java.sql.Date day) {
		boolean isWardStatusSuccess = false;
		boolean isExist = false;
		Connection con = getConnection();
		PatientDAO patientDAO = new PatientDAO(con);
		
		
		isExist = patientDAO.showStatusWard(day);
		//init
		wardA[0] = new int[3];
		wardA[1] = new int[3];
		wardA[2] = new int[3];
		wardA[3] = new int[5];
		wardB[0] = new int[3];
		wardB[1] = new int[3];
		wardB[2] = new int[3];
		wardB[3] = new int[5];
		
		
		for(int i=0; i<wardA.length; i++) {
			for(int j=0; j<wardA[i].length; j++) {
				wardA[i][j] = PatientDAO.wardA[i][j];
			}
		}
		for(int i=0; i<wardA.length; i++) {
			for(int j=0; j<wardA[i].length; j++) {
				wardB[i][j] = PatientDAO.wardB[i][j];
			}
		}
		//int listCount = memberDAO.listMember();
		if(isExist) {		// 리스트 보여주는 것은 이 이하의 코드 필요없을듯, 나중에 수정하기 
			commit(con);
			isWardStatusSuccess = true;
		}else {
			rollback(con);
		}
		
		return isWardStatusSuccess;
	}
	
}
