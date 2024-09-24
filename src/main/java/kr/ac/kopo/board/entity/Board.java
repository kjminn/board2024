package kr.ac.kopo.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class Board extends BaseEntity{
    @Id // 기본키(primary key) 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 자동증가(auto-increment)
    private Long bno;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;//Foreign Key  설정(참조무결성 유지)

//    변경된 제목으로 수정
    public void changeTitle(String title){
        this.title = title;
    }

//    변경된 내용으로 수정
    public void changeContent(String content){
        this.content = content;
    }
}
