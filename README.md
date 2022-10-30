# CustomBuoni
This Minecraft plugin introduces Buoni[^buoni], items that can be *used*[^used] only once and that are destroyed afterwards, but let's dive into it.

To understand why I made such a plugin, why there are these types of Buoni, and why is it in italian, jump off to the [**What's all of this about?**](https://github.com/Giopav/CustomBuoni/new/main?readme=1#whats-all-of-this-about) section.

## What's a Buono?
A Buono is a voucher that can be used for something.

If you feel like this definition is too broad, there's a reason for it.

Currently, there is a limited use for Buoni, let's see them:
- Nome (Modifies the name of the item).
- Descrizione (Modifies the first line of lore of the item).
- Strattrak (Adds a tracker of player kills onto the item, displayed in the description).
- Mobtrak (Adds a tracker of mob kills onto the item, displayed in the description).

## Command & subcommands
> /buono [arg]

The main command is "**/buono**", this is the only command that you will need to call to interact with the plugin and its functions.

The subcommands[^subcommand] are the ones that play the most important role, there are 5 subcommands: apply, cancel, give, help, and list.


<details>
  <summary>Modify</summary>
  
  > /buono [value]

  This is not really a subcommand, it will be called every time the player writes anything other that the 5 standard subcommands.

  You can use this subcommand when you want to modify the value of the Buono in your hand, but not every Buono has a value, you can distinguish the ones that do, because the first line of the lore starts with "»".

  ![image](https://user-images.githubusercontent.com/43653262/198896035-da17a574-1888-46f8-ba37-1fe338bd0405.png)

  The plugin will try to assign as value any[^value] kind of text that you write.
  
</details>
<details>
  <summary>Apply</summary>
  
  > /buono apply

  Apply the Buono that is on your off hand onto the item in your main hand.

  More on this at the [**Apply a Buono**](https://github.com/Giopav/CustomBuoni/new/main?readme=1#apply-a-buono) section.
  
  ------
  
</details>
<details>
  <summary>Cancel</summary>
  
  > /buono cancel

  Cancel the value of the Buono in your main hand.

  From:

  ![image](https://user-images.githubusercontent.com/43653262/198890488-7989fcfd-08b7-4f93-b52e-c08bf88d3439.png)

  To:

  ![image](https://user-images.githubusercontent.com/43653262/198890524-dcb95385-73db-4db2-8428-519364fd2f79.png)
  
  ------

</details>
<details>
  <summary>Give</summary>
  
  > /buono give [Buono]

  Add to the sender's inventory the selected Buono, to see a list of valid Buoni, check the [List subcommand](https://github.com/Giopav/CustomBuoni/new/main?readme=1#list) section.
  
  ------
  
</details>
<details>
  <summary>Help</summary>
  
  > /buono help

  Receive a message with simple hints on how to use the command (in Italian lol).

  ![image](https://user-images.githubusercontent.com/43653262/198892579-488bac4b-c753-46b4-935d-a4d5acf394ad.png)
  
  ------
  
</details>
<details>
  <summary>List</summary>
  
  > /buono list

  Receive an Automatically-generated list[^list] of the Buoni.
  
  ------
  
</details>

## Apply a Buono
Some Buoni can be applied (like Nome and Descrizione), let's explore how: 
- To apply them they first have to contain a valid value.
- Hold the Buono in your off hand.
- Hold a modifiable item in your main hand.
- Type "/buono apply".
- The value has been applied onto your item!

## What's all of this about?
I worked for some years in an Italian Minecraft server called "FearGames", this server was plagued by bad administrative choices, part of these choices wat the intention to keep a lot of features "staff-intensive"[^staffintensive].

A feature of this server was a set of items called "Buoni". From Buoni used to modify the items to Buoni that were used to offer events (so to ask a staffer to organize them), all the way to just asking a member of the staff what was gonna come out in the next update (Buono rivelatore[^Rivelatore]).

For quite some time I tried to push the staff to automate features like the Buoni and others, I never succeeded.

This plugin is to close a chapter of my life, to show that I could (although some doubted me), that I still can, and that I did.
(This is why all the gameplay messages are in Italian, but everything else is in English).

I hope you liked this quick story!

[^buoni]: plural of "Buono", which is the translation of "Voucher" in Italian.
[^used]: Some Buoni can be applied to items to change the item's name or lore, some can't be used at all and are just for show.
[^subcommand]: The first word that you write after calling the command, in other words, the first argument.
[^value]: The value can contain spaces, therefore anything that you write after the "/buono" command will be counted as part of the value.
[^list]: Every time another Buono is added, it is automatically added to the list subcommand.
[^staffintensive]: Requires frequent action from the staff.
[^rivelatore]: "Buono Rivelatore" can be kind of translated to "Rivelation Voucher", by using it you could get a glimpse in the next update of the server, like trying an item not yet out or knowing what will be needed to craft it.
