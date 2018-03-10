package viewModel;

import java.sql.Timestamp;

public class ResumeView {

    public Timestamp date;

    /**
     * Initializes a new instance of the {@link ResumeView model}
     * @param date resume view date
     * @param companyName resume view company name
     */
    public ResumeView(Timestamp date, String companyName) {

        this.date = date;
        this.companyName = companyName;
    }

    public String companyName;

    /**
     * Gets a resume view date
     * @return resume view date
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Gets a resume view company name
     * @return resume view company name
     */
    public String getCompanyName() {
        return companyName;
    }
}
