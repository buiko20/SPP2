package viewModel;

import java.sql.Date;

/**
 * Represents an aspirant view model.
 */
public class Aspirant {

    public String name;
    public String surname;
    public String patronymic;
    public String sex;
    public String education;
    public Date dateOfBirth;
    public String phoneNumber;
    public String email;
    public String mailingAddress;
    public String englishLevel;
    public String aboutMe;
    public String cityOfResidence;

    /**
     * Initializes a new instance of the {@link Aspirant model}
     * @param name aspirant name
     * @param surname aspirant surname
     * @param patronymic aspirant patronymic
     * @param sex aspirant sex
     * @param education aspirant education
     * @param dateOfBirth aspirant date of birth
     * @param phoneNumber aspirant phone number
     * @param email aspirant email
     * @param mailingAddress aspirant mailing address
     * @param englishLevel aspirant level of english
     * @param aboutMe aspirant self-description
     * @param cityOfResidence aspirant city of residence
     */
    public Aspirant(String name, String surname, String patronymic, String sex, String education, Date dateOfBirth,
                    String phoneNumber, String email, String mailingAddress, String englishLevel, String aboutMe, String cityOfResidence) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.education = education;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.mailingAddress = mailingAddress;
        this.englishLevel = englishLevel;
        this.aboutMe = aboutMe;
        this.cityOfResidence = cityOfResidence;
    }

    /**
     * Gets an aspirant name
     * @return aspirant name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets an aspirant surname
     * @return aspirant surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Gets an aspirant patronymic
     * @return aspirant patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Gets an aspirant sex
     * @return aspirant sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Gets an aspirant education
     * @return aspirant education
     */
    public String getEducation() {
        return education;
    }

    /**
     * Gets an aspirant date of birth
     * @return aspirant date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Gets an aspirant phone number
     * @return aspirant phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets an aspirant email
     * @return aspirant email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets an aspirant mailing address
     * @return aspirant mailing address
     */
    public String getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Gets an aspirant level of english
     * @return aspirant level of english
     */
    public String getEnglishLevel() {
        return englishLevel;
    }

    /**
     * Gets an aspirant self-description
     * @return aspirant self-description
     */
    public String getAboutMe() {
        return aboutMe;
    }

    /**
     * Gets an aspirant city of residence
     * @return aspirant city of residence
     */
    public String getCityOfResidence() {
        return cityOfResidence;
    }

}
