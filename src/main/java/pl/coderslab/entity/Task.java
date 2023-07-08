package pl.coderslab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String generalPurpose;
    @NotBlank
    @Size(min = 3)
    private String firstStep;
    @NotBlank
    @Size(min = 3)
    private String secondStep;

    @ManyToOne
    private User user;
}
