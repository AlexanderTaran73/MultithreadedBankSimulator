import Transactions.*
import java.util.concurrent.ConcurrentHashMap

fun main(args: Array<String>) {

    val bank = Bank()
    bank.observers.add(Logger())

    bank.cashiers.add(Cashier(0, bank))
    bank.cashiers.add(Cashier(1, bank))
    bank.cashiers.add(Cashier(2, bank))
    bank.cashiers.add(Cashier(3, bank))

    bank.clients.add(Client(0, ConcurrentHashMap()))
    bank.clients.add(Client(1, ConcurrentHashMap()))
    bank.clients.add(Client(2, ConcurrentHashMap()))
    bank.clients.add(Client(3, ConcurrentHashMap()))

    while (true) {
        Thread.sleep(10000)
        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[0], "USD", 1000.0)))
        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[1], "USD", 1000.0)))
        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[2], "USD", 1000.0)))
        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[3], "USD", 1000.0)))

        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[0], "USD", 5000.0)))
        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[1], "USD", 500.0)))
        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[2], "USD", 1000.0)))
        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[3], "USD", 200.0)))
    }

}


