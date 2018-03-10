package viewModel;

import java.sql.Date;

public class AspirantResume {

    public String careerObjective;
    public float salary;
    public String surname;
    public String name;
    public String patronymic;
    public String sex;
    public Date dateOfBirth;
    public String email;
    public String phoneNumber;
    public String mailingAddress;
    public String cityOfResidence;
    public String education;
    public String englishLevel;
    public String isTripPossible;
    public String isRelocationPossible;
    public String skills;
    public String aboutMe;

    /**
     * Initializes a new instance of the {@link AspirantResume model}
     * @param careerObjective aspirant career objective
     * @param salary salary that aspirant want
     * @param surname aspirant surname
     * @param name aspirant name
     * @param patronymic aspirant patronymic
     * @param sex aspirant sex
     * @param dateOfBirth aspirant date of birth
     * @param email aspirant email
     * @param phoneNumber aspirant phone number
     * @param mailingAddress aspirant mailing address
     * @param cityOfResidence aspirant city of residence
     * @param education aspirant education
     * @param englishLevel aspirant english level
     * @param isTripPossible is trip possible for aspirant
     * @param isRelocationPossible is relocation possible for aspitant
     * @param skills aspirant skills
     * @param aboutMe aspirant self-description
     */
    public AspirantResume(String careerObjective, Float salary, String surname, String name, String patronymic,
                          String sex, Date dateOfBirth, String email, String phoneNumber, String mailingAddress,
                          String cityOfResidence, String education, String englishLevel, String isTripPossible,
                          String isRelocationPossible, String skills, String aboutMe) {
        this.careerObjective = careerObjective;
        this.salary = salary;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;
        this.cityOfResidence = cityOfResidence;
        this.education = education;
        this.englishLevel = englishLevel;
        this.isTripPossible = isTripPossible;
        this.isRelocationPossible = isRelocationPossible;
        this.skills = skills;
        this.aboutMe = aboutMe;
    }

    /**
     * Gets an aspirant career objective
     * @return aspirant career objective
     */
    public String getCareerObjective() {
        return careerObjective;
    }

    /**
     * Gets a salary that aspirant want
     * @return
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Gets is trip possible for aspirant
     * @return is trip possible for aspirant
     */
    public String getIsTripPossible() {
        return isTripPossible;
    }

    /**
     * Gets is relocation possible for aspirant
     * @return is relocation possible for aspirant
     */
    public String getIsRelocationPossible() {
        return isRelocationPossible;
    }

    /**
     * Gets an aspirant skills
     * @return aspirant skills
     */
    public String getSkills() {
        return skills;
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
