package kr.kosmo.jobkorea.adm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.kosmo.jobkorea.adm.model.admAtdMngModel;
import kr.kosmo.jobkorea.adm.model.processFailModel;
import kr.kosmo.jobkorea.tut.dao.TestDao;
import kr.kosmo.jobkorea.tut.model.TestModel;
import kr.kosmo.jobkorea.tut.model.TestQue;
import kr.kosmo.jobkorea.tut.model.AttendanceModel;
import kr.kosmo.jobkorea.tut.model.LecInfo;
import kr.kosmo.jobkorea.tut.model.TestEnroll;
import kr.kosmo.jobkorea.adm.dao.admAtdMngDao;

@Service
public class admAtdMngServiceimpl implements admAtdMngService {


	
	@Autowired
	admAtdMngDao admAtdMngDao;
	
	@Autowired
	TestDao testdao;
	
	//강사 리스트 조회
	@Override
	public List<admAtdMngModel> adm_list_Tutor(Map<String, Object> paramMap) throws Exception {
		List<admAtdMngModel> list_Tutor = admAtdMngDao.adm_list_Tutor(paramMap);
		return list_Tutor;
	}
	
	@Override
	public int listTutCnt(Map<String, Object> paramMap) throws Exception {
		
		int listTutCnt = admAtdMngDao.listTutCnt(paramMap);
		
		return listTutCnt;
	}
	
	@Override
	public List<LecInfo> lecture_List_Select(Map<String, Object> paramMap){
		
		List<LecInfo> lecture_List_Select = admAtdMngDao.lecture_List_Select(paramMap);
		
		return lecture_List_Select;
	}
	
	@Override
	public int listLecCnt(Map<String, Object> paramMap) throws Exception {
		
		int listLecCnt = admAtdMngDao.listLecCnt(paramMap);
		
		return listLecCnt;
	}
	

	
}
