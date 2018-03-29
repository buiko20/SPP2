package service.fake;

import dao.DAO;
import domain.Company;
import domain.HRManager;
import domain.Invitation;
import service.CompanyService;
import service.impl.MyCompanyService;
import service.impl.MyDocumentService;
import viewModel.Aspirant;
import viewModel.AspirantInvitation;
import viewModel.AspirantResume;
import viewModel.JobVacancy;

public class Main {

    public static void main(String[] args) {
        try {

            AspirantResume resume = new AspirantResume(
                    "кпцукпцукп", 123f, "123", "123",
                    "123", "вавпаывапы", new java.sql.Date(1998, 2, 1), "123", "123", "123",
                    "123", "123", "123", "true", "true", "123"
            ,"123dfffffffff00000fffffffffffffffffffffffffffffffffffffffffffff");

            JobVacancy jobVacancy = new JobVacancy("123", "123", new java.sql.Date(1998, 2, 1),
                    "123", "123", "123",
                    "123", "123", "123", "123");

            Aspirant aspirant = new Aspirant("123", "123", "123", "123",
                    "123", new java.sql.Date(1998, 2, 1), "123", "123", "123",
                    "123", "123", "123");

            AspirantInvitation invitation = new AspirantInvitation(new java.sql.Date(1998, 2, 1), "123",
                    "123", "123", "123", "123", "123",
                    "123", "123", "123");

            CompanyService companyService = getCompanyService();
            companyService.addCompany(new Company("123", "123", "123", "123"));
            HRManager hrManager = new HRManager(0, "пцукпцукпцукп", "123", "123", "123", "123", 0);

            MyDocumentService documentService = new MyDocumentService(companyService);
            documentService.createPdf("D:\\1.pdf", resume);
            documentService.createPdf("D:\\1.pdf", resume);
           /* documentService.createPdf("1.pdf", jobVacancy);
            documentService.createPdf("1.pdf", aspirant);
            documentService.createPdf("1.pdf", invitation);
            documentService.createPdf("1.pdf", hrManager);*/

         /*  documentService.createXls("1.xls", resume);
           documentService.createXls("1.xls", jobVacancy);
           documentService.createXls("1.xls", aspirant);
           documentService.createXls("1.xls", invitation);
           documentService.createXls("1.xls", hrManager);

            documentService.createCsv("1.csv", resume);
            documentService.createCsv("1.csv", jobVacancy);
            documentService.createCsv("1.csv", aspirant);
            documentService.createCsv("1.csv", invitation);
            documentService.createCsv("1.csv", hrManager);*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static CompanyService getCompanyService() {
        DAO<Company> companyDAO = new CompanyDaoFake();
        DAO<Invitation> invitationDAO = new InvitationDaoFake();
        return new MyCompanyService(companyDAO, invitationDAO);
    }

}
