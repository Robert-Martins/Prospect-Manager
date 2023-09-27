package com.prospect.manager.presentation.controllers;

import com.prospect.manager.infrastructure.filters.ProspectFilter;
import com.prospect.manager.presentation.dtos.ProspectDto;
import com.prospect.manager.presentation.services.IProspectService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/prospects")
public class ProspectController {

    @Autowired
    private IProspectService prospectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody ProspectDto prospectDto) {
        this.prospectService.create(prospectDto);
    }

    @GetMapping(name = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProspectDto read(@PathVariable(name = "id") ObjectId id) {
        return this.prospectService.read(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProspectDto> readAll(@RequestParam ProspectFilter prospectFilter) {
        return this.prospectService.readAll(prospectFilter);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody ProspectDto prospectDto) {
        this.prospectService.update(prospectDto);
    }

    @DeleteMapping(name = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "id") ObjectId id) {
        this.prospectService.delete(id);
    }

    @GetMapping("/exists/{taxId}")
    @ResponseStatus(HttpStatus.OK)
    public String existsByTaxId(@PathVariable(name = "taxId") String taxId) {
        return this.prospectService.existsByTaxId(taxId);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void analyze(@PathVariable(name = "id") ObjectId id) {
        this.prospectService.analyze(id);
    }

}
