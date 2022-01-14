package org.springframework.samples.petclinic.feeding;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Feeding extends BaseEntity{

    @NotNull
    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	LocalDate startDate;
    @NotNull
    @Min(1)
    @Column(name = "weeks_duration")
    double weeksDuration;
    @ManyToOne
    @NotNull
    Pet pet;
    @ManyToOne
    FeedingType feedingType;
}
