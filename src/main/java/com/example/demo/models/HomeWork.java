package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "homeworks")
public class HomeWork {
    public enum Grade {
        NONE,
        A,
        B,
        C,
        D,
        F
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String homework;
    @Column(nullable = false, columnDefinition = "int(1) default 0")
    private Grade grade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_homeworks_users"))
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate passDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeWork homeWork = (HomeWork) o;
        return grade == homeWork.grade && Objects.equals(id, homeWork.id) && Objects.equals(homework, homeWork.homework);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homework, grade);
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "id=" + id +
                ", homework='" + homework + '\'' +
                ", grade=" + grade +
                ", student=" + user +
                ", passDate=" + passDate +
                '}';
    }
}
