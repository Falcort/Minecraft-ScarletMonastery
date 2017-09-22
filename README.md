# Created by Thibault SOUQUET
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![GitHub release](https://img.shields.io/github/release/Falcort/Minecraft-WelcomeTitle.svg?maxAge=2592000)](https://github.com/Falcort/Minecraft-WelcomeTitle/releases)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.10-brightgreen.svg)]()
[![Minecraft](https://img.shields.io/badge/Minecraft-1.12-red.svg)]()

## Scarlet Monastery
![Logo](https://img00.deviantart.net/773b/i/2016/218/b/2/_crest__scarlet_crusade_by_celestalon-dabwi8t.png)
### Created in 2016

### This plugins was created for Spigot & Minecraft 1.10 & for the server Minedaeron

This plugin is design to handle wow like dungeon, especialy Scarlet Monastery.

#### How does it work

You need to set up multiple things before making the plugin working, unless your server will suffer lot of lags.
You need to create a room entrance of the dungeon with 3 signs, and take the coordinate of the signs
They will be used to enter and team up in the dungeon.

Then you need to create and duplicate the bloc of the dungeon, you need to have at the end 3 same dungeons.
All of them need a waiting room, where players will need to wait to be 5 in the dungeon.
Place one sign that will be use to exit the dungeon.
Take a teleportation coordinate in the waiting room & the coordinate of the sign.

Enter all those infromation in the config file and that done !

Now player can go to the dungeon, see how many people are already in the waiting room, if they are 5, this particulare instance of the dungeon will be close.
But they can still join stranger on others non 5 people instances.
Everything is updated in real time so if a player leave someone less can join instantly.

Todos :
- [X] Make a working version
- [ ] Make a XML file for multiple dungeons setup
- [ ] Change the eventListener on something else that entity movement (Very laggy)
- [ ] Solve the bug of beaking sign

