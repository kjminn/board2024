package kr.ac.kopo.board.service;

import kr.ac.kopo.board.dto.ReplyDTO;
import kr.ac.kopo.board.entity.Board;
import kr.ac.kopo.board.entity.Reply;
import kr.ac.kopo.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
    private final ReplyRepository replyRepository;
    @Override
    public Long register(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);

        return reply.getRno();
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);
    }

    @Override
    public void remove(Long rno) {
        replyRepository.deleteById(rno);
    }

    @Override
    public List<ReplyDTO> getList(Long bno) {
        List<Reply> replyList = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());
        List<ReplyDTO> replyDTOList = replyList.stream().map(reply -> entityToDTO(reply)).collect(Collectors.toList());
        return replyDTOList;
    }
}
