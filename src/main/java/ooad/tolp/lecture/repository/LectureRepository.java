package ooad.tolp.lecture.repository;

import ooad.tolp.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findAllByInstructorId(Long instructorId);
}
