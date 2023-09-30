import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Queue } from '../models/queue.model';

@Injectable({
  providedIn: 'root'
})
export class QueueService {

  private apiUrl: string = "http://localhost:9090";

  constructor(
    private http: HttpClient
  ) { 
    this.apiUrl = this.apiUrl.concat("/queue");
  }

  public insertLast(id: string): Observable<void> {
    return this.http.post<void>(this.apiUrl, id);
  }

  public getQueue(): Observable<Queue> {
    return this.http.get<Queue>(this.apiUrl);
  }

  public removeFirst(): Observable<Queue> {
    return this.http.delete<Queue>(this.apiUrl);
  }

}
