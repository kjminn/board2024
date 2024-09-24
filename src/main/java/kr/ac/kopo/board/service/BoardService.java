package kr.ac.kopo.board.service;

import kr.ac.kopo.board.dto.BoardDTO;
import kr.ac.kopo.board.dto.PageRequestDTO;
import kr.ac.kopo.board.dto.PageResultDTO;
import kr.ac.kopo.board.entity.Board;
import kr.ac.kopo.board.entity.Member;

public interface BoardService {
//    새글을 등록하는 기능
    Long register(BoardDTO dto);
//    게시목록 처리 기능
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
//   특정 게시글 하나를 조회하는 기능
    BoardDTO get(Long bno);
//    삭제 기능
    void removeWithReplies(Long bno);
//    수정 기능
    void modify(BoardDTO boardDTO);

//    Entity를 DTO로 변환하는 메소드
    default BoardDTO entityToDTO(Board board, Member member, Long replyCount){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())
                .build();

        return boardDTO;
    }

//    DTO를 Entity로 변환하는 메소드(
    default Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder()
                .email(dto.getWriterEmail())
                .build();

        Board board=Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }
}
