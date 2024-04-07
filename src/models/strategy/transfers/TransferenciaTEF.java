package models.strategy.transfers;

public class TransferenciaTEF implements  Transfer{
    @Override
    public void transferir(double valor){
        System.out.println("Transferência TEF realizada no valor de R$" + valor);
    }
}
