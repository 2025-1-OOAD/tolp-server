package ooad.tolp.lecture.repository;

import ooad.tolp.lecture.domain.QnABoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnABoardRepository extends JpaRepository<QnABoard, Long> {
    QnABoard findByLectureId(Long lectureId);
}
