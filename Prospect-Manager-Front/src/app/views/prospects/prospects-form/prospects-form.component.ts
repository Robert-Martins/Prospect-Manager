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

  public naturalPerson: boolean = true;

  constructor(
    private toastr: ToastrService,
    private spinner: NgxSpinnerService,
    private prospectService: ProspectService,
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

  public get personFormGroup(): FormGroup {
    return this.prospectForm.get('person') as FormGroup;
  }

  public get companyFormGroup(): FormGroup {
    return this.prospectForm.get('company') as FormGroup;
  }

  public get isNaturalPerson(): boolean {
    return this.prospectFormValues.naturalPerson;
  }

  public toList(): void {
    this.router.navigate(['/prospects']);
  }

  public onSubmit(): void {
    this.prospectId && this.prospectId != '0' ?
        this.update()
      :
        this.create();
  }

  public onNaturalPersonChange(): void {
    this.createProspectForm(this.prospectFormValues);
  }

  private loadItems(): void {
    this.spinner.show()
    this.prospectId = this.activatedRoute.snapshot.paramMap.get('id');
    this.prospectId && this.prospectId !== '0' ?
        this.read()
      :
        this.createProspectForm();
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
    this.prospectService.read(this.prospectId)
      .subscribe(
        {
          next: prospect => {
            this.prospect = prospect;
            this.naturalPerson = prospect?.naturalPerson;
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
    this.spinner.hide();
    this.prospectForm = this.fb.group({
      id: [prospect?.id],
      naturalPerson: [prospect?.naturalPerson != null ? prospect?.naturalPerson : true, [Validators.required]],
      person: this.naturalPerson ? this.createPersonForm(prospect?.person) : null,
      company: !this.naturalPerson ? this.createCompanyForm(prospect?.company) : null
    });
    console.log(this.prospectForm)
  }

  private createCompanyForm(company: Company = new Company()): FormGroup {
    return this.fb.group({
      id: [company?.id],
      companyName: [company?.companyName, [Validators.required, Validators.maxLength(50)]],
      cnpj: [company?.cnpj, [Validators.required, Validators.min(14), Validators.max(14)]],
      mcc: [company?.mcc, [Validators.required, Validators.max(4)]],
      contact: this.createPersonForm(company?.contact, true)
    });
  }

  private createPersonForm(person: Person = new Person(), isContact: boolean = false): FormGroup {
    return this.fb.group({
      id: [person?.id],
      name: [person?.name, [Validators.required, Validators.maxLength(50)]],
      cpf: [person?.cpf, [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
      email: [person?.email, [Validators.required]],
      mcc: [person?.mcc, isContact ? [ Validators.required, Validators.max(9999) ] : [Validators.max(9999)]]
    });
  }

}
