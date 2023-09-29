import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http"
import { Observable } from 'rxjs';
import { EnumDto } from '../models/enum.model';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private apiUrl: string = "http://localhost:9090";

  constructor(
    private http: HttpClient
  ) { 
    this.apiUrl = this.apiUrl.concat("/app");
  }

  public loadEnum(type: string): Observable<EnumDto[]> {
    return this.http.get<EnumDto[]>(`${this.apiUrl}/${type}`);
  }

}
