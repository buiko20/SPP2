package service.impl;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import domain.Company;
import domain.HRManager;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import service.CompanyService;
import service.DocumentService;
import service.exception.ServiceException;
import service.utils.ArgumentVerificationService;
import viewModel.Aspirant;
import viewModel.AspirantInvitation;
import viewModel.AspirantResume;
import viewModel.JobVacancy;

import java.io.*;

public class MyDocumentService implements DocumentService {

    private static final String LOGO = "D:\\Hamelioniya\\university\\3 курс\\СПП(Java)\\Лаб№2-8\\SPP2\\logo.PNG";
    private static final String RUSSIAN_FONT = "D:\\Hamelioniya\\university\\3 курс\\СПП(Java)\\Лаб№2-8\\SPP2\\FreeSans.ttf";

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
            PdfFont russian = PdfFontFactory.createFont(RUSSIAN_FONT, "Cp1251", true);

            Paragraph paragraph = new Paragraph(resume.getSurname() + " " + resume.getName() + " " + resume.getPatronymic())
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(russian)
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Resume")
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(russian)
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Email: " + resume.getEmail() + "\r\n")
                    .setFont(russian)
                    .setFontSize(20)
                    .add("Career objective: " + resume.getCareerObjective() + "\r\n")
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
            PdfFont russian = PdfFontFactory.createFont(RUSSIAN_FONT, "Cp1251", true);

            Paragraph paragraph = new Paragraph("Job vacancy")
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(russian)
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Status: " + jobVacancy.getStatus() + "\r\n")
                    .setFont(russian)
                    .setFontSize(20)
                    .add("Name: " + jobVacancy.getName() + "\r\n")
                    .add("Date: " + jobVacancy.getDate() + "\r\n")
                    .add("Hr manager: " + jobVacancy.getHrManagerSurname() + " " + jobVacancy.getHrManagerName() + "\r\n")
                    .add("Hr manager phone: " + jobVacancy.getHrManagerPhoneNumber() + "\r\n")
                    .add("Hr manager email: " + jobVacancy.getHrManagerEmail() + "\r\n")
                    .add("Address: " + jobVacancy.getAddress() + "\r\n")
                    .add("Description: " + jobVacancy.getDescription() + "\r\n");
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
            PdfFont russian = PdfFontFactory.createFont(RUSSIAN_FONT, "Cp1251", true);

            Paragraph paragraph = new Paragraph(aspirant.getSurname() + " " + aspirant.getName() + " " + aspirant.getPatronymic())
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(russian)
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Sex: " + aspirant.getSex() + "\r\n")
                    .setFont(russian)
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
            PdfFont russian = PdfFontFactory.createFont(RUSSIAN_FONT, "Cp1251", true);

            Paragraph paragraph = new Paragraph("Invitation")
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(russian)
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Date: " + invitation.getDate() + "\r\n")
                    .setFont(russian)
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
            PdfFont russian = PdfFontFactory.createFont(RUSSIAN_FONT, "Cp1251", true);

            Company company = this.companyService.getCompanyById(hrManager.getCompanyId());

            Paragraph paragraph = new Paragraph("HRManager")
                    .setItalic()
                    .setMarginBottom(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(russian)
                    .setFontSize(40);
            document.add(paragraph);

            paragraph = new Paragraph("Hr manager: " + hrManager.getSurname() + " " + hrManager.getName() + "\r\n")
                    .setFont(russian)
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

    @Override
    public void createXls(String path, AspirantResume resume)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(resume, "resume");

        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");

            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short)12);
            font.setFontName("Times New Roman");
            style.setFont(font);
            style.setWrapText(true);
            style.setAlignment(HorizontalAlignment.LEFT);
            style.setVerticalAlignment(VerticalAlignment.TOP);

            HSSFRow[] rows = new HSSFRow[13];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = sheet.createRow(i);
            }

            int i = 0;
            createCell(rows[i++], 0, style).setCellValue("Aspirant");
            createCell(rows[i++], 0, style).setCellValue("Email");
            createCell(rows[i++], 0, style).setCellValue("Career objective");
            createCell(rows[i++], 0, style).setCellValue("Sex");
            createCell(rows[i++], 0, style).setCellValue("Phone number");
            createCell(rows[i++], 0, style).setCellValue("Education");
            createCell(rows[i++], 0, style).setCellValue("English level");
            createCell(rows[i++], 0, style).setCellValue("Is relocation possible");
            createCell(rows[i++], 0, style).setCellValue("Is trip possible");
            createCell(rows[i++], 0, style).setCellValue("Date Of Birth");
            createCell(rows[i++], 0, style).setCellValue("Salary");
            createCell(rows[i], 0, style).setCellValue("About me");

            i = 0;
            createCell(rows[i++], 1, style).setCellValue(resume.getSurname() + " " + resume.getName() + " " + resume.getPatronymic());
            createCell(rows[i++], 1, style).setCellValue(resume.getEmail());
            createCell(rows[i++], 1, style).setCellValue(resume.getCareerObjective());
            createCell(rows[i++], 1, style).setCellValue(resume.getSex());
            createCell(rows[i++], 1, style).setCellValue(resume.getPhoneNumber());
            createCell(rows[i++], 1, style).setCellValue(resume.getEducation());
            createCell(rows[i++], 1, style).setCellValue(resume.getEnglishLevel());
            createCell(rows[i++], 1, style).setCellValue(resume.getIsRelocationPossible());
            createCell(rows[i++], 1, style).setCellValue(resume.getIsTripPossible());
            createCell(rows[i++], 1, style).setCellValue(resume.getDateOfBirth().toString());
            createCell(rows[i++], 1, style).setCellValue(resume.getSalary());
            createCell(rows[i], 1, style).setCellValue(resume.getAboutMe());

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void createXls(String path, JobVacancy jobVacancy)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(jobVacancy, "jobVacancy");

        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");

            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short)12);
            font.setFontName("Times New Roman");
            style.setFont(font);
            style.setWrapText(true);
            style.setAlignment(HorizontalAlignment.LEFT);
            style.setVerticalAlignment(VerticalAlignment.TOP);

            HSSFRow[] rows = new HSSFRow[12];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = sheet.createRow(i);
            }

            int i = 0;
            createCell(rows[i++], 0, style).setCellValue("Status");
            createCell(rows[i++], 0, style).setCellValue("Name");
            createCell(rows[i++], 0, style).setCellValue("Hr manager");
            createCell(rows[i++], 0, style).setCellValue("Hr manager phone");
            createCell(rows[i++], 0, style).setCellValue("Hr manager email");
            createCell(rows[i++], 0, style).setCellValue("Address");
            createCell(rows[i], 0, style).setCellValue("Description");

            i = 0;
            createCell(rows[i++], 1, style).setCellValue(jobVacancy.getStatus());
            createCell(rows[i++], 1, style).setCellValue(jobVacancy.getName());
            createCell(rows[i++], 1, style).setCellValue(jobVacancy.getHrManagerSurname() + " " + jobVacancy.hrManagerName);
            createCell(rows[i++], 1, style).setCellValue(jobVacancy.getHrManagerPhoneNumber());
            createCell(rows[i++], 1, style).setCellValue(jobVacancy.getHrManagerEmail());
            createCell(rows[i++], 1, style).setCellValue(jobVacancy.getAddress());
            createCell(rows[i], 1, style).setCellValue(jobVacancy.getDescription());

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void createXls(String path, Aspirant aspirant)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(aspirant, "aspirant");

        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");

            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short)12);
            font.setFontName("Times New Roman");
            style.setFont(font);
            style.setWrapText(true);
            style.setAlignment(HorizontalAlignment.LEFT);
            style.setVerticalAlignment(VerticalAlignment.TOP);

            HSSFRow[] rows = new HSSFRow[12];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = sheet.createRow(i);
            }

            int i = 0;
            createCell(rows[i++], 0, style).setCellValue("Aspirant");
            createCell(rows[i++], 0, style).setCellValue("Sex");
            createCell(rows[i++], 0, style).setCellValue("Email");
            createCell(rows[i++], 0, style).setCellValue("Phone number");
            createCell(rows[i++], 0, style).setCellValue("Mailing address");
            createCell(rows[i++], 0, style).setCellValue("Education");
            createCell(rows[i++], 0, style).setCellValue("English level");
            createCell(rows[i++], 0, style).setCellValue("Date Of Birth");
            createCell(rows[i++], 0, style).setCellValue("About me");
            createCell(rows[i], 0, style).setCellValue("City Of residence");

            i = 0;
            createCell(rows[i++], 1, style).setCellValue(aspirant.getSurname() + " " + aspirant.getName() + " " + aspirant.getPatronymic());
            createCell(rows[i++], 1, style).setCellValue(aspirant.getSex());
            createCell(rows[i++], 1, style).setCellValue(aspirant.getEmail());
            createCell(rows[i++], 1, style).setCellValue(aspirant.getPhoneNumber());
            createCell(rows[i++], 1, style).setCellValue(aspirant.getMailingAddress());
            createCell(rows[i++], 1, style).setCellValue(aspirant.getEducation());
            createCell(rows[i++], 1, style).setCellValue(aspirant.getEnglishLevel());
            createCell(rows[i++], 1, style).setCellValue(aspirant.getDateOfBirth().toString());
            createCell(rows[i++], 1, style).setCellValue(aspirant.getAboutMe());
            createCell(rows[i], 1, style).setCellValue(aspirant.getCityOfResidence());

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void createXls(String path, AspirantInvitation invitation)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(invitation, "invitation");

        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");

            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short)12);
            font.setFontName("Times New Roman");
            style.setFont(font);
            style.setWrapText(true);
            style.setAlignment(HorizontalAlignment.LEFT);
            style.setVerticalAlignment(VerticalAlignment.TOP);

            HSSFRow[] rows = new HSSFRow[12];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = sheet.createRow(i);
            }

            int i = 0;
            createCell(rows[i++], 0, style).setCellValue("Date");
            createCell(rows[i++], 0, style).setCellValue("Address");
            createCell(rows[i++], 0, style).setCellValue("Aspirant email");
            createCell(rows[i++], 0, style).setCellValue("Career objective");
            createCell(rows[i++], 0, style).setCellValue("Company name");
            createCell(rows[i++], 0, style).setCellValue("Job vacancy name");
            createCell(rows[i++], 0, style).setCellValue("Hr manager");
            createCell(rows[i++], 0, style).setCellValue("Hr manager phone");
            createCell(rows[i], 0, style).setCellValue("Hr manager email");

            i = 0;
            createCell(rows[i++], 1, style).setCellValue(invitation.getDate().toString());
            createCell(rows[i++], 1, style).setCellValue(invitation.getAddress());
            createCell(rows[i++], 1, style).setCellValue(invitation.getAspirantEmail());
            createCell(rows[i++], 1, style).setCellValue(invitation.getAspirantCareerObjective());
            createCell(rows[i++], 1, style).setCellValue(invitation.getCompanyName());
            createCell(rows[i++], 1, style).setCellValue(invitation.getJobVacancyName());
            createCell(rows[i++], 1, style).setCellValue(invitation.getHrManagerSurname() + " " + invitation.getCompanyName());
            createCell(rows[i++], 1, style).setCellValue(invitation.getHrManagerPhoneNumber());
            createCell(rows[i], 1, style).setCellValue(invitation.getHrManagerEmail());

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void createXls(String path, HRManager hrManager)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(hrManager, "hrManager");

        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");

            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short)12);
            font.setFontName("Times New Roman");
            style.setFont(font);
            style.setWrapText(true);
            style.setAlignment(HorizontalAlignment.LEFT);
            style.setVerticalAlignment(VerticalAlignment.TOP);

            HSSFRow[] rows = new HSSFRow[12];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = sheet.createRow(i);
            }

            int i = 0;
            createCell(rows[i++], 0, style).setCellValue("Hr manager");
            createCell(rows[i++], 0, style).setCellValue("Email");
            createCell(rows[i++], 0, style).setCellValue("Phone");
            createCell(rows[i++], 0, style).setCellValue("Company name");
            createCell(rows[i++], 0, style).setCellValue("Company email");
            createCell(rows[i++], 0, style).setCellValue("Company mailing address");
            createCell(rows[i], 0, style).setCellValue("Company phone number");

            Company company = this.companyService.getCompanyById(hrManager.getCompanyId());

            i = 0;
            createCell(rows[i++], 1, style).setCellValue(hrManager.getSurname() + " " + hrManager.getName());
            createCell(rows[i++], 1, style).setCellValue(hrManager.getEmail());
            createCell(rows[i++], 1, style).setCellValue(hrManager.getPhoneNumber());
            createCell(rows[i++], 1, style).setCellValue(company.getName());
            createCell(rows[i++], 1, style).setCellValue(company.getEmail());
            createCell(rows[i++], 1, style).setCellValue(company.getMailingAddress());
            createCell(rows[i], 1, style).setCellValue(company.getPhoneNumber());

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void createCsv(String path, AspirantResume resume)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(resume, "resume");

        try {
            String csv = resume.getSurname() + ";" + resume.getName() + ";" + resume.getPatronymic() + ";\"" +
                    resume.getEmail() + "\";" +
                    resume.getCareerObjective() + ";" +
                    resume.getSex() + ";\"" +
                    resume.getPhoneNumber() + "\";\"" +
                    resume.getEducation() + "\";" +
                    resume.getIsRelocationPossible() + ";" +
                    resume.getIsTripPossible() + ";\"" +
                    resume.getDateOfBirth().toString() + "\";\"" +
                    resume.getSalary() + "\";\"" +
                    resume.getAboutMe() + "\"";

            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "Cp1251"));
            out.append(csv);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void createCsv(String path, JobVacancy jobVacancy)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(jobVacancy, "resume");

        try {
            String csv = "\"" + jobVacancy.getStatus() + "\";\"" +
                    jobVacancy.getName() + "\";" +
                    jobVacancy.getHrManagerSurname() + ";" + jobVacancy.hrManagerName + ";\"" +
                    jobVacancy.getHrManagerPhoneNumber() + "\";\"" +
                    jobVacancy.getHrManagerEmail() + "\";\"" +
                    jobVacancy.getAddress() + "\";\"" +
                    jobVacancy.getDescription() + "\";";

            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "Cp1251"));
            out.append(csv);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void createCsv(String path, Aspirant aspirant)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(aspirant, "resume");

        try {
            String csv = aspirant.getSurname() + ";" + aspirant.getName() + ";" + aspirant.getPatronymic() + ";" +
                    aspirant.getSex() + ";\"" +
                    aspirant.getEmail() + "\";\"" +
                    aspirant.getPhoneNumber() + "\";\"" +
                    aspirant.getMailingAddress() + "\";\"" +
                    aspirant.getEducation() + "\";\"" +
                    aspirant.getEnglishLevel() + "\";" +
                    aspirant.getDateOfBirth().toString() + ";\"" +
                    aspirant.getAboutMe() + "\";\"" +
                    aspirant.getCityOfResidence() + "\";";

            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "Cp1251"));
            out.append(csv);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void createCsv(String path, AspirantInvitation invitation)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(invitation, "invitation");

        try {
            String csv = "\"" + invitation.getDate().toString() + "\";\"" +
                    invitation.getAddress() + "\";\"" +
                    invitation.getAspirantEmail() + "\";\"" +
                    invitation.getAspirantCareerObjective() + "\";\"" +
                    invitation.getCompanyName() + "\";\"" +
                    invitation.getJobVacancyName() + "\";" +
                    invitation.getHrManagerSurname() + ";" + invitation.getCompanyName() + ";\"" +
                    invitation.getHrManagerPhoneNumber() + "\";\"" +
                    invitation.getHrManagerEmail() + "\";";

            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "Cp1251"));
            out.append(csv);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void createCsv(String path, HRManager hrManager)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(path, "path");
        ArgumentVerificationService.verifyNull(hrManager, "hrManager");

        try {
            Company company = this.companyService.getCompanyById(hrManager.getCompanyId());
            String csv = hrManager.getSurname() + ";" + hrManager.getName() + ";\"" +
                    hrManager.getEmail() + "\";\"" +
                    hrManager.getPhoneNumber() + "\";\"" +
                    company.getName() + "\";\"" +
                    company.getEmail() + "\";\"" +
                    company.getMailingAddress() + "\";\"" +
                    company.getPhoneNumber() + "\";";

            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "Cp1251"));
            out.append(csv);
            out.flush();
            out.close();
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

    private HSSFCell createCell(HSSFRow row, int i, CellStyle style) {
        HSSFCell cell = row.createCell(i);
        cell.setCellStyle(style);
        return cell;
    }
}
