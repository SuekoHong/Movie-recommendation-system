package com.movies.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * The class is about administrator who manage users and movies.
 * This class includes all the information of a administrator and simple get or set function with these information.
 * @author Sueko
 * @version 1.0
 * @since JDK 8.0
 */
public class Administrator  implements Serializable {

    private String administratorName;
    private String administratorGender;
    private Date administratorBirthday;
    private String administratorTel;
    private String administratorEmail;
    private String administratorPassword;

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getAdministratorGender() {
        return administratorGender;
    }

    public void setAdministratorGender(String administratorGender) {
        this.administratorGender = administratorGender;
    }

    public Date getAdministratorBirthday() {
        return administratorBirthday;
    }

    public void setAdministratorBirthday(Date administratorBirthday) {
        this.administratorBirthday = administratorBirthday;
    }

    public String getAdministratorTel() {
        return administratorTel;
    }

    public void setAdministratorTel(String administratorTel) {
        this.administratorTel = administratorTel;
    }

    public String getAdministratorEmail() {
        return administratorEmail;
    }

    public void setAdministratorEmail(String administratorEmail) {
        this.administratorEmail = administratorEmail;
    }

    public String getAdministratorPassword() {
        return administratorPassword;
    }

    public void setAdministratorPassword(String administratorPassword) {
        this.administratorPassword = administratorPassword;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "administratorName='" + administratorName + '\'' +
                ", administratorGender='" + administratorGender + '\'' +
                ", administratorBirthday=" + administratorBirthday +
                ", administratorTel='" + administratorTel + '\'' +
                ", administratorEmail='" + administratorEmail + '\'' +
                ", administratorPassword='" + administratorPassword + '\'' +
                '}';
    }
}
