package Transactions

import Client

class TransferTransaction(var transactionData: TransferTransactionData) : Transaction{
    override fun makeTransaction(): TransactionCallBack {

        try {
            if (transactionData.senderClient.deposits[transactionData.currency] == null)
                return TransferTransactionCallBack("The sender does not have such currency", "Incorrect data")
            if (transactionData.receiverClient.deposits[transactionData.currency] == null)
                return TransferTransactionCallBack("The receiver does not have such currency", "Incorrect data")

            synchronized(transactionData.senderClient.deposits[transactionData.currency]!!) {
                val senderDeposit = transactionData.senderClient.deposits[transactionData.currency]!!.amount
                if (senderDeposit - transactionData.amount < 0.0)
                    return TransferTransactionCallBack("Insufficient funds for transfer", "Insufficient funds")
                transactionData.senderClient.deposits[transactionData.currency]!!.amount =
                    senderDeposit - transactionData.amount
            }

            synchronized(transactionData.receiverClient.deposits[transactionData.currency]!!) {
                transactionData.receiverClient.deposits[transactionData.currency]!!.amount =
                    transactionData.receiverClient.deposits[transactionData.currency]!!.amount + transactionData.amount
            }
        }
        catch (_:Exception){
            return TransferTransactionCallBack("An unknown error occurred during the transaction", "Error")
        }
        return TransferTransactionCallBack("The transfer was successful", "OK")
    }
}

class TransferTransactionData(val senderClient : Client,
                              val receiverClient : Client,
                              var currency : String,
                              var amount : Double,
                              override val transactionType: String = "TransferTransactionData") : TransactionData

class TransferTransactionCallBack(override var message: String,
                                  override var status: String) : TransactionCallBack