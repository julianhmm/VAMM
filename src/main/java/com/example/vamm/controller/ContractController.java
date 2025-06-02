package com.example.vamm.controller;

import com.example.vamm.model.Contract;
import com.example.vamm.repository.ContractRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {
    private final ContractRepository repository;

    public ContractController(ContractRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Contract> all() {
        List<Contract> list = repository.findAll();
        list.sort(Comparator.comparing(Contract::getEndDate));
        return list;
    }

    @PostMapping
    public Contract create(@RequestBody Contract contract) {
        return repository.save(contract);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> read(@PathVariable String id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> update(@PathVariable String id, @RequestBody Contract contract) {
        return repository.findById(id)
                .map(existing -> {
                    contract.setId(existing.getId());
                    return ResponseEntity.ok(repository.save(contract));
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
