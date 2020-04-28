# Card Validation System
A java based card validation system.

## Running

To run the project, download the jar from the compiled folder and run the following command. The project is tested with Java versions 13+.

```
java -jar <path_to_project_jar> <path_to_inputfile> <path_to_ouputfile>
```

## Testing

To run the JUnit tests present in the project you could use JUnit Console Launcher version 5+. Copy the folder testResources to run the sample tests to the same path as the jar and then run the following command. Feel free to replace the data in the sample files to run custom tests.

```
java -jar <path_to_junit_jar> --classpath <path_to_project_jar> -p com.sjsu.individualproject.test
```
