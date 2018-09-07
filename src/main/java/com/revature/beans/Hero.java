package com.revature.beans;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "APP_Hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HeroSequence")
    @SequenceGenerator(allocationSize = 1, name = "HeroSequence", sequenceName = "SQ_Hero_PK")
    @Column(name = "Hero_ID")
    private int HeroId;
    @Column(name = "HeroNAME")
    private String Heroname;
    @Column(name = "PASSWORD")
    private int password;
    @Column(name = "F_NAME")
    private String fName;
    @Column(name = "L_NAME")
    private String lName;
    private LocalDate birthdate;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Hero_ID",
            joinColumns = {@JoinColumn(name = "Hero_ID")},
            inverseJoinColumns = {@JoinColumn(name = "POWER_ID")}
    )
    private Set<Power> Powers = new HashSet<>();



    public Hero(String Heroname, String fName, String lName, LocalDate birthdate) {
        this.Heroname = Heroname;
        this.fName = fName;
        this.lName = lName;
        this.birthdate = birthdate;
    }

    public void setPowers(Set<Power> P) {
    	this.Powers = (Set<Power>)P;
    }
    public int getHeroId() {
        return HeroId;
    }

    public void setHeroId(int HeroId) {
        this.HeroId = HeroId;
    }

    public String getHeroname() {
        return Heroname;
    }

    public void setHeroname(String Heroname) {
        this.Heroname = Heroname;
    }

    public int getPassword() {
        return password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }



    @Override
    public String toString() {
        return "Hero{" +
                "HeroId=" + HeroId +
                ", Heroname='" + Heroname + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
