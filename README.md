# string-parser

This is an application(backend) for parsing string.

# IntelliJ IDE

JetBrains provide the IntelliJ IDE.

This IDE is recommended for excellent Maven integration, and very fast build times.

# Tools
 * Java 11
 * Spring framework (boot, mvc, logging, test)
 * Maven
 * Lombok
 * Swagger
 * Rest-assured

# Dependencies

All required dependencies are listed in the 'pom.xml' file.

## Setting up
1. Open project in IntelliJ, it will create an `.idea`.
2. Use *File* > *Project Structure* to confirm Java 11 is used.
3. Create *Edit Configuration* (if not exist Add new *Maven* configuration) or check build and run options(must be specified Java 11 SDK for 'string-parser' module and 'com.dannyhromau.parser.Application' as running directory).
4. Use the *Maven* tools window to:
   * *Toggle "Skip Tests" Mode* (if You won't to testing the application)
   * *Execute Maven Goal*: `clean install`
   * check the target directory (You should see an archive there named *string-parser-1.0-SNAPSHOT.jar*).
     
## Running and testing
1. Run the application with command `java -jar string-parser-1.0-SNAPSHOT.jar --spring.config=application` in *command line*.
2. The maximum and minimum string length is specified in application.yml file located in your jar-archive. You can change this value betweeen 1 and 2147483645.

❗️ **Note**: if You want to send the string with big number of characters, add the java heap size to run command (for example 'java **-Xmx8192m** -jar string-parser-1.0-SNAPSHOT.jar --spring.config=application')

4. For tetsing all the endpoints possible see swagger user interface (go to "yourhostname/swagger-ui/index.html#/".

Hope You enjoy!
