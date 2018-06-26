package ru.kscsq.tinkofftest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  })
    public @ResponseBody List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @RequestMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  })
    public Application getApplication(@PathVariable int id) throws EntityNotFoundException {
        return applicationService.getApplication(id);
    }

}
