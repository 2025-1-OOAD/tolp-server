package ooad.tolp.qna.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ooad.tolp.lecture.domain.QnA;
import ooad.tolp.lecture.domain.QnABoard;
import ooad.tolp.qna.dto.QnARequest;
import ooad.tolp.lecture.dto.QnAResponse;
import ooad.tolp.lecture.repository.QnARepository;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class QnAService {

    private final QnARepository qnaRepository;
    private final QnABoardRepository qnaBoardRepository;
    private final UserRepository userRepository;

    public QnAResponse postQnA(QnARequest request) {
        QnABoard board = qnaBoardRepository.findById(request.getBoardId())
                .orElseThrow(() -> new EntityNotFoundException("QnABoard not found"));

        User writer = userRepository.findById(request.getWriterId())
                .orElseThrow(() -> new EntityNotFoundException("Writer not found"));

        QnA qna = QnA.builder()
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .writer(writer)
                .board(board)
                .build();

        if (request.getParentId() != null) {
            QnA parent = qnaRepository.findById(request.getParentId())
                    .orElseThrow(() -> new EntityNotFoundException("Parent QnA not found"));
            qna.setParent(parent);
        }

        return QnAResponse.fromEntity(qnaRepository.save(qna));
    }

    @Transactional(readOnly = true)
    public List<QnAResponse> getQnAsByBoard(Long boardId) {
        return qnaRepository.findAllByBoardId(boardId).stream()
                .map(QnAResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteQnA(Long id) {
        QnA qna = qnaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("QnA not found"));
        qna.setDeleted(true);
    }
}