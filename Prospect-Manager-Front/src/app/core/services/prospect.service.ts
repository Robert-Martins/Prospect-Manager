import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Prospect } from '../models/prospect.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProspectService {

  private apiUrl: string = "http://localhost:9090";
  
  constructor(
    private http: HttpClient
  ) { 
    this.apiUrl = this.apiUrl.concat("/prospects");
  }

  public create(prospect: Prospect): Observable<void> {
    return this.http.post<void>(
      this.apiUrl,
      prospect
    );
  }

  public read(id: string): Observable<Prospect> {
    return this.http.get<Prospect>(`${this.apiUrl}/${id}`);
  }

  public readAll(
    name: string,
    taxId: string,
    mcc: number,
    status: string,
    naturalPerson: boolean,
    initialDate: Date,
    finalDate: Date
  ): Observable<Prospect[]> {
    return this.http.get<Prospect[]>(
      this.apiUrl +
      `?name=${name}` +
      `&taxId=${taxId}` +
      `&mcc=${mcc}` +
      `&status=${status}` +
      `&naturalPerson=${naturalPerson}` +
      `&initialDate=${initialDate}` +
      `&finalDate=${finalDate}`
    );
  }

  public update(prospect: Prospect): Observable<void> {
    return this.http.put<void>(
      this.apiUrl,
      prospect
    );
  }

  public delete(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  public analyze(id: string, status: string): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/${id}/${status}`, null);
  }

}
