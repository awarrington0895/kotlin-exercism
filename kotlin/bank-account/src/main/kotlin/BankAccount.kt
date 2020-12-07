class BankAccount() {
    var balance: Long = 0
        get(): Long {
            check(!closed) { "Closed accounts do not have a balance" }
            return field
        }
    
    private var closed: Boolean = false

    @Synchronized
    fun adjustBalance(amount: Long) {
        check(!closed) { "Cannot adjust balance on closed account." }
        balance += amount
    }

    fun close() {
        closed = true
    }
}
