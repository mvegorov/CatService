package org.example;

import org.example.DTO.OwnerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> getOwnerById(@PathVariable int id) {
        return ResponseEntity.ok(ownerService.getOwnerById(id));
    }

    @GetMapping
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

    @PostMapping
    public OwnerDto addOwner(@RequestBody OwnerDto ownerDto) {
        return ownerService.addOwner(ownerDto);
    }

    @PutMapping("/{id}")
    public OwnerDto updateOwner(@PathVariable int id, @RequestBody OwnerDto ownerDto) {
        return ownerService.updateOwner(id, ownerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable int id) {
        ownerService.deleteOwner(id);
    }
}
