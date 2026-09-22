package AcountType

abstract class Conta(
    val titular: String,
    val numeroConta: Int,
    saldoInicial: Double = 0.0
) {
    var saldo: Double = saldoInicial
        protected set

    protected val historico = mutableListOf<String>()
    private val linha = "=".repeat(36)

    fun depositar(valor: Double) {
        if (valor <= 0) {
            println("Depósito com valor inválido!")
            return
        }
        saldo += valor
        historico.add("Depósito de R$$valor realizado.")
        println("Depósito realizado com sucesso!")
    }
    fun sacar(valor: Double) {
        if (valor <= 0) {
            println("Saque com valor inválido!")
            return
        }
        if (valor > saldo) {
            println("Saldo insuficiente para realizar esta operação!")
            return
        }
        saldo -= valor
        historico.add("Saque de R$$valor realizado.")
        println("Saque realizado com sucesso!")

    }
    open fun aplicarTaxa() {}
    open fun aplicarRendimento() {}

    // Desafio extra: o design permite criar um novo tipo de conta no futuro apenas
    // herdando de Conta e sobrescrevendo os métodos open, sem alterar as classes existentes.

    fun exibirDados() {
        println(linha)
        println("BANCO BYTEBANK EVOLUTION")
        println(linha)
        println("Cliente: $titular")
        println("Conta: $numeroConta")
        println("Saldo Atual: R$ $saldo")
    }

    fun exibirHistorico() {
        println(linha)
        println("HISTÓRICO DE OPERAÇÕES")
        println(linha)
        for (operacao in historico) {
            println(operacao)
        }
    }

    fun transferir(destino: Conta, valor: Double) {
        if (valor <= 0) {
            println("Transferência com valor inválido!")
            return
        }
        if (valor > saldo) {
            println("Saldo insuficiente para realizar esta operação!")
            return
        }
        saldo -= valor
        destino.saldo += valor
        historico.add("Transferência de R$$valor enviada.")
        destino.historico.add("Transferência de R$$valor recebida.")
        println("Transferência realizada com sucesso!")
    }




}