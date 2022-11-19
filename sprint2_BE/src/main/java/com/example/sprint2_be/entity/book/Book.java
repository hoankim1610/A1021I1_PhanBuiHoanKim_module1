package com.example.sprint2_be.entity.book;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String bookCode;

    private String bookName;

    private String bookImage;

    private String bookContent;

    private Double bookPrice;

    private String bookTranslator;

    private Integer bookTotalPage;

    private String bookSize;

    private LocalDate bookPublishDate;

    private Integer bookQuantity = 0;

    private Boolean bookFlag = false;

    private String bookPublisher;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_category_id")
    private Category categoryId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_author_id")
    private Author bookAuthorId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_promotion_id")
    private Promotion bookPromotionId;

    public Book() {
    }

    public Book(String bookCode, String bookName, String bookImage, String bookContent, Double bookPrice, String bookTranslator, Integer bookTotalPage, String bookSize, LocalDate bookPublishDate, Integer bookQuantity, Boolean bookFlag, String bookPublisher, Category categoryId, Author bookAuthorId, Promotion bookPromotionId) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookContent = bookContent;
        this.bookPrice = bookPrice;
        this.bookTranslator = bookTranslator;
        this.bookTotalPage = bookTotalPage;
        this.bookSize = bookSize;
        this.bookPublishDate = bookPublishDate;
        this.bookQuantity = bookQuantity;
        this.bookFlag = bookFlag;
        this.bookPublisher = bookPublisher;
        this.categoryId = categoryId;
        this.bookAuthorId = bookAuthorId;
        this.bookPromotionId = bookPromotionId;
    }

    public Book(Long bookId, String bookCode, String bookName, String bookImage, String bookContent, Double bookPrice, String bookTranslator, Integer bookTotalPage, String bookSize, LocalDate bookPublishDate, Integer bookQuantity, Boolean bookFlag, String bookPublisher, Category categoryId, Author bookAuthorId, Promotion bookPromotionId) {
        this.bookId = bookId;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookContent = bookContent;
        this.bookPrice = bookPrice;
        this.bookTranslator = bookTranslator;
        this.bookTotalPage = bookTotalPage;
        this.bookSize = bookSize;
        this.bookPublishDate = bookPublishDate;
        this.bookQuantity = bookQuantity;
        this.bookFlag = bookFlag;
        this.bookPublisher = bookPublisher;
        this.categoryId = categoryId;
        this.bookAuthorId = bookAuthorId;
        this.bookPromotionId = bookPromotionId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookTranslator() {
        return bookTranslator;
    }

    public void setBookTranslator(String bookTranslator) {
        this.bookTranslator = bookTranslator;
    }

    public Integer getBookTotalPage() {
        return bookTotalPage;
    }

    public void setBookTotalPage(Integer bookTotalPage) {
        this.bookTotalPage = bookTotalPage;
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }

    public LocalDate getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(LocalDate bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public Boolean getBookFlag() {
        return bookFlag;
    }

    public void setBookFlag(Boolean bookFlag) {
        this.bookFlag = bookFlag;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Author getBookAuthorId() {
        return bookAuthorId;
    }

    public void setBookAuthorId(Author bookAuthorId) {
        this.bookAuthorId = bookAuthorId;
    }

    public Promotion getBookPromotionId() {
        return bookPromotionId;
    }

    public void setBookPromotionId(Promotion bookPromotionId) {
        this.bookPromotionId = bookPromotionId;
    }
}
