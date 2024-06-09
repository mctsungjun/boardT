package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.BoardDto;
import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String save(){
        return "save";
    }
    @PostMapping("save")
    public String save(BoardDto boardDto){
        System.out.println("boardDto: " + boardDto);
        boardService.save(boardDto);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<BoardDto> boardDtoList = boardService.findAll();
        System.out.println(boardDtoList.toString());
        model.addAttribute("boardList",boardDtoList);

        return "list";
    }
    // /10, /1
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        // 조회수 처리
        boardService.updateHits(id);
        // 상세 내용
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board",boardDto);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String updateFrom(@PathVariable("id") Long id, Model model){
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board",boardDto);
        return "update";


    }
    @PostMapping("/update/{id}")
    public String update(BoardDto boardDto, Model model){
        boardService.update(boardDto);
        BoardDto dto = boardService.findById(boardDto.getId());
        model.addAttribute("board",dto);
        return "detail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        boardService.delete(id);
        return "redirect:/list";
    }
}
