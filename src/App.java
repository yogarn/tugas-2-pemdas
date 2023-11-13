import java.util.Scanner;

public class App {
    final static int MAX_SISWA = 10;
    final static int MAX_MATPEL = 10;
    final static int MAX_SEMESTER = 2;
    /* menyimpan nama siswa */
    static String[] siswa = new String[MAX_SISWA];
    /*
     * menyimpan nama matpel per siswa tiap semester, semester ganjil = 0, genap = 1
     */
    static String[][][] siswaMatpel = new String[MAX_SISWA][MAX_SEMESTER][MAX_MATPEL];
    /*
     * menyimpan nilai matpel per siswa tiap semester, semester ganjil = 0; genap =
     * 1
     */
    static double[][][] siswaMatpelNilai = new double[MAX_SISWA][MAX_SEMESTER][MAX_MATPEL];
    /* menyimpan banyak siswa */
    static int banyakSiswa = 0;
    /* menyimpan banyak matpel */
    static int banyakSiswaMatpel = 0;

    public static String konversiNilai(double nilai) {
        if (nilai > 80) {
            return "A";
        } else if (nilai > 75) {
            return "B+";
        } else if (nilai > 69) {
            return "B";
        } else if (nilai > 65) {
            return "C+";
        } else if (nilai > 59) {
            return "C";
        } else if (nilai > 55) {
            return "D+";
        } else if (nilai > 40) {
            return "D";
        } else {
            return "E";
        }
    }

    public static void tambahSiswa(String nama) {
        siswa[banyakSiswa] = nama;
        banyakSiswa++;
    }

    public static void tambahMatpel(String matpel) {
        for (int i = 0; i < MAX_SISWA; i++) {
            for (int j = 0; j < MAX_SEMESTER; j++) {
                siswaMatpel[i][j][banyakSiswaMatpel] = matpel;
            }
        }
        banyakSiswaMatpel++;
    }

    public static int cariSiswa(String nama) {
        int indeksSiswa = banyakSiswa;
        for (int i = 0; i < banyakSiswa; i++) {
            if (siswa[i].equals(nama)) {
                indeksSiswa = i;
            }
        }
        return indeksSiswa;
    }

    public static int cariMatpel(String matpel) {
        int indeksMatpel = banyakSiswaMatpel;
        for (int i = 0; i < banyakSiswaMatpel; i++) {
            if (siswaMatpel[0][0][i].equals(matpel)) {
                indeksMatpel = i;
            }
        }
        return indeksMatpel;
    }

    /*
     * nama: nama siswa
     * semester: semester, 0 untuk ganjil, 1 untuk genap
     * matpel: nama matpel
     * nilai: nilai matpel tiap semester
     */
    public static void isiDataSiswa(String nama, int semester, String matpel, int nilai) {
        siswaMatpelNilai[cariSiswa(nama)][semester][cariMatpel(matpel)] = nilai;
    }

    public static void printSiswa() {
        System.out.print("SISWA: ");
        for (int i = 0; i < banyakSiswa; i++) {
            System.out.print(siswa[i] + " ");
        }
        System.out.println();
    }

    public static void printMatpel() {
        System.out.print("MATA PELAJARAN: ");
        for (int i = 0; i < banyakSiswaMatpel; i++) {
            System.out.print(siswaMatpel[0][0][i] + " ");
        }
        System.out.println();
    }

    public static void printRaportSiswa(String nama) {
        // satria
        // - ada 47
        // 20 mata pelajaran
        // 10 nilai
        // 17 nilai huruf
        System.out.println(">> BEGIN RAPORT <<");
        System.out.printf("%nNama: %s%n", nama);
        System.out.println("Semester: Ganjil");
        System.out.printf("%-20s|%10s|%15s%n", "Mata Pelajaran", "Nilai", "Nilai Huruf");
        System.out.println("-".repeat(47));
        for (int j = 0; j < banyakSiswaMatpel; j++) {
            System.out.printf("%-20s|%10.1f|%15s%n", siswaMatpel[cariSiswa(nama)][0][j],
                    siswaMatpelNilai[cariSiswa(nama)][0][j], konversiNilai(siswaMatpelNilai[cariSiswa(nama)][0][j]));
        }
        System.out.println();
        System.out.println("Semester: Genap");
        System.out.printf("%-20s|%10s|%15s%n", "Mata Pelajaran", "Nilai", "Nilai Huruf");
        System.out.println("-".repeat(47));
        for (int j = 0; j < banyakSiswaMatpel; j++) {
            System.out.printf("%-20s|%10.1f|%15s%n", siswaMatpel[cariSiswa(nama)][1][j],
                    siswaMatpelNilai[cariSiswa(nama)][1][j], konversiNilai(siswaMatpelNilai[cariSiswa(nama)][1][j]));
        }
        System.out.printf("%n>> END RAPORT <<%n");
    }

    public static int cariJuara(int semester) {
        double meanTerbesar = 0.0;
        double totalNilai = 0.0;
        int juara = 0;
        for (int i = 0; i < banyakSiswa; i++) {
            totalNilai = 0;
            for (int j = 0; j < banyakSiswaMatpel; j++) {
                totalNilai += siswaMatpelNilai[i][semester][j];
            }
            if ((totalNilai / banyakSiswaMatpel) > meanTerbesar) {
                meanTerbesar = (totalNilai / banyakSiswaMatpel);
                juara = i;
            }
        }
        return juara;
    }

    public static void hitungNilai(int semester) {
        String[] grade = { "A", "B+", "B", "C+", "C", "D+", "D", "E" };
        int[] gradeCount = new int[8];
        for (int i = 0; i < banyakSiswa; i++) {
            gradeCount = new int[8];
            for (int j = 0; j < banyakSiswaMatpel; j++) {
                if (konversiNilai(siswaMatpelNilai[i][semester][j]).equals("A")) {
                    gradeCount[0]++;
                } else if (konversiNilai(siswaMatpelNilai[i][semester][j]).equals("B+")) {
                    gradeCount[1]++;
                } else if (konversiNilai(siswaMatpelNilai[i][semester][j]).equals("B")) {
                    gradeCount[2]++;
                } else if (konversiNilai(siswaMatpelNilai[i][semester][j]).equals("C+")) {
                    gradeCount[3]++;
                } else if (konversiNilai(siswaMatpelNilai[i][semester][j]).equals("C")) {
                    gradeCount[4]++;
                } else if (konversiNilai(siswaMatpelNilai[i][semester][j]).equals("D+")) {
                    gradeCount[5]++;
                } else if (konversiNilai(siswaMatpelNilai[i][semester][j]).equals("D")) {
                    gradeCount[6]++;
                } else if (konversiNilai(siswaMatpelNilai[i][semester][j]).equals("E")) {
                    gradeCount[7]++;
                }
            }
            System.out.print(siswa[i] + " ");
            for (int j = 0; j < 8; j++) {
                if (gradeCount[j] != 0) {
                    System.out.printf("%s:%d ", grade[j], gradeCount[j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String matpel, semester, nama, perintah;
        int semesterAngka, nilai;

        while (true) {
            perintah = input.next();
            if (perintah.equals("SISWA")) {
                nama = input.next();
                tambahSiswa(nama);
            } else if (perintah.equals("MATPEL")) {
                matpel = input.next();
                tambahMatpel(matpel);
            } else if (perintah.equals("NILAI")) {
                nama = input.next();
                semester = input.next();
                matpel = input.next();
                nilai = input.nextInt();
                if (semester.equals("GANJIL")) {
                    semesterAngka = 0;
                } else {
                    semesterAngka = 1;
                }
                isiDataSiswa(nama, semesterAngka, matpel, nilai);
            } else if (perintah.equals("PRINT_SISWA")) {
                printSiswa();
            } else if (perintah.equals("PRINT_MATPEL")) {
                printMatpel();
            } else if (perintah.equals("PRINT_RAPORT")) {
                nama = input.next();
                printRaportSiswa(siswa[cariSiswa(nama)]);
            } else if (perintah.equals("CARI_JUARA")) {
                semester = input.next();
                if (semester.equals("GANJIL")) {
                    semesterAngka = 0;
                } else {
                    semesterAngka = 1;
                }
                System.out.printf("JUARA_1 %s %s%n", semester, siswa[cariJuara(semesterAngka)]);
            } else if (perintah.equals("HITUNG_NILAI")) {
                semester = input.next();
                if (semester.equals("GANJIL")) {
                    semesterAngka = 0;
                } else {
                    semesterAngka = 1;
                }
                hitungNilai(semesterAngka);
            } else {
                break;
            }
        }

        input.close();
    }
}
