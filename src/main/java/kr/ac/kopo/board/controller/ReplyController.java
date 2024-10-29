package kr.ac.kopo.board.controller;

import kr.ac.kopo.board.dto.ReplyDTO;
import kr.ac.kopo.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @GetMapping(value = "/board/{bno}")
    public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno){
        return new ResponseEntity<>(replyService.getList(bno), HttpStatus.OK);
    }
}
