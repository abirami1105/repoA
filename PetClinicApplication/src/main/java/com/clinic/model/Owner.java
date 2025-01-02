package com.clinic.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents an Owner entity in the clinic system.
 */
@Entity
public class Owner {

    // Primary key for the Owner entity, automatically generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the owner.
    private String name;

    // Contact information for the owner.
    private String contact;

    // One-to-Many relationship with the Pet entity.
    // The 'mappedBy' attribute indicates that the 'owner' field in the Pet entity is the inverse side.
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;

    // Default constructor required by JPA.
    public Owner() {
    }

    // Parameterized constructor for convenience.
    public Owner(String name, String contact) {
        this.name = name;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
