package com.prospect.manager.infrastructure.utils;

import com.prospect.manager.domain.models.Company;
import com.prospect.manager.domain.models.Person;
import com.prospect.manager.domain.models.Prospect;
import com.prospect.manager.domain.models.QueueItem;
import com.prospect.manager.presentation.dtos.*;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;

public class AppModelMapper {

    public static ProspectDto mapModelToDto(Prospect prospect) {
        ProspectDto prospectDto = new ProspectDto();
        BeanUtils.copyProperties(prospect, prospectDto,
                "person",
                "company");
        if(prospect.getNaturalPerson())
            prospectDto.setPerson(mapModelToDto(prospect.getPerson()));
        else
            prospectDto.setCompany(mapModelToDto(prospect.getCompany()));
        return prospectDto;
    }

    public static PersonDto mapModelToDto(Person person) {
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(person, personDto);
        return personDto;
    }

    public static CompanyDto mapModelToDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        BeanUtils.copyProperties(company, companyDto,
                "contact");
        Optional.ofNullable(company.getContact())
                .ifPresent(
                        contact -> companyDto.setContact(mapModelToDto(contact))
                );
        return companyDto;
    }

    public static QueueDto mapModelToDto(List<QueueItem> queue) {
        QueueDto queueDto = new QueueDto();
        queueDto.setSize(queue.size());
        queueDto.setFirst(
                queue.stream().min(ComparatorUtils::compareQueueItemsByUpdatedAt)
                        .map(QueueItem::getProspect)
                        .map(AppModelMapper::mapModelToDto)
                        .orElse(new ProspectDto())
        );
        queueDto.setQueueItems(mapModelItemsToDto(queue));
        return queueDto;
    }

    private static List<QueueItemDto> mapModelItemsToDto(List<QueueItem> prospects) {
        return prospects.stream()
                .map(AppModelMapper::mapModelToDto)
                .toList();
    }

    private static QueueItemDto mapModelToDto(QueueItem prospect) {
        QueueItemDto queueItemDto = new QueueItemDto();
        BeanUtils.copyProperties(prospect.getProspect(), queueItemDto);
        return queueItemDto;
    }

}
