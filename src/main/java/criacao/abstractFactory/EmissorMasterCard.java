package criacao.abstractFactory;

public class EmissorMasterCard implements Emissor{
    public void envia(String mensagem) {
        System.out.println("Enviando a seguinte mensagem para a MasterCard...");
        System.out.println(mensagem);
    }
}
