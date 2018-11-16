package com.red30tech.backend;

import com.red30tech.database.api.Database;
import com.red30tech.database.api.DatabaseFactory;
import com.red30tech.cache.api.Cache;

public class Processor {

  public static void main(String... args) {
     Database database = DatabaseFactory.getDatabase();

     try {
        database = new Cache(database);
     }
     catch (NoClassDefFoundError exception) {
        System.out.println("No cache found");
     }

     System.out.println("Using database: " + database.getClass().getName());

     database.create("One", "Modularity is good");
     System.out.println(database.get("One"));
     database.update("One", "Modularity is great");    
     System.out.println(database.get("One"));
     database.delete("One");
     System.out.println(database.get("One"));
  }
}
