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
import arc.mirim.domain.ReplyVO;
import arc.mirim.service.BoardService;
import arc.mirim.service.ReplyService;

@Controller
@RequestMapping("/replies/")
public class ReplyController {
	

	@Autowired
	ReplyService repService;
	
	@PostMapping("new")
	public String register(@RequestParam("bno") Long bno, ReplyVO vo) {
		System.out.println("rep..."+vo+" ");
		repService.insert(vo);
		return "redirect:/board/get?bno="+bno;
	}
	
	@PostMapping("delete")
	public String delete(@RequestParam("bno") Long bno, Long rno) {
		repService.delete(rno);
		return "redirect:/board/get?bno="+bno;
	}
	
	
	
}
