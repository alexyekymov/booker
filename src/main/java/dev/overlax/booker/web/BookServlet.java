package dev.overlax.booker.web;

import dev.overlax.booker.model.Book;
import dev.overlax.booker.repository.BookRepository;
import dev.overlax.booker.repository.Repository;
import dev.overlax.booker.util.BooksUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    private Repository repository;

    @Override
    public void init() throws ServletException {
        repository = new BookRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(req);
                repository.delete(id);
                resp.sendRedirect("books");
                break;
            case "all":
            default:
                req.setAttribute("books", BooksUtil.getTos(repository.getAll()));
                req.getRequestDispatcher("/books.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String addTime = req.getParameter("addTime");

        Book book = new Book(id.isEmpty() ? null : Integer.valueOf(id),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("pages")),
                Integer.parseInt(req.getParameter("currentPage"))
        );

        repository.save(book);
        resp.sendRedirect("books");
    }

    private int getId(HttpServletRequest req) {
        return Integer.parseInt(req.getParameter("id"));
    }
}
