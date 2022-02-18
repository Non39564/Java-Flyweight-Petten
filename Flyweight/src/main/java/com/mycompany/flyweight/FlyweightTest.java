package com.mycompany.flyweight;

import java.util.StringTokenizer;
import java.util.Vector;

public class FlyweightTest {

  public static void main(String[] args) throws Exception {
    Vector empList = initialize();
    AddressFactory factory = AddressFactory.getInstance();

    for (int i = 0; i < empList.size(); i++) {
      String s = (String) empList.elementAt(i);
      StringTokenizer st = new StringTokenizer(s, ",");
      String name = st.nextToken();
      String title = st.nextToken();
      String division = st.nextToken();

      AddressInfo flyweight = factory.getFlyweight(division);
      VCard card = new VCard(name, title, flyweight);
      card.print();
    }
  }

  private static Vector initialize() {

    Vector v = new Vector();
    v.add("name1,title1,North");
    v.add("name2,title2,South");
    v.add("name4,title3,East");
    v.add("name7,title1,West");

    return v;
  }
}