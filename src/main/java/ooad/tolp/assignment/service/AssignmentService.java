package ooad.tolp.assignment.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ooad.tolp.assignment.domain.Assignment;
import ooad.tolp.assignment.dto.AssignmentRequest;
import ooad.tolp.assignment.dto.AssignmentResponse;
import ooad.tolp.assignment.repository.AssignmentRepository;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.lecture.repository.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final LectureRepository lectureRepository;

    public AssignmentResponse createAssignment(AssignmentRequest request) {
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found"));

        Assignment assignment = Assignment.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .lecture(lecture)
                .build();

        return AssignmentResponse.fromEntity(assignmentRepository.save(assignment));
    }

    @Transactional(readOnly = true)
    public List<AssignmentResponse> getAssignmentsByLecture(Long lectureId) {
        return assignmentRepository.findAllByLectureId(lectureId).stream()
                .map(AssignmentResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteAssignment(Long id) {
        if (!assignmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Assignment not found");
        }
        assignmentRepository.deleteById(id);
    }
}