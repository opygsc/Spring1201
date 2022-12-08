package com.human.cafe1201;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.human.service.IF_BoardService;
import com.human.util.FileDataUtil;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;

@Controller
public class BbsController {
	
	@Inject // 주입하려고 하는 객체의 타입이 일치하는 객체를 자동으로 주입
	private IF_BoardService bsrv;
	
	@Inject // 주입하려고 하는 객체의 타입이 일치하는 객체를 자동으로 주입
	private FileDataUtil fileDataUtil;

	@RequestMapping(value = "/wrForm", method = RequestMethod.GET)
	public String wrForm(Locale locale, Model model) {
		return "bbs/wrForm";
	}

	@RequestMapping(value = "/wrAction", method = RequestMethod.POST)
	public String wrAction(Locale locale, Model model, BoardVO bVo, MultipartFile[] file) throws Exception {
//	객체로 받을 때는 파라미터 이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야 함 -> 자동맵핑

//		System.out.println(bVo.getName() + " 디버깅 용도");
//		System.out.println(fileNames[0] + "/" + fileNames[1]);
//		System.out.println(file.getOriginalFilename() + " 첨부파일 디버깅 용도");
		
//		fileDataUtil 객체의 fileUpload 메서드를 호출, 매개변수로 file을 넘김 <지정한 폴더로 첨부파일 복사>
		String[] fileNames = fileDataUtil.fileUpload(file);
//		System.out.println(fileNames[0] + " : DB에 저장될 파일명");
		System.out.println(fileNames.length + "dadf");
		
//		넘겨받을 파일명을 BoardVO files 변수에 저장함
		bVo.setFiles(fileNames);

//		DB작업
		bsrv.insertOne(bVo);

		return "home";
	}

	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public String bbsList(Locale locale, Model model, @ModelAttribute("pageVO") PageVO pVo) throws Exception {
//	객체로 받을 때는 파라미터 이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야 함 -> 자동맵핑

//		page 계산하기 위해서는 첫번째 페이지정보 (클라이언트가 넘김), 두번째는 전체페이지 수, 세번째는 페이지당 그리고 페이지그룹당 수
		if (pVo.getPage() == null) { // 클라이언트가 페이지정보를 넘겨주지않는다면 기본값 1로 세팅
			pVo.setPage(1);
		}
		System.out.println("현재 페이지 정보 : " + pVo.getPage());

		int totalpageCnt = bsrv.countBoard(); // select count(*) from login;
		System.out.println(totalpageCnt + "건 등록됨");
		pVo.setTotalCount(totalpageCnt);

		List<BoardVO> list = bsrv.selectAll(pVo); // 페이징 쿼리에 맵핑, 매개변수 필요

		System.out.println(list.size() + "건 가져옴, 디버깅용");
		model.addAttribute("bList", list); // 넘길 변수명, 자료형
		model.addAttribute("pageVo", pVo); // 페이지 객체를 View에게 전달
		return "bbs/bbsList";
	}

	@RequestMapping(value = "/bbsView", method = RequestMethod.GET)
	public String bbsView(Locale locale, Model model, @RequestParam("vNo") String vNo) throws Exception {
//	객체로 받을 때는 파라미터 이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야 함 -> 자동맵핑

//		DB작업
		bsrv.updateCnt(vNo);
		BoardVO tempVo = bsrv.selectOne(vNo);
		model.addAttribute("boardVo", tempVo);

		List<String> attachList = bsrv.selectAttach(vNo);
		model.addAttribute("attachList", attachList);
//		System.out.println(attachList.get(0));
		return "bbs/bbsView";
	}

	@RequestMapping(value = "/bbsMod", method = RequestMethod.GET)
	public String bbsMod(Locale locale, Model model, @RequestParam("vNo") String vNo) throws Exception {
//	객체로 받을 때는 파라미터 이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야 함 -> 자동맵핑

//		DB작업
		BoardVO tempVo = bsrv.selectOne(vNo);
		model.addAttribute("boardVo", tempVo);

		return "bbs/bbsMod";
	}

	@RequestMapping(value = "/bbsModAction", method = RequestMethod.POST)
	public String bbsModAction(Locale locale, Model model, BoardVO bVo) throws Exception {
//	객체로 받을 때는 파라미터 이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야 함 -> 자동맵핑

//		DB작업
		bsrv.updateBoard(bVo);

		return "redirect:/bbsView?vNo=" + bVo.getNum();
	}

	@RequestMapping(value = "/bbsDel", method = RequestMethod.GET)
	public String bbsDel(Locale locale, Model model, @RequestParam("vNo") String vNo) throws Exception {
//	객체로 받을 때는 파라미터 이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야 함 -> 자동맵핑

//		DB작업
		bsrv.deleteBoard(vNo);

		return "redirect:/bbsList";
	}
}