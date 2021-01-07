package kr.kosmo.jobkorea.adm.model;


public class testPersonControlModel {
		

		//tb_test(시험 테이블)
		private int test_id; //시험 ID
		private int lec_id; //강의 ID
		private String test_name; //시험명
		private String test_sort; //시험 분류
		private String test_start; //시작일
		private String test_end; //종료일
		private int test_id_2; //시험 묶음 ID(본시, 재시 
		
		//tb_test_user(시험 응시 정보 테이블)
		private String std_id;
		private int test_sco;
		private String pass;
		
		//tb_lec_info(강의 정보 테이블)
		private String lec_name; //강의명
		private String c_st; //강의 시작일
		private String c_end; //강의 종료일
		private String pre_pnum;
		
		//tb_userinfo(회원테이블)
		private String name;// 이름 
		private String loginID;
		
		//DB_tb_test_user
		private String sco; //시험점수가 있는 사람 - 응시자 수
		private String minNum; // 미응시자 수
		
		private String std_num;
		private int test_sco_f;
		
		
		public String getName_f() {
			return name_f;
		}
		public void setName_f(String name_f) {
			this.name_f = name_f;
		}
		public String getStd_num_f() {
			return std_num_f;
		}
		public void setStd_num_f(String std_num_f) {
			this.std_num_f = std_num_f;
		}
		public int getTest_sco_f_f() {
			return test_sco_f_f;
		}
		public void setTest_sco_f_f(int test_sco_f_f) {
			this.test_sco_f_f = test_sco_f_f;
		}
		public String getState_f() {
			return state_f;
		}
		public void setState_f(String state_f) {
			this.state_f = state_f;
		}
		private String name_f;// 이름 
		private String std_num_f;
		private int test_sco_f_f;
		private String state_f;
		

	public int getTest_sco_f() {
			return test_sco_f;
		}
		public void setTest_sco_f(int test_sco_f) {
			this.test_sco_f = test_sco_f;
		}
	public String getStd_num() {
			return std_num;
		}
		public void setStd_num(String std_num) {
			this.std_num = std_num;
		}
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public int getLec_id() {
		return lec_id;
	}
	public void setLec_id(int lec_id) {
		this.lec_id = lec_id;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	public String getTest_sort() {
		return test_sort;
	}
	public void setTest_sort(String test_sort) {
		this.test_sort = test_sort;
	}
	public String getTest_start() {
		return test_start;
	}
	public void setTest_start(String test_start) {
		this.test_start = test_start;
	}
	public String getTest_end() {
		return test_end;
	}
	public void setTest_end(String test_end) {
		this.test_end = test_end;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public int getTest_sco() {
		return test_sco;
	}
	public void setTest_sco(int test_sco) {
		this.test_sco = test_sco;
	}
	public String getLec_name() {
		return lec_name;
	}
	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getSco() {
		return sco;
	}
	public void setSco(String sco) {
		this.sco = sco;
	}
	public String getMinNum() {
		return minNum;
	}
	public void setMinNum(String minNum) {
		this.minNum = minNum;
	}
	
	public String getC_st() {
		return c_st;
	}
	public void setC_st(String c_st) {
		this.c_st = c_st;
	}
	public String getC_end() {
		return c_end;
	}
	public void setC_end(String c_end) {
		this.c_end = c_end;
	}
	
	public String getPre_pnum() {
		return pre_pnum;
	}
	public void setPre_pnum(String pre_pnum) {
		this.pre_pnum = pre_pnum;
	}
	public int getTest_id_2() {
		return test_id_2;
	}
	public void setTest_id_2(int test_id_2) {
		this.test_id_2 = test_id_2;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
