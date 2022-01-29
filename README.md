# README #

**Name:**	Jonathan Ekman

**Period:**	7

**Game Title:** Asteroids I guess

## Game Proposal ##

Asteroids. It's quite literally asteroids.

Game Controls:

+ space to shoot
+ a to turn left
+ d to turn right

Game Elements:

+ Asteroids
	+ they float about
+ SpaceShip
	+ it flies about
+ Aliens
	+ they fly about too but shoot you
	+ they are also rare

How to Win:

+ you don't

## Link Examples ##
similar in terms of how it operates to civilization but plays differently

+ [Example Link](https://store.steampowered.com/app/289070/Sid_Meiers_Civilization_VI/)

## Teacher Response ##

**Approved**

Looks like a good plan, but make sure you have a complete game in time. Can you get a simple playable version that just has the core gameplay done by early next week?

## Class Design and Brainstorm ##

With how many changes there are this is kinda useless.

## Development Journal ##

GOAL FOR EACH DAY:
Do as much as possible/am willing to do.

5/24/20
2 hours

research on Tech Tree implementations
Tech Tree will use enums
Tech Tree mostly compleated.
started plans for class/game structure 

5/26/20
2 ish hours

work on game engine, buttons now properly supported.
research on game AI implementations
found finite stage, implementation
seems quite hard
started work on player and AI implementations, AI not so much,
very confusing.

5/28/20
3 hours

Continued work on game engine
continued research on AI implementations
found stratagy pattern
still have no idea how to do the AI
considering using java.lang.net?
for multiplayer instead of AI
Resarched serialization
thats as far as I got with that
still very confused as to what to do

5/30/20
roughly 6 hours

more work on engine
even more ai research
work on ui and general game stuffs
its not going well.
considering changing game drastically,
likely outcome to be a sidescrolling
nuke guidance game.

I have deemed the current game too hard
to make within the given time, I have
hanceforth decided to make the essentially
shmup.

while making the shmup, I ended up making
the basics to Asteroid or Lunar Lander. And given
the continued impendingness of time it would likely
be best to make Asteroids, so I am going to do that.

have a missle/rocket flying about the screen, flies off
edges and never returns...
again even more work on engine, it just needs so much

5/31/20
maybe 12 hours I don't know

Dawn of the third day:
24 hours remain

Yes its 12 in the morning.
added transport from one side
to the other, unfortunately hardcoded.
made placeholder art for asteroids,
while I was at it i made spaceship art too

added meteors, made them spin and move about
fixed most of the hardcoding for transport over
edges
made meteors go poof upon spaceship impact
added health as a little bar thing
in bottom right
gave spaceship invicibility time

added bullets fire from center of spacesip
while spaceship is being constantly put to the top
encountered strange bug where putting spaceship on top
would cause a gagillion of bullets to be created from
one press of space
fixed it by adding a delay to fire


made bullets destroy meteors and have them split into two
unless they were already small. i got a very fun bug from
not checking if they were small already
made bullets poof with meteors

added score spent a while trying to figure out how to
center it, ended up just geting its width and length
and using that
made score update with shooting meteors

game exits to main menu when all health is lost
time to add sound.

I added sound, it took a while
cause apparently it must be a .wav
also the health bar goes grey while in invicibility

added a highscore boad, it was painful
now to serialize it so your scores stay constant
in an attempt to find maximum scoreboard display num
i found a bug that makes the game run slower and
slower depending on how many games you have ran
still no serialization though.

just asteroids seemed lame, so I put
in aliens that shoot at you.
the targeting works, but not well
it as also a pain to get working
but It will kill you.

Finally got the HSBoard to be able to do backspaces...
UFO will now spawn at a random time, with increasing
chances as you keep playing. You might even get
real bad luck and have 2 spawn.

did more tweaking, updated some textures.

Best way to encounter a ufo:
destroy all but one asteroid,
preferably a big one
then fly around avoiding it.
if you dont want to do that
change the spawn chance
in the update method of
levelgen

6/1/20

I made a jar file for ya.


**Date (time spent)**

Goal:  What are you trying to accomplish today?

Work accomplished:  Describe what you did today and how it went.

**Date (time spent)**

Goal:  What are you trying to accomplish today?

Work accomplished:  Describe what you did today and how it went.

***
***