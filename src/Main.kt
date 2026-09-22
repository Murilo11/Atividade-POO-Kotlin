import AcountType.Conta
import AcountType.Corrente
import AcountType.Poupanca

fun main() {
    val conta1 = Corrente("Murilo", 1001, 1000.0)
    val conta2 = Corrente("Ana", 1002, 500.0)
    val poupanca = Poupanca("Kaua", 2001, 1000.0)

    conta1.depositar(200.0)
    conta1.sacar(150.0)
    conta2.sacar(9999.0)
    poupanca.depositar(-50.0)

    val contas: List<Conta> = listOf(conta1, conta2, poupanca)
    for (conta in contas) {
        conta.aplicarTaxa()
    }

    poupanca.aplicarRendimento()

    conta1.transferir(poupanca, 300.0)
    conta2.transferir(conta1, 99999.0)

    for (conta in contas) {
        conta.exibirDados()
        conta.exibirHistorico()
    }
}