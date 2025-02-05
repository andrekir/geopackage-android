# Change Log
All notable changes to this project will be documented in this file.
Adheres to [Semantic Versioning](http://semver.org/).

---

## 6.7.2 (TBD)

* TBD

## [6.7.1](https://github.com/ngageoint/geopackage-android/releases/tag/6.7.1) (01-24-2023)

* geopackage-core version 6.6.2

## [6.7.0](https://github.com/ngageoint/geopackage-android/releases/tag/6.7.0) (12-07-2022)

* geopackage-core version 6.6.1
* SQLite Android Bindings version 3400000
* DGIWG (Defence Geospatial Information Working Group) GeoPackage Profile support

## [6.6.0](https://github.com/ngageoint/geopackage-android/releases/tag/6.6.0) (09-26-2022)

* min SDK version updated to 23
* Removed appcompat dependency

## [6.5.0](https://github.com/ngageoint/geopackage-android/releases/tag/6.5.0) (09-23-2022)

* geopackage-core version 6.5.0
* SQLite Android Bindings version 3390300
* appcompat version 1.5.1
* Allow user row integer value truncation to byte and short

## [6.4.0](https://github.com/ngageoint/geopackage-android/releases/tag/6.4.0) (07-11-2022)

* compile and target SDK version 33
* geopackage-core version 6.4.0
* SQLite Android Bindings version 3390000
* appcompat version 1.4.2

## [6.3.1](https://github.com/ngageoint/geopackage-android/releases/tag/6.3.1) (05-06-2022)

* geopackage-core version 6.3.1
* SQLite Android Bindings version 3380400
* FeatureRowData id, geometry type, and envelope support

## [6.3.0](https://github.com/ngageoint/geopackage-android/releases/tag/6.3.0) (04-19-2022)

* geopackage-core version 6.3.0
* SQLite Android Bindings version 3380200
* OGC Related Tables Extension additional mappings methods
* NGA Feature Style Extension additional style and icon row methods
* Feature Style expanded pixel bounds
* Deprecated WrapperConnection classes
* gradle plugin updated to 7.1.3

## [6.2.1](https://github.com/ngageoint/geopackage-android/releases/tag/6.2.1) (03-11-2022)

* compile SDK version 32
* geopackage-core version 6.2.1
* Iterable User Cursor ids
* GeoPackage metadata Geometry Index query for chunk fixes
* Manual feature rows query for chunk fix
* GeoPackage Geometry Index extension feature rows query for chunk fixes
* Paginated query fix for android binding RTree queries

## [6.2.0](https://github.com/ngageoint/geopackage-android/releases/tag/6.2.0) (02-04-2022)

* geopackage-core version 6.2.0
* ormlite-android version 6.1
* tiff version 3.0.0
* appcompat version 1.4.1
* SQLite Android Bindings version 3370200
* Removed INTERNET Android Manifest permission
* TileGenerator individual zoom level specifications
* TileCreator dynamic separated tile width and height determination adjustment
* Iterable row results
* Improved pagination query support

## [6.1.3](https://github.com/ngageoint/geopackage-android/releases/tag/6.1.3) (12-17-2021)

* UrlTileGenerator HTTP Method and Header field values support
* TileCreator improved tile sizes when tile width and/or height are not specified
* gradle plugin updated to 7.0.4

## [6.1.2](https://github.com/ngageoint/geopackage-android/releases/tag/6.1.2) (11-22-2021)

* appcompat version 1.4.0
* Additional large blob read attempt, fix for certain phones

## [6.1.1](https://github.com/ngageoint/geopackage-android/releases/tag/6.1.1) (11-11-2021)

* Java 11
* geopackage-core version 6.1.1
* ormlite-android version 5.7
* gradle plugin updated to 7.0.3

## [6.1.0](https://github.com/ngageoint/geopackage-android/releases/tag/6.1.0) (11-05-2021)

* compile SDK version 31
* geopackage-core version 6.1.0
* tiff version 2.0.5
* UrlTileGenerator URL bounds generation fix for degree projections (WGS84 WMS)
* Import GeoPackage fix where invalid file not deleted upon failed import

## [6.0.2](https://github.com/ngageoint/geopackage-android/releases/tag/6.0.2) (09-15-2021)

* Fix for user cursor queries of columns with large blobs

## [6.0.1](https://github.com/ngageoint/geopackage-android/releases/tag/6.0.1) (08-17-2021)

* tiff version 2.0.4
* Check for ORMLite Android backend log availability
* appcompat version 1.3.1

## [6.0.0](https://github.com/ngageoint/geopackage-android/releases/tag/6.0.0) (07-07-2021)

* geopackage-core version 6.0.0
* ormlite-android version 5.6
* SQLite Android Bindings version 3360000
* tiff version 2.0.3
* appcompat version 1.3.0
* gradle plugin updated to 4.2.2

## [5.1.0](https://github.com/ngageoint/geopackage-android/releases/tag/5.1.0) (03-23-2021)

* Open external GeoPackage support, without a required Context or Manager

## [5.0.0](https://github.com/ngageoint/geopackage-android/releases/tag/5.0.0) (03-09-2021)

* geopackage-core version 5.0.0
* compile SDK version 30
* ormlite-android version 5.3
* SQLite Android Bindings version 3340100
* appcompat version 1.2.0
* androidx documentfile 1.0.1 (new dependency)
* Tile table reprojections
* Omit null values in inserts
* Tile DAO map zoom levels
* GeoPackage Manager DocumentFile and progress support
* gradle plugin updated to 4.1.2

## [4.0.0](https://github.com/ngageoint/geopackage-android/releases/tag/4.0.0) (07-14-2020)

* geopackage-core version 4.0.0
* tiff version 2.0.2
* SQLite Android Bindings version 3320300
* Community extensions decoupling and management, including class repackaging
* Contents Data Type refactor, core data types and expanded custom data type support
* DAO options to enable modifying row ids or disable column value type validation
* Distinct select statement queries and counts
* GeoPackage DAO by table methods
* Tile creation projection fix for different projections in the same unit
* SRS and Projection shortcut methods
* gradle plugin updated to 4.0.1

## [3.5.0](https://github.com/ngageoint/geopackage-android/releases/tag/3.5.0) (03-10-2020)

* geopackage-core version 3.5.0
* Tile Generator option to skip pre-existing tiles when updating a GeoPackage
* XYZ tile rebranding, previously referred to as Google
* Separation of columns from user tables
* Queries by specified columns
* Feature Preview for drawing a single preview tile of features
* Feature Style Extension fix to use an individual feature style over a default table icon
* GeoPackageImpl and FeatureIndexGeoPackageResults classes changed to be public
* Android 29 / Q GeoPackage export methods
* gradle plugin updated to 3.6.1

## [3.4.0](https://github.com/ngageoint/geopackage-android/releases/tag/3.4.0) (11-14-2019)

* compile SDK version 29
* geopackage-core version 3.4.0
* SQLite Android Bindings version 3300100
* Java 8
* Feature Index Manager catches and logs index type errors, attempts next index type
* Fixed out of bounds iteration errors on Manual Feature Query Results and Feature Index List Results
* Improved Android Bindings SQLite connection support, including read only and on demand only connections
* RTree, Feature Table Index, Metadata, and Manual Feature Query: feature query and count methods with additional arguments, nested single SQL queries
* Feature Index Manager, single nested SQL queries for features with additional query argument options
* Feature Index Results and Metadata Results id iteration shortcut to retrieve id without creating full features
* Additional connection and DAO query and count methods
* Additional user result get value and id methods
* appcompat version 1.1.0
* gradle plugin updated to 3.5.2
* gradle version 5.4.1

## [3.3.0](https://github.com/ngageoint/geopackage-android/releases/tag/3.3.0) (07-10-2019)

* geopackage-core version 3.3.0
* Removed sf-geojson, inherit the dependency
* Transaction shortcut methods for the GeoPackages, connections, and User DAOs
* Feature Tiles geometry caching
* GeoPackage User Custom DAO retrieval
* Table Readers moved to geopackage-core
* Automatically enable foreign key checks for new connections without preexisting violations
* GeoPackage table foreign key check
* OGC API Features download to GeoPackage support
* Android Q fix for SQL Utils quote wrap
* gradle plugin updated to 3.4.2
* gradle version 5.1.1

## [3.2.0](https://github.com/ngageoint/geopackage-android/releases/tag/3.2.0) (04-02-2019)

* geopackage-core version 3.2.0
* tiff version 2.0.1
* sf-geojson version 2.0.1
* sqlite-android version 3270200
* NGA [Contents Id](http://ngageoint.github.io/GeoPackage/docs/extensions/contents-id.html) Extension
* NGA [Feature Style](http://ngageoint.github.io/GeoPackage/docs/extensions/feature-style.html) Extension
* OGC [Related Tables](http://www.geopackage.org/18-000.html) Extension improvements
* Feature Tile drawing and generator improvements including scaling, styles, and layering
* FeatureIndexResults id iteration option in place of reading full feature rows
* Feature Cache for memory caching feature rows in a single table
* Feature Cache Tables for memory caching feature rows from multiple single GeoPackage tables
* GeoPackage app context accessor
* Feature Row geometry type accessor
* GeoPackage creation example updates
* Upgrade to AndroidX support libraries
* gradle plugin updated to 3.3.2
* gradle version 4.10.1

## [3.1.0](https://github.com/ngageoint/geopackage-android/releases/tag/3.1.0) (10-04-2018)

* geopackage-core version 3.1.0
* User Table DAO projected bounding box methods
* GeoPackage Connection query improvements
* Cursor Result interface implementation, utilized by UserCursor
* Feature Indexer and Feature Table Index chunked limit queries when indexing
* Feature Index Manager support for RTree and Manual queries
* GeoPackage Database SQLite Android Bindings connection
* Geometry Metadata Data Source bounding box methods
* RTree Index Extension read support for querying geometries
* Handling of SQLite Write Ahead Log and Share Memory files
* Feature Index Results interface and implementations
* Feature Row geometry value and envelope methods
* Feature Table Reader ignore case of geometry column name
* Manual Feature Queries for unindexed geometries
* min SDK version updated to 16
* compile SDK version 28
* Android support library updated to 28.0.0
* SQLite Android Bindings version 3240000
* Android Manifest replace allowBackup as disabled and enable cleartext traffic
* gradle plugin updated to 3.2.0
* gradle version 4.6

## [3.0.2](https://github.com/ngageoint/geopackage-android/releases/tag/3.0.2) (07-27-2018)

* geopackage-core version 3.0.2
* Properties Extension for saving GeoPackage metadata in the file
* Properties Manager for using the Properties Extension on multiple open GeoPackages
* Additional GeoPackage Connection query method

## [3.0.1](https://github.com/ngageoint/geopackage-android/releases/tag/3.0.1) (07-13-2018)

* geopackage-core version 3.0.1
* Related Tables Extension support (DRAFT version 0.1)
* User row copy methods
* GeoPackage register cursor wrapper method
* Cursor Factory allows replacement of existing cursor wrappers with updated ones
* User DAO support for id-less schemas
* Custom User connection, DAO, cursor, row, and table reader implementations
* Javadoc warning fixes
* ormlite-android version 5.1
* gradle plugin updated to 3.1.3
* android maven gradle plugin updated to 2.1
* google repository update
* compile SDK version 27
* Android support library updated to 27.1.1
* gradle version 4.4

## [3.0.0](https://github.com/ngageoint/geopackage-android/releases/tag/3.0.0) (05-17-2018)

* geopackage-core version updated to 3.0.0
* [GeoPackage Core](https://github.com/ngageoint/geopackage-core-java) new WKB dependency on [Simple Features WKB library](https://github.com/ngageoint/simple-features-wkb-java)
  * Package names in dependent classes must be updated
  * GeometryType code calls must be replaced using GeometryCodes
* [GeoPackage Core](https://github.com/ngageoint/geopackage-core-java) new projection dependency on [Simple Features Projections library](https://github.com/ngageoint/simple-features-proj-java)
  * Package names in dependent classes must be updated
  * ProjectionFactory SRS calls must be replaced using SpatialReferenceSystem projection method
  * ProjectionTransform bounding box calls must be replaced using BoundingBox transform method
* [Simple Features GeoJSON library](https://github.com/ngageoint/simple-features-geojson-java) dependency

## [2.0.2](https://github.com/ngageoint/geopackage-android/releases/tag/2.0.2) (03-20-2018)

* Tile Scaling extension for displaying missing tiles using nearby zoom levels
* Skip tiles drawn from features when no features overlap the tile
* Tile DAO approximate zoom level methods
* Tile Generator fix to save updated bounds in the Tile Matrix Set
* Tile Generator projection transformations only when projections differ
* GeoPackage import fix to close input stream on error cases
* GeoPackage Metadata DB close backing database connection
* geopackage-core version updated to 2.0.2

## [2.0.1](https://github.com/ngageoint/geopackage-android/releases/tag/2.0.1) (02-14-2018)

* Coverage Data extension (previously Elevation Extension)
* RTree Index Extension minimal support (user functions not supported)
* Tile Generator contents bounding box fix to use the requested bounds
* Handle table names containing spaces within the cursor factory
* Open GeoPackage with writable flag option
* Turn off Android auto backup
* GeoPackage creation example
* geopackage-core version updated to 2.0.1

## [2.0.0](https://github.com/ngageoint/geopackage-android/releases/tag/2.0.0) (11-20-2017)

* WARNING - BoundingBox.java (geopackage-core) coordinate constructor arguments order changed to (min lon, min lat, max lon, max lat)
  Pre-existing calls to BoundingBox coordinate constructor should swap the min lat and max lon values
* WARNING - TileGrid.java (geopackage-core) constructor arguments order changed to (minX, minY, maxX, maxY)
  Pre-existing calls to TileGrid constructor should swap the minY and maxX values
* geopackage-core version updated to 2.0.0
* User Invalid Cursor support for reading large blobs
* Attribute, Feature, and Tile Invalid Cursor implementations
* Attribute, Feature, and Tile User Row Sync implementations
* Query support for "columns as"
* Feature Indexer and Feature Table Index row syncing
* Improved feature row geometry blob handling
* Feature Tiles geometry simplifications
* Multiple Results and List Results implementations of Feature Index results
* Feature Index Manager index type specific improvements
* User Query object representation and support
* tiff version updated to 2.0.0
* gradle plugin updated to 2.3.3
* android maven gradle plugin updated to 2.0
* maven google dependency
* compile SDK version 26
* build tools version updated to 26.0.1
* min SDK version updated to 14
* target SDK version updated to 26
* Android support library updated to 26.0.2

## [1.4.1](https://github.com/ngageoint/geopackage-android/releases/tag/1.4.1) (07-13-2017)

* geopackage-core version updated to 1.3.1
* Improved handling of unknown Contents bounding boxes
* Feature Tile max feature number drawn tiles default padding and text size
* Minor color deprecation and Javadoc updates

## [1.4.0](https://github.com/ngageoint/geopackage-android/releases/tag/1.4.0) (06-27-2017)

* geopackage-core version updated to 1.3.0
* tiff version updated to 1.0.3
* Copy constructors for user table (features, tiles, attributes) row objects
* Improved date column support for user tables (features, tiles, attributes)

## [1.3.2](https://github.com/ngageoint/geopackage-android/releases/tag/1.3.2) (06-12-2017)

* geopackage-core version updated to 1.2.2
* tiff version updated to 1.0.2
* Elevation Extension scale and offset columns changed to be non nullable
* Android support library updated to 25.2.0
* min SDK lowered from 14 to 13
* build tools version updated to 25.0.3
* gradle plugin updated to 2.3.2
* Android Manifest cleanup
* URL Tile Generator and GeoPackage download handle URL redirects

## [1.3.1](https://github.com/ngageoint/geopackage-android/releases/tag/1.3.1) (02-02-2017)

* Elevation Extension support (PNG & TIFF)
* geopackage-core version updated to 1.2.1
* Moved Play Services and Android Map Utility dependencies to [geopackage-android-map](http://github.com/ngageoint/geopackage-android-map)
* MapFeatureTiles replaced by DefaultFeatureTiles, removes Map library dependency & fixes geometries drawn over the International Date Line
* User Attributes table support
* tiff-java dependency for TIFF support
* Elevation query algorithms including Nearest Neighbor, Bilinear, and Bicubic
* Elevation unbounded results elevation queries
* Table and column name SQL quotations to allow uncommon but valid names
* Zoom level determination using width and height
* GeoPackage application id and user version
* Updated Android, Gradle, & Maven build & SDK libraries
* OrmLite Android version updated to 5.0

## [1.3.0](https://github.com/ngageoint/geopackage-android/releases/tag/1.3.0) (06-23-2016)

* geopackage-core version updated to 1.2.0
* Improved tile drawing on bounds for tiles not lining up with requests
* Tile Creator providing common tile generation functionality
* Tile reprojections between different unit types (ex. WGS84 GeoPackage tiles)
* Tile DAO changed to work with any projection units
* Tile Generator support for multiple projections, such as WGS84 in addition to Web Mercator
* URL Tile Generator changed to use provided projection in place of parsing URL

## [1.2.9](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.9) (05-10-2016)

* GeoPackage 1.1.0 spec updates
* geopackage-core version updated to 1.1.8
* GeoPackage Connection column exists and query single result method implementations
* Use updated projection calls by passing Spatial Reference Systems
* Feature Overlay Query use of Data Column names in place of the column name when available

## [1.2.8](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.8) (04-19-2016)

* GeoPackage Manager import GeoPackage as override fix to prevent multiple same named metadata entries
* GeoPackage metadata unique constraint added to name column
* Gradle and Android library updates

## [1.2.7](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.7) (04-18-2016)

* geopackage-core version updated to 1.1.7
* GeoPackage Manager name like queries
* GeoPackage Manager import as external link with override option methods
* GeoPackage Manager automatically delete database records where the file no longer exists
* Get longitude distance bug fix in Tile Bounding Box Map Utilities
* Feature Overlay Query and Feature Tiles close methods to close wrapped Index Manager connections
* Feature Overlay Query map click message improvements and map click Feature Table Data implementations
* Map click Feature Table Data JSON compatible conversions

## [1.2.6](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.6) (02-19-2016)

* geopackage-core version updated to 1.1.6
* Feature Tile Table Linker implementation with methods for retrieving data access objects
* Bounded Overlay check if a specified tile exists
* Feature Overlay ignore drawing tiles that already exist in a linked tile table
* Feature Overlay Query improved determination if a tile exists before querying features
* Manager create GeoPackage as an external file methods

## [1.2.5](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.5) (02-02-2016)

* geopackage-core version updated to 1.1.5
* Feature Tile Generator linking between feature and tile tables
* Feature Overlay Query updates to support linked feature and tile tables

## [1.2.4](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.4) (01-25-2016)

* Updated Android compile and target SDK version to 23 (Marshmallow)
* Fixed GeoPackage Manager count to also include external GeoPackages
* Added methods for retrieving and counting only internal or external GeoPackages

## [1.2.3](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.3) (01-15-2016)

* geopackage-core version updated to 1.1.4 for proj4j dependency location change
* Removed intermediate projection conversions in the map shape converter. Fixes EPSG 27700 (British National Grid) conversions.

## [1.2.2](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.2) (12-16-2015)

* geopackage-core version updated to 1.1.3 for Geometry projection transformations

## [1.2.1](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.1) (12-14-2015)

* geopackage-core version updated to 1.1.2 - [Core Issue #14](https://github.com/ngageoint/geopackage-core-java/issues/14)
* GeoPackage methods: execute SQL, query, foreign key check, integrity check, quick integrity check
* URL Tile Generator TMS support
* ORMLite log level changed from debug to info
* Tile Generator fix for updating a GeoPackage and replacing an existing tile

## [1.2.0](https://github.com/ngageoint/geopackage-android/releases/tag/1.2.0) (11-24-2015)

* Separation of Google Play Services Google Maps logic from GeoPackage functionality
* Tile retrieval logic separated from overlays
* Feature Tiles Map specific tile drawing separated into child implementation
* Separation of Map specific Tile Bounding Box utilities

## [1.1.1](https://github.com/ngageoint/geopackage-android/releases/tag/1.1.1) (11-20-2015)

* Javadoc project name and external API links
* Project Feature DAO bounding box when not in the same projection
* Feature Overlay Query message builder, check if features are indexed first
* geopackage-core version updated to 1.1.1 - [Issue #13](https://github.com/ngageoint/geopackage-android/issues/13)
* min and max column query methods - [Issue #15](https://github.com/ngageoint/geopackage-android/issues/15)
* TileDao methods, query for tile grid or bounding box at zoom level - [Issue #14](https://github.com/ngageoint/geopackage-android/issues/14)
* Database header and integrity validation options and methods. Validate imported GeoPackage headers by default. - [Issue #16](https://github.com/ngageoint/geopackage-android/issues/16)
* Manager methods - delete all externally linked databases with missing files, retrieve database name by externally linked path

## [1.1.0](https://github.com/ngageoint/geopackage-android/releases/tag/1.1.0) (10-08-2015)

* NGA Table Index Extension implementation - http://ngageoint.github.io/GeoPackage/docs/extensions/geometry-index.html
* Feature Index Manager to combine existing metadata indexing with the NGA Table Index Extension
* Feature Tile improvements, including max features per tile settings and custom max feature tile drawing
* Feature and Tile DAO get bounding box method
* Feature Overlay Query for querying the features behind the drawn feature tiles

## [1.0.1](https://github.com/ngageoint/geopackage-android/releases/tag/1.0.1) (09-23-2015)

* Upgrading geopackage-core version to 1.0.1 to get added GeoPackageCache functionality

## [1.0.0](https://github.com/ngageoint/geopackage-android/releases/tag/1.0.0) (09-15-2015)

* Initial Release
