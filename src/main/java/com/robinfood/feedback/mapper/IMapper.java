package com.robinfood.feedback.mapper;

public interface IMapper<T, S> {
  S map(T t);
}
