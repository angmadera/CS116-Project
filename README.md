# Streaming System

A java implemented streaming system that allows multiple users to organize recordings (audio or video) into playlists and play them.

# Description

1) Has a method run that runs displays the menu and runs the system.
2) Has a “database” of UNIQUE (with unique ID) users that allows to add new users and remove existing users based on their ID or name.
3) Has a menu with options and sub-menus and controlled using keyboard. It is possible to add a user, remove a user, and list all users. Each user can add a recording, add a playlist from file, add a playlist from another user, remove reocrdings from playlists, play individual recordings, play an entire playlist once, shuffle entire playlist once, save playlist to a file, and display playlist stats.
4) Each user has their own playlist that is initially empty. They can add an individual recording, add entire set of recordings from a file to the playlist, add an entire set of recordings from another playlist, remove individual recordings based on playlist index or based on its name, play individual recordings based on playlist index or based on its name, play entire playlist in order it was populated, or shuffle entire playlist once.
5) Display playlist statistics.

# Requirements
1) Must use a CSV file
2) Must use ArrayLists
3) Multiple users can share the same name
4) Users cannot change their name
