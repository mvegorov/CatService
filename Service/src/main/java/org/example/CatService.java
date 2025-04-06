package org.example;

import org.example.DTO.CatDto;
import org.example.DTO.OwnerDto;
import org.example.Repositories.CatRepository;
import org.example.exeptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CatDto getCatById(int id) {
        Optional<Cat> cat = catRepository.findById(id);
        if (cat.isPresent()) {
            return convertToDto(cat.get());
        } else {
            throw new ResourceNotFoundException("Cat not found with id " + id);
        }
    }

    public List<CatDto> getCatsByColor(CatColor color) {
        List<Cat> cats = catRepository.findByColor(color);
        return cats.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CatDto addCat(CatDto catDto) {
        Cat cat = convertToEntity(catDto);
        Cat savedCat = catRepository.save(cat);
        return convertToDto(savedCat);
    }

    public CatDto updateCat(int id, CatDto catDto) {
        Optional<Cat> optionalCat = catRepository.findById(id);
        if (optionalCat.isPresent()) {
            Cat existingCat = optionalCat.get();
            existingCat.setName(catDto.getName());
            existingCat.setBirthDate(catDto.getBirthDate());
            existingCat.setBreed(catDto.getBreed());
            existingCat.setColor(CatColor.valueOf(catDto.getColor().toUpperCase()));
            existingCat.setOwner(convertToEntity(catDto.getOwner()));
            Cat updatedCat = catRepository.save(existingCat);
            return convertToDto(updatedCat);
        } else {
            throw new ResourceNotFoundException("Cat not found with id " + id);
        }
    }

    public void deleteCat(int id) {
        catRepository.deleteById(id);
    }

    private CatDto convertToDto(Cat cat) {
        return modelMapper.map(cat, CatDto.class);
    }

    private Cat convertToEntity(CatDto catDto) {
        return modelMapper.map(catDto, Cat.class);
    }

    private Owner convertToEntity(OwnerDto ownerDto) {
        return modelMapper.map(ownerDto, Owner.class);
    }
}