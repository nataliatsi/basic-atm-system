package models.strategies.transfers.factory;

import models.strategies.transfers.Transfer;
import models.strategies.transfers.TransferenciaPIX;
import models.strategies.transfers.TransferenciaTED;
import models.strategies.transfers.TransferenciaTEF;

public class TransferenciaFactory {
    public static Transfer criarTransferencia(int tipo) {
        return switch (tipo) {
            case 1 -> new TransferenciaPIX();
            case 2 -> new TransferenciaTED();
            case 3 -> new TransferenciaTEF();
            default -> throw new IllegalArgumentException("Tipo de transferência inválido.");
        };
    }
}
