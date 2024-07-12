package com.gd.foodbee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.gd.foodbee.dto.NoticeDTO;
import com.gd.foodbee.dto.NoticeFileDTO;
import com.gd.foodbee.dto.NoticeRequest;
import com.gd.foodbee.service.NoticeService;
import com.gd.foodbee.util.TeamColor;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NoticeController {
	@Autowired NoticeService noticeService;
	
	@GetMapping("/noticeList")//전체List
	public String noticeList(
			@RequestParam(name="currentPage", defaultValue="1") int currentPage,
			@RequestParam(name="rowPerPage", defaultValue="10") int rowPerPage,
			Model model) {
		
		log.debug(TeamColor.PURPLE + "currentPage =>" + currentPage );
		log.debug(TeamColor.PURPLE + "rowPerPage =>" + rowPerPage);
		
		List<HashMap<String,Object>> list = noticeService.getNoticeList(currentPage, rowPerPage);
		List<HashMap<String,Object>> allEmpList = noticeService.getAllEmpNoticeList(currentPage, rowPerPage);
		List<HashMap<String,Object>> allDptList = noticeService.getAllDptNoticeList(currentPage, rowPerPage);
		
		log.debug(TeamColor.PURPLE + "list=>" + list);
		log.debug(TeamColor.PURPLE + "allEmpList=>" + allEmpList);
		log.debug(TeamColor.PURPLE + "allDptList=>" + allDptList);
		
		//총 공지사항의 갯수
		int cntNotice = noticeService.getCountNoticeList();
		log.debug(TeamColor.PURPLE + "cntNotice=>" + cntNotice);
		
		model.addAttribute("list", list);
		model.addAttribute("allEmpList", allEmpList);
		model.addAttribute("allDptList", allDptList);
	return "noticeList";
	}
	
	@GetMapping("/addNotice")//공지사항 추가
	public String addNotice() {
	return "addNotice";
	}
	
	@PostMapping("/addNoticeAction")
	public String addNoticeAction(NoticeRequest noticeRequest) {
		log.debug(TeamColor.PURPLE + "noticeRequest=>" + noticeRequest);

		noticeService.addNotice(noticeRequest);
		
	return"redirect:/noticeList";
	
	}
	
	
}
