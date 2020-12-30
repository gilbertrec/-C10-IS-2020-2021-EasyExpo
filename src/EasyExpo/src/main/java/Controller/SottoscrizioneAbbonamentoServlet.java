package Controller;

import Model.DAO.AbbonamentoDAO;
import Model.DAO.MetodiDiPagamentoDAO;
import Model.POJO.MetodoPagamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@WebServlet("/SottoscrizioneAbbonamentoServlet")
public class SottoscrizioneAbbonamentoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();
        MetodiDiPagamentoDAO metodoDAO = new MetodiDiPagamentoDAO();

        String nomeIntestatario = request.getParameter("nomeIntestatario");
        if (!(nomeIntestatario != null && nomeIntestatario.matches("[A-Z a-z]{1,50}"))) {
            throw new MyServletException("Nome intestatario non valido.");
        }
        String numeroCarta = request.getParameter("numeroCarta");
        if (!(numeroCarta != null && numeroCarta.matches("[0-9]{4}[0-9]{4}[0-9]{4}[0-9]{4}"))) {
            throw new MyServletException("Numero carta non valido.");
        }

        String cvv = request.getParameter("cvv");
        /*if (!(cvv != null &&  cvv.matches("[0-9] {3}"))) {
            throw new MyServletException("Cvv non valido.");
        }*/

        String dataScadenza = request.getParameter("dataScadenza");
        if (!(dataScadenza != null && dataScadenza.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))) {
            throw new MyServletException("Data scadenza non valida.");
        }

        MetodoPagamento metodo = new MetodoPagamento();
        metodo.setNumeroCarta(numeroCarta);
        metodo.setCvv(Integer.parseInt(cvv));

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        try {
            java.util.Date utilDate = format.parse(dataScadenza);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            metodo.setDataScadenza(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        metodoDAO.createMetodoPagamento(metodo);
        request.getSession().setAttribute("metodo", metodo);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
