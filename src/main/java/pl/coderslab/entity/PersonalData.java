package pl.coderslab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personalData")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long id;
    @NotBlank
    @Size(min = 2)

    @NotBlank
    @Size(min = 2)
    private String firstName;
    @NotBlank
    @Size(min = 2)
    private String lastName;
    @NotNull
    @Min(1)
    private int goal;
    @NotNull
    @Min(12)
    private int age;
    @NotNull
    @Min(1)
    private int height;
    @NotNull
    @Min(1)
    private double weight;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}