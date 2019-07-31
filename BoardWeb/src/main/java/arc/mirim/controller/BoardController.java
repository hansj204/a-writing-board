package arc.mirim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import arc.mirim.domain.BoardVO;
import arc.mirim.domain.Criteria;
import arc.mirim.service.BoardService;
import arc.mirim.service.ReplyService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService brdService;
	
	@Autowired
	ReplyService repService;
	
	@GetMapping("/main")
	public String main(Model model) {
		return "/board/main";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list...");
		List<BoardVO> brdlist = brdService.getList();
		for(BoardVO boardVO : brdlist) {
			System.out.println(boardVO);
		}
		model.addAttribute("sample", "3518 한수정");
		model.addAttribute("list", brdService.getList());
		return "/board/list";
	}
	
	@PostMapping("/list")
	public String listpost(Criteria cri, Model model) {
		System.out.println("seraching...");
		List<BoardVO> searchlist = brdService.getSearch(cri);
		for(BoardVO boardVO : searchlist) {
			System.out.println(boardVO);
		}
		model.addAttribute("list", brdService.getSearch(cri));
		return "/board/list";
	}
	
	@GetMapping("/register")
	public String register() {
		System.out.println("reg get...");
		return "/board/register";
	}
	
	@PostMapping("/register")
	public String register(BoardVO board) {
		System.out.println("reg post...");
		brdService.register(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		System.out.println("get get...");
		System.out.println(brdService.get(bno));
		model.addAttribute("board", brdService.get(bno));
		model.addAttribute("replylist", repService.getList(bno));
	}
	
	@GetMapping("/modify")
	public void modify(@RequestParam("bno") Long bno, Model model) {
		System.out.println("modify get...");
		model.addAttribute("board", brdService.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board) {
		System.out.println("modify post...");
		brdService.modify(board);
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Long bno) {
		System.out.println("remove get...");
		brdService.remove(bno);
		return "redirect:/board/list";
	}
	
	
}
