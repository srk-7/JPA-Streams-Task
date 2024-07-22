package com.ust.spring_jpastreamer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="employee")
public class Employee {
    @Id
    private int id;
    private String education;
    private float joiningYear;
    private String city;
    private float paymentTier;
    private float age;
    private String gender;
    private String everBenched;
    private float experienceInCurrentDomain;
    private float leaveOrNot;
}
