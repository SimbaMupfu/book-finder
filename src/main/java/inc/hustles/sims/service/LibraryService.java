package inc.hustles.sims.service;

import inc.hustles.sims.model.Book;
import inc.hustles.sims.model.BorrowingRecord;
import inc.hustles.sims.model.Member;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<BorrowingRecord> borrowingRecords = new ArrayList<>();

    public List<Book> getAllBooks(){
        return books;
    }

    public Optional<Book> getBookById(Long id){
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void updateBook(Book updatedBook){
        for(int i = 0; i < books.size(); i++){
            Book book = books.get(i);
            if(book.getId().equals(updatedBook.getId())){
                books.set(i, updatedBook);
                break;
            }
        }
    }

    public void deleteBook(Long id){
        books.removeIf(book -> book.getId().equals(id));
    }

    public List<Member> getAllMembers(){
        return members;
    }

    public Optional<Member> getMemberById(Long id){
        return members.stream()
                .filter(member -> member.getId().equals(id))
                .findFirst();
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void updateMember(Member updatedMember){
        for(int i = 0; i < members.size(); i++){
            Member member = members.get(i);
            if(member.getId().equals(updatedMember.getId())){
                members.set(i, updatedMember);
                break;
            }
        }
    }

    public void deleteMember(Long id){
        members.removeIf(member -> member.getId().equals(id));
    }

    public List<BorrowingRecord> getAllBorrowingRecords(){
        return borrowingRecords;
    }

    public void borrowBook(BorrowingRecord borrowingRecord){
        borrowingRecord.setBorrowDate(LocalDate.now());
        borrowingRecord.setDueDate(LocalDate.now().plusDays(14));
        borrowingRecords.add(borrowingRecord);

        Book book = borrowingRecord.getBook();
        book.setAvailableCopies(book.getAvailableCopies() - 1);
    }

    public void returnBook(Long recordId, LocalDate returnDate){
        for(int i = 0; i < borrowingRecords.size(); i++){
            for(BorrowingRecord borrowingRecord : borrowingRecords){
                if(borrowingRecord.getId().equals(recordId)){
                    borrowingRecord.setReturnDate(returnDate);

                    Book book = borrowingRecord.getBook();
                    book.setAvailableCopies(book.getAvailableCopies() + 1);
                    break;
                }
            }
        }
    }
}
