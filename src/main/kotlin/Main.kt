
import Observers.FileLogger


fun main(args: Array<String>) {


    val bank = Bank()


    bank.observers.add(FileLogger())        //Logging in file
//    bank.observers.add(ConsoleLogger())   //Logging in console



//    Test data

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
//    var transaction1 = WithdrawTransaction(
//        WithdrawTransactionData(
//            client = bank.clients[0],
//            currency = "USD",
//            amount = 1000.0))
//
//    var transaction2 = ToDepositTransaction(
//        ToDepositTransactionData(
//            client = bank.clients[0],
//            currency = "USD",
//            amount = 5000.0))
//
//    var transaction3 = ExchangeCurrencyTransaction(
//        ExchangeCurrencyTransactionData(
//            client = bank.clients[0],
//            fromCurrency = "USD",
//            toCurrency = "EUR",
//            ratio = bank.exchangeRates["USD"]!! / bank.exchangeRates["EUR"]!!,
//            amount = 100.0))
//
//    var transaction4 = TransferTransaction(
//        TransferTransactionData(
//            senderClient = bank.clients[0],
//            receiverClient = bank.clients[1],
//            currency = "USD", amount = 1000.0))
//
//        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[0], "USD", 1000.0)))
//        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[1], "USD", 1000.0)))
//        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[2], "USD", 1000.0)))
//        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(bank.clients[3], "USD", 1000.0)))
//
//        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[0], "USD", 5000.0)))
//        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[1], "USD", 50000.0)))
//        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[2], "USD", 1000.0)))
//        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(bank.clients[3], "USD", 200.0)))
//
//        bank.transactionQueue.add(transaction1)
//        bank.transactionQueue.add(transaction2)
//        bank.transactionQueue.add(transaction3)
//        bank.transactionQueue.add(transaction4)



//    ConsoleUI
    val consoleUI = ConsoleUI(bank)
    consoleUI.start()

}

