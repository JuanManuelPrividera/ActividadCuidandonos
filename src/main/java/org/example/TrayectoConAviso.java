package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TrayectoConAviso implements Trayecto{

  private ArrayList<Destino> paradas;
  private Float distancia;
  private long duracionTotal;

  private LocalDateTime horaComienzo;
  private LocalDateTime horaFinalizacion;

  private ArrayList<LocalDateTime>llegadasIntermedias;
  private ArrayList<LocalDateTime> salidasIntermedias;

  public void pausar() {
    llegadasIntermedias.add(LocalDateTime.now());
  }

  public void continuar() {
    salidasIntermedias.add(LocalDateTime.now());
  }

  @Override
  public long calcularDemora() {
    Long tiempoEnParadas = 0L;
    for (int i = 0; i < salidasIntermedias.size(); i++) {
      tiempoEnParadas += Duration.between(salidasIntermedias.get(i),llegadasIntermedias.get(i)).getSeconds();
    }
    return duracionTotal - tiempoEnParadas;
  }

  @Override
  public void comenzar() {
    horaComienzo = LocalDateTime.now();
  }

  @Override
  public void finalizar() {
    horaFinalizacion = LocalDateTime.now();
  }
}
