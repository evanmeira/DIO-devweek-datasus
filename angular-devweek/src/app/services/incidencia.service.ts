import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Incidencia } from '../model/incidencia';
import { FaixaEtariaService } from './faixa-etaria.service';
import { RegiaoService } from './regiao.service';

@Injectable({
  providedIn: 'root'
})
export class IncidenciaService {

  constructor(
    private http: HttpClient,
    private regiaoService: RegiaoService,
    private faixaEtariaService: FaixaEtariaService
  ) { }

  listIncidencias(): Observable<Incidencia[]>{
    return this.http.get<Incidencia[]>("/api/incidencia")
      .pipe(
        tap(
          incidencias => incidencias.forEach(
            incidendia => {
              this.regiaoService.getById(incidendia.regiao_id).subscribe(
                regiao => incidendia.regiao = regiao
              );
              this.faixaEtariaService.getById(incidendia.faixa_id).subscribe(
                faixa => incidendia.faixaEtaria = faixa
              )
            }
          )
        )
      );
  }
}
