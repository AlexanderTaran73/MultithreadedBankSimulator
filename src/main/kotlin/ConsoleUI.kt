import Transactions.*


class ConsoleUI(val bank : Bank) {

    fun createCashiers(){
        println("In the next line, enter the number of cashiers:\n")
        var input : Int
        while (true) {
            try {
                input = readln().toInt()
                if(input<1){
                    println("Incorrect input. Try again!\n")
                    continue
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }
        repeat(input){
            bank.cashiers.add(Cashier(it+1, bank))
        }
        println("Adding cashiers is complete.\n")

    }

    fun createClients(){
        println("In the next line, enter the number of clients:\n")
        var input : Int
        while (true) {
            try {
                input = readln().toInt()
                if(input<1){
                    println("Incorrect input. Try again!\n")
                    continue
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }
        repeat(input){
            bank.clients.add(Client(it+1))
        }
        println("Adding clients is complete. Сlient ids from one to $input.\n")
    }

    fun addTransation(){
        println(
                    "1. Put money on deposit\n"+
                    "2. Withdraw money from deposit\n"+
                    "3. Exchange currency\n"+
                    "4. Transfer funds\n"
        )
        println("In the next line, enter the number of Transation:\n")

        var input : Int
        while (true) {
            try {
                input = readln().toInt()
                when(input){
                    1 -> createToDepositTransaction()
                    2 -> createWithdrawTransaction()
                    3 -> createExchangeCurrencyTransaction()
                    4 -> createTransferTransaction()
                    else -> {
                        println("Incorrect input. Try again!\n")
                        continue
                    }
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }


    }

    fun createToDepositTransaction(){
        println("Enter user id:\n")
        var input : Int
        while (true) {
            try {
                input = readln().toInt()
                if (bank.clients.size < input || input < 1) {
                    println("No such user. Try again!\n")
                    continue
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }
        val client = bank.clients[input-1]


        println(
                    "1. EUR\n"+
                    "2. USD\n"+
                    "3. RUB\n"
        )
        println("Enter currency id:\n")

        var currency: String
        while (true) {
            try {
                input = readln().toInt()
                when(input){
                    1 -> currency = "EUR"
                    2 -> currency = "USD"
                    3 -> currency = "RUB"
                    else -> {
                        println("Incorrect input. Try again!\n")
                        continue
                    }
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }

        println("Enter amount:\n")
        var amount : Double
        while (true) {
            try {
                amount = readln().toDouble()
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }

        println("Create a transaction ...\n")
        bank.transactionQueue.add(ToDepositTransaction(ToDepositTransactionData(client, currency, amount)))
    }

    fun createWithdrawTransaction(){
        println("Enter user id:\n")
        var input : Int
        while (true) {
            try {
                input = readln().toInt()
                if (bank.clients.size < input || input < 1) {
                    println("No such user. Try again!\n")
                    continue
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }
        val client = bank.clients[input-1]


        println(
            "1. EUR\n"+
                    "2. USD\n"+
                    "3. RUB\n"
        )
        println("Enter currency id:\n")

        var currency: String
        while (true) {
            try {
                input = readln().toInt()
                when(input){
                    1 -> currency = "EUR"
                    2 -> currency = "USD"
                    3 -> currency = "RUB"
                    else -> {
                        println("Incorrect input. Try again!\n")
                        continue
                    }
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }

        println("Enter amount:\n")
        var amount : Double
        while (true) {
            try {
                amount = readln().toDouble()
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }

        println("Create a transaction ...\n")
        bank.transactionQueue.add(WithdrawTransaction(WithdrawTransactionData(client, currency, amount)))
    }

    fun createExchangeCurrencyTransaction(){
        println("Enter user id:\n")
        var input : Int
        while (true) {
            try {
                input = readln().toInt()
                if (bank.clients.size < input || input < 1) {
                    println("No such user. Try again!\n")
                    continue
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }
        val client = bank.clients[input-1]

        println(
            "1. EUR\n"+
                    "2. USD\n"+
                    "3. RUB\n"
        )
        println("Enter fromCurrency id:\n")

        var fromCurrency: String
        while (true) {
            try {
                input = readln().toInt()
                when(input){
                    1 -> fromCurrency = "EUR"
                    2 -> fromCurrency = "USD"
                    3 -> fromCurrency = "RUB"
                    else -> {
                        println("Incorrect input. Try again!\n")
                        continue
                    }
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }

        println(
            "1. EUR\n"+
                    "2. USD\n"+
                    "3. RUB\n"
        )
        println("Enter fromCurrency id:\n")

        var toCurrency: String
        while (true) {
            try {
                input = readln().toInt()
                when(input){
                    1 -> toCurrency = "EUR"
                    2 -> toCurrency = "USD"
                    3 -> toCurrency = "RUB"
                    else -> {
                        println("Incorrect input. Try again!\n")
                        continue
                    }
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }

        println("Enter amount:\n")
        var amount : Double
        while (true) {
            try {
                amount = readln().toDouble()
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }

        println("Create a transaction ...\n")

        bank.transactionQueue.add(ExchangeCurrencyTransaction(
            ExchangeCurrencyTransactionData(
            client, fromCurrency, toCurrency, amount,
            bank.exchangeRates[fromCurrency]!! / bank.exchangeRates[toCurrency]!!
        )
        ))

    }

    fun createTransferTransaction(){
        println("Enter senderClient id:\n")
        var input : Int
        while (true) {
            try {
                input = readln().toInt()
                if (bank.clients.size < input || input < 1) {
                    println("No such user. Try again!\n")
                    continue
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }
        val senderClient = bank.clients[input-1]


        println("Enter receiverClient id:\n")
        while (true) {
            try {
                input = readln().toInt()
                if (bank.clients.size < input || input < 1) {
                    println("No such user. Try again!\n")
                    continue
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }
        val receiverClient = bank.clients[input-1]


        println(
            "1. EUR\n"+
                    "2. USD\n"+
                    "3. RUB\n"
        )
        println("Enter currency id:\n")

        var currency: String
        while (true) {
            try {
                input = readln().toInt()
                when(input){
                    1 -> currency = "EUR"
                    2 -> currency = "USD"
                    3 -> currency = "RUB"
                    else -> {
                        println("Incorrect input. Try again!\n")
                        continue
                    }
                }
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }

        println("Enter amount:\n")
        var amount : Double
        while (true) {
            try {
                amount = readln().toDouble()
                break
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }

        println("Create a transaction ...\n")
        bank.transactionQueue.add(TransferTransaction(TransferTransactionData(senderClient, receiverClient, currency, amount)))

    }

    fun seeClients(){
        bank.clients.forEach(){
            println(it.toString())
        }
    }

    fun start(){
        println("We begin interaction with our bank!\n")
        createCashiers()
        createClients()



        var input : Int
        while (true) {
            try {
                println("Select an action option:\n"+
                        "1. See Clients\n" +
                        "2. Make Transation\n" +
                        "0. Go out\n")
                input = readln().toInt()
                when(input){
                    1 -> seeClients()
                    2 -> addTransation()
                    0 -> {
                        println("We are finishing our program. Best wishes!\n")
                        System.exit(0)
                    }
                    else -> {
                        println("Incorrect input. Try again!\n")
                        continue
                    }
                }
            } catch (_: Exception) {
                println("Incorrect input. Try again!\n")
            }
        }
    }
}