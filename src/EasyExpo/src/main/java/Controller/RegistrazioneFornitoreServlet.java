package Controller;

import Controller.MyServletException;
import Model.POJO.Fornitore;
import Model.DAO.FornitoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistrazioneFornitore")
public class RegistrazioneFornitoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FornitoreDAO fornitoreDAO = new FornitoreDAO();
        if (request.getSession().getAttribute("fornitore") != null) {
            throw new MyServletException("Fornitore loggato.");
        }

        String password = request.getParameter("password");
        if (!(password != null && password.length() >= 8 && !password.toUpperCase().equals(password)
                && !password.toLowerCase().equals(password) && password.matches("[0-9 a-z A-Z.!#$%&'+\\=?^_`{|}~-]{8,512}"))) {
            throw new MyServletException("Password non valida.");
        }

        String passwordConferma = request.getParameter("passwordConferma");
        if (!password.equals(passwordConferma)) {
            throw new MyServletException("Le password non combaciano");
        }

        String nome = request.getParameter("nome");
        if (!(nome != null && nome.matches("[A-Z a-z]{1,30}"))) {
            throw new MyServletException("Nome non valido.");
        }

        String email = request.getParameter("email");
        if (!(email != null && email.matches("[a-z A-Z 0-9 ._]{8,50}@[a-z A-Z 0-9.]{4,50}.([a-z A-Z]{2,5})"))) {
            throw new MyServletException("Email non valida.");
        }

        String partitaIVA = request.getParameter("partitaIVA");
        if(!(partitaIVA != null && partitaIVA.matches("[A-Z 0-9]{16}"))){
            throw new MyServletException("CodiceFiscale non valido.");
        }

        String cognome = request.getParameter("cognome");
        if (!(cognome != null && cognome.trim().length() > 0 && cognome.matches("[A-Z a-z]{1,30}"))) {
            throw new MyServletException("Cognome non valido.");
        }
        String luogoUbicazione = request.getParameter("luogoUbicazione");
        if (!(luogoUbicazione != null && luogoUbicazione.trim().length() > 0 && luogoUbicazione.matches("[a-z A-Z]{1,30}"))) {
            throw new MyServletException("Luogo di ubicazione non valido.");
        }
        String telefono = request.getParameter("telefono");
        if(!(telefono != null && telefono.matches("[0-9]{10}"))){
            throw new MyServletException("Numero di telefono non valido.");
        }
        String ragioneSociale = request.getParameter("ragioneSociale");
        if(!(ragioneSociale != null && ragioneSociale.matches("[0-9]{10}"))){
            throw new MyServletException("Ragione sociale non valida.");
        }


        Fornitore fornitore = new Fornitore();
        fornitore.setEmail(email);
        fornitore.setPassword(password);
        fornitore.setPartitaIva(partitaIVA);
        fornitore.setNome(nome);
        fornitore.setCognome(cognome);
        fornitore.setTelefono(telefono);
        fornitore.setLuogoUbicazione(luogoUbicazione);
        fornitore.setRagioneSociale(ragioneSociale);

        fornitoreDAO.createFornitore(fornitore);
        request.getSession().setAttribute("fornitore", fornitore);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/registrazionesuccesso.jsp");
        requestDispatcher.forward(request, response);
    }
}
