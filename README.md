# deeply-in-patterns
Patterns Examples

1. **Interpreter** pattern for parsing URL queries to SQL WHERE conditions
   
   Supports queries in format e.g. `field=value&&field2=value2`

   QueryInterpreterTest shows how it works:
```

String testQuery = "placesCount==10&&skiLevel==BEGINNER&&price==1000";

String actualSqlQuery = underTest.interpret(testQuery);

assertEquals(actualSqlQuery, "placesCount=10 AND skiLevel='BEGINNER' AND price=1000");
