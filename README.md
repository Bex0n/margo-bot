# Margonem Autofighter

[![MIT license](https://img.shields.io/github/license/Aarif123456/image_repository?style=for-the-badge)](https://lbesson.mit-license.org/)
![Top Language](https://img.shields.io/github/languages/top/Bex0n/margo-bot?style=for-the-badge)

## What is this? 🤔

This is an addon to [Margonem](https://www.margonem.pl) - the largest
internet polish MMORPG game. It automatically attacks chosen monster whenever it spawns.

THIS IS ONLY INTENDED FOR RESEARCH PURPOSES.

## How to run

Program has been tested on Windows.

1. Setup.
* you must have Java Development Kit installed.
* set path to jdk bin folder in user's enviroment variables (for example C:\Program Files\Java\jdk-18.0.1.1\bin).

2. Add monster to program's database.
* make screenshot by launching MakeScreenshot.bat
* find 7x7 pixel square covering monster's body defined by it's left upper corner pixel
* launch RunMonsterCreation 
* set monster's name
* set screenshot's file (default capture.jpg)
* set left upper corner pixel coordinates

3. Run program
* launch RunProgram
* enter monster's name
* launch Margonem game and make it visible on entire screen (just fullscreen, NOT F11 MODE)
* program will attack monster when it spawns

## Features :eyes:

* Add monster to database
    * Make screenshot to capture monster
    * Open monster creation tool and add it to database
* Autokill monsters
    * Choose monster and kill it everytime it spawns

## TODO :alarm_clock:

* Monster database
    * encryption
    * easier access
    * point-and-click monster data creation

* Autokill
    * test accuracy
    * improve algorithm
    * accept loot automatically

* User Management
    * GUI

* Future features
    * send mobile notification when capcha appears

