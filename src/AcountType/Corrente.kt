package AcountType

class Corrente(titular: String, numeroConta: Int, saldoInicial: Double) : Conta(titular, numeroConta, saldoInicial) {
    private val taxaMensal = 30.0

    override fun aplicarTaxa() {
        saldo -= taxaMensal
        historico.add("Taxa mensal de R$$taxaMensal aplicada.")
        println("Aplicando taxa mensal...")
        println("Novo saldo: R$$saldo")
    }
}