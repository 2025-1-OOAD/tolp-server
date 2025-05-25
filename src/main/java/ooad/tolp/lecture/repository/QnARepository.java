package ooad.tolp.lecture.repository;

import ooad.tolp.lecture.domain.QnA;
import ooad.tolp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QnARepository extends JpaRepository<QnA, Long> {
    List<QnA> findAllByBoardId(Long boardId);
    List<QnA> findAllByWriter(User writer);
}