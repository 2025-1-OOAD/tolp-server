package ooad.tolp.assignment.service;

import ooad.tolp.assignment.dto.*;
import ooad.tolp.global.security.common.dto.GradeRequest;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    public void createAssignment(Long lectureId, AssignmentRequest request) {
        // TODO: 과제 등록 처리
    }

    public void submitAssignment(Long lectureId, Long assignmentId, SubmissionRequest request) {
        // TODO: 과제 제출 처리
    }

    public void gradeAssignment(Long lectureId, GradeRequest request) {
        // TODO: 과제 채점 처리
    }

    public SubmissionResponse getAssignmentResult(Long lectureId, Long submissionId) {
        // TODO: 과제 결과 조회 처리
        return new SubmissionResponse();
    }
}