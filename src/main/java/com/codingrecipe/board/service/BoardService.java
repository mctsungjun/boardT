package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDto;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDto boardDto) {
        boardRepository.save(boardDto);
    }

    public List<BoardDto> findAll() {

        return boardRepository.findAll();
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDto findById(Long id) {
        return boardRepository.findById(id);
    }
    public void update(BoardDto boardDto){
        boardRepository.update(boardDto);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }
}
