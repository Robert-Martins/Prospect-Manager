import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { Company } from 'src/app/core/models/company.model';
import { EnumDto } from 'src/app/core/models/enum.model';
import { Person } from 'src/app/core/models/person.model';
import { Prospect } from 'src/app/core/models/prospect.model';
import { AppService } from 'src/app/core/services/app.service';
import { ProspectService } from 'src/app/core/services/prospect.service';

@Component({
  selector: 'app-prospects-form',
  templateUrl: './prospects-form.component.html',
  styleUrls: ['./prospects-form.component.scss']
})
export class ProspectsFormComponent implements OnInit {

  public prospectId?: string;

  public prospect: Prospect;

  public prospectForm: FormGroup;

  public newProspect: boolean = true;

  public prospectAnalysisStatus: EnumDto[] = [];

  constructor(
    private toastr: ToastrService,
    private spinner: NgxSpinnerService,
    private prospectService: ProspectService,
    private appService: AppService,
    private fb: FormBuilder,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
      this.loadItems();
  }

  public get prospectFormValues(): Prospect {
    return this.prospectForm.value;
  }

  public toList(): void {
    this.router.navigate(['/prospects']);
  }

  private loadItems(): void {
    this.loadStatus();
    this.prospectId = this.activatedRoute.snapshot.paramMap.get('id');
    this.prospectId ?
        this.read()
      :
        this.createProspectForm();
  }

  public onSubmit(): void {
    this.prospectId ?
        this.update()
      :
        this.create();
  }

  public onDelete(): void {
    this.delete();
  }

  private create(): void {
    this.spinner.show();
    this.prospectService.create(this.prospectFormValues)
      .subscribe(
        {
          next: () => {
            this.toastr.success("Prospect cadastrado com sucesso!");
            this.spinner.hide();
            this.toList();
          },
          error: error => {
            this.toastr.error(error?.details);
            this.spinner.hide();
          }
        }
      );
  }

  private read(): void {
    this.newProspect = false;
    this.spinner.show();
    this.prospectService.read(this.prospectId)
      .subscribe(
        {
          next: prospect => {
            this.prospect = prospect;
            this.createProspectForm(prospect);
            this.spinner.hide();
          },
          error: error => {
            this.toastr.error(error?.details);
            this.spinner.hide();
          }
        }
      );
  }

  private update(): void {
    this.spinner.show();
    this.prospectService.update(this.prospectFormValues)
      .subscribe(
        {
          next: () => {
            this.toastr.success("Prospect atualizado com sucesso!");
            this.spinner.hide();
          },
          error: error => {
            this.toastr.error(error?.details);
            this.spinner.hide();
          }
        }
      );
  }

  private delete(): void {
    this.spinner.show();
    this.prospectService.delete(this.prospectFormValues.id)
      .subscribe(
        {
          next: () => {
            this.toastr.success("Prospect deletado com sucesso!");
            this.spinner.hide();
            this.toList();
          },
          error: error => {
            this.toastr.error(error?.details);
            this.spinner.hide();
          }
        }
      )
  }

  private createProspectForm(prospect: Prospect = new Prospect()): void {
    this.prospectForm = this.fb.group({
      id: [prospect?.id],
      naturalPerson: [prospect?.naturalPerson, [Validators.required]],
      person: prospect?.naturalPerson ? this.createPersonForm(prospect?.person) : null,
      company: !prospect?.naturalPerson ? this.createCompanyForm(prospect?.company) : null
    });
  }

  private createCompanyForm(company: Company = new Company()): FormGroup {
    return this.fb.group({
      id: [company?.id],
      companyName: [company?.companyName, [Validators.required]],
      cnpj: [company?.cnpj, [Validators.required]],
      mcc: [company.mcc, [Validators.required]],
      contact: this.createPersonForm(company?.contact)
    });
  }

  private createPersonForm(person: Person = new Person()): FormGroup {
    return this.fb.group({
      id: [person?.id],
      name: [person?.name,],
      cpf: [person?.cpf],
      email: [person?.email],
      mcc: [person?.mcc]
    });
  }

  private loadStatus(): void {
    this.appService.loadEnum('')
      .subscribe(
        {
          next: enums => this.prospectAnalysisStatus = enums
        }
      );
  }

}
