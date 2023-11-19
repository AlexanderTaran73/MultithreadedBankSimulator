package Transactions

import Client

class ToDepositTransaction(var transactionData: ToDepositTransactionData): Transaction {
    override fun makeTransaction(): TransactionCallBack {
        try {
            if (transactionData.client.deposits[transactionData.currency] == null)
                return ToDepositTransactionCallBack("${transactionData.transactionType}: The client does not have such currency / ClientID ${transactionData.client.id}", "Incorrect data")
            synchronized(transactionData.client.deposits[transactionData.currency]!!) {
                val deposit = transactionData.client.deposits[transactionData.currency]!!
                transactionData.client.deposits[transactionData.currency]!!.amount =
                    deposit.amount + transactionData.amount
            }
        }
        catch (_:Exception){
            return ToDepositTransactionCallBack("${transactionData.transactionType}: An unknown error occurred during the transaction / ClientID ${transactionData.client.id}", "Error")
        }
        return ToDepositTransactionCallBack("${transactionData.transactionType}: To deposit was successful / ClientID ${transactionData.client.id}", "OK")
    }
}

class ToDepositTransactionData(val client: Client,
                               val currency: String,
                               val amount:Double,
                               override val transactionType: String = "ToDepositTransactionData"): TransactionData

class ToDepositTransactionCallBack(override var message: String,
                                   override var status: String) : TransactionCallBack