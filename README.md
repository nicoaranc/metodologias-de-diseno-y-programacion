# 99.7% Citric Liquid

## About

`99.7% Citric Liquid` is a simplified clone of the renowned game, `100% Orange Juice`. Its main
purpose is to serve as an educational tool, teaching foundational programming concepts.

📢 **Note**: This project is purely educational and will not be used for any commercial purposes.

---

## For Students

The remainder of this README is yours to complete. Take this opportunity to describe your
contributions, the design decisions you've made, and any other information you deem necessary.

## Updates
### Tarea 2
I implemented the Double Dispatch in the reward's methods, to give corresponding rewards to the winning units when the battle
ends. And a partial Double Dispatch in the battle's methods, this decision was taken because the battle sequence
depends on the player decision to defend or evade the attack, so the idea is to complete the attack sequence in the 
future. \
Besides to implement the getters and setters of every private variables of the Units (PlayerCharacter & WildUnits).

### Tarea 3

#### Combat & State Pattern
I finished all the implementation of the combat's methods, and starts to struct the game with a
GameController, more specifically implemented the State Pattern in the game. The State Pattern was made with 
different classes that represents each state in the game, and the context of the State Pattern 
is the GameController, that controls every transition in the game and their respective events.

#### Observer Pattern
In addition, the Observer Pattern was implemented too, this is for notify the GameController when
a player reach the 6th Norma (the game winning condition), more specifically the GameController 
is the Observer and the Observable Subject are the players, that if one of them reach the Winning Norma,
notify the GameController with an event to update the GameController to finish the game.

#### Null Object & Factory Patterns
And finally, there are two more Design Patterns implemented in the game, the Null Object Pattern and 
the Factory Pattern. The implementation of the Null Object pattern it was simple, it was implemented to
each Norma except the 6th Norma, this is to separate the "winning" behaviour of the Normas,
when a Player reach the 6th Norma, the player have to notify to the GameController, but
first it have to check if the Norma is the winning one, but it isn't, the rest of the Normas
doesn't do anything. The implementation of the Factory Pattern it was to create the entire
Board of the game, the objects to create are the different panels, and then each panel have
a different Factory, and the game's Board have instances of each Factory and if the constructor
of the board wants to add one Panel to the Board, just call to the Board's specific Factory.


## States diagram

![Diagrama de estados](docs/diagrama-estados%20.png)

<div style="text-align:center;">
    <img src="https://i.creativecommons.org/l/by/4.0/88x31.png" alt="Creative Commons License">
</div>

This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

---