package by.naumenka.lesson36;

class Document {
    private String documentNumber;
    private String creationDate;
    private String nameAuthor;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    @Override
    public String toString() {
        return "Document {" +
                "documentNumber = '" + documentNumber + '\'' +
                ", creationDate = " + creationDate +
                ", nameAuthor = '" + nameAuthor + '\'' +
                '}';
    }
}