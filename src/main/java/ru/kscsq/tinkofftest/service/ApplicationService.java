package ru.kscsq.tinkofftest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kscsq.tinkofftest.entity.Application;
import ru.kscsq.tinkofftest.exception.EntityNotFoundException;
import ru.kscsq.tinkofftest.repository.ApplicationRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepositoryImpl applicationRepository;

    public List<Application> getAllApplications() {
        List<Application> applications = new ArrayList<>();
        applicationRepository.findAll().forEach(applications::add);
        return applications;
    }


    public Application getApplication(int id) throws EntityNotFoundException {
        Application application = applicationRepository.findTopByContactIdOrderByDateCreatedDesc(id);
        if (application == null)
            throw new EntityNotFoundException(Application.class, "id", id + "");
        else
            return application;
    }

}
