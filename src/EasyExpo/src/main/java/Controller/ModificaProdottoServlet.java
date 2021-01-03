package Controller;

import Model.DAO.ProdottoDAO;
import Model.POJO.Prodotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

@WebServlet("/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String partitaIva = request.getParameter("partitaIva");
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        Prodotto prodotto = prodottoDAO.doRetrieveByIdProdottoEPartitaIva(id, partitaIva);
        request.setAttribute("prodotto", prodotto);

        //foto
        Part filePart = request.getPart("foto");
        String fileName = filePart.getSubmittedFileName();
        String path = "/Users/lucreziarobustelli/Documents/GitHub/-C10-IS-2020-2021-EasyExpo/src/EasyExpo/src/main/webapp/" + "images";
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

        //da continuare e passare i parametri per salvare

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/modificaProdotto.jsp");
        requestDispatcher.forward(request, response);
    }
}