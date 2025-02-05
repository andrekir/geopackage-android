package mil.nga.geopackage;

import junit.framework.TestCase;

import org.junit.After;

import mil.nga.geopackage.extension.coverage.CoverageDataTiff;
import mil.nga.geopackage.extension.coverage.GriddedCoverage;
import mil.nga.geopackage.extension.coverage.GriddedCoverageDao;
import mil.nga.geopackage.extension.coverage.GriddedCoverageDataType;
import mil.nga.geopackage.extension.coverage.GriddedCoverageEncodingType;
import mil.nga.geopackage.extension.coverage.GriddedTile;
import mil.nga.geopackage.extension.coverage.GriddedTileDao;
import mil.nga.geopackage.geom.GeoPackageGeometryDataUtils;
import mil.nga.geopackage.srs.SpatialReferenceSystem;
import mil.nga.geopackage.srs.SpatialReferenceSystemDao;
import mil.nga.geopackage.tiles.matrix.TileMatrix;
import mil.nga.geopackage.tiles.matrix.TileMatrixDao;
import mil.nga.geopackage.tiles.matrixset.TileMatrixSet;
import mil.nga.geopackage.tiles.user.TileDao;
import mil.nga.geopackage.tiles.user.TileRow;
import mil.nga.geopackage.tiles.user.TileTableMetadata;
import mil.nga.proj.ProjectionConstants;

/**
 * Abstract Test Case for Created TIFF Tiled Gridded Coverage Data GeoPackages
 *
 * @author osbornb
 */
public abstract class CreateCoverageDataTiffGeoPackageTestCase extends
        GeoPackageTestCase {

    public class CoverageDataTiffValues {

        public float[][] tilePixels;

        public Double[][] coverageData;

        public float[] tilePixelsFlat;

        public Double[] coverageDataFlat;

    }

    protected CoverageDataTiffValues coverageDataValues = new CoverageDataTiffValues();

    protected final boolean allowNulls;

    /**
     * Constructor
     *
     * @param allowNulls true to allow null coverage data values
     */
    public CreateCoverageDataTiffGeoPackageTestCase(boolean allowNulls) {
        this.allowNulls = allowNulls;
    }

    @Override
    protected GeoPackage getGeoPackage() throws Exception {

        GeoPackageManager manager = GeoPackageFactory.getManager(activity);

        // Delete
        manager.delete(TestConstants.CREATE_COVERAGE_DATA_DB_NAME);

        // Create
        manager.create(TestConstants.CREATE_COVERAGE_DATA_DB_NAME);

        // Open
        GeoPackage geoPackage = manager.open(TestConstants.CREATE_COVERAGE_DATA_DB_NAME);
        if (geoPackage == null) {
            throw new GeoPackageException("Failed to open database");
        }

        double minLongitude = -180.0 + (360.0 * Math.random());
        double maxLongitude = minLongitude
                + ((180.0 - minLongitude) * Math.random());
        double minLatitude = ProjectionConstants.WEB_MERCATOR_MIN_LAT_RANGE
                + ((ProjectionConstants.WEB_MERCATOR_MAX_LAT_RANGE - ProjectionConstants.WEB_MERCATOR_MIN_LAT_RANGE) * Math
                .random());
        double maxLatitude = minLatitude
                + ((ProjectionConstants.WEB_MERCATOR_MAX_LAT_RANGE - minLatitude) * Math
                .random());

        BoundingBox bbox = new BoundingBox(minLongitude,
                minLatitude, maxLongitude, maxLatitude);

        SpatialReferenceSystemDao srsDao = geoPackage
                .getSpatialReferenceSystemDao();
        SpatialReferenceSystem contentsSrs = srsDao
                .getOrCreateFromEpsg(ProjectionConstants.EPSG_WORLD_GEODETIC_SYSTEM_GEOGRAPHICAL_3D);
        SpatialReferenceSystem tileMatrixSetSrs = srsDao
                .getOrCreateFromEpsg(ProjectionConstants.EPSG_WORLD_GEODETIC_SYSTEM_GEOGRAPHICAL_3D);

        CoverageDataTiff coverageData = CoverageDataTiff
                .createTileTable(geoPackage,
                        TileTableMetadata.create(TestConstants.CREATE_COVERAGE_DATA_DB_TABLE_NAME,
                                bbox, contentsSrs.getId(), bbox, tileMatrixSetSrs.getId()));
        TileDao tileDao = coverageData.getTileDao();
        TileMatrixSet tileMatrixSet = coverageData.getTileMatrixSet();

        GriddedCoverageDao griddedCoverageDao = coverageData
                .getGriddedCoverageDao();

        GriddedCoverage griddedCoverage = new GriddedCoverage();
        griddedCoverage.setTileMatrixSet(tileMatrixSet);
        griddedCoverage.setDataType(GriddedCoverageDataType.FLOAT);
        boolean defaultPrecision = true;
        if (Math.random() < .5) {
            griddedCoverage.setPrecision(10.0 * Math.random());
            defaultPrecision = false;
        }
        griddedCoverage.setDataNull((double) Float.MAX_VALUE);
        GriddedCoverageEncodingType encoding;
        double randomEncoding = Math.random();
        if (randomEncoding < 1.0 / 3.0) {
            encoding = GriddedCoverageEncodingType.AREA;
        } else if (randomEncoding < 2.0 / 3.0) {
            encoding = GriddedCoverageEncodingType.CENTER;
        } else {
            encoding = GriddedCoverageEncodingType.CORNER;
        }
        griddedCoverage.setGridCellEncodingType(encoding);
        TestCase.assertEquals(1, griddedCoverageDao.create(griddedCoverage));

        long gcId = griddedCoverage.getId();
        griddedCoverage = griddedCoverageDao.queryForId(gcId);
        TestCase.assertNotNull(griddedCoverage);
        TestCase.assertEquals(1.0, griddedCoverage.getScale());
        TestCase.assertEquals(0.0, griddedCoverage.getOffset());

        if (defaultPrecision) {
            TestCase.assertEquals(1.0, griddedCoverage.getPrecision());
        } else {
            TestCase.assertTrue(griddedCoverage.getPrecision() >= 0.0
                    && griddedCoverage.getPrecision() <= 10.0);
        }
        TestCase.assertEquals(encoding,
                griddedCoverage.getGridCellEncodingType());
        TestCase.assertEquals(encoding.getName(),
                griddedCoverage.getGridCellEncoding());
        TestCase.assertEquals("Height", griddedCoverage.getFieldName());
        TestCase.assertEquals("Height", griddedCoverage.getQuantityDefinition());

        GriddedTile commonGriddedTile = new GriddedTile();
        commonGriddedTile.setContents(tileMatrixSet.getContents());

        // The min, max, mean, and sd are just for testing and have
        // no association on the test tile created
        boolean defaultGTMin = true;
        if (Math.random() < .5) {
            commonGriddedTile.setMin(1000.0 * Math.random());
            defaultGTMin = false;
        }
        boolean defaultGTMax = true;
        if (Math.random() < .5) {
            commonGriddedTile.setMax(1000.0
                    * Math.random()
                    + (commonGriddedTile.getMin() == null ? 0
                    : commonGriddedTile.getMin()));
            defaultGTMax = false;
        }
        boolean defaultGTMean = true;
        if (Math.random() < .5) {
            double min = commonGriddedTile.getMin() != null ? commonGriddedTile
                    .getMin() : 0;
            double max = commonGriddedTile.getMax() != null ? commonGriddedTile
                    .getMax() : 2000.0;
            commonGriddedTile.setMean(((max - min) * Math.random()) + min);
            defaultGTMean = false;
        }
        boolean defaultGTStandardDeviation = true;
        if (Math.random() < .5) {

            double min = commonGriddedTile.getMin() != null ? commonGriddedTile
                    .getMin() : 0;
            double max = commonGriddedTile.getMax() != null ? commonGriddedTile
                    .getMax() : 2000.0;
            commonGriddedTile.setStandardDeviation((max - min) * Math.random());
            defaultGTStandardDeviation = false;
        }

        GriddedTileDao griddedTileDao = coverageData.getGriddedTileDao();

        int width = 1 + (int) Math.floor((Math.random() * 4.0));
        int height = 1 + (int) Math.floor((Math.random() * 4.0));
        int tileWidth = 3 + (int) Math.floor((Math.random() * 62.0));
        int tileHeight = 3 + (int) Math.floor((Math.random() * 62.0));
        int minZoomLevel = (int) Math.floor(Math.random() * 22.0);
        int maxZoomLevel = minZoomLevel + (int) Math.floor(Math.random() * 3.0);

        // Just draw one image and re-use
        coverageData = new CoverageDataTiff(geoPackage, tileDao);
        byte[] imageBytes = drawTile(coverageData, tileWidth, tileHeight,
                griddedCoverage, commonGriddedTile);

        TileMatrixDao tileMatrixDao = geoPackage.getTileMatrixDao();

        for (int zoomLevel = minZoomLevel; zoomLevel <= maxZoomLevel; zoomLevel++) {

            TileMatrix tileMatrix = new TileMatrix();
            tileMatrix.setContents(tileMatrixSet.getContents());
            tileMatrix.setMatrixHeight(height);
            tileMatrix.setMatrixWidth(width);
            tileMatrix.setTileHeight(tileHeight);
            tileMatrix.setTileWidth(tileWidth);
            tileMatrix.setPixelXSize(
                    bbox.getLongitudeRange() / width / tileWidth);
            tileMatrix.setPixelYSize(
                    bbox.getLatitudeRange() / height / tileHeight);
            tileMatrix.setZoomLevel(zoomLevel);
            TestCase.assertEquals(1, tileMatrixDao.create(tileMatrix));

            for (int row = 0; row < height; row++) {
                for (int column = 0; column < width; column++) {

                    TileRow tileRow = tileDao.newRow();
                    tileRow.setTileColumn(column);
                    tileRow.setTileRow(row);
                    tileRow.setZoomLevel(zoomLevel);
                    tileRow.setTileData(imageBytes);

                    long tileId = tileDao.create(tileRow);
                    TestCase.assertTrue(tileId >= 0);

                    GriddedTile griddedTile = new GriddedTile();
                    griddedTile.setContents(tileMatrixSet.getContents());
                    griddedTile.setTableId(tileId);
                    griddedTile.setScale(commonGriddedTile.getScale());
                    griddedTile.setOffset(commonGriddedTile.getOffset());
                    griddedTile.setMin(commonGriddedTile.getMin());
                    griddedTile.setMax(commonGriddedTile.getMax());
                    griddedTile.setMean(commonGriddedTile.getMean());
                    griddedTile.setStandardDeviation(commonGriddedTile
                            .getStandardDeviation());

                    TestCase.assertEquals(1, griddedTileDao.create(griddedTile));
                    long gtId = griddedTile.getId();
                    TestCase.assertTrue(gtId >= 0);

                    griddedTile = griddedTileDao.queryForId(gtId);
                    TestCase.assertNotNull(griddedTile);
                    TestCase.assertEquals(1.0, griddedTile.getScale());
                    TestCase.assertEquals(0.0, griddedTile.getOffset());
                    if (defaultGTMin) {
                        TestCase.assertNull(griddedTile.getMin());
                    } else {
                        TestCase.assertTrue(griddedTile.getMin() >= 0.0
                                && griddedTile.getMin() <= 1000.0);
                    }
                    if (defaultGTMax) {
                        TestCase.assertNull(griddedTile.getMax());
                    } else {
                        TestCase.assertTrue(griddedTile.getMax() >= 0.0
                                && griddedTile.getMax() <= 2000.0);
                    }
                    if (defaultGTMean) {
                        TestCase.assertNull(griddedTile.getMean());
                    } else {
                        TestCase.assertTrue(griddedTile.getMean() >= 0.0
                                && griddedTile.getMean() <= 2000.0);
                    }
                    if (defaultGTStandardDeviation) {
                        TestCase.assertNull(griddedTile.getStandardDeviation());
                    } else {
                        TestCase.assertTrue(griddedTile.getStandardDeviation() >= 0.0
                                && griddedTile.getStandardDeviation() <= 2000.0);
                    }
                }

            }
            height *= 2;
            width *= 2;
        }

        return geoPackage;
    }

    @After
    public void tearDown() throws Exception {

        // Close
        if (geoPackage != null) {
            geoPackage.close();
        }

    }

    /**
     * Draw a coverage data tile with random values
     *
     * @param coverageData
     * @param tileWidth
     * @param tileHeight
     * @param griddedCoverage
     * @param commonGriddedTile
     * @return
     */
    private byte[] drawTile(CoverageDataTiff coverageData, int tileWidth,
                            int tileHeight, GriddedCoverage griddedCoverage,
                            GriddedTile commonGriddedTile) {

        coverageDataValues.tilePixels = new float[tileHeight][tileWidth];
        coverageDataValues.coverageData = new Double[tileHeight][tileWidth];
        coverageDataValues.tilePixelsFlat = new float[tileHeight * tileWidth];
        coverageDataValues.coverageDataFlat = new Double[tileHeight
                * tileWidth];

        GriddedTile griddedTile = new GriddedTile();
        griddedTile.setScale(commonGriddedTile.getScale());
        griddedTile.setOffset(commonGriddedTile.getOffset());
        griddedTile.setMin(commonGriddedTile.getMin());
        griddedTile.setMax(commonGriddedTile.getMax());
        griddedTile.setMean(commonGriddedTile.getMean());
        griddedTile.setStandardDeviation(commonGriddedTile
                .getStandardDeviation());

        float minValue = 8850.0f;
        float maxValue = 10994.0f;

        // Create the image and graphics
        for (int x = 0; x < tileWidth; x++) {
            for (int y = 0; y < tileHeight; y++) {
                float value;
                if (allowNulls && Math.random() < .05) {
                    value = griddedCoverage.getDataNull().floatValue();
                } else {
                    value = (float) ((Math.random() * (maxValue - minValue)) + minValue);
                }

                coverageDataValues.tilePixels[y][x] = value;
                coverageDataValues.coverageData[y][x] = coverageData
                        .getValue(griddedTile, value);

                coverageDataValues.tilePixelsFlat[(y * tileWidth) + x] = coverageDataValues.tilePixels[y][x];
                coverageDataValues.coverageDataFlat[(y * tileWidth) + x] = coverageDataValues.coverageData[y][x];
            }
        }

        byte[] imageData = coverageData
                .drawTileData(coverageDataValues.tilePixels);

        // GeoPackageGeometryDataUtils.compareByteArrays(imageData, coverageData
        // .drawTileData(griddedTile, coverageDataValues.coverageData));
        GeoPackageGeometryDataUtils.compareByteArrays(imageData, coverageData
                .drawTileData(coverageDataValues.tilePixelsFlat, tileWidth,
                        tileHeight));
        // GeoPackageGeometryDataUtils.compareByteArrays(imageData, coverageData
        // .drawTileData(griddedTile, coverageDataValues.coverageDataFlat,
        // tileWidth, tileHeight));

        return imageData;
    }

}
