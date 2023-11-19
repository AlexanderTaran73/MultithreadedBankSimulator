import Observers.ConsoleLogger
import Observers.FileLogger
import Transactions.ToDepositTransaction
import Transactions.ToDepositTransactionData
import Transactions.WithdrawTransaction
import Transactions.WithdrawTransactionData

fun main(args: Array<String>) {

    val bank = Bank()
    bank.observers.add(FileLogger())        //Logging in file
//    bank.observers.add(ConsoleLogger())   //Logging in console

//
//    Thread.sleep(1000)
//
//    bank.cashiers.add(Cashier(0, bank))
//    bank.cashiers.add(Cashier(1, bank))
//    bank.cashiers.add(Cashier(2, bank))
//    bank.cashiers.add(Cashier(3, bank))
//
//    bank.clients.add(Client(0))
//    bank.clients.add(Client(1))
//    bank.clients.add(Client(2))
//    bank.clients.add(Client(3))
//
//
//        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[0], "USD", 1000.0)))
//        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[1], "USD", 1000.0)))
//        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[2], "USD", 1000.0)))
//        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[3], "USD", 1000.0)))
//
//        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[0], "USD", 5000.0)))
//        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[1], "USD", 500.0)))
//        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[2], "USD", 1000.0)))
//        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[3], "USD", 200.0)))


    val consoleUI = ConsoleUI(bank)
    consoleUI.start()

}

