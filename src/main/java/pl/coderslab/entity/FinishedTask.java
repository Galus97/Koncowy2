package pl.coderslab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "finished_tasks")
@Getter
@Setter
@ToString
public class FinishedTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String generalPurpose;

    @Column(nullable = false)
    private String firstStep;

    @Column(nullable = false)
    private String secondStep;

}
