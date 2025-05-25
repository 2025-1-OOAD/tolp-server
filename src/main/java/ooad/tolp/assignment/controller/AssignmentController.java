package ooad.tolp.assignment.controller;

import lombok.RequiredArgsConstructor;
import ooad.tolp.assignment.dto.AssignmentRequest;
import ooad.tolp.assignment.dto.AssignmentResponse;
import ooad.tolp.assignment.service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<AssignmentResponse> create(@RequestBody AssignmentRequest request) {
        return ResponseEntity.ok(assignmentService.createAssignment(request));
    }

    @GetMapping("/lecture/{lectureId}")
    public ResponseEntity<List<AssignmentResponse>> getByLecture(@PathVariable Long lectureId) {
        return ResponseEntity.ok(assignmentService.getAssignmentsByLecture(lectureId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
