package ooad.tolp.service;

import ooad.tolp.dto.Request.LectureRequest;
import ooad.tolp.dto.Request.LectureVideoRequest;
import ooad.tolp.dto.Response.LectureResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class LectureService {

    public void createLecture(LectureRequest request) {
        // TODO: 강의 개설 처리
    }

    public void updateLecture(Long id, LectureRequest request) {
        // TODO: 강의 수정 처리
    }

    public void searchLecture(String keyword) {
        // TODO: 강의 검색 처리
    }

    public void updateLectureVideo(Long videoId, LectureVideoRequest request) {
        // TODO: 강의 영상 업로드 처리
    }

    public void deleteLectureVideo(Long videoId) {
        // TODO: 강의 영상 삭제 처리
    }

    public void getLectureVideos(Long lectureId) {
        // TODO: 강의 영상 목록 조회 처리
    }
}
