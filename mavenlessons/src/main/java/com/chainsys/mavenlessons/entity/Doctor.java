package com.chainsys.mavenlessons.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
	private int id;
	@Column(name = "doctor_name")
	private String doctorName;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	private String speciality;
	private String city;
	@Column(name = "phone_number")
	private long phoneNumber;
	private float fees;
    
    
    @OneToMany (mappedBy = "doctor", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Appointment > appointments;
    public List<Appointment> getAppointments(){ 
    return this.appointments;
    }

    public int getDoctor_id() {
        return id;
    }
    public void setDoctor_id(int doctor_id) {
        this.id = doctor_id;
    }
    public String getName() {
        return doctorName;
    }
    public void setName(String name) {
        this.doctorName = name;
    }
    public Date getDob() {
        return dateOfBirth;
    }
    public void setDob(Date dob) {
        this.dateOfBirth = dob;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public long getPhone_no() {
        return phoneNumber;
    }
    public void setPhone_no(long phone_no) {
        this.phoneNumber = phone_no;
    }
    public float getStandard_fees() {
        return fees;
    }
    public void setStandard_fees(float standard_fees) {
        this.fees = standard_fees;
    }
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s,  %s, %.2f ",id,doctorName,dateOfBirth,speciality,city,phoneNumber,fees);
    }
}