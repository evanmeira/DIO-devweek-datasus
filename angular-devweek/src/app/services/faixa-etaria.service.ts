import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FaixaEtaria } from '../model/faixaEtaria';

@Injectable({
  providedIn: 'root'
})
export class FaixaEtariaService {

  constructor(
    private http: HttpClient
  ) { }

  listFaixaEtaria(): Observable<FaixaEtaria[]>{
    return this.http.get<FaixaEtaria[]>("/api/faixaetaria");
  }

  getById(id: number): Observable<FaixaEtaria>{
    return this.http.get<FaixaEtaria>(`/api/faixaetaria/${id}`);
  }
}
