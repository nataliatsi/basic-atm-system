package models.strategies.transfers;

public class TransferenciaPIX implements Transfer{

    @Override
    public void transferir(double valor){
        System.out.println("Transferência PIX realizada no valor de R$" + valor);
    }
}
