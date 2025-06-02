package com.example.vamm.controller;

import com.example.vamm.model.Asset;
import com.example.vamm.repository.AssetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {
    private final AssetRepository repository;

    public AssetController(AssetRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Asset> all(@RequestParam(required = false) Integer upcoming) {
        List<Asset> list = repository.findAll();
        list.sort(Comparator.comparing(Asset::getEolDate));
        if (upcoming != null) {
            LocalDate threshold = LocalDate.now().plusDays(upcoming);
            return list.stream()
                    .filter(a -> a.getEolDate() != null && !a.getEolDate().isAfter(threshold))
                    .toList();
        }
        return list;
    }

    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return repository.save(asset);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> read(@PathVariable String id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asset> update(@PathVariable String id, @RequestBody Asset asset) {
        return repository.findById(id)
                .map(existing -> {
                    asset.setId(existing.getId());
                    return ResponseEntity.ok(repository.save(asset));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
