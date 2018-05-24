package domain;

/**
 * Represents a HRManager domain model.
 */
public class HRManager implements Comparable<HRManager> {

    private int id;
    private String email;
    private String password;
    private String surname;
    private String name;
    private String phoneNumber;
    private int companyId;

    /**
     * Initializes a new instance of the {@link HRManager model}
     * @param email HRManager email
     * @param password HRManager password
     * @param surname HRManager surname
     * @param name HRManager name
     * @param phoneNumber HRManager phone number
     * @param companyId id of the company in which the HRManager works
     */
    public HRManager(String email, String password, String surname, String name, String phoneNumber,
                     int companyId) {
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.companyId = companyId;
    }

    /**
     * Initializes a new instance of the {@link HRManager model}
     * @param id HRManager id
     * @param email HRManager email
     * @param password HRManager password
     * @param surname HRManager surname
     * @param name HRManager name
     * @param phoneNumber HRManager phone number
     * @param companyId id of the company in which the HRManager works
     */
    public HRManager(int id, String email, String password, String surname, String name, String phoneNumber,
                     int companyId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.companyId = companyId;
    }

    /**
     * Gets a HRManager id
     * @return HRManager id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a HRManager id
     * @param id HRManager id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets a HRManager email
     * @return HRManager email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets a HRManager email
     * @param email HRManager email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets a HRManager password
     * @return HRManager password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets a HRManager password
     * @param password HRManager password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets a HRManager surname
     * @return HRManager surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets a HRManager surname
     * @param surname HRManager surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets a HRManager name
     * @return HRManager name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a HRManager name
     * @param name HRManager name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets a HRManager phone number
     * @return HRManager phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets a HRManager phone number
     * @param phoneNumber HRManager phone nmber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets id of the company in which the HRManager works
     * @return id of the company in which the HRManager works
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * Sets id of the company in which the HRManager works
     * @param companyId id of the company in which the HRManager works
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public int compareTo(HRManager obj) {
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

        HRManager hrManager = (HRManager)obj;

        return this.getId() == hrManager.getId();
    }
}
