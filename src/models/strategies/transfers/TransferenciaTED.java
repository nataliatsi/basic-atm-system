package models.strategies.transfers;

public class TransferenciaTED implements Transfer{
    @Override
    public void transferir(double valor){
        System.out.println("Transferência TED realizada no valor de R$" + valor);
    }
}
