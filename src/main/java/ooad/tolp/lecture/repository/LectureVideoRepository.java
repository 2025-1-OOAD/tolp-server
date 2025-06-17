package ooad.tolp.lecture.repository;

import ooad.tolp.lecture.domain.LectureVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LectureVideoRepository extends JpaRepository<LectureVideo, Long> {
    List<LectureVideo> findAllByLectureId(Long lectureId);
}
