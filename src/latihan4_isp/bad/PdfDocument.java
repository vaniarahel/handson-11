package latihan4_isp.bad;

// MASALAH: PdfDocument dipaksa implement method yang tidak dibutuhkan
// PDF hanya bisa read dan print, tapi dipaksa implement edit, calculate, resize
public class PdfDocument implements Document {
    private String filename;

    public PdfDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[PDF] Reading document: " + filename);
    }

    @Override
    public void print() {
        System.out.println("[PDF] Printing document: " + filename);
    }

    @Override
    public void edit(String content) {
        // ❌ Pelanggaran ISP: Harus melempar exception karena dipaksa implement
        throw new UnsupportedOperationException("PDF documents cannot be edited");
    }

    @Override
    public void calculate(String formula) {
        // ❌ Pelanggaran ISP: Harus melempar exception karena dipaksa implement
        throw new UnsupportedOperationException("PDF documents cannot calculate");
    }

    @Override
    public void resize(int width, int height) {
        // ❌ Pelanggaran ISP: Harus melempar exception karena dipaksa implement
        throw new UnsupportedOperationException("PDF documents cannot be resized");
    }
}