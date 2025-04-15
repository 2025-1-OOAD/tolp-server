// ✅ QnAService.java
package ooad.tolp.lecture.service;

import ooad.tolp.lecture.dto.QnARequest;
import ooad.tolp.lecture.dto.QnAResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnAService {

    public void postQuestion(Long lectureId, QnARequest request) {
        // TODO: 질문 등록 처리
    }

    public void replyToQuestion(Long lectureId, Long parentId, QnARequest request) {
        // TODO: 답글 등록 처리
    }

    public void updateQnA(Long lectureId, Long qnaId, QnARequest request) {
        // TODO: 질문/답변 수정 처리
    }

    public void deleteQnA(Long lectureId, Long qnaId) {
        // TODO: 질문/답변 삭제 처리
    }

    public List<QnAResponse> getQnAList(Long lectureId) {
        // TODO: 질문 목록 조회 처리
        return List.of();
    }
}