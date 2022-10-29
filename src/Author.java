public class Author {
    private String firstName;
    private String lastName;
    private String nationality;
    private String yearOfBirth;
    private String yearOfDeath;

    public Author() {
    }

    public Author(String firstName, String lastName, String nationality, String yearOfBirth, String yearOfDeath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(String yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    @Override
    public String toString() {
        return String.format("Author: %s, %s, %s, %s, %s", firstName, lastName, nationality, yearOfBirth, yearOfDeath );
    }
}
