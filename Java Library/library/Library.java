import java.util.ArrayList;
class Library {
  public ArrayList<Book> books = new ArrayList<Book>();
  public ArrayList<Member> members = new ArrayList<Member>();


  public Boolean isMemberIdExist(String id) {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        System.out.println("Id member Sudah terdaftar");
        return true;
      }
    }
    return false;
  }

  public void addMember(Member member) {
    if (!isMemberIdExist(member.id)) {
      this.members.add(member);
    }
  }

  public void addBook(Book book) {
    this.books.add(book);
  }
  public Boolean isBookIdExist(String id) {
    Boolean isExist = false;
    for (Book book : this.books) {
      if (book.id == id) {
        isExist = true;
      }
    }
    return isExist;
  }

  public void giveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);
    this.books.remove(book);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.add(book);
  }

  public void receiveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);
    this.books.add(book);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.remove(book);
  }

  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id) {
    for (Book book : this.books) {
      if (book.id.equals(id)) {
        return book;
      }
    }
    return null;
  }
}