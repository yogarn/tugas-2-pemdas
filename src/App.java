public class App {
    final static int MAX_SISWA = 10;
    final static int MAX_MATPEL = 10;
    final static int MAX_SEMESTER = 2;
    /* menyimpan nama siswa */
    static String[] siswa = new String[MAX_SISWA];
    /* menyimpan nama matpel per siswa tiap semester, semester ganjil = 0, genap = 1 */
    static String[][][] siswaMatpel = new String[MAX_SISWA][MAX_SEMESTER][MAX_MATPEL];
    /* menyimpan nilai matpel per siswa tiap semester, semester ganjil = 0; genap = 1 */
    static double[][][] siswaMatpelNilai = new double[MAX_SISWA][MAX_SEMESTER][MAX_MATPEL];
    /* menyimpan banyak siswa */
    static int banyakSiswa = 0;
    /* menyimpan banyak matpel */
    static int banyakSiswaMatpel = 0;
    
    public static String konversiNilai(double nilai) {
        //satria
    }

    public static void tambahSiswa(String nama) {
        //satria
    }

    public static void tambahMatpel(String matpel) {
        //satria
    }

    public static int cariSiswa(String nama) {
        //conflict
    }

    public static int cariMatpel(String matpel) {
        //conflict
    }
    
    /*
    nama: nama siswa
    semester: semester, 0 untuk ganjil, 1 untuk genap
    matpel: nama matpel
    nilai: nilai matpel tiap semester
    */
    public static void isiDataSiswa(String nama, int semester, String matpel, int nilai) {
        //yoga
    }

    public static void printSiswa() {
        //satria
    }

    public static void printRaportSiswa(String nama) {
        //satria
    }

    public static int cariJuara(int semester) {
        //yoga
    }

    public static void hitungNilai(int semester) {
        //yoga
    }

    public static void main(String[] args) {
        //yoga
    }
}
