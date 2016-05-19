import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		String arquivo = "J://Gdrive//IFTM//Linguagem de Programação//workspace//Trabalho2//01.txt";
		try {
			System.setIn(new FileInputStream(new File(arquivo)));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		
		
		String 
			nome[],
			telefone[];
		int 
			i,
			j,
			menor,
			tipo[],
			minutos[],
			n;
		double 
			percentual,
			comparar,
			total,
			valor[], 
			preco[][]; //Preco do pacote inicial e alem da franquia
		
		System.out.println("Quantos clientes serão informados?: ");
		n=sc.nextInt();
		
		nome=new String[n];
		telefone=new String[n];
		tipo=new int[n];
		minutos=new int[n];
		valor=new double[n];
		preco=new double[3][2];

		//input dos dados do usuario
		
		for (i=0;i<n;i++) {
			System.out.println("Informe o "+(i+1)+"º nome?: ");
			nome[i]=sc.next();
			System.out.println("Informe o telefone?: ");
			telefone[i]=sc.next();
			System.out.println("Informe o tipo da conta?: ");
			tipo[i]=sc.nextInt();
			System.out.println("Informe os minutos?: ");
			minutos[i]=sc.nextInt();
		}
		//INPUT DOS DADOS DA TABELA
		for (i=0; i<3; i++) {
			for(j=0; j<2; j++) {
				if(j==1) {
					System.out.println("Informe o preço adicional do tipo "+(i+1)+": ");
					preco[i][j]=sc.nextDouble();
				}
				else{	
					System.out.println("Informe o preço do tipo "+(i+1)+": ");
					preco[i][j]=sc.nextDouble();
				}	
			}
		}
		
		for(i=0; i<n; i++){
			if (minutos[i]>90){
				valor[i]=preco[tipo[i]][0]+(minutos[i]-90.0)*preco[tipo[i]][1];
			}
			else {
				valor[i]=preco[tipo[i]][0];
			}
		}	
		System.out.println("");
		System.out.println("NOME  TELEFONE  TIPO  MINUTOS  TOTAL");
		for (i=0; i<n; i++) {
			System.out.print(nome[i]+": ");
			System.out.print(telefone[i]+"  ");
			System.out.print(tipo[i]+"  ");
			System.out.print(minutos[i]+"  ");
			System.out.printf("%.2f",valor[i]);
			System.out.println("");
		}
		System.out.println("");
		//calcula a receita total da empresa
		total=0;
		for(i=0; i<n; i++) {
			total = total + valor[i];
		}
		System.out.printf("A receita total igual a: %.2f\n",total);
		System.out.println();
		
		//comparar valor maior
		menor=0;
		comparar=0;
		comparar=valor[0];
		for(i=0; i<n; i++) {
			if(comparar>valor[i]){
				comparar=valor[i];
				menor=i;
			}
			
		}
		System.out.println("A conta mais barata - "+nome[menor]+": "+telefone[menor]);
		total=0;
		j=0;
		for(i=0; i<n; i++) {
			if(tipo[i]==1) {
				total=total+minutos[i];
				j++;
			}
		}
		System.out.println("");
		System.out.printf("Media dos minutos dos clientes 1 é: %.1f\n",total/j);
		System.out.println("");
		
		//clientes que não consumiram minutos excedentes
		System.out.println("Clientes que não consumiram minutos excedentes: ");
		for(i=0; i<n; i++) {
			if(minutos[i]<=90){
				System.out.println(nome[i]+": "+telefone[i]);
			}
		}
		//A quantidade de clientes que consumiu acima de 120 minutos.
		j=0;
		for(i=0; i<n; i++) {
			if(minutos[i]>120){
				j++;
			}
		}
		System.out.println("");
		System.out.println("Cliente(s) consumiu(ram) mais que 120 minutos: "+j);
		j=0;
		for(i=0; i<n; i++) {
			if(tipo[i]==2){
				j++;
			}
		}
		percentual=(double)j/n*100;
		System.out.println("");
		System.out.printf("%.1f%% dos clientes possuem contas do tipo 2",percentual);
	}

}
