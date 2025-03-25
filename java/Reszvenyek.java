import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Reszvenyek {

    public static void main(String[] args) {
        System.out.println("Reszvenyek");

        // deklarálás
        final int MaxN = 1000000;
        int N;
        int[] reszvenyek = new int[MaxN];
        int[] arfolyamok = new int[MaxN];
        
        
        boolean van;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        // beolvasás
        Scanner scan = new Scanner(System.in);
        System.out.print("N=?: ");
        N = scan.nextInt();
        List<Integer> reszvenyekList = new ArrayList<>(N);
        List<Integer> arfolyamokList = new ArrayList<>(N);
        for (int i=0;i<N;i++) {
            System.out.println("A(z) "+(i+1)+". nap adatai:");
            System.out.print(" reszveny: ");
            reszvenyek[i] = scan.nextInt();
            reszvenyekList.add(reszvenyek[i]);
            System.out.print(" arfolyam: ");
            arfolyamok[i] = scan.nextInt();
            arfolyamokList.add(arfolyamok[i]);
        }
        scan.close();

        System.out.println();
        System.out.println("PoA");
        van=eldontes_poa(N,reszvenyek);
        System.out.println(van?"IGEN":"NEM");
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        for (int i=0;i<1000000;i++) {
            van=eldontes_poa(N,reszvenyek);
        }
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        
        System.out.println();
        System.out.println("PoA List");
        van=eldontes_poa(N,reszvenyekList);
        System.out.println(van?"IGEN":"NEM");
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        for (int i=0;i<1000000;i++) {
            van=eldontes_poa(N,reszvenyekList);
        }
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        

        System.out.println();
        System.out.println("Foreach");
        // megoldás
        van=eldontes_foreach(N,reszvenyek);
        System.out.println(van?"IGEN":"NEM");
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        for (int i=0;i<1000000;i++) {
            van=eldontes_foreach(N,reszvenyek);
        }
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        
        System.out.println();
        System.out.println("Foreach List");
        // megoldás
        van=eldontes_foreach(N,reszvenyekList);
        System.out.println(van?"IGEN":"NEM");
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        for (int i=0;i<1000000;i++) {
            van=eldontes_foreach(N,reszvenyekList);
        }
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        
        System.out.println();
        System.out.println("Foreach List (Integer)");
        // megoldás
        van=eldontes_foreachInt(N,reszvenyekList);
        System.out.println(van?"IGEN":"NEM");
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        for (int i=0;i<1000000;i++) {
            van=eldontes_foreachInt(N,reszvenyekList);
        }
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));

        System.out.println();
        System.out.println("Foreach Iterator");
        // megoldás
        van=eldontes_iterator(N,reszvenyekList);
        System.out.println(van?"IGEN":"NEM");
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        for (int i=0;i<1000000;i++) {
            van=eldontes_iterator(N,reszvenyekList);
        }
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));

        System.out.println();
        System.out.println("Stream");
        van=eldontes_stream(N,reszvenyek);
        System.out.println(van?"IGEN":"NEM");
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));
        for (int i=0;i<1000000;i++) {
            van=eldontes_stream(N,reszvenyek);
        }
        System.out.println("Időbélyeg: "+sdf.format(System.currentTimeMillis()));

    }

    /* * /
    // Visual Studi Code generálta:
    static boolean eldontes(int N, int[] reszvenyek) {
        boolean van=false;
        for (int i=0;i<N;i++) {
            if (reszvenyek[i]>1000) {
                van=true;
            }
        }
        return van;
    }
    /* */


    static boolean eldontes_poa(int N, int[] reszvenyek) {
        int i=0;
        while ((i<N) && (reszvenyek[i]!=42)) { 
            i++;
        }
        return (i<N);
    }

    static boolean eldontes_poa(int N, List<Integer> reszvenyekList) {
        int i=0;
        while ((i<N) && (reszvenyekList.get(i)!=42)) { 
            i++;
        }
        return (i<N);
    }

    static boolean eldontes_foreach(int N, int[] reszvenyek) {
        for (int r: reszvenyek) {
            if (r==42) {
                return true;
            }
        }
        return false;
    }

    static boolean eldontes_foreach(int N, List<Integer> reszvenyekList) {
        for (int r: reszvenyekList) {
            if (r==42) {
                return true;
            }
        }
        return false;
    }

    static boolean eldontes_foreachInt(int N, List<Integer> reszvenyekList) {
        for (Integer r: reszvenyekList) {
            if (r==42) {
                return true;
            }
        }
        return false;
    }

    static boolean eldontes_iterator(int N, List<Integer> reszvenyekList) {
        Iterator<Integer> it = reszvenyekList.iterator();
        while (it.hasNext()) {
            Integer r=it.next();
            if (r==42) {
                return true;
            }
        }
        return false;
    }

    static boolean eldontes_stream(int N, int[] reszvenyek) {
        return Arrays.stream(reszvenyek).anyMatch(r -> r==42);
    }

}