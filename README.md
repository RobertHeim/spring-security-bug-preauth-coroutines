## Minimal reproducible example
See [ActionService](src/main/kotlin/com/example/demo/ActionService.kt)
and [ActionServiceTest](src/test/kotlin/com/example/demo/ActionServiceTest.kt)
where the following `@PreAuthorize` SpEL is used:
```
@PreAuthorize("#action.getUserId() == 1")
```

## Run
```
./gradlew test
```

## Expected
Build success

## Actual
Fails with:
```
Caused by: org.springframework.expression.spel.SpelEvaluationException: EL1004E: Method call: Method getUserId() cannot be found on type java.lang.Object[]
```
Because in `org.springframework.expression.spel.ast.MethodReference` the `targetObject` is **not of the expected Type `Action`** but of type `Object[]` holding

```
[0] = "Action(userId=1)"
[1] = "Continuation at com.example.demoActionServiceTest$save...."
```

## Workaround

Adding `[0]` works:
```
@PreAuthorize("#action[0].getUserId() == 1")
```
