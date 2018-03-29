package viewModel;

import java.util.Date;

/**
 * Represents a resume view view model.
 */
public class ResumeView {

    public Date date;

    /**
     * Initializes a new instance of the {@link ResumeView model}
     * @param date resume view date
     * @param companyName resume view company name
     */
    public ResumeView(Date date, String companyName) {

        this.date = date;
        this.companyName = companyName;
    }

    public String companyName;

    /**
     * Gets a resume view date
     * @return resume view date
     */
    public Date getDate() {
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
