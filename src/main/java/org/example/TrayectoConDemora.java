package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TrayectoConDemora implements Trayecto{
  private ArrayList<Destino> paradas;
  private Float distancia;
  private long duracionTotal;
  private long demoraPorParada;

  private LocalDateTime horaComienzo;
  private LocalDateTime horaFinalizacion;

  public TrayectoConDemora(ArrayList<Destino> paradas, int demoraPorParada){
    this.paradas = paradas;
    this.demoraPorParada = demoraPorParada;
  }

  @Override
  public long calcularDemora() {
    return duracionTotal - paradas.size() * demoraPorParada;
  }

  @Override
  public void comenzar() {
    horaComienzo = LocalDateTime.now();
  }

  @Override
  public void finalizar() {
    horaFinalizacion = LocalDateTime.now();
    duracionTotal = Duration.between(horaFinalizacion, horaComienzo).getSeconds();
  }
}
