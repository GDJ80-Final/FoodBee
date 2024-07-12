package com.gd.foodbee.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.foodbee.dto.NoticeDTO;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NoticeMapper {
	//전체 공지사항
    //파라미터="HashMap" 
  	//반환값="HashMap"
	//사용클래스=NoticeService.getNoticeList
    List<HashMap<String, Object>> noticeList(HashMap<String,Object> m);
    //전사원별 공지사항
    //파라미터="HashMap" 
  	//반환값="HashMap"
    //사용클래스=NoticeService.getAllEmpNoticeList
    List<HashMap<String,Object>> allEmpNoticeList(HashMap<String,Object> m);
    //부서별 공지사항
  //파라미터="HashMap" 
  	//반환값="HashMap"
    //사용클래스=NoticeService.getAllDptNoticeList
    List<HashMap<String,Object>> allDptNoticeList(HashMap<String,Object> m);
    
    //전체공지사항의 총갯수 구하기
    //반환값="int"
    //사용클래스=NoticeService.getCountnoticeList
    int countNoticeList();
    //전사원별공지사항 총갯수 구하기
    int countEmpNoticeList();
    //부서별공지사항 총갯수 구하기
    int countDptNoticeList();
    
    //공지사항 추가하기
    int insertNotice(NoticeDTO noticeDTO);
}