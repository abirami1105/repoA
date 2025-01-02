package com.clinic.model;

import jakarta.persistence.*;

/**
 * Represents a Pet entity in the clinic system.
 */
@Entity
public class Pet {

    // Primary key for the Pet entity, automatically generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the pet.
    private String name;

    // Breed of the pet.
    private String breed;

    // Many-to-One relationship with the Owner entity.
    @ManyToOne
    private Owner owner;

    // Consultation fee for the pet.
    private double consultationFee;

    // Default constructor required by JPA.
    public Pet() {
    }

    // Parameterized constructor for convenience.
    public Pet(String name, String breed, Owner owner, double consultationFee) {
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        this.consultationFee = consultationFee;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", owner=" + (owner != null ? owner.getName() : "null") +
                ", consultationFee=" + consultationFee +
                '}';
    }
}
