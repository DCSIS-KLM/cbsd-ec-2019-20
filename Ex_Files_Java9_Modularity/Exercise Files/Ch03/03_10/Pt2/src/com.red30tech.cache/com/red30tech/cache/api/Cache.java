package com.red30tech.cache.api;

import com.red30tech.database.api.Database;

public class Cache implements Database {

   private final Database backendDatabase;

   public Cache(Database database) {
      backendDatabase = database;
   }

   public void create(String key, Object value) {
      backendDatabase.create(key, value);
   }

   public Object get(String key) {
      return backendDatabase.get(key);
   }

   public void update(String key, Object value) {
      backendDatabase.update(key, value);
   }

   public void delete(String key) {
      backendDatabase.delete(key);
   }
}
