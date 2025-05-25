package ooad.tolp.quiz.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ooad.tolp.quiz.domain.Quiz;
import ooad.tolp.quiz.dto.QuizRequest;
import ooad.tolp.quiz.dto.QuizResponse;
import ooad.tolp.quiz.repository.QuizRepository;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.lecture.repository.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class QuizService {

    private final QuizRepository quizRepository;
    private final LectureRepository lectureRepository;

    public QuizResponse createQuiz(QuizRequest request) {
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found"));

        Quiz quiz = Quiz.builder()
                .title(request.getTitle())
                .questionList(request.getQuestionList())
                .deadline(request.getDeadline())
                .lecture(lecture)
                .build();

        return QuizResponse.fromEntity(quizRepository.save(quiz));
    }

    @Transactional(readOnly = true)
    public List<QuizResponse> getQuizzesByLecture(Long lectureId) {
        return quizRepository.findAllByLectureId(lectureId).stream()
                .map(QuizResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteQuiz(Long id) {
        if (!quizRepository.existsById(id)) {
            throw new EntityNotFoundException("Quiz not found");
        }
        quizRepository.deleteById(id);
    }
}