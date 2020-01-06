package dao;

import domain.Boletos;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class BoletosDAO {

    public void merge(Boletos boletos) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.merge(boletos);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

    //método usuaro na tela cadboletos
    public List<Boletos> listarBoletosNaoPagos(String status_pgto) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Boletos.class);
            consulta.add((Restrictions.eq("status", status_pgto)));
            List<Boletos> boletos = consulta.list();
            return boletos;
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
    }

    //método usuaro na tela consulta boletos
    public List<Boletos> listaTudo(String beneficiario) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Boletos.class);
            consulta.add(Restrictions.like("beneficiario", "%" + beneficiario + "%"));
            consulta.addOrder(Order.asc("status"));
            List<Boletos> boletos = consulta.list();
            return boletos;
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
    }

    //método usuaro na tela cadboletos
    public List<Boletos> buscarPorData(Date data_venc, String status) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Boletos.class);
            consulta.add((Restrictions.eq("dtVenc", data_venc)));
            consulta.add((Restrictions.eq("status", status)));
            List<Boletos> boletos = consulta.list();
            return boletos;
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public Boletos buscarCodigo(Long codigo) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Boletos.class);
            consulta.add(Restrictions.idEq(codigo));
            Boletos boleto = (Boletos) consulta.uniqueResult();
            return boleto;
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public void excluir(Boletos boletos) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(boletos);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }
}
