package com.ihachani.iac.emails.domain;

public class Contact {
    private String name;
    private String sex;
    private String email;
    private String companyName;

    public Contact(String name, String sex, String email, String companyName) {
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.companyName = companyName;
    }

    public Contact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (getName() != null ? !getName().equals(contact.getName()) : contact.getName() != null) return false;
        if (getSex() != null ? !getSex().equals(contact.getSex()) : contact.getSex() != null) return false;
        if (getEmail() != null ? !getEmail().equals(contact.getEmail()) : contact.getEmail() != null) return false;
        return getCompanyName() != null ? getCompanyName().equals(contact.getCompanyName()) : contact.getCompanyName() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "contact{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
