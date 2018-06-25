package ru.kscsq.tinkofftest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kscsq.tinkofftest.entity.Application;

@Repository
public interface ApplicationRepositoryImpl extends CrudRepository<Application, Integer> {

    Application findTopByContactIdOrderByDateCreatedDesc(@Param("contact_id") int id);

}
