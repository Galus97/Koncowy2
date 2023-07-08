package pl.coderslab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    private Long id;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 3)
    private String username;

    @NotNull
    @Size(min = 6)
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PersonalData personalData;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Task> task = new ArrayList<>();
}
