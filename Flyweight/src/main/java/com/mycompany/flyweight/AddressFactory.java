package com.mycompany.flyweight;

import java.util.HashMap;

public class AddressFactory {
    private HashMap lstFlyweight;

  private static AddressFactory factory = new AddressFactory();

  private AddressFactory() {
    lstFlyweight = new HashMap();
  }

  public synchronized AddressInfo getFlyweight(String divisionName) {
    if (lstFlyweight.get(divisionName) == null) {
      AddressInfo fw = new Address(divisionName);
      lstFlyweight.put(divisionName, fw);
      return fw;
    } else {
      return (AddressInfo) lstFlyweight.get(divisionName);
    }
  }

  public static AddressFactory getInstance() {
    return factory;
  }
    
}
