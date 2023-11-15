import java.util.concurrent.ConcurrentHashMap

class Client(var id:Int, var deposits : ConcurrentHashMap<String, Deposit>){

    init {
        deposits["RUB"] = Deposit("RUB", 0.0)
        deposits["USD"] = Deposit("USD", 0.0)
        deposits["EUR"] = Deposit("EUR", 0.0)
    }
}

class Deposit(val currency: String, var amount: Double) {
}

