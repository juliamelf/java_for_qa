package ru.juliamelf.javaqa.addressbook.model;

public class ContactData {
    private final String id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String company;
    private final String firstAddress;
    private String group;

    // private final String homepage;
   // private final String secondAddress;
   // private final String secondPhone;
   // private final String comments;

    public ContactData(String id, String firstName, String middleName, String lastName, String company, String firstAddress, String group) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.company = company;
        this.firstAddress = firstAddress;
        //this.homepage = homepage;
        //this.secondAddress = secondAddress;
        //this.secondPhone = secondPhone;
        //this.comments = comments;
        this.group = group;
    }

    public ContactData(String firstName, String middleName, String lastName, String company, String firstAddress, String group) {
        this.id = null;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.company = company;
        this.firstAddress = firstAddress;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() { return firstName; }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public String getGroup() { return group; }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstAddress='" + firstAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return firstAddress != null ? firstAddress.equals(that.firstAddress) : that.firstAddress == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstAddress != null ? firstAddress.hashCode() : 0);
        return result;
    }

    /*
    public String getHomepage() {
        return homepage;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public String getComments() {
        return comments;
    }

    */
}
