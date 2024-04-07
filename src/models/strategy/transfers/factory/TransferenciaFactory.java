package models.strategy.transfers.factory;

import models.strategy.transfers.Transfer;
import models.strategy.transfers.TransferenciaPIX;
import models.strategy.transfers.TransferenciaTED;
import models.strategy.transfers.TransferenciaTEF;

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
