cd D:\CODE\Offline\Statistics\StatisticsImp\app\packJar
d:

del /f /s /q /a .\*
rd META-INF
rd com
rd de
rd okhttp3
rd okio
rd retrofit2

copy "D:\CODE\Offline\Statistics\StatisticsImp\app\release\greendao-1.3.7.jar" "D:\CODE\Offline\Statistics\StatisticsImp\app\packJar"
copy "D:\CODE\Offline\Statistics\StatisticsImp\app\release\okhttp-3.2.0.jar" "D:\CODE\Offline\Statistics\StatisticsImp\app\packJar"
copy "D:\CODE\Offline\Statistics\StatisticsImp\app\release\okio-1.6.0.jar" "D:\CODE\Offline\Statistics\StatisticsImp\app\packJar"
copy "D:\CODE\Offline\Statistics\StatisticsImp\app\release\retrofit-2.0.0.jar" "D:\CODE\Offline\Statistics\StatisticsImp\app\packJar"
copy "D:\CODE\Offline\Statistics\StatisticsImp\app\release\STATISTIC_v1.1.jar" "D:\CODE\Offline\Statistics\StatisticsImp\app\packJar"

jar -xvf greendao-1.3.7.jar
rd /q /s .\META-INF

jar -xvf okhttp-3.2.0.jar
rd /q /s .\META-INF

jar -xvf okio-1.6.0.jar
rd /q /s .\META-INF

jar -xvf retrofit-2.0.0.jar
rd /q /s .\META-INF

jar -xvf STATISTIC_v1.1.jar
rd /q /s .\META-INF

del greendao-1.3.7.jar
del okhttp-3.2.0.jar
del okio-1.6.0.jar
del retrofit-2.0.0.jar
del STATISTIC_v1.1.jar

xcopy /e /q D:\CODE\Offline\Statistics\StatisticsImp\app\release\META-INF D:\CODE\Offline\Statistics\StatisticsImp\app\packJar\META-INF\
jar -cvfM STATISTIC_v1.1.jar .

pause