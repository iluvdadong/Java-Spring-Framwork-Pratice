package examples.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import examples.springmvc.dto.Board;
import examples.springmvc.dto.SearchCondition;
import examples.springmvc.service.BoardService;

@Controller
@RequestMapping(path = "/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public String list(Model model){
	      SearchCondition searchCondition = new SearchCondition();
		
        List<Board> boards = boardService.getBoards(searchCondition);
        model.addAttribute("list", boards);
        model.addAttribute("count", boardService.getBoardCount());

        return "boards/list";
    }

    @GetMapping("/{id}")
    public String getBoard(@PathVariable(name = "id")Long id, Model model){
        Board board = boardService.getBoard(id);
        model.addAttribute("board", board);

        return "boards/view";
    }

    @GetMapping("/writeform")
    public String writeform(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if(user == null)
            return "redirect:/users/loginerror";
        return "boards/writeform";
    }
}
