import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Company } from 'src/app/core/models/company.model';
import { Person } from 'src/app/core/models/person.model';
import { Prospect } from 'src/app/core/models/prospect.model';

@Component({
  selector: 'prospect-analysis-card',
  templateUrl: './prospect-analysis-card.component.html',
  styleUrls: ['./prospect-analysis-card.component.scss']
})
export class ProspectAnalysisCardComponent {

  public prospectName: string;
  public prospectTaxId: string;
  public prospectMcc: number;
  public isNaturalPerson: boolean;

  @Output()
  public onSubmit: EventEmitter<string> = new EventEmitter<string>();

  public readonly APPROVED: string = "APPROVED";
  public readonly REPPROVED: string = "REPPROVED";

  @Input()
  public set prospect(prospect: Prospect) {
    this.isNaturalPerson = prospect?.naturalPerson;
    this.isNaturalPerson ? this.setPersonData(prospect?.person) : this.setCompanyData(prospect?.company);
  }

  public setPersonData(person: Person): void {
    this.prospectName = person?.name;
    this.prospectTaxId = person?.cpf;
    this.prospectMcc = person?.mcc;
  }

  public setCompanyData(company: Company): void {
    this.prospectName = company?.companyName;
    this.prospectTaxId = company?.cnpj;
    this.prospectMcc = company?.mcc;
  }

  public onRepprove(): void {
    this.onSubmit.emit(this.REPPROVED);
  }

  public onApprove(): void {
    this.onSubmit.emit(this.APPROVED);
  }

}
