package Transactions

import Client

class WithdrawTransaction(var transactionData: WithdrawTransactionData): Transaction{
    override fun makeTransaction(): TransactionCallBack {
        TODO("Not yet implemented")

        return WithdrawTransactionCallBack("WithdrawTransactionCallBack", "OK")
    }
}


class WithdrawTransactionData(val client: Client,
                               val currency: String,
                               val amount:Double,
                               override val transactionType: String = "WithdrawTransactionData"): TransactionData

class WithdrawTransactionCallBack(override var message: String,
                                   override var status: String) : TransactionCallBack