package service.impl;

import dao.DAO;
import domain.JobVacancy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.JobVacancyService;
import service.fake.JobVacancyDaoFake;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyJobVacancyServiceTests {

    private JobVacancyService jobVacancyService;

    @BeforeEach
    /*void setUp() {
        DAO<JobVacancy> jobVacancyDAO = new JobVacancyDaoFake();
        jobVacancyService = new MyJobVacancyService(jobVacancyDAO);
    }*/

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllAspirantJobVacancy_returnedAllAspirantJobVacancy() throws Exception {
        ArrayList<JobVacancy> result = this.jobVacancyService.getAllAspirantJobVacancy();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    /*@Test
    void addJobVacancy_jobVacancy_addedJobVacancy() throws Exception {
        JobVacancy jobVacancy = new JobVacancy();
        jobVacancy.setName("name");

        this.jobVacancyService.addJobVacancy(jobVacancy);
        jobVacancy = this.jobVacancyService.getJobVacancy("name");

        assertTrue(jobVacancy.getName().equals("name"));
    }*/

}
