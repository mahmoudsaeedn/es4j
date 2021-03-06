# Command

Command is a request for changes in the domain. Unlike an [event](event.md), it is not a statement of fact as it might be rejected. For example, `CreateUser` command may or may not result in an `UserCreated` event being produced.

Defining a command is pretty straightforward, through subclassing `StandardCommand<State, Result>`:

```java
public class CreateUser extends StandardCommand<Void, User> {
  @Getter
  private final String email;

  public CreateUser(String email) {
    this.email = email;
  }
}
```

The type parameter signifies an optional "result" type that can be returned
once the command is successfully executed, by overriding the `result()`
method:

```java
@Override
public User result() {
  return User.lookup(email);
}
```

A more important part of any command is being able to generate events. This is done by overriding the `events()` method that returns a stream of events:

```java
@Override
public EventStream<Void> events(Repository repository) {
  return EventStream.of(new UserCreated(email));
}
```
