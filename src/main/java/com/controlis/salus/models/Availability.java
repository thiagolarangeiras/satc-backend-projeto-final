package com.controlis.salus.models;

import com.controlis.salus.dtos.AvailabilityInsertDto;
import com.controlis.salus.dtos.AvailabilityReturnDto;
import com.controlis.salus.models.enums.WeekDay;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "availabilitys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer weekDayTimeId;

    private Integer medicId;
    private WeekDay weekDay;
    private LocalDateTime dateTime;


    //Mapers
    public static AvailabilityReturnDto convertEntityToDto(Availability availability) {
        return new AvailabilityReturnDto(
                availability.getId(),
                availability.getWeekDayTimeId(),
                availability.getMedicId(),
                availability.getWeekDay(),
                availability.getDateTime()
        );
    }

    public static Availability convertDtoToEntity(AvailabilityInsertDto dto) {
        return Availability.builder()
                .medicId(dto.medicId())
                .weekDay(dto.weekDay())
                .dateTime(dto.dateTime())
                .build();
    }
}