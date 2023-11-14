

class Cashier(val id : Int, val bank : Bank) : Thread(){

    override fun run() {
        while (true){
            val transaction = bank.transactionQueue.poll()
            if (transaction!=null){
                val transactionCallBack = transaction.makeTransaction()
//                println(transactionCallBack.status)
                TODO("Добавить обработку CallBack")

            }else{
                TODO("Добавить обработку отсутствия транзакции")

            }
        }
    }

    init {
        start()
    }
}