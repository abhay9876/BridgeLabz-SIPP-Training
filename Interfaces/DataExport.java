interface DataExporter {
    void export(String data);

    default void exportToJSON(String data) {
        System.out.println("Exporting to JSON: {\"data\":\"" + data + "\"}");
    }
}

class CSVExporter implements DataExporter {
    public void export(String data) {
        System.out.println("Exporting to CSV: " + data);
    }
}

class PDFExporter implements DataExporter {
    public void export(String data) {
        System.out.println("Exporting to PDF: " + data);
    }
}

public class DataExport {
    public static void main(String[] args) {
        DataExporter csv = new CSVExporter();
        DataExporter pdf = new PDFExporter();

        csv.export("Sales Report");
        csv.exportToJSON("Sales Report");

        pdf.export("Invoice Report");
        pdf.exportToJSON("Invoice Report");
    }
}
