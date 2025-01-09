package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.enums.StudyFormat;

@Entity
@Table(name = "courses")
//
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_gen")
    @SequenceGenerator(name ="course_gen",sequenceName = "course_seq",allocationSize = 1)

    private  Long id;
    private String name;
    private int price;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    public Course(String name, int price, StudyFormat studyFormat) {
        this.name = name;
        this.price = price;
        this.studyFormat = studyFormat;
    }
}
