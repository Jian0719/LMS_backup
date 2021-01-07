package kr.kosmo.jobkorea.adm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kosmo.jobkorea.tut.model.AttendanceModel;
import kr.kosmo.jobkorea.tut.model.LecInfo;
import kr.kosmo.jobkorea.tut.model.LecStdInfo;
import kr.kosmo.jobkorea.tut.model.TestEnroll;
import kr.kosmo.jobkorea.tut.model.TestModel;
import kr.kosmo.jobkorea.tut.model.TestQue;
import kr.kosmo.jobkorea.tut.service.TestService;
import kr.kosmo.jobkorea.adm.model.EquipmentControlModel;
import kr.kosmo.jobkorea.adm.model.admAtdMngModel;
import kr.kosmo.jobkorea.adm.service.admAtdMngService;

@Controller
@RequestMapping("/adm/")
public class admAtdMngController {
	
	@Autowired
	admAtdMngService admAtdMngService;
	
	@Autowired
	TestService TestService;
	
	
	// Set logger
		private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
		
		private final String className = this.getClass().toString();
	

	
	@RequestMapping("attendanceControl.do")
	public String admAtdMng(@RequestParam Map<String, Object> paramMap,HttpSession session,Model model)throws Exception {
		

		logger.info("+ Start " + className + ".attendanceControl");
		logger.info("   - paramMap : " + paramMap);
		logger.info("+ End " + className + ".attendanceControl");
		
		return "adm/learn_mng/admAtdMng";
	}
	
	@RequestMapping("admlistTut.do")
	@ResponseBody
	public Map<String, Object> adm_list_Tutor(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
	
		logger.info("+ Start " + className + ".listTut");
		logger.info("   - paramMap : " + paramMap);
		

		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));
		int pageIndex = (currentPage-1)*pageSize;
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		
		logger.info("+ pageIndex " + className + pageIndex);
		logger.info("+ pageSize " + className + pageSize);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		//강사 리스트 조회
		List<admAtdMngModel> list_Tutor = admAtdMngService.adm_list_Tutor(paramMap);
		
		logger.info("+ list_Tutor " + list_Tutor);

		
		int listTutCnt = admAtdMngService.listTutCnt(paramMap);
		
		
		model.addAttribute("list_Tutor",list_Tutor);
		resultMap.put("list_Tutor", list_Tutor);
		System.out.println("왜야야야" + list_Tutor);
		
		
		
		//강사 리스트 갯수
		/*resultMap.put("list_Tutor", list_Tutor);*/
		resultMap.put("listTutCnt", listTutCnt);
		resultMap.put("pageSize",pageSize);
		
		
		return resultMap;
		
	}
	
	
	/*@RequestMapping("lec_List.do")
	public String atdMng(@RequestParam Map<String, Object> paramMap,HttpSession session,Model model)throws Exception {
		
		logger.info("+ Start " + className + ".lec_List");
		logger.info("   - paramMap : " + paramMap);
		
		  String tutor_id = (String) paramMap.get("loginID");
	      paramMap.put("tutor_id", tutor_id);
	      
	      List<LecInfo> lecture_List = TestService.lecture_List_Select(paramMap);
	      model.addAttribute("lecture_List", lecture_List);
	      
	   logger.info("+ lecture_List " + lecture_List);
		
		return "adm/learn_mng/admAtdMng";
	}*/
	
	/*장비 목록 조회*/
	@RequestMapping("lec_List.do")
	@ResponseBody
	public Map<String, Object> lec_List(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
	
		
		logger.info("+ Start " + className + ".lec_List");
		logger.info("   - paramMap : " + paramMap);
		
		
		 String tutor_id = (String) paramMap.get("loginID");
	     paramMap.put("tutor_id", tutor_id);
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;	
		
		
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		

		//장비 목록 조회
	    List<LecInfo> lecture_List = TestService.lecture_List_Select(paramMap);
		resultMap.put("lecture_List", lecture_List);
		logger.info("+ End " + className + ".lecture_List");

		
		
		//공통 그룹코드 목록 카운트 조회
		int totalCount = admAtdMngService.listLecCnt(paramMap);

		resultMap.put("totalCount", totalCount);
		resultMap.put("pageSize", pageSize);
		resultMap.put("currentPageComnGrpCod",currentPage);

		logger.info("+ End " + className + ".listLecCnt");

		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/atdList")
	public List<AttendanceModel> atdList(int lec_id,HttpSession session)throws Exception {
		logger.info("+ Start " + className + ".atdList");
		
		List<AttendanceModel> result = TestService.atdList(lec_id);
		
		logger.info("+ End " + className + ".atdList");
		return result;
	}

	
//////출석부 상세조회///////////
	@RequestMapping("/atdMng_Detail")
	public String atdMng_Detail(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,  HttpServletResponse response, HttpSession session) throws Exception {

		List<AttendanceModel> result = TestService.nameList(Integer.parseInt((String) paramMap.get("lec_id")));
		ArrayList list = new ArrayList();

		for (int i = 0; i < result.size(); i++) {
			String[] a = result.get(i).getAll_state().split(",");
			String[] re = new String[a.length + 1];
			re[0] = result.get(i).getName();
			for (int j = 1; j < re.length; j++) {
				re[j] = a[j - 1];
			}
			list.add(re);
			paramMap.put("result", list);
		}
		model.addAttribute("atd_Date_List", TestService.atd_Date(paramMap));
		model.addAttribute("atd_std_List", list);

		return "/adm/learn_mng/admAtdMng2";
	}

	@ResponseBody
	@RequestMapping("/atdReg")
	public Map<String, Object> atdReg(Model model, @RequestParam(value="Arr[]") List<String> Arr, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,  HttpServletResponse response, HttpSession session) throws Exception {
	      
		
		  SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd");
		  Date time = new Date();
		  String time1 = format1.format(time);
		  paramMap.put("len_date", time1);
		  System.out.println("!!!!"+time1);
	      List<AttendanceModel> list_atd = new ArrayList<AttendanceModel>();
	      int lecId = 0;
	      for(String list : Arr) {
	    	  AttendanceModel result = new AttendanceModel();
	         String[] a = list.split(",");
	         result.setLec_id(Integer.parseInt(a[0]));
	         result.setStd_id(a[1]);
	         result.setAtd_state(a[2]);
	         result.setLen_date(time1);
	         lecId = result.getLec_id();
	         paramMap.put("lec_id", lecId);
	         list_atd.add(result);
	         paramMap.put("result", result);
	        }
	      System.out.println("@!#!@$#!@%여기 "+TestService.searchByDate(paramMap).size());
	      if(TestService.searchByDate(paramMap).size()==0){
	    	  int a = TestService.atd_plus(lecId);
	      }
	      for (int i = 0; i<list_atd.size(); i++) {
	    	  AttendanceModel sys = new AttendanceModel();
	    	  sys = TestService.searchAtd(list_atd.get(i));
	    	  System.out.println(sys);
	    	  if(TestService.searchAtd(list_atd.get(i))== null){
	    		TestService.atdStd(list_atd.get(i));
	    	  }else{
	    		  int result = TestService.updateAtd(list_atd.get(i));
	    	  }
		}
	      return paramMap;
	   }   
	
	
}


