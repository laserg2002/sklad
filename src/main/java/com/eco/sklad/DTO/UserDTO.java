package com.eco.sklad.DTO;

import com.eco.sklad.domain.*;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {
    private int id;
    @NotEmpty
    private String balansName;
    private String companyName;
    private String managerName;
    private Boolean allowMinus=false;
    private int balansCredit=0;
    private User user;

    public UserDTO() {
    }

    public UserDTO(String managerName) {
        this.managerName = managerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBalansName() {
        return balansName;
    }

    public void setBalansName(String balansName) {
        this.balansName = balansName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Boolean getAllowMinus() {
        return allowMinus;
    }

    public void setAllowMinus(Boolean allowMinus) {
        this.allowMinus = allowMinus;
    }

    public int getBalansCredit() {
        return balansCredit;
    }

    public void setBalansCredit(int balansCredit) {
        this.balansCredit = balansCredit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", balansName='" + balansName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", allowMinus=" + allowMinus +
                ", balansCredit=" + balansCredit +
                ", user=" + user +
                '}';
    }
}
