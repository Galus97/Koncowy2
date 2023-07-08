package pl.coderslab.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.PersonalData;
import pl.coderslab.entity.User;
import pl.coderslab.repository.PersonalDataRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;

    public PersonalData savePersonalData(PersonalData personalData){
        return personalDataRepository.save(personalData);
    }

    public PersonalData findByUser(User user){
        return personalDataRepository.findByUser(user);
    }

}
