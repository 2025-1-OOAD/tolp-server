package ooad.tolp.quiz.repository;

import ooad.tolp.quiz.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findAllByLectureId(Long lectureId);
}