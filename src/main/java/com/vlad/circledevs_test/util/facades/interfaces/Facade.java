package com.vlad.circledevs_test.util.facades.interfaces;

import java.util.List;

public interface Facade<T> {
  List<T> getAll();

  T getById(Integer id);

  void delete(T t);

  T create(T t);

  Boolean existById(int id);
}


