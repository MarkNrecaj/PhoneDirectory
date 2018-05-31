
public class Emri
{ private String name;
   public Emri(String i) {  name = i; }

    public boolean equals(Emri c)
  {   String s = c.getEmri();
      return  ( name.equals(s) ); }

  public String getEmri()
  {   return name; }
}