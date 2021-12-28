public class TerimaGaji extends Gaji {

    public int jumlahHariAbsen;

    public int GajiPokok(int gajiPokok) {
        Gaji.gajiPokok = gajiPokok;
        return gajiPokok;
    }

    @Override
    public void JumlahHariMasuk() {
        System.out.print("Masukkan jumlah hari masuk : ");
        jumlahHariMasuk = input.nextInt();input.nextLine();
        jumlahHariAbsen = 30 - jumlahHariMasuk;
    }

     @Override
    public void Potongan() {
        potongan = (int) (((double) jumlahHariAbsen / 30) * gajiPokok);
    }

    @Override
    public void TotalGaji() {
        totalGaji = gajiPokok - potongan;
    }
}
