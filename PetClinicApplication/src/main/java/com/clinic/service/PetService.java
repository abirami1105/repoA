package com.clinic.service;

import com.clinic.model.Pet;
import com.clinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }
}
