package com.revature.beans;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Power")
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PowerSequence")
    @SequenceGenerator(allocationSize = 1, name = "PowerSequence", sequenceName = "SQ_Power_PK")
    @Column(name = "Power_ID")
    private int PowerId;
    @Column(name = "POWER_NAME")
    private String powername;
    @Column(name = "DPS")
    private int dps;
    @ManyToMany(mappedBy = "Powers")
    private Set<Hero> Heros = new HashSet<>();
    

    public Power( String powername, int dps) {
        this.powername = powername;
        this.dps = dps;
    }


	public int getPowerId() {
		return PowerId;
	}


	public void setPowerId(int powerId) {
		PowerId = powerId;
	}


	public String getPowername() {
		return powername;
	}


	public void setPowername(String powername) {
		this.powername = powername;
	}


	public int getDps() {
		return dps;
	}


	public void setDps(int dps) {
		this.dps = dps;
	}


	public Set<Hero> getHeros() {
		return Heros;
	}


	public void setHeros(Set<Hero> heros) {
		Heros = heros;
	}

    
}
