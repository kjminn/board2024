package kr.ac.kopo.board.repository;

import kr.ac.kopo.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
