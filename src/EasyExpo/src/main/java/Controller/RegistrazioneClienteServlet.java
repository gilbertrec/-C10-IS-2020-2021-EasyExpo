package Controller;

import Model.DAO.ClienteDAO;
import Model.POJO.Cliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> RegistrazioneClienteServlet e' una Servlet che permette al Cliente
 * di Registrarsi al sito</p>.
 *
 * @author GIUSEPPE AVINO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/RegistrazioneCliente")
public class RegistrazioneClienteServlet extends HttpServlet {
  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ClienteDAO clienteDAO = new ClienteDAO();

    if (request.getSession().getAttribute("cliente") != null) {
      throw new MyServletException("Cliente loggato.");
    }

    String password = request.getParameter("password");
    if (!(password != null && password.length() >= 8 && !password.toUpperCase().equals(password)
        && !password.toLowerCase().equals(password)
        && password.matches("[0-9 a-z A-Z.!#$%&'+\\=?^_`{|}~-]{8,512}"))) {
      throw new MyServletException("Password non valida.");
    }

    String passwordConferma = request.getParameter("passwordConferma");
    if (!password.equals(passwordConferma)) {
      throw new MyServletException("Le password non combaciano.");
    }

    String nome = request.getParameter("nome");
    if (!(nome != null && nome.matches("[A-Z a-z]{1,30}"))) {
      throw new MyServletException("Nome non valido.");
    }

    String email = request.getParameter("email");
    boolean esiste = false;
    esiste = clienteDAO.doRetrieveByEmail(email);
    if (!(email != null
        && email.matches("[a-z A-Z 0-9 ._]{8,50}@[a-z A-Z 0-9.]"
        + "{4,50}.([a-z A-Z]{2,5})") && esiste == false)) {
      throw new MyServletException("Email non valida.");
    }

    String codiceFiscale = request.getParameter("codiceFiscale");
    if (!(codiceFiscale != null && codiceFiscale.matches("[A-Z 0-9]{16}"))) {
      throw new MyServletException("CodiceFiscale non valido.");
    }

    String cognome = request.getParameter("cognome");
    if (!(cognome != null && cognome.trim().length() > 0 && cognome.matches("[A-Z a-z]{1,30}"))) {
      throw new MyServletException("Cognome non valido.");
    }
    String luogoUbicazione = request.getParameter("luogoUbicazione");
    if (!(luogoUbicazione != null && luogoUbicazione.trim().length() > 0
        && luogoUbicazione.matches("[a-z A-Z]{1,30}"))) {
      throw new MyServletException("Luogo di ubicazione non valido.");
    }
    String telefono = request.getParameter("telefono");
    if (!(telefono != null && telefono.matches("[0-9]{10}"))) {
      throw new MyServletException("Numero di telefono non valido.");
    }

    Cliente cliente = new Cliente();
    cliente.setEmail(email);
    cliente.setPassword(password);
    cliente.setCodiceFiscale(codiceFiscale);
    cliente.setNome(nome);
    cliente.setCognome(cognome);
    cliente.setTelefono(telefono);
    cliente.setLuogoUbicazione(luogoUbicazione);

    clienteDAO.createCliente(cliente);
    request.getSession().setAttribute("cliente", cliente);
    request.getSession().setAttribute("passwordConferma", passwordConferma);

    RequestDispatcher requestDispatcher =
        request.getServletContext().getRequestDispatcher("/login.jsp");
    requestDispatcher.forward(request, response);
  }
}
