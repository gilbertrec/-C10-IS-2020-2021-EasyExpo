package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

@WebServlet("/AggiungiProdottoServlet")
@MultipartConfig
public class AggiungiProdottoServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String partitaIva = request.getParameter("partitaIva");
    if (!(partitaIva != null && partitaIva.matches("[0-9]{11}"))) {
      throw new MyServletException("Partita Iva non valida.");
    }

    String titolo = request.getParameter("titolo");
    if (!(titolo != null && titolo.matches("[A-Z a-z 0-9]{1,30}"))) {
      throw new MyServletException("Titolo non valido.");
    }

    String tipo = request.getParameter("tipo");

    String prezzo = request.getParameter("prezzo");
    if (!(prezzo != null && prezzo.matches("[0-9]{1,5},[0-9]{2}"))) {
      throw new MyServletException("Prezzo non valido.");
    }

    String quantita = request.getParameter("quantita");
    if (!(quantita != null && quantita.matches("[0-9]{3}"))) {
      throw new MyServletException("Descrizione non valida.");
    }

    String descrizione = request.getParameter("descrizione");
    if (!(descrizione != null && descrizione.matches("[A-Z a-z .,/()%”]{1,1024}"))) {
      throw new MyServletException("Descrizione non valida.");
    }

    //foto
    Part filePart = request.getPart("foto");
    String fileName = filePart.getSubmittedFileName();
    String path = getServletContext().getRealPath("") + File.separator + "images";
    File uploads = new File(path);
    int lenght = fileName.length(); //Lunghezza del Nome della foto inserita

    if (lenght == 0) {
      throw new MyServletException("Immagine non inserita!");
    }

    File file = File.createTempFile(fileName.substring(0, lenght - 4),
        fileName.substring(lenght - 4, lenght), uploads);

    try (InputStream input = filePart.getInputStream()) {
      Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      e.printStackTrace();
    }

    int lastIndex =
        file.getAbsoluteFile().toString().lastIndexOf("/") + 1; //Inizio nome della foto finale
    int totalLenght = file.getAbsoluteFile().toString().length();//Lunghezza path assoluto
    String finalFileName = file.getAbsolutePath().toString()
        .substring(lastIndex, totalLenght); //Ricavo il nome effettivo della foto
    String fotoFinale = "images/" + finalFileName;


    Prodotto prodotto = new Prodotto();
    prodotto.setPartitaIva(partitaIva);
    prodotto.setTitolo(titolo);
    prodotto.setDescrizione(descrizione);
    prodotto.setTipo(Prodotto.Tipo.valueOf(tipo));
    prodotto.setQuantità(Integer.parseInt(quantita));
    prodotto.setPrezzo(Float.parseFloat(prezzo));
    prodotto.setFoto(fotoFinale);
    ProdottoDAO prodottodao = new ProdottoDAO();
    prodottodao.createProdotto(prodotto);
    List<Prodotto> prodotti = prodottodao.doRetrieveByPartitaIva(partitaIva);
    request.getSession().setAttribute("prodotti", prodotti);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
    requestDispatcher.forward(request, response);
  }
}