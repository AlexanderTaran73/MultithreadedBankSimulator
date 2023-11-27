

class Cashier(val id : Int, val bank : Bank) : Thread(){

    override fun run() {
        while (true){
            val transaction = bank.transactionQueue.poll()
            if (transaction!=null){
                val transactionCallBack = transaction.makeTransaction()
                bank.notifyObservers("TransLog","Cashier $id: Made transaction: ${transactionCallBack.message}", transactionCallBack.status)

            }else{
//
            }
        }
    }

    init {
        start()
    }
}