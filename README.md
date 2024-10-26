Pretty's Trio Trial is a game I made for stream as a joke because it was the 69th stream. 

You roll dice trying to get them to all land on threes. Once you do, you can add a die to your stock and repeat the task.
Once you get 25 dice and they all land on threes, you'll be able to unlock the win screen of the game.
It sounds simple, but the time to accomplish is inhumane.
Also, if the game is closed at any point, all progress is lost and you must start all over again.

It's all or nothing.

For those who want to play it themselves, here's how to set it up. (Yes, I know there's a better way to do this, but that requires me to do some extra set-up, as far as I know, and I don't have the time to do that right now.)

Step 1: Install the most recent Java JDK. Technically, you only need the JRE, but I couldn't find any offical downloads of the most recent version on it's own. However, the download for the JDK has it, so it'll have to do.
https://www.oracle.com/java/technologies/downloads/

Step 2: Install the most recent SDK for JavaFX. Since JavaFX is now separated from the JDK, you need to install this too. Otherwise, the game won't run.
https://gluonhq.com/products/javafx/

Once it's installed, you'll get a zipped folder. Open it to find the SDK folder. Move this somewhere easy to find.

Step 3: Locate the bin folder within the folder you just installed. Once you find it, take note of it's file path, perhaps copy it into a text file. At the end of your path, add a "\" or "/" depending on your OS. Let's refer to this path as [FILEPATH].

Step 4: Install the game, specifically, the .jar file, and place it somewhere easy to access. Why follow my garbage instructions for nothing?

Step 5: Open a terminal (i.e. Command Prompt) and navigate it to be at the .jar file's location. The terminal should show the current directory you're in. If you haven't used the terminal before, you can type "cd" followed by a space then the directory you want to visit to travel there.

Once there...
Step 6: Copy the following text under the OS of your device, making sure to replace [FILEPATH] with the file path you wrote down in step 3, into the terminal.

WINDOWS:
java --module-path [FILEPATH] --add-modules javafx.controls -jar Pretty's_Trio_Trial.jar

MACOS:
java --module-path [FILEPATH] --add-modules javafx.controls -jar Pretty\'s_Trio_Trial.jar

I belive the text for Linux is the same as MacOS, but I'm not sure.
Press enter/return and if everything was done correctly, the game should open up momentarily!

Again, I know the instructions suck. Hopefully, I'll be able to make the process more streamlined. For now, this is the best I've got.

As for those here for the code & assets, feel free to download, modify, and customize them into your own personal taste.
