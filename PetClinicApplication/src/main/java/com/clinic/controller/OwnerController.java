package com.clinic.controller;

import com.clinic.model.Owner;
import com.clinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @PostMapping
    public Owner addOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }
}