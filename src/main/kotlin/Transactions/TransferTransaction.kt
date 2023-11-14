package Transactions

import Client

class TransferTransaction(var transactionData: TransferTransactionData) : Transaction{
    override fun makeTransaction(): TransactionCallBack {
        TODO("Not yet implemented")

        return TransferTransactionCallBack("TransferTransactionCallBack", "OK")
    }
}

class TransferTransactionData(val senderClient : Client,
                              val receiverClient : Client,
                              var currency : String,
                              var amount : Double,
                              override val transactionType: String = "TransferTransactionData") : TransactionData

class TransferTransactionCallBack(override var message: String,
                                  override var status: String) : TransactionCallBack