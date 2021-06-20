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
	// �ǹ̻� DAO�� �־�� ����. 
	// DAO���� ���� �����͸� �������Ƿ� ��Ȳ�� �ǽð����� �ٲ� �� ����. 
	public static int[][] wardA = new int[4][];	// 4�� �ǹ�
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
		// ȯ�� ���� ��ġ ��� �˰���
		int floor = pwr.getHo()/100;	// ��
		int offset = pwr.getHo()%10;	// ȣ
		if(pwr.getWname() == 'A') {	// A����
			if(floor == 1) {	// ��
				if(offset == 1) {	// ȣ
					wardA[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardA[floor-1][offset-1]++;
				}else {
					wardA[floor-1][offset-1]++;
				}
			}else if(floor == 2) {
				if(floor == 1) {	// ȣ
					wardA[floor-1][offset-1]++;
				}else if(floor == 2) {
					wardA[floor-1][offset-1]++;
				}else {
					wardA[floor-1][offset-1]++;
				}
			}else if(floor == 3) {
				if(offset == 1) {	// ȣ
					wardA[floor-1][offset-1]++;
				}else if(offset== 2) {
					wardA[floor-1][offset-1]++;
				}else {
					wardA[floor-1][offset-1]++;
				}
			}else {	// pwr.getHo()/100 == 4�� ���
				if(offset == 1) {	// ȣ
					wardA[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardA[floor-1][offset-1]++;
				}else if(offset == 3){
					wardA[floor-1][offset-1]++;
				}else if(offset == 4) {
					wardA[floor-1][offset-1]++;
				}else {	//5ȣ
					wardA[floor-1][offset-1]++;
				}
			}
			
		}else {	// B����
			if(floor == 1) {	// ��
				if(offset == 1) {	// ȣ
					wardB[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardB[floor-1][offset-1]++;
				}else {
					wardB[floor-1][offset-1]++;
				}
			}else if(floor == 2) {
				if(floor == 1) {	// ȣ
					wardB[floor-1][offset-1]++;
				}else if(floor == 2) {
					wardB[floor-1][offset-1]++;
				}else {
					wardB[floor-1][offset-1]++;
				}
			}else if(floor == 3) {
				if(offset == 1) {	// ȣ
					wardB[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardB[floor-1][offset-1]++;
				}else {
					wardB[floor-1][offset-1]++;
				}
			}else {	// pwr.getHo()/100 == 4�� ���
				if(offset == 1) {	// ȣ
					wardB[floor-1][offset-1]++;
				}else if(offset == 2) {
					wardB[floor-1][offset-1]++;
				}else if(offset == 3){
					wardB[floor-1][offset-1]++;
				}else if(offset == 4) {
					wardB[floor-1][offset-1]++;
				}else {	//5ȣ
					wardB[floor-1][offset-1]++;
				}
			}
		}
	}
	
	
	public ArrayList<Patient> listPatient() {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		PreparedStatement pstmt = null;	// SQL�� ����
		ResultSet rs = null;			//select ���� ��� �� �����
		String sql = null;
		
		try {
			sql = "select * from patient";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //Ŀ�� ����� �̵�, ������ ���� ����
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Patient pat = new Patient();	// �Ű����� ���� ����Ʈ �⺻ �����ڸ� PatientŬ������ �߰�
				// Patient mem = null �� �����ϸ� Patient �ν��Ͻ� �ʱ�ȭ���� �ʾ�
				// �Ʒ��� pat.set~() �Լ��� ����� �� ����. nullpointerException �߻�.
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
	
		PreparedStatement pstmt = null;	// SQL�� ����
		ResultSet rs = null;			//select ���� ��� �� �����
		String sql = null;
		
		try {
			sql = "select patient.pno, pname, ward.wno, wname, ho, capacity, wpay from ward, record, patient where ward.wno = record.wno and record.pno = patient.pno and dischargedate > ?";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //Ŀ�� ����� �̵�, ������ ���� ����
			pstmt.setDate(1, day);
			rs = pstmt.executeQuery();
			if(rs.next()) isZero = true;
			
			while(rs.next()) {
				PatWaRecord pwr = new PatWaRecord();	// �Ű����� ���� ����Ʈ �⺻ �����ڸ� PatientŬ������ �߰�
				// Patient mem = null �� �����ϸ� Patient �ν��Ͻ� �ʱ�ȭ���� �ʾ�
				// �Ʒ��� pat.set~() �Լ��� ����� �� ����. nullpointerException �߻�.
				pwr.setPno(rs.getString(1));
				pwr.setPname(rs.getString(2));
				pwr.setWno(rs.getString(3));
				pwr.setWname(rs.getString(4).charAt(0));
				pwr.setHo(rs.getInt(5));
				pwr.setCapacity(rs.getInt(6));
				pwr.setWpay(rs.getInt(7));
				
				pwrlist.add(pwr);
				
				// ȯ�� ���� ��ġ ��� �˰���
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
