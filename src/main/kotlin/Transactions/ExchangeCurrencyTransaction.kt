package Transactions

import Client

class ExchangeCurrencyTransaction( var transactionData: ExchangeCurrencyTransactionData) : Transaction {
    override fun makeTransaction(): TransactionCallBack {

        TODO("Write makeTransacrion realisation")
        return ExchangeCurrencyTransactionCallBack("ExchangeCurrencyTransactionCallBack", "OK")
    }
}

class ExchangeCurrencyTransactionData(override val transactionType: String = "ExchangeCurrency",
                                      val client: Client,
                                      val fromCurrency: String,
                                      val toCurrency: String,
                                      val amount: Double) : TransactionData



class ExchangeCurrencyTransactionCallBack(override var message: String,
                                          override var status: String): TransactionCallBack
