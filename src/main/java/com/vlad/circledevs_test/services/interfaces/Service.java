package com.vlad.circledevs_test.services.interfaces;

import java.util.List;

public interface Service<T> {
  public List<T> findAll();

  public T findById(int id);

  public T save(T customer);

  public void delete(T t);

  public Boolean existsById(int id);
}
