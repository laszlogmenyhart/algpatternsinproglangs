import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Reszvenyek {

    public static void main(String[] args) {
        System.out.println("Prices");

        // deklarálás
        final int MaxN = 1000000;
        int N;
        int[] reszvenyek = new int[MaxN];
        int[] arfolyamok = new int[MaxN];
        long start;
        long end;
        long diff;

        boolean van;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat sdf_diff = new SimpleDateFormat("mm:ss.SSS");

        // beolvasás
        Scanner scan = new Scanner(System.in);
        System.out.print("N=?: ");
        N = scan.nextInt();
        List<Integer> reszvenyekList = new ArrayList<>(N);
        List<Integer> arfolyamokList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            System.out.println("" + (i + 1) + ". day's data:");
            System.out.print(" HUF/unit: ");
            reszvenyek[i] = scan.nextInt();
            reszvenyekList.add(reszvenyek[i]);
            System.out.print(" EUR/HUF: ");
            arfolyamok[i] = scan.nextInt();
            arfolyamokList.add(arfolyamok[i]);
        }
        // IntStream reszvenyekStream = Arrays.stream(reszvenyek);
        // IntStream arfolyamokStream = Arrays.stream(arfolyamok);
        scan.close();

        System.out.println();
        System.out.println("PoA");
        van = eldontes_poa(N, reszvenyek);
        System.out.println(van ? "YES" : "NO");
        System.out.println("start: " + sdf.format(System.currentTimeMillis()));
        diff = 0;
        for (int i = 0; i < 1000000; i++) {
            start = System.currentTimeMillis();
            van = eldontes_poa(N, reszvenyek);
            diff += System.currentTimeMillis() - start;
        }
        System.out.println("diff: " + sdf_diff.format(diff));
        System.out.println("end: " + sdf.format(System.currentTimeMillis()));

        System.out.println();
        System.out.println("PoA List");
        van = eldontes_poa(N, reszvenyekList);
        System.out.println(van ? "YES" : "NO");
        System.out.println("start: " + sdf.format(System.currentTimeMillis()));
        diff = 0;
        for (int i = 0; i < 1000000; i++) {
            start = System.currentTimeMillis();
            van = eldontes_poa(N, reszvenyekList);
            diff += System.currentTimeMillis() - start;
        }
        System.out.println("diff: " + sdf_diff.format(diff));
        System.out.println("end: " + sdf.format(System.currentTimeMillis()));

        System.out.println();
        System.out.println("Foreach");
        // megoldás
        van = eldontes_foreach(N, reszvenyek);
        System.out.println(van ? "YES" : "NO");
        System.out.println("start: " + sdf.format(System.currentTimeMillis()));
        diff = 0;
        for (int i = 0; i < 1000000; i++) {
            start = System.currentTimeMillis();
            van = eldontes_foreach(N, reszvenyek);
            diff += System.currentTimeMillis() - start;
        }
        System.out.println("diff: " + sdf_diff.format(diff));
        System.out.println("end: " + sdf.format(System.currentTimeMillis()));

        System.out.println();
        System.out.println("Foreach List");
        // megoldás
        van = eldontes_foreach(N, reszvenyekList);
        System.out.println(van ? "YES" : "NO");
        System.out.println("start: " + sdf.format(System.currentTimeMillis()));
        diff = 0;
        for (int i = 0; i < 1000000; i++) {
            start = System.currentTimeMillis();
            van = eldontes_foreach(N, reszvenyekList);
            diff += System.currentTimeMillis() - start;
        }
        System.out.println("diff: " + sdf_diff.format(diff));
        System.out.println("end: " + sdf.format(System.currentTimeMillis()));

        System.out.println();
        System.out.println("Foreach List (Integer)");
        // megoldás
        van = eldontes_foreachInt(N, reszvenyekList);
        System.out.println(van ? "YES" : "NO");
        System.out.println("start: " + sdf.format(System.currentTimeMillis()));
        diff = 0;
        for (int i = 0; i < 1000000; i++) {
            start = System.currentTimeMillis();
            van = eldontes_foreachInt(N, reszvenyekList);
            diff += System.currentTimeMillis() - start;
        }
        System.out.println("diff: " + sdf_diff.format(diff));
        System.out.println("end: " + sdf.format(System.currentTimeMillis()));

        System.out.println();
        System.out.println("Iterator");
        // megoldás
        van = eldontes_iterator(N, reszvenyekList);
        System.out.println(van ? "YES" : "NO");
        System.out.println("start: " + sdf.format(System.currentTimeMillis()));
        diff = 0;
        for (int i = 0; i < 1000000; i++) {
            start = System.currentTimeMillis();
            van = eldontes_iterator(N, reszvenyekList);
            diff += System.currentTimeMillis() - start;
        }
        System.out.println("diff: " + sdf_diff.format(diff));
        System.out.println("end: " + sdf.format(System.currentTimeMillis()));

        System.out.println();
        System.out.println("Stream");
        IntStream reszvenyekStream = Arrays.stream(reszvenyek);
        van = eldontes_stream(N, reszvenyekStream);
        System.out.println(van ? "YES" : "NO");
        System.out.println("start: " + sdf.format(System.currentTimeMillis()));
        diff = 0;
        for (int i = 0; i < 1000000; i++) {
            reszvenyekStream = Arrays.stream(reszvenyek);
            start = System.currentTimeMillis();
            van = eldontes_stream(N, reszvenyekStream);
            diff += System.currentTimeMillis() - start;
        }
        System.out.println("diff: " + sdf_diff.format(diff));
        System.out.println("end: " + sdf.format(System.currentTimeMillis()));

    }

    /*
     * * /
     * // Visual Studi Code generálta:
     * static boolean eldontes(int N, int[] reszvenyek) {
     * boolean van=false;
     * for (int i=0;i<N;i++) {
     * if (reszvenyek[i]>1000) {
     * van=true;
     * }
     * }
     * return van;
     * }
     * /*
     */

    static boolean eldontes_poa(int N, int[] reszvenyek) {
        int i = 0;
        while ((i < N) && (reszvenyek[i] != 42)) {
            i++;
        }
        return (i < N);
    }

    static boolean eldontes_poa(int N, List<Integer> reszvenyekList) {
        int i = 0;
        while ((i < N) && (reszvenyekList.get(i) != 42)) {
            i++;
        }
        return (i < N);
    }

    static boolean eldontes_foreach(int N, int[] reszvenyek) {
        for (int r : reszvenyek) {
            if (r == 42) {
                return true;
            }
        }
        return false;
    }

    static boolean eldontes_foreach(int N, List<Integer> reszvenyekList) {
        for (int r : reszvenyekList) {
            if (r == 42) {
                return true;
            }
        }
        return false;
    }

    static boolean eldontes_foreachInt(int N, List<Integer> reszvenyekList) {
        for (Integer r : reszvenyekList) {
            if (r == 42) {
                return true;
            }
        }
        return false;
    }

    static boolean eldontes_iterator(int N, List<Integer> reszvenyekList) {
        Iterator<Integer> it = reszvenyekList.iterator();
        while (it.hasNext()) {
            Integer r = it.next();
            if (r == 42) {
                return true;
            }
        }
        return false;
    }

    static boolean eldontes_stream(int N, IntStream reszvenyekStream) {
        return reszvenyekStream.anyMatch(r -> r == 42);
    }

}