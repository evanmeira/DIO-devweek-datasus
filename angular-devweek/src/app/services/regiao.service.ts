import { Injectable } from '@angular/core';
import { Regiao } from '../model/regiao';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegiaoService {

  constructor(
    private http: HttpClient
  ) { }

  listRegioes(): Observable<Regiao[]>{
    return this.http.get<Regiao[]>('/api/regiao');
  }

  getById(id: number): Observable<Regiao>{
    return this.http.get<Regiao>(`/api/regiao/${id}`)
  }
}
