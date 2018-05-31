import javax.swing.*;

public class PhoneDirectoryTest {
    public static void main(String[] args) {
        Directory a = new Directory(20);
        Writer v = null;
        int c = 0;
        String n;
        String s;



        while (true) {
            String input = JOptionPane.showInputDialog("Ju lutem zgjedhni njerin nga opsionet:\n" +
                    "1. Regjistro nje kontakt \n2. Kerko nje kontakt \n3. Fshije nje kontakt");
            //int in = new Integer(input);
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Aplikacioni u mbyll");
                break;
            } else if (input.equals("")) {
                JOptionPane.showMessageDialog(null, "Ju lutem shenoni njerin nga opsionet 1, 2 ose 3");
                continue;
            } else if (input.equals("1")) {
                s = JOptionPane.showInputDialog("Sheno Emrin");
                String number = JOptionPane.showInputDialog("Sheno Numrin");
                n = number;

                    a.insert(new PhoneEntry(new Emri(s), n));
                JOptionPane.showMessageDialog(null, "Kontakti u regjistrua me sukses:\n"
                        + "Emri:    " + s +"\nNumri:  " + n);
                System.out.println("Emri: " + s);

            } else if (input.equals("2")) {
                s = JOptionPane.showInputDialog("Sheno Emrin");
                //System.out.println(a.base[0].getKey().getEmri());
                int indeksi = a.gjejIndeksin(new Emri(s));
                //System.out.println(indeksi);
                if (a.find(new Emri(s)) == null ) {
                    JOptionPane.showMessageDialog(null, "Personi: " + s + " nuk ekziston");
                } //Problem
                else if (c == 0) {
                    v = new Writer(indeksi, a);
                    c++;
                } else {
                    v.jepVlerat(indeksi);
                    v.repaint();
                }

            } else if (input.equals("3")) {
                s = JOptionPane.showInputDialog("Sheno Emrin e kontaktit qe deshironi ta fshini");
                //int indeksi = a.gjejIndeksin(new Emri(s));
                a.delete(new Emri(s));
            }


            //System.out.println(a.base[0]);
        }


    }

}