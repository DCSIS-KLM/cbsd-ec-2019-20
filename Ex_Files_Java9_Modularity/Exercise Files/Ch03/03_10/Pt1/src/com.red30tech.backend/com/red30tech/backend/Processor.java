package com.red30tech.backend;

import com.red30tech.database.api.Database;
import com.red30tech.database.api.DatabaseFactory;

public class Processor {

  public static void main(String... args) {
     Database database = DatabaseFactory.getDatabase();

     database.create("One", "Modularity is good");
     System.out.println(database.get("One"));
     database.update("One", "Modularity is great");    
     System.out.println(database.get("One"));
     database.delete("One");
     System.out.println(database.get("One"));
  }
}
