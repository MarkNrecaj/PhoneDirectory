import javax.swing.*;
/** Directory  implements a Directory of records */
public class Directory
{ public PhoneEntry[] base;   // the collection of records
  private int NOT_FOUND = -1;  // int used to denote when a PhoneEntry not found
  private int w = 0;
  /** Constructor  Directory  initializes the Directory
    * @param initial_size - the size of the Directory */
  public Directory(int initial_size)
  { if ( initial_size > 0 )
         { base = new PhoneEntry[initial_size]; }
    else { base = new PhoneEntry[1]; }
  }

    /** gjejIndeksin  is a helper method that searches  base  for a record
     *  whose key is  k.   If found, the index of the record is returned,
     *  else  NOT_FOUND  is returned.  */
  public int gjejIndeksin(Emri k){

  int rez = NOT_FOUND;
  for(int i = 0; i< w; i++){
      if (base[i].getKey().getEmri().equalsIgnoreCase( k.getEmri()))
      { rez = i;
        break;
      }
      else{ JOptionPane.showMessageDialog(null, "Personi:  nuk ekziston");}
  }
  return rez;
  }


  /** find  locates a PhoneEntry in the Directory based on a key
    * @param k - the key of the desired PhoneEntry
    * @return (the address of) the desired record;
    *  return  null if record not found.  */
  public PhoneEntry find(Emri k)
  { PhoneEntry answer = null;
    int index = gjejIndeksin(k);
    if ( index != NOT_FOUND )
       { answer = base[index]; }
    return answer;
  }
  /** insert inserts a new PhoneEntry into the Directory.
    * @param r - the PhoneEntry
    * @return true, if record added; return false if record not added because
    *   another record with the same key already exists in the Directory */
  public boolean insert(PhoneEntry r)
  { boolean success = false;
    if ( gjejIndeksin(r.getKey()) == NOT_FOUND )  // r  not already in  base?
       { // find an empty element in  base  for insertion of  r:
         boolean found_empty_place = false;
         int i = 0;
         while ( !found_empty_place  &&  i != base.length )
               // so far, all of  base[0]..base[i-1]  are occupied
               { if ( base[i] == null )   // is this element empty?
                      { found_empty_place = true; }
                 else { i = i + 1; }
               }
         if ( found_empty_place )
              { base[i] = r; }
         else { // array is full!  So, create a new one to hold more records:
                PhoneEntry[] temp = new PhoneEntry[base.length * 2];
                for ( int j = 0;  j != base.length;  j = j + 1 )
                    { temp[j] = base[j]; } // copy  base  into  temp
                temp[base.length] = r;   // insert  r  in first free element
                base = temp;   // change  base  to hold address of  temp
              }
         success = true;
         w++;
       }

    return success;
  }

  /** delete removes a PhoneEntry in the Directory based on a key
    * @param k - the PhoneEntry's key (identification)
    * @return true, if PhoneEntry is found and deleted; return false otherwise  */
  public boolean delete(Emri k)
  { boolean result = false;
  
    int index = gjejIndeksin(k);
    for(int i = index;i<base.length-1;i++)
            {
             base[i] = base[i+1];
            
    if ( index != NOT_FOUND )
       { base[index] = null;
         result = true;
       }}
    return result;
  }
}