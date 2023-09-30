import { ProspectService } from './../../../core/services/prospect.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { EnumDto } from 'src/app/core/models/enum.model';
import { Prospect } from 'src/app/core/models/prospect.model';
import { AppService } from 'src/app/core/services/app.service';
import AppDataSource from 'src/app/shared/directives/models/data/data-source.model';

@Component({
  selector: 'app-prospects-list',
  templateUrl: './prospects-list.component.html',
  styleUrls: ['./prospects-list.component.scss']
})
export class ProspectsListComponent implements OnInit {

  public readonly displayedColumns: string[] = ['name', 'taxId', 'mcc'];

  public prospects: Prospect[] = [];

  public prospectAnalysisStatus: EnumDto[] = [];

  public filterForm: FormGroup;

  public dataSource: AppDataSource<Prospect> = new AppDataSource([]);

  constructor(
    private toastr: ToastrService,
    private spinner: NgxSpinnerService,
    private prospectService: ProspectService,
    private appService: AppService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
      this.createFilterForm();
      this.loadItems();
  }

  public get filterFormValues() {
    return this.filterForm?.value;
  }

  public newProspect(): void {
    this.toForm('0');
  }

  public toForm(id: string): void {
    this.router.navigate([`/prospects/form/${id}`]);
  }

  public onApplyFilter(): void {
    this.loadProspects();
  }

  public onClearFilter(): void {
    this.filterForm.reset();
    this.loadProspects();
  }

  private loadItems(): void {
    this.loadProspects();
    this.loadProspectsAnalysisStatus();
  }

  private loadProspects(): void {
    this.spinner.show();
    this.prospectService.readAll(
      this.filterFormValues?.name,
      this.filterFormValues?.taxId,
      this.filterFormValues?.mcc,
      this.filterFormValues?.status,
      this.filterFormValues?.naturalPerson,
      this.filterFormValues?.initialDate,
      this.filterFormValues?.finalDate
    ).subscribe(
      {
        next: prospects => {
          this.prospects = prospects;
          this.dataSource.setData(prospects);
          this.spinner.hide();
        },
        error: error => {
          this.toastr.error(error?.details);
          this.spinner.hide();
        }
      }
    );
  }

  private loadProspectsAnalysisStatus(): void {
    this.appService.loadEnum('prospectAnalysisStatus')
      .subscribe(
        {
          next: enums => this.prospectAnalysisStatus = enums
        }
      );
  }

  private createFilterForm(): void {
    this.filterForm = this.fb.group({
      name: [],
      taxId: [],
      mcc: [],
      status: [],
      naturalPerson: [],
      initialDate: [],
      finalDate: []
    })
  }

}
