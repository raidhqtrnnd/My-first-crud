
import java.util.Scanner;

public class Gaji implements PTABC {
    
    public static int gajiPokok;
    static int potongan;
    static int totalGaji;
    static String jabatannya;
    static int jumlahHariMasuk;
    String noPegawai;
    String namaPegawai;
    Integer noJabatan;

    static Scanner input = new Scanner(System.in);
    

@Override
public void NoPegawai() {
    System.out.print("Masukkan No Pegawai       : ");

}

@Override
public void NamaPegawai() {
    System.out.print    ("Masukkan Nama Pegawai     : " );
}


    @Override
    public void Jabatan() {
        System.out.println("\n1. Direktur Utama");
        System.out.println("2. Direktur Personalia");
        System.out.println("3. Manager");
        System.out.println("4. Karyawan");
        System.out.print("Masukkan no Jabatan : ");
        noJabatan = input.nextInt();input.nextLine();
        if (this.noJabatan == 1) {
        } else if (this.noJabatan == 2) {
        } else if (this.noJabatan == 3) {
        } else if (this.noJabatan == 4) {
        } else {
            System.out.println("Nomor yang anda masukkan salah");
        }
    }

    @Override
    public void GajiPokok() {
        if (noJabatan == 1) {
            jabatannya = "Direktur Utama";
            gajiPokok = 8000000;
        } else if (noJabatan == 2) {
            jabatannya = "Direktur Personalia";
            gajiPokok = 6000000;
        } else if (noJabatan == 3) {
            jabatannya = "Manager";
            gajiPokok = 5000000;
        } else if (noJabatan == 4) {
            jabatannya = "Karyawan";
            gajiPokok = 3000000;
        }
    }

    @Override
    public void JumlahHariMasuk() {
    }

    @Override
    public void Potongan() {
    }

    @Override
    public void TotalGaji() {
    }

    
}
