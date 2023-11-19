package Transactions

import Client

class TransferTransaction(var transactionData: TransferTransactionData) : Transaction{
    override fun makeTransaction(): TransactionCallBack {

        try {
            if (transactionData.senderClient.deposits[transactionData.currency] == null)
                return TransferTransactionCallBack("Incorrect data. ${transactionData.transactionType}: The sender does not have such currency / SenderClientID ${transactionData.senderClient.id}  ReceiverClientID ${transactionData.receiverClient.id}", "Error")
            if (transactionData.receiverClient.deposits[transactionData.currency] == null)
                return TransferTransactionCallBack("Incorrect data. ${transactionData.transactionType}: The receiver does not have such currency / SenderClientID ${transactionData.senderClient.id}  ReceiverClientID ${transactionData.receiverClient.id}", "Error")

            synchronized(transactionData.senderClient.deposits[transactionData.currency]!!) {
                val senderDeposit = transactionData.senderClient.deposits[transactionData.currency]!!.amount
                if (senderDeposit - transactionData.amount < 0.0)
                    return TransferTransactionCallBack("Insufficient funds. ${transactionData.transactionType}: Insufficient funds for transfer / SenderClientID ${transactionData.senderClient.id}  ReceiverClientID ${transactionData.receiverClient.id}", "Error")
                transactionData.senderClient.deposits[transactionData.currency]!!.amount =
                    senderDeposit - transactionData.amount
            }

            synchronized(transactionData.receiverClient.deposits[transactionData.currency]!!) {
                transactionData.receiverClient.deposits[transactionData.currency]!!.amount =
                    transactionData.receiverClient.deposits[transactionData.currency]!!.amount + transactionData.amount
            }
        }
        catch (_:Exception){
            return TransferTransactionCallBack("${transactionData.transactionType}: An unknown error occurred during the transaction / SenderClientID ${transactionData.senderClient.id}  ReceiverClientID ${transactionData.receiverClient.id}", "Error")
        }
        return TransferTransactionCallBack("${transactionData.transactionType}: The transfer was successful / SenderClientID ${transactionData.senderClient.id}  ReceiverClientID ${transactionData.receiverClient.id}", "OK")
    }
}

class TransferTransactionData(val senderClient : Client,
                              val receiverClient : Client,
                              var currency : String,
                              var amount : Double,
                              override val transactionType: String = "TransferTransactionData") : TransactionData

class TransferTransactionCallBack(override var message: String,
                                  override var status: String) : TransactionCallBack