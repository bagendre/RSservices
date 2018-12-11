/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javassist.CtMethod.ConstParameter.string;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Antrian;
import util.HibernateUtil;

/**
 *
 * @author ASUS A455L
 */
public class AntrianHelper {

    public AntrianHelper() {
    }

    public List<Antrian> getAllAntrian() {
        List<Antrian> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Antrian a";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public void addNewAntrian(
            Date tanggal,
            String noRm,
            String nama,
            String alamat,
            String namaKlinik) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Antrian antrian = new Antrian(tanggal, noRm, nama, alamat, namaKlinik);
        session.saveOrUpdate(antrian);
        transaction.commit();
        session.close();
    }
    
    public List<Antrian> cariAntrian(String tanggal) {
        List<Antrian> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Antrian a where a.tanggal =:tanggal";
        Query q = session.createQuery(query);
        DateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        Date date;
        try {
            date = format.parse(tanggal);
            q.setParameter("tanggal", date);
        } catch (ParseException ex) {
            Logger.getLogger(AntrianHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        result = q.list();
        session.close();
        return result;
    }

}
