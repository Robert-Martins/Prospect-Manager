package com.prospect.manager.domain.services;

import com.prospect.manager.domain.models.Prospect;
import com.prospect.manager.domain.repositories.ProspectRepository;
import com.prospect.manager.infrastructure.enums.PersistType;
import com.prospect.manager.infrastructure.enums.ProspectAnalysisStatus;
import com.prospect.manager.infrastructure.events.ProspectPersistEvent;
import com.prospect.manager.infrastructure.exception.exceptions.NotFoundException;
import com.prospect.manager.infrastructure.utils.AppModelMapper;
import com.prospect.manager.presentation.dtos.ProspectDto;
import com.prospect.manager.presentation.services.ICompanyService;
import com.prospect.manager.presentation.services.IPersonService;
import com.prospect.manager.presentation.services.IProspectService;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProspectService implements IProspectService {

    @Autowired
    private ProspectRepository prospectRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private IPersonService personService;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void create(ProspectDto prospectDto) {
        Prospect prospect = new Prospect();
        prospect.setStatus(ProspectAnalysisStatus.AWAITING_ANALYSIS);
        prospect.setNaturalPerson(prospectDto.getNaturalPerson());
        if(prospect.getNaturalPerson())
            prospect.setPerson(this.personService.create(prospectDto.getPerson()));
        else
            prospect.setCompany(this.companyService.create(prospectDto.getCompany()));
        Prospect savedProspect = this.prospectRepository.save(prospect);
        this.publisher.publishEvent(
                new ProspectPersistEvent(
                        this,
                        PersistType.CREATE,
                        savedProspect.getId()
                )
        );
    }

    @Override
    public Prospect findById(ObjectId id) {
        return this.prospectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prospect não foi encontrado"));
    }

    @Override
    public ProspectDto read(ObjectId id) {
        return this.prospectRepository.findById(id)
                .map(AppModelMapper::mapModelToDto)
                .orElseThrow(() -> new NotFoundException("Prospect não foi encontrado"));
    }

    @Override
    public List<ProspectDto> readAll(
            String name,
            String taxId,
            Integer mcc,
            ProspectAnalysisStatus status,
            Boolean naturalPerson,
            Date initialDate,
            Date finalDate) {
        Query query = new Query();

        if (StringUtils.isNotEmpty(name)) {
            Criteria nameCriteria = Criteria.where("person.name").regex(name, "i")
                    .orOperator(Criteria.where("company.companyName").regex(name, "i"));
            query.addCriteria(nameCriteria);
        }

        if (StringUtils.isNotEmpty(taxId)) {
            Criteria taxIdCriteria = Criteria.where("person.cpf").is(taxId)
                    .orOperator(Criteria.where("company.cnpj").is(taxId));
            query.addCriteria(taxIdCriteria);
        }

        if (initialDate != null || finalDate != null) {
            Criteria dateCriteria = new Criteria();
            if (initialDate != null) {
                dateCriteria = dateCriteria.and("createdAt").gte(initialDate);
            }
            if (finalDate != null) {
                dateCriteria = dateCriteria.and("createdAt").lte(finalDate);
            }
            query.addCriteria(dateCriteria);
        }

        query.with(Sort.by(Sort.Direction.DESC, "createdAt"));

        return mongoTemplate.find(query, ProspectDto.class);
    }

    @Override
    public void update(ProspectDto prospectDto) {
        Prospect prospect = this.findById(new ObjectId(prospectDto.getId()));
        if(prospect.getNaturalPerson())
            this.personService.update(prospectDto.getPerson());
        else
            this.companyService.update(prospectDto.getCompany());
        if(prospect.getStatus().equals(ProspectAnalysisStatus.AWAITING_ANALYSIS))
            this.publisher.publishEvent(
                    new ProspectPersistEvent(
                            this,
                            PersistType.UPDATE,
                            prospect.getId()
                    )
            );
    }

    @Override
    public void delete(Prospect prospect) {
        this.prospectRepository.delete(prospect);
    }

    @Override
    public void deleteById(ObjectId id) {
        Prospect prospect = this.prospectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prospect não encontrado"));
        if(prospect.getNaturalPerson())
            this.personService.deleteById(prospect.getPerson().getId());
        else
            this.companyService.deleteById(prospect.getCompany().getId());
        if(prospect.getStatus().equals(ProspectAnalysisStatus.AWAITING_ANALYSIS))
            this.publisher.publishEvent(
                    new ProspectPersistEvent(
                            this,
                            PersistType.DELETE,
                            id
                    )
            );
        else
            this.prospectRepository.deleteById(id);
    }

    @Override
    public void analyze(ObjectId id, ProspectAnalysisStatus status) {
        Prospect prospect = this.prospectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prospect não foi encontrado"));
        prospect.setStatus(status);
        prospect.setAnalyzedAt(new Date());
        this.prospectRepository.save(prospect);
    }

}
