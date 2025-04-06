package org.example;

import org.example.DTO.OwnerDto;
import org.example.Repositories.OwnerRepository;
import org.example.exeptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OwnerDto getOwnerById(int id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id: " + id));
        return modelMapper.map(owner, OwnerDto.class);
    }

    public List<OwnerDto> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream()
                .map(owner -> modelMapper.map(owner, OwnerDto.class))
                .collect(Collectors.toList());
    }

    public OwnerDto addOwner(OwnerDto ownerDto) {
        Owner owner = modelMapper.map(ownerDto, Owner.class);
        Owner savedOwner = ownerRepository.save(owner);
        return modelMapper.map(savedOwner, OwnerDto.class);
    }

    public OwnerDto updateOwner(int id, OwnerDto ownerDto) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id: " + id));
        owner.setName(ownerDto.getName());

        Owner updatedOwner = ownerRepository.save(owner);
        return modelMapper.map(updatedOwner, OwnerDto.class);
    }

    public void deleteOwner(int id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id: " + id));
        ownerRepository.delete(owner);
    }
}