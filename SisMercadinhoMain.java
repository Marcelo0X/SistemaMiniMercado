import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class SisMercadinhoMain {

    static Scanner ent = new Scanner(System.in);

    public static void main(String args[]){
	calcCompras();
    }
    public static void calcCompras(){
	List<SisMercadinho> comp = new ArrayList<>();
       
	double aux = 0;
	boolean nu = true;
	try{
	    BufferedWriter file = new BufferedWriter(new FileWriter("notaFiscal.txt"));
	    
	    while(nu){
		System.out.print("Fim ou Produto ");
		String nome = ent.nextLine();
		file.newLine();
		file.write(nome);
		if(nome.equals("fim")){
		    nu = false;
		    break;
		}
		System.out.print("Preço ");
		double preco = ent.nextDouble();
		String nomPreco = Double.toString(preco);
		file.newLine();
		file.write(nomPreco);
		System.out.print("Quantidade ");
		int qtd = ent.nextInt();
		String nomQtd = Integer.toString(qtd);
		file.newLine();
		file.write(nomQtd);
		ent.nextLine();
		SisMercadinho merc = new SisMercadinho(nome, preco, qtd);
		comp.add(merc);
		aux += merc.calcPreco();
	    }
	    System.out.println();
	    for(SisMercadinho merc: comp){
		merc.mostrarItens();
	    }
	    System.out.println();
	    System.out.printf("R$ %.2f\n", aux);
	    String nomAux = Double.toString(aux);
	    file.newLine();
	    file.write(nomAux);
	    file.newLine();
	    BufferedReader ler = new BufferedReader(new FileReader("notaFiscal.txt"));
	    String leitor;
	    while((leitor = ler.readLine()) != null){
		System.out.println(leitor);
	    }
	    ler.close();
	    file.close();
	    ent.close();
	}catch(Exception e){
	    ent.nextLine();
	    System.out.println("Erro "+e+" Tente novamente");
	    calcCompras();
	}
    }

}
