package Transactions

import Client

class ExchangeCurrencyTransaction( var transactionData: ExchangeCurrencyTransactionData) : Transaction {
    override fun makeTransaction(): TransactionCallBack {
        try {
            if (transactionData.client.deposits[transactionData.fromCurrency] == null)
                return WithdrawTransactionCallBack("Incorrect data. ${transactionData.transactionType}: The client does not have such currency / ClientID ${transactionData.client.id}", "Error")
            if (transactionData.client.deposits[transactionData.toCurrency] == null)
                return WithdrawTransactionCallBack("Incorrect data. ${transactionData.transactionType}: The client does not have such currency / ClientID ${transactionData.client.id}", "Error")

            synchronized(transactionData.client.deposits[transactionData.fromCurrency]!!) {
                val deposit = transactionData.client.deposits[transactionData.fromCurrency]!!
                if (deposit.amount - transactionData.amount < 0.0)
                    return ExchangeCurrencyTransactionCallBack("Insufficient funds. ${transactionData.transactionType}: Insufficient funds for exchange / ClientID ${transactionData.client.id}", "Error")

                transactionData.client.deposits[transactionData.fromCurrency]!!.amount =
                    deposit.amount - transactionData.amount
            }
            synchronized(transactionData.client.deposits[transactionData.toCurrency]!!){
                val deposit = transactionData.client.deposits[transactionData.toCurrency]!!
                transactionData.client.deposits[transactionData.toCurrency]!!.amount =
                    deposit.amount + transactionData.amount * transactionData.ratio
            }
        }
        catch (_:Exception){
            return ExchangeCurrencyTransactionCallBack("${transactionData.transactionType}: An unknown error occurred during the transaction / ClientID ${transactionData.client.id}", "Error")
        }
        return ExchangeCurrencyTransactionCallBack("${transactionData.transactionType}: Exchange Currency was successful / ClientID ${transactionData.client.id}", "OK")
    }
}

class ExchangeCurrencyTransactionData(val client: Client,
                                      val fromCurrency: String,
                                      val toCurrency: String,
                                      val amount: Double,
                                      val ratio: Double, //ratio = exchangeRates[fromCurrency] / exchangeRates[toCurrency]
                                      override val transactionType: String = "ExchangeCurrency") : TransactionData



class ExchangeCurrencyTransactionCallBack(override var message: String,
                                          override var status: String): TransactionCallBack
