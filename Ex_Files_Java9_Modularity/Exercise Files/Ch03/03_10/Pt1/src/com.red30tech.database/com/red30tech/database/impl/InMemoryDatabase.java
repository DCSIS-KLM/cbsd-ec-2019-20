package com.red30tech.database.impl;

import java.util.Map;
import java.util.HashMap;

import com.red30tech.database.api.Database;

public class InMemoryDatabase implements Database {

   private final Map<String, Object> database;

   public InMemoryDatabase() {
      database = new HashMap<String, Object>();
   }

   public void create(String key, Object value) {
      database.put(key, value);
   }

   public Object get(String key) {
      return database.get(key);
   }

   public void update(String key, Object value) {
      create(key, value);
   }

   public void delete(String key) {
      database.remove(key);
   }
}
