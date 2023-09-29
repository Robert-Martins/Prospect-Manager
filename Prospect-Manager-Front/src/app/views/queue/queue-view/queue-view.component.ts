import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { EnumDto } from 'src/app/core/models/enum.model';
import { Prospect } from 'src/app/core/models/prospect.model';
import { Queue } from 'src/app/core/models/queue.model';
import { AppService } from 'src/app/core/services/app.service';
import { ProspectService } from 'src/app/core/services/prospect.service';
import { QueueService } from 'src/app/core/services/queue.service';

@Component({
  selector: 'app-queue-view',
  templateUrl: './queue-view.component.html',
  styleUrls: ['./queue-view.component.scss']
})
export class QueueViewComponent implements OnInit {

  public queue: Queue;

  constructor(
    private toastr: ToastrService,
    private spinner: NgxSpinnerService,
    private queueService: QueueService,
    private prospectService: ProspectService
  ) { 

  }

  ngOnInit(): void {
      this.loadQueue();
  }

  public get queueSize(): number {
    return this.queue?.queueItems?.length ?? 0;
  }

  public get current(): Prospect {
    return this.queue.first;
  }

  public onAnalyze(status: string): void {
    this.spinner.show();
    this.prospectService.analyze(this.current.id, status)
      .subscribe(
        {
          next: () => {
            this.toastr.success("Prospect avaliado");
            this.removeFirst();
          },
          error: error => {
            this.toastr.error(error?.details);
            this.removeFirst();
          }
        }
      )
  }

  private removeFirst(): void {
    this.queueService.removeFirst()
      .subscribe(
        {
          next: queue => {
            this.queue = queue;
            this.spinner.hide();
          },
          error: error => {
            this.toastr.error(error?.details);
            this.spinner.hide();
          }
        }
      )
  }

  private loadQueue(): void {
    this.spinner.show();
    this.queueService.getQueue()
      .subscribe(
        {
          next: queue => {
            this.queue = queue;
            this.spinner.hide();
          },
          error: error => {
            this.toastr.error(error?.details);
            this.spinner.hide();
          }
        }
      );
  }

}
