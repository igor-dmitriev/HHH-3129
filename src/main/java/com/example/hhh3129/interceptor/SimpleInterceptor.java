package com.example.hhh3129.interceptor;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.collection.spi.PersistentCollection;

import java.io.Serializable;

/**
 * Created by Igor Dmitriev on 11/30/17
 */
public class SimpleInterceptor extends EmptyInterceptor {
  @Override
  public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
    super.onCollectionRecreate(collection, key);
    System.out.println("onCollectionRecreate role -> " + ((PersistentCollection) collection).getRole());
  }

  @Override
  public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
    super.onCollectionUpdate(collection, key);
    System.out.println("onCollectionUpdate role -> " + ((PersistentCollection) collection).getRole());
  }
}
