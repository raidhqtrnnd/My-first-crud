
import java.util.InputMismatchException;
import java.util.Scanner;

import java.sql.*;

public class Program extends Gaji {
	
	//static Scanner scanner;
	static Connection conn;
		
	public static void main(String[] args) {
    
		
		try (Scanner input = new Scanner (System.in)) {
      String pilihanUser;
      boolean isLanjutkan = true;
      				
      String url = "jdbc:mysql://localhost:3306/db_pegawai";
      try {
      	Class.forName("com.mysql.cj.jdbc.Driver");
      	conn = DriverManager.getConnection(url,"root","");
      	System.out.println("\nClass Driver ditemukan");
      	
      	while (isLanjutkan) {
      		System.out.println("\n-----------------------");
      		System.out.println("Database Pegawai PT.ABC");
      		System.out.println("-----------------------");
      		System.out.println("1. Lihat Data Pegawai");
      		System.out.println("2. Tambah Data Pegawai");
      		System.out.println("3. Ubah Data Pegawai");
      		System.out.println("4. Hapus Data Pegawai");
      		System.out.println("5. Cari Data Pegawai");
      		
      		System.out.print("\nPilihan anda (1/2/3/4/5): ");
      		pilihanUser = input.next();
      		
      		switch (pilihanUser) {
      		case "1":
      			lihatdata();
      			break;
      		case "2":
      			tambahdata();
      			break;
      		case "3":
      			ubahdata();
      			break;
      		case "4":
      			hapusdata();
      			break;
      		case "5":
      			caridata();
      			break;
      		default:
      			System.err.println("\nInput anda tidak ditemukan\nSilakan pilih [1-5]");
      		}
      		
      		System.out.print("\nApakah Anda ingin melanjutkan [y/n]? ");
      		pilihanUser = input.next();
      		isLanjutkan = pilihanUser.equalsIgnoreCase("y");
      	}
      	System.out.println("\nTerima Kasih\n");
      	
      }
      catch(ClassNotFoundException ex) {
      	System.err.println("\nDriver Error\n");
      	System.exit(0);
      }
      catch(SQLException e){
      	System.err.println("\nTidak berhasil koneksi\n");
      }
    }
	}
	
	private static void lihatdata() throws SQLException {
		String text1 = "\n===Daftar Seluruh Data Pegawai PT.ABC===";
		System.out.println(text1.toUpperCase());
						
		String sql ="SELECT * FROM pegawai";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()){
			System.out.print("\nID Pegawai\t\t: ");
            System.out.print(result.getInt("idPegawai"));
            System.out.print("\nNama Pegawai\t\t: ");
            System.out.print(result.getString("namaPegawai"));
            System.out.print("\nJabatan\t\t\t: ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nJumlah Hari Masuk\t: ");
            System.out.print(result.getString("jumlahHariMasuk"));
            System.out.print("\nJumlah Gaji Pokok\t: ");
            System.out.print(result.getString("gajiPokok"));
            System.out.print("\nPotongan\t\t: ");
            System.out.print(result.getString("potongan"));
            System.out.print("\nTotal Gaji\t\t: ");
            System.out.print(result.getString("totalGaji"));
            System.out.print("\n");
		}
	}
		
	private static void tambahdata() throws SQLException{
		String text2 = "\n=====Tambah Data Pegawai=====";
		System.out.println(text2.toUpperCase());
		
		
      try {
   
      Gaji gaji1 = new Gaji();
      gaji1.NoPegawai();
      String noPegawai = input.nextLine();
      gaji1.NamaPegawai();
      String namaPegawai = input.nextLine();
      gaji1.Jabatan();
      gaji1.GajiPokok();
      Integer.toString(gajiPokok);

      TerimaGaji terimaGaji1 = new TerimaGaji();
      terimaGaji1.JumlahHariMasuk();
      terimaGaji1.Potongan();
      Integer.toString(potongan);
      terimaGaji1.TotalGaji();
      Integer.toString(totalGaji);

      
      String sql = "INSERT INTO pegawai (idPegawai, namaPegawai, jabatan, jumlahHariMasuk, gajiPokok, potongan, totalGaji) VALUES ('"+noPegawai+"','"+namaPegawai+"','"+jabatannya+"','"+jumlahHariMasuk+"','"+gajiPokok+"','"+potongan+"','"+totalGaji+"')";
      			
          Statement statement = conn.createStatement();
          statement.execute(sql);
          System.out.println("\nBerhasil input data");

        } catch (SQLException e) {
            System.err.println("\nTerjadi kesalahan input data");
        } catch (InputMismatchException e) {
        	System.err.println("\nInputlah dengan angka saja");
       	}
    }

  private static void ubahdata() throws SQLException{
		String text3 = "\n===Ubah Data Pegawai===";
		System.out.println(text3.toUpperCase());
		
		try {
      try {
              lihatdata();
              System.out.print("\nMasukkan ID Pegawai yang akan di ubah atau update : ");
              Integer noPegawai = Integer.parseInt(input.nextLine());
              
              String sql = "SELECT * FROM pegawai WHERE idPegawai = " +noPegawai;
              
              Statement statement = conn.createStatement();
              ResultSet result = statement.executeQuery(sql);
              
              if(result.next()){
                  
                  System.out.print("\nNama Pegawai ["+result.getString("namaPegawai")+"]\t: ");
                  String namaPegawai = input.nextLine();

                  Gaji gaji1 = new Gaji();
                  gaji1.Jabatan();
                  gaji1.GajiPokok();
                  Integer.toString(gajiPokok);

                  TerimaGaji terimaGaji1 = new TerimaGaji();
                  terimaGaji1.JumlahHariMasuk();
                  terimaGaji1.Potongan();
                  Integer.toString(potongan);
                  terimaGaji1.TotalGaji();
                  Integer.toString(totalGaji);
                     
                  sql = "UPDATE pegawai SET namaPegawai='"+namaPegawai+"',jabatan = '"+jabatannya+"',jumlahHariMasuk= '"+jumlahHariMasuk+"',gajiPokok ='"+gajiPokok+"', potongan = '"+potongan+"', totalGaji = '"+totalGaji+"' WHERE idPegawai='"+noPegawai+"'";
                  //System.out.println(sql);

                  if(statement.executeUpdate(sql) > 0){
                      System.out.println("\nBerhasil memperbaharui data pegawai (idPegawai "+noPegawai+")");
                  }
              }
              statement.close();        
          } catch (SQLException e) {
              System.err.println("\nTerjadi kesalahan dalam mengedit data");
              System.err.println(e.getMessage());
          }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
		}
	
	private static void hapusdata() {
		String text4 = "\n===Hapus Data Pegawai===";
		System.out.println(text4.toUpperCase());
		
		try {
      try{
            lihatdata();
            System.out.print("\nKetik ID Pegawai pegawai yang akan Anda Hapus : ");
            Integer noPegawai= Integer.parseInt(input.nextLine());
            
            String sql = "DELETE FROM pegawai WHERE idPegawai = "+ noPegawai;
            Statement statement = conn.createStatement();
            //ResultSet result = statement.executeQuery(sql);
            
            if(statement.executeUpdate(sql) > 0){
                System.out.println("\nBerhasil menghapus data pegawai (ID Pegawai "+noPegawai+")");
            }
       }catch(SQLException e){
            System.out.println("\nTerjadi kesalahan dalam menghapus data barang");
            }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
		}
	
	private static void caridata () throws SQLException {
		String text5 = "\n===Cari Data Pegawai===";
		System.out.println(text5.toUpperCase());
		
		
      System.out.print("\nMasukkan nama Pegawai : ");
          
      String keyword = input.nextLine();
          Statement statement = conn.createStatement();
          String sql = "SELECT * FROM pegawai WHERE namaPegawai LIKE '%"+keyword+"%'";
          ResultSet result = statement.executeQuery(sql); 
                  
          while(result.next()){
            System.out.print("\nID Pegawai\t\t: ");
            System.out.print(result.getInt("idPegawai"));
            System.out.print("\nNama Pegawai\t\t: ");
            System.out.print(result.getString("namaPegawai"));
            System.out.print("\nJabatan\t\t\t: ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nJumlah Hari Masuk\t: ");
            System.out.print(result.getString("jumlahHariMasuk"));
            System.out.print("\nJumlah Gaji Pokok\t: ");
            System.out.print(result.getString("gajiPokok"));
            System.out.print("\nPotongan\t\t: ");
            System.out.print(result.getString("potongan"));
            System.out.print("\nTotal Gaji\t\t: ");
            System.out.print(result.getString("totalGaji"));
            System.out.print("\n");
          }
    }
	}
	

