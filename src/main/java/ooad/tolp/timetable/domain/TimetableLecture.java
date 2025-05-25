package ooad.tolp.timetable.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooad.tolp.lecture.domain.Lecture;

@Entity
@Getter
@NoArgsConstructor
public class TimetableLecture {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Lecture lecture;

    private String customTime;

    public TimetableLecture(Lecture lecture, String customTime) {
        this.lecture = lecture;
        this.customTime = customTime;
    }

    public void updateTime(String newTime) {
        this.customTime = newTime;
    }
}
