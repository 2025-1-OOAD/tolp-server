package ooad.tolp.service;

import ooad.tolp.dto.Request.AssignmentRequest;
import ooad.tolp.dto.Request.GradeRequest;
import ooad.tolp.dto.Request.SubmissionRequest;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    public void createAssignment(AssignmentRequest request) {
        // TODO: 과제 등록 처리
    }

    public void submitAssignment(Long id, SubmissionRequest request) {
        // TODO: 과제 제출 처리
    }

    public void gradeAssignment(GradeRequest request) {
        // TODO: 과제 채점 처리
    }

    public void getAssignmentResult(Long submissionId) {
        // TODO: 과제 결과 조회 처리
    }
}
