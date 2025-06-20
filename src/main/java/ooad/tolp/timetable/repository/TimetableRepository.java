package ooad.tolp.timetable.repository;

import ooad.tolp.timetable.domain.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimetableRepository extends JpaRepository <Timetable, Long> {
    Optional<Timetable> findByOwnerId(Long userId);
}
