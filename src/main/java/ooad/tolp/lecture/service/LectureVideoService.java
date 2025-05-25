package ooad.tolp.lecture.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.lecture.domain.LectureVideo;
import ooad.tolp.lecture.dto.LectureVideoRequest;
import ooad.tolp.lecture.dto.LectureVideoResponse;
import ooad.tolp.lecture.repository.LectureRepository;
import ooad.tolp.lecture.repository.LectureVideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class LectureVideoService {

    private final LectureRepository lectureRepository;
    private final LectureVideoRepository lectureVideoRepository;

    public LectureVideoResponse uploadVideo(LectureVideoRequest request) {
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found"));

        LectureVideo video = LectureVideo.builder()
                .title(request.getTitle())
                .videoUrl(request.getVideoUrl())
                .postedAt(LocalDateTime.now())
                .lecture(lecture)
                .build();

        return LectureVideoResponse.fromEntity(lectureVideoRepository.save(video));
    }

    @Transactional(readOnly = true)
    public List<LectureVideoResponse> getVideosByLecture(Long lectureId) {
        return lectureVideoRepository.findAllByLectureId(lectureId).stream()
                .map(LectureVideoResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteVideo(Long id) {
        if (!lectureVideoRepository.existsById(id)) {
            throw new EntityNotFoundException("LectureVideo not found");
        }
        lectureVideoRepository.deleteById(id);
    }
}