import java.util.Scanner;
import java.io.IOException;

class Console {
  
    public static void clear(String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
	
	
	
class ContaBancaria {
    
  static double saldo;  
  
  public static boolean validarSangria(double valor){    
    
    if(valor > saldo){
      return false;
    }
    
    return true;
  }
  
  public static void reforcoSaldo(double valor){
    saldo = saldo + valor;
  }
    
  public static void depositar() throws IOException, InterruptedException{
    
      Scanner teclado = new Scanner(System.in);   
      
      double valor;
      
      System.out.print("Qual o valor que voce deseja depositar?\n\n");
      
      valor = teclado.nextDouble();
      exibirSaldo();
	  System.out.print("\n\n");
      reforcoSaldo(valor);
	  System.out.print("\n\n");
	  exibirSaldo();
	  System.out.print("Prescione enter para voltar ao menu principal");
	  System.in.read();
      menu();      
      
  }
  
  public static void fazerSaque(double valor){
	  saldo = saldo - valor;
  }
  
  public static double sacar() throws IOException, InterruptedException{
	  
	  Scanner teclado = new Scanner(System.in);
	  
	  double valor;
	  
	  System.out.print("Isira o valor que deseja sacar\n");
	  
	  valor = teclado.nextDouble();
      
      if(validarSangria(valor) == false){

  
        System.out.print("Saldo insuficiente\n\n");
		System.out.print("Prescione enter para voltar ao menu principal");
	    System.in.read();
        menu();
      }
	  exibirSaldo();
      System.out.print("\n\n");
      fazerSaque(valor);
	  System.out.print("\n\n");
	  exibirSaldo();
	  System.out.print("Prescione enter para voltar ao menu principal");
	  System.in.read();
	  
	  menu();
        
    return saldo;
  } 
  
  public static void sair(){
	  
  }
  
  public static double exibirSaldo() throws IOException, InterruptedException{
    System.out.print("\n\n");  
    System.out.print(saldo);
	System.out.print("\n\n");
	System.out.print("Prescione enter para voltar ao menu principal");
	System.in.read();
    return saldo;
  }
  
  //public static void pressionarParaMenu() throws IOException, InterruptedException{
	
  //}
  
  
  public static void menu() throws IOException, InterruptedException{
    Scanner teclado = new Scanner(System.in);
	Console console = new Console();
	console.clear();


    int opcao;
    
    System.out.print("Menu do meu sistema\n\n");
    System.out.print("------------------------\n\n");
    System.out.print("Por favor selecione uma opcao:\n");
    System.out.print("------------------------\n\n");
    System.out.print("[1] - Depositar\n");
    System.out.print("[2] - Sacar\n");
    System.out.print("[3] - Exibir saldo\n");
    System.out.print("[4] - Sair do sistema\n");
    
    opcao = teclado.nextInt();       
    
    switch (opcao) {
      case 1:
      depositar();
      break;

      case 2:
      sacar();
      break;

      case 3:
      exibirSaldo();
      menu();
      break;

      case 4:
      System.exit(0);
      break;

    default:
      System.out.printf("Insira uma opcao válida");
      main(null);
    }
    
  }
  
	
		
	public static void main(String args[]) throws IOException, InterruptedException{
		

    saldo = 0;

    menu();    
       
    System.exit(0);
		
	}

}