package kr.kosmo.jobkorea.adm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.kosmo.jobkorea.tut.model.TestModel;
import kr.kosmo.jobkorea.tut.model.TestQue;
import kr.kosmo.jobkorea.adm.model.admAtdMngModel;
import kr.kosmo.jobkorea.tut.model.AttendanceModel;
import kr.kosmo.jobkorea.tut.model.LecInfo;
import kr.kosmo.jobkorea.tut.model.TestEnroll;

public interface admAtdMngService {
	
	//강사 목록 조회
	public List<admAtdMngModel> adm_list_Tutor(Map<String, Object> paramMap) throws Exception;
	
	public int listTutCnt(Map<String, Object> paramMap) throws Exception;

	public List<LecInfo> lecture_List_Select(Map<String, Object> paramMap);
	
	public int listLecCnt(Map<String, Object> paramMap) throws Exception;
	
}
