package Transactions

import Client

class TransferTransaction : Transaction{
    override fun makeTransaction(): TransactionCallBack {
        TODO("Not yet implemented")
    }
}

class TransferTransactionData(override val transactionType: String = "TransferTransactionData",
                              val senderClient : Client,
                              val receiverClient : Client,
                              var currency : String,
                              var amount : Double) : TransactionData

class TransferTransactionCallBack(override var message: String, override var status: String) : TransactionCallBack