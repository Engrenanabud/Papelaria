import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Papelaria {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int[] idCode = {1, 2, 3, 4, 5};
        String[] produtos = {"lapis  ", "papel  ", "caneta", "tesoura", "cola  "};
        int[] qtdProduto = {10, 10, 10, 10, 10};
        double[] valorProduto = {1.5, 4.5, 1, 3, 2.5};
        List<Integer> idCarrinho = new ArrayList<>();
        List<Integer> qtdCompras = new ArrayList<>();

        while (true) {

            System.out.println("==========================================");
            System.out.println("==============Papelaria!==================");
            System.out.println("==========================================");
            System.out.println("Código \t Produto \t Quantidade \t Preço");
            for (int i = 0; i < idCode.length; i++) {

                System.out.println(" " + idCode[i] + "\t\t" + "  " + produtos[i] + "\t\t" + qtdProduto[i] + "\t\t\t" + " " + valorProduto[i]);

            }

            System.out.println("==========================================");
            System.out.println("Faça suas compras! (NOVAS PROMOÇÕES): ");
            System.out.println("Digite o código do produto que deseja comprar: ");
            int codigoDesejado = entrada.nextInt();
            int posicaoDoProduto = codigoDesejado - 1;


            System.out.println("O produto desejado é: " + produtos[posicaoDoProduto]);

            System.out.println("Digite a quantidade que deseja comprar: ");
            int quantidade = entrada.nextInt();

            if ((quantidade >= 1) && (quantidade <= qtdProduto[posicaoDoProduto])) {
                idCarrinho.add(posicaoDoProduto);
                qtdCompras.add(quantidade);
                qtdProduto[posicaoDoProduto] = qtdProduto[posicaoDoProduto] - quantidade;
            } else {
                System.out.println("Quantidade Inválida!");
            }

            System.out.print("Deseja continuar comprando  [S/N] ?");
            entrada.nextLine();
            String opcao = entrada.nextLine();
            if (opcao.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.print("Código Inválido");

            }


        }

        System.out.println("============================================================");
        System.out.println("================== ITENS NO CARRINHO =======================");
        System.out.println("============================================================");
        System.out.println("PRODUTO \t QUANTIDADE \t PREÇO UNI. \t\t VALOR TOTAL");
        double valorTotalcompra = 0;
        for (int i = 0; i < idCarrinho.size(); i++) {
            double valorTotalitem = qtdCompras.get(i) * valorProduto[idCarrinho.get(i)];
            System.out.println(" " + produtos[idCarrinho.get(i)] + " \t\t " + qtdCompras.get(i) + " \t\t\t\t" + valorProduto[idCarrinho.get(i)] + "\t\t\t\t\t" + valorTotalitem);
            valorTotalcompra += valorTotalitem;
        }

        double valorTributacao =  (valorTotalcompra * 0.09);

        valorTotalcompra += (valorTotalcompra * 0.09);

        double valorTotalComDesconto = 0;
        double valorDoDesconto = 0;
        boolean tipoPagamento = true;


        while (tipoPagamento) {
            System.out.println("============================================================");
            System.out.println("Imposto total = 9% ");
            System.out.println("Selecionar forma de Pagamento:  ");
            System.out.println("[1] À vista (dinheiro, pix ou débito) 20% de desconto ");
            System.out.println("[2] À vista no crédito tem 10% de desconto");
            System.out.println("[3] Parcelado em até 3x sem desconto");

            int variavel = entrada.nextInt();


            switch (variavel) {

                case 1:
                    valorDoDesconto = valorTotalcompra * 0.20;
                    valorTotalComDesconto =  valorTotalcompra - (valorTotalcompra * 0.20);
                    tipoPagamento = false;

                    break;
                case 2:

                    valorDoDesconto = valorTotalcompra * 0.10;
                    valorTotalComDesconto = valorTotalcompra - (valorTotalcompra * 0.10) ;
                    tipoPagamento = false;
                    break;
                case 3:
                    valorTotalComDesconto = valorTotalcompra / 3;
                    System.out.println("Sua compra terá um valor de 3 parcelas de: " + valorTotalcompra);
                    tipoPagamento = false;
                    break;

                default:
                    System.out.println("Nenhuma opção válida");
                    break;
            }

        }

        DecimalFormat formato = new DecimalFormat("#.##");
        String valorTotalcompraFormatado = formato.format(valorTotalcompra);
        String valorTotalComDescontoFormatado = formato.format(valorTotalComDesconto);
        String valorTributacaoFormatado = formato.format(valorTributacao);
        String valorDoDescontoFormatado = formato.format(valorDoDesconto);

        System.out.println("============================================================");
        System.out.println("=======================NOTA FISCAL =========================");
        System.out.println("============================================================");
        System.out.println("PRODUTO \t QUANTIDADE \t PREÇO UNI. \t\t VALOR TOTAL");

        for (int i = 0; i < idCarrinho.size(); i++) {
            double valorTotalitem = qtdCompras.get(i) * valorProduto[idCarrinho.get(i)];
            System.out.println(" " + produtos[idCarrinho.get(i)] + " \t\t " + qtdCompras.get(i) + " \t\t\t\t" + valorProduto[i] + "\t\t\t\t\t" + valorTotalitem);

        }


        System.out.println("------------------------------------------------------------");
        System.out.println("Imposto total:                                       9% ");
        System.out.println("Valor tributário:  \t\t\t\t\t\t\t\t\t" + valorTributacaoFormatado);
        System.out.println("Valor Total da Compra: \t\t\t\t\t\t\t\t" + valorTotalcompraFormatado );
        System.out.println("Desconto na compra: \t\t\t\t\t\t\t\t" + valorDoDescontoFormatado);
        System.out.println("Valor total a ser pago: \t\t\t\t\t\t\t" + valorTotalComDescontoFormatado );
    }
}