package Transactions

import Client

class ToDepositTransaction(var transactionData: ToDepositTransactionData): Transaction {
    override fun makeTransaction(): TransactionCallBack {
        TODO("Not yet implemented")

        return ToDepositTransactionCallBack("ToDepositTransactionCallBack", "OK")
    }
}

class ToDepositTransactionData(val client: Client,
                               val currency: String,
                               val amount:Double,
                               override val transactionType: String = "ToDepositTransactionData"): TransactionData

class ToDepositTransactionCallBack(override var message: String,
                                   override var status: String) : TransactionCallBack