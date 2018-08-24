package criacao.abstractFactory;

public class ReceptorMasterCard implements Receptor{

    public String recebe() {
        System.out.println("Recebendo mensagem da MasterCard...");
        return "Mensagem da MasterCard";
    }
}
