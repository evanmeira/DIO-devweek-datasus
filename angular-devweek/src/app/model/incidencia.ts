import { FaixaEtaria } from "./faixaEtaria";
import { Regiao } from "./regiao";

export interface Incidencia{
  id: number;
  regiao_id: number;
  mes: number;
  faixa_id: number;
  qnt_exames: number;

  regiao: Regiao;
  faixaEtaria: FaixaEtaria
}