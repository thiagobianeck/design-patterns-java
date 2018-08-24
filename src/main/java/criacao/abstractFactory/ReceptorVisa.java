package criacao.abstractFactory;

public class ReceptorVisa implements Receptor{

    public String recebe() {
        System.out.println("Recebendo mensagem da Visa...");
        return "Mensagem da Visa";
    }
}
