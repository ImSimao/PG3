package i2627.trab2.grupo1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Library {
    /**
     * Classe interna que representa uma entrada no catálogo da biblioteca, contendo um livro e a quantidade disponível.
     */
    public static class CatalogEntry {
        private final Book book;
        private int quantity;

        public CatalogEntry(Book book, int quantity) {
            this.book = book;
            this.quantity = quantity;
        }

        /**
         * Método accessor para o campo book.
         * @return O livro associado a esta entrada do catálogo.
         */
        public Book getBook() {
            return book;
        }

        /**
         * Método accessor para o campo quantity.
         * @return A quantidade disponível do livro associado a esta entrada do catálogo.
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * Método mutator para o campo quantity.
         * @param quantity A nova quantidade a ser definida.
         */
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // Campo correspondente ao catálogo da biblioteca.
    // ToDo: name it catalog

    /**
     * Adiciona um livro à biblioteca. Se o livro já existir, atualiza a quantidade disponível; se não existir, cria uma entrada no catálogo.
     * @param book O livro a ser adicionado.
     * @param quantity A quantidade de livros a ser adicionado.
     * @throws LibraryException Se a quantidade de livros especificada for inferior ou igual a 0
     */
    public void addBook(Book book, int quantity) {
        // ToDo
    }

    /**
     * Adiciona múltiplos livros à biblioteca. Se algum livro já existir, atualiza a quantidade disponível; se não existir, cria uma entrada no catálogo.
     * @param books Os livros a serem adicionados.
     */
    public void addAllBooks(Book... books) {
        // ToDo
    }

    /**
     * Remove um livro da biblioteca com base no ISBN. Se a quantidade disponível for maior que 1, apenas diminui a quantidade em 1; caso contrário, remove o livro completamente.
     * @param isbn O ISBN do livro a ser removido.
     * @return O livro removido.
     * @throws LibraryException Se o livro com o ISBN especificado não for encontrado na biblioteca.
     */
    public Book removeBook(String isbn) {
        // ToDo
    }

    /**
     * Remove um livro da biblioteca com base no ISBN, independentemente da quantidade disponível.
     * @param isbn O ISBN do livro a ser removido.
     * @throws LibraryException Se o livro com o ISBN especificado não for encontrado na biblioteca.
     */
    public void deleteBook(String isbn) {
        // ToDo
    }

    /**
     * Retorna o livro com um determinado ISBN.
     * @param isbn O ISBN do livro a ser retornado.
     * @return O livro com o ISBN especificado.
     * @throws LibraryException Se o livro com o ISBN especificado não for encontrado na biblioteca.
     */
    public Book getBookByISBN(String isbn) {
        // ToDo
    }

    /**
     * Retorna a quantidade disponível de um livro com um determinado ISBN.
     * @param isbn O ISBN do livro cuja quantidade disponível será retornada.
     * @return A quantidade disponível do livro. Retorna 0 se o livro não for encontrado na biblioteca.
     */
    public int getBookQuantity(String isbn) {
        // ToDo
    }

    /**
     * Retorna a quantidade total de livros disponíveis que obedecem a um determinado filtro.
     * @param filter O filtro a ser aplicado.
     * @return A quantidade total de livros disponíveis que atendem aos critérios.
     */
    private int getBooksQuantity(Predicate<CatalogEntry> filter) {
        // ToDo
    }

    /**
     * Retorna a quantidade total de livros disponíveis com um determinado título e autor, sem distinguir maiúsculas de minúsculas.
     * @param title O título dos livros cuja quantidade será retornada.
     * @param author O autor dos livros cuja quantidade será retornada.
     * @return A quantidade total de livros disponíveis com o título e autor especificados.
     */
    public int getBooksQuantity(String title, String author) {
        // ToDo
    }

    /**
     * Retorna a quantidade total de livros disponíveis publicados num determinado ano e editados por um determinado editor, sem distinguir maiúsculas de minúsculas.
     * @param year O ano de publicação dos livros cuja quantidade será retornada.
     * @param editor O editor dos livros cuja quantidade será retornada.
     * @return A quantidade total de livros disponíveis com o ano e editor especificados.
     */
    public int getBooksQuantity(int year, String editor) {
        // ToDo
    }

    /**
     * Retorna a lista de livros que obedecem a um determinado filtro, mapeando-os para o tipo Book.
     * @param filter O filtro a ser aplicado.
     * @return A lista de livros que atendem aos critérios.
     */
    private List<Book> listBooks(Predicate<CatalogEntry> filter) {
        // ToDo
    }

    /**
     * Retorna lista de todos os livros disponíveis na biblioteca, independentemente da categoria.
     */
    public List<Book> listAllBooks() {
        // ToDo
    }

    /**
     * Retorna a lista de livros de uma determinada categoria (BookGenre).
     * @param genre A categoria de livros a ser listada.
     * @return A lista de livros da categoria especificada.
     */
    public List<Book> listBooksByGenre(BookGenre genre) {
        // ToDo
    }

    /**
     * Retorna a lista de livros cujo título contenha uma determinada palavra-chave.
     * A comparação entre palavras-chave é insensível a maiúsculas e minúsculas.
     * @param keyword A palavra-chave a ser buscada nos títulos dos livros.
     * @return A lista de livros cujo título contenha a palavra-chave especificada.
     */
    public List<Book> listBooksByTitleKeyword(String keyword) {
        // ToDo
    }

    /**
     * Retorna a lista de livros que obedecem a um determinado filtro, mapeando-os para o tipo Book e ordenando-os conforme o comparador fornecido.
     * @param filter O filtro a ser aplicado.
     * @param sorter O comparador para ordenar os elementos.
     * @return A lista de livros que atendem aos critérios.
     */
    private List<Book> listBooks(Predicate<CatalogEntry> filter, Comparator<CatalogEntry> sorter) {
        // ToDo
    }

    /**
     * Retorna a lista de livros de um determinado título e autor, ordenados por ano de publicação, do mais recente para o mais antigo.
     * A comparação entre títulos e entre autores é insensível a maiúsculas e minúsculas.
     * @param title O título dos livros a serem listados.
     * @param author O autor dos livros a serem listados.
     * @return A lista de livros com o título e autor especificados, ordenados por ano de publicação.
     */
    public List<Book> listBooksByTitleAndAuthor(String title, String author) {
        // ToDo
    }

    /**
     * Retorna a lista de livros publicados num determinado ano, ordenados por autor, e, dentro do autor, ordenados pelo título.
     * @param year O ano dos livros a serem listados.
     * @return A lista de livros do ano especificado, ordenados por autor
     */
    public List<Book> listBooksByYear(int year) {
        // ToDo
    }

    /**
     * Agrupa os livros por categoria (BookGenre).
     * @return Um mapa onde a chave é o género do livro e o valor é a lista de livros desse gênero.
     */
    public Map<BookGenre, List<Book>> groupBooksByGenre() {
        Map<BookGenre, List<Book>> groupedBooks = new HashMap<>();
        for (CatalogEntry entry: catalog.values()) {
            Book book = entry.getBook();
            groupedBooks.computeIfAbsent(book.genre(), _ -> new ArrayList<>()).add(book);
        }
        return groupedBooks;
    }

   /**
    * Agrupa os livros por autor, listando os autores em ordem alfabética (sem distinguir maiúsculas de minúsculas) e, para cada autor, 
    * lista os livros publicados por ele, ordenados por ano de publicação, do mais recente para o mais antigo.
    * @return Um mapa onde a chave é o autor do livro e o valor é a fila de prioridade de livros desse autor.
    */
   public Map<String, PriorityQueue<Book>> groupBooksByAuthor() {
       Map<String, PriorityQueue<Book>> groupedBooks = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
       for (CatalogEntry entry: catalog.values()) {
           Book book = entry.getBook();
           groupedBooks.computeIfAbsent(book.author(), _ -> new PriorityQueue<>(Comparator.comparingInt(Book::year).reversed())).add(book);
       }
       return groupedBooks;
   }
}
