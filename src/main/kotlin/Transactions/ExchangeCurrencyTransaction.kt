package Transactions

import Client

class ExchangeCurrencyTransaction( var transactionData: ExchangeCurrencyTransactionData) : Transaction {
    override fun makeTransaction(): TransactionCallBack {

        TODO("Write makeTransacrion realisation")
        return ExchangeCurrencyTransactionCallBack("ExchangeCurrencyTransactionCallBack", "OK")
    }
}

class ExchangeCurrencyTransactionData(val client: Client,
                                      val fromCurrency: String,
                                      val toCurrency: String,
                                      val amount: Double,
                                      val ratio: Double,
                                      override val transactionType: String = "ExchangeCurrency") : TransactionData



class ExchangeCurrencyTransactionCallBack(override var message: String,
                                          override var status: String): TransactionCallBack
