package domain;

import java.sql.Date;

/**
 * Represents an aspirant profile domain model.
 */
public class AspirantProfile implements Comparable<AspirantProfile>{

    private int id;
    private String name;
    private String surname;
    private String email;
    private String patronymic;
    private String sex;
    private String education;
    private Date dateOfBirth;
    private String phoneNumber;
    private String mailingAddress;
    private String englishLevel;
    private String aboutMe;
    private String cityOfResidence;

    /**
     * Initializes a new instance of the {@link AspirantProfile}.
     */
    public AspirantProfile() {
    }

    /**
     * Initializes a new instance of the {@link AspirantProfile model}
     * @param name aspirant name
     * @param surname aspirant surname
     * @param email aspirant email
     * @param patronymic aspirant patronymic
     * @param sex aspirant sex
     * @param education aspirant education
     * @param dateOfBirth aspirant date of birth
     * @param phoneNumber aspirant phone number
     * @param mailingAddress aspirant mailing address
     * @param englishLevel aspirant level of english
     * @param aboutMe aspirant self-description
     * @param cityOfResidence aspirant city of residence
     */
    public AspirantProfile(String name, String surname, String email, String patronymic, String sex, String education,
                           Date dateOfBirth, String phoneNumber, String mailingAddress, String englishLevel,
                           String aboutMe, String cityOfResidence) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.patronymic = patronymic;
        this.sex = sex;
        this.education = education;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;
        this.englishLevel = englishLevel;
        this.aboutMe = aboutMe;
        this.cityOfResidence = cityOfResidence;
    }

    /**
     * Initializes a new instance of the {@link AspirantProfile model}
     * @param id aspirant profile id
     * @param name aspirant name
     * @param surname aspirant surname
     * @param email aspirant email
     * @param patronymic aspirant patronymic
     * @param sex aspirant sex
     * @param education aspirant education
     * @param dateOfBirth aspirant date of birth
     * @param phoneNumber aspirant phone number
     * @param mailingAddress aspirant mailing address
     * @param englishLevel aspirant level of english
     * @param aboutMe aspirant self-description
     * @param cityOfResidence aspirant city of residence
     */
    public AspirantProfile(int id, String name, String surname, String email, String patronymic, String sex, String education,
                           Date dateOfBirth, String phoneNumber, String mailingAddress, String englishLevel,
                           String aboutMe, String cityOfResidence) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.patronymic = patronymic;
        this.sex = sex;
        this.education = education;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;
        this.englishLevel = englishLevel;
        this.aboutMe = aboutMe;
        this.cityOfResidence = cityOfResidence;
    }

    /**
     * Gets an aspirant profile id
     * @return aspirant profile id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets an aspirant profile id
     * @param id aspirant profile id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets an aspirant name
     * @return aspirant name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets an aspirant name
     * @param name aspirant name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets an aspirant surname
     * @return aspirant surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets an aspirant surname
     * @param surname aspirant surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets an aspirant email
     * @return aspirant email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets an aspirant email
     * @param email aspirant email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets an aspirant patronymic
     * @return aspirant patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Sets an aspirant patronymic
     * @param patronymic aspirant patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Gets an aspirant sex
     * @return aspirant sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets an aspirant sex
     * @param sex aspirant sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets an aspirant education
     * @return aspirant education
     */
    public String getEducation() {
        return education;
    }

    /**
     * Sets an aspirant education
     * @param education aspirant education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * Gets an aspirant date of birth
     * @return aspirant date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets an aspirant date of birth
     * @param dateOfBirth aspirant date of birth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets an aspirant phone number
     * @return aspirant phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets an aspirant phone number
     * @param phoneNumber aspirant phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets an aspirant mailing address
     * @return aspirant mailing address
     */
    public String getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Sets an aspirant mailing address
     * @param mailingAddress aspirant mailing address
     */
    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    /**
     * Gets an aspirant level of english
     * @return aspirant level of english
     */
    public String getEnglishLevel() {
        return englishLevel;
    }

    /**
     * Sets an aspirant level of english
     * @param englishLevel aspirant level of english
     */
    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    /**
     * Gets an aspirant self-description
     * @return aspirant self-description
     */
    public String getAboutMe() {
        return aboutMe;
    }

    /**
     * Sets an aspirant self-description
     * @param aboutMe aspirant self-description
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    /**
     * Gets an aspirant city of residence
     * @return aspirant city of residence
     */
    public String getCityOfResidence() {
        return cityOfResidence;
    }

    /**
     * Sets an aspirant city of residence
     * @param cityOfResidence aspirant city of residence
     */
    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    @Override
    public int compareTo(AspirantProfile obj) {
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

        AspirantProfile aspirantProfile = (AspirantProfile)obj;

        return this.getId() == aspirantProfile.getId();
    }
}

