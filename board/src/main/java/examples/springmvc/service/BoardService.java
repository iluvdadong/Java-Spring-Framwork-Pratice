package examples.springmvc.service;

import examples.springmvc.dao.BoardMapper;
import examples.springmvc.dto.Board;
import examples.springmvc.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Transactional(readOnly = false)
    public int addBoard(Board board){
        return boardMapper.addBoard(board);
    }

    @Transactional
    public List<Board> getBoards(SearchCondition searchCondition){
        return boardMapper.getBoards(searchCondition);
    }

    @Transactional
    public Board getBoard(Long id){
        return boardMapper.getBoard(id);
    }

    @Transactional
    public int getBoardCount() {
        return boardMapper.getBoardCount();
    }
}
