import java.util.concurrent.ConcurrentHashMap

class Client(var id:Int, var deposits : Deposits)

class Deposits {
    var deposits = ConcurrentHashMap<String, Double>()

    init {
        deposits["RUB"] = 0.0
        deposits["USD"] = 0.0
        deposits["EUR"] = 0.0
    }
}

