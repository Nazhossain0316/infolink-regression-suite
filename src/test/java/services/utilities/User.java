package services.utilities;

public class User {

    public static final String OPERATOR = "Operator";
    public static final String WEB_USER = "Web User";
    public static final String WEB_USER_AND_OPERATOR = "Web User and Operator";
    public static final String METRIC = "Metric";
    public static final String IMPERIAL = "Imperial";

    String userType;
    String firstName;
    String middleName;
    String lastName;

    String employeeNumber;
    String language;
    String timeZone;
    String unitOfMeasure;

    public User(String userType,
                     String firstName,
                     String middleName,
                     String lastName,
                     String employeeNumber,
                     String language,
                     String timeZone,
                     String unitOfMeasure) {
        this.userType = userType;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.language = language;
        this.timeZone =timeZone;
        this.unitOfMeasure = unitOfMeasure;
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }


    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
