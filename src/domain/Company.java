package domain;

/**
 * Represents a company domain model.
 */
public class Company implements Comparable<Company> {

    private int id;
    private String name;
    private String phoneNumber;
    private String mailingAddress;
    private String email;

    /**
     * Initializes a new instance of the {@link Company model}
     * @param name company name
     * @param phoneNumber company phone number
     * @param mailingAddress company mailing address
     * @param email company email
     */
    public Company(String name, String phoneNumber, String mailingAddress, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;
        this.email = email;
    }

    /**
     * Initializes a new instance of the {@link Company model}
     * @param id company id
     * @param name company name
     * @param phoneNumber company phone number
     * @param mailingAddress company mailing address
     * @param email company email
     */
    public Company(int id, String name, String phoneNumber, String mailingAddress, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;
        this.email = email;
    }

    /**
     * Gets a company id
     * @return company id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a company id
     * @param id company id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets a company name
     * @return company name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a company name
     * @param name company name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets a company phone number
     * @return company phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets a company phone number
     * @param phoneNumber company phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets a company mailing address
     * @return company mailing address
     */
    public String getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Sets a company mailing address
     * @param mailingAddress company mailing address
     */
    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    /**
     * Gets a company email
     * @return company email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets a company email
     * @param email company email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Company obj) {
        if (obj == null) {
            throw new NullPointerException("Object is null");
        }

        return Integer.compare(this.getId(), obj.getId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Company company = (Company)obj;

        return this.getId() == company.getId();
    }
}
