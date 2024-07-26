
package principal;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) throws Exception {
        System.out.println("\nControle de Fluxo");
        System.out.println("------------------");
        System.out.println("\nDigite dois parâmentros que sejam números inteiros.");
        System.out.println("O Segundo parâmetro deve ser maior que o primeiro.");

        int parametroUm = verificaParametroUm();
        int parametroDois = verificaParametroDois();

        contar(parametroUm,parametroDois);

    }

    //vefificação do primeiro parâmetro
    static int verificaParametroUm() throws Exception {
        int parametro;
        boolean valido = false;
        do{
            try {
                Scanner terminal = new Scanner(System.in);
                System.out.print("Digite o primeiro parâmetro: ");
                parametro = terminal.nextInt();
                valido = true;
                return parametro;
            }catch (Exception e){
                System.out.println("Valor inválido. O parâmetro deve ser um número inteiro.");
            }
        }while (!valido);
        return 0;
    }


    //vefificação do segundo parâmetro
    static int verificaParametroDois() throws Exception {
        int parametro;
        boolean valido = false;
        do{
            try {
                Scanner terminal = new Scanner(System.in);
                System.out.print("Digite o Segundo parâmetro: ");
                parametro = terminal.nextInt();
                valido = true;
                return parametro;
            }catch (Exception e){
                System.out.println("Valor inválido. O parâmetro deve ser um número inteiro.");
            }
        }while (!valido);
        return 0;
    }



    static void contar(int parametroUm, int parametroDois) throws Exception {
        try {
            if(parametroUm <= parametroDois){
                throw new ParametroInvalido();
            }else {
                for(int i = 1; i <= parametroUm-parametroDois; i++ ){
                    System.out.print(i + " ");
                }
            }
        }catch (ParametroInvalido e){
            System.out.println("ATENÇÃO: Primeiro parâmetro deve ser maior que o segundo, você digitou:");
            System.out.println("Primeiro parâmetro = " + parametroUm);
            System.out.println("Segundo parâmetro = " + parametroDois);
            parametroUm = verificaParametroUm();
            parametroDois = verificaParametroDois();
            contar(parametroUm,parametroDois);
        }
    }
}
