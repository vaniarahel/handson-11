package latihan4_isp;

import latihan4_isp.good.*; // UNCOMMENT: Import semua class & interface yang sudah di-refactor
import java.util.List;
import java.util.ArrayList;


public class ISPPractice {
    public static void main(String[] args) {
        // ... (Bagian BAD PRACTICE tetap sama)

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti ISP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti ISP ===\n");

        // UNCOMMENT CODE DI BAWAH SETELAH REFACTORING SELESAI
        System.out.println("--- Testing PDF Document ---");
        PdfDocument goodPdf = new PdfDocument("Contract.pdf");
        goodPdf.read();
        goodPdf.print();
        // goodPdf.edit(); // COMPILE ERROR - method tidak ada, tidak perlu throw exception

        System.out.println("\n--- Testing Word Document ---");
        WordDocument word = new WordDocument("Report.docx");
        word.read();
        word.edit("Updated content for report");
        word.print();

        System.out.println("\n--- Testing Spreadsheet Document ---");
        SpreadsheetDocument spreadsheet = new SpreadsheetDocument("Budget.xlsx");
        spreadsheet.read();
        spreadsheet.edit("A1: 1000");
        spreadsheet.calculate("SUM(A1:A10)");
        spreadsheet.print();

        System.out.println("\n--- Testing Image Document ---");
        ImageDocument goodImage = new ImageDocument("Photo.jpg");
        goodImage.read();
        goodImage.resize(800, 600);
        // goodImage.print(); // COMPILE ERROR - method tidak ada

        System.out.println("\n--- Polymorphic Usage ---");
        latihan4_isp.good.Readable readable1 = new PdfDocument("Doc1.pdf");
        latihan4_isp.good.Readable readable2 = new ImageDocument("Image1.jpg");

        readable1.read();
        readable2.read();

        // Hanya dokumen yang printable yang bisa masuk ke list ini
        List<Printable> printableDocuments = new ArrayList<>();
        printableDocuments.add(new PdfDocument("Doc.pdf"));
        printableDocuments.add(new WordDocument("Report.docx"));
        printableDocuments.add(new SpreadsheetDocument("Data.xlsx"));
        // printableDocuments.add(new ImageDocument("Photo.jpg")); // COMPILE ERROR - bagus!

        System.out.println("\nPrinting all printable documents:");
        for (Printable doc : printableDocuments) {
            doc.print();
        }

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Focused - Setiap interface punya capability yang jelas dan spesifik");
        System.out.println("✓ Flexible - Class hanya implement capability yang benar-benar dimiliki");
        System.out.println("✓ Type-safe - Compile-time checking, bukan runtime exception");
        System.out.println("✓ Clean - Tidak ada method yang throw UnsupportedOperationException");
        System.out.println("✓ Extensible - Mudah tambah document type baru dengan capability mix & match");
    }
}
