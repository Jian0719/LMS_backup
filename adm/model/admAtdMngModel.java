package kr.kosmo.jobkorea.adm.model;

import lombok.Data;

@Data
public class admAtdMngModel{
	
	//강사리스트 조회
	private String loginID;
	//강사 이름
	private String user_type;
	private String tel;
	private String mail;

	//시험ID
	private int test_id;
	//강의ID
	private int lec_id;
	//시험명
	private String test_name;
	//시험분류
	private String test_sort;
	//시작일
	private String test_start;
	//종료일
	private String test_end;
	
	
	private String tutor_name;
	
	//join용 추가 변수
	private String std_id;
	private int test_sco;
	private String pass;
	private String name;
	private String sc;
	
}