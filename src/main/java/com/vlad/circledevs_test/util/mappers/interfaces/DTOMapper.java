package com.vlad.circledevs_test.util.mappers.interfaces;

public interface DTOMapper <D,T> {
  public T toDTO(D t);
  public D fromDTO(T t);
}
