

class Cashier(val id : Int, val bank : Bank) : Thread(){

    override fun run() {
        while (true){
            val transaction = bank.transactionQueue.poll()
            if (transaction!=null){
                val transactionCallBack = transaction.makeTransaction()
                bank.notifyObservers("Cashier $id: Made transaction:\n   ${transactionCallBack.message}", transactionCallBack.status)

            }else{
                bank.notifyObservers("Cashier $id: There are no transactions at the moment\n", "OK")
                Thread.sleep(5000)
            }
        }
    }

    init {
        start()
    }
}