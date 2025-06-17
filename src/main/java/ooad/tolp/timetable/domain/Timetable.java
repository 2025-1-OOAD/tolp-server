package ooad.tolp.timetable.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.user.domain.User;

import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor
public class Timetable {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private User owner;

   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinColumn(name = "timetable_id")
   private final List<TimetableLecture> timetableLectures = new ArrayList<>();



    public Timetable(User owner) {
        this.owner = owner;
    }

    public void updateLectureTime(Long lectureId, String newTime) {
        for (TimetableLecture t1 : timetableLectures) {
            if (t1.getLecture().getId().equals(lectureId)) {
                t1.updateTime(newTime);
                return;
            }
        }
        throw new IllegalArgumentException("해당 강의가 시간표에 없습니다.");
    }
}