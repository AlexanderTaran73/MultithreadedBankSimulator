import java.util.concurrent.ConcurrentHashMap

class Client(var id:Int){
    var deposits : ConcurrentHashMap<String, Deposit> = ConcurrentHashMap()

    init {
        deposits["RUB"] = Deposit("RUB", 0.0)
        deposits["USD"] = Deposit("USD", 0.0)
        deposits["EUR"] = Deposit("EUR", 0.0)
    }

    override fun toString(): String {
        return "\nClient ID: $id\n"+"" +
                "Deposits:\n"+
                "\tEUR: ${deposits["EUR"]!!.amount}\n"+
                "\tUSD: ${deposits["USD"]!!.amount}\n"+
                "\tRUB: ${deposits["RUB"]!!.amount}\n"
    }
}

class Deposit(val currency: String, var amount: Double) {
}

