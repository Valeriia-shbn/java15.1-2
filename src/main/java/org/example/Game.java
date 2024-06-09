package org.example;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void register(Player player){
        if (!players.contains(player)) {
            players.add(player);
        }

    }
    public int round (String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.getStrength()>player2.getStrength()){
            return 1;
        } else if (player2.getStrength()>player1.getStrength()) {
            return 2;
        } else return 0;

    }
}
