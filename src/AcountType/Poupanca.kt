package AcountType

class Poupanca(titular: String, numeroConta: Int, saldoInicial: Double) : Conta(titular, numeroConta, saldoInicial) {
    private val taxaRendimento = 0.005

    override fun aplicarRendimento() {
        val rendimento = saldo * taxaRendimento
        saldo += rendimento
        historico.add("Rendimento de R$$rendimento aplicado.")
        println("Rendimento mensal aplicado com sucesso!")
    }
}