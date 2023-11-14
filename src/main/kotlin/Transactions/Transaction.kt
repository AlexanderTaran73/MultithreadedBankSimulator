package Transactions

interface Transaction {
    fun makeTransaction() : TransactionCallBack
}

interface TransactionData{
    val transactionType : String

}

interface TransactionCallBack{
    var message : String
    var status : String
}