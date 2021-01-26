package Controller.Fornitore;

import Controller.MyServletException;
import Model.DAO.ProdottoDAO;
import Model.POJO.Prodotto;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
    String titolo = request.getParameter("titolo");
    if (!(titolo != null && titolo.matches("[A-Z a-z 0-9]{1,30}"))) {
      throw new MyServletException("Titolo non valido.");
    }

    String tipo = request.getParameter("tipo");

    String prezzo = request.getParameter("prezzo");
    if (!(prezzo != null && prezzo.matches("[0-9]{1,5}.[0-9]{2}"))) {
      throw new MyServletException("Prezzo non valido.");
    }

    String quantita = request.getParameter("quantita");
    if (!(quantita != null && quantita.matches("[0-9]{1,3}"))) {
      throw new MyServletException("Quantità non valida.");
    }

    String descrizione = request.getParameter("descrizione");
    if (!(descrizione != null && descrizione.matches("[A-Z a-z .,/()%”]{1,1024}"))) {
      throw new MyServletException("Descrizione non valida.");
    }

    //foto
    Part filePart = request.getPart("foto");
    String fileName = filePart.getSubmittedFileName();
    String path =
        "/Users/lucreziarobustelli/Documents/GitHub/-C10-IS-2020-2021-EasyExpo"
            + "/src/EasyExpo/src/main/webapp/"
            + "images";
    File uploads = new File(path);
    int lenght = fileName.length(); //Lunghezza del Nome della foto inserita

    String fotoFinale;

    if (lenght == 0) {
      fotoFinale = "";
    } else {
      File file = File.createTempFile(fileName.substring(0, lenght - 4),
          fileName.substring(lenght - 4, lenght), uploads);

      try (InputStream input = filePart.getInputStream()) {
        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
      } catch (Exception e) {
        e.printStackTrace();
      }

      int lastIndex =
          file.getAbsoluteFile().toString().lastIndexOf("/") + 1; //Inizio nome della foto finale
      int totalLenght = file.getAbsoluteFile().toString().length(); //Lunghezza path assoluto
      String finalFileName = file.getAbsolutePath().toString()
          .substring(lastIndex, totalLenght); //Ricavo il nome effettivo della foto
      fotoFinale = "images/" + finalFileName;
    }




    Prodotto prodotto = new Prodotto();
    prodotto.setPartitaIva(partitaIva);
    prodotto.setTitolo(titolo);
    prodotto.setDescrizione(descrizione);
    prodotto.setTipo(Prodotto.Tipo.valueOf(tipo));
    prodotto.setQuantità(Integer.parseInt(quantita));
    prodotto.setPrezzo(Float.parseFloat(prezzo));
    prodotto.setImmagine(fotoFinale);
    ProdottoDAO prodottodao = new ProdottoDAO();
    prodottodao.createProdotto(prodotto);
    List<Prodotto> prodotti = prodottodao.doRetrieveByPartitaIva(partitaIva);
    request.getSession().setAttribute("prodotti", prodotti);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
    requestDispatcher.forward(request, response);
  }
}