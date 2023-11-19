package Transactions

import Client

class WithdrawTransaction(var transactionData: WithdrawTransactionData): Transaction{
    override fun makeTransaction(): TransactionCallBack {
        try {
            if (transactionData.client.deposits[transactionData.currency] == null)
                return WithdrawTransactionCallBack("Incorrect data. ${transactionData.transactionType}: The client does not have such currency / ClientID ${transactionData.client.id}", "Error")
            synchronized(transactionData.client.deposits[transactionData.currency]!!) {
                val deposit = transactionData.client.deposits[transactionData.currency]!!
                if (deposit.amount - transactionData.amount < 0.0)
                    return WithdrawTransactionCallBack("Insufficient funds. ${transactionData.transactionType}: Insufficient funds for withdrawal / ClientID ${transactionData.client.id}", "Error")

                transactionData.client.deposits[transactionData.currency]!!.amount =
                    deposit.amount - transactionData.amount
            }
        }
        catch (_:Exception){
            return WithdrawTransactionCallBack("${transactionData.transactionType}: An unknown error occurred during the transaction / ClientID ${transactionData.client.id}", "Error")
        }
        return WithdrawTransactionCallBack("${transactionData.transactionType}: Withdraw was successful / ClientID ${transactionData.client.id}", "OK")
    }
}


class WithdrawTransactionData(val client: Client,
                               val currency: String,
                               val amount:Double,
                               override val transactionType: String = "WithdrawTransactionData"): TransactionData

class WithdrawTransactionCallBack(override var message: String,
                                   override var status: String) : TransactionCallBack