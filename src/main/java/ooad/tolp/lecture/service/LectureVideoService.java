package ooad.tolp.lecture.service;

import ooad.tolp.lecture.dto.LectureVideoRequest;
import ooad.tolp.lecture.dto.LectureVideoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureVideoService {

    public void uploadVideo(Long lectureId, Long videoId, LectureVideoRequest request) {
        // TODO: 강의 영상 업로드 처리
    }

    public void deleteVideo(Long lectureId, Long videoId) {
        // TODO: 강의 영상 삭제 처리
    }

    public List<LectureVideoResponse> getLectureVideos(Long lectureId) {
        // TODO: 강의 영상 리스트 조회
        return List.of();
    }
}
