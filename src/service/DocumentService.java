package service;

import domain.HRManager;
import service.exception.ServiceException;
import viewModel.Aspirant;
import viewModel.AspirantInvitation;
import viewModel.AspirantResume;
import viewModel.JobVacancy;

public interface DocumentService {

    void createPdf(String path, AspirantResume resume)
            throws IllegalArgumentException, ServiceException;

    void createPdf(String path, JobVacancy jobVacancy)
            throws IllegalArgumentException, ServiceException;

    void createPdf(String path, Aspirant aspirant)
            throws IllegalArgumentException, ServiceException;

    void createPdf(String path, AspirantInvitation invitation)
            throws IllegalArgumentException, ServiceException;

    void createPdf(String path, HRManager hrManager)
            throws IllegalArgumentException, ServiceException;

}
