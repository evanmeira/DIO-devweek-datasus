import { Component, OnInit } from '@angular/core';
import { FaixaEtaria } from 'src/app/model/faixaEtaria';
import { Incidencia } from 'src/app/model/incidencia';
import { Regiao } from 'src/app/model/regiao';
import { FaixaEtariaService } from 'src/app/services/faixa-etaria.service';
import { IncidenciaService } from 'src/app/services/incidencia.service';
import { RegiaoService } from 'src/app/services/regiao.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {

  regioes: Regiao[] = [];
  inicidencias: Incidencia[] = [];
  faixaEtarias: FaixaEtaria[] = [];

  constructor(
    private regiaoService: RegiaoService,
    private incidenciaService: IncidenciaService,
    private faixaEtariaService: FaixaEtariaService
  ) { }

  ngOnInit(): void {
    this.regiaoService.listRegioes().subscribe(
      regioes => this.regioes = regioes
    );
    this.incidenciaService.listIncidencias().subscribe(
      incidencias => this.inicidencias = incidencias
    );
    this.faixaEtariaService.listFaixaEtaria().subscribe(
      faixaEtarias => this.faixaEtarias = faixaEtarias
    );
  }

}
