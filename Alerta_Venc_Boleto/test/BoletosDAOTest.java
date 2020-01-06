
import dao.BoletosDAO;
import domain.Boletos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Ignore;
import org.junit.Test;
import view.CadBoletos;

public class BoletosDAOTest {

    @Ignore
    @Test
    public void salvar() throws ParseException {
        Boletos boletos = new Boletos();
        BoletosDAO bdao = new BoletosDAO();

        Date dtVenc = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        dtVenc = formato.parse("2018-10-26");

        boletos.setBeneficiario("samsung");
        boletos.setValor(10.50);
        boletos.setStatus("não");
        boletos.setDtVenc(dtVenc);

        bdao.merge(boletos);
    }

    @Ignore
    @Test
    public void listar() {
        BoletosDAO bdao = new BoletosDAO();
        for (Boletos b : bdao.listarBoletosNaoPagos("Não")) {
            System.out.println(b);
        }
    }

    @Ignore
    @Test
    public void buscarCodigo() {
        BoletosDAO bdao = new BoletosDAO();

        Boletos boletos = bdao.buscarCodigo(1L);
        if (boletos == null) {
            System.out.println("Não achou");
        } else {
            System.out.println(boletos);
        }
    }

    @Ignore
    @Test
    public void excluir() {
        BoletosDAO bdao = new BoletosDAO();

        Boletos boletos = bdao.buscarCodigo(1L);
        bdao.excluir(boletos);
    }

    @Ignore
    @Test
    public void editar() throws ParseException {
        BoletosDAO bdao = new BoletosDAO();

        Date dtVenc = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        dtVenc = formato.parse("2018-10-31");

        Boletos boletos = bdao.buscarCodigo(2L);
        boletos.setDtVenc(dtVenc);
        boletos.setBeneficiario("Lg");
        boletos.setStatus("Sim");
        boletos.setValor(200.99);

        bdao.merge(boletos);
    }

    //@Ignore
    @Test
    public void buscarPorStatus() throws ParseException {
        BoletosDAO bdao = new BoletosDAO();
        //formata data para salvar no banco
        
        String data = "25/10/2018";
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);

        String dataSalva = ano + "-" + mes + "-" + dia;
        Date dataVenc = new Date();
        SimpleDateFormat dtFormatada = new SimpleDateFormat("yyyy-MM-dd");

        try {
            dataVenc = dtFormatada.parse(dataSalva);
        } catch (ParseException ex) {
            Logger.getLogger(CadBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Boletos bo : bdao.buscarPorData(dataVenc, "NÃO")) {
            System.out.println(bo);
        }

    }
}
