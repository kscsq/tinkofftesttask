package ru.kscsq.tinkofftest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kscsq.tinkofftest.entity.Application;
import ru.kscsq.tinkofftest.exception.EntityNotFoundException;
import ru.kscsq.tinkofftest.service.ApplicationService;

import java.util.List;


@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @RequestMapping("/{id}")
    public Application getApplication(@PathVariable int id) throws EntityNotFoundException {
        return applicationService.getApplication(id);
    }

}
