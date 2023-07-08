package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.PersonalData;
import pl.coderslab.entity.User;

public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {

    PersonalData findByUser(User user);

}
