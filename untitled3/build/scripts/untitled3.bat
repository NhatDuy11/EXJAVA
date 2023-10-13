@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  untitled3 startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and UNTITLED3_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\untitled3-2.13.11.jar;%APP_HOME%\lib\spark-sql_2.12-3.1.2.jar;%APP_HOME%\lib\spark-catalyst_2.12-3.1.2.jar;%APP_HOME%\lib\spark-core_2.12-3.1.2.jar;%APP_HOME%\lib\spark-unsafe_2.12-3.1.2.jar;%APP_HOME%\lib\chill_2.12-0.9.5.jar;%APP_HOME%\lib\spark-network-shuffle_2.12-3.1.2.jar;%APP_HOME%\lib\spark-network-common_2.12-3.1.2.jar;%APP_HOME%\lib\scala-xml_2.12-1.2.0.jar;%APP_HOME%\lib\scala-reflect-2.12.10.jar;%APP_HOME%\lib\json4s-jackson_2.12-3.7.0-M5.jar;%APP_HOME%\lib\jackson-module-scala_2.12-2.10.0.jar;%APP_HOME%\lib\spark-launcher_2.12-3.1.2.jar;%APP_HOME%\lib\spark-kvstore_2.12-3.1.2.jar;%APP_HOME%\lib\spark-sketch_2.12-3.1.2.jar;%APP_HOME%\lib\spark-tags_2.12-3.1.2.jar;%APP_HOME%\lib\json4s-core_2.12-3.7.0-M5.jar;%APP_HOME%\lib\scala-parser-combinators_2.12-1.1.2.jar;%APP_HOME%\lib\json4s-ast_2.12-3.7.0-M5.jar;%APP_HOME%\lib\json4s-scalap_2.12-3.7.0-M5.jar;%APP_HOME%\lib\scala-library-2.13.11.jar;%APP_HOME%\lib\opencsv-5.5.2.jar;%APP_HOME%\lib\hadoop-client-3.2.0.jar;%APP_HOME%\lib\hadoop-common-3.2.0.jar;%APP_HOME%\lib\commons-text-1.9.jar;%APP_HOME%\lib\commons-lang3-3.12.0.jar;%APP_HOME%\lib\commons-beanutils-1.9.4.jar;%APP_HOME%\lib\commons-collections4-4.4.jar;%APP_HOME%\lib\avro-mapred-1.8.2-hadoop2.jar;%APP_HOME%\lib\avro-ipc-1.8.2.jar;%APP_HOME%\lib\avro-1.8.2.jar;%APP_HOME%\lib\jackson-module-paranamer-2.10.0.jar;%APP_HOME%\lib\paranamer-2.8.jar;%APP_HOME%\lib\chill-java-0.9.5.jar;%APP_HOME%\lib\xbean-asm7-shaded-4.15.jar;%APP_HOME%\lib\activation-1.1.1.jar;%APP_HOME%\lib\curator-recipes-2.13.0.jar;%APP_HOME%\lib\hadoop-mapreduce-client-jobclient-3.2.0.jar;%APP_HOME%\lib\hadoop-mapreduce-client-common-3.2.0.jar;%APP_HOME%\lib\hadoop-mapreduce-client-core-3.2.0.jar;%APP_HOME%\lib\hadoop-yarn-client-3.2.0.jar;%APP_HOME%\lib\hadoop-yarn-common-3.2.0.jar;%APP_HOME%\lib\hadoop-auth-3.2.0.jar;%APP_HOME%\lib\curator-framework-2.13.0.jar;%APP_HOME%\lib\curator-client-2.13.0.jar;%APP_HOME%\lib\zookeeper-3.4.14.jar;%APP_HOME%\lib\jakarta.servlet-api-4.0.3.jar;%APP_HOME%\lib\commons-math3-3.4.1.jar;%APP_HOME%\lib\arrow-vector-2.0.0.jar;%APP_HOME%\lib\arrow-memory-netty-2.0.0.jar;%APP_HOME%\lib\arrow-memory-core-2.0.0.jar;%APP_HOME%\lib\spotbugs-annotations-3.1.9.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.30.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.30.jar;%APP_HOME%\lib\slf4j-log4j12-1.7.30.jar;%APP_HOME%\lib\stream-2.9.6.jar;%APP_HOME%\lib\metrics-jvm-4.1.1.jar;%APP_HOME%\lib\metrics-json-4.1.1.jar;%APP_HOME%\lib\metrics-graphite-4.1.1.jar;%APP_HOME%\lib\metrics-jmx-4.1.1.jar;%APP_HOME%\lib\metrics-core-4.1.1.jar;%APP_HOME%\lib\orc-core-1.5.12.jar;%APP_HOME%\lib\hive-storage-api-2.7.2.jar;%APP_HOME%\lib\orc-shims-1.5.12.jar;%APP_HOME%\lib\parquet-hadoop-1.10.1.jar;%APP_HOME%\lib\parquet-column-1.10.1.jar;%APP_HOME%\lib\parquet-encoding-1.10.1.jar;%APP_HOME%\lib\parquet-common-1.10.1.jar;%APP_HOME%\lib\parquet-format-2.4.0.jar;%APP_HOME%\lib\kerb-simplekdc-1.0.1.jar;%APP_HOME%\lib\kerb-client-1.0.1.jar;%APP_HOME%\lib\kerb-admin-1.0.1.jar;%APP_HOME%\lib\kerb-server-1.0.1.jar;%APP_HOME%\lib\kerb-common-1.0.1.jar;%APP_HOME%\lib\kerb-util-1.0.1.jar;%APP_HOME%\lib\kerb-identity-1.0.1.jar;%APP_HOME%\lib\kerby-config-1.0.1.jar;%APP_HOME%\lib\token-provider-1.0.1.jar;%APP_HOME%\lib\kerb-crypto-1.0.1.jar;%APP_HOME%\lib\kerb-core-1.0.1.jar;%APP_HOME%\lib\kerby-pkix-1.0.1.jar;%APP_HOME%\lib\slf4j-api-1.7.30.jar;%APP_HOME%\lib\log4j-1.2.17.jar;%APP_HOME%\lib\compress-lzf-1.0.3.jar;%APP_HOME%\lib\snappy-java-1.1.8.2.jar;%APP_HOME%\lib\lz4-java-1.7.1.jar;%APP_HOME%\lib\zstd-jni-1.4.8-1.jar;%APP_HOME%\lib\RoaringBitmap-0.9.0.jar;%APP_HOME%\lib\commons-net-3.6.jar;%APP_HOME%\lib\jersey-container-servlet-2.30.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.30.jar;%APP_HOME%\lib\jersey-server-2.30.jar;%APP_HOME%\lib\jersey-client-2.30.jar;%APP_HOME%\lib\jersey-hk2-2.30.jar;%APP_HOME%\lib\jersey-media-jaxb-2.30.jar;%APP_HOME%\lib\jersey-common-2.30.jar;%APP_HOME%\lib\netty-all-4.1.51.Final.jar;%APP_HOME%\lib\hadoop-hdfs-client-3.2.0.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.9.5.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.9.5.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.9.5.jar;%APP_HOME%\lib\jackson-databind-2.10.0.jar;%APP_HOME%\lib\ivy-2.4.0.jar;%APP_HOME%\lib\oro-2.0.8.jar;%APP_HOME%\lib\pyrolite-4.30.jar;%APP_HOME%\lib\py4j-0.10.9.jar;%APP_HOME%\lib\commons-crypto-1.1.0.jar;%APP_HOME%\lib\unused-1.0.0.jar;%APP_HOME%\lib\univocity-parsers-2.9.1.jar;%APP_HOME%\lib\orc-mapreduce-1.5.12.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-collections-3.2.2.jar;%APP_HOME%\lib\jackson-mapper-asl-1.9.13.jar;%APP_HOME%\lib\jackson-core-asl-1.9.13.jar;%APP_HOME%\lib\commons-compress-1.8.1.jar;%APP_HOME%\lib\xz-1.5.jar;%APP_HOME%\lib\httpclient-4.5.2.jar;%APP_HOME%\lib\commons-codec-1.11.jar;%APP_HOME%\lib\kryo-shaded-4.0.2.jar;%APP_HOME%\lib\hadoop-yarn-api-3.2.0.jar;%APP_HOME%\lib\hadoop-annotations-3.2.0.jar;%APP_HOME%\lib\leveldbjni-all-1.8.jar;%APP_HOME%\lib\jackson-core-2.10.0.jar;%APP_HOME%\lib\jackson-annotations-2.10.0.jar;%APP_HOME%\lib\audience-annotations-0.5.0.jar;%APP_HOME%\lib\shims-0.9.0.jar;%APP_HOME%\lib\jakarta.ws.rs-api-2.1.6.jar;%APP_HOME%\lib\hk2-locator-2.6.1.jar;%APP_HOME%\lib\hk2-api-2.6.1.jar;%APP_HOME%\lib\hk2-utils-2.6.1.jar;%APP_HOME%\lib\jakarta.inject-2.6.1.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.3.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\javassist-3.25.0-GA.jar;%APP_HOME%\lib\janino-3.0.16.jar;%APP_HOME%\lib\commons-compiler-3.0.16.jar;%APP_HOME%\lib\antlr4-runtime-4.8-1.jar;%APP_HOME%\lib\protobuf-java-2.5.0.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\aircompressor-0.10.jar;%APP_HOME%\lib\threeten-extra-1.5.0.jar;%APP_HOME%\lib\parquet-jackson-1.10.1.jar;%APP_HOME%\lib\minlog-1.3.0.jar;%APP_HOME%\lib\objenesis-2.5.1.jar;%APP_HOME%\lib\guice-4.0.jar;%APP_HOME%\lib\guava-16.0.1.jar;%APP_HOME%\lib\commons-cli-1.2.jar;%APP_HOME%\lib\commons-io-2.5.jar;%APP_HOME%\lib\jetty-servlet-9.3.24.v20180605.jar;%APP_HOME%\lib\jsp-api-2.1.jar;%APP_HOME%\lib\commons-configuration2-2.1.1.jar;%APP_HOME%\lib\re2j-1.1.jar;%APP_HOME%\lib\gson-2.2.4.jar;%APP_HOME%\lib\htrace-core4-4.1.0-incubating.jar;%APP_HOME%\lib\woodstox-core-5.0.3.jar;%APP_HOME%\lib\stax2-api-3.1.4.jar;%APP_HOME%\lib\dnsjava-2.1.7.jar;%APP_HOME%\lib\okhttp-2.7.5.jar;%APP_HOME%\lib\jaxb-api-2.2.11.jar;%APP_HOME%\lib\aopalliance-repackaged-2.6.1.jar;%APP_HOME%\lib\arrow-format-2.0.0.jar;%APP_HOME%\lib\flatbuffers-java-1.9.0.jar;%APP_HOME%\lib\httpcore-4.4.4.jar;%APP_HOME%\lib\jetty-security-9.3.24.v20180605.jar;%APP_HOME%\lib\nimbus-jose-jwt-4.41.1.jar;%APP_HOME%\lib\json-smart-2.3.jar;%APP_HOME%\lib\okio-1.6.0.jar;%APP_HOME%\lib\jetty-util-9.3.24.v20180605.jar;%APP_HOME%\lib\jcip-annotations-1.0-1.jar;%APP_HOME%\lib\accessors-smart-1.2.jar;%APP_HOME%\lib\kerby-xdr-1.0.1.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\jline-0.9.94.jar;%APP_HOME%\lib\netty-3.10.6.Final.jar;%APP_HOME%\lib\kerby-asn1-1.0.1.jar;%APP_HOME%\lib\kerby-util-1.0.1.jar


@rem Execute untitled3
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %UNTITLED3_OPTS%  -classpath "%CLASSPATH%" scalaSpark.scala1 %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable UNTITLED3_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%UNTITLED3_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
