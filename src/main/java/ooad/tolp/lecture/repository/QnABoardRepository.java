package ooad.tolp.lecture.repository;

import ooad.tolp.lecture.domain.QnABoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QnABoardRepository extends JpaRepository<QnABoard, Long> {
    Optional<QnABoard> findByLectureId(Long lectureId);

}
