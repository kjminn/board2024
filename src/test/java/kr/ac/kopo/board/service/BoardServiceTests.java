package kr.ac.kopo.board.service;


import kr.ac.kopo.board.dto.BoardDTO;
import kr.ac.kopo.board.dto.PageRequestDTO;
import kr.ac.kopo.board.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardDTO dto = BoardDTO.builder()
                .title("101 Board Test...")
                .content("101 Board Test Board Test Board Test")
                .writerEmail("user7@kopo.ac.kr")
                .build();
        Long bno = boardService.register(dto);
        System.out.println("정상적으로 글이 저장되었습니다. : "+bno);
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO  = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for (BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }

    }

    @Test
    public void testGet(){
        Long bno = 1L;

        BoardDTO boardDTO = boardService.get(bno);

        System.out.println(boardDTO);
    }

    @Test
    public void testRemove(){
        Long bno = 1L;
        boardService.removeWithReplies(bno);
    }

    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(2L)
                .title("수정한 제목 연습")
                .content("수정한 내용 연습")
                .build();

        boardService.modify(boardDTO);
    }
}
