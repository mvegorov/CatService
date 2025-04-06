package org.example;

import org.example.DTO.CatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping("/{id}")
    public ResponseEntity<CatDto> getCatById(@PathVariable int id) {
        return ResponseEntity.ok(catService.getCatById(id));
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<CatDto>> getCatsByColor(@PathVariable CatColor color) {
        return ResponseEntity.ok(catService.getCatsByColor(color));
    }

    @PostMapping
    public CatDto addCat(@RequestBody CatDto CatDTO) {
        return catService.addCat(CatDTO);
    }

    @PutMapping("/{id}")
    public CatDto updateCat(@PathVariable int id, @RequestBody CatDto CatDTO) {
        return catService.updateCat(id, CatDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable int id) {
        catService.deleteCat(id);
    }
}
