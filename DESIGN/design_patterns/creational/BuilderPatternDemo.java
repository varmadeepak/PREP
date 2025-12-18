// ===================== PRODUCT =====================
final class Desktop {

    private String cpu;
    private int ram;
    private int storage;
    private String gpu;
    private String os;

    // Package-private setters (accessible only within this file/package)
    void setCpu(String cpu) {
        this.cpu = cpu;
    }

    void setRam(int ram) {
        this.ram = ram;
    }

    void setStorage(int storage) {
        this.storage = storage;
    }

    void setGpu(String gpu) {
        this.gpu = gpu;
    }

    void setOs(String os) {
        this.os = os;
    }

    // Public getters (read-only for clients)
    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "Desktop{" +
                "cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", gpu='" + gpu + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}

// ===================== BUILDER =====================
interface DesktopBuilder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    void buildGPU();
    void buildOS();
    Desktop build();
}

// ===================== CONCRETE BUILDER (Gaming) =====================
class GamingDesktopBuilder implements DesktopBuilder {

    private final Desktop desktop = new Desktop();

    @Override
    public void buildCPU() {
        desktop.setCpu("Intel i9");
    }

    @Override
    public void buildRAM() {
        desktop.setRam(32);
    }

    @Override
    public void buildStorage() {
        desktop.setStorage(1024);
    }

    @Override
    public void buildGPU() {
        desktop.setGpu("RTX 4080");
    }

    @Override
    public void buildOS() {
        desktop.setOs("Windows 11");
    }

    @Override
    public Desktop build() {
        return desktop;
    }
}

// ===================== CONCRETE BUILDER (Productivity) =====================
class ProductivityDesktopBuilder implements DesktopBuilder {

    private final Desktop desktop = new Desktop();

    @Override
    public void buildCPU() {
        desktop.setCpu("Intel i5");
    }

    @Override
    public void buildRAM() {
        desktop.setRam(16);
    }

    @Override
    public void buildStorage() {
        desktop.setStorage(512);
    }

    @Override
    public void buildGPU() {
        desktop.setGpu("Integrated Graphics");
    }

    @Override
    public void buildOS() {
        desktop.setOs("Ubuntu Linux");
    }

    @Override
    public Desktop build() {
        return desktop;
    }
}

// ===================== DIRECTOR =====================
class DesktopDirector {

    private final DesktopBuilder builder;

    DesktopDirector(DesktopBuilder builder) {
        this.builder = builder;
    }

    Desktop construct() {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
        builder.buildGPU();
        builder.buildOS();
        return builder.build();
    }
}

// ===================== CLIENT =====================
public class BuilderPatternDemo {

    public static void main(String[] args) {

        Desktop gamingDesktop =
                new DesktopDirector(new GamingDesktopBuilder()).construct();

        Desktop productivityDesktop =
                new DesktopDirector(new ProductivityDesktopBuilder()).construct();

        System.out.println("Gaming Desktop: " + gamingDesktop);
        System.out.println("Productivity Desktop: " + productivityDesktop);

        // Read-only access
        System.out.println("Gaming CPU: " + gamingDesktop.getCpu());
    }
}