package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.PatWaRecord;
import vo.Patient;

public class PatientDAO {
	Connection con;
	// 의미상 DAO에 있어야 맞음. 
	// DAO에서 병동 데이터를 가져오므로 현황이 실시간으로 바뀔 수 있음. 
	public static int[][] wardA = new int[4][];	// 4층 건물
	public static int[][] wardB = new int[4][];
	
	public static void initWard() {
		wardA[0] = new int[3];
		wardA[1] = new int[3];
		wardA[2] = new int[3];
		wardA[3] = new int[5];
		wardB[0] = new int[3];
		wardB[1] = new int[3];
		wardB[2] = new int[3];
		wardB[3] = new int[5];
	}
	
	public PatientDAO(Connection con) {
		this.con = con;
	}
	
	public void countPatientWard(PatWaRecord pwr) {
		// 환자 병실 위치 기록 알고리즘
		int floor = pwr.getHo()/100;	// 층
		int offset = pwr.getHo()%10;	// 호
		if(pwr.getWname() == 'A') {	// A병동
			if(floor == 1) {	// 층
				if(offset == 1) {	// 호
					wardA[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardA[floor-1][offset-1]++;
				}else {
					wardA[floor-1][offset-1]++;
				}
			}else if(floor == 2) {
				if(floor == 1) {	// 호
					wardA[floor-1][offset-1]++;
				}else if(floor == 2) {
					wardA[floor-1][offset-1]++;
				}else {
					wardA[floor-1][offset-1]++;
				}
			}else if(floor == 3) {
				if(offset == 1) {	// 호
					wardA[floor-1][offset-1]++;
				}else if(offset== 2) {
					wardA[floor-1][offset-1]++;
				}else {
					wardA[floor-1][offset-1]++;
				}
			}else {	// pwr.getHo()/100 == 4인 경우
				if(offset == 1) {	// 호
					wardA[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardA[floor-1][offset-1]++;
				}else if(offset == 3){
					wardA[floor-1][offset-1]++;
				}else if(offset == 4) {
					wardA[floor-1][offset-1]++;
				}else {	//5호
					wardA[floor-1][offset-1]++;
				}
			}
			
		}else {	// B병동
			if(floor == 1) {	// 층
				if(offset == 1) {	// 호
					wardB[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardB[floor-1][offset-1]++;
				}else {
					wardB[floor-1][offset-1]++;
				}
			}else if(floor == 2) {
				if(floor == 1) {	// 호
					wardB[floor-1][offset-1]++;
				}else if(floor == 2) {
					wardB[floor-1][offset-1]++;
				}else {
					wardB[floor-1][offset-1]++;
				}
			}else if(floor == 3) {
				if(offset == 1) {	// 호
					wardB[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardB[floor-1][offset-1]++;
				}else {
					wardB[floor-1][offset-1]++;
				}
			}else {	// pwr.getHo()/100 == 4인 경우
				if(offset == 1) {	// 호
					wardB[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardB[floor-1][offset-1]++;
				}else if(offset == 3){
					wardB[floor-1][offset-1]++;
				}else if(offset == 4) {
					wardB[floor-1][offset-1]++;
				}else {	//5호
					wardB[floor-1][offset-1]++;
				}
			}
		}
	}
	
	
	public ArrayList<Patient> listPatient() {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		PreparedStatement pstmt = null;	// SQL문 전달
		ResultSet rs = null;			//select 문의 결과 값 저장용
		String sql = null;
		
		try {
			sql = "select * from patient";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //커서 양방향 이동, 데이터 동적 갱신
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Patient pat = new Patient();	// 매개변수 없는 디폴트 기본 생성자를 Patient클래스에 추가
				// Patient mem = null 로 선언하면 Patient 인스턴스 초기화되지 않아
				// 아래의 pat.set~() 함수를 사용할 수 없음. nullpointerException 발생.
				pat.setPno(rs.getString(1));
				pat.setName(rs.getString(2));
				pat.setAge(rs.getInt(3));
				pat.setSex(rs.getString(4));
				patients.add(pat);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) close(rs);
				if(pstmt != null) close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return patients;
	}
	
	public boolean showStatusWard(java.sql.Date day) {
		ArrayList<PatWaRecord> pwrlist = new ArrayList<PatWaRecord>();
		boolean isZero = false;
		PatientDAO.initWard();
	
		PreparedStatement pstmt = null;	// SQL문 전달
		ResultSet rs = null;			//select 문의 결과 값 저장용
		String sql = null;
		
		try {
			sql = "select patient.pno, pname, ward.wno, wname, ho, capacity, wpay from ward, record, patient where ward.wno = record.wno and record.pno = patient.pno and dischargedate > ?";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //커서 양방향 이동, 데이터 동적 갱신
			pstmt.setDate(1, day);
			rs = pstmt.executeQuery();
			if(rs.next()) isZero = true;
			
			while(rs.next()) {
				PatWaRecord pwr = new PatWaRecord();	// 매개변수 없는 디폴트 기본 생성자를 Patient클래스에 추가
				// Patient mem = null 로 선언하면 Patient 인스턴스 초기화되지 않아
				// 아래의 pat.set~() 함수를 사용할 수 없음. nullpointerException 발생.
				pwr.setPno(rs.getString(1));
				pwr.setPname(rs.getString(2));
				pwr.setWno(rs.getString(3));
				pwr.setWname(rs.getString(4).charAt(0));
				pwr.setHo(rs.getInt(5));
				pwr.setCapacity(rs.getInt(6));
				pwr.setWpay(rs.getInt(7));
				
				pwrlist.add(pwr);
				
				// 환자 병실 위치 기록 알고리즘
				countPatientWard(pwr);
			}
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) close(rs);
				if(pstmt != null) close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return isZero;
	}
}
