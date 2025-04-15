package ooad.tolp.assignment.service;

import ooad.tolp.assignment.dto.AssignmentRequest;
import ooad.tolp.assignment.dto.GradeRequest;
import ooad.tolp.assignment.dto.SubmissionRequest;
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
