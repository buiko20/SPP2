package service.impl;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import domain.Company;
import domain.HRManager;
import service.CompanyService;
import service.DocumentService;
import service.exception.ServiceException;
import service.utils.ArgumentVerificationService;
import viewModel.Aspirant;
import viewModel.AspirantInvitation;
import viewModel.AspirantResume;
import viewModel.JobVacancy;

import java.io.FileOutputStream;

public class MyDocumentService implements DocumentService {

    private static final String LOGO = "logo.PNG";

    private CompanyService companyService;

    public MyDocumentService(CompanyService companyService) {

        ArgumentVerificationService.verifyNull(companyService, "companyService");

        this.companyService = companyService;
    }

    @Override
    public void createPdf(String path, AspirantResume resume)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(resume, "resume");

        try {

            Document document = this.createPdfTemplate(path);

            Paragraph paragraph = new Paragraph(resume.getSurname() + " " + resume.getName() + " " + resume.getPatronymic())
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Resume")
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Email: " + resume.getEmail() + "\r\n")
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA))
                    .setFontSize(20)
                    .add("CareerObjective: " + resume.getCareerObjective() + "\r\n")
                    .add("Skills: " + resume.getSkills() + "\r\n")
                    .add("Sex: " + resume.getSex() + "\r\n")
                    .add("Phone number: " + resume.getPhoneNumber() + "\r\n")
                    .add("Education: " + resume.getEducation() + "\r\n")
                    .add("English level: " + resume.getEnglishLevel() + "\r\n")
                    .add("Is relocation possible: " + resume.getIsRelocationPossible() + "\r\n")
                    .add("Is trip possible: " + resume.getIsTripPossible() + "\r\n")
                    .add("Date Of Birth: " + resume.getDateOfBirth() + "\r\n")
                    .add("Salary: " + resume.getSalary() + "\r\n")
                    .add("About me: " + resume.getAboutMe() + "\r\n");
            document.add(paragraph);

            document.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void createPdf(String path, JobVacancy jobVacancy)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(jobVacancy, "jobVacancy");

        try {

            Document document = this.createPdfTemplate(path);

            Paragraph paragraph = new Paragraph("Job vacancy")
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Status: " + jobVacancy.getStatus() + "\r\n")
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA))
                    .setFontSize(20)
                    .add("Name: " + jobVacancy.getName() + "\r\n")
                    .add("Date: " + jobVacancy.getDate() + "\r\n")
                    .add("Hr manager: " + jobVacancy.getHrManagerSurname() + " " + jobVacancy.getHrManagerName() + "\r\n")
                    .add("Hr manager phone: " + jobVacancy.getHrManagerPhoneNumber() + "\r\n")
                    .add("Hr manager email: " + jobVacancy.getHrManagerEmail() + "\r\n")
                    .add("Description: " + jobVacancy.getDescription() + "\r\n")
                    .add("Address: " + jobVacancy.getAddress() + "\r\n");
            document.add(paragraph);

            document.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void createPdf(String path, Aspirant aspirant)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(aspirant, "aspirant");

        try {

            Document document = this.createPdfTemplate(path);

            Paragraph paragraph = new Paragraph(aspirant.getSurname() + " " + aspirant.getName() + " " + aspirant.getPatronymic())
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Sex: " + aspirant.getSex() + "\r\n")
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA))
                    .setFontSize(20)
                    .add("Email: " + aspirant.getEmail() + "\r\n")
                    .add("Phone number: " + aspirant.getPhoneNumber() + "\r\n")
                    .add("Mailing address: " + aspirant.getMailingAddress() + "\r\n")
                    .add("Education: " + aspirant.getEducation() + "\r\n")
                    .add("English level: " + aspirant.getEnglishLevel() + "\r\n")
                    .add("Date Of Birth: " + aspirant.getDateOfBirth() + "\r\n")
                    .add("About me: " + aspirant.getAboutMe() + "\r\n")
                    .add("City Of residence: " + aspirant.getCityOfResidence() + "\r\n");
            document.add(paragraph);

            document.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void createPdf(String path, AspirantInvitation invitation)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(invitation, "invitation");

        try {

            Document document = this.createPdfTemplate(path);

            Paragraph paragraph = new Paragraph("Invitation")
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Date: " + invitation.getDate())
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA))
                    .setFontSize(20)
                    .add("Address: " + invitation.getAddress() + "\r\n")
                    .add("Aspirant email: " + invitation.getAspirantEmail() + "\r\n")
                    .add("Career objective: " + invitation.getAspirantCareerObjective() + "\r\n")
                    .add("Company name: " + invitation.getCompanyName() + "\r\n")
                    .add("Job vacancy name: " + invitation.getJobVacancyName() + "\r\n")
                    .add("Hr manager: " + invitation.getHrManagerSurname() + " " + invitation.getHrManagerName() + "\r\n")
                    .add("Hr manager phone: " + invitation.getHrManagerPhoneNumber() + "\r\n")
                    .add("Hr manager email: " + invitation.getHrManagerEmail() + "\r\n");
            document.add(paragraph);

            document.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void createPdf(String path, HRManager hrManager)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(hrManager, "hrManager");

        try {

            Document document = this.createPdfTemplate(path);

            Company company = this.companyService.getCompanyById(hrManager.getCompanyId());

            Paragraph paragraph = new Paragraph("HRManager")
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Hr manager: " + hrManager.getSurname() + " " + hrManager.getName() + "\r\n")
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA))
                    .setFontSize(20)
                    .add("Email: " + hrManager.getEmail() + "\r\n")
                    .add("Phone: " + hrManager.getPhoneNumber() + "\r\n")
                    .add("Company name: " + company.getName() + "\r\n")
                    .add("Company email: " + company.getEmail() + "\r\n")
                    .add("Company mailing address: " + company.getMailingAddress() + "\r\n")
                    .add("Company phone number: " + company.getPhoneNumber() + "\r\n");
            document.add(paragraph);

            document.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private Document createPdfTemplate(String path) throws Exception {
        FileOutputStream fos = new FileOutputStream(path);

        PdfWriter writer = new PdfWriter(fos);
        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf);

        Image logo = new Image(ImageDataFactory.create(LOGO));
        Paragraph paragraph = new Paragraph()
                .add(logo);
        document.add(paragraph);

        return document;
    }

}
