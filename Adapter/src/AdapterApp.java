public class AdapterApp {
    public static void main(String[] args) {

        //inheritance
        VectorGraphicInterface vectorGraphicInterface = new VectorAdapterFromRaster();
        vectorGraphicInterface.drawLine();
        vectorGraphicInterface.drawSquare();

        //composition

        VectorGraphicInterface vectorGraphicInterface1 = new VectorAdapterFromRaster();
        vectorGraphicInterface1.drawLine();
        vectorGraphicInterface1.drawSquare();

    }

}

interface VectorGraphicInterface {
    void drawLine();

    void drawSquare();
}

class RasterGrapics {
    void drawRasterLine() {
        System.out.println("Рисуем линию");
    }

    void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}

class VectorAdapterFromRaster extends RasterGrapics implements VectorGraphicInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicInterface {
    RasterGrapics rasterGrapics = new RasterGrapics();

    @Override
    public void drawLine() {
        rasterGrapics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGrapics.drawRasterSquare();
    }
}