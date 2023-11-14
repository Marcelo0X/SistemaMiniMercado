public class SisMercadinho  {

    private String nome;
    private double preco;
    private int qtd;

    public SisMercadinho(String nome, double preco, int qtd){
	setNome(nome);
	setPreco(preco);
	setQtd(qtd);
	
    }
    public void setNome(String nome){
	this.nome = nome;
    }
    public String getNome(){
	return nome;
    }
    public void setPreco(double preco){
	this.preco = preco;
    }
    public double getPreco(){
	return preco;
    }
    public void setQtd(int qtd){
	this.qtd = qtd;
    }
    public int getQtd(){
	return qtd;
    }
    public void mostrarItens(){
	System.out.printf("%s %d R$ %.2f\n", nome, qtd, preco);
    }
    public double calcPreco(){
	return preco * qtd;
    }

}
