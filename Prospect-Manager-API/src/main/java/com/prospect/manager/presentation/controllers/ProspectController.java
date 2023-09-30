package com.prospect.manager.presentation.controllers;

import com.prospect.manager.infrastructure.enums.ProspectAnalysisStatus;
import com.prospect.manager.infrastructure.filters.ProspectFilter;
import com.prospect.manager.presentation.dtos.ProspectDto;
import com.prospect.manager.presentation.services.IProspectService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/prospects")
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

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProspectDto> readAll(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "taxId", required = false) String taxId,
            @RequestParam(name = "mcc", required = false) Integer mcc,
            @RequestParam(name = "status", required = false) ProspectAnalysisStatus status,
            @RequestParam(name = "naturalPerson", required = false) Boolean naturalPerson,
            @RequestParam(name = "initialDate", required = false) Date initialDate,
            @RequestParam(name = "finalDate", required = false) Date finalDate
    ) {
        return this.prospectService.readAll(
                name,
                taxId,
                mcc,
                status,
                naturalPerson,
                initialDate,
                finalDate
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody ProspectDto prospectDto) {
        this.prospectService.update(prospectDto);
    }

    @DeleteMapping(name = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "id") ObjectId id) {
        this.prospectService.deleteById(id);
    }

    @PostMapping("/{id}/{status}")
    @ResponseStatus(HttpStatus.OK)
    public void analyze(@PathVariable(name = "id") ObjectId id, @PathVariable(name = "status") ProspectAnalysisStatus status) {
        this.prospectService.analyze(id, status);
    }

}
