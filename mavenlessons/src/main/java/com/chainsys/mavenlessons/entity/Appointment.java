package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name="Appointments")
public class Appointment {
	@Id
	@Column(name = "appointment_id")
	private int appointmentId;
	@Column(name = "appointment_date")
	private Date appointmentDate;
//    @Column (name="doc_id")
//    private int docId;
    @Column (name="patient_name")
    private String name;
    @Column(name = "fees_collected")
	private float feesCollected;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id", nullable= false, insertable=false, updatable=false)
    @JsonIgnore
    private Doctor doctor;

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doc) {
        this.doctor = doc;
    }
    public int getId() {
        return appointmentId;
    }
    public void setId(int id) {
        this.appointmentId = id;
    }
    public Date getApp_date() {
        return appointmentDate;
    }
    public void setApp_date(Date app_date) {
        this.appointmentDate = app_date;
    }
//    public int getDoc_id() {
//        return docId;
//    }
//    public void setDoc_id(int doc_id) {
//        this.docId = doc_id;
//    }
    public String getPatient_name() {
        return name;
    }
    public void setPatient_name(String patient_name) {
        this.name = patient_name;
    }
    public float getFees_collected() {
        return feesCollected;
    }
    public void setFees_collected(float fees_collected) {
        this.feesCollected = fees_collected;
    }
   
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %.2f", appointmentId, appointmentDate, name, feesCollected);
    }
}