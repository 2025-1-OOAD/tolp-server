package ooad.tolp.qna.service;

import ooad.tolp.qna.dto.QnARequest;
import org.springframework.stereotype.Service;

@Service
public class QnAService {

    public void postQuestion(QnARequest request) {
        // TODO: 질문 등록 처리
    }

    public void replyToQuestion(Long parentId, QnARequest request) {
        // TODO: 답글 등록 처리
    }

    public void updateQnA(Long id, QnARequest request) {
        // TODO: 질문/답글 수정 처리
    }

    public void deleteQnA(Long id) {
        // TODO: 질문/답글 삭제 처리
    }
}
