/** PhoneEntry models a phone directory */
public class PhoneEntry
{
  private Emri emri;
  private String numri;
  
  
  /** Constructor PhoneEntry constructs the directory.
    * @param e - the directory's name
    * @param n - the directory's phonee number */
  public PhoneEntry(Emri e, String n)
  { emri = e;
    numri = n;
  }

  /** getkey  returns the key that identifies the PhoneEntry
    * @return the key  */
  public Emri getKey() { return emri; }

  /** Number returns the directory's phone number
    * @return the number */
  public String getNumber() { return numri; }

}