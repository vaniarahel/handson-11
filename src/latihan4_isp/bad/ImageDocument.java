package latihan4_isp.bad;

// ImageDocument masalahnya paling parah
// Hanya butuh read dan resize, tapi dipaksa implement 3 method lain
public class ImageDocument implements Document {
    private String filename;

    public ImageDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[IMAGE] Reading image: " + filename);
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("[IMAGE] Resizing image: " + filename + " to " + width + "x" + height);
    }

    @Override
    public void edit(String content) {
        // Pelanggaran ISP
        throw new UnsupportedOperationException("Image documents cannot be edited with text");
    }

    @Override
    public void print() {
        // Pelanggaran ISP
        throw new UnsupportedOperationException("Image documents cannot be printed");
    }

    @Override
    public void calculate(String formula) {
        // Pelanggaran ISP
        throw new UnsupportedOperationException("Image documents cannot calculate");
    }
}