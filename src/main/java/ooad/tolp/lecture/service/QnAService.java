package ooad.tolp.lecture.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ooad.tolp.lecture.domain.QnA;
import ooad.tolp.lecture.domain.QnABoard;
import ooad.tolp.lecture.dto.QnARequest;
import ooad.tolp.lecture.dto.QnAResponse;
import ooad.tolp.lecture.repository.QnARepository;
import ooad.tolp.lecture.repository.QnABoardRepository;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class QnAService {

    private final QnARepository qnaRepository;
    private final QnABoardRepository qnaBoardRepository;
    private final UserRepository userRepository;

    public List<QnAResponse> getQnAsByWriter(User writer) {
        return qnaRepository.findAllByWriter(writer).stream()
                .map(QnAResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public QnAResponse postQnA(QnARequest request, User writer) {
        QnABoard board = qnaBoardRepository.findByLectureId(request.getLectureId())
                .orElseThrow(() -> new EntityNotFoundException("QnABoard not found"));

        QnA qna = QnA.builder()
                .content(request.getContent())
                .board(board)
                .writer(writer)
                .parent(request.getParentId() != null ? qnaRepository.findById(request.getParentId()).orElse(null) : null)
                .build();

        return QnAResponse.fromEntity(qnaRepository.save(qna));
    }

    @Transactional(readOnly = true)
    public List<QnAResponse> getQnAsByBoard(Long boardId) {
        return qnaRepository.findAllByBoardId(boardId).stream()
                .map(QnAResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<QnAResponse> getQnAsByLecture(Long lectureId) {
        QnABoard board = qnaBoardRepository.findByLectureId(lectureId)
                .orElseThrow(() -> new EntityNotFoundException("QnABoard not found"));
        return qnaRepository.findAllByBoardId(board.getId()).stream()
                .map(QnAResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteQnA(Long id) {
        QnA qna = qnaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("QnA not found"));
        qna.setDeleted(true);
    }
}
