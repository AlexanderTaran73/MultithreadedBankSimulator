class Client(var id:Int, deposits : Deposits)

class Deposits {
    var deposits: HashMap<String, Double> = hashMapOf(
        "RUB" to 0.0,
        "USD" to 0.0,
        "EUR" to 0.0)
}

