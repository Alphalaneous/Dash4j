# Dash4j
A library to interact with Geometry Dash

In this library, we have a few cool things to interact with GD, such as getting responses from the servers, reading the Geometry Dash save, and editing/reading the Geometry Dash memory.

For example, there are a few listeners that will allow you to perform actions based on something occuring in game such as entering a level:

```java
Global.onEnterLevel(() -> {
  System.out.println("Entered A Level");
})
```
We can also look at in level stuff such as changing gamemode:

```java
Level.onGamemode(Gamemode.SHIP, () -> {
  System.out.println("I am ship now");
});
```

The Level class allows you to listen to, edit and get basic information about the level you are in.
The Hacks class allows for settings Noclip, Safe Mode, Practice Music Hack, No Spikes, No Hitbox, and No Solids.
The SaveExplorer class allows for reading and modifying GD saves easily. This includes parsing GD levels and editing them.
